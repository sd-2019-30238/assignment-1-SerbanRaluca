package cqrs.writeModel;

public class RemoveProductCommand implements ICommand {

	private String code;
	private String type;
	
	public RemoveProductCommand(String code) {
		this.code=code;
		this.type="removeProduct";
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
