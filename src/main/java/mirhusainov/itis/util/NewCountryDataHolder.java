package mirhusainov.itis.util;

import org.hibernate.validator.constraints.NotBlank;

import javax.naming.Name;

/**
 * Created by Ruslan on 03.05.2017.
 */
public class NewCountryDataHolder {

    @NotBlank(message = "enter country name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
