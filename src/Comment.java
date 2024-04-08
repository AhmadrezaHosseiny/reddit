import java.util.ArrayList;
public class Comment {
    public String text;
    public Account account;
    public ArrayList<Karma> karmas = new ArrayList<>();
    Comment(String text, Post p) {
        p.comments.add(this);
        this.text = text;
        this.account = Reddit.currentAccount;
    }
    public void show() {
        System.out.println("Text: " + this.text);              //write
    }
    public void showTable(String prefix) {                    //write
        System.out.println(prefix + this.text);
    }
    public static Comment search(String text) {
        for (Comment c : Reddit.currentPost.comments) {       //write
            if (c.text.equals(text)) return c;
        }
        return null;
    }








}
