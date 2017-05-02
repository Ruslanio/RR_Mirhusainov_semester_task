package mirhusainov.itis.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Ruslan on 27.04.2017.
 */
public class SignUpDataHolder {

    @Email
    @NotBlank(message = "this field required")
    private String email;

    private String name;

    @NotBlank(message = "this field required")
    private String password;

    @NotBlank(message = "this field required")
    private String repeatedPassword;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
