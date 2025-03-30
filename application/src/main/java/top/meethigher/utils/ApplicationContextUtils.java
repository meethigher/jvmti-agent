package top.meethigher.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import top.meethigher.config.SimpleBean;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {


    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac = applicationContext;
    }


    public static ApplicationContext getApplicationContext() {
        return ac;
    }

    public static SimpleBean getSimpleBean() {
        return ac.getBean(SimpleBean.class);
    }
}
