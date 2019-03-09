package ecut.association.po;

import java.io.Serializable;

public class Dubber implements Serializable{

	private static final long serialVersionUID = -7436845097720592214L;
	
	private Integer id;
	
	private String dubberName;
	
	private Integer roleId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDubberName() {
		return dubberName;
	}

	public void setDubberName(String dubberName) {
		this.dubberName = dubberName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	
}
