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
import org.apache.ibatis.jdbc.SQL;

public class FilmCategorySqlProvider {

    public String insertSelective(FilmCategory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("film_category");
        
        if (record.getFilmId() != null) {
            sql.VALUES("film_id", "#{filmId,jdbcType=SMALLINT}");
        }
        
        if (record.getCategoryId() != null) {
            sql.VALUES("category_id", "#{categoryId,jdbcType=TINYINT}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FilmCategory record) {
        SQL sql = new SQL();
        sql.UPDATE("film_category");
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("film_id = #{filmId,jdbcType=SMALLINT}");
        sql.WHERE("category_id = #{categoryId,jdbcType=TINYINT}");
        
        return sql.toString();
    }
}