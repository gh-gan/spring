package dal.testdb.auto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import dal.testdb.auto.dataobject.TestTableDO;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.HashSet;
import dal.testdb.auto.paging.TestPageVoPage;
import dal.testdb.auto.mapper.TestTableDOMapper;

/**
* The Table my_test_table.
* MY_TEST_TABLE
*/
@Repository
public class TestTableDAO{

    @Autowired
    private TestTableDOMapper testTableDOMapper;

    /**
     * 插入表:my_test_table.<br/>
     * @param entity entity
     * @return Long
     */
    public Long insert(TestTableDO entity){
        return testTableDOMapper.insert(entity);
    }
    /**
     * 批量插入表:my_test_table.<br/>
     * @param list list
     * @return Long
     */
    public Long insertBatch(List<TestTableDO> list){
        return testTableDOMapper.insertBatch(list);
    }
    /**
     * 更新表:my_test_table.<br/>
     * @param entity entity
     * @return Long
     */
    public Long update(TestTableDO entity){
        return testTableDOMapper.update(entity);
    }
    /**
     * 根据主键删除数据:my_test_table.<br/>
     * @param id id
     * @return Long
     */
    public Long deleteById(Integer id){
        return testTableDOMapper.deleteById(id);
    }
    /**
     * 根据主键获取数据:my_test_table.<br/>
     * @param id id
     * @return TestTableDO
     */
    public TestTableDO getById(Integer id){
        return testTableDOMapper.getById(id);
    }
    /**
     * 查询多条.<br/>
     * @param entity entity
     * @return List<TestTableDO>
     */
    public List<TestTableDO> selectList(TestTableDO entity){
        return testTableDOMapper.selectList(entity);
    }
    /**
     * 查询结果多条并转为Map.<br/>
     * @param entity entity
     * @return Map<Integer,String>
     */
    public Map<Integer,String> selectListToMap(TestTableDO entity){
        Map<Integer,String> result = new LinkedHashMap();
        List<TestTableDO> resultList = testTableDOMapper.selectListToMap(entity);
        if(resultList!=null && !resultList.isEmpty()){
            for(TestTableDO object : resultList){
                result.put(object.getId(),object.getName());
            }
        }
        return result;
    }
    /**
     * 查询结果多条并转为MapList.<br/>
     * @param age age
     * @return Map<Integer,List<String>>
     */
    public Map<Integer,List<String>> selectListForMapList(Integer age){
        Map<Integer,List<String>> result = new LinkedHashMap();
        List<TestTableDO> resultList = testTableDOMapper.selectListForMapList(age);
        if(resultList!=null && !resultList.isEmpty()){
            for(TestTableDO object : resultList){
                List<String> vList =  result.get(object.getId());
                if(vList == null){
                    vList = new ArrayList();
                    result.put(object.getId(),vList);
                }
                vList.add(object.getName());
            }
        }
        return result;
    }
    /**
     * 查询结果多条并转为MapList.<br/>
     * @param age age
     * @return Map<Integer,Set<String>>
     */
    public Map<Integer,Set<String>> selectListForMapSet(Integer age){
        Map<Integer,Set<String>> result = new LinkedHashMap();
        List<TestTableDO> resultList = testTableDOMapper.selectListForMapSet(age);
        if(resultList!=null && !resultList.isEmpty()){
            for(TestTableDO object : resultList){
                Set<String> vSet =  result.get(object.getId());
                if(vSet == null){
                    vSet = new HashSet();
                    result.put(object.getId(),vSet);
                }
                vSet.add(object.getName());
                }
        }
        return result;
    }
    /**
     * 分页查询.<br/>
     * @param testPageVo testPageVo
     * @return TestPageVoPage
     */
    public TestPageVoPage queryForPage(TestPageVoPage testPageVo){
        int total = testTableDOMapper.queryForPageCount(testPageVo);
        if(total>0){
            testPageVo.setDatas(testTableDOMapper.queryForPageResult(testPageVo));
        }
        testPageVo.setTotal(total);
        return testPageVo;
    }
}
