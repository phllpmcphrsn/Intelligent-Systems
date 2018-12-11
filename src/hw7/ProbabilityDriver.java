package hw7;
/******************************************************************************
 * CS-701 Assignment 7: Conditional Probability
 * This program is modeled after Harry Sudden's Probability Tree for Medical 
 * Interpretation 
 * (http://www.harrysurden.com/projects/visual/Probability_Tree_D3/Probability_Tree_D3.html).
 * It will figure out the conditional probability of two given events.
 * @author phllp
 */
import java.text.DecimalFormat;

public class ProbabilityDriver {

	public static void main(String[] args) {
		Event A = new Event("Population who have a disease", 0.8f);
		Event notA = new Event("Population who do not have a disease", A.negate());
		Event B = new Event(0.6f);
		Event notB = new Event(B.negate());

		//using DecimalFormat to format the output of printed decimal values 
		DecimalFormat df = new DecimalFormat("0.##");
		DecimalFormat df2 = new DecimalFormat("0.0000");
		
		System.out.println("Medical Interpretation\n");
		System.out.println(A.toString());
		System.out.println(notA.toString());
		System.out.println("Test Sensitivity (True Positive Rate): " + df.format(condProb(A,B)*100) + "%");
		System.out.println("Test Specificity (True Negative Rate): " + df.format(condProb(notA, notB)*100) + "%\n");
		System.out.println("Probability of Having Disease Given Positive Test Result: " + df.format(condProb(B, A)*100) + "%\n");

		System.out.println("P(A|not_B) |" + df2.format(condProb(A, notB)));
		System.out.println("P(A&B      |" + df2.format(and(A, B)));
		System.out.println("P(A&not_B) |" + df2.format(and(A, notB)));
		
		System.out.println("P(not_A|B) |" + df2.format(condProb(notA, B)));
		System.out.println("P(not_A&B) |" + df2.format(and(notA, B)));
		System.out.println("P(not_A&B) |" + df2.format(and(notA, notB)));
		
		
		System.out.println();
		
	}

	public static float and(Event A, Event B) {
		return A.getProbability() * B.getProbability();
	}
	
	/************************************************************
	 * Conditional probability is given by P(A&B)/P(A)
	 * @param A
	 * @param B
	 * @return 
	 */
	public static float condProb(Event A, Event B) {
		return and(A, B)/A.getProbability();
	}
	
}
