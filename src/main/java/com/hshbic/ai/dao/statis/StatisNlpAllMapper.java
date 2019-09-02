package com.hshbic.ai.dao.statis;

import com.hshbic.ai.common.base.MyMapper;
import com.hshbic.ai.model.bigData.AiStatisNlpAll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StatisNlpAllMapper extends MyMapper<AiStatisNlpAll> {

    /**
     * 全量
     * @return
     */
    @Select("select count(distinct userId) uv from ai_statis_all where createTime>=#{start} and createTime<=#{end}")
    Integer selectUVByDate(String start, String end);

    /**
     * 分情景
     * @param start
     * @param end
     * @param domains
     * @return
     */
    @Select({"<script>" +
            "select count(distinct userId) uv from ai_statis_nlp_all where createTime between #{start} and #{end} and domain in " +
            "<foreach collection='domains' item='domain' open='(' separator=',' close=')'> #{domain}</foreach>" +
            "</script>"})
    Integer selectUVByParam(String start, String end, List<String> domains);


    /**
     * 分appid 和 domain
     * @param start
     * @param end
     * @param appIds
     * @param domains
     * @return
     */
    @Select({"<script>" +
            "select count(*) from(select userId from ai_statis_all where createTime between #{start} and #{end} and appId in "+
                 "<foreach collection='appIds' item='appId' open='(' separator=',' close=')'> #{appId}</foreach> " +
            "union select userId from ai_statis_nlp_all where createTime between #{start} and #{end} and domain in " +
                "<foreach collection='domains' item='domain' open='(' separator=',' close=')'> #{domain}</foreach> ) a " +
            "</script>"})
    Integer selectUVByParams(String start, String end, List<String> appIds, List<String> domains);

}
