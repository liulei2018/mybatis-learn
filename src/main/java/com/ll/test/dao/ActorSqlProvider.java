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

import com.ll.test.model.Actor;
import org.apache.ibatis.jdbc.SQL;

public class ActorSqlProvider {

    public String insertSelective(Actor record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("actor");
        
        if (record.getActorId() != null) {
            sql.VALUES("actor_id", "#{actorId,jdbcType=SMALLINT}");
        }
        
        if (record.getFirstName() != null) {
            sql.VALUES("first_name", "#{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.VALUES("last_name", "#{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.VALUES("last_update", "#{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Actor record) {
        SQL sql = new SQL();
        sql.UPDATE("actor");
        
        if (record.getFirstName() != null) {
            sql.SET("first_name = #{firstName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastName() != null) {
            sql.SET("last_name = #{lastName,jdbcType=VARCHAR}");
        }
        
        if (record.getLastUpdate() != null) {
            sql.SET("last_update = #{lastUpdate,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("actor_id = #{actorId,jdbcType=SMALLINT}");
        
        return sql.toString();
    }
}