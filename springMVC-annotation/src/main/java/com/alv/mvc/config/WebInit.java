package com.alv.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author ：tangxin
 * @date ：Created in 2022/11/18 15:21
 * @description：
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @Author tx
     * @Date 2022/11/18 15:25
     * @Description  指定Spring配置类  不过还没有进行ssm整合 所以这里创建出来就好 不然就return一个0的数组
     * @Param []
     * @Return java.lang.Class<?>[]
     * @Since version-1.0
     */

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * @Author tx
     * @Date 2022/11/18 15:26
     * @Description 指定SpringMVC的配置类
     * @Param []
     * @Return java.lang.Class<?>[]
     * @Since version-1.0
     */

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    /**
     * @Author tx
     * @Date 2022/11/18 15:43
     * @Description  指定dispatcherServlet映射规则 也就是urlpattern 也就是”/“
     * @Param []
     * @Return java.lang.String[]
     * @Since version-1.0
     */


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * @Author tx
     * @Date 2022/11/18 15:56
     * @Description  注册过滤器
     * @Param []
     * @Return javax.servlet.Filter[]
     * @Since version-1.0
     */


    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
