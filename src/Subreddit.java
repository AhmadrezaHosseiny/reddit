import java.util.ArrayList;
public class Subreddit {
    public String topic;
    public ArrayList<Account> memberAccounts = new ArrayList<>();
    public static ArrayList<Post> posts = new ArrayList<>();
    public Account admin;
    public void showPosts() {
        for (Post p : posts) {
            //p.showPostText();
        }
    }
    public void show() {
        //todo println topic admin
    }









}
