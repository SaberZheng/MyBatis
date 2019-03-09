package ecut.access.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ecut.access.po.Role;

public interface RoleMapper {
	
	//根据id获取角色
	public Role getRole(Integer id) throws Exception ;
	
	// 根据note模糊查询角色列表
	public List<Role> getRoles(String note )  throws Exception ;
	
	//根据note和roleName查询
	//public List<Role> getRolesByNameAndNote(Role r);
	//public List<Role> getRolesByNameAndNote(@Param("note") String note ,@Param("roleName")String roleName);
	
	public List<Role> getRolesByNameAndNote(String note ,String roleName);

	
	//根据一组id获取角色
	public List<Role> getRolesByIds(List<Integer> ids);
	
	//添加角色信息
	public int insertRole(Role r)  throws Exception ;
	
	//根据id删除角色信息
	public int deleteRole(Integer id)  throws Exception ;
	
	//更新角色信息
	public int updateRole(Role  r )  throws Exception ;
	
}
