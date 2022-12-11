public class SetObj {
	Panel p;
	
	public 	SettObj(Panel p) {
		this.p = p;
	}
	
	public void setObject() {
		p.o[0] = new Obj_Key();
		p.o[0].worldx = 20 * p.tSize;
		p.o[0].worldy = 12 * p.tSize;
		
		p.o[1] = new Obj_Door2();
		p.o[1].worldx = 1* p.tSize;
		p.o[1].worldy = 2 * p.tSize;
		
		p.o[2] = new Obj_Coin();
		p.o[2].worldx = 1 * p.tSize;
		p.o[2].worldy = 2 * p.tSize;
	}
}
