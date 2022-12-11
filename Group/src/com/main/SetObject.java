public class SetObj {
	Panel p;
	
	public 	SettObj(Panel p) {
		this.p = p;
	}
	
	public void setObject() {
		p.o[2] = new Obj_Coin();
		p.o[2].worldx = 1 * p.tSize;
		p.o[2].worldy = 2 * p.tSize;
	}
}
