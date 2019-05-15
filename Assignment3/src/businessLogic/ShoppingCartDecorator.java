package businessLogic;

import java.util.List;

import businessLogic.beans.Item;

public class ShoppingCartDecorator implements ShoppingCart {

	private ShoppingCart shoppingCart;
	
	public ShoppingCartDecorator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
	
	@Override
	public List<Item> getItems() {
		return shoppingCart.getItems();
	}

	@Override
	public Double getTotal() {
		return shoppingCart.getTotal();
	}

	public ShoppingCart getCart() {
		return shoppingCart;
	}

	public void setCart(ShoppingCart cart) {
		this.shoppingCart = cart;
	}

}
