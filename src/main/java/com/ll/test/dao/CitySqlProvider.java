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
import org.apache.ibatis.jdbc.SQL;

public class CitySqlProvider {

    public String insertSelective(City record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("city");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("Name", "#{name,jdbcType=CHAR}");
        }
        
        if (record.getCountrycode() != null) {
            sql.VALUES("CountryCode", "#{countrycode,jdbcType=CHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.VALUES("District", "#{district,jdbcType=CHAR}");
        }
        
        if (record.getPopulation() != null) {
            sql.VALUES("Population", "#{population,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(City record) {
        SQL sql = new SQL();
        sql.UPDATE("city");
        
        if (record.getName() != null) {
            sql.SET("Name = #{name,jdbcType=CHAR}");
        }
        
        if (record.getCountrycode() != null) {
            sql.SET("CountryCode = #{countrycode,jdbcType=CHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("District = #{district,jdbcType=CHAR}");
        }
        
        if (record.getPopulation() != null) {
            sql.SET("Population = #{population,jdbcType=INTEGER}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}