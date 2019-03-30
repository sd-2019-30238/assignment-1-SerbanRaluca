package businessLogic;

public class DiscountCreator extends AbstractDiscountCreator {

	@Override
	public Discount createDiscount(String type) {
		Discount discount;
		switch (type)
        {
            case "10":
                discount = new Discount10();
                break;
            case "15":
                discount = new Discount15();
                break;
                
            case "20":
                discount = new Discount20();
                break;
                
            default: throw new IllegalArgumentException("No such discount.");
        }
         return discount;  
	}
  
}
