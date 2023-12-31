grammar IsiLang;

@header{
	import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import src.br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import src.br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import src.br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import src.br.com.professorisidro.isilanguage.ast.IsiProgram;
	import src.br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import src.br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import src.br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import src.br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import src.br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import src.br.com.professorisidro.isilanguage.ast.CommandWhile;
	import src.br.com.professorisidro.isilanguage.ast.CommandDoWhile;
	import java.util.ArrayList;
	import java.util.Stack;
}

@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String _exprWhile;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	private ArrayList<AbstractCommand> listaLoop;
    private int leftDT;
    private int rightDT;
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Symbol "+id+" not declared");
		}
		if (!((IsiVariable)(symbolTable.get(id))).getAtribuicao()){
			//throw new IsiSemanticException("Symbol "+id+" not assigned");
			System.out.println("Symbol "+id+" not assigned");
		} else {
		    System.out.println("Symbol "+id+" already declared");
		}
	}

	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' decl bloco  'fimprog.'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());
           	  ArrayList<IsiSymbol> lista = symbolTable.getAll();
              for(int i = 0; i<lista.size();i++){
                  boolean atribuido = ((IsiVariable)(lista.get(i))).getAtribuicao();

                  boolean usado = ((IsiVariable)(lista.get(i))).getUso();
                  if (atribuido && usado) {
                  } else if ( atribuido && !usado){
                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" assigned but not used.");
                  } else if (!atribuido && usado){
                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" used but not assigned.");
                  } else {
                      System.out.println("WARNING: Symbol "+ lista.get(i).getName()+" declared but not assigned and used.");
                  }
              }
           }
		;
		
decl    :  (declaravar)+
        ;

declaravar :  tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    } 
              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>();
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao
 		|  cmdrepeticao
		;
		
cmdleitura	: 'leia' AP
                     ID { if (symbolTable.exists(_input.LT(-1).getText())){
                                      ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setAtribuicao(true);
                                  }
                          verificaID(_input.LT(-1).getText());
                     	  _readID = _input.LT(-1).getText();
                        } 
                     FP 
                     SC 
                     
              {
              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
              	CommandLeitura cmd = new CommandLeitura(_readID, var);
              	stack.peek().add(cmd);
              }   
			;
			
cmdescrita	: 'escreva' 
                 AP 
                 ID { verificaID(_input.LT(-1).getText());
                      ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
	                  _writeID = _input.LT(-1).getText();
                     } 
                 FP 
                 SC
               {
               	  CommandEscrita cmd = new CommandEscrita(_writeID);
               	  stack.peek().add(cmd);
               }
			;
			
cmdattrib	:  ID { if (symbolTable.exists(_input.LT(-1).getText())){
                                ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setAtribuicao(true);
                            }
                    verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                    leftDT = ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).getType();
                   } 
               ATTR { _exprContent = ""; } 
               expr 
               SC
               {
               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               	 stack.peek().add(cmd);
               }
			;
			
			
cmdselecao  :  'se' AP
                    ID    {
                            verificaID(_input.LT(-1).getText());
                            ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
                            _exprDecision = _input.LT(-1).getText();
                          }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER | STRING) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdrepeticao : 'while' AP
               expr {_exprWhile = _input.LT(-1).getText();}
               OPREL {_exprWhile += _input.LT(-1).getText();}
               expr {_exprWhile += _input.LT(-1).getText();}
               FP ACH {  curThread = new ArrayList<AbstractCommand>();
                        stack.push(curThread);
                     }
               (cmd)+
               FCH {
                    listaLoop = stack.pop();
                    CommandWhile cmd = new CommandWhile(_exprWhile, listaLoop);
                    stack.peek().add(cmd);
                   }
               |
               'do'ACH { curThread = new ArrayList<AbstractCommand>();
                      stack.push(curThread);
                      }
               (cmd)+
               FCH 'while' AP
               expr {_exprWhile = _input.LT(-1).getText();}
               OPREL{_exprWhile += _input.LT(-1).getText();}
               expr {_exprWhile += _input.LT(-1).getText();}
               FP {   listaLoop = stack.pop();
                      CommandDoWhile cmd = new CommandDoWhile(_exprWhile, listaLoop);
                      stack.peek().add(cmd);
                  } SC;

expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;
			
termo		: ID { verificaID(_input.LT(-1).getText());
                   ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).setUso(true);
	               _exprContent += _input.LT(-1).getText();
	               rightDT = ((IsiVariable)(symbolTable.get(_input.LT(-1).getText()))).getType();
                   if (leftDT != rightDT){
                   		throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+rightDT);
                   }
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
                if (leftDT != 0){
                  throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+0);
                 }
              }
            | STRING { _exprContent += _input.LT(-1).getText();
                        if (leftDT != 1){
                          throw new IsiSemanticException("Semantic ERROR - Type Mismatching "+leftDT+ "-"+1);
                        }
                     }


			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: '.'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

STRING  : ASPAS ('A'..'Z' | 'a'..'z' | '0'..'9' | ' ')* ASPAS
        ;

ASPAS   : '"'
        ;

WS	: (' ' | '\t' | '\n' | '\r') -> skip;