
public class UseStack {

	public static void main(String[] args) {

		UseStack use;
		use = new UseStack();
		use.go();

	}

	public void go() {


		CS112Stack<Integer> stack = new CS112Stack<Integer>();
		stack.push(11);
		stack.push(13);
		System.out.println(stack.pop());
		stack.push(87);
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());


		CS112Stack<String> stack2 = new CS112Stack<String>();
		stack2.push("Beethoven");
		stack2.push("Berlioz");
		System.out.println(stack2.pop());
		stack2.push("Liszt");
		System.out.println(stack2.pop());
		System.out.println(stack2.isEmpty());
		System.out.println(stack2.pop());
		System.out.println(stack2.isEmpty());


		CS112Stack<Character> s = new CS112Stack<Character>();

		for (char i='a'; i<='z';i++)
		{
			s.push(i);
		}

		while (!s.isEmpty())
		{
			System.out.print(s.pop());
		}

		System.out.println();




	}

}
