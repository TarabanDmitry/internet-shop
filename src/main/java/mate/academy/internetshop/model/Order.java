package mate.academy.internetshop.model;

import java.util.List;
import mate.academy.internetshop.lib.IdGenerator;

public class Order {

    private User user;
    private Long id;
    private List<Item> itemsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = IdGenerator.getOrderId();
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
