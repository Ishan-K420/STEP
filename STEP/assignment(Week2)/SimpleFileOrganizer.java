import java.util.*;

public class SimpleFileOrganizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> files = new ArrayList<>();
        System.out.println("Enter file names (empty line to stop):");
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            files.add(line);
        }

        System.out.printf("%-20s %-12s %-20s%n", "Original", "Category", "New Name");
        int doc = 0, img = 0, audio = 0, video = 0, unknown = 0;
        for (String name : files) {
            String ext = "";
            int dot = name.lastIndexOf('.');
            if (dot > 0 && dot < name.length() - 1) ext = name.substring(dot + 1).toLowerCase();
            String cat;
            if (ext.equals("txt") || ext.equals("doc")) { cat = "Document"; doc++; }
            else if (ext.equals("jpg") || ext.equals("png")) { cat = "Image"; img++; }
            else if (ext.equals("mp3") || ext.equals("wav")) { cat = "Audio"; audio++; }
            else if (ext.equals("mp4") || ext.equals("avi")) { cat = "Video"; video++; }
            else { cat = "Unknown"; unknown++; }
            String newName = cat + "_" + (dot > 0 ? name.substring(dot) : "");
            System.out.printf("%-20s %-12s %-20s%n", name, cat, newName);
        }

        System.out.println("\nCategory Counts:");
        System.out.println("Documents: " + doc);
        System.out.println("Images: " + img);
        System.out.println("Audio: " + audio);
        System.out.println("Video: " + video);
        System.out.println("Unknown: " + unknown);
    }
}