import java.util.Stack;

public class Hanoi
{
	Stack<Integer> start;											//Stacks to represent the 3 pegs
	Stack<Integer> temp;
	Stack<Integer> target;
	int size;														//Original number of disks
	int moves;														//Number of moves from start
	
	public Hanoi(int n)
	{
		moves=0;
		size=n;
		start=new Stack<Integer>();
		temp=new Stack<Integer>();
		target=new Stack<Integer>();
		
		for(int x = n; x != 0; x--){start.push(x);}					//Pushes n items or "disks" on stack
	}
	
	
	public void move(Stack<Integer> a, Stack<Integer> b)			//Move one disk
	{
		if(a.isEmpty()){return;}									
		if(!b.isEmpty() && a.peek() > b.peek()){return;}			//Only a smaller disk can go on a bigger one
		
		int temporary = a.pop();
		b.push(temporary);
		System.out.println("\n\n");
		moves++;
		if(temporary == 1 && b == target && start.isEmpty() && temp.isEmpty())
		{
			System.out.println("End(Move " + moves + "):");
		}
		else
		{
			System.out.println("Move " + moves + ":");
		}
		
		System.out.println(this);
	}
	
	public void solveIntitaler()									//Starts recursion
	{
		System.out.println("Start:");
		System.out.println(this);
		solve(start,temp,target,size);
	}
	
	public void solve(Stack<Integer> s, Stack<Integer> te, Stack<Integer> ta, int x)		//Recursively solves tower 	
	{
		if(x==1)
		{
			move(s,ta);
			return;
		}
		
		solve(s,ta,te,x-1);	
		move (s,ta);
        solve( te, s, ta,x-1);
        
    
		
	}
	
	
	public String toString()
	{
		String wtr = "\t\t|\t\t\t|\t\t\t|\t\t\n";
		
		Stack<Integer> temp1 = (Stack<Integer>) start.clone();
		Stack<Integer> temp2 = (Stack<Integer>) temp.clone();
		Stack<Integer> temp3 = (Stack<Integer>) target.clone();
		
		int max=Math.max(temp1.size(), Math.max(temp2.size(), temp3.size()));
		
		
		for(int i = size - max; i > 0; i--){wtr += "\t\t|\t\t\t|\t\t\t|\t\t\n";}
		
		for(int x = max-1 ; x > -1; x--)
		{
			wtr += "\t\t";
			if(temp1.size()-1 < x){wtr += "|";}
			else{wtr += temp1.pop() + "";}
			wtr += "\t\t\t";
			if(temp2.size() - 1 < x){wtr += "|";}
			else{wtr += temp2.pop() + "";}
			wtr += "\t\t\t";
			if(temp3.size() - 1 < x){wtr += "|";}
			else{wtr += temp3.pop() + "";}
			wtr += "\t\t\n";	
		}
		
		wtr += "\t-----------------\t-----------------\t-----------------";
		return wtr;
	}
	
	
	
	

}