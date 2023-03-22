package whatsApp.model;

import java.util.List;
import java.util.Set;

public class Group {
    private Set<User>users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Group() {
    }

    public Group(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "users=" + users +
                '}';
    }
}
