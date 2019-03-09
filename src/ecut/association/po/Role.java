package ecut.association.po;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -4663460700843152533L;

	private Integer id;

	private String roleName;

	private String note;
	
	private Integer comicId;

	private Comic comic;
	
	private Dubber dubber;

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

	public Integer getComicId() {
		return comicId;
	}

	public void setComicId(Integer comicId) {
		this.comicId = comicId;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}
	
	
	public Dubber getDubber() {
		return dubber;
	}

	public void setDubber(Dubber dubber) {
		this.dubber = dubber;
	}

	@Override
	public String toString() {
		String s = "\n"+"角色信息：id =" + id + ",roleName =" + roleName + ", note = " + note+", comicId = " + comicId;
		s=s+";"+"动漫信息："+"id="+comic.getId()+",comicName="+comic.getComicName()+",remark="+comic.getRemark();
		return s;
	}

}
