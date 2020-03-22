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
	    JOptionPane.showMessageDialog (null, "該程式在使用者輸入分數後，能計算出\n" + 
					         "平均分數、及格、不及格人數等資訊\n");
	    double score = 0, sum = 0;
	    int studentsNum = 0, lower60 = 0, higher60 = 0, judge;
	    do
	    {
	    	while (true)
	    	{
		    String input = JOptionPane.showInputDialog ("請輸入一個 0~100 的分數\n若輸入範圍錯誤，則須重新輸入!!!");
		    score = Integer.parseInt (input);
		    if (score > 100 || score < 0)
			continue;
	    	    sum += score;
	    	    studentsNum++;
	    	    if (score >= 60)
			higher60 ++;
	    	    else if (score >= 0 && score <= 60)
	    		lower60 ++;
	    	    judge = JOptionPane.showConfirmDialog(null, "是否繼續輸入分數?", "確認", JOptionPane.YES_NO_OPTION);
	    	    if(judge == 1)
	    		break;
	    	}

	    	if (studentsNum > 0)
	    	    JOptionPane.showMessageDialog (null, "平均分數為: "  + (sum / studentsNum) + "\n" + 
						         "及格人數為: "  + higher60 + "\n" + 
						         "不及格人數為: " + lower60);
	    	else
	    	    JOptionPane.showMessageDialog (null, "沒有可計算的資料");

	    	judge = JOptionPane.showConfirmDialog(null, "是否結束該程式呢?", "確認", JOptionPane.YES_NO_OPTION);
		
	    	score = sum = studentsNum = lower60 = higher60 = 0;
	    }
	    while (judge == 1);
	}
}
