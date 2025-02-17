package org.jeecg.modules.system.model;

import lombok.Data;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.entity.SysUser;


@Data
public class SysUserSysDepartModel {

    private String id;
    private String realname;
    private String workNo;
    private String post;
    private String telephone;
    private String email;
    private String phone;
    private String departId;
    private String departName;
    private String avatar;

}
