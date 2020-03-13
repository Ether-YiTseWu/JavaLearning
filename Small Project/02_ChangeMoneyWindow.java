/**
 * <h1> Change Money Window </h1>
 * @ author YiTse Wu
 * @ since 2020-3-12
 */
import javax.swing.JOptionPane;
public class ChangeMoneyWindow {
	public static void main(String[] args) 
	{
		// Setup
		String amountString = JOptionPane.showInputDialog (
                "叫块100000计\n" +
                "赣祘Α块程ぶ秗布の祑刽计秖\n");
		int dollar, dollarOrigin, one, five, ten, fifty, oneHundred, fiveHundred, oneThousand;
		dollar = Integer.parseInt (amountString);
		dollarOrigin = dollar;
		
		// Compute
		oneThousand = dollar/1000;
		fiveHundred = dollar%1000/500;
		oneHundred = dollar%500/100;
		fifty = dollar%100/50;
		ten = dollar%50/10;
		five = dollar%10/5;
		one = dollar%5/1;
		
		// Show
        JOptionPane.showMessageDialog (null,
        		"眤块计 : " + dollarOrigin + "\n" +
        		"程ぶ秗布祑刽计秖 : \n" + 
        		oneThousand + " じ秗布\n" +
        		fiveHundred + " きκじ秗布\n" +
        		oneHundred + " κじ秗布\n" + 
        		fifty + " きじ祑刽\n" +
        		ten + " じ祑刽\n" +
        		five + " きじ祑刽\n" +
        		one + " じ祑刽\n");
        System.exit (0);

	}

}
