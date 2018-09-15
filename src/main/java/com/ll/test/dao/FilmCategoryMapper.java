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

import com.ll.test.model.FilmCategory;
import com.ll.test.model.FilmCategoryKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FilmCategoryMapper {
    @Delete({
        "delete from film_category",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(FilmCategoryKey key);

    @Insert({
        "insert into film_category (film_id, category_id, ",
        "last_update)",
        "values (#{filmId,jdbcType=SMALLINT}, #{categoryId,jdbcType=TINYINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(FilmCategory record);

    @InsertProvider(type=FilmCategorySqlProvider.class, method="insertSelective")
    int insertSelective(FilmCategory record);

    @Select({
        "select",
        "film_id, category_id, last_update",
        "from film_category",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    FilmCategory selectByPrimaryKey(FilmCategoryKey key);

    @UpdateProvider(type=FilmCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FilmCategory record);

    @Update({
        "update film_category",
        "set last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where film_id = #{filmId,jdbcType=SMALLINT}",
          "and category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(FilmCategory record);
}