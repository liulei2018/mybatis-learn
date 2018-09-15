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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PaymentMapper {
    @Delete({
        "delete from payment",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short paymentId);

    @Insert({
        "insert into payment (payment_id, customer_id, ",
        "staff_id, rental_id, ",
        "amount, payment_date, ",
        "last_update)",
        "values (#{paymentId,jdbcType=SMALLINT}, #{customerId,jdbcType=SMALLINT}, ",
        "#{staffId,jdbcType=TINYINT}, #{rentalId,jdbcType=INTEGER}, ",
        "#{amount,jdbcType=DECIMAL}, #{paymentDate,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Payment record);

    @InsertProvider(type=PaymentSqlProvider.class, method="insertSelective")
    int insertSelective(Payment record);

    @Select({
        "select",
        "payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update",
        "from payment",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="payment_id", property="paymentId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.SMALLINT),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.TINYINT),
        @Result(column="rental_id", property="rentalId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL),
        @Result(column="payment_date", property="paymentDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Payment selectByPrimaryKey(Short paymentId);

    @UpdateProvider(type=PaymentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Payment record);

    @Update({
        "update payment",
        "set customer_id = #{customerId,jdbcType=SMALLINT},",
          "staff_id = #{staffId,jdbcType=TINYINT},",
          "rental_id = #{rentalId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "payment_date = #{paymentDate,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where payment_id = #{paymentId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(Payment record);
}