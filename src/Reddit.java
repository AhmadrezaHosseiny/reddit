import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Reddit {
    public static boolean debug = false;
    public static String prefix = "-->";
    public static Post currentPost;
    public static Account currentAccount;
    public static Subreddit currentSubreddit;
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Subreddit> subreddits = new ArrayList<>();
    private static Comment currentComment;
    public static void show(String s) {
        if (debug) System.out.println(prefix + s);
    }
    public static void init() {
        System.out.println("\r\nInitialising...\r\n");
        Account a1 = new Account("u1", "e1@.com", "p1");
        Reddit.currentAccount = a1;
        Reddit.accounts.add(a1);
        Subreddit s1 = new Subreddit("java");
        Subreddit s2 = new Subreddit("c++");
        Subreddit s3 = new Subreddit("python");
        Post p1 = new Post("post1title", "post1text", s1);
        Post p2 = new Post("post2title", "post2text", s1);
        Post p3 = new Post("post3title", "post3text", s2);
        Post p4 = new Post("post4title", "post4text", s3);
        Comment c1 = new Comment("comment1text", p1);
        Comment c2 = new Comment("comment1text", p2);
        Comment c3 = new Comment("comment1text", p3);
        Comment c4 = new Comment("comment1text", p4);
        Comment c5 = new Comment("comment1text", p4);
    }
    public static void createAccount() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        boolean duplicate = false;
        while (!valid) {
            System.out.print("Enter your username: ");//todo check amd repeat if bad input
            String username = br.readLine();
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = new Account(username, email, password);
            if (!a.validateEmail()) {
                System.out.println("Your email is not valid.");
                continue;
            }
            if (!a.validatePassword()) {
                System.out.println("Your password is not valid.");
                continue;
            }
            for (Account b : Reddit.accounts) {
                if (b.email.equals(a.email)) {
                    System.out.println("Your email has been duplicated twice.");
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                duplicate = false;
                continue;
            }
            else {
                Reddit.accounts.add(a);
                System.out.println("\r\nAccount created successfully.");
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
        }
    }
    public static void logIn() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = Account.logIn(email, password);
            if (a != null) {
                Reddit.currentAccount = a;
                System.out.println();
                System.out.println("Logged in successfully.");
                System.out.println();
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
            System.out.println();
            System.out.println("Logged in unsuccessfully.");
            System.out.println();
        }
    }
    public static void logOut() throws IOException {
        Reddit.currentAccount = null;
        System.out.println("Logged out.");
        Reddit.logIn();
    }
    public static void editUsername() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter your username: ");
            String username = br.readLine();
            System.out.print("Enter your email: ");
            String email = br.readLine();
            System.out.print("Enter your password: ");
            String password = br.readLine();
            Account a = new Account(username, email, password);
            if (a.validateEmail() && a.validatePassword()) {
                Reddit.currentAccount.username = a.username;
                Reddit.currentAccount.email = a.email;
                Reddit.currentAccount.password = a.password;
                System.out.println("Account edited successfully.");
                System.out.println(a.username);
                System.out.println(a.email);
                System.out.println(a.password);
                System.out.println();
                valid = true;
            }
            else {
                System.out.println("Account edited unsuccessfully.");
            }
        }
    }
    public static void createSubreddit() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your topic: ");
        String topic = br.readLine();
        Subreddit s = new Subreddit(topic);
        System.out.println("Subreddit created successfully.");
    }
    public static void createPost() throws IOException {
        if (Reddit.currentSubreddit == null) {
            System.out.println("First select subreddit.");
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your title: ");
        String title = br.readLine();
        System.out.print("Enter your text: ");
        String text = br.readLine();
        Post p = new Post(title, text, Reddit.currentSubreddit);
        System.out.println("Post created successfully.");
        p.show();
    }
    public static void createComment() throws IOException {
        if (Reddit.currentPost == null) {
            System.out.println("First select post.");
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your comment: ");
        String text = br.readLine();
        Comment c = new Comment(text, Reddit.currentPost);
        System.out.println("Comment created successfully.");
        c.show();
    }
    public static Subreddit selectSubreddit() throws IOException {
        Subreddit s = null;
        while (s == null) {
            showAllSubreddits();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your topic: ");
            String topic = br.readLine();
            s = Subreddit.search(topic);
        }
        return s;
    }
    public static Post selectPost() throws IOException {
        Post p = null;
        while (p == null) {
            showCurrentSubredditWithPosts();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your selected title: ");
            String title = br.readLine();
            p = Post.search(title);
        }
        return p;
    }
    public static Comment selectComment() throws IOException {
        Comment c = null;
        while (c == null) {
            showCurrentPostWithComments();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));                //write
            System.out.print("Enter your text: ");
            String text = br.readLine();
            c = Comment.search(text);
        }
        return c;
    }
    public static void showAllSubreddits() {
        System.out.print("\r\nList of all subreddits: \r\n");
        System.out.println("Topic\t\tUsername");
        for (Subreddit s : subreddits) s.showTable();
    }
    public static void showAllSubredditsWithPosts() {
        for (Subreddit s : Reddit.subreddits) {
            s.show();
            System.out.println("\tPost\tTitle\t\t\tText");//todo show username
            for (Post p : s.posts) p.showTable("\t\t\t");
        }
    }
    public static void showAllPostsWithComments() {
        for (Post p : Reddit.currentSubreddit.posts) {
            p.show();
            System.out.println("\tComment\t\t\tText");                          //write
            for (Comment c : p.comments) c.showTable("\t\t\t");
        }
    }
    public static void showCurrentSubredditWithPosts() {
        Subreddit s = Reddit.currentSubreddit;
        s.show();
        System.out.println("\tPost\tTitle\t\t\tText");//todo show username
        for (Post p : s.posts) p.showTable("\t\t\t");
    }
    public static void showCurrentPostWithComments() {
        Post p = Reddit.currentPost;
        p.show();                                                                  //write
        System.out.println("\tComment\t\t\tText");//todo show username
        for (Comment c : p.comments) c.showTable("\t\t\t");
    }
    public static void setCurrentSubreddit() throws IOException {
        Reddit.currentSubreddit = Reddit.selectSubreddit();
        System.out.println("Current subreddit topic is: " + Reddit.currentSubreddit.topic);
    }
    public static void setCurrentPost() throws IOException {
        if (Reddit.currentSubreddit == null) {
            System.out.println("First select subreddit.");
            setCurrentSubreddit();
        }
        Reddit.currentPost = Reddit.selectPost();
        System.out.println("Current post is: ");
        Reddit.currentPost.show();
    }
    public static void setCurrentComment() throws IOException {
        if (Reddit.currentPost == null) {
            System.out.println("First select post.");                      //write
            setCurrentPost();
        }
        Reddit.currentComment = Reddit.selectComment();
        System.out.println("Current comment is: ");
        Reddit.currentComment.show();
    }



















}
