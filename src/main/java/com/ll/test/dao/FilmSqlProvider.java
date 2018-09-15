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
import org.apache.ibatis.jdbc.SQL;

public class FilmSqlProvider {

    public String insertSelective(Film record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("film");
        
        if (record.getFilmId() != null) {
            sql.VALUES("film_id", "#{filmId,jdbcType=SMALLINT}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getReleaseYear() != null) {
            sql.VALUES("release_year", "#{releaseYear,jdbcType=DATE}");
        }
        
        if (record.getLanguageId() != null) {
            sql.VALUES("language_id", "#{languageId,jdbcType=TINYINT}");
        }
        
        if (record.getOriginalLanguageId() != null) {
            sql.VALUES("original_language_id", "#{originalLanguageId,jdbcType=TINYINT}");
        }
        
        if (record.getRentalDuration() != null) {
            sql.VALUES("rental_duration", "#{rentalDuration,jdbcType=TINYINT}");
        }
        
        if (record.getRentalRate() != null) {
            sql.VALUES("rental_rate", "#{rentalRate,jdbcType=DECIMAL}");
        }
        
        if (record.getLength() != null) {
            sql.VALUES("length", "#{length,jdbcType=SMALLINT}");
        }
        
        if (record.getReplacementCost() != null) {
            sql.VALUES("replacement_cost", "#{replacementCost,jdbcType=DECIMAL}");
        }
        
        if (record.getRating() != null) {
            sql.VALUES("rating", "#{rating,jdbcType=CHAR}");
        }
        
        if (record.getSpecialFeatures() != null) {
            sql.VALUES("special_features", "#{specialFeatures,jdbcType=CHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Film record) {
        SQL sql = new SQL();
        sql.UPDATE("film");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getReleaseYear() != null) {
            sql.SET("release_year = #{releaseYear,jdbcType=DATE}");
        }
        
        if (record.getLanguageId() != null) {
            sql.SET("language_id = #{languageId,jdbcType=TINYINT}");
        }
        
        if (record.getOriginalLanguageId() != null) {
            sql.SET("original_language_id = #{originalLanguageId,jdbcType=TINYINT}");
        }
        
        if (record.getRentalDuration() != null) {
            sql.SET("rental_duration = #{rentalDuration,jdbcType=TINYINT}");
        }
        
        if (record.getRentalRate() != null) {
            sql.SET("rental_rate = #{rentalRate,jdbcType=DECIMAL}");
        }
        
        if (record.getLength() != null) {
            sql.SET("length = #{length,jdbcType=SMALLINT}");
        }
        
        if (record.getReplacementCost() != null) {
            sql.SET("replacement_cost = #{replacementCost,jdbcType=DECIMAL}");
        }
        
        if (record.getRating() != null) {
            sql.SET("rating = #{rating,jdbcType=CHAR}");
        }
        
        if (record.getSpecialFeatures() != null) {
            sql.SET("special_features = #{specialFeatures,jdbcType=CHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("film_id = #{filmId,jdbcType=SMALLINT}");
        
        return sql.toString();
    }
}