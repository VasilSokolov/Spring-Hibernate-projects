package app.game.store.model.dto.json;

import com.google.gson.annotations.Expose;

public class UserDto {

    @Expose
    private String email;

    @Expose
    private String password;

    @Expose
    private String fullName;

    public UserDto() {
    }

    public UserDto(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserDto [email=" + email + ", password=" + password + ", fullName=" + fullName + "]";
    }


}
