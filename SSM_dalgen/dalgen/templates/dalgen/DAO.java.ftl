<@pp.dropOutputFile />
<#import "../lib/function.ftl" as fun/>
<#list dalgen.daos as dao>
    <@pp.changeOutputFile name = "/main/java/${dao.classPath}/${dao.className}.java" />
package ${dao.packageName};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
<#list dao.importLists as import>
import ${import};
</#list>

/**
* The Table ${dao.tableName!}.
* ${dao.desc!}
*/
<#if dalgen.config.getExtParam("Repository") == "true">@Repository</#if>
public class ${dao.className}{

    @Autowired
    private ${dao.doMapper.className} ${dao.doMapper.className?uncap_first};

    <#list dao.motheds as method>
    /**
     * ${method.desc!method.name!}.<br/>
        <#list  method.params as param>
     * @param ${param.param} ${param.param}
        </#list>
     * @return ${fun.methodClass(method)}
     */
    public ${fun.methodClass(method)} ${method.name}(<#list  method.params as param><#if param_index gt 0>,</#if>${param.paramType!} <#assign pagingParam = param.param/>${param.param}</#list>){
    <#if !method.name?starts_with("insert")><#list  method.params as param><#if param.paramType?starts_with("List<")>
    if(${param.param}!=null && ${param.param}.size()>201){throw new RuntimeException("${param.param} 超出200长度限制");}
    </#if></#list></#if>
    <#if method.pagingFlag == "true">
        <#if method.pagingCustomFlag == "true">
        int total = ${dao.doMapper.className?uncap_first}.${method.pagingCntOperation}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        <#else >
        int total = ${dao.doMapper.className?uncap_first}.${method.name}Count(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        </#if>
        if(total>0){
            ${pagingParam}.setDatas(${dao.doMapper.className?uncap_first}.${method.name}Result(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>));
        }
        ${pagingParam}.setTotal(total);
        return ${pagingParam};
    <#elseif method.kvMap?? && method.kvMap == "true">
        ${fun.methodClass(method)} result = new LinkedHashMap();
        ${method.returnClass} resultList = ${dao.doMapper.className?uncap_first}.${method.name}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        if(resultList!=null && !resultList.isEmpty()){
            for(${fun.fanType2Type(method.returnClass)} object : resultList){
                <#if method.mapV??>
                result.put(object.get${method.mapK}(),object.get${method.mapV}());
                <#else >
                result.put(object.get${method.mapK}(),object);
                </#if>
            }
        }
        return result;
    <#elseif method.kvMap?? && method.kvMap == "list">
        ${fun.methodClass(method)} result = new LinkedHashMap();
        ${method.returnClass} resultList = ${dao.doMapper.className?uncap_first}.${method.name}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        if(resultList!=null && !resultList.isEmpty()){
            for(${fun.fanType2Type(method.returnClass)} object : resultList){
                <#if method.mapV??>
                List<${method.mapVType}> vList =  result.get(object.get${method.mapK}());
                <#else >
                List<${fun.fanType2Type(method.returnClass)}> vList =  result.get(object.get${method.mapK}());
                </#if>
                if(vList == null){
                    vList = new ArrayList();
                    result.put(object.get${method.mapK}(),vList);
                }
                <#if method.mapV??>
                vList.add(object.get${method.mapV}());
                <#else >
                vList.add(object);
                </#if>
            }
        }
        return result;
    <#elseif method.kvMap?? && method.kvMap == "set">
        ${fun.methodClass(method)} result = new LinkedHashMap();
        ${method.returnClass} resultList = ${dao.doMapper.className?uncap_first}.${method.name}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
        if(resultList!=null && !resultList.isEmpty()){
            for(${fun.fanType2Type(method.returnClass)} object : resultList){
                <#if method.mapV??>
                Set<${method.mapVType}> vSet =  result.get(object.get${method.mapK}());
                <#else >
                Set<${fun.fanType2Type(method.returnClass)}> vSet =  result.get(object.get${method.mapK}());
                </#if>
                if(vSet == null){
                    vSet = new HashSet();
                    result.put(object.get${method.mapK}(),vSet);
                }
                <#if method.mapV??>
                vSet.add(object.get${method.mapV}());
                <#else >
                vSet.add(object);
                </#if>
                }
        }
        return result;
    <#else>
        return ${dao.doMapper.className?uncap_first}.${method.name}(<#list  method.params as param><#if param_index gt 0>, </#if>${param.param}</#list>);
    </#if>
    }
    </#list>
}
</#list>
