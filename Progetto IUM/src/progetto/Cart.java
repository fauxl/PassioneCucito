package progetto;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<GadgetBean> gadgets;

	public Cart() {
		gadgets = new ArrayList<GadgetBean>();
	}

	

	public void addGadget(GadgetBean gadget) {
		gadgets.add(gadget);
	}



	public void deleteGadget(GadgetBean gadget) {
		for(GadgetBean gadg : gadgets) {
			if(gadg.getcode().equals(gadget.getcode())) {
				gadgets.remove(gadg);
				break;
			}
		}
	}

	public List<GadgetBean> getgadget() {
		return  gadgets;
	}


}