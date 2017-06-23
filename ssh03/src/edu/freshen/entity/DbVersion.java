package edu.freshen.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * DbVersion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="dbversion"
    ,catalog="world"
)

public class DbVersion  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer dbVersion;


    // Constructors

    /** default constructor */
    public DbVersion() {
    }

    
    /** full constructor */
    public DbVersion(Integer dbVersion) {
        this.dbVersion = dbVersion;
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
    
    @Column(name="dbVersion", nullable=false)

    public Integer getDbVersion() {
        return this.dbVersion;
    }
    
    public void setDbVersion(Integer dbVersion) {
        this.dbVersion = dbVersion;
    }
   








}