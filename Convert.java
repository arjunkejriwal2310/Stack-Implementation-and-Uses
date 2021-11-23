import java.util.Scanner;

public class Convert
{
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        Convert convert;
        convert = new Convert();
        convert.go();
    }

    public void go()
    {
        System.out.println("Please enter the infix expression: ");
        String infix = keyboard.nextLine();

        Scanner scanner = new Scanner(infix);

        String postfix = convert(scanner);

        System.out.println("");
        System.out.println("The postfix expression is as follows: " + postfix);

        Scanner scanner2 = new Scanner(postfix);
        int result = value(scanner2);

        System.out.println("");
        System.out.println("The result of the postfix expression is: " + result);
    }

    public String convert(Scanner s)
    {
        CS112Stack<Operator> stack = new CS112Stack<Operator>();
        String output = "";
        String next = "";
        int bracket = 0;

        while(!next.equals("="))
        {
            if (s.hasNextInt())
            {
                output = output + s.nextInt() + " ";
            }
            else
            {
                next = s.next();
                if(next.equals("+"))
                {
                    Operator plus = new Operator('+', 1 + bracket);
                    if (!stack.isEmpty())
                    {
                        if (stack.top().getPrecedence() >= plus.getPrecedence())
                        {
                            output = output + stack.pop() + " ";
                        }
                    }
                    stack.push(plus);
                }
                else if (next.equals("-"))
                {
                    Operator minus = new Operator('-', 1 + bracket);
                    if (!stack.isEmpty())
                    {
                        if (stack.top().getPrecedence() >= minus.getPrecedence())
                        {
                            output = output + stack.pop() + " ";
                        }
                    }
                    stack.push(minus);
                }
                else if (next.equals("*"))
                {
                    Operator into = new Operator('*', 2 + bracket);
                    if (!stack.isEmpty())
                    {
                        if (stack.top().getPrecedence() >= into.getPrecedence())
                        {
                            output = output + stack.pop() + " ";
                        }
                    }
                    stack.push(into);
                }
                else if (next.equals("/"))
                {
                    Operator divide = new Operator('/', 2 + bracket);
                    if (!stack.isEmpty())
                    {
                        if (stack.top().getPrecedence() >= divide.getPrecedence())
                        {
                            output = output + stack.pop() + " ";
                        }
                    }
                    stack.push(divide);
                }
                else if (next.equals("("))
                {
                    bracket = bracket + 4;
                }
                else if (next.equals(")"))
                {
                    bracket = bracket - 4;
                }
            }
        }

        if (next.equals("="))
        {
            while(!stack.isEmpty())
            {
                output = output + stack.pop() + " ";
            }
        }

        output = output + "=";
        return output;
    }

    public int value (Scanner s)
    {
        CS112Stack<Integer> stack = new CS112Stack<Integer>();
        String next = "";

        while(!next.equals("="))
        {
            if (s.hasNextInt())
            {
                stack.push(s.nextInt());
            }
            else
            {
                next = s.next();
                if (next.equals("+"))
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                else if (next.equals("-"))
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                else if (next.equals("*"))
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                else if (next.equals("/"))
                {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
            }
        }

        return stack.top();
    }
}