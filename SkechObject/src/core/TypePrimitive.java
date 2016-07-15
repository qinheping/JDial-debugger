package core;

public class TypePrimitive extends SketchType {
	/** Type constant for bit types. */
	public static final int TYPE_BIT = 1;
	/** Type constant for int types. */
	public static final int TYPE_INT8 = 2;
	public static final int TYPE_INT16 = 3;
	public static final int TYPE_INT32 = 4;
	public static final int TYPE_INT64 = 5;
	public static final int TYPE_INT = TYPE_INT32;
	/** Type constant for float types. */
	public static final int TYPE_FLOAT = 6;
	/** Type constant for double types; unused in StreamIt. */
	public static final int TYPE_DOUBLE = 7;
	/** Type constant for void types. */
	public static final int TYPE_VOID = 9;
	/** Type constant for signed integers. */
	public static final int TYPE_SIGINT = 14;

	/** Type constant for signed integers. */
	public static final int TYPE_NULLPTR = 15;

	/**
	 * For internal use only. This type can be cast to anything, and anything
	 * can be cast to it.
	 */
	public static final int TYPE_BOTTOM = 16;

	/** Type constant for string types */
	public static final int TYPE_CHAR = 17;

	/** Type object for bit types. */
	public static final TypePrimitive bittype = new TypePrimitive(TYPE_BIT);
	/** Type object for int types. */
	public static final TypePrimitive inttype = new TypePrimitive(TYPE_INT);
	public static final TypePrimitive int8type = new TypePrimitive(TYPE_INT8);
	public static final TypePrimitive int16type = new TypePrimitive(TYPE_INT16);
	public static final TypePrimitive int32type = new TypePrimitive(TYPE_INT32);
	public static final TypePrimitive int64type = new TypePrimitive(TYPE_INT64);
	public static final TypePrimitive siginttype = new TypePrimitive(TYPE_SIGINT);
	/** Type object for float types. */
	public static final TypePrimitive floattype = new TypePrimitive(TYPE_FLOAT);
	public static final TypePrimitive doubletype = new TypePrimitive(TYPE_DOUBLE);
	/** Type object for void types. */
	public static final TypePrimitive voidtype = new TypePrimitive(TYPE_VOID);
	public static final TypePrimitive nulltype = new TypePrimitive(TYPE_NULLPTR);

	public static final TypePrimitive bottomtype = new TypePrimitive(TYPE_BOTTOM);

	public static final TypePrimitive chartype = new TypePrimitive(TYPE_CHAR);

	private int type;

	/**
	 * Create a new primitive type. It's private, because we don't want other
	 * classes creating their own primitive types. They should use only the ones
	 * we have defined statically above.
	 *
	 * This allows us to compare primitive types with simple pointer equality,
	 * without having to call the equals operator.
	 * 
	 * @param type
	 *            integer type number, one of the TYPE_* constants
	 */
	private TypePrimitive(int type) {
		this.type = type;
	}

	/**
	 * Get the type number for this type.
	 *
	 * @return integer type number, one of the TYPE_* constants
	 */
	public int getType() {
		return type;
	}

	public String toString() {
		switch (type) {
		case TYPE_BIT:
			return "bit";
		case TYPE_INT8:
			return "int8";
		case TYPE_INT16:
			return "int16";
		case TYPE_INT64:
			return "int64";
		case TYPE_INT:
			return "int";
		case TYPE_FLOAT:
			return "float";
		case TYPE_DOUBLE:
			return "double";
		case TYPE_VOID:
			return "void";
		case TYPE_NULLPTR:
			return "null ptr";
		case TYPE_BOTTOM:
			return "bottom";
		case TYPE_SIGINT:
			return "int";
		case TYPE_CHAR:
			return "char";
		default:
			return "<primitive type " + type + ">";
		}
	}

}
