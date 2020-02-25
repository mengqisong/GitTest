package io.mqs.jcartadministrationback.dto.out;

public class AdministratorListOutDTO {
    private Integer administratorId;
    private String username;
    private Byte status;
    private Long ceatetime;

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCeatetime() {
        return ceatetime;
    }

    public void setCeatetime(Long ceatetime) {
        this.ceatetime = ceatetime;
    }
}
