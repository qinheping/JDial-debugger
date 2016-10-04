package jsonast;

public class Frame extends JsonNode {

	private String name;
	private VarList encoded_locals;
	private VarList ordered_varnames;
	private boolean is_highlighted;
	private boolean is_zombie;
	private Integer id;

	public Frame(String name, VarList encoded_locals, VarList ordered_varnames, boolean is_highlighted,
			boolean is_zombie, Integer id) {
		this.setName(name);
		this.setEncoded_locals(encoded_locals);
		this.setOrdered_varnames(ordered_varnames);
		this.setIs_highlighted(is_highlighted);
		this.setIs_zombie(is_zombie);
		this.setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VarList getEncoded_locals() {
		return encoded_locals;
	}

	public void setEncoded_locals(VarList encoded_locals) {
		this.encoded_locals = encoded_locals;
	}

	public VarList getOrdered_varnames() {
		return ordered_varnames;
	}

	public void setOrdered_varnames(VarList ordered_varnames) {
		this.ordered_varnames = ordered_varnames;
	}

	public boolean isIs_highlighted() {
		return is_highlighted;
	}

	public void setIs_highlighted(boolean is_highlighted) {
		this.is_highlighted = is_highlighted;
	}

	public boolean isIs_zombie() {
		return is_zombie;
	}

	public void setIs_zombie(boolean is_zombie) {
		this.is_zombie = is_zombie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
