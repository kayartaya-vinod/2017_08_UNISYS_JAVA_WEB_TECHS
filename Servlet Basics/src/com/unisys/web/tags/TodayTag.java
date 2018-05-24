package com.unisys.web.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TodayTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	private String pattern = null;
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			// this is the same "out" found int he JSP
			// where this tag is used, and DO NOT close the same
			JspWriter out = pageContext.getOut();
			Date dt = new Date();
			if(pattern==null){
				out.print(dt);
			}
			else {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				out.print(sdf.format(dt));
			}
		} catch (IOException e) {
		}

		return super.doStartTag();
	}
}
