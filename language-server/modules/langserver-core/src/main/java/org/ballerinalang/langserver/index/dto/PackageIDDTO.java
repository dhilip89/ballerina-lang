/*
*  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.langserver.index.dto;

/**
 * DTO for Package.
 */
public class PackageIDDTO {

    private int id;
    
    private String name;
    
    private String orgName;
    
    private String version;

    public PackageIDDTO(String name, String orgName, String version) {
        this.name = name;
        this.orgName = orgName;
        this.version = version;
    }

    public PackageIDDTO(int id, String name, String orgName, String version) {
        this.id = id;
        this.name = name;
        this.orgName = orgName;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getVersion() {
        return version;
    }
}
