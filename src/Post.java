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
        s.posts.add(this);
        this.text = text;
        this.title = title;
        this.account = Reddit.currentAccount;
    }
    public void show() {
        System.out.println("Title: " + this.title);
        System.out.println("Text: " + this.text);
        Karma k = Karma.sum(this);
        System.out.println("Karma Upvote: " + k.upVote + "\tDownvote: " + k.downVote);
    }
    public void showRow(String prefix) {
        Karma k = Karma.sum(this);
        String ks = " +" + Integer.toString(k.upVote) + " -" + Integer.toString(k.downVote);
        System.out.println(prefix +
                String.format("%-15s",v + this.account.username) +
                String.format("%-15s",v + this.title) +
                String.format("%-25s",v + this.text) +
                String.format("%-15s",v + ks) +
                v);
    }
    static String tl = "┌";
    static String tr = "┐";
    static String v = "│";
    static String h = "─";
    static String t = "┬";
    static String c = "┼";
    static String dr = "┘";
    static String d = "┴";
    static String dl = "└";
    static String r = "┤";
    static String l = "├";
    public static void showTableHeader(String prefix) {
        System.out.println(prefix + "\r\nPosts Table");
        System.out.println(prefix + tl + h.repeat(14) + t + h.repeat(14) + t + h.repeat(24) + t + h.repeat(14) + tr);
        System.out.println(prefix +
                String.format("%-15s",v + "Username") +
                String.format("%-15s",v + "Title") +
                String.format("%-25s",v + "Text") +
                String.format("%-15s",v + "Karma") + v);
        System.out.println(prefix + l + h.repeat(14) + c + h.repeat(14) + c + h.repeat(24) + c + h.repeat(14) + r);
    }
    public static  void showTableFooter(String prefix) {
        System.out.println(prefix + dl + h.repeat(14) + d + h.repeat(14) + d + h.repeat(24) + d + h.repeat(14) + dr);
    }
    public static Post search(String title) {
        for (Post p : Reddit.currentSubreddit.posts) {
            if (p.title.equals(title)) return p;
        }
        return null;
    }







}
