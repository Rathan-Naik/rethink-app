/*
Copyright 2020 RethinkDNS developers

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.celzero.bravedns.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.celzero.bravedns.service.FirewallRuleset
import com.celzero.bravedns.util.Constants.Companion.INIT_TIME_MS

@Entity(tableName = "ConnectionTracker")
class ConnectionTracker {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    var appName: String = ""
    var uid: Int = 0
    var ipAddress: String = ""
    var port: Int = 0
    var protocol: Int = 0
    var isBlocked: Boolean = false
    var blockedByRule: String = ""
    var flag: String = ""
    var dnsQuery: String? = null
    var timeStamp: Long = INIT_TIME_MS

    override fun equals(other: Any?): Boolean {
        if (other !is ConnectionTracker) return false
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return this.id.hashCode()
    }
}
