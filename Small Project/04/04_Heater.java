/**
 * @author YiTse
 */
public class Heater
{
	private static int heaterNum = 0;
	private String heaterName;
	private int nowTemp, maxTemp, minTemp, increment;
	
	/**
	 * Heater���غc�l�A�H�h������
	 * <p>
	 * ��Heater�ѼƦ��T��
	 * @param name Heater���W��
	 * @param min Heater���̤p�Ө��ū�
	 * @param max Heater���̤j�Ө��ū�
	 */
	public Heater(String name, int min, int max)
	{
		heaterName = name;
		minTemp = min;
		maxTemp = max;
		nowTemp = 15;
		increment = 5;
		System.out.println ("�ӥ[�����W�٬� " + heaterName + "�A�{�b���ū׬�" + nowTemp + "��" +
							"�A�ӥ[�����̧C���Ө��ū׬O " + minTemp + "��" +
							"�A�̰����Ө��ū׬O " + maxTemp + "��" +
							"�A�ӥ[�����@���վ� " + increment + "��\n");
		heaterNum++;
	}
	
	/**
	 * Heater���غc�l�A�H�h������
	 * <p>
	 * ��Heater�ѼƦ�����
	 * @param name Heater���W��
	 * @param min Heater���̤p�Ө��ū�
	 * @param max Heater���̤j�Ө��ū�
	 * @param now Heater�ثe���ū�
	 * @param incre Heater�@���ק諸�ūפj�p
	 */
	public Heater(String name, int min, int max, int now, int incre)
	{
		heaterName = name;
		minTemp = min;
		maxTemp = max;
		nowTemp = now;
		increment = incre;
		System.out.println ("�ӥ[�����W�٬� " + heaterName + "�A�{�b���ū׬�" + nowTemp + "��" +
							"�A�ӥ[�����̧C���Ө��ū׬O " + minTemp + "��" +
							"�A�̰����Ө��ū׬O " + maxTemp + "��" +
							"�A�ӥ[�����@���վ� " + increment + "��\n");
		heaterNum++;
	}
	
	/**
	 * printTemp�C�L�XHeater�{�b���ū�
	 * <p>
	 * printTemp�L�Ѽ�
	 */
	public void printTemp()
	{
		System.out.println (heaterName + "�ثe���ū׬O" + nowTemp + "��\n");
	}
	/**
	 * printHeaterNum�C�L�XHeater���ƶq
	 * <p>
	 * printHeaterNum�L�Ѽ�
	 */
	public void printHeaterNum()
	{
		System.out.print ("�ثe��" + heaterNum + "�ӥ[����");
	}
	/**
	 * setIncrement��]�wHeater�@���վ�h�ַū�
	 * <p>
	 * setIncrement���@�ӰѼ�
	 * @param incre Heater�@���վ�h�ַū�
	 */
	public void setIncrement(int incre)
	{
		increment = incre;
		System.out.println ("���ܷū׽վ���A" + heaterName + "�@����վ� " + increment + "��\n");
	}
	/**
	 * getTemp����o�ثeHeater���ū�
	 * <p>
	 * getTemp�L�ѼơA���Ӧ^�ǭ�
	 * @return nowTemp �^�ǥثeHeater���ū�
	 */
	public int getTemp()
	{
		return nowTemp;
	}
	/**
	 * getHeaterNum����oHeater���ƶq
	 * <p>
	 * getHeaterNum�L�ѼơA���Ӧ^�ǭ�
	 * @return heaterNum �^��Heater���ƶq
	 */
	public static int getHeaterNum()
	{
		return heaterNum;
	}
	/**
	 * limitTemp�୭��[���ΧN�o���ūצbHeater���e�Խd��
	 * <p>
	 * limitTemp���@�ӰѼơA���Ӧ^�ǭ�
	 * @param afterTemp Heater�[���ΧN�o�᪺�ū�
	 * @return 0or1 �^��0��1
	 */
	public int limitTemp(int afterTemp)
	{
		if (afterTemp <= maxTemp && afterTemp >= minTemp)
			return 0;
		else if (afterTemp > maxTemp)
			System.out.print ("�W�L�̰��ūש�!!!�ū׽վ�L�ġA");
		else if (afterTemp < minTemp)
			System.out.print ("�C��̧C�ūש�!!!�ū׽վ�L�ġA");
		return 1;
	}	
	/**
	 * cooler�୰�C�ū�
	 * <p>
	 * cooler�L�Ѽ�
	 */
	public void cooler()
	{
		System.out.print(heaterName + "���� " + increment + "�סA");
		nowTemp -= increment;
		int judge = limitTemp(nowTemp);
		if (judge == 0)
			System.out.println ("�ثe���ū׬O" + nowTemp + "��\n");
		else
		{
			nowTemp += increment;
			System.out.println (heaterName + "�ثe���ū׬O" + nowTemp + "��\n");
		}
	}
	/**
	 * warmer��ɰ��ū�
	 * <p>
	 * warmer�L�Ѽ�
	 */
	public void warmer()
	{
		System.out.print(heaterName + "�W�� " + increment + "�סA");
		nowTemp += increment;
		int judge = limitTemp(nowTemp);
		if (judge == 0)
			System.out.println ("�ثe���ū׬O" + nowTemp + "��\n");
		else
		{
			nowTemp -= increment;
			System.out.println (heaterName + "�ثe���ū׬O" + nowTemp + "��\n");
		}
	}
}