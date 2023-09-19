package juhyun.yun.db.manager;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class YunDBManager {
	private SqlSessionFactory ssf;

	private static final YunDBManager YDBM = new YunDBManager();

	private YunDBManager() {
	}

	public static YunDBManager getYdbm() {
		return YDBM;
	}

	public void setSqlSessionFactory(String cfgFile) {
		try {
			InputStream is = Resources.getResourceAsStream(cfgFile);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(is);
		} catch (IOException e) {
		}
	}

	public SqlSession connect() {
		return ssf.openSession();
	}
}
