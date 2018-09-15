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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RentalMapper {
    @Delete({
        "delete from rental",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rentalId);

    @Insert({
        "insert into rental (rental_id, rental_date, ",
        "inventory_id, customer_id, ",
        "return_date, staff_id, ",
        "last_update)",
        "values (#{rentalId,jdbcType=INTEGER}, #{rentalDate,jdbcType=TIMESTAMP}, ",
        "#{inventoryId,jdbcType=INTEGER}, #{customerId,jdbcType=SMALLINT}, ",
        "#{returnDate,jdbcType=TIMESTAMP}, #{staffId,jdbcType=TINYINT}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Rental record);

    @InsertProvider(type=RentalSqlProvider.class, method="insertSelective")
    int insertSelective(Rental record);

    @Select({
        "select",
        "rental_id, rental_date, inventory_id, customer_id, return_date, staff_id, last_update",
        "from rental",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rental_id", property="rentalId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rental_date", property="rentalDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="inventory_id", property="inventoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="customer_id", property="customerId", jdbcType=JdbcType.SMALLINT),
        @Result(column="return_date", property="returnDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.TINYINT),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Rental selectByPrimaryKey(Integer rentalId);

    @UpdateProvider(type=RentalSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Rental record);

    @Update({
        "update rental",
        "set rental_date = #{rentalDate,jdbcType=TIMESTAMP},",
          "inventory_id = #{inventoryId,jdbcType=INTEGER},",
          "customer_id = #{customerId,jdbcType=SMALLINT},",
          "return_date = #{returnDate,jdbcType=TIMESTAMP},",
          "staff_id = #{staffId,jdbcType=TINYINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where rental_id = #{rentalId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Rental record);
}