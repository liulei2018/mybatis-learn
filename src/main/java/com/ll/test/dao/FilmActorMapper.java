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

import com.ll.test.model.FilmActor;
import com.ll.test.model.FilmActorKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FilmActorMapper {
    @Delete({
        "delete from film_actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(FilmActorKey key);

    @Insert({
        "insert into film_actor (actor_id, film_id, ",
        "last_update)",
        "values (#{actorId,jdbcType=SMALLINT}, #{filmId,jdbcType=SMALLINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(FilmActor record);

    @InsertProvider(type=FilmActorSqlProvider.class, method="insertSelective")
    int insertSelective(FilmActor record);

    @Select({
        "select",
        "actor_id, film_id, last_update",
        "from film_actor",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="actor_id", property="actorId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    FilmActor selectByPrimaryKey(FilmActorKey key);

    @UpdateProvider(type=FilmActorSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FilmActor record);

    @Update({
        "update film_actor",
        "set last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where actor_id = #{actorId,jdbcType=SMALLINT}",
          "and film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(FilmActor record);
}