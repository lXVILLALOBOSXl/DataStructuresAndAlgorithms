package academy.learnprogramming.hashtable;

public class SimpleHashtable {
    private Employee[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new Employee[10];
    }

    public void put(String key, Employee employee){
        int hashedkey = hashKey(key);

        if(this.hashtable[hashedkey] != null) {
            System.out.println("Sorry, there's already an employee at position " + hashedkey);
            return;
        }

        this.hashtable[hashedkey] = employee;
    }

    public Employee get(String key){
        int hashedKey = hashKey(key);
        return this.hashtable[hashedKey];
    }

    private int hashKey(String key) {
        return key.length() % this.hashtable.length;
    }

    public void print() {
        for (int i = 0; i < this.hashtable.length; i++) {
            System.out.println(this.hashtable[i]);
        }
    }
}
