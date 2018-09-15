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

import com.ll.test.model.Actor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ActorMapper {
    @Delete({
        "delete from actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short actorId);

    @Insert({
        "insert into actor (actor_id, first_name, ",
        "last_name, last_update)",
        "values (#{actorId,jdbcType=SMALLINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Actor record);

    @InsertProvider(type=ActorSqlProvider.class, method="insertSelective")
    int insertSelective(Actor record);

    @Select({
        "select",
        "actor_id, first_name, last_name, last_update",
        "from actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="actor_id", property="actorId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Actor selectByPrimaryKey(Short actorId);

    @UpdateProvider(type=ActorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Actor record);

    @Update({
        "update actor",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where actor_id = #{actorId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(Actor record);
}