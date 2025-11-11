import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Surya De Datta
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    HashMap map;
    public Finder()
    {
        map = new HashMap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException
    {
        String line = br.readLine();
        // Reads through the buffered read object line by line
        while(line != null)
        {
            // Divides each line into it's key and value
            String[] words = line.split(",");
            map.add(words[keyCol],words[valCol]);
            line = br.readLine();
        }
        br.close();
    }
    public String query(String key)
    {
        // Ensures a value is present for a given key using map
        String value = map.get(key);
        if(value != null)
        {
            return value;
        }
        return INVALID;
    }
}