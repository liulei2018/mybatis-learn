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

import com.ll.test.model.Customer;
import org.apache.ibatis.jdbc.SQL;

public class CustomerSqlProvider {

    public String insertSelective(Customer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer");
        
        if (record.getCustomerId() != null) {
            sql.VALUES("customer_id", "#{customerId,jdbcType=SMALLINT}");
        }
        
        if (record.getStoreId() != null) {
            sql.VALUES("store_id", "#{storeId,jdbcType=TINYINT}");
        }
        
        if (record.getFirstName() != null) {
            sql.VALUES("first_name", "#{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.VALUES("last_name", "#{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=SMALLINT}");
        }
        
        if (record.getActive() != null) {
            sql.VALUES("active", "#{active,jdbcType=BIT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Customer record) {
        SQL sql = new SQL();
        sql.UPDATE("customer");
        
        if (record.getStoreId() != null) {
            sql.SET("store_id = #{storeId,jdbcType=TINYINT}");
        }
        
        if (record.getFirstName() != null) {
            sql.SET("first_name = #{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.SET("last_name = #{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{addressId,jdbcType=SMALLINT}");
        }
        
        if (record.getActive() != null) {
            sql.SET("active = #{active,jdbcType=BIT}");
        }
        
        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("customer_id = #{customerId,jdbcType=SMALLINT}");
        
        return sql.toString();
    }
}