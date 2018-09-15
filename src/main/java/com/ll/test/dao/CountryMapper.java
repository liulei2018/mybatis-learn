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

import com.ll.test.model.Country;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CountryMapper {
    @Delete({
        "delete from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String code);

    @Insert({
        "insert into country (Code, Name, Continent, ",
        "Region, SurfaceArea, IndepYear, ",
        "Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, ",
        "GovernmentForm, HeadOfState, ",
        "Capital, Code2)",
        "values (#{code,jdbcType=CHAR}, #{name,jdbcType=CHAR}, #{continent,jdbcType=CHAR}, ",
        "#{region,jdbcType=CHAR}, #{surfacearea,jdbcType=REAL}, #{indepyear,jdbcType=SMALLINT}, ",
        "#{population,jdbcType=INTEGER}, #{lifeexpectancy,jdbcType=REAL}, ",
        "#{gnp,jdbcType=REAL}, #{gnpold,jdbcType=REAL}, #{localname,jdbcType=CHAR}, ",
        "#{governmentform,jdbcType=CHAR}, #{headofstate,jdbcType=CHAR}, ",
        "#{capital,jdbcType=INTEGER}, #{code2,jdbcType=CHAR})"
    })
    int insert(Country record);

    @InsertProvider(type=CountrySqlProvider.class, method="insertSelective")
    int insertSelective(Country record);

    @Select({
        "select",
        "Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, ",
        "GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2",
        "from country",
        "where Code = #{code,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="Code", property="code", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="Name", property="name", jdbcType=JdbcType.CHAR),
        @Result(column="Continent", property="continent", jdbcType=JdbcType.CHAR),
        @Result(column="Region", property="region", jdbcType=JdbcType.CHAR),
        @Result(column="SurfaceArea", property="surfacearea", jdbcType=JdbcType.REAL),
        @Result(column="IndepYear", property="indepyear", jdbcType=JdbcType.SMALLINT),
        @Result(column="Population", property="population", jdbcType=JdbcType.INTEGER),
        @Result(column="LifeExpectancy", property="lifeexpectancy", jdbcType=JdbcType.REAL),
        @Result(column="GNP", property="gnp", jdbcType=JdbcType.REAL),
        @Result(column="GNPOld", property="gnpold", jdbcType=JdbcType.REAL),
        @Result(column="LocalName", property="localname", jdbcType=JdbcType.CHAR),
        @Result(column="GovernmentForm", property="governmentform", jdbcType=JdbcType.CHAR),
        @Result(column="HeadOfState", property="headofstate", jdbcType=JdbcType.CHAR),
        @Result(column="Capital", property="capital", jdbcType=JdbcType.INTEGER),
        @Result(column="Code2", property="code2", jdbcType=JdbcType.CHAR)
    })
    Country selectByPrimaryKey(String code);

    @UpdateProvider(type=CountrySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Country record);

    @Update({
        "update country",
        "set Name = #{name,jdbcType=CHAR},",
          "Continent = #{continent,jdbcType=CHAR},",
          "Region = #{region,jdbcType=CHAR},",
          "SurfaceArea = #{surfacearea,jdbcType=REAL},",
          "IndepYear = #{indepyear,jdbcType=SMALLINT},",
          "Population = #{population,jdbcType=INTEGER},",
          "LifeExpectancy = #{lifeexpectancy,jdbcType=REAL},",
          "GNP = #{gnp,jdbcType=REAL},",
          "GNPOld = #{gnpold,jdbcType=REAL},",
          "LocalName = #{localname,jdbcType=CHAR},",
          "GovernmentForm = #{governmentform,jdbcType=CHAR},",
          "HeadOfState = #{headofstate,jdbcType=CHAR},",
          "Capital = #{capital,jdbcType=INTEGER},",
          "Code2 = #{code2,jdbcType=CHAR}",
        "where Code = #{code,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Country record);
}