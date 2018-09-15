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

import com.ll.test.model.FilmTtext;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FilmTtextMapper {
    @Delete({
        "delete from film_text",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short filmId);

    @Insert({
        "insert into film_text (film_id, title, ",
        "description)",
        "values (#{filmId,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(FilmTtext record);

    @InsertProvider(type=FilmTtextSqlProvider.class, method="insertSelective")
    int insertSelective(FilmTtext record);

    @Select({
        "select",
        "film_id, title, description",
        "from film_text",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    FilmTtext selectByPrimaryKey(Short filmId);

    @UpdateProvider(type=FilmTtextSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FilmTtext record);

    @Update({
        "update film_text",
        "set title = #{title,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(FilmTtext record);

    @Update({
        "update film_text",
        "set title = #{title,jdbcType=VARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(FilmTtext record);
}