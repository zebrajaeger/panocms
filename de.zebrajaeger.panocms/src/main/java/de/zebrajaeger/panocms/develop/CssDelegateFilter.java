package de.zebrajaeger.panocms.develop;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Lars Brandt, Silpion IT Solutions GmbH
 */
@WebFilter(
        servletNames = {"OpenCmsServlet", "OpenCmsServletErrorHandler"},
        dispatcherTypes = {DispatcherType.REQUEST})
public class CssDelegateFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CssDelegateFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        boolean isDelegated = false;
        try {

            // TODO only while developement
            //if (Stage.DEV == Environment.getInstance().getStage() && servletRequest instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            Path path = Paths.get(req.getRequestURI());

            // is file in delegate list?
            String fileName = path.getFileName().toString();
            String delegateUrl = Delegate.getInstance().get(fileName);
            if (delegateUrl != null) {
                String content = readRemoteContent(delegateUrl);
                if (content != null) {
                    servletResponse.getWriter().write(content);
                    isDelegated = true;
                }
            }
            //}
        } finally {
            if (!isDelegated) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }

    private String readRemoteContent(String url) {
        String result = null;
        try {
            URLConnection con = new URL(url).openConnection();
            con.setConnectTimeout(500);
            con.setReadTimeout(5000);
            result = IOUtils.toString(con.getInputStream(), StandardCharsets.UTF_8);
        } catch (SocketTimeoutException ignore) {
            LOG.warn("Could not connect File not found :'{}'", url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            LOG.warn("File not found :'{}'", url);
        } catch (IOException ignore) {

        }
        return result;
    }
}
