//дһ������������int�ͣ����������������ַ������磺����123�����ء�321����
// Ҫ������õݹ飬������ȫ�ֱ��������������һ�����������뷵���ַ�����

public class ReserveInt {
	
	public String reserve(int num){
		if (num/10 == 0) return Integer.toString(num);
		return Integer.toString(num%10) + reserve(num/10);		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReserveInt obj = new ReserveInt();
		String str = obj.reserve(123000789);
		System.out.println(str);
	}

}