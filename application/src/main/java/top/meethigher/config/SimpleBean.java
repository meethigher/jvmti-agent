package top.meethigher.config;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {

    private String name = "init";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
