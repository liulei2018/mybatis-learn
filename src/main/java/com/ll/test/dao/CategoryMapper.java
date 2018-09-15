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

import com.ll.test.model.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CategoryMapper {
    @Delete({
        "delete from category",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte categoryId);

    @Insert({
        "insert into category (category_id, name, ",
        "last_update)",
        "values (#{categoryId,jdbcType=TINYINT}, #{name,jdbcType=VARCHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Category record);

    @InsertProvider(type=CategorySqlProvider.class, method="insertSelective")
    int insertSelective(Category record);

    @Select({
        "select",
        "category_id, name, last_update",
        "from category",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="category_id", property="categoryId", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Category selectByPrimaryKey(Byte categoryId);

    @UpdateProvider(type=CategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Category record);

    @Update({
        "update category",
        "set name = #{name,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where category_id = #{categoryId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Category record);
}