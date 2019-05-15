package businessLogic;

public class DiscountShoppingCart extends ShoppingCartDecorator{

	/*adds a discount if the price of the products is more than 1000*/
	public DiscountShoppingCart(ShoppingCart shoppingCart) {
		super(shoppingCart);	
	}
	
	public Double getTotal() {
		Double total=super.getTotal();
		if(total>1000) {
			total=(90*total)/100;
		}
		return total;
	}

}
