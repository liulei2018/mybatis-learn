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

import com.ll.test.model.Film;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FilmMapper {
    @Delete({
        "delete from film",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short filmId);

    @Insert({
        "insert into film (film_id, title, ",
        "release_year, language_id, ",
        "original_language_id, rental_duration, ",
        "rental_rate, length, ",
        "replacement_cost, rating, ",
        "special_features, last_update, ",
        "description)",
        "values (#{filmId,jdbcType=SMALLINT}, #{title,jdbcType=VARCHAR}, ",
        "#{releaseYear,jdbcType=DATE}, #{languageId,jdbcType=TINYINT}, ",
        "#{originalLanguageId,jdbcType=TINYINT}, #{rentalDuration,jdbcType=TINYINT}, ",
        "#{rentalRate,jdbcType=DECIMAL}, #{length,jdbcType=SMALLINT}, ",
        "#{replacementCost,jdbcType=DECIMAL}, #{rating,jdbcType=CHAR}, ",
        "#{specialFeatures,jdbcType=CHAR}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{description,jdbcType=LONGVARCHAR})"
    })
    int insert(Film record);

    @InsertProvider(type=FilmSqlProvider.class, method="insertSelective")
    int insertSelective(Film record);

    @Select({
        "select",
        "film_id, title, release_year, language_id, original_language_id, rental_duration, ",
        "rental_rate, length, replacement_cost, rating, special_features, last_update, ",
        "description",
        "from film",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_year", property="releaseYear", jdbcType=JdbcType.DATE),
        @Result(column="language_id", property="languageId", jdbcType=JdbcType.TINYINT),
        @Result(column="original_language_id", property="originalLanguageId", jdbcType=JdbcType.TINYINT),
        @Result(column="rental_duration", property="rentalDuration", jdbcType=JdbcType.TINYINT),
        @Result(column="rental_rate", property="rentalRate", jdbcType=JdbcType.DECIMAL),
        @Result(column="length", property="length", jdbcType=JdbcType.SMALLINT),
        @Result(column="replacement_cost", property="replacementCost", jdbcType=JdbcType.DECIMAL),
        @Result(column="rating", property="rating", jdbcType=JdbcType.CHAR),
        @Result(column="special_features", property="specialFeatures", jdbcType=JdbcType.CHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="description", property="description", jdbcType=JdbcType.LONGVARCHAR)
    })
    Film selectByPrimaryKey(Short filmId);

    @UpdateProvider(type=FilmSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Film record);

    @Update({
        "update film",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_year = #{releaseYear,jdbcType=DATE},",
          "language_id = #{languageId,jdbcType=TINYINT},",
          "original_language_id = #{originalLanguageId,jdbcType=TINYINT},",
          "rental_duration = #{rentalDuration,jdbcType=TINYINT},",
          "rental_rate = #{rentalRate,jdbcType=DECIMAL},",
          "length = #{length,jdbcType=SMALLINT},",
          "replacement_cost = #{replacementCost,jdbcType=DECIMAL},",
          "rating = #{rating,jdbcType=CHAR},",
          "special_features = #{specialFeatures,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "description = #{description,jdbcType=LONGVARCHAR}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Film record);

    @Update({
        "update film",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_year = #{releaseYear,jdbcType=DATE},",
          "language_id = #{languageId,jdbcType=TINYINT},",
          "original_language_id = #{originalLanguageId,jdbcType=TINYINT},",
          "rental_duration = #{rentalDuration,jdbcType=TINYINT},",
          "rental_rate = #{rentalRate,jdbcType=DECIMAL},",
          "length = #{length,jdbcType=SMALLINT},",
          "replacement_cost = #{replacementCost,jdbcType=DECIMAL},",
          "rating = #{rating,jdbcType=CHAR},",
          "special_features = #{specialFeatures,jdbcType=CHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where film_id = #{filmId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(Film record);
}