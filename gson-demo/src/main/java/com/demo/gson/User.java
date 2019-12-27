package com.demo.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class User implements Serializable {
    @Since(1.0)
    private Long id;
    @Since(1.0)
    @Expose
    private String name;
    @Since(1.0)
    @Expose
    private Integer age;
    @Since(1.0)
    private Date birthDay;
    @Since(1.0)
    private Boolean isMale;
    @Since(1.0)
    private Double balance;
    @Since(1.1)
    private String version;

    private transient String excludeTransient;
    public static String excludeStatic="excludeStatic";

    private List<LoginAccount> loginAccountList;
}
