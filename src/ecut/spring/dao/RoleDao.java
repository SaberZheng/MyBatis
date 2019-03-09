package ecut.spring.dao;


import ecut.spring.po.Role;

public interface RoleDao {
	
	//根据id获取角色
	public Role getRole(Integer id) throws Exception ;
	
	
}
