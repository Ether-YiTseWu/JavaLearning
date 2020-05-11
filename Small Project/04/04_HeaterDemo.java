/**
 * @author YiTse
 */
public class HeaterDemo 
{
	/**
	 * 該函數為main
	 * <p>
	 * 用來驗證Heater.java中的程式碼
	 * @param args 命令列引數
	 */
	public static void main(String[] args) 
	{
		Heater heater1 = new Heater("H01", 0, 150);
		Heater heater2 = new Heater("H02", -100, 40, 36, 10);
		Heater heater3 = new Heater("H03", -200, 200, 160, 1);
		
		heater1.printTemp();
		heater1.warmer();
		heater1.setIncrement(100);
		heater1.cooler();
		
		heater2.printTemp();
		heater2.cooler();
		
		heater3.printTemp();
		heater3.setIncrement(10);
		for (int i = 0; i<5 ; i++)
			heater3.warmer();
		
		heater1.printHeaterNum();
		float num = Heater.getHeaterNum();			// Java 的特性，可直接用類別名Heater取得static變數
		float tempSum = (float)(heater1.getTemp() + heater2.getTemp() + heater3.getTemp());
		System.out.println("，這" + (int)num + "個加熱器的平均溫度為" + tempSum/num + "度");
	}
}