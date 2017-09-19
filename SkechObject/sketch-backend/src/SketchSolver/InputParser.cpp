/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison implementation for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.0.4"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 1

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* Copy the first part of user declarations.  */
#line 1 "InputParser/InputParser.yy" /* yacc.c:339  */


using namespace std;

BooleanDAGCreator* currentBD;
stack<string> namestack;
vartype Gvartype;
string tupleName;

bool isModel;




#ifdef CONST
#undef CONST
#endif


#define YY_DECL int yylex (YYSTYPE* yylval, yyscan_t yyscanner)
extern int yylex (YYSTYPE* yylval, yyscan_t yyscanner);


#line 90 "InputParser.cpp" /* yacc.c:339  */

# ifndef YY_NULLPTR
#  if defined __cplusplus && 201103L <= __cplusplus
#   define YY_NULLPTR nullptr
#  else
#   define YY_NULLPTR 0
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 0
#endif

/* In a future release of Bison, this section will be replaced
   by #include "InputParser.hpp".  */
#ifndef YY_YY_INPUTPARSER_HPP_INCLUDED
# define YY_YY_INPUTPARSER_HPP_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 1
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    T_dbl = 258,
    T_int = 259,
    T_bool = 260,
    T_ident = 261,
    T_OutIdent = 262,
    T_NativeCode = 263,
    T_string = 264,
    T_true = 265,
    T_false = 266,
    T_vartype = 267,
    T_rightAC = 268,
    T_leftAC = 269,
    T_rightTC = 270,
    T_leftTC = 271,
    T_leftAR = 272,
    T_rightAR = 273,
    T_arrow = 274,
    T_twoS = 275,
    T_ppls = 276,
    T_mmns = 277,
    T_eq = 278,
    T_neq = 279,
    T_and = 280,
    T_or = 281,
    T_For = 282,
    T_ge = 283,
    T_le = 284,
    T_Native = 285,
    T_NativeMethod = 286,
    T_Sketches = 287,
    T_new = 288,
    T_Typedef = 289,
    T_def = 290,
    T_mdldef = 291,
    T_Min = 292,
    T_sp = 293,
    T_assert = 294,
    T_assume = 295,
    T_hassert = 296,
    T_equals = 297,
    T_replace = 298,
    T_eof = 299
  };
#endif
/* Tokens.  */
#define T_dbl 258
#define T_int 259
#define T_bool 260
#define T_ident 261
#define T_OutIdent 262
#define T_NativeCode 263
#define T_string 264
#define T_true 265
#define T_false 266
#define T_vartype 267
#define T_rightAC 268
#define T_leftAC 269
#define T_rightTC 270
#define T_leftTC 271
#define T_leftAR 272
#define T_rightAR 273
#define T_arrow 274
#define T_twoS 275
#define T_ppls 276
#define T_mmns 277
#define T_eq 278
#define T_neq 279
#define T_and 280
#define T_or 281
#define T_For 282
#define T_ge 283
#define T_le 284
#define T_Native 285
#define T_NativeMethod 286
#define T_Sketches 287
#define T_new 288
#define T_Typedef 289
#define T_def 290
#define T_mdldef 291
#define T_Min 292
#define T_sp 293
#define T_assert 294
#define T_assume 295
#define T_hassert 296
#define T_equals 297
#define T_replace 298
#define T_eof 299

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 30 "InputParser/InputParser.yy" /* yacc.c:355  */

	int intConst;
	bool boolConst;
	std::string* strConst;
	double doubleConst;		
	std::list<int>* iList;
	list<bool_node*>* nList;
	list<string*>* sList;
	vartype variableType;
	BooleanDAG* bdag;
	bool_node* bnode;
  OutType* otype;
  vector<OutType*>* tVector;
  vector<string>* sVector;

#line 234 "InputParser.cpp" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif



int yyparse (yyscan_t yyscanner);

#endif /* !YY_YY_INPUTPARSER_HPP_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 250 "InputParser.cpp" /* yacc.c:358  */

#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short int yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short int yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned int
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE
# if (defined __GNUC__                                               \
      && (2 < __GNUC__ || (__GNUC__ == 2 && 96 <= __GNUC_MINOR__)))  \
     || defined __SUNPRO_C && 0x5110 <= __SUNPRO_C
#  define YY_ATTRIBUTE(Spec) __attribute__(Spec)
# else
#  define YY_ATTRIBUTE(Spec) /* empty */
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# define YY_ATTRIBUTE_PURE   YY_ATTRIBUTE ((__pure__))
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# define YY_ATTRIBUTE_UNUSED YY_ATTRIBUTE ((__unused__))
#endif

#if !defined _Noreturn \
     && (!defined __STDC_VERSION__ || __STDC_VERSION__ < 201112)
# if defined _MSC_VER && 1200 <= _MSC_VER
#  define _Noreturn __declspec (noreturn)
# else
#  define _Noreturn YY_ATTRIBUTE ((__noreturn__))
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN \
    _Pragma ("GCC diagnostic push") \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")\
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif


#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYSIZE_T yynewbytes;                                            \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / sizeof (*yyptr);                          \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  5
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   513

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  69
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  36
/* YYNRULES -- Number of rules.  */
#define YYNRULES  134
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  350

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   299

#define YYTRANSLATE(YYX)                                                \
  ((unsigned int) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, without out-of-bounds checking.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    53,     2,     2,    63,    48,    64,     2,
      57,    58,    46,    45,    56,    68,    67,    47,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,    52,    61,
      49,    62,    50,    51,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    54,     2,    55,    66,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    59,    65,    60,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint16 yyrline[] =
{
       0,   127,   127,   130,   131,   132,   133,   136,   152,   152,
     168,   169,   175,   188,   195,   202,   212,   218,   232,   236,
     245,   248,   248,   249,   249,   250,   251,   254,   255,   256,
     258,   258,   261,   260,   277,   285,   290,   293,   297,   298,
     302,   314,   319,   323,   324,   326,   327,   329,   334,   343,
     343,   355,   365,   368,   372,   378,   379,   382,   383,   387,
     415,   420,   427,   438,   447,   460,   477,   478,   480,   481,
     484,   487,   490,   493,   496,   500,   503,   506,   514,   517,
     524,   530,   544,   558,   573,   586,   590,   594,   598,   601,
     605,   609,   612,   616,   620,   631,   632,   643,   647,   652,
     655,   659,   694,   742,   745,   749,   752,   757,   761,   769,
     774,   778,   782,   786,   790,   798,   803,   808,   817,   824,
     825,   830,   831,   832,   834,   835,   836,   837,   839,   843,
     844,   847,   848,   849,   851
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "T_dbl", "T_int", "T_bool", "T_ident",
  "T_OutIdent", "T_NativeCode", "T_string", "T_true", "T_false",
  "T_vartype", "T_rightAC", "T_leftAC", "T_rightTC", "T_leftTC",
  "T_leftAR", "T_rightAR", "T_arrow", "T_twoS", "T_ppls", "T_mmns", "T_eq",
  "T_neq", "T_and", "T_or", "T_For", "T_ge", "T_le", "T_Native",
  "T_NativeMethod", "T_Sketches", "T_new", "T_Typedef", "T_def",
  "T_mdldef", "T_Min", "T_sp", "T_assert", "T_assume", "T_hassert",
  "T_equals", "T_replace", "T_eof", "'+'", "'*'", "'/'", "'%'", "'<'",
  "'>'", "'?'", "':'", "'!'", "'['", "']'", "','", "'('", "')'", "'{'",
  "'}'", "';'", "'='", "'$'", "'&'", "'|'", "'^'", "'.'", "'-'", "$accept",
  "Program", "MethodList", "InList", "$@1", "OutList", "ParamDecl", "$@2",
  "$@3", "ParamList", "Mhelp", "Method", "$@4", "TupleType",
  "TupleTypeList", "TypeLine", "TypeList", "Typedef", "Replacement",
  "AssertionExpr", "HLAssertion", "$@5", "TokenList", "WorkBody",
  "WorkStatement", "OptionalMsg", "Expression", "varList", "IdentList",
  "Term", "ParentsList", "ConstantExpr", "ConstantTerm", "NegConstant",
  "Constant", "Ident", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,    43,    42,    47,    37,    60,
      62,    63,    58,    33,    91,    93,    44,    40,    41,   123,
     125,    59,    61,    36,    38,   124,    94,    46,    45
};
# endif

#define YYPACT_NINF -143

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-143)))

#define YYTABLE_NINF -131

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
     -28,   -13,   100,   239,  -143,  -143,    76,  -143,  -143,  -143,
     138,   141,   154,   239,   239,   239,    25,   105,   193,   144,
    -143,  -143,  -143,  -143,  -143,   136,  -143,  -143,   105,   105,
     146,   179,   175,   235,   198,   247,  -143,  -143,   189,   246,
    -143,   260,    17,  -143,  -143,  -143,    45,  -143,  -143,  -143,
     301,    -5,     7,   156,   256,   255,   275,   282,  -143,  -143,
      84,   283,   292,    97,  -143,   196,     8,    26,    17,   285,
     300,   115,  -143,     6,     6,     1,     1,   247,   119,   215,
    -143,  -143,     1,   134,  -143,   213,  -143,   233,  -143,  -143,
       1,     1,   307,   309,   318,   238,   303,  -143,     1,  -143,
       1,     1,     1,     1,   288,  -143,     1,   290,     1,   302,
     226,   333,   365,  -143,   311,  -143,   367,  -143,   215,   369,
     215,   -14,   335,  -143,   378,   369,   396,   383,   397,   383,
     330,   331,   172,   172,   172,  -143,  -143,   384,  -143,  -143,
    -143,  -143,  -143,   393,  -143,  -143,  -143,   398,   383,  -143,
     402,  -143,   172,   172,  -143,   355,    78,    78,   362,   247,
     417,    78,   425,   172,    78,    78,   161,   390,   380,   389,
    -143,   167,   195,   384,   412,   369,  -143,  -143,  -143,   -42,
      41,    32,   391,    78,   431,    78,  -143,   426,   417,   385,
    -143,    14,  -143,   392,    55,   386,  -143,   399,   172,   441,
    -143,   172,    78,    78,    78,    78,    78,    78,    78,    78,
      78,    78,    78,    78,    78,    78,    78,   405,    78,   328,
     451,   400,   453,  -143,  -143,    78,  -143,  -143,  -143,   408,
     460,   172,    33,  -143,  -143,  -143,   184,  -143,   418,  -143,
     419,   253,   454,  -143,   413,   187,   410,   -16,  -143,  -143,
    -143,  -143,  -143,  -143,  -143,  -143,  -143,  -143,  -143,  -143,
    -143,  -143,  -143,     6,  -143,   349,    36,  -143,  -143,   411,
     414,   416,   420,     2,  -143,   127,    -3,  -143,  -143,   424,
     428,  -143,    78,   172,   172,  -143,  -143,   421,   116,    90,
    -143,  -143,   427,    78,   422,   172,   430,  -143,   433,  -143,
    -143,  -143,   468,   165,  -143,  -143,   172,   172,   429,    78,
     176,  -143,   417,  -143,  -143,   229,   249,   432,   434,   435,
     204,   436,   423,   172,   437,  -143,  -143,   259,  -143,   172,
     101,   172,   438,  -143,    43,   439,   140,  -143,  -143,   478,
     442,   443,   480,   247,   444,   440,   247,  -143,   446,  -143
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
      45,     0,     0,     3,    43,     1,     0,    31,    30,    49,
       0,     0,     0,     3,     3,     3,     0,    52,     0,     0,
       2,    32,     4,     6,     5,     0,    46,    44,    52,    52,
       0,     0,     0,     0,     0,    38,    53,    54,     0,     0,
      50,     0,    27,   131,   132,   133,     0,    38,    51,    48,
       0,     0,     0,     0,    28,     0,    37,    34,    41,    39,
       0,     0,    13,     0,    12,     0,     0,     0,    27,     0,
       0,     0,    42,     0,     0,     0,     0,     0,     0,   121,
     124,   129,     0,     0,    16,     0,    15,     0,    29,    55,
       0,     0,     0,     0,     0,     0,     0,   130,     0,    23,
       0,     0,     0,     0,     0,    21,     0,     0,     0,     0,
       0,     0,     0,    40,     0,    14,     0,   125,   122,     0,
     123,   126,   127,   128,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    33,    57,     0,    56,    36,
      35,    47,    18,     7,    24,    17,    22,     0,    10,    26,
       0,    25,     0,     0,   100,   134,    95,    95,     0,     0,
       0,     0,     0,     0,    95,     0,     0,    68,     0,    99,
     106,    67,     0,    97,     0,     0,    20,    11,    19,     0,
       0,     0,   134,     0,     0,    95,    99,     0,     0,     0,
     134,     0,   104,     0,     0,     0,   103,    99,     0,     0,
      61,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,    63,    98,    95,     9,    58,    60,     0,
       0,     0,     0,    82,    96,    84,     0,   119,     0,   107,
       0,     0,     0,   105,     0,     0,     0,     0,    75,    74,
      70,    72,    92,    93,    85,    88,    86,    87,    91,    90,
      69,    71,    73,     0,    89,     0,     0,    66,    65,     0,
       0,     0,     0,     0,   113,     0,     0,   110,   112,     0,
       0,   108,    95,     0,     0,    62,    76,     0,   134,     0,
      78,    64,     0,    95,     0,     0,     0,   114,     0,   120,
     111,   109,     0,     0,    94,    77,     0,     0,     0,    95,
       0,   115,     0,    83,    81,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    79,   116,     0,    80,     0,
       0,     0,     0,   117,     0,     0,     0,   118,    59,     0,
       0,     0,     0,     0,     0,     0,     0,   102,     0,   101
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
    -143,  -143,   415,  -121,  -143,   -53,  -143,  -143,  -143,   445,
    -143,  -143,  -143,  -143,   450,  -143,  -143,  -143,  -143,  -143,
    -143,  -143,   263,  -143,  -143,  -143,  -126,  -142,   325,   112,
    -143,   289,   324,    47,   -35,  -140
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int16 yydefgoto[] =
{
      -1,     2,    11,   144,   175,   149,    54,   125,   119,    55,
      12,    13,    34,    59,    46,    27,    16,     3,    14,    32,
      15,    18,    30,   110,   138,   221,   166,   184,   174,   167,
     276,    78,    79,   168,   186,   170
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_int16 yytable[] =
{
      47,    62,   286,   190,   146,    43,     1,   171,   172,   198,
      43,    44,    45,    64,    84,   187,    44,    45,    43,   227,
     191,   295,   195,    51,    44,    45,   179,   180,    81,    52,
      81,    25,    86,   102,   103,   198,    92,   194,    81,    81,
      81,    81,    97,   234,   229,   229,     4,    81,   236,    63,
      81,    56,    81,   198,   226,    81,    81,    57,    76,   238,
     298,    65,    85,    81,   239,    81,    81,    81,    81,    77,
      53,    81,   245,    81,    77,   247,   151,   240,   230,   230,
      87,   154,    43,   270,   182,    26,   231,   198,    44,    45,
      56,   290,   198,   266,   198,   177,    57,   169,   169,   169,
       5,    43,   228,    58,   338,   273,   198,    44,    45,   306,
      80,    28,    80,   243,    29,   158,   159,   169,   169,    43,
      93,    94,    80,    80,   189,    44,    45,   160,   169,    80,
     197,   161,    80,    17,    80,   163,   299,    80,    80,   289,
     302,   198,    72,    75,    19,    80,   183,    80,    80,    80,
      80,   308,   198,    80,    76,    80,   241,   303,   304,   335,
      21,    91,    66,   169,    98,    77,   169,   318,    67,   310,
     181,   242,   320,   296,    99,   154,    43,   297,   155,    98,
     315,   316,    44,    45,   169,    20,   156,   100,    43,   105,
      33,   198,   157,    35,    44,    45,   169,   330,   340,    31,
      43,   275,   100,   334,    38,   336,    44,    45,    43,   158,
     159,    39,   198,   199,    44,    45,   198,    43,   198,   220,
     314,   160,   200,    44,    45,   161,   162,   198,    81,   163,
     169,   319,   130,   131,   274,   164,    40,    43,   198,   284,
     165,    41,    82,    44,    45,     6,   198,   222,   169,   169,
      48,    43,    49,    76,   326,    42,   223,    44,    45,   106,
     169,   101,   102,   103,    77,   132,   133,   134,   185,   185,
      76,   169,   169,   192,     7,     8,   185,   196,     9,   108,
     198,    77,    10,    98,   321,   327,   135,   136,   169,   137,
      76,    36,    37,   116,   169,   196,   169,   185,   279,   280,
     198,    77,    50,   281,   322,   332,   100,    61,   345,   333,
     287,   348,    68,    69,   248,   249,   250,   251,   252,   253,
     254,   255,   256,   257,   258,   259,   260,   261,   262,    70,
     264,   154,    43,    98,   155,    98,    71,   185,    44,    45,
      73,    74,   156,   124,    89,   127,    90,    98,   157,   101,
     102,   103,   154,    43,    83,   288,   100,   129,   100,    44,
      45,   117,   113,   156,    95,   158,   159,   114,   115,   157,
     100,   104,   141,   142,   107,   143,   109,   160,    98,   111,
     112,   161,   265,   103,   145,   163,   158,   159,   139,   148,
     173,   164,   152,   153,   185,   126,   165,   128,   160,    -8,
      96,   100,   161,   162,   176,   185,   163,   201,   178,   181,
      98,   188,   164,   202,   203,   204,   205,   165,   206,   207,
     140,   185,   118,   190,   120,   121,   122,   123,    22,    23,
      24,   193,   225,   100,   219,   208,   209,   210,   211,   212,
     213,    98,    98,  -129,   233,   232,   235,   242,   237,   244,
     246,   147,   150,  -130,   214,   215,   216,   217,   218,   263,
     267,   268,   269,   271,   100,   100,   272,   283,   277,   278,
     282,   285,   291,   293,   300,   294,   305,   292,   301,   309,
     311,   307,   312,   313,   341,   329,   344,   317,   337,   323,
     325,   328,   324,   339,   331,   347,   342,    60,   224,   343,
     346,   349,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,    88
};

static const yytype_int16 yycheck[] =
{
      35,     6,    18,     6,   125,     4,    34,   133,   134,    51,
       4,    10,    11,     6,     6,   157,    10,    11,     4,    61,
     160,    19,   164,     6,    10,    11,   152,   153,    63,    12,
      65,     6,     6,    47,    48,    51,    71,   163,    73,    74,
      75,    76,    77,   185,    12,    12,    59,    82,   188,    54,
      85,     6,    87,    51,   175,    90,    91,    12,    57,    45,
      63,    54,    54,    98,    50,   100,   101,   102,   103,    68,
      53,   106,   198,   108,    68,   201,   129,    63,    46,    46,
      54,     3,     4,   225,     6,    60,    54,    51,    10,    11,
       6,    55,    51,   219,    51,   148,    12,   132,   133,   134,
       0,     4,    61,    58,    61,   231,    51,    10,    11,    19,
      63,     6,    65,    58,     9,    37,    38,   152,   153,     4,
      73,    74,    75,    76,   159,    10,    11,    49,   163,    82,
     165,    53,    85,    57,    87,    57,   276,    90,    91,   265,
     282,    51,    58,    46,     6,    98,    68,   100,   101,   102,
     103,   293,    51,   106,    57,   108,   191,   283,   284,    58,
       6,    46,     6,   198,    45,    68,   201,   309,    12,   295,
      54,    55,   312,    46,    55,     3,     4,    50,     6,    45,
     306,   307,    10,    11,   219,    44,    14,    68,     4,    55,
      46,    51,    20,    57,    10,    11,   231,   323,    58,     6,
       4,   236,    68,   329,    58,   331,    10,    11,     4,    37,
      38,    32,    51,    52,    10,    11,    51,     4,    51,    52,
      55,    49,    61,    10,    11,    53,    54,    51,   263,    57,
     265,    55,     6,     7,    50,    63,    61,     4,    51,    52,
      68,     6,    46,    10,    11,     6,    51,    52,   283,   284,
      61,     4,     6,    57,    50,    57,    61,    10,    11,    46,
     295,    46,    47,    48,    68,    39,    40,    41,   156,   157,
      57,   306,   307,   161,    35,    36,   164,   165,    39,    46,
      51,    68,    43,    45,    55,   320,    60,    61,   323,    63,
      57,    28,    29,    55,   329,   183,   331,   185,    45,    46,
      51,    68,    42,    50,    55,    46,    68,     6,   343,    50,
     263,   346,    56,    58,   202,   203,   204,   205,   206,   207,
     208,   209,   210,   211,   212,   213,   214,   215,   216,    54,
     218,     3,     4,    45,     6,    45,    54,   225,    10,    11,
      57,    49,    14,    55,    59,    55,    46,    45,    20,    46,
      47,    48,     3,     4,    65,     6,    68,    55,    68,    10,
      11,    58,    55,    14,    75,    37,    38,    58,    50,    20,
      68,    82,    61,     6,    85,     6,    87,    49,    45,    90,
      91,    53,    54,    48,     6,    57,    37,    38,    55,     6,
       6,    63,    62,    62,   282,   106,    68,   108,    49,     6,
      76,    68,    53,    54,     6,   293,    57,    17,     6,    54,
      45,    49,    63,    23,    24,    25,    26,    68,    28,    29,
      55,   309,    98,     6,   100,   101,   102,   103,    13,    14,
      15,     6,    20,    68,    54,    45,    46,    47,    48,    49,
      50,    45,    45,    54,    13,    54,    20,    55,    63,    63,
       9,    55,    55,    54,    64,    65,    66,    67,    68,    54,
       9,    61,     9,    55,    68,    68,     6,    54,    50,    50,
      16,    61,    61,    57,    50,    55,    55,    63,    50,    57,
      50,    54,    49,    15,     6,    62,     6,    58,    50,    57,
      55,    55,    58,    54,    57,    55,    54,    47,   173,    56,
      56,    55,    -1,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    68
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,    34,    70,    86,    59,     0,     6,    35,    36,    39,
      43,    71,    79,    80,    87,    89,    85,    57,    90,     6,
      44,     6,    71,    71,    71,     6,    60,    84,     6,     9,
      91,     6,    88,    46,    81,    57,    91,    91,    58,    32,
      61,     6,    57,     4,    10,    11,    83,   103,    61,     6,
      42,     6,    12,    53,    75,    78,     6,    12,    58,    82,
      83,     6,     6,    54,     6,    54,     6,    12,    56,    58,
      54,    54,    58,    57,    49,    46,    57,    68,   100,   101,
     102,   103,    46,   100,     6,    54,     6,    54,    78,    59,
      46,    46,   103,   102,   102,   100,   101,   103,    45,    55,
      68,    46,    47,    48,   100,    55,    46,   100,    46,   100,
      92,   100,   100,    55,    58,    50,    55,    58,   101,    77,
     101,   101,   101,   101,    55,    76,   100,    55,   100,    55,
       6,     7,    39,    40,    41,    60,    61,    63,    93,    55,
      55,    61,     6,     6,    72,     6,    72,    55,     6,    74,
      55,    74,    62,    62,     3,     6,    14,    20,    37,    38,
      49,    53,    54,    57,    63,    68,    95,    98,   102,   103,
     104,    95,    95,     6,    97,    73,     6,    74,     6,    95,
      95,    54,     6,    68,    96,    98,   103,    96,    49,   103,
       6,   104,    98,     6,    95,    96,    98,   103,    51,    52,
      61,    17,    23,    24,    25,    26,    28,    29,    45,    46,
      47,    48,    49,    50,    64,    65,    66,    67,    68,    54,
      52,    94,    52,    61,    97,    20,    72,    61,    61,    12,
      46,    54,    54,    13,    96,    20,   104,    63,    45,    50,
      63,   103,    55,    58,    63,    95,     9,    95,    98,    98,
      98,    98,    98,    98,    98,    98,    98,    98,    98,    98,
      98,    98,    98,    54,    98,    54,    95,     9,    61,     9,
      96,    55,     6,    95,    50,   103,    99,    50,    50,    45,
      46,    50,    16,    54,    52,    61,    18,   102,     6,    95,
      55,    61,    63,    57,    55,    19,    46,    50,    63,   104,
      50,    50,    96,    95,    95,    55,    19,    54,    96,    57,
      95,    50,    49,    15,    55,    95,    95,    58,    96,    55,
     104,    55,    55,    57,    58,    55,    50,   103,    55,    62,
      95,    57,    46,    50,    95,    58,    95,    50,    61,    54,
      58,     6,    54,    56,     6,   103,    56,    55,   103,    55
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    69,    70,    71,    71,    71,    71,    72,    73,    72,
      74,    74,    75,    75,    75,    75,    75,    75,    75,    75,
      75,    76,    75,    77,    75,    75,    75,    78,    78,    78,
      79,    79,    81,    80,    82,    82,    82,    82,    83,    83,
      83,    84,    84,    85,    85,    86,    86,    87,    88,    90,
      89,    89,    91,    91,    91,    92,    92,    93,    93,    93,
      93,    93,    93,    93,    93,    93,    94,    94,    95,    95,
      95,    95,    95,    95,    95,    95,    95,    95,    95,    95,
      95,    95,    95,    95,    95,    95,    95,    95,    95,    95,
      95,    95,    95,    95,    95,    96,    96,    97,    97,    98,
      98,    98,    98,    98,    98,    98,    98,    98,    98,    98,
      98,    98,    98,    98,    98,    98,    98,    98,    98,    99,
      99,   100,   100,   100,   101,   101,   101,   101,   101,   102,
     102,   103,   103,   103,   104
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     3,     0,     2,     2,     2,     1,     0,     3,
       1,     2,     2,     2,     5,     3,     3,     6,     6,     7,
       7,     0,     6,     0,     6,     6,     6,     0,     1,     3,
       1,     1,     0,     9,     1,     5,     5,     1,     0,     2,
       5,     4,     5,     0,     2,     0,     4,    10,     3,     0,
       4,     5,     0,     2,     2,     0,     2,     1,     4,    11,
       4,     3,     5,     3,     5,     4,     2,     0,     1,     3,
       3,     3,     3,     3,     3,     3,     4,     5,     4,     8,
       8,     6,     3,     6,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     5,     0,     2,     1,     2,     1,
       1,    16,    15,     2,     2,     3,     1,     3,     4,     5,
       4,     5,     4,     4,     5,     6,     8,     9,    10,     0,
       2,     1,     3,     3,     1,     3,     3,     3,     3,     1,
       2,     1,     1,     1,     1
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (yyscanner, YY_("syntax error: cannot back up")); \
      YYERROR;                                                  \
    }                                                           \
while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value, yyscanner); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*----------------------------------------.
| Print this symbol's value on YYOUTPUT.  |
`----------------------------------------*/

static void
yy_symbol_value_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep, yyscan_t yyscanner)
{
  FILE *yyo = yyoutput;
  YYUSE (yyo);
  YYUSE (yyscanner);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyoutput, yytoknum[yytype], *yyvaluep);
# endif
  YYUSE (yytype);
}


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

static void
yy_symbol_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep, yyscan_t yyscanner)
{
  YYFPRINTF (yyoutput, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyoutput, yytype, yyvaluep, yyscanner);
  YYFPRINTF (yyoutput, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yytype_int16 *yyssp, YYSTYPE *yyvsp, int yyrule, yyscan_t yyscanner)
{
  unsigned long int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[yyssp[yyi + 1 - yynrhs]],
                       &(yyvsp[(yyi + 1) - (yynrhs)])
                                              , yyscanner);
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule, yyscanner); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
static YYSIZE_T
yystrlen (const char *yystr)
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            /* Fall through.  */
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return yystpcpy (yyres, yystr) - yyres;
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep, yyscan_t yyscanner)
{
  YYUSE (yyvaluep);
  YYUSE (yyscanner);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/*----------.
| yyparse.  |
`----------*/

int
yyparse (yyscan_t yyscanner)
{
/* The lookahead symbol.  */
int yychar;


/* The semantic value of the lookahead symbol.  */
/* Default value used for initialization, for pacifying older GCCs
   or non-GCC compilers.  */
YY_INITIAL_VALUE (static YYSTYPE yyval_default;)
YYSTYPE yylval YY_INITIAL_VALUE (= yyval_default);

    /* Number of syntax errors so far.  */
    int yynerrs;

    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = yyssp - yyss + 1;

#ifdef yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        YYSTYPE *yyvs1 = yyvs;
        yytype_int16 *yyss1 = yyss;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * sizeof (*yyssp),
                    &yyvs1, yysize * sizeof (*yyvsp),
                    &yystacksize);

        yyss = yyss1;
        yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yytype_int16 *yyss1 = yyss;
        union yyalloc *yyptr =
          (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
                  (unsigned long int) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex (&yylval, yyscanner);
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 2:
#line 127 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { solution.start(); int tmp= envt->doallpairs() ; solution.stop(); return tmp; }
#line 1595 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 3:
#line 130 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {}
#line 1601 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 4:
#line 131 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {}
#line 1607 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 5:
#line 132 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {}
#line 1613 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 6:
#line 133 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {}
#line 1619 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 7:
#line 136 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 
    if(Gvartype == TUPLE){
        currentBD->create_inputs( -1, OutType::getTuple(tupleName), *(yyvsp[0].strConst));
    }
    else
    if( Gvartype == INT){
		currentBD->create_inputs( 2 /*NINPUTS*/, OutType::INT , *(yyvsp[0].strConst)); 
	}else{
		if(Gvartype==FLOAT){
			currentBD->create_inputs(-1, OutType::FLOAT, *(yyvsp[0].strConst)); 
		}else{
			currentBD->create_inputs(-1, OutType::BOOL, *(yyvsp[0].strConst)); 
		}
	}	

}
#line 1640 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 8:
#line 152 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	if(Gvartype == TUPLE){
        currentBD->create_inputs( -1, OutType::getTuple(tupleName), *(yyvsp[0].strConst));
    }
    else
    if( Gvartype == INT){
		currentBD->create_inputs( 2 /*NINPUTS*/, OutType::INT , *(yyvsp[0].strConst)); 
	}else{
		if(Gvartype==FLOAT){
			currentBD->create_inputs(-1, OutType::FLOAT, *(yyvsp[0].strConst)); 
		}else{
			currentBD->create_inputs(-1, OutType::BOOL, *(yyvsp[0].strConst)); 
		}
	}	
}
#line 1660 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 10:
#line 168 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 	 currentBD->create_outputs(-1, *(yyvsp[0].strConst)); }
#line 1666 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 11:
#line 169 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	
	currentBD->create_outputs(-1, *(yyvsp[-1].strConst));
}
#line 1675 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 12:
#line 175 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  
	if( (yyvsp[-1].variableType) == INT){

		currentBD->create_inputs( 2 /*NINPUTS*/, OutType::INT , *(yyvsp[0].strConst)); 
	}else{
		if((yyvsp[-1].variableType) == FLOAT){
			currentBD->create_inputs(-1, OutType::FLOAT, *(yyvsp[0].strConst)); 
		}else{
			currentBD->create_inputs(-1, OutType::BOOL, *(yyvsp[0].strConst)); 
		}
	}	
	delete (yyvsp[0].strConst);
}
#line 1693 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 13:
#line 188 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

    currentBD->create_inputs( -1 , OutType::getTuple(*(yyvsp[-1].strConst)), *(yyvsp[0].strConst));
       

    delete (yyvsp[0].strConst);
}
#line 1705 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 14:
#line 195 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

    currentBD->create_inputs( -1 , OutType::getTuple(*(yyvsp[-4].strConst)) , *(yyvsp[-3].strConst), -1, (yyvsp[-1].intConst));
       

    delete (yyvsp[-3].strConst);
}
#line 1717 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 15:
#line 202 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
 	 if( (yyvsp[-1].variableType) == INT){

		 currentBD->create_outputs(2 /* NINPUTS */, *(yyvsp[0].strConst));
 	 }else{

	 	 currentBD->create_outputs(-1, *(yyvsp[0].strConst)); 
 	 }
	 delete (yyvsp[0].strConst);
 }
#line 1732 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 16:
#line 212 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

    currentBD->create_outputs(-1, *(yyvsp[0].strConst));
    delete (yyvsp[0].strConst);
 }
#line 1742 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 17:
#line 218 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  
	if( (yyvsp[-5].variableType) == INT){

		currentBD->create_inputs( 2 /*NINPUTS*/, OutType::INT_ARR , *(yyvsp[0].strConst), (yyvsp[-2].intConst)); 
	}else{
		if((yyvsp[-5].variableType) == FLOAT){
			currentBD->create_inputs(-1, OutType::FLOAT_ARR, *(yyvsp[0].strConst), (yyvsp[-2].intConst)); 
		}else{
			currentBD->create_inputs(-1, OutType::BOOL_ARR, *(yyvsp[0].strConst), (yyvsp[-2].intConst)); 
		}
	}	
	delete (yyvsp[0].strConst);
}
#line 1760 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 18:
#line 232 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    currentBD->create_inputs(-1, OutType::getTuple(*(yyvsp[-5].strConst)), *(yyvsp[0].strConst), (yyvsp[-2].intConst));
}
#line 1768 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 19:
#line 236 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
 	 if( (yyvsp[-5].variableType) == INT){
		 currentBD->create_outputs(2 /* NINPUTS */, *(yyvsp[0].strConst));
 	 }else{

	 	 currentBD->create_outputs(-1, *(yyvsp[0].strConst)); 
 	 }
	 delete (yyvsp[0].strConst);
 }
#line 1782 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 20:
#line 245 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  currentBD->create_outputs(-1,*(yyvsp[0].strConst));
 }
#line 1790 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 21:
#line 248 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {Gvartype = (yyvsp[-3].variableType); }
#line 1796 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 23:
#line 249 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {Gvartype = TUPLE; tupleName = *(yyvsp[-3].strConst);}
#line 1802 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 30:
#line 258 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {isModel=true; }
#line 1808 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 31:
#line 258 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {isModel=false; }
#line 1814 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 32:
#line 261 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {		modelBuilding.restart ();
		if(currentBD!= NULL){
			delete currentBD;
		}

		currentBD = envt->newFunction(*(yyvsp[0].strConst), isModel);

		delete (yyvsp[0].strConst);

}
#line 1829 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 33:
#line 271 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 
	currentBD->finalize();
	modelBuilding.stop();
}
#line 1838 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 34:
#line 277 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    if( (yyvsp[0].variableType) == INT){ (yyval.otype) = OutType::INT;}
    if( (yyvsp[0].variableType) == BIT){ (yyval.otype) = OutType::BOOL;}
	if( (yyvsp[0].variableType) == FLOAT){ (yyval.otype) = OutType::FLOAT;}
    if( (yyvsp[0].variableType) == INT_ARR){ (yyval.otype) = OutType::INT_ARR;}
    if( (yyvsp[0].variableType) == BIT_ARR){ (yyval.otype) = OutType::BOOL_ARR;}
    if( (yyvsp[0].variableType) == FLOAT_ARR){ (yyval.otype) = OutType::FLOAT_ARR;}
}
#line 1851 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 35:
#line 285 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    if ((yyvsp[-4].variableType) == INT) {(yyval.otype) = OutType::INT_ARR;}
    if( (yyvsp[-4].variableType) == BIT){ (yyval.otype) = OutType::BOOL_ARR;}
    if( (yyvsp[-4].variableType) == FLOAT){ (yyval.otype) = OutType::FLOAT_ARR;}
}
#line 1861 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 36:
#line 290 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  (yyval.otype) = ((Tuple*)OutType::getTuple(*(yyvsp[-4].strConst)))->arr;
}
#line 1869 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 37:
#line 293 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 
    (yyval.otype) = OutType::getTuple(*(yyvsp[0].strConst));
}
#line 1877 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 38:
#line 297 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {/* Empty */  (yyval.tVector) = new vector<OutType*>(); }
#line 1883 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 39:
#line 298 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    (yyvsp[-1].tVector)->push_back( (yyvsp[0].otype) );
    (yyval.tVector) = (yyvsp[-1].tVector);
}
#line 1892 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 40:
#line 302 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    OutType* type;
    if ((yyvsp[-3].variableType) == INT) {type = OutType::INT_ARR;}
    if( (yyvsp[-3].variableType) == BIT){ type = OutType::BOOL_ARR;}
    if( (yyvsp[-3].variableType) == FLOAT){type = OutType::FLOAT_ARR;}
    for (int i = 0; i < (yyvsp[-1].intConst); i++ ) {
        (yyvsp[-4].tVector)->push_back (type );
    }
    (yyval.tVector) = (yyvsp[-4].tVector);

}
#line 1908 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 41:
#line 314 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
//add type
    OutType::makeTuple(*(yyvsp[-3].strConst), *(yyvsp[-1].tVector), -1);

}
#line 1918 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 42:
#line 319 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    OutType::makeTuple(*(yyvsp[-4].strConst), *(yyvsp[-1].tVector), (yyvsp[-2].intConst));
}
#line 1926 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 43:
#line 323 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { /* Empty */ }
#line 1932 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 44:
#line 324 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { }
#line 1938 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 45:
#line 326 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {/* Empty */}
#line 1944 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 46:
#line 327 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { }
#line 1950 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 47:
#line 329 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  envt->registerFunctionReplace(*(yyvsp[-6].strConst), *(yyvsp[-8].strConst), *(yyvsp[-4].strConst), (yyvsp[-2].intConst));
}
#line 1958 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 48:
#line 335 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	if(PARAMS->interactive){
		(yyval.bdag) = envt->prepareMiter(envt->getCopy(*(yyvsp[0].strConst)),  envt->getCopy(*(yyvsp[-2].strConst)), envt->inlineAmnt());
	}else{
		envt->addspskpair(*(yyvsp[0].strConst), *(yyvsp[-2].strConst));
	}		
}
#line 1970 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 49:
#line 343 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {if(PARAMS->interactive){ solution.restart();} }
#line 1976 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 50:
#line 344 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	if(PARAMS->interactive){
		int tt = envt->assertDAG((yyvsp[-1].bdag), std::cout);
		envt->printControls("");
		solution.stop();
		cout<<"COMPLETED"<<endl;
		if(tt != 0){
			return tt;
		}
	}
}
#line 1992 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 51:
#line 356 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	int tt = envt->runCommand(*(yyvsp[-4].strConst), *(yyvsp[-2].sList));
	delete (yyvsp[-4].strConst);
	delete (yyvsp[-2].sList);
	if(tt >= 0){
		return tt;
	}
}
#line 2005 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 52:
#line 365 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.sList) = new list<string*>();	
}
#line 2013 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 53:
#line 368 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.sList) = (yyvsp[0].sList);
	(yyval.sList)->push_back( (yyvsp[-1].strConst));
}
#line 2022 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 54:
#line 372 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.sList) = (yyvsp[0].sList);
	(yyval.sList)->push_back( (yyvsp[-1].strConst));
}
#line 2031 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 55:
#line 378 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { /* Empty */ }
#line 2037 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 56:
#line 379 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { /* */ }
#line 2043 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 57:
#line 382 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  (yyval.intConst)=0;  /* */ }
#line 2049 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 58:
#line 383 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	currentBD->alias( *(yyvsp[-3].strConst), (yyvsp[-1].bnode));
	delete (yyvsp[-3].strConst);
}
#line 2058 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 59:
#line 387 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

	list<string*>* childs = (yyvsp[-9].sList);
	list<string*>::reverse_iterator it = childs->rbegin();
	
	list<bool_node*>* oldchilds = (yyvsp[-7].nList);
	list<bool_node*>::reverse_iterator oldit = oldchilds->rbegin();
	
	bool_node* rhs;
	rhs = (yyvsp[-1].bnode);
	int bigN = childs->size();
	Assert( bigN == oldchilds->size(), "This can't happen");	

	for(int i=0; i<bigN; ++i, ++it, ++oldit){		
		ARRASS_node* an = dynamic_cast<ARRASS_node*>(newNode(bool_node::ARRASS));
		an->multi_mother.reserve(2);
		an->multi_mother.push_back(*oldit);			
		an->multi_mother.push_back(rhs);
		Assert( rhs != NULL, "AAARRRGH This shouldn't happen !!");
		Assert((yyvsp[-4].bnode) != NULL, "1: THIS CAN'T HAPPEN!!");
		an->quant = i;		
		currentBD->alias( *(*it), currentBD->new_node((yyvsp[-4].bnode),  NULL,  an) );
		delete *it;
	}
	delete childs;
	delete oldchilds;	
}
#line 2090 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 60:
#line 415 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	Assert(false, "UNREACHABLE");
	currentBD->create_outputs(2 /*NINPUTS*/, (yyvsp[-1].bnode), *(yyvsp[-3].strConst));
	delete (yyvsp[-3].strConst);
}
#line 2100 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 61:
#line 420 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  if ((yyvsp[-1].bnode)) {
    /* Asserting an expression, construct assert node. */
    
    currentBD->new_node ((yyvsp[-1].bnode), NULL, bool_node::ASSERT);
  }
}
#line 2112 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 62:
#line 427 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  if ((yyvsp[-3].bnode)) {
    /* Asserting an expression, construct assert node. */
	if(!((yyvsp[-3].bnode)->type == bool_node::CONST && dynamic_cast<CONST_node*>((yyvsp[-3].bnode))->getVal() == 1)){
		ASSERT_node* bn = dynamic_cast<ASSERT_node*>(newNode(bool_node::ASSERT));
		bn->setMsg(*(yyvsp[-1].strConst));
		currentBD->new_node ((yyvsp[-3].bnode), NULL, bn);
	}    
    delete (yyvsp[-1].strConst);
  }
}
#line 2128 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 63:
#line 438 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  if ((yyvsp[-1].bnode)) {
    /* Asserting an expression, construct assert node. */
    
    ASSERT_node* bn = dynamic_cast<ASSERT_node*>(newNode(bool_node::ASSERT));
    bn->makeHardAssert();
    currentBD->new_node((yyvsp[-1].bnode), NULL, bn);
  }
}
#line 2142 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 64:
#line 447 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  if ((yyvsp[-3].bnode)) {
    /* Asserting an expression, construct assert node. */
	if(!((yyvsp[-3].bnode)->type == bool_node::CONST && dynamic_cast<CONST_node*>((yyvsp[-3].bnode))->getVal() == 1)){
		ASSERT_node* bn = dynamic_cast<ASSERT_node*>(newNode(bool_node::ASSERT));
		bn->setMsg(*(yyvsp[-1].strConst));
    bn->makeHardAssert();
		currentBD->new_node ((yyvsp[-3].bnode), NULL, bn);
	}    
    delete (yyvsp[-1].strConst);
  }
}
#line 2159 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 65:
#line 460 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  if ((yyvsp[-2].bnode)) {
    /* Asserting an expression, construct assert node. */
	if(!((yyvsp[-2].bnode)->type == bool_node::CONST && dynamic_cast<CONST_node*>((yyvsp[-2].bnode))->getVal() == 1)){
		ASSERT_node* bn = dynamic_cast<ASSERT_node*>(newNode(bool_node::ASSERT));
		bn->makeAssume();
		if ((yyvsp[-1].strConst)) {
			bn->setMsg(*(yyvsp[-1].strConst));
		}
		currentBD->new_node ((yyvsp[-2].bnode), NULL, bn);
	}
	if ((yyvsp[-1].strConst)) {
		delete (yyvsp[-1].strConst);
	}
  }
}
#line 2180 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 66:
#line 477 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.strConst) = (yyvsp[0].strConst); }
#line 2186 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 67:
#line 478 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.strConst) = 0; }
#line 2192 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 68:
#line 480 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.bnode) = (yyvsp[0].bnode); }
#line 2198 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 69:
#line 481 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::AND);	
}
#line 2206 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 70:
#line 484 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::AND);
}
#line 2214 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 71:
#line 487 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::OR);	
}
#line 2222 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 72:
#line 490 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 	
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::OR);	
}
#line 2230 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 73:
#line 493 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {	
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::XOR);	
}
#line 2238 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 74:
#line 496 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {	
	bool_node* tmp = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::EQ);
	(yyval.bnode) = currentBD->new_node (tmp, NULL, bool_node::NOT);	
}
#line 2247 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 75:
#line 500 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 			
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::EQ);
}
#line 2255 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 76:
#line 503 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-1].bnode), (yyvsp[-3].bnode), bool_node::ARR_R);
}
#line 2263 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 77:
#line 506 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
   
	//TUPLE_R_node* tn = dynamic_cast<TUPLE_R_node*>();
    
	//tn->idx = $4;
	(yyval.bnode) = currentBD->new_node((yyvsp[-4].bnode), (yyvsp[-1].intConst));
	
}
#line 2276 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 78:
#line 514 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-1].bnode), currentBD->create_const((yyvsp[-3].intConst)), bool_node::ARR_R);		
}
#line 2284 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 79:
#line 517 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	ARR_W_node* an = dynamic_cast<ARR_W_node*>(newNode(bool_node::ARR_W));
	an->multi_mother.push_back( currentBD->get_node(*(yyvsp[-7].strConst)) );
	an->multi_mother.push_back( (yyvsp[-2].bnode) );
	(yyval.bnode) = currentBD->new_node((yyvsp[-4].bnode), NULL, an);	
	delete (yyvsp[-7].strConst);
}
#line 2296 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 80:
#line 524 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	ARR_W_node* an = dynamic_cast<ARR_W_node*>(newNode(bool_node::ARR_W));
	an->multi_mother.push_back( currentBD->create_const((yyvsp[-7].intConst)) );
	an->multi_mother.push_back( (yyvsp[-2].bnode) );
	(yyval.bnode) = currentBD->new_node((yyvsp[-4].bnode), NULL, an);		
}
#line 2307 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 81:
#line 530 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	int pushval = 0;
	arith_node* an = dynamic_cast<arith_node*>(newNode(bool_node::ARRACC));
	list<bool_node*>* childs = (yyvsp[-4].nList);
	list<bool_node*>::reverse_iterator it = childs->rbegin();
	int bigN = childs->size();
	an->multi_mother.reserve(bigN);
	for(int i=0; i<bigN; ++i, ++it){
		an->multi_mother.push_back(*it);
	}		
	Assert((yyvsp[-1].bnode) != NULL, "2: THIS CAN'T HAPPEN!!");	
	(yyval.bnode) = currentBD->new_node((yyvsp[-1].bnode), NULL,  an);
	delete childs;	
}
#line 2326 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 82:
#line 544 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	arith_node* an = dynamic_cast<arith_node*>(newNode(bool_node::ARR_CREATE));
    

	list<bool_node*>* childs = (yyvsp[-1].nList);
	list<bool_node*>::reverse_iterator it = childs->rbegin();
	int bigN = childs->size();
	an->multi_mother.reserve(bigN);
	for(int i=0; i<bigN; ++i, ++it){
		an->multi_mother.push_back(*it);
	}		
	(yyval.bnode) = currentBD->new_node(NULL, NULL, an); 
	delete childs;
}
#line 2345 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 83:
#line 558 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

	arith_node* an = dynamic_cast<arith_node*>(newNode(bool_node::TUPLE_CREATE));

	list<bool_node*>* childs = (yyvsp[-1].nList);
	list<bool_node*>::reverse_iterator it = childs->rbegin();
	int bigN = childs->size();
	an->multi_mother.reserve(bigN);
	for(int i=0; i<bigN; ++i, ++it){
		an->multi_mother.push_back(*it);
	}
    (dynamic_cast<TUPLE_CREATE_node*>(an))->setName(*(yyvsp[-4].strConst));
	(yyval.bnode) = currentBD->new_node(NULL, NULL, an); 
	delete childs;
}
#line 2365 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 84:
#line 573 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	arith_node* an = dynamic_cast<arith_node*>(newNode(bool_node::ACTRL));
	list<bool_node*>* childs = (yyvsp[-1].nList);
	list<bool_node*>::reverse_iterator it = childs->rbegin();
	int bigN = childs->size();
	an->multi_mother.reserve(bigN);
	for(int i=0; i<bigN; ++i, ++it){
		an->multi_mother.push_back(*it);
	}		
	(yyval.bnode) = currentBD->new_node(NULL, NULL, an); 
	delete childs;
}
#line 2382 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 85:
#line 586 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::PLUS); 	
}
#line 2390 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 86:
#line 590 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {	
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::DIV); 	
}
#line 2398 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 87:
#line 594 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {	
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::MOD); 	
}
#line 2406 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 88:
#line 598 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode)= currentBD->new_node((yyvsp[-2].bnode),  (yyvsp[0].bnode), bool_node::TIMES);
}
#line 2414 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 89:
#line 601 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	bool_node* neg1 = currentBD->new_node((yyvsp[0].bnode), NULL, bool_node::NEG);
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode), neg1, bool_node::PLUS); 	
}
#line 2423 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 90:
#line 605 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	
	(yyval.bnode) = currentBD->new_node((yyvsp[0].bnode), (yyvsp[-2].bnode), bool_node::LT);     
}
#line 2432 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 91:
#line 609 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->new_node((yyvsp[-2].bnode), (yyvsp[0].bnode), bool_node::LT);
}
#line 2440 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 92:
#line 612 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	bool_node* tmp = currentBD->new_node((yyvsp[-2].bnode), (yyvsp[0].bnode), bool_node::LT);
	(yyval.bnode) = currentBD->new_node(tmp, NULL, bool_node::NOT);
}
#line 2449 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 93:
#line 616 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	bool_node* tmp = currentBD->new_node((yyvsp[0].bnode), (yyvsp[-2].bnode), bool_node::LT);
	(yyval.bnode) = currentBD->new_node(tmp, NULL, bool_node::NOT);
}
#line 2458 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 94:
#line 620 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	arith_node* an = dynamic_cast<arith_node*>(newNode(bool_node::ARRACC));
	bool_node* yesChild =((yyvsp[-2].bnode));
	bool_node* noChild = ((yyvsp[0].bnode));
	an->multi_mother.push_back( noChild );
	an->multi_mother.push_back( yesChild );	
	(yyval.bnode) = currentBD->new_node((yyvsp[-4].bnode), NULL, an); 	
}
#line 2471 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 95:
#line 631 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { /* Empty */  	(yyval.nList) = new list<bool_node*>();	}
#line 2477 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 96:
#line 632 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {

//The signs are already in the stack by default. All I have to do is not remove them.
	if((yyvsp[-1].bnode) != NULL){
		(yyvsp[0].nList)->push_back( (yyvsp[-1].bnode) );
	}else{
		(yyvsp[0].nList)->push_back( NULL );
	}
	(yyval.nList) = (yyvsp[0].nList);
}
#line 2492 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 97:
#line 643 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.sList) = new list<string*>();	
	(yyval.sList)->push_back( (yyvsp[0].strConst));
}
#line 2501 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 98:
#line 647 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.sList) = (yyvsp[0].sList);
	(yyval.sList)->push_back( (yyvsp[-1].strConst));
}
#line 2510 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 99:
#line 652 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_const((yyvsp[0].intConst));
}
#line 2518 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 100:
#line 655 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_const((yyvsp[0].doubleConst));
}
#line 2526 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 101:
#line 659 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
    
	list<bool_node*>* params = (yyvsp[-9].nList);
	if(false && params->size() == 0){

        (yyval.bnode) = currentBD->create_inputs(-1,OutType::getTuple(*(yyvsp[-12].strConst)), *(yyvsp[-15].strConst));

		delete (yyvsp[-15].strConst);
	}else{	
		string& fname = *(yyvsp[-15].strConst);
		list<bool_node*>::reverse_iterator parit = params->rbegin();
		UFUN_node* ufun = new UFUN_node(fname);
		ufun->outname = *(yyvsp[-3].strConst);
		int fgid = (yyvsp[-1].intConst);
		ufun->fgid = fgid;
		bool_node* pCond;	
		for( ; parit != params->rend(); ++parit){
            ufun->multi_mother.push_back((*parit));
        }
        pCond = (yyvsp[-6].bnode);


        ufun->set_nbits( 0 );
        ufun->set_tupleName(*(yyvsp[-12].strConst));
		
		
		//ufun->name = (currentBD->new_name(fname));
		(yyval.bnode) = currentBD->new_node(pCond, NULL, ufun);

        delete (yyvsp[-15].strConst);
		delete (yyvsp[-3].strConst);
	}
	delete (yyvsp[-9].nList);

}
#line 2566 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 102:
#line 694 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	
	list<bool_node*>* params = (yyvsp[-9].nList);
	if(false && params->size() == 0){
		if( (yyvsp[-12].variableType) == INT){
			(yyval.bnode) = currentBD->create_inputs( 2 /*NINPUTS*/, OutType::INT , *(yyvsp[-14].strConst)); 
		}else{
			if((yyvsp[-12].variableType)==FLOAT){
				(yyval.bnode) = currentBD->create_inputs(-1,OutType::FLOAT, *(yyvsp[-14].strConst));
			}else{
				(yyval.bnode) = currentBD->create_inputs(-1,OutType::BOOL, *(yyvsp[-14].strConst));
			}
		}
		delete (yyvsp[-14].strConst);
	}else{	
		string& fname = *(yyvsp[-14].strConst);
		list<bool_node*>::reverse_iterator parit = params->rbegin();
		UFUN_node* ufun = new UFUN_node(fname);
		ufun->outname = *(yyvsp[-3].strConst);
		int fgid = (yyvsp[-1].intConst);
		ufun->fgid = fgid;	
		bool_node* pCond;	

        for( ; parit != params->rend(); ++parit){
            ufun->multi_mother.push_back((*parit));
        }
        pCond = (yyvsp[-6].bnode);

		
		if( (yyvsp[-12].variableType) == INT || (yyvsp[-12].variableType)==INT_ARR){
			ufun->set_nbits( 2 /*NINPUTS*/  );
		}else{	
			ufun->set_nbits( 1  );
		}
		if((yyvsp[-12].variableType) == INT_ARR || (yyvsp[-12].variableType)==BIT_ARR){
			ufun->makeArr();
		}
		
		//ufun->name = (currentBD->new_name(fname));
		(yyval.bnode) = currentBD->new_node(pCond, NULL, ufun);

		
		delete (yyvsp[-14].strConst);
		delete (yyvsp[-3].strConst);
	}
	delete (yyvsp[-9].nList);
}
#line 2618 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 103:
#line 742 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {		
		(yyval.bnode) = currentBD->new_node((yyvsp[0].bnode), NULL, bool_node::NEG);				
}
#line 2626 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 104:
#line 745 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 
	(yyval.bnode) = currentBD->new_node((yyvsp[0].bnode), NULL, bool_node::NOT);		    
}
#line 2634 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 105:
#line 749 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 
						(yyval.bnode) = (yyvsp[-1].bnode); 
						}
#line 2642 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 106:
#line 752 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { 			
			(yyval.bnode) = currentBD->get_node(*(yyvsp[0].strConst));
			delete (yyvsp[0].strConst);				
			 
		}
#line 2652 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 107:
#line 757 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {		
	(yyval.bnode) = currentBD->create_controls(-1, *(yyvsp[-1].strConst));
	delete (yyvsp[-1].strConst);
}
#line 2661 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 108:
#line 761 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	int nctrls = (yyvsp[-1].intConst);
	if(overrideNCtrls){
		nctrls = NCTRLS;
	}
	(yyval.bnode) = currentBD->create_controls(nctrls, *(yyvsp[-2].strConst));
	delete (yyvsp[-2].strConst);
}
#line 2674 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 109:
#line 769 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls((yyvsp[-2].intConst), *(yyvsp[-3].strConst));
	delete (yyvsp[-3].strConst);

}
#line 2684 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 110:
#line 774 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls(-1, *(yyvsp[-2].strConst), false, true);
	delete (yyvsp[-2].strConst);
}
#line 2693 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 111:
#line 778 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls((yyvsp[-2].intConst), *(yyvsp[-3].strConst), false, true);
	delete (yyvsp[-3].strConst);
}
#line 2702 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 112:
#line 782 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  (yyval.bnode) = currentBD->create_controls(-1, *(yyvsp[-2].strConst), false, true, false, -1, true);
  delete (yyvsp[-2].strConst);
}
#line 2711 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 113:
#line 786 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls(-1, *(yyvsp[-1].strConst), true);
	delete (yyvsp[-1].strConst);
}
#line 2720 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 114:
#line 790 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	int nctrls = (yyvsp[-1].intConst);
	if(overrideNCtrls){
		nctrls = NCTRLS;
	}
	(yyval.bnode) = currentBD->create_controls(nctrls, *(yyvsp[-2].strConst), true);
	delete (yyvsp[-2].strConst);
}
#line 2733 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 115:
#line 798 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls((yyvsp[-2].intConst), *(yyvsp[-3].strConst), true);
	delete (yyvsp[-3].strConst);

}
#line 2743 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 116:
#line 803 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls(-1, *(yyvsp[-1].strConst), false, false, true, (yyvsp[-6].intConst));
  ((CTRL_node*) (yyval.bnode))->setParents(*(yyvsp[-4].sVector));
	delete (yyvsp[-1].strConst);
}
#line 2753 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 117:
#line 808 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	int nctrls = (yyvsp[-1].intConst);
	if(overrideNCtrls){
		nctrls = NCTRLS;
	}
	(yyval.bnode) = currentBD->create_controls(nctrls, *(yyvsp[-2].strConst), false, false, true, (yyvsp[-7].intConst));
  ((CTRL_node*) (yyval.bnode))->setParents(*(yyvsp[-5].sVector));
	delete (yyvsp[-2].strConst);
}
#line 2767 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 118:
#line 817 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
	(yyval.bnode) = currentBD->create_controls((yyvsp[-2].intConst), *(yyvsp[-3].strConst), false, false, true, (yyvsp[-8].intConst));
  ((CTRL_node*) (yyval.bnode))->setParents(*(yyvsp[-6].sVector));
	delete (yyvsp[-3].strConst);
}
#line 2777 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 119:
#line 824 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { /* Empty */  	(yyval.sVector) = new vector<string>();	}
#line 2783 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 120:
#line 825 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {
  (yyvsp[-1].sVector)->push_back(*(yyvsp[0].strConst));
	(yyval.sVector) = (yyvsp[-1].sVector);
}
#line 2792 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 121:
#line 830 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[0].intConst); }
#line 2798 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 122:
#line 831 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[-2].intConst) + (yyvsp[0].intConst); }
#line 2804 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 123:
#line 832 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[-2].intConst) - (yyvsp[0].intConst); }
#line 2810 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 124:
#line 834 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[0].intConst); }
#line 2816 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 125:
#line 835 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[-1].intConst); }
#line 2822 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 126:
#line 836 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = (yyvsp[-2].intConst) * (yyvsp[0].intConst); }
#line 2828 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 127:
#line 837 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { Assert( (yyvsp[0].intConst) != 0, "You are attempting to divide by zero !!");
							      (yyval.intConst) = (yyvsp[-2].intConst) / (yyvsp[0].intConst); }
#line 2835 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 128:
#line 839 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { Assert( (yyvsp[0].intConst) != 0, "You are attempting to mod by zero !!");
							      (yyval.intConst) = (yyvsp[-2].intConst) % (yyvsp[0].intConst); }
#line 2842 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 129:
#line 843 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  (yyval.intConst) = (yyvsp[0].intConst); }
#line 2848 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 130:
#line 844 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  (yyval.intConst) = -(yyvsp[0].intConst); }
#line 2854 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 131:
#line 847 "InputParser/InputParser.yy" /* yacc.c:1646  */
    {  (yyval.intConst) = (yyvsp[0].intConst); }
#line 2860 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 132:
#line 848 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = 1; }
#line 2866 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 133:
#line 849 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.intConst) = 0; }
#line 2872 "InputParser.cpp" /* yacc.c:1646  */
    break;

  case 134:
#line 851 "InputParser/InputParser.yy" /* yacc.c:1646  */
    { (yyval.strConst)=(yyvsp[0].strConst); }
#line 2878 "InputParser.cpp" /* yacc.c:1646  */
    break;


#line 2882 "InputParser.cpp" /* yacc.c:1646  */
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */

  yyn = yyr1[yyn];

  yystate = yypgoto[yyn - YYNTOKENS] + *yyssp;
  if (0 <= yystate && yystate <= YYLAST && yycheck[yystate] == *yyssp)
    yystate = yytable[yystate];
  else
    yystate = yydefgoto[yyn - YYNTOKENS];

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (yyscanner, YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yyscanner, yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval, yyscanner);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp, yyscanner);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (yyscanner, YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval, yyscanner);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[*yyssp], yyvsp, yyscanner);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 853 "InputParser/InputParser.yy" /* yacc.c:1906  */



void Inityyparse(){

	 	
}

void yyerror( void* yyscanner, const char* c){
	Assert(false, (char *)c); 
}


int isatty(int i){



return 1;
}
