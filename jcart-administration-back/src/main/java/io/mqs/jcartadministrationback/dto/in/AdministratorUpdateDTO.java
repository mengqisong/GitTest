package io.mqs.jcartadministrationback.dto.in;

public class AdministratorUpdateDTO {
    private Integer administratorId;
    private String username;
    private String realName;
    private String password;
    private String email;
    private String avatarUrl;
    private Byte status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

}
