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

package com.jgeppert.struts2.jquery.components;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.UIBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Slider. 
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>Examples</p>
 * 
 * <!-- START SNIPPET: example1 -->
 * &lt;sj:slider id="myslider" name="myslider"/&gt;
 * <!-- END SNIPPET: example1 -->
 * 
 */
@StrutsTag(name="slider", tldTagClass="com.jgeppert.struts2.jquery.views.jsp.ui.SliderTag", description="Render a Slider")
public class Slider extends UIBean {

    final public static String TEMPLATE = "slider";
    final protected static Logger LOG = LoggerFactory.getLogger(Slider.class);
    final private static transient Random RANDOM = new Random();    
    
    protected String animate;
    protected String max;
    protected String min;
    protected String orientation;
    protected String range;
    protected String step;
    protected String start;
    protected String slide;
    protected String change;
    protected String stop;
    protected String displayValueElement;
   
    public Slider(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateParams() {
        super.evaluateParams();

        if(animate != null)
          addParameter("animate", findValue(animate, Boolean.class));
        if(max != null)
            addParameter("max", findString(max));
        if(min != null)
            addParameter("min", findString(min));
        if(orientation != null)
            addParameter("orientation", findString(orientation));
        if(range != null)
            addParameter("range", findString(range));
        if(step != null)
          addParameter("step", findString(step));
        if(start != null) 
          addParameter("start", findString(start));
        if(slide != null) 
          addParameter("slide", findString(slide));
        if(change != null) 
          addParameter("change", findString(change));
        if(stop != null) 
          addParameter("stop", findString(stop));
        if(displayValueElement != null) 
          addParameter("displayValueElement", findString(displayValueElement));
        if(value != null) 
          addParameter("value", findValue(value));
        
        if ((this.id == null || this.id.length() == 0)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs 
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);  
            this.id = "slider_" + String.valueOf(nextInt);
            addParameter("id", this.id);
        }
    }
    
    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getTheme() {
        return "jquery";
    }
    
    @StrutsTagAttribute(description="Whether to slide handle smoothly when user click outside handle on the bar. Default: false", defaultValue="false", type="Boolean")
    public void setAnimate(String animate)
    {
      this.animate = animate;
    }

    @StrutsTagAttribute(description="Initialize a slider with the max option specified. Default: 100")
    public void setMax(String max)
    {
      this.max = max;
    }

    @StrutsTagAttribute(description="The minimum value of the slider. Default: 0")
    public void setMin(String min)
    {
      this.min = min;
    }

    @StrutsTagAttribute(description="Normally you don't need to set this option because the plugin detects the slider orientation automatically. If the orientation is not correctly detected you can set this option to 'horizontal' or 'vertical'. Default: 'auto'")
    public void setOrientation(String orientation)
    {
      this.orientation = orientation;
    }

    @StrutsTagAttribute(description="If set to true, the slider will detect if you have two handles and create a stylable range element between these two. Two other possible values are 'min' and 'max'. A min range goes from the slider min to one handle. A max range goes from one handle to the slider max.")
    public void setRange(String range)
    {
      this.range = range;
    }

    @StrutsTagAttribute(description="Determines the size or amount of each interval or step the slider takes between min and max. The full specified value range of the slider (max - min) needs to be evenly divisible by the step. Default: 1")
    public void setStep(String step)
    {
      this.step = step;
    }

    @Override
    @StrutsTagAttribute(description="Determines the value of the slider. Default: 0")
    public void setValue(String value) {
      super.setValue(value);
    }

    @StrutsTagAttribute(description="This event is triggered when the user starts sliding.")
    public void setStart(String start)
    {
      this.start = start;
    }

    @StrutsTagAttribute(description="This event is triggered on every mouse move during slide.")
    public void setSlide(String slide)
    {
      this.slide = slide;
    }

    @StrutsTagAttribute(description="This event is triggered on slide stop, or if the value is changed programmatically.")
    public void setChange(String change)
    {
      this.change = change;
    }

    @StrutsTagAttribute(description="This event is triggered when the user stops sliding.")
    public void setStop(String stop)
    {
      this.stop = stop;
    }

    @StrutsTagAttribute(description="Element Id to display the value.")
    public void setDisplayValueElement(String displayValueElement)
    {
      this.displayValueElement = displayValueElement;
    }

}