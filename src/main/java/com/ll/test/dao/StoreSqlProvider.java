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
import org.apache.ibatis.jdbc.SQL;

public class StoreSqlProvider {

    public String insertSelective(Store record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("store");
        
        if (record.getStoreId() != null) {
            sql.VALUES("store_id", "#{storeId,jdbcType=TINYINT}");
        }
        
        if (record.getManagerStaffId() != null) {
            sql.VALUES("manager_staff_id", "#{managerStaffId,jdbcType=TINYINT}");
        }
        
        if (record.getAddressId() != null) {
            sql.VALUES("address_id", "#{addressId,jdbcType=SMALLINT}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Store record) {
        SQL sql = new SQL();
        sql.UPDATE("store");
        
        if (record.getManagerStaffId() != null) {
            sql.SET("manager_staff_id = #{managerStaffId,jdbcType=TINYINT}");
        }
        
        if (record.getAddressId() != null) {
            sql.SET("address_id = #{addressId,jdbcType=SMALLINT}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("store_id = #{storeId,jdbcType=TINYINT}");
        
        return sql.toString();
    }
}