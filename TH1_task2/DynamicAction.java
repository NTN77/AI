package TH1_task2; 

public class DynamicAction extends Action {
	private String name;

	public DynamicAction(String name) {
		this.name = name;
	}

	@Override
	public boolean isNoOp() {
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
