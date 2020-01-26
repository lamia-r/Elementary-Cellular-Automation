import java.util.Scanner;

public class CA
{
    // instance variables - replace the example below with your own
    private int numIteration;
    private int ruleNumber;
    public int[] ruleset;

    /**
     * Constructor for objects of class CA
     */
public static void main(String[] args) { 
      Scanner scanner=new Scanner (System.in);
      System.out.println("Please enter the number of iterations: ");
      int iteration=Integer.parseInt(scanner.nextLine());
      System.out.println("Please enter the Rule number: ");
      int ruleNum=Integer.parseInt(scanner.nextLine());
      int n = iteration;
      int numCells = 2 * n;

      int[] cells = new int[numCells];      // cellular automaton at time t
      int[] old   = new int[numCells];      // cellular automaton at time t-1
      cells[numCells/2] = 1;
  
      for (int t = 1; t < n; t++) {

         // draw current row
         for (int i = 0; i < numCells; i++) {
            if(cells[i]==1) System.out.print("*");
            else         System.out.print(" ");
         }
         System.out.println("");

         // save current row
         for (int i = 0; i < numCells; i++)
            old[i] = cells[i];

         // update cells according to rule 90
         int[] nextgen = new int[cells.length];
         for (int i = 1; i < cells.length-1; i++) {
         int left   = cells[i-1];
         int me     = cells[i];
         int right  = cells[i+1];
         nextgen[i] = rules(left, me, right,ruleNum);
         }
         cells = nextgen;
      }
   }


    public static int[] makingRule(int rule)
    {
       int[] temp = new int[8];
       int i = 0;
       while (rule > 0) {
           int divisor = (int) Math.floor(rule/ 2);
           int remainder = rule % 2;
           temp[i] = (int) remainder;
           rule = divisor;
           i++;
       }

       int[] ruleset = new int[8];
       for (int j = 0; j < 8; j++) {
                ruleset[j] = temp[7-j];
            }
         
       return ruleset;
    }
    
    private static int rules (int a, int b, int c, int ruleNum) {
    
    int ruleset[]=makingRule(ruleNum);
    if      (a == 1 && b == 1 && c == 1) return ruleset[0];
    else if (a == 1 && b == 1 && c == 0) return ruleset[1];
    else if (a == 1 && b == 0 && c == 1) return ruleset[2];
    else if (a == 1 && b == 0 && c == 0) return ruleset[3];
    else if (a == 0 && b == 1 && c == 1) return ruleset[4];
    else if (a == 0 && b == 1 && c == 0) return ruleset[5];
    else if (a == 0 && b == 0 && c == 1) return ruleset[6];
    else if (a == 0 && b == 0 && c == 0) return ruleset[7];
    return 0;   }
}
