package edu.freshen.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * City entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="city"
    ,catalog="world"
)

public class City  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String countryCode;
     private String district;
     private Integer population;


    // Constructors

    /** default constructor */
    public City() {
    }

    
    /** full constructor */
    public City(String name, String countryCode, String district, Integer population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="increment")@Id @GeneratedValue(generator="generator")
    
    @Column(name="ID", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="Name", nullable=false, length=35)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="CountryCode", nullable=false, length=3)

    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    @Column(name="District", nullable=false, length=20)

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    
    @Column(name="Population", nullable=false)

    public Integer getPopulation() {
        return this.population;
    }
    
    public void setPopulation(Integer population) {
        this.population = population;
    }


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", countryCode="
				+ countryCode + ", district=" + district + ", population="
				+ population + "]";
	}
   








}