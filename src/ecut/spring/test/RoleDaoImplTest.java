package ecut.spring.test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecut.spring.dao.RoleDao;
import ecut.spring.po.Role;


public class RoleDaoImplTest {
	
	private AbstractApplicationContext container;
	
	private RoleDao roleDao;
	
	@Before
	public  void init() throws IOException {
		// 指定configuration metadata配置元数据
		String configLocations = "classpath:ecut/**/spring/applicationContext.xml";
		// 创建spring IOC容器
		container = new ClassPathXmlApplicationContext(configLocations);
		roleDao = (RoleDao) container.getBean("roleDao", RoleDao.class);
	}

	@Test
	public void testGetRole() throws Exception {
		// 从容器中获取的bean实例中获取属性值
		Role role = roleDao.getRole(1);
		System.out.println(role);
		
	}
	
	@After
	public void destroy(){
		// 关闭spring的IOC容器
		container.close();
	}
}
