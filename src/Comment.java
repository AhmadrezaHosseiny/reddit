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
        System.out.println("Username: " + this.account.username);
        System.out.println("Text: " + this.text);
        Karma k = Karma.sum(this);
        System.out.println("Karma Upvote: " + k.upVote + "Downvote: " + k.downVote);
    }
    public void showTable(String prefix) {
        System.out.println(prefix + this.account.username + "\t" + this.text);
    }
    public static Comment search(String text) {
        for (Comment c : Reddit.currentPost.comments) {
            if (c.text.equals(text)) return c;
        }
        return null;
    }








}
