package ecut.access.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ecut.access.mapper.RoleMapper;
import ecut.access.po.Role;

public class RoleMapperTest {
	
	private SqlSessionFactory factory;

	
	@Before
	public  void init() throws IOException {
		// mybatis配置文件
		String resource = "ecut/access/mybaits-config.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactoryBuilder builer =new SqlSessionFactoryBuilder();
		factory = builer.build(inputStream);
		// 通过工厂得到SqlSession
	}

	@Test
	public void testGetRole() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		//class com.sun.proxy.$Proxy6,roleMapper代理对象
		System.out.println(roleMapper.getClass());
		Role role = roleMapper.getRole(1);
		System.out.println(role);
	}
	
 
	@Test
	public void testGetRoles() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		List<Role> roles = roleMapper.getRoles("火影");
		System.out.println(roles);
	}

	@Test
	public void testGetRolesByNameAndNote() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		List<Role> roles = roleMapper.getRolesByNameAndNote("火影","");
		System.out.println(roles);
	}
	
	/*@Test
	public void testGetRolesByNameAndNote() throws Exception{
		Role role = new Role();
		role.setNote("火影忍者");
		role.setRoleName("鸣人");
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		List<Role> roles = roleMapper.getRolesByNameAndNote(role);
		System.out.println(roles);
	}
	*/

	@Test
	public void testGetRolesByIds() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		List<Role> roles = roleMapper.getRolesByIds(ids);
		System.out.println(roles);
	}

	
	@Test
	public void testInsertRole() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		Role role = new Role();
		role.setNote("火影忍者");
		role.setRoleName("小樱");
		roleMapper.insertRole(role);
		session.commit();
	}

	@Test
	public void testDeleteRole() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		roleMapper.deleteRole(4);
		session.commit();
	}

	@Test
	public void testUpdateRole() throws Exception{
		SqlSession session = factory.openSession();
		//创建RoleMapper对象，mybaits自动生成的mapper代理对象
		RoleMapper roleMapper = session.getMapper(RoleMapper.class);
		Role role = new Role();
		role.setId(3);
		role.setNote("火影忍者");
		role.setRoleName("小樱");
		roleMapper.updateRole(role);
		session.commit();
	}

}
