package ecut.reverse.test;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ecut.reverse.mapper.TRoleMapper;
import ecut.reverse.po.TRole;
import ecut.reverse.po.TRoleExample;


public class RoleTest {

	private AbstractApplicationContext container;
	
	private TRoleMapper roleMapper;

	@Before
	public  void init() throws IOException {
		// 指定configuration metadata配置元数据
		String configLocations = "classpath:ecut/**/reverse/applicationContext.xml";
		// 创建spring IOC容器
		container = new ClassPathXmlApplicationContext(configLocations);
		// 从容器中获取的bean实例中获取属性值
		roleMapper = (TRoleMapper) container.getBean("TRoleMapper", TRoleMapper.class);
	}

	//根据主键删除 
	@Test
	public void testDeleteByPrimaryKey() {
		roleMapper.deleteByPrimaryKey(8);
	}

	//插入
	@Test
	public void testInsert() {
		//构造 角色对象
		TRole role = new TRole();
		role.setRoleName("路飞");
		role.setNote("海贼王");
		role.setComicId(2);
		roleMapper.insert(role);
	}

	//自定义条件查询
	@Test
	public void testSelectByExample() {
		TRoleExample roleExample = new TRoleExample();
		//通过criteria构造查询条件
		TRoleExample.Criteria criteria = roleExample.createCriteria();
		criteria.andComicIdEqualTo(2);
		criteria.andIdGreaterThanOrEqualTo(2);
		//可能返回多条记录
		List<TRole> list = roleMapper.selectByExample(roleExample);
		
		for(TRole r:list){
			System.out.println("id="+r.getId()+",roleName="+r.getRoleName()+",note="+r.getNote()+",comicId="+r.getComicId());
		}
	}

	//根据主键查询
	@Test
	public void testSelectByPrimaryKey() {
		TRole role = roleMapper.selectByPrimaryKey(1);
		System.out.println("id="+role.getId()+",roleName="+role.getRoleName()+",note="+role.getNote()+",comicId="+role.getComicId());
	}

	//更新数据
	@Test
	public void testUpdateByPrimaryKey() {
		
		//对所有字段进行更新，需要先查询出来再更新
		TRole role = roleMapper.selectByPrimaryKey(8);
		
		role.setComicId(3);;
		//没有非空判断
		roleMapper.updateByPrimaryKey(role);
		//如果传入字段不空为才更新，在批量更新中使用此方法，不需要先查询再更新
		//roleMapper.updateByPrimaryKeySelective(record);
		
	}
	
	@After
	public void destroy(){
		// 关闭spring的IOC容器
		container.close();
	}

}
