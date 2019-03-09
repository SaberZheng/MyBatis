package ecut.access.dao;

import java.util.List;

import ecut.access.po.Role;

public interface RoleDao {
	
	//根据id获取角色
	public Role getRole(Integer id) throws Exception ;
	
	// 根据note模糊查询角色列表
	public List<Role> getRoles(String note )  throws Exception ;
	
	//添加角色信息
	public int insertRole(Role r)  throws Exception ;
	
	//根据id删除角色信息
	public int deleteRole(Integer id)  throws Exception ;
	
	//更新角色信息
	public int updateRole(Role  r )  throws Exception ;
	
}
