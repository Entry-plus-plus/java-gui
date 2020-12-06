import java.util.ArrayList;
import java.util.List;

public class Group {

    String groupName = "New group";

    List<User> members = new ArrayList<>();

    boolean canSeeDashboard = true;
    boolean canSeeRooms = true;
    boolean canSeeSettings = true;
    boolean canSeeData = true;
    boolean canSeeContact = true;

    public Group(String groupName) {
        this.groupName = groupName;
    }
}
