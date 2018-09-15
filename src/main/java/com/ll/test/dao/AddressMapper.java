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
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AddressMapper {
    @Delete({
        "delete from address",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int deleteByPrimaryKey(Short addressId);

    @Insert({
        "insert into address (address_id, address, ",
        "address2, district, ",
        "city_id, postal_code, ",
        "phone, last_update, ",
        "location)",
        "values (#{addressId,jdbcType=SMALLINT}, #{address,jdbcType=VARCHAR}, ",
        "#{address2,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{cityId,jdbcType=SMALLINT}, #{postalCode,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{lastUpdate,jdbcType=TIMESTAMP}, ",
        "#{location,jdbcType=BINARY})"
    })
    int insert(Address record);

    @InsertProvider(type=AddressSqlProvider.class, method="insertSelective")
    int insertSelective(Address record);

    @Select({
        "select",
        "address_id, address, address2, district, city_id, postal_code, phone, last_update, ",
        "location",
        "from address",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    @Results({
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="address2", property="address2", jdbcType=JdbcType.VARCHAR),
        @Result(column="district", property="district", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.SMALLINT),
        @Result(column="postal_code", property="postalCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="location", property="location", jdbcType=JdbcType.BINARY)
    })
    Address selectByPrimaryKey(Short addressId);

    @UpdateProvider(type=AddressSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Address record);

    @Update({
        "update address",
        "set address = #{address,jdbcType=VARCHAR},",
          "address2 = #{address2,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "city_id = #{cityId,jdbcType=SMALLINT},",
          "postal_code = #{postalCode,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP},",
          "location = #{location,jdbcType=BINARY}",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Address record);

    @Update({
        "update address",
        "set address = #{address,jdbcType=VARCHAR},",
          "address2 = #{address2,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "city_id = #{cityId,jdbcType=SMALLINT},",
          "postal_code = #{postalCode,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where address_id = #{addressId,jdbcType=SMALLINT}"
    })
    int updateByPrimaryKey(Address record);
}