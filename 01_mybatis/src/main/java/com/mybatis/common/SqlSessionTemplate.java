package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	public static SqlSession getSession() {
		SqlSession session=null;
		String fileName = "mybatis-config.xml";
		try {
			//sqlSession 객체 생성하기
			//1. SqlSessionFactoryBuilder클래스의 build() 메소드를 호출
			//	build() 호출하면 SqlSessionFactory객체를 생성한다.
			//	build()는 매개변수로 config.xml파일을 받는다.
			InputStream is = Resources.getResourceAsStream(fileName);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			session = ssf.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
}
