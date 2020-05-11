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
                "請輸入一個100000以下的數字\n" +
                "該程式能輸出最少的鈔票及硬幣數量\n");
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
        	JOptionPane.showMessageDialog (null, "您輸入的數字為 : " + dollarOrigin + "\n" +
					       "最少的鈔票硬幣數量為 : \n" + 
					       oneThousand + " 個一千元鈔票\n" +
					       fiveHundred + " 個五百元鈔票\n" +
					       oneHundred + " 個一百元鈔票\n" + 
					       fifty + " 個五十元硬幣\n" +
					       ten + " 個十元硬幣\n" +
					       five + " 個五元硬幣\n" +
					       one + " 個一元硬幣\n");
        	System.exit (0);
	}

}
