package bit.ss.recommendSystem.modules.entity;

import bit.ss.recommendSystem.common.utils.IdGen;
import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private String id;
    private String userName;
    private String password;
    private Date registerTime;
    private Date lastLoginTime;

    public void preInsert() {
        this.id = IdGen.uuid();
        this.registerTime = new Date();
        this.lastLoginTime = this.registerTime;
    }
}
