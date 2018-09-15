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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CustomerMapper {
    @Delete({
        "delete from customer",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short customerId);

    @Insert({
        "insert into customer (customer_id, store_id, ",
        "first_name, last_name, ",
        "email, address_id, ",
        "active, create_date, ",
        "last_update)",
        "values (#{customerId,jdbcType=SMALLINT}, #{storeId,jdbcType=TINYINT}, ",
        "#{firstName,jdbcType=VARCHAR}, #{lastName,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{addressId,jdbcType=SMALLINT}, ",
        "#{active,jdbcType=BIT}, #{createDate,jdbcType=TIMESTAMP}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Customer record);

    @InsertProvider(type=CustomerSqlProvider.class, method="insertSelective")
    int insertSelective(Customer record);

    @Select({
        "select",
        "customer_id, store_id, first_name, last_name, email, address_id, active, create_date, ",
        "last_update",
        "from customer",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.TINYINT),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.SMALLINT),
        @Result(column="active", property="active", jdbcType=JdbcType.BIT),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Customer selectByPrimaryKey(Short customerId);

    @UpdateProvider(type=CustomerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update customer",
        "set store_id = #{storeId,jdbcType=TINYINT},",
          "first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "active = #{active,jdbcType=BIT},",
          "create_date = #{createDate,jdbcType=TIMESTAMP},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where customer_id = #{customerId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(Customer record);
}