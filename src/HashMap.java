import java.util.Objects;

public class HashMap
{
    public static final long RADIX = 256;
    // Creates a reasonable initial table size based on resizing ability and max data set size
    public static final int DEFAULT_TABLE_SIZE = 997;
    int tableSize;
    int n;
    String[] keys;
    String[] values;

    public HashMap()
    {
        n = 0;
        tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[DEFAULT_TABLE_SIZE];
        this.values = new String[DEFAULT_TABLE_SIZE];
    }
    public int hash(String key)
    {
        int m = key.length();
        int h = 0;
        for(int i = 0; i < m; i++)
        {
            // Shift previous hash value to make room for the new character and adds current character
            h = (int) ((h * RADIX + key.charAt(i)) %  tableSize);
        }
        return h;
    }
    public void add(String key, String value)
    {
        // Ensures load factor is below 0.5 to avoid long linear probing sequences
        if(n > 0.5 * tableSize)
        {
            resize();
        }
        int index = hash(key);
        while(keys[index] != null)
        {
            // Moves 1 index over and wraps around to beginning of map in case of collision
            index = (index + 1) % tableSize;
        }
        keys[index] = key;
        values[index] = value;
        // Keeps track of number of elements currently in the map
        n++;
    }
    public String get(String key)
    {
        int val = hash(key);
        int index = val;
        while(keys[index] != null)
        {
            // Finds the proper index for a given key and returns its value
            if(keys[index].equals(key))
            {
                return values[index];
            }
            index = (index + 1) % tableSize;
        }
       return null;
    }
    // Increases map size to avoid long linear probing chains
    public void resize()
    {
        // Resizes 1 more than double to keep table size odd to avoid collisions
        tableSize *= 2 + 1;
        String oldKeys[] = keys;
        String oldValues[] = values;
        keys = new String[tableSize];
        values = new String[tableSize];
        for (int i = 0; i < oldKeys.length; i++)
        {
            if(oldKeys[i] != null)
            {
                // Adds old values back to newly sized keys and values arrays
                add(oldKeys[i], oldValues[i]);
            }
        }
    }

}
