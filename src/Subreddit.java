import java.util.ArrayList;
public class Subreddit {
    public String topic;
    public Account admin;
    public ArrayList<Post> posts = new ArrayList<>();
    Subreddit(String topic) {
        this.topic = topic;
        this.admin = Reddit.currentAccount;
        Reddit.subreddits.add(this);
    }
    public void show() {
        System.out.println("\r\nSubreddit:\tTopic: " + topic + " \t " + "User: " + Reddit.currentAccount.username);
    }
    public void showTable() {
        System.out.println(topic + " \t " + Reddit.currentAccount.username);
    }
    public static Subreddit search(String topic) {
        for (Subreddit s : Reddit.subreddits) {
            if (s.topic.equals(topic)) return s;
        }
        return null;
    }









}
