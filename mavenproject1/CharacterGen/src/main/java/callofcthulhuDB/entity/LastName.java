package callofcthulhuDB.entity;
// Generated 23 lut 2020, 09:37:02 by Hibernate Tools 4.3.1



/**
 * LastName generated by hbm2java
 */
public class LastName  implements java.io.Serializable {


     private Integer id;
     private String lastName;

    public LastName() {
    }

    public LastName(String lastName) {
       this.lastName = lastName;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}

