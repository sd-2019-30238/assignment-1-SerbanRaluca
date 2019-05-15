package businessLogic;

import java.util.List;

import businessLogic.beans.Item;
import cqrs.writeModel.ProductWriteModel;

public class ShoppingCartImpl implements ShoppingCart{
	
	private List<Item> items;
	private ProductWriteModel productModel;
	
	public ShoppingCartImpl(List<Item> items,ProductWriteModel model) {
		this.items=items;
		this.productModel=model;
	}

	@Override
	public List<Item> getItems() {
		return items;
		
	}

	@Override
	public Double getTotal() {
		Double total=0.0;
		for(int i=0;i<items.size();i++) {
			Double price=items.get(i).getProduct().getPrice();
			int quantity=items.get(i).getQuantity();
			total+=price*quantity;
			String code=items.get(i).getProduct().getCode();
			int q=items.get(i).getProduct().getQuantity();
			int newQuantity=q-quantity;
            productModel.updateProduct(code, newQuantity);			
		}
		
		return total;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
