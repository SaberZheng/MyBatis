package ecut.first.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ecut.first.po.Role;

public class FirstTest {

	private SqlSessionFactory factory;

	
	public @Before void init() throws IOException {
		// mybatis配置文件
		String resource = "ecut/first/mybaits-config.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
	}

	// 根据id查询角色信息，得到一条记录结果
	public @Test void testGetRole() {
		// 通过SqlSession操作数据库
		SqlSession session = factory.openSession();
		// 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
		// 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
		// sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
		// selectOne查询出一条记录
		Role r = session.selectOne("test.getRole", 1);
		System.out.println(r);
		// 释放资源
		session.close();

	}

	// 根据note模糊查询角色列表
	public @Test void testGetRoles() {
		SqlSession session = factory.openSession();
		// list中的role和映射文件中resultType所指定的类型一致
		List<Role> r = session.selectList("test.getRoles", "火影");
		// List<Role> r = session.selectList("test.getRoles", "' or 1=1 or '");
		System.out.println(r);
		// 释放资源
		session.close();

	}
	
	//添加角色信息
	public @Test void testInsertRole() {
		SqlSession session = factory.openSession();
		Role r = new Role();
		r.setRoleName("鸣人");
		r.setNote("火影忍者");
		session.insert("test.insertRole", r);
		// 提交事务
		session.commit();
		// 获取角色信息主键
		System.out.println(r.getId());
		// 释放资源
		session.close();

	}
	
	//根据id删除角色信息
	public @Test void testDeleteRole() {
		SqlSession session = factory.openSession();
		session.delete("test.deleteRole",2);
		session.commit();
		// 释放资源
		session.close();
	}
	
	//更新角色信息
	public @Test void testUpdatRole(){
		SqlSession session = factory.openSession();
		Role r = new Role();
		//必须设置id
		r.setId(1);
		r.setRoleName("鸣人");
		r.setNote("火影忍者");
		session.update("test.updateRole", r);
		session.commit();
		// 释放资源
		session.close();
	}
	

}
