package org.example.csrf.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.owasp.csrfguard.CsrfGuardFilter;
import org.owasp.csrfguard.CsrfGuardHttpSessionListener;
import org.owasp.csrfguard.CsrfGuardServletContextListener;
import org.owasp.csrfguard.servlet.JavaScriptServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import lombok.extern.java.Log;

@Log
public class WebConfig implements ServletContextInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.info("onStartup");
		configContext();
		servletContext.addListener(addCsrfGuardServletContextListener());
		servletContext.addListener(addCsrfGuardHttpSessionListener());
		servletContext = addCsrfGuardFilter(servletContext);
		servletContext = setOwaspParams(servletContext);
		addJavaScriptServlet(servletContext);
	}

	private WebApplicationContext configContext() {
		log.info("Retrieving Context");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation("hello");
		return context;
	}

	private ServletContext addJavaScriptServlet(ServletContext servletContext) {
        log.info("Adding jsServlet");
		ServletRegistration.Dynamic jsServlet = servletContext.addServlet("JavaScriptServlet", JavaScriptServlet.class);
		jsServlet.addMapping("/JavaScriptServlet");
		jsServlet.setLoadOnStartup(2);
		return servletContext;
	}
	
	private ServletContext addCsrfGuardFilter(ServletContext servletContext) {
		log.info("Adding addCsrfGuardFilter");
		servletContext.addFilter("CSRFGuard", new CsrfGuardFilter()).addMappingForUrlPatterns(null, false,"/*");
		return servletContext;
	}
	
	private CsrfGuardHttpSessionListener addCsrfGuardHttpSessionListener() {
		log.info("Adding CsrfGuardHttpSessionListener");
		return new CsrfGuardHttpSessionListener();
	}

	private CsrfGuardServletContextListener addCsrfGuardServletContextListener() {
		log.info("Adding CsrfGuardServletContextListener");
		return new CsrfGuardServletContextListener();
	}
	
	private ServletContext setOwaspParams(ServletContext servletContext) {
		log.info("Setting setOwaspParams");
		servletContext.setInitParameter("Owasp.CsrfGuard.Config", "WEB-INF/Owasp.CsrfGuard.properties");
		servletContext.setInitParameter("Owasp.CsrfGuard.Config.Print", "true");
		return servletContext;
	}

}
