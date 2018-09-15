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

import com.ll.test.model.Address;
import org.apache.ibatis.jdbc.SQL;

public class AddressSqlProvider {

    public String insertSelective(Address record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("address");
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=SMALLINT}");
        }
        
        if (record.getAddress() != null) {
            sql.VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress2() != null) {
            sql.VALUES("address2", "#{address2,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.VALUES("district", "#{district,jdbcType=VARCHAR}");
        }
        
        if (record.getCityId() != null) {
            sql.VALUES("city_id", "#{cityId,jdbcType=SMALLINT}");
        }
        
        if (record.getPostalCode() != null) {
            sql.VALUES("postal_code", "#{postalCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLocation() != null) {
            sql.VALUES("location", "#{location,jdbcType=BINARY}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Address record) {
        SQL sql = new SQL();
        sql.UPDATE("address");
        
        if (record.getAddress() != null) {
            sql.SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress2() != null) {
            sql.SET("address2 = #{address2,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict() != null) {
            sql.SET("district = #{district,jdbcType=VARCHAR}");
        }
        
        if (record.getCityId() != null) {
            sql.SET("city_id = #{cityId,jdbcType=SMALLINT}");
        }
        
        if (record.getPostalCode() != null) {
            sql.SET("postal_code = #{postalCode,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLocation() != null) {
            sql.SET("location = #{location,jdbcType=BINARY}");
        }
        
        sql.WHERE("address_id = #{addressId,jdbcType=SMALLINT}");
        
        return sql.toString();
    }
}