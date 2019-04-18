package businessLogic;

public class Discount15 extends Discount {

	@Override
	public Double applyDiscount(Double price) {
		Double newPrice=0.0;
		newPrice=price-(15*price)/100;
		return newPrice;
	}

}
