package ecut.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import ecut.spring.po.Role;

public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao{
	//  SqlSessionDaoSupport有方法setSqlSessionFactory
	
	@Override
	public Role getRole(Integer id) throws Exception {
		//继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSessoin
		SqlSession session =this.getSqlSession();
		//执行查询操作
		Role role = session.selectOne("test.getRole", id);
		// Spring 管理资源，使用完会自动关闭，释放资源
		return role;
	}

}
