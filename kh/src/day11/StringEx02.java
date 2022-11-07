package day11;


public class StringEx02 {

	public static void main(String[] args) {
		/* 문자열 str에 search가 몇번 등장하는지 확인하는 코드를 작성하세요*/
		String str = "Hello world! My name is Hong ooo";
		String search = "oo";
		
		//str에서 search가 있는 위치를 찾음
		//-1이 아니면 부분문자열을 추출
		String tmp = str;
		int count = 0;
		while(true) {
			System.out.println(tmp);
			int index = tmp.indexOf(search);
			if(index == -1) { // else를 안써도 동일하게 동작함
				break;
			}
			tmp = tmp.substring(index+ search.length()); // 더하기 얘를 안하면 무한루프함
			//현재위치부터 부분문자열을 계속 추출함 // 한번두번이 아니라 한번 찾는거로 끝나야해서 해당글자만큼 더해야함
			//일반적으로 많이씀
			count++;
		}
		System.out.println(str+"에는 " + search +"가"+count+"번 있습니다.");

		
	}

}
//내가 작성한코드
//for (int i = 0; i < str.length(); i++) {
//	 int index = str.indexOf(search);
//	 if(index != -1) {
//		 str.substring(index);
//		 count++;
//	 }else {
//		 break;
//	 }
//}