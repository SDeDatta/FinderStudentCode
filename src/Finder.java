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
    public static final long P = 2305843009213693951L;
    ArrayList<String[]> arr;
    public Finder()
    {
        arr = new ArrayList<>();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        //Array of ArrayLists
        int lineCount = 0;
        int arrCounter = 0;//
        String line = br.readLine();
        while(line != null)
        {
            String[] words = line.split(",");
            String str1 = words[0];
            String str2 = words[1];
            lineCount++;
            String[] inner = new String[2];
            int index = hash(str1);
            inner[0] = str1;
            inner[1] = str2;
            arr.add(index, inner);
            arrCounter++;
        }
        // Hash function that can calculate a unique index for an arraylist
        // Array of Arraylists that each hold a key and a value;
        br.close();
    }
    public static int hash(String t)
    {
        int m = t.length();
        long h = 0;
        for(int i = 0; i < m; i++)
        {
            // Shift previous hash value to make room for the new character and adds current character
            h = (h * RADIX + t.charAt(i)) %  P;
        }
        return (int) h;
    }
    public String query(String key)
    {
        // TODO: Complete the query() function!
        int val = hash(key);
        String value = "";
        if(val >= 0 && val < arr.size())
        {
            if(arr.get(val) != null)
            {
               value = arr.get(val)[(1)];
            }
        }
        if(value != null)
        {
            return value;
        }
        return INVALID;
    }
}