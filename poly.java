package practice;
public class LinkedPolynomial {
    private Node first = new Node(0, 0);  // sentinel
    private Node last  = first;

    private static class Node {
        int coef;
        int exp;
        Node next;
        Node(int coef, int exp) {
            this.coef = coef;
            this.exp  = exp;
        }
    }

    // 0    
    private LinkedPolynomial() { }

    // a * x^b
    public LinkedPolynomial(int coef, int exp) {
        last.next = new Node(coef, exp);
        last = last.next;
    }

    // return c = a + b
    public LinkedPolynomial plus(LinkedPolynomial b) {
        LinkedPolynomial a = this;
        LinkedPolynomial c = new LinkedPolynomial();
        Node x = a.first.next;
        Node y = b.first.next;
        while (x != null || y != null) {
            Node t = null;
            if(x == null)
            {
            	t = new Node(y.coef, y.exp);
            	y = y.next; 
           	}
            else if(y == null)
            {
            	t = new Node(x.coef, x.exp);
            	x = x.next; 
            	}
            else if (x.exp > y.exp) 
            {
            	t = new Node(x.coef, x.exp); 
            	x = x.next;
            	} 
            else if (x.exp < y.exp) {
            	t = new Node(y.coef, y.exp);  
            	y = y.next; 
            	} 

            else {
                int coef = x.coef + y.coef;
                int exp  = x.exp;
                x = x.next;
                y = y.next;
                if (coef == 0) continue;
                t = new Node(coef, exp);
            }
        
            c.last.next = t;
            c.last = c.last.next;
        }
        return c;
    }




public static void display(LinkedPolynomial a) {
	
    
    for (Node x = a.first.next; x != null; x = x.next) {
        
    	System.out.print( x.coef +  "x^" + x.exp + " " );
    }
    
    
}
public static int count(LinkedPolynomial a) {
	int count = 0;
    
    for (Node x = a.first.next; x != null; x = x.next) {
        
    	count++;
    }
    return count;
    
}
public static int maxdegree(LinkedPolynomial a) {
	int count = 0;
    
    for (Node x = a.first.next; x != null; x = x.next) {
        
    	if(count < x.exp) {
    		count = x.exp;
    	}
    }
    return count;
    
}
    // test client
    public static void main(String[] args) { 

        LinkedPolynomial p1   = new LinkedPolynomial(4, 3);
        LinkedPolynomial p2   = new LinkedPolynomial(3, 2);
        LinkedPolynomial p3   = new LinkedPolynomial(1, 0);
        LinkedPolynomial p4   = new LinkedPolynomial(2, 1);
        LinkedPolynomial p    = p1.plus(p2).plus(p3).plus(p4);   // 4x^3 + 3x^2 + 1

        LinkedPolynomial q1   = new LinkedPolynomial(3, 2);
        LinkedPolynomial q2   = new LinkedPolynomial(5, 0);
        LinkedPolynomial q    = q1.plus(q2);                     // 3x^2 + 5
        LinkedPolynomial r    = p.plus(q);
        display(p);
        System.out.println("");
        System.out.println("Term counts " + count(p));
        System.out.println("max degree" + maxdegree(p));
        System.out.println("");
        display(q);
        System.out.println("");
        System.out.println("Term counts " + count(q));
        System.out.println("max degree" + maxdegree(q));
        System.out.println("");
        display(r);
        System.out.println("");
        System.out.println("Term counts " + count(r));
        System.out.println("max degree " + maxdegree(r));
        System.out.println("");

   }

}
