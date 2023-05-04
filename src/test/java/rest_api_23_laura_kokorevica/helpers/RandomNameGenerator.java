package rest_api_23_laura_kokorevica.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomNameGenerator {
    private String name;

    public void setName() {
        name = RandomStringUtils.random(5);
    }

    public String getName() {
        return name;
    }
}
