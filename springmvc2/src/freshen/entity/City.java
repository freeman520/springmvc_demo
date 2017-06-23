package freshen.entity;
// default package


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

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    

    public String getCountryCode() {
        return this.countryCode;
    }
    
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    

    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    

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