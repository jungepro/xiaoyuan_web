package org.jeecg.modules.system.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class ThirdLoginModel implements Serializable {
    private static final long serialVersionUID = 4098628709290780891L;

    
    private String source;

    
    private String uuid;

    
    private String username;

    
    private String avatar;

    
    private String suffix;

    
    private String operateCode;

    public ThirdLoginModel(){

    }

    
    public ThirdLoginModel(String source,String uuid,String username,String avatar){
        this.source = source;
        this.uuid = uuid;
        this.username = username;
        this.avatar = avatar;
    }

    
    public String getUserLoginAccount(){
        if(suffix==null){
            return this.uuid;
        }
        return this.uuid + this.suffix;
    }
}
