package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
// map은 향상된 for문을 사용할수 없다. map은 get은 다르다 키 값을주면 그 키값의 맞는 값을 가져오는거지 전체값을 가져오는게 안됨
public class MapEx01 {
	public static void main(String[] args) {
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "pw1"); //아이디는 중복확인하고 비밀번호는 중복확인
		// map 은 key 아이디 처럼 중복되면 안되고 value 은 비밀번호 같이 생각하기
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");
		userList.put("id3", "pw3"); //새로추가가 되는게 아니라 기존값을 덮어쓰기함
	
		//방법 1. keySet을 이용
		//keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for (String tmp : keySet) {
			System.out.println(tmp + ":" + userList.get(tmp));
		}
		
		System.out.println();
		
		//방법 2. EntrySet을 이용
		// map 의 객체 하나 객체 하나 set에 저장함
		Set<Entry<String,String>> entrySet = userList.entrySet();
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry);
		}
	}
}
