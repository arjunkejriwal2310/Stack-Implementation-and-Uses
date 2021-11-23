public class Operator
{
    private char operator;
    private int precedence;

    public Operator (char operator, int precedence)
    {
        this.operator = operator;
        this.precedence = precedence;
    }

    public void setOperator(char operator)
    {
        this.operator = operator;
    }

    public void setPrecedence(int precedence)
    {
        this.precedence = precedence;
    }

    public char getOperator()
    {
        return operator;
    }

    public int getPrecedence()
    {
        return precedence;
    }

    public String toString()
    {
        return operator + "";
    }
}
