<#--
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
-->
		<li
<#if parameters.id?if_exists != "">
			id="${parameters.id}"<#rt/>
</#if>
<#if parameters.cssStyle?if_exists != "">
			style="${parameters.cssStyle}"<#rt/>
</#if>
<#if parameters.cssClass?if_exists != "">
 			class="${parameters.cssClass}"<#rt/>
</#if>
<#if parameters.type?if_exists != "">
        data-jstree='{"type" : "${parameters.type}"}'<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
		>
	<#if !parameters.targets?exists && parameters.href?if_exists != ""> 
			<a href="${parameters.href?string}"
            <#if parameters.id?if_exists != "">
               id="${parameters.id}_link"<#rt/>
            </#if>
            ><#rt/>
	<#else>
			<a href="javascript:void(0)"
                <#if parameters.id?if_exists != "">
               id="${parameters.id}_link"<#rt/>
                </#if>
                <#if parameters.targets?if_exists != "">
               data-targets="${parameters.targets}"<#rt/>
                </#if>
            ><#rt/>
	</#if>
<#if parameters.title?if_exists != "">
			${parameters.title}
</#if>
			</a>
			<ul>
