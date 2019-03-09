package ecut.spring.po;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -4663460700843152533L;

	private Integer id;

	private String roleName;

	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		String s = "id =" + id + ",name =" + roleName + ", note = " + note;
		return s;
	}

}
