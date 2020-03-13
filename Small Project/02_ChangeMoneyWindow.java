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
                "�п�J�@��100000�H�U���Ʀr\n" +
                "�ӵ{�����X�̤֪��r���εw���ƶq\n");
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
        		"�z��J���Ʀr�� : " + dollarOrigin + "\n" +
        		"�̤֪��r���w���ƶq�� : \n" + 
        		oneThousand + " �Ӥ@�d���r��\n" +
        		fiveHundred + " �Ӥ��ʤ��r��\n" +
        		oneHundred + " �Ӥ@�ʤ��r��\n" + 
        		fifty + " �Ӥ��Q���w��\n" +
        		ten + " �ӤQ���w��\n" +
        		five + " �Ӥ����w��\n" +
        		one + " �Ӥ@���w��\n");
        System.exit (0);

	}

}
