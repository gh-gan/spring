package dal.testdb.auto.mapper;

import dal.testdb.auto.dataobject.TestTableDO;
import java.util.List;
import java.util.Map;
import dal.testdb.auto.paging.TestPageVoPage;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table my_test_table.
 * MY_TEST_TABLE
 */
public interface TestTableDOMapper{

    /**
     * 插入表:my_test_table.<br/>
     * @param entity entity
     * @return Long
     */
    Long insert(TestTableDO entity);
    /**
     * 批量插入表:my_test_table.<br/>
     * @param list list
     * @return Long
     */
    Long insertBatch(List<TestTableDO> list);
    /**
     * 更新表:my_test_table.<br/>
     * @param entity entity
     * @return Long
     */
    Long update(TestTableDO entity);
    /**
     * 根据主键删除数据:my_test_table.<br/>
     * @param id id
     * @return Long
     */
    Long deleteById(Integer id);
    /**
     * 根据主键获取数据:my_test_table.<br/>
     * @param id id
     * @return TestTableDO
     */
    TestTableDO getById(Integer id);
    /**
     * 查询多条.<br/>
     * @param entity entity
     * @return List<TestTableDO>
     */
    List<TestTableDO> selectList(TestTableDO entity);
    /**
     * 查询结果多条并转为Map.<br/>
     * @param entity entity
     * @return List<TestTableDO>
     */
    List<TestTableDO> selectListToMap(TestTableDO entity);
    /**
     * 查询结果多条并转为MapList.<br/>
     * @param age age
     * @return List<TestTableDO>
     */
    List<TestTableDO> selectListForMapList(Integer age);
    /**
     * 查询结果多条并转为MapList.<br/>
     * @param age age
     * @return List<TestTableDO>
     */
    List<TestTableDO> selectListForMapSet(Integer age);
    /**
     * 分页查询.<br/>
     * @param testPageVo testPageVo
     * @return int
     */
    int queryForPageCount(TestPageVoPage testPageVo);
    /**
     * 分页查询.<br/>
     * @param testPageVo testPageVo
     * @return List<TestTableDO>
     */
    List<TestTableDO> queryForPageResult(TestPageVoPage testPageVo);
}
