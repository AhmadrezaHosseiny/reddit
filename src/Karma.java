import java.util.ArrayList;
import java.lang.reflect.Array;
public class Karma {
    public Account account;
    public int upVote;
    public int downVote;
    Karma() {
    }
    Karma(Post p, String vote) {
        if (vote.equals("+")) {
            this.upVote = 1;
        }
        else if (vote.equals("-")) {
            this.downVote = 1;
        }
        p.karmas.add(this);
    }
    Karma(Comment c, String vote) {
        if (vote.equals("+")) {
            this.upVote = 1;
        }
        else if (vote.equals("-")) {
            this.downVote = 1;
        }
        c.karmas.add(this);
    }
    public static Karma sum(Subreddit s) {
    //todo
        return null;
    }
    public static Karma sum(Post p) {
        Karma result = new Karma();
        for (Karma k : p.karmas) {
            result.upVote += k.upVote;
            result.downVote += k.downVote;
        }
        return result;
    }
    public static Karma sum(Comment c) {
        Karma result = new Karma();
        for (Karma k : c.karmas) {
            result.upVote += k.upVote;
            result.downVote += k.downVote;
        }
        return result;
    }









}
