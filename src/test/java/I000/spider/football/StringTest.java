package I000.spider.football;

public class StringTest {

	public static void main(String[] args) {
		String str = "当前期14088期";
		String str2 = str.substring(3);
		System.out.println(str2.subSequence(0, str2.length()-1));
	}
}
