package com.labs.catalog.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.labs.catalog.service.beans.InfoService;

@WebServlet(urlPatterns = "/info", initParams = { @WebInitParam(name = "message", value = "hi") })
public class InfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected final Log logger = LogFactory.getLog(getClass());

    private InfoService infoService;

    private ApplicationContext ctx;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ctx = (ApplicationContext) config.getServletContext().getAttribute("springApplicationContext");
        infoService = ctx.getBean(InfoService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        infoService.showMessage();

        resp.setContentType("text/html");

        ClassPathResource helloTemplate = (ClassPathResource) ctx.getResource("classpath:hello-template.html");

        byte[] buffer = new byte[10240];

        try (InputStream input = helloTemplate.getInputStream(); OutputStream output = resp.getOutputStream();) {
            for (int length = 0; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            output.flush();
        }

    }

}
