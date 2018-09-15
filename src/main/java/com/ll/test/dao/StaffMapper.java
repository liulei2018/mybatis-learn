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

import com.ll.test.model.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StaffMapper {
    @Delete({
        "delete from staff",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte staffId);

    @Insert({
        "insert into staff (staff_id, first_name, ",
        "last_name, address_id, ",
        "email, store_id, ",
        "active, username, password, ",
        "last_update, picture)",
        "values (#{staffId,jdbcType=TINYINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{addressId,jdbcType=SMALLINT}, ",
        "#{email,jdbcType=VARCHAR}, #{storeId,jdbcType=TINYINT}, ",
        "#{active,jdbcType=BIT}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{lastUpdate,jdbcType=TIMESTAMP}, #{picture,jdbcType=LONGVARBINARY})"
    })
    int insert(Staff record);

    @InsertProvider(type=StaffSqlProvider.class, method="insertSelective")
    int insertSelective(Staff record);

    @Select({
        "select",
        "staff_id, first_name, last_name, address_id, email, store_id, active, username, ",
        "password, last_update, picture",
        "from staff",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="first_name", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.SMALLINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.TINYINT),
        @Result(column="active", property="active", jdbcType=JdbcType.BIT),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="picture", property="picture", jdbcType=JdbcType.LONGVARBINARY)
    })
    Staff selectByPrimaryKey(Byte staffId);

    @UpdateProvider(type=StaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Staff record);

    @Update({
        "update staff",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "active = #{active,jdbcType=BIT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "picture = #{picture,jdbcType=LONGVARBINARY}",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Staff record);

    @Update({
        "update staff",
        "set first_name = #{firstName,jdbcType=VARCHAR},",
          "last_name = #{lastName,jdbcType=VARCHAR},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "active = #{active,jdbcType=BIT},",
          "username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where staff_id = #{staffId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Staff record);
}