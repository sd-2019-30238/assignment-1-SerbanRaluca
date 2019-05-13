package businessLogic;

public class Discount10 extends Discount {

	@Override
	public Double applyDiscount(Double price) {
		Double newPrice=0.0;
		newPrice=price-(10*price)/100;
		return newPrice;		
	}

}
