import java.util.ArrayList;
public class Subreddit {
    public String topic;
    public ArrayList<Account> memberAccounts = new ArrayList<>();
    public ArrayList<Post> posts = new ArrayList<>();
    public Account admin;
    Subreddit(String topic) {
        this.topic = topic;
        this.admin = Reddit.currentAccount;
        Reddit.subreddits.add(this);
    }
    public void showTable() {
        System.out.println(topic + " \t " + Reddit.currentAccount.username);
    }
    public void show() {
        System.out.println("\r\nSubreddit\tTopic: " + topic + " \t " + "Username: " + Reddit.currentAccount.username);
    }
    public static Subreddit search(String topic) {
        for (Subreddit s : Reddit.subreddits) {
            if (s.topic.equals(topic)) return s;
        }
        return null;
    }









}
