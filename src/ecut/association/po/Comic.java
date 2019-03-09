package ecut.association.po;

import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {

	private static final long serialVersionUID = -3674954993814032572L;
	
	private Integer id;
	
	private String comicName;
	
	private String remark;
	
	private List<Role> roles;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComicName() {
		return comicName;
	}

	public void setComicName(String comicName) {
		this.comicName = comicName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
