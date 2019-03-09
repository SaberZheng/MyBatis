package ecut.spring.mapper;

import ecut.spring.po.Role;

public interface RoleMapper {
	
	//根据id获取角色
	public Role getRole(Integer id) throws Exception ;
	
}
