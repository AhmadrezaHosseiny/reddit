import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Post {
    public String title;
    public String text;
    public Account account;
    public ArrayList<Comment> comments = new ArrayList<>();
    public ArrayList<String> tags = new ArrayList<>();
    public ArrayList<Karma> karmas = new ArrayList<>();
    Post(String title, String text, Subreddit s) {
        this.title = title;
        this.text = text;
        s.posts.add(this);
        this.account = Reddit.currentAccount;
    }
    public void show() {
        System.out.println("Title: " + this.title);
        System.out.println("Text: " + this.text);
    }
    public void showTable(String prefix) {
        System.out.println(prefix + this.title + "\t\t" + this.text);
    }
    public void showComments() {
        for (Comment c : comments) {
            c.show();
        }
    }
    public static Post search(String title) {
        for (Post p : Reddit.currentSubreddit.posts) {
            if (p.title.equals(title)) return p;
        }
        return null;
    }







}
