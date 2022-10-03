 
public class Notation {
	/*
	 * @author Nebeyu Daniel 
	 */
	//no arg constructor 
	public Notation() {
		
	}
	/*
	 * @param infix - the infix expression in string format
	 * @throw InvalidNotationFormatException - if the infix expression format is invalid
	 * @return the postfix expression in string format
	 */
	@SuppressWarnings({ "static-access" })
	public static String convertInfixToPostfix(String complexInfix) throws InvalidNotationFormatException {
		
		MyStack<Character> stack = new MyStack<Character>(complexInfix.length());
		MyQueue<Character> queue = new MyQueue<Character>(complexInfix.length()); 
		//try and catch for notation format
		try {
			for(int i=0; i< complexInfix.length(); i++) {
				//cast each string a char to manipulate better
				Character c = complexInfix.charAt(i);
				Character.toString(c);
				//checks for spaces numbers and for parathesis
				if(c.equals(' ')) {
					continue;
				}
				if(c.isDigit(c)) {
					queue.enqueue(c);
				}
				if(c.equals('(')) {
					stack.push(c);
				}
				//if the operators is there and is in the correct precedence then pop it into the queue
				if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
					char top = stack.top();
						if(top == '*' || top == '/' 
								|| c.equals('-') && top == '-' 
								|| c.equals('-') && top == '+'
								|| c.equals('+') && top == '-' 
								|| c.equals('+') && top == '+') {
							queue.enqueue(stack.pop());
						}
					//push into the stack for final
					stack.push(c);
				}
				// adds the operators at the end by putting it in between parathesis
				if(c.equals(')')) {
					while(stack.top() != '(') {
						queue.enqueue(stack.pop());
						if(stack.top().equals(null)) {
							throw new InvalidNotationFormatException();		
						}
					}
					stack.pop();
				}
			}
		}catch(Exception e) {
			throw new InvalidNotationFormatException();
			
		}
		return queue.toString();
	}
	//@param postfix - the postfix expression in string format
	//@throw InvalidNotationFormatException - if the postfix expression format is invalid
	//@return the infix expression in string format
	
	public static String convertPostfixToInfix(String complexPostfix) {
		MyStack<String> s = new MyStack<String>(complexPostfix.length());
		// try and catch for notation format
		try {
			//checks each char for a space num 
			for(int i =0; i < complexPostfix.length(); i++) {
				if(complexPostfix.charAt(i) == ' ') {
					continue;
				}
				if(Character.isDigit(complexPostfix.charAt(i))){
					s.push(Character.toString(complexPostfix.charAt(i)));
				}
				// checks for operators
				else if(complexPostfix.charAt(i) == '+' 
						|| complexPostfix.charAt(i) == '-' 
						|| complexPostfix.charAt(i) == '/'
						|| complexPostfix.charAt(i) == '*')
				{
				// takes the operators from the string and assigns it to infix notation
					String s1 = s.pop();
					String s2 = s.pop();
					String std = "(" + s2 + complexPostfix.charAt(i) + s1 + ")";
					s.push(std);

				}
			}
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		return s.toString();
		
	}
	// @param postfixExpr - the postfix expression in String format
		// @return the evaluation of the postfix expression as a double
		// @throw InvalidNotationFormatException - if the postfix expression format is invalid
	@SuppressWarnings("static-access")
	public static double evaluatePostfixExpression(String complexPostfix) {
		MyStack<Double> s = new MyStack<Double>(complexPostfix.length());
		//try and catch again while iterating the string 
		try {
			for(int i =0; i<complexPostfix.length(); i++) {
				//checks for space and number
				Character c = complexPostfix.charAt(i);
				if(c.equals(' ')) {
					continue;
				}
				if(c.isDigit(c) || c.equals('(')) {
					s.push(Double.parseDouble(c.toString(c)));
				}
				// checks for operator
				else if(c.equals('+') || c.equals('-') || c.equals('*') || c.equals('/')) {
					double d1 = s.pop();
					double d2 = s.pop();
					//goes through each operation to do the arithmetic.
					if(c.equals('+')){
						s.push(d2 + d1);		
					}
					else if(c.equals('-')) {
						s.push(d2 - d1);
					}
					else if(c.equals('*')) {
						s.push(d2*d1);
					}
					else if(c.equals('/')) {
						s.push(d2/d1);
					}
				}
			}
		}
		catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		return Double.parseDouble(s.toString());
	}
}
