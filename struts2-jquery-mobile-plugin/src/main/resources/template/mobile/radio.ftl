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
<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<div data-role="fieldcontain">
<#if hasFieldErrors>
<#list fieldErrors[parameters.name] as error>
        <div class="errorMessage">${error}</div><#t/>
</#list>
</#if>
 	<fieldset data-role="controlgroup"
 	<#if parameters.horizontal?default(false)>
		data-type="horizontal"
	</#if>
 	>
<#if parameters.label??>
    <legend><#t/>
<#if parameters.required?default(false) && parameters.requiredposition?default("right") != 'right'>
        <span class="required">*</span><#t/>
</#if>
${parameters.label}<#t/>
<#if parameters.required?default(false) && parameters.requiredposition?default("right") == 'right'>
 <span class="required">*</span><#t/>
</#if>
${parameters.labelseparator?default(":")}<#t/>
</legend><#t/>
</#if>
<#if parameters.list?? >
<@s.iterator value="parameters.list">
    <#if parameters.listKey??>
        <#assign itemKey = stack.findValue(parameters.listKey)/>
    <#else>
        <#assign itemKey = stack.findValue('top')/>
    </#if>
    <#assign itemKeyStr = itemKey.toString() />
    <#if parameters.listValue??>
        <#assign itemValue = stack.findString(parameters.listValue)/>
    <#else>
        <#assign itemValue = stack.findString('top')/>
    </#if>
<input type="radio"<#rt/>
<#if parameters.name??>
 name="${parameters.name}"<#rt/>
</#if>
 id="${parameters.id}${itemKeyStr}"<#rt/>
<#if tag.contains(parameters.nameValue?default(''), itemKeyStr)>
 checked="checked"<#rt/>
</#if>
<#if itemKey??>
 value="${itemKeyStr}"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex}"<#rt/>
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
/><#rt/>
<label for="${parameters.id}${itemKeyStr}"><#rt/>
    ${itemValue}<#t/>
</label>
</@s.iterator>
</#if>
     </fieldset>
<#include "/${parameters.templateDir}/mobile/controlfooter.ftl" />
 