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
import org.apache.ibatis.jdbc.SQL;

public class CountrySqlProvider {

    public String insertSelective(Country record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("country");
        
        if (record.getCode() != null) {
            sql.VALUES("Code", "#{code,jdbcType=CHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=CHAR}");
        }
        
        if (record.getContinent() != null) {
            sql.VALUES("Continent", "#{continent,jdbcType=CHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.VALUES("Region", "#{region,jdbcType=CHAR}");
        }
        
        if (record.getSurfacearea() != null) {
            sql.VALUES("SurfaceArea", "#{surfacearea,jdbcType=REAL}");
        }
        
        if (record.getIndepyear() != null) {
            sql.VALUES("IndepYear", "#{indepyear,jdbcType=SMALLINT}");
        }
        
        if (record.getPopulation() != null) {
            sql.VALUES("Population", "#{population,jdbcType=INTEGER}");
        }
        
        if (record.getLifeexpectancy() != null) {
            sql.VALUES("LifeExpectancy", "#{lifeexpectancy,jdbcType=REAL}");
        }
        
        if (record.getGnp() != null) {
            sql.VALUES("GNP", "#{gnp,jdbcType=REAL}");
        }
        
        if (record.getGnpold() != null) {
            sql.VALUES("GNPOld", "#{gnpold,jdbcType=REAL}");
        }
        
        if (record.getLocalname() != null) {
            sql.VALUES("LocalName", "#{localname,jdbcType=CHAR}");
        }
        
        if (record.getGovernmentform() != null) {
            sql.VALUES("GovernmentForm", "#{governmentform,jdbcType=CHAR}");
        }
        
        if (record.getHeadofstate() != null) {
            sql.VALUES("HeadOfState", "#{headofstate,jdbcType=CHAR}");
        }
        
        if (record.getCapital() != null) {
            sql.VALUES("Capital", "#{capital,jdbcType=INTEGER}");
        }
        
        if (record.getCode2() != null) {
            sql.VALUES("Code2", "#{code2,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Country record) {
        SQL sql = new SQL();
        sql.UPDATE("country");
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=CHAR}");
        }
        
        if (record.getContinent() != null) {
            sql.SET("Continent = #{continent,jdbcType=CHAR}");
        }
        
        if (record.getRegion() != null) {
            sql.SET("Region = #{region,jdbcType=CHAR}");
        }
        
        if (record.getSurfacearea() != null) {
            sql.SET("SurfaceArea = #{surfacearea,jdbcType=REAL}");
        }
        
        if (record.getIndepyear() != null) {
            sql.SET("IndepYear = #{indepyear,jdbcType=SMALLINT}");
        }
        
        if (record.getPopulation() != null) {
            sql.SET("Population = #{population,jdbcType=INTEGER}");
        }
        
        if (record.getLifeexpectancy() != null) {
            sql.SET("LifeExpectancy = #{lifeexpectancy,jdbcType=REAL}");
        }
        
        if (record.getGnp() != null) {
            sql.SET("GNP = #{gnp,jdbcType=REAL}");
        }
        
        if (record.getGnpold() != null) {
            sql.SET("GNPOld = #{gnpold,jdbcType=REAL}");
        }
        
        if (record.getLocalname() != null) {
            sql.SET("LocalName = #{localname,jdbcType=CHAR}");
        }
        
        if (record.getGovernmentform() != null) {
            sql.SET("GovernmentForm = #{governmentform,jdbcType=CHAR}");
        }
        
        if (record.getHeadofstate() != null) {
            sql.SET("HeadOfState = #{headofstate,jdbcType=CHAR}");
        }
        
        if (record.getCapital() != null) {
            sql.SET("Capital = #{capital,jdbcType=INTEGER}");
        }
        
        if (record.getCode2() != null) {
            sql.SET("Code2 = #{code2,jdbcType=CHAR}");
        }
        
        sql.WHERE("Code = #{code,jdbcType=CHAR}");
        
        return sql.toString();
    }
}