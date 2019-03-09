package ecut.access.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ecut.access.dao.RoleDao;
import ecut.access.dao.RoleDaoImpl;
import ecut.access.po.Role;

public class RoleDaoImplTest {
	
	private SqlSessionFactory factory;

	@Before
	public  void init() throws IOException {
		// mybatis配置文件
		String resource = "ecut/access/mybaits-config.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
	}

	@Test
	public void testGetRole() throws Exception {
		//创建RoleDao对象
		RoleDao roleDao = new RoleDaoImpl(factory);
		//调用RoleDao方法
		Role role = roleDao.getRole(1);
		System.out.println(role);
		
		
	}

	@Test
	public void testGetRoles() throws Exception {
		RoleDao roleDao = new RoleDaoImpl(factory);
		List<Role> roles = roleDao.getRoles("火影");
		System.out.println(roles);
	}

	@Test
	public void testInsertRole() throws Exception {
		RoleDao roleDao = new RoleDaoImpl(factory);
		Role role = new Role();
		role.setNote("火影忍者");
		role.setRoleName("小樱");
		roleDao.insertRole(role);
	}

	@Test
	public void testDeleteRole() throws Exception {
		RoleDao roleDao = new RoleDaoImpl(factory);
		roleDao.deleteRole(4);
		
	}

	@Test
	public void testUpdateRole() throws Exception {
		RoleDao roleDao = new RoleDaoImpl(factory);
		Role role = new Role();
		role.setId(3);
		role.setNote("火影忍者");
		role.setRoleName("小樱");
		roleDao.updateRole(role);
		
	}

}
