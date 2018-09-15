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

import com.ll.test.model.Payment;
import org.apache.ibatis.jdbc.SQL;

public class PaymentSqlProvider {

    public String insertSelective(Payment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("payment");
        
        if (record.getPaymentId() != null) {
            sql.VALUES("payment_id", "#{paymentId,jdbcType=SMALLINT}");
        }
        
        if (record.getCustomerId() != null) {
            sql.VALUES("customer_id", "#{customerId,jdbcType=SMALLINT}");
        }
        
        if (record.getStaffId() != null) {
            sql.VALUES("staff_id", "#{staffId,jdbcType=TINYINT}");
        }
        
        if (record.getRentalId() != null) {
            sql.VALUES("rental_id", "#{rentalId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getPaymentDate() != null) {
            sql.VALUES("payment_date", "#{paymentDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Payment record) {
        SQL sql = new SQL();
        sql.UPDATE("payment");
        
        if (record.getCustomerId() != null) {
            sql.SET("customer_id = #{customerId,jdbcType=SMALLINT}");
        }
        
        if (record.getStaffId() != null) {
            sql.SET("staff_id = #{staffId,jdbcType=TINYINT}");
        }
        
        if (record.getRentalId() != null) {
            sql.SET("rental_id = #{rentalId,jdbcType=INTEGER}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=DECIMAL}");
        }
        
        if (record.getPaymentDate() != null) {
            sql.SET("payment_date = #{paymentDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("payment_id = #{paymentId,jdbcType=SMALLINT}");
        
        return sql.toString();
    }
}