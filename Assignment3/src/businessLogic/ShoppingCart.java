package businessLogic;

import java.util.List;

import businessLogic.beans.Item;

public interface ShoppingCart {

	public List<Item> getItems();
	public Double getTotal();
	
}
