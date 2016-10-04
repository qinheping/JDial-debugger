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

}
