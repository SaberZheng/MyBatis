package ecut.access.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import ecut.access.po.Role;

public class RoleDaoImpl implements RoleDao{
	
	public SqlSessionFactory factory;
	
	// 需要向dao实现类中注入SqlSessionFactory, 这里通过构造方法注入
	public RoleDaoImpl(SqlSessionFactory factory){
		this.factory = factory;
	}

	@Override
	public Role getRole(Integer id) throws Exception {
		SqlSession session = factory.openSession();
		//执行查询操作
		Role role = session.selectOne("test.getRole", id);
		// 释放资源
		session.close();
		return role;
	}

	@Override
	public List<Role> getRoles(String note) throws Exception {
		SqlSession session = factory.openSession();
		//执行模糊查询操作
		List<Role> roles = session.selectList("test.getRoles", note);
		// 释放资源
		session.close();
		return roles;
	}

	@Override
	public int insertRole(Role r) throws Exception {
		SqlSession session = factory.openSession();
		//执行插入操作
		session.insert("test.insertRole", r);
		//提交事务
		session.commit();
		// 释放资源
		session.close();
		return 0;
	}

	@Override
	public int deleteRole(Integer id) throws Exception {
		SqlSession session = factory.openSession();
		//执行删除操作
		int i = session.delete("test.deleteRole", id);
		//提交事务
		session.commit();
		// 释放资源
		session.close();
		return i;
	}

	@Override
	public int updateRole(Role r) throws Exception {
		SqlSession session = factory.openSession();
		//执行更新操作
		session.update("test.updateRole", r);
		//提交事务
		session.commit();
		// 释放资源
		session.close();
		return 0;
	}

}
