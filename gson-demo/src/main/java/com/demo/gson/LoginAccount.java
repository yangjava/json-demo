package com.demo.gson;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginAccount implements Serializable {

    private Long id;

    private String loginName;

    private String type;

    private Date LoginTime;
}
