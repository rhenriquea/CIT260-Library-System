import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    private static void saveAndQuit() {
        System.out.println("Enter the filename to save:");
        // String fileName = userInput.next() + ".json";

        JSONObject library = new JSONObject();
        library.put("name", "BYU-I Library System");
        library.put("location", "Rexburg, Idaho");

        // JSONArray librarians = new JSONArray();
        // JSONArray borrowers = new JSONArray();
        // JSONArray books = new JSONArray();

        // library.put("librarians", librarians);
        // library.put("borrowers", borrowers);
        // library.put("books", books);

       /* try(FileWriter file = new FileWriter(fileName)) {
            file.write(library.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        running = false;*/
    }

    private static void loadFile(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(fileName + ".json"));
            JSONObject jsonObj = (JSONObject) obj;
            String name = (String) jsonObj.get("name");
            System.out.println("Name is " + name);
            String location = (String) jsonObj.get("name");
            System.out.println("Location is " + location);

            // Loop Array
            JSONArray books = (JSONArray) jsonObj.get("books");
            books.forEach(b -> parseBookObj((JSONObject) b));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseBookObj(JSONObject b) {
        String author = (String) b.get("author");
        String title = (String) b.get("title");
        System.out.println(author + " wrote " + title);
    }

}
