package businessLogic.beans;

import java.sql.SQLException;

import businessLogic.utils.DBUtils;

public class OrderObserver implements Observer {

	@Override
	public void update(String id,String state) {
		try {
			DBUtils.updateOrder(id,state);
			System.out.println("Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
