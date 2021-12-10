import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class SyntaxTable {

  public final static int IFSTATEMENT_PRIME = 100;
  public final static int IFSTATEMENT = 101;
  public final static int RELEXPRESSION = 102;
  public final static int EXPRESSION = 103;
  public final static int ELSEPART = 104;
  public final static int TERM = 105;

  private static ArrayList<HashMap<Integer, String>> _syntaxTable;
  private static ArrayList<Rule> _rules;

  public SyntaxTable() {
  }

  public static List<HashMap<Integer, String>> getSyntaxTable() {
    if (_syntaxTable == null)
      _syntaxTable = new ArrayList<HashMap<Integer, String>>() {
        {
          // #0
          add(new HashMap<Integer, String>() {
            {
              put(sym.IF, "sk 2");
              put(IFSTATEMENT, "1");
            }
          });
          // #1
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "acc");
            }
          });
          // #2
          add(new HashMap<Integer, String>() {
            {
              put(sym.LEFTPAR, "sk 3");
             
            }
          });
          // #3
          add(new HashMap<Integer, String>() {
            {
              put(RELEXPRESSION, "4");
              put(TERM, "9");
              
            }
          });
          // #4
          add(new HashMap<Integer, String>() {
            {
              put(sym.RIGHTPAR, "sk 5");
            }
          });
          // #5
          add(new HashMap<Integer, String>() {
            {
              put(sym.COLON, "sk 6");
            }
          });
          // #6
          add(new HashMap<Integer, String>() {
            {
              put(EXPRESSION, "7");
              put(TERM, "16");
            }
          });
          // #7
          add(new HashMap<Integer, String>() {
            {
              put(sym.ELSE, "sk 17");
              put(sym.MUL, "sk 14");
              put(ELSEPART, "8");
            }
          });
          // #8
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "rk 1");
            }
          });
          // #9
          add(new HashMap<Integer, String>() {
            {
              put(sym.RIGHTPAR, "rk 4");
              put(sym.EOF, "rk 4");
              
            }
          });
          // #10
          add(new HashMap<Integer, String>() {
            {
              
              put(TERM, "10");
            }
          });
          // #11
          add(new HashMap<Integer, String>() {
            {
              put(sym.RIGHTPAR, "rk 3");
              put(sym.EOF, "rk 3");
            }
          });
          // #12
          add(new HashMap<Integer, String>() {
            {
              put(sym.RIGHTPAR, "rk 7");
              put(sym.ELSE, "rk 7");
              put(sym.GREATER, "rk 7");
              put(sym.MUL, "rk 7");
              put(sym.EOF, "rk 7");
            }
          });
          // #13
          add(new HashMap<Integer, String>() {
            {
            	put(sym.RIGHTPAR, "rk 8");
                put(sym.ELSE, "rk 8");
                put(sym.GREATER, "rk 8");
                put(sym.MUL, "rk 8");
                put(sym.EOF, "rk 8");
            }
          });
          // #14
          add(new HashMap<Integer, String>() {
            {
              put(TERM, "15");
            }
          });
          // #15
          add(new HashMap<Integer, String>() {
            {
                put(sym.ELSE, "rk 5");
                put(sym.MUL, "rk 5");
                put(sym.EOF, "rk 5");
            }
          });
          // #16
          add(new HashMap<Integer, String>() {
            {
            	put(sym.ELSE, "rk 6");
                put(sym.MUL, "rk 6");
                put(sym.EOF, "rk 6");
            }
          });
          // #17
          add(new HashMap<Integer, String>() {
            {
              put(sym.COLON, "sk 18");
            }
          });
          // #18
          add(new HashMap<Integer, String>() {
            {
              
              put(TERM, "16");
            }
          });
          // #19
          add(new HashMap<Integer, String>() {
            {
              put(sym.EOF, "rk 2");
              put(TERM, "16");
            }
          });
        }
      };

    return _syntaxTable;
  }

  public static List<Rule> getRules() {
    if (_rules == null)
      _rules = new ArrayList<Rule>() {
        {
          // #0
          add(new Rule(SyntaxTable.IFSTATEMENT_PRIME, new LinkedList<Integer>() {
            {
              add(SyntaxTable.IFSTATEMENT);
            }
          }));
          // #1
          add(new Rule(SyntaxTable.IFSTATEMENT, new LinkedList<Integer>() {
            {
              add(sym.ID);
              add(sym.LEFTPAR);
              add(SyntaxTable.RELEXPRESSION);
              add(sym.RIGHTPAR);
              add(sym.COLON);
              add(SyntaxTable.EXPRESSION);
              add(SyntaxTable.ELSEPART);
            }
          }));
          // #2
          add(new Rule(SyntaxTable.ELSEPART, new LinkedList<Integer>() {
            {
              add(sym.ELSE);
              add(sym.COLON);
              add(SyntaxTable.EXPRESSION);
            }
          }));
          // #3
          add(new Rule(SyntaxTable.RELEXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.TERM);
              add(sym.GREATER);
              add(SyntaxTable.TERM);
            }
          }));
          // #4
          add(new Rule(SyntaxTable.RELEXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.TERM);
            }
          }));
          // #5
          add(new Rule(SyntaxTable.EXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.EXPRESSION);
              add(sym.MUL);
              add(SyntaxTable.TERM);
            }
          }));
          // #6
          add(new Rule(SyntaxTable.EXPRESSION, new LinkedList<Integer>() {
            {
              add(SyntaxTable.TERM);
            }
          }));
          // #7
          add(new Rule(SyntaxTable.TERM, new LinkedList<Integer>() {
            {
              add(sym.ID);
            }
          }));
          // #8
          add(new Rule(SyntaxTable.TERM, new LinkedList<Integer>() {
            {
              add(sym.CONST);
            }
          }));
        }
      };

    return _rules;
  }
}