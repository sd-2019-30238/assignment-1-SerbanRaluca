package dataAccess;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	/**
	 * @param field
	 * @return interogare pentru a selecta linii dintr-un tabel dupa valoare unui camp dat
	 */
	protected String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	/**
	 * 
	 * @param field
	 * @return intergare de stergere dupa un anumit camp
	 */
	private String createDeleteQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	/**
	 * 
	 * @param field1-campul ce urmeaza sa fie setat
	 * @param field2-campul dupa care se aleg linile ce vor fi setate
	 * @return interogare pentru update
	 */
	private String createUpdateQuery(String field1,String field2) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(type.getSimpleName());
		sb.append(" SET "+field1+"=?"); 
		sb.append(" WHERE " + field2 + "=?");
		return sb.toString();
	}
	/**
	 * 
	 * @return interogare pentru a selecta toate liniile dintr-un tabel
	 */
	private String createSelectAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		return sb.toString();
	}
	/**
	 * 
	 * @param o
	 * @return interogare pentru inserarea unui obiect in tabel
	 */
	public String createInsertQuery(Object o) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName());
		sb.append(" VALUES(");
		Object value;
		Field[] fields=o.getClass().getDeclaredFields();
		int length=o.getClass().getDeclaredFields().length-1;
		for(int i=0;i<length;i++) {
			fields[i].setAccessible(true);
			try {
				value = fields[i].get(o);
				if(value instanceof Integer) {
					sb.append(value+",");
				}
				else
					sb.append("'"+value+"',");

			}catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		fields[length].setAccessible(true);
		try {
			value = fields[length].get(o);
			if(value instanceof Integer) {
				sb.append(value+")");
			}
			else
				sb.append("'"+value+"')");

		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	/**
	 * metoda care selecteaza tot continutul unui tabel
	 * @return lista de obiecte
	 */
	public List<T> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAll();
		try {
			ConnectionFactory.getInstance();
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	/**
	 * 
	 * @param id
	 * @param idField-numele campului din tabel care stocheaza id-ul
	 * @return elementul din tabel cu id-ul dat
	 */
	public T findById(int id,String idField) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> list=new ArrayList<T>();
		String query = createSelectQuery(idField);
		try {
			ConnectionFactory.getInstance();
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			list=createObjects(resultSet);
			if(list.isEmpty()==false) {
				return list.get(0);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	/**
	 * 
	 * @param resultSet-rezultatul interogarii
	 * @return lista cu obiectele din rezultatul interogarii
	 */
	protected List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * insereaza un obiect intr-un tabel
	 * @param t-obiectul de inserat
	 */
	public void insert(T t) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createInsertQuery(t);
		try {
			ConnectionFactory.getInstance();
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	/**
	 * metoda permite modificarea valorii unui camp din tabel pentru un anumit element
	 * @param id-pentru identificare elementului din tabel ce va fi editat
	 * @param idField-numele campului ce identifica id-ul
	 * @param camp-coloana din tabel pentru care se face modificarea
	 * @param value-noua valoare pentru coloana respectiva
	 */
	public void updateById(int id,String idField,String camp,String value) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createUpdateQuery(camp,idField);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1,value);
			statement.setInt(2,id);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:UpdateById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	/**
	 * metoda care sterge o linie din tabel
	 * @param id-pentru identificarea liniei ce se va sterge din tabel
	 * @param idField-numele campului ce identifica id-ul in tabelul respectiv
	 */
	public void deleteById(int id,String idField) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createDeleteQuery(idField);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:UpdateById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
