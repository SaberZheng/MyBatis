package ecut.association.mapper;

import java.util.List;

import ecut.association.po.Comic;
import ecut.association.po.Role;
import ecut.association.po.RoleComic;

public interface RoleMapperComic {
	
	//查询角色信息，关联查询所属动漫信息,使用resultType
	public List<RoleComic>  findRoleComicsByResultType() throws Exception ;

	//查询角色信息，关联查询所属动漫信息,使用resultMap
	public List<Role>  findRoleComicsByResultMap() throws Exception ;
	
	//查询动漫信息。关联查询动漫中的角色
	public List<Comic> findComics() throws Exception ;
	
	//查询动漫信息。关联查询动漫中的角色及配音演员信息
	public List<Comic> findComicsAndDubber() throws Exception ;
	
	//根据id查询动漫
	public Comic findComicById(Integer id) throws Exception ;
	
	//查询角色信息，关联查询所属动漫信息,使用resultMap和延迟加载
	public List<Role> findRoleComicsByLazyLoading()  throws Exception ;

	//根据id更新动漫
	public int updateComic(Comic comic) throws Exception;
}
