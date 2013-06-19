
package cofh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraftforge.common.Configuration;

public class FriendRegistry {

    public static Map<String, List<String>> friends = new HashMap<String, List<String>>();

    public static Configuration friendConf;

    public static List<String> getFriendList(String player) {

        if (player == null || friends.get(player) == null) {
            return null;
        }
        return friends.get(player);
    }

    public static boolean isFriend(String player, String friend) {

        if (player == null || friend == null) {
            return false;
        }
        if (friends.get(player) == null) {
            return false;
        }
        return friends.get(player).contains(friend);
    }

    public static boolean addFriend(String player, String friend) {

        if (player == null || friend == null) {
            return false;
        }
        if (friends.get(player) == null) {
            friends.put(player, new ArrayList());
        }
        if (friends.get(player).contains(friend)) {
            return false;
        }
        friends.get(player).add(friend);
        return true;
    }

    public static boolean removeFriend(String player, String friend) {

        if (player == null || friend == null) {
            return false;
        }
        if (friends.get(player) == null) {
            return false;
        }
        friends.get(player).remove(friend);
        return true;
    }

}
