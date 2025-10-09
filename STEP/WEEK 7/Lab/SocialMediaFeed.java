class Post {
    String author, content, time;
    Post(String author, String content, String time) {
        this.author = author; this.content = content; this.time = time;
    }
    public void display() {
        System.out.println(author + " - " + content + " (" + time + ")");
    }
}

class InstagramPost extends Post {
    int likes; String hashtags;
    InstagramPost(String author, String content, String time, int likes, String hashtags) {
        super(author, content, time);
        this.likes = likes; this.hashtags = hashtags;
    }
    @Override
    public void display() {
        System.out.println("Instagram: " + author);
        System.out.println(content);
        System.out.println("Hashtags: " + hashtags);
        System.out.println("Likes: " + likes);
        System.out.println(time);
    }
}

class TwitterPost extends Post {
    int retweets;
    TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }
    @Override
    public void display() {
        System.out.println("Twitter: @" + author);
        System.out.println(content);
        System.out.println("Chars: " + content.length());
        System.out.println("Retweets: " + retweets);
        System.out.println(time);
    }
}

class LinkedInPost extends Post {
    int connections;
    LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }
    @Override
    public void display() {
        System.out.println("LinkedIn: " + author);
        System.out.println(content);
        System.out.println("Connections: " + connections);
        System.out.println(time);
    }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post p1 = new InstagramPost("Alice", "Enjoying the sunset!", "6:00 PM", 120, "#sunset #nature");
        Post p2 = new TwitterPost("Bob", "Hello Twitter world!", "7:15 PM", 30);
        Post p3 = new LinkedInPost("Charlie", "Excited to join a new role.", "9:00 AM", 500);
        p1.display();
        p2.display();
        p3.display();
    }
}