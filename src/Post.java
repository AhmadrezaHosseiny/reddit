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
    public static void createPost() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.print("Enter your title: ");
            String title = br.readLine();
            System.out.print("Enter your text: ");
            String text = br.lines().toString();
            Post p = new Post();
            p.title = title;
            p.text = text;
        }
    }
    public void showPostBody(Post p) {
        System.out.println("Title: " + p.title);
        System.out.println("Text: " + p.text);
    }
    public void showPostComments() {
        for (Comment c : comments) {
            c.show();
        }
    }







}
