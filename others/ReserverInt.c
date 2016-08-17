//写一个函数，输入int型，返回整数逆序后的字符串。如：输入123，返回“321”。
// 要求必须用递归，不能用全局变量，输入必须是一个参数，必须返回字符串。

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