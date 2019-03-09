package ecut.association.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ecut.association.mapper.RoleMapperComic;
import ecut.association.po.Comic;
import ecut.association.po.Role;
import ecut.association.po.RoleComic;

public class RoleMapperComicTest {
	
	private SqlSessionFactory factory;

	
	@Before
	public  void init() throws IOException {
		String resource = "ecut/association/mybaits-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builer =new SqlSessionFactoryBuilder();
		factory = builer.build(inputStream);
	}
	
	@Test
	public void testFindRoleComicsByResultType() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		List<RoleComic> roleComics = mapper.findRoleComicsByResultType();
		System.out.println(roleComics);
	}
	
	
	@Test
	public void testFindRoleComicsByResultMap() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		List<Role> roleComics = mapper.findRoleComicsByResultMap();
		System.out.println(roleComics);
	}
	

	@Test
	public void testFindComics() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		List<Comic> comics = mapper.findComics();
		for(Comic c : comics){
			String s = "动漫信息：id="+c.getId()+",comicName="+c.getComicName()+",remark="+c.getRemark();
			System.out.println(s);
			for(Role r:c.getRoles()){
				System.out.println("角色信息：id =" + r.getId() + ",roleName =" + r.getRoleName() + ", note = " + r.getNote()+", comicId = " + r.getComicId());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
	
	@Test
	public void testFindComicsAndDubber() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		List<Comic> comics = mapper.findComicsAndDubber();
		for(Comic c : comics){
			String s = "动漫信息：id="+c.getId()+",comicName="+c.getComicName()+",remark="+c.getRemark();
			System.out.println(s);
			for(Role r:c.getRoles()){
				System.out.println("角色信息：id =" + r.getId() + ",roleName =" + r.getRoleName() + ", note = " + r.getNote()+", comicId = " + r.getComicId());
				System.out.println("配音演员信息：id =" + r.getDubber().getId()+ ",dubberName =" + r.getDubber().getDubberName() + ", roleId = " + r.getDubber().getRoleId());
			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}
	
	
	@Test
	public void testFindComicById() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		Comic comic = mapper.findComicById(1);
		System.out.println("动漫信息：id="+comic.getId()+",comicName="+comic.getComicName()+",remark="+comic.getRemark());
	
	}
    
	@Test
	public void testFindRoleComicsByLazyLoading() throws Exception {
		SqlSession session = factory.openSession();
		RoleMapperComic  mapper =  session.getMapper(RoleMapperComic.class);
		List<Role> roleComics = mapper.findRoleComicsByLazyLoading();
		//执行getComic()去查询动漫信息，这里实现按需懒加载
		System.out.println(roleComics);
	}
	

	// 一级缓存测试
	@Test
	public void testCache1() throws Exception {
		SqlSession session = factory.openSession();// 创建代理对象
		RoleMapperComic mapper = session.getMapper(RoleMapperComic.class);

		// 下边查询使用一个SqlSession
		// 第一次发起请求，查询id为1的动漫
		Comic comic1 = mapper.findComicById(1);
		System.out.println("动漫信息：id="+comic1.getId()+",comicName="+comic1.getComicName()+",remark="+comic1.getRemark());

		// 如果session去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。

		/*// 更新comic1的信息
		 comic1.setComicName("fate");
		 mapper.updateComic(comic1);
		 //执行commit操作去清空缓存
		 session.commit();*/

		// 第二次发起请求，查询id为1的动漫
		Comic comic2 = mapper.findComicById(1);
		System.out.println("动漫信息：id="+comic2.getId()+",comicName="+comic2.getComicName()+",remark="+comic2.getRemark());

		session.close();

	}

	// 二级缓存测试
	@Test
	public void testCache2() throws Exception {
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		SqlSession session3 = factory.openSession();
		// 创建代理对象
		RoleMapperComic mapper1 = session1.getMapper(RoleMapperComic.class);
		// 第一次发起请求，查询id为1的动漫
		Comic comic1 = mapper1.findComicById(1);
		System.out.println("动漫信息：id="+comic1.getId()+",comicName="+comic1.getComicName()+",remark="+comic1.getRemark());
		
		//这里执行关闭操作，将session中的数据写到二级缓存区域
		session1.close();
		
		
		//使用session3执行commit()操作
		RoleMapperComic mapper3 = session3.getMapper(RoleMapperComic.class);
		Comic comic  = mapper3.findComicById(1);
		comic.setComicName("fate");
		mapper3.updateComic(comic);
		//执行提交，清空RoleMapperComic下边的二级缓存
		session3.commit();
		session3.close();
		
		

		RoleMapperComic mapper2 = session2.getMapper(RoleMapperComic.class);
		// 第二次发起请求，查询id为1的动漫
		Comic comic2 = mapper2.findComicById(1);
		System.out.println("动漫信息：id="+comic2.getId()+",comicName="+comic2.getComicName()+",remark="+comic2.getRemark());

		session2.close();

	} 
	
}
