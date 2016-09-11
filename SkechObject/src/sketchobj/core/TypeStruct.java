package sketchobj.core;


public class TypeStruct extends Type {
	private String name;
	private final boolean isUnboxed;

	/** Creates a new reference to a structured type. */
	public TypeStruct(String name, boolean isUnboxed) {
		this.name = name;
		this.isUnboxed = isUnboxed;
	}

	// public TypeStructRef addDefaultPkg(String pkg, NameResolver nres) {
	// if (name.indexOf('@') >= 0) {
	// return this;
	// } else {
	// String nname = nres.getStructName(name, pkg);
	// if (nname == null) {
	// nname = name;
	// }
	// return new TypeStructRef(nname, isUnboxed);
	// }
	// }

	/** Returns the name of the referenced structure. */
	public String getName() {
		return name;
	}

	public boolean isStruct() {
		return true;
	}
	//
	// public Expression defaultValue () {
	// if (isUnboxed)
	// return new ExprNew((FEContext) null, this, new
	// ArrayList<ExprNamedParam>(), false);
	// return ExprNullPtr.nullPtr;
	// }

	public int hashCode() {
		return name.hashCode();
	}

	// public String toString()
	// {
	// if (isUnboxed) {
	// return this.getCudaMemType().syntaxNameSpace() + "|" + name + "|";
	// } else {
	// return this.getCudaMemType().syntaxNameSpace() + name;
	// }
	// }

	public String toString() {
		if (isUnboxed) {
			return "|" + name + "|";
		} else {
			return name;
		}
	}

//	@Override
//	public Type withMemType(CudaMemoryType memtyp) {
//		return new TypeStructRef(memtyp, name, isUnboxed);
//	}
//
//	@Override
//	public TypeComparisonResult compare(Type other) {
//		if (other instanceof TypeStructRef) {
//			TypeStructRef that = (TypeStructRef) other;
//			return TypeComparisonResult.knownOrNeq(this.name.equals(that.name) && this.isUnboxed == that.isUnboxed);
//		}
//
//		return TypeComparisonResult.NEQ;
//	}
//
//	public Type leastCommonPromotion(Type that, NameResolver nres) {
//		if (this.promotesTo(that, nres))
//			return that;
//		if (that.promotesTo(this, nres))
//			return this;
//		if ((that instanceof TypeStructRef)) {
//			TypeStructRef tsr = (TypeStructRef) that;
//			String name1 = nres.getStructName(tsr.name);
//			if (name1 == null) {
//				return null;
//			}
//			String name1parent = nres.getStructParentName(name1);
//
//			String name2 = nres.getStructName(name);
//			if (name2 == null) {
//				return null;
//			}
//			String name2parent = nres.getStructParentName(name2);
//
//			if (name1parent != null && name2parent != null) {
//				return (new TypeStructRef(name2parent, isUnboxed))
//						.leastCommonPromotion(new TypeStructRef(name1parent, tsr.isUnboxed), nres);
//			}
//		}
//		return null;
//	}
//
//	public boolean promotesTo(Type that, NameResolver nres) {
//		if (super.promotesTo(that, nres))
//			return true;
//		if ((that instanceof TypeStructRef)) {
//			TypeStructRef tsr = (TypeStructRef) that;
//			String name1 = nres.getStructName(tsr.name);
//			if (name1 == null) {
//				return false;
//			}
//			String name2 = name;
//			while (nres.getStructParentName(name2) != null) {
//				String name3 = nres.getStructName(name2);
//				if (name1.equals(name3)) {
//					return true;
//				}
//				name2 = nres.getStructParentName(name2);
//
//			}
//			String name3 = nres.getStructName(name2);
//			return name1.equals(name3);
//		} else {
//			if (that instanceof TypeArray) {
//				return this.promotesTo(((TypeArray) that).getBase(), nres);
//			}
//		}
//		return false;
//	}
//
//	public Collection<Type> getBaseTypes() {
//		return Collections.singletonList((Type) this);
//	}
//
//	public Map<String, Type> unify(Type t, Set<String> names) {
//		if (names.contains(this.toString())) {
//			return Collections.singletonMap(this.toString(), t);
//		} else {
//			return Collections.EMPTY_MAP;
//		}
//	}

	public String cleanName() {
		return this.toString().replace('@', '_');
	}

	public boolean isUnboxed() {
		return isUnboxed;
	}

}
