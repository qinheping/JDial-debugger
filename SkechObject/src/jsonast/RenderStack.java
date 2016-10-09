package jsonast;

import java.util.List;

public class RenderStack extends JsonNode{

	private List<Frame> frams;

	public RenderStack(List<Frame> flist) {
		this.setFrams(flist);
	}

	public List<Frame> getFrams() {
		return frams;
	}

	public void setFrams(List<Frame> frams) {
		this.frams = frams;
	}
	
	public String toString(){
		String result = "";
		for(Frame f: frams){
			result = "Frame: " +f.toString();
		}
		return result;
	}
}
