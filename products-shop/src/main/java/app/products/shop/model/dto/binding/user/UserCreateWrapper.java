package app.products.shop.model.dto.binding.user;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCreateWrapper {

    private int count = 1;

    @XmlElement(name = "user")
    private List<UserCreateBindingModel> users;

    public List<UserCreateBindingModel> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        users.forEach(s -> {
            sb.append(count++ + " ")
                    .append(s)
                    .append("\n");
        });
        return sb.toString();
    }


}
