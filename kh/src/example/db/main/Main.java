package example.db.main;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Main {
	public static void main(String[] args) {
		String resource = "db/day4/main/mybatis-config.xml";
		InputStream inputStream;
		try
		{
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			try (SqlSession session = sqlSessionFactory.openSession()) {
				MainController mc = new MainController(session);
				mc.run();
			}
		}catch(
		IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
