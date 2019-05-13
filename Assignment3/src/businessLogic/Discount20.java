package businessLogic;

public class Discount20 extends Discount {

	@Override
	public Double applyDiscount(Double price) {
		Double newPrice=0.0;
		newPrice=price-(20*price)/100;
		return newPrice;
	}

}
