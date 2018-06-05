package main;

import java.util.Scanner;

public class Power {
	
	public static int pow(int x, int n, int d) {
	    
		//Special Case
		if(x == 0) {
			return 0;
		}
		
	    //Check for negative value, if -ve then should return a positive remainder (e.g -10 % 3 -> 2 not -1)
	    boolean flag = false;
	    if(x < 0) {
	    		flag = true;
	    }
	    
	    if(n == 0) {
	        return 1;
	    }
	    
	    //Recursive call. Problem reduces to n/2 which makes the algo run in longn steps
	    long smallAns = pow(x, n/2, d);
	    long temp = ((smallAns % d) * (smallAns % d))%d;
	    
	    if(n%2 == 0) {
	        	return (int)(temp);
	    } else {
	    		x %= d;
	    		if(flag) {
	    			//converting to positive value (e.g (-10 % 3) = -1, -> -1 + 3 = 2)
	    			x += d;
	    		}
	    		 
	    		return (int)((temp * x) %d);
	    }
	    
	}
	
	public static void main(String[] args) {

//		A : 71045970
//		B : 41535484
//		C : 64735492
//		
//		ex: 20805472

		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int n = s.nextInt();
		int d = s.nextInt();
		s.close();
		
		System.out.println(pow(x, n, d));
		
	}

}

