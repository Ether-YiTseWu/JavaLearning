/**
 * @author YiTse
 */
public class HeaterDemo 
{
	/**
	 * �Ө�Ƭ�main
	 * <p>
	 * �Ψ�����Heater.java�����{���X
	 * @param args �R�O�C�޼�
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
		float num = Heater.getHeaterNum();			// Java ���S�ʡA�i���������O�WHeater���ostatic�ܼ�
		float tempSum = (float)(heater1.getTemp() + heater2.getTemp() + heater3.getTemp());
		System.out.println("�A�o" + (int)num + "�ӥ[�����������ū׬�" + tempSum/num + "��");
	}
}