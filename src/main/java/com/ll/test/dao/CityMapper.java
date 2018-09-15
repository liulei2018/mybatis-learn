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

import com.ll.test.model.City;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CityMapper {
    @Delete({
        "delete from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into city (ID, Name, CountryCode, ",
        "District, Population)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=CHAR}, #{countrycode,jdbcType=CHAR}, ",
        "#{district,jdbcType=CHAR}, #{population,jdbcType=INTEGER})"
    })
    int insert(City record);

    @InsertProvider(type=CitySqlProvider.class, method="insertSelective")
    int insertSelective(City record);

    @Select({
        "select",
        "ID, Name, CountryCode, District, Population",
        "from city",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="CountryCode", property="countrycode", jdbcType=JdbcType.CHAR),
        @Result(column="District", property="district", jdbcType=JdbcType.CHAR),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER)
    })
    City selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(City record);

    @Update({
        "update city",
        "set Name = #{name,jdbcType=CHAR},",
          "CountryCode = #{countrycode,jdbcType=CHAR},",
          "District = #{district,jdbcType=CHAR},",
          "Population = #{population,jdbcType=INTEGER}",
        "where ID = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(City record);
}