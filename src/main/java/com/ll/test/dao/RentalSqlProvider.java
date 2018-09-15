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

import com.ll.test.model.Rental;
import org.apache.ibatis.jdbc.SQL;

public class RentalSqlProvider {

    public String insertSelective(Rental record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("rental");
        
        if (record.getRentalId() != null) {
            sql.VALUES("rental_id", "#{rentalId,jdbcType=INTEGER}");
        }
        
        if (record.getRentalDate() != null) {
            sql.VALUES("rental_date", "#{rentalDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInventoryId() != null) {
            sql.VALUES("inventory_id", "#{inventoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerId() != null) {
            sql.VALUES("customer_id", "#{customerId,jdbcType=SMALLINT}");
        }
        
        if (record.getReturnDate() != null) {
            sql.VALUES("return_date", "#{returnDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffId() != null) {
            sql.VALUES("staff_id", "#{staffId,jdbcType=TINYINT}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Rental record) {
        SQL sql = new SQL();
        sql.UPDATE("rental");
        
        if (record.getRentalDate() != null) {
            sql.SET("rental_date = #{rentalDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInventoryId() != null) {
            sql.SET("inventory_id = #{inventoryId,jdbcType=INTEGER}");
        }
        
        if (record.getCustomerId() != null) {
            sql.SET("customer_id = #{customerId,jdbcType=SMALLINT}");
        }
        
        if (record.getReturnDate() != null) {
            sql.SET("return_date = #{returnDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStaffId() != null) {
            sql.SET("staff_id = #{staffId,jdbcType=TINYINT}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("rental_id = #{rentalId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}