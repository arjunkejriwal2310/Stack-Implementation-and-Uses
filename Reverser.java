import java.util.Scanner;

public class Reverser
{
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        Reverser reverse;
        reverse = new Reverser();
        reverse.go();
    }

    public void go()
    {
        System.out.println("Please enter a string: ");
        String s = keyboard.nextLine();

        String rev = reverse(s);

        System.out.println("The reverse of the entered string is the following: " + rev);
    }

    public String reverse (String s)
    {
        CS112Stack<Character> stack = new CS112Stack<Character>();

        for (int i = 0; i < s.length(); i++)
        {
            stack.push(s.charAt(i));
        }

        String reverse = "";

        for (int i = 0; i < s.length(); i++)
        {
            reverse = reverse + stack.pop();
        }

        return reverse;
    }
}
