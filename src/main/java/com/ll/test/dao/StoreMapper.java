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

import com.ll.test.model.Store;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface StoreMapper {
    @Delete({
        "delete from store",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    int deleteByPrimaryKey(Byte storeId);

    @Insert({
        "insert into store (store_id, manager_staff_id, ",
        "address_id, last_update)",
        "values (#{storeId,jdbcType=TINYINT}, #{managerStaffId,jdbcType=TINYINT}, ",
        "#{addressId,jdbcType=SMALLINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Store record);

    @InsertProvider(type=StoreSqlProvider.class, method="insertSelective")
    int insertSelective(Store record);

    @Select({
        "select",
        "store_id, manager_staff_id, address_id, last_update",
        "from store",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    @Results({
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.TINYINT, id=true),
        @Result(column="manager_staff_id", property="managerStaffId", jdbcType=JdbcType.TINYINT),
        @Result(column="address_id", property="addressId", jdbcType=JdbcType.SMALLINT),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Store selectByPrimaryKey(Byte storeId);

    @UpdateProvider(type=StoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Store record);

    @Update({
        "update store",
        "set manager_staff_id = #{managerStaffId,jdbcType=TINYINT},",
          "address_id = #{addressId,jdbcType=SMALLINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where store_id = #{storeId,jdbcType=TINYINT}"
    })
    int updateByPrimaryKey(Store record);
}