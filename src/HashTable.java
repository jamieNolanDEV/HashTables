public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data;


    class HashEntry{
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable(){
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value){
        int index = getIndex(key);

        HashEntry entry = new HashEntry(key, value);

        if(data[index] == null){
            data[index] = entry;
        }
        else{
            HashEntry entries = data[index];
            //linked list part
            while(entries.next !=null){
                entries = entries.next;
            }
            entries.next = entry;
        }
    }


    public String get(String key){
        int index = getIndex(key);

        HashEntry entries = data[index];

        if(entries != null){
            while(!entries.key.equals(key) && entries.next != null){
                entries = entries.next;
            }
            return entries.value;
        }
        return null;
    }
    public int getIndex(String key){
        int hashCode = key.hashCode();

        System.out.println("Hash code" +hashCode);
        int index = hashCode % INITIAL_SIZE;

        System.out.println("Index" +index);

        return index;

    }


}
