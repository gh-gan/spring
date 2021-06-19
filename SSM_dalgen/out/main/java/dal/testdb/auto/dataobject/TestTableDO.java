package dal.testdb.auto.dataobject;


/**
 * The table MY_TEST_TABLE
 */
public class TestTableDO{

    /**
     * id ID.
     */
    private Integer id;
    /**
     * longid LONGID.
     */
    private Long longid;
    /**
     * name NAME.
     */
    private String name;
    /**
     * age AGE.
     */
    private Integer age;

    /**
     * Set id ID.
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Get id ID.
     *
     * @return the string
     */
    public Integer getId(){
        return id;
    }

    /**
     * Set longid LONGID.
     */
    public void setLongid(Long longid){
        this.longid = longid;
    }

    /**
     * Get longid LONGID.
     *
     * @return the string
     */
    public Long getLongid(){
        return longid;
    }

    /**
     * Set name NAME.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name NAME.
     *
     * @return the string
     */
    public String getName(){
        return name;
    }

    /**
     * Set age AGE.
     */
    public void setAge(Integer age){
        this.age = age;
    }

    /**
     * Get age AGE.
     *
     * @return the string
     */
    public Integer getAge(){
        return age;
    }
}
