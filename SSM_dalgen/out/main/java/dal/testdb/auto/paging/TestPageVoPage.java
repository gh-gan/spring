package dal.testdb.auto.paging;

import dal.testdb.auto.paging.BasePage;
import dal.testdb.auto.dataobject.TestTableDO;

/**
 * The table MY_TEST_TABLE MY_TEST_TABLE
 */
public class TestPageVoPage extends BasePage<TestTableDO>{

    /**
     * name NAME.
     */
    private String name;

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
}
