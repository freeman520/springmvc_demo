package edu.freshen.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="userinfo"
    ,catalog="world"
)

public class UserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String loginName;
     private String loginPwd;


    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    
    /** full constructor */
    public UserInfo(String loginName, String loginPwd) {
        this.loginName = loginName;
        this.loginPwd = loginPwd;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="loginName", nullable=false)

    public String getLoginName() {
        return this.loginName;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    @Column(name="loginPwd", nullable=false)

    public String getLoginPwd() {
        return this.loginPwd;
    }
    
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
   








}