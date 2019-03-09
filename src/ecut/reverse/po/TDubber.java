package ecut.reverse.po;

public class TDubber {
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
        this.dubberName = dubberName == null ? null : dubberName.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}