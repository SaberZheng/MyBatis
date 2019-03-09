package ecut.association.po;

public class RoleComic extends Role {

	private static final long serialVersionUID = -6089413956387774208L;

	private String comicName;

	private String remark;

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

	@Override
	public String toString() {
		String s = "\n"+"角色信息：id =" + getId() + ",roleName =" + getRoleName() + ", note = " + getNote()+", comicId = " + getComicId();
		s=s+";"+"动漫信息："+"comicName="+comicName+",remark="+remark;
		return s;
	}
}
