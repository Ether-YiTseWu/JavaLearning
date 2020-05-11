/**
 * @author YiTse
 */
public class Heater
{
	private static int heaterNum = 0;
	private String heaterName;
	private int nowTemp, maxTemp, minTemp, increment;
	
	/**
	 * Heater篶更暗ぇ
	 * <p>
	 * 赣Heater把计Τ
	 * @param name Heater嘿
	 * @param min Heater程┯放
	 * @param max Heater程┯放
	 */
	public Heater(String name, int min, int max)
	{
		heaterName = name;
		minTemp = min;
		maxTemp = max;
		nowTemp = 15;
		increment = 5;
		System.out.println ("赣荐竟嘿 " + heaterName + "瞷放" + nowTemp + "" +
							"赣荐竟程┯放琌 " + minTemp + "" +
							"程蔼┯放琌 " + maxTemp + "" +
							"赣荐竟Ω秸俱 " + increment + "\n");
		heaterNum++;
	}
	
	/**
	 * Heater篶更暗ぇ
	 * <p>
	 * 赣Heater把计Τき
	 * @param name Heater嘿
	 * @param min Heater程┯放
	 * @param max Heater程┯放
	 * @param now Heaterヘ玡放
	 * @param incre HeaterΩэ放
	 */
	public Heater(String name, int min, int max, int now, int incre)
	{
		heaterName = name;
		minTemp = min;
		maxTemp = max;
		nowTemp = now;
		increment = incre;
		System.out.println ("赣荐竟嘿 " + heaterName + "瞷放" + nowTemp + "" +
							"赣荐竟程┯放琌 " + minTemp + "" +
							"程蔼┯放琌 " + maxTemp + "" +
							"赣荐竟Ω秸俱 " + increment + "\n");
		heaterNum++;
	}
	
	/**
	 * printTempHeater瞷放
	 * <p>
	 * printTemp礚把计
	 */
	public void printTemp()
	{
		System.out.println (heaterName + "ヘ玡放琌" + nowTemp + "\n");
	}
	/**
	 * printHeaterNumHeater计秖
	 * <p>
	 * printHeaterNum礚把计
	 */
	public void printHeaterNum()
	{
		System.out.print ("ヘ玡Τ" + heaterNum + "荐竟");
	}
	/**
	 * setIncrement砞﹚HeaterΩ秸俱ぶ放
	 * <p>
	 * setIncrementΤ把计
	 * @param incre HeaterΩ秸俱ぶ放
	 */
	public void setIncrement(int incre)
	{
		increment = incre;
		System.out.println ("э跑放秸俱虫" + heaterName + "Ω秸俱 " + increment + "\n");
	}
	/**
	 * getTemp莉眔ヘ玡Heater放
	 * <p>
	 * getTemp礚把计Τ肚
	 * @return nowTemp 肚ヘ玡Heater放
	 */
	public int getTemp()
	{
		return nowTemp;
	}
	/**
	 * getHeaterNum莉眔Heater计秖
	 * <p>
	 * getHeaterNum礚把计Τ肚
	 * @return heaterNum 肚Heater计秖
	 */
	public static int getHeaterNum()
	{
		return heaterNum;
	}
	/**
	 * limitTemp荐┪玱放Heater甧г絛瞅ず
	 * <p>
	 * limitTempΤ把计Τ肚
	 * @param afterTemp Heater荐┪玱放
	 * @return 0or1 肚0┪1
	 */
	public int limitTemp(int afterTemp)
	{
		if (afterTemp <= maxTemp && afterTemp >= minTemp)
			return 0;
		else if (afterTemp > maxTemp)
			System.out.print ("禬筁程蔼放┰!!!放秸俱礚");
		else if (afterTemp < minTemp)
			System.out.print ("程放┰!!!放秸俱礚");
		return 1;
	}	
	/**
	 * cooler放
	 * <p>
	 * cooler礚把计
	 */
	public void cooler()
	{
		System.out.print(heaterName + "放 " + increment + "");
		nowTemp -= increment;
		int judge = limitTemp(nowTemp);
		if (judge == 0)
			System.out.println ("ヘ玡放琌" + nowTemp + "\n");
		else
		{
			nowTemp += increment;
			System.out.println (heaterName + "ヘ玡放琌" + nowTemp + "\n");
		}
	}
	/**
	 * warmerど蔼放
	 * <p>
	 * warmer礚把计
	 */
	public void warmer()
	{
		System.out.print(heaterName + "糤放 " + increment + "");
		nowTemp += increment;
		int judge = limitTemp(nowTemp);
		if (judge == 0)
			System.out.println ("ヘ玡放琌" + nowTemp + "\n");
		else
		{
			nowTemp -= increment;
			System.out.println (heaterName + "ヘ玡放琌" + nowTemp + "\n");
		}
	}
}