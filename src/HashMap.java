public class HashMap
{
    public static final long RADIX = 256;
    public static final int DEFAULT_TABLE_SIZE = 2;
    int tableSize;
    int n;
    String[] keys;
    String[] values;

    public HashMap(int numElements)
    {
        tableSize = DEFAULT_TABLE_SIZE;
        this.keys = new String[n];
        this.values = new String[n];
    }
    public int hash(String key)
    {
        int m = key.length();
        int h = 0;
        for(int i = 0; i < m; i++)
        {
            // Shift previous hash value to make room for the new character and adds current character
            h = (int) ((h * RADIX + key.charAt(i)) %  (tableSize*2 -1));
        }
        return h;
    }
    void add(String key, String value)
    {

    }
    String get(String key)
    {
        int val = hash(key);
        int trueVal = val;
        if(values[val] == )
        {

        }
    }
    public void resize()
    {
        tableSize *= 2;
    }

}
