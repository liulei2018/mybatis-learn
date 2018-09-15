/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.ll.test.dao;

import com.ll.test.model.Language;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface LanguageMapper {
    @Delete({
        "delete from language",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte languageId);

    @Insert({
        "insert into language (language_id, name, ",
        "last_update)",
        "values (#{languageId,jdbcType=TINYINT}, #{name,jdbcType=CHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Language record);

    @InsertProvider(type=LanguageSqlProvider.class, method="insertSelective")
    int insertSelective(Language record);

    @Select({
        "select",
        "language_id, name, last_update",
        "from language",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="language_id", property="languageId", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Language selectByPrimaryKey(Byte languageId);

    @UpdateProvider(type=LanguageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Language record);

    @Update({
        "update language",
        "set name = #{name,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where language_id = #{languageId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Language record);
}