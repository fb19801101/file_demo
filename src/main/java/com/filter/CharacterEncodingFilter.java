package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-24 12:52
 */
public class CharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding("GBK");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}
}