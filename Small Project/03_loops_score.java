import javax.swing.JOptionPane;

/**
 * @author YiTse
 *
 */

public class loops_score
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JOptionPane.showMessageDialog (null, "�ӵ{���b�ϥΪ̿�J���ƫ�A��p��X\n"
										   + "�������ơB�ή�B���ή�H�Ƶ���T\n");
		double score = 0, sum = 0;
		int studentsNum = 0, lower60 = 0, higher60 = 0, judge;
	    do
	    {
	    	while (true)
	    	{
		    	String input = JOptionPane.showInputDialog ("�п�J�@�� 0~100 ������\n�Y��J�d����~�A�h�����s��J!!!");
		    	score = Integer.parseInt (input);
		    	if (score > 100 || score < 0)
		    		continue;
	    		sum += score;
	    		studentsNum++;
	    		if(score >= 60)
	    			higher60 ++;
	    		else if (score >= 0 && score <= 60)
	    			lower60 ++;
	    		judge = JOptionPane.showConfirmDialog(null, "�O�_�~���J����?", "�T�{", JOptionPane.YES_NO_OPTION);
	    		if(judge == 1)
	    			break;
	    	}

	    	if (studentsNum > 0)
	    		JOptionPane.showMessageDialog (null, "�������Ƭ�: "  + (sum / studentsNum) + "\n" +
	    											 "�ή�H�Ƭ�: "  + higher60 + "\n" +
	    											 "���ή�H�Ƭ�: " + lower60);
	    	else
	    		JOptionPane.showMessageDialog (null, "�S���i�p�⪺���");

	    	judge = JOptionPane.showConfirmDialog(null, "�O�_�����ӵ{���O?", "�T�{", JOptionPane.YES_NO_OPTION);

	    	score = sum = studentsNum = lower60 = higher60 = 0;
	    }
	    while (judge == 1);
	}
}
