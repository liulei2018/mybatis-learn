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

import com.ll.test.model.Inventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface InventoryMapper {
    @Delete({
        "delete from inventory",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer inventoryId);

    @Insert({
        "insert into inventory (inventory_id, film_id, ",
        "store_id, last_update)",
        "values (#{inventoryId,jdbcType=INTEGER}, #{filmId,jdbcType=SMALLINT}, ",
        "#{storeId,jdbcType=TINYINT}, #{lastUpdate,jdbcType=TIMESTAMP})"
    })
    int insert(Inventory record);

    @InsertProvider(type=InventorySqlProvider.class, method="insertSelective")
    int insertSelective(Inventory record);

    @Select({
        "select",
        "inventory_id, film_id, store_id, last_update",
        "from inventory",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="inventory_id", property="inventoryId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="film_id", property="filmId", jdbcType=JdbcType.SMALLINT),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.TINYINT),
        @Result(column="last_update", property="lastUpdate", jdbcType=JdbcType.TIMESTAMP)
    })
    Inventory selectByPrimaryKey(Integer inventoryId);

    @UpdateProvider(type=InventorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Inventory record);

    @Update({
        "update inventory",
        "set film_id = #{filmId,jdbcType=SMALLINT},",
          "store_id = #{storeId,jdbcType=TINYINT},",
          "last_update = #{lastUpdate,jdbcType=TIMESTAMP}",
        "where inventory_id = #{inventoryId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Inventory record);
}