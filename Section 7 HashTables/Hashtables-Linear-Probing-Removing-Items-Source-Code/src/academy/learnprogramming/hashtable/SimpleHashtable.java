package academy.learnprogramming.hashtable;

public class SimpleHashtable {
    private StoredEmployee[] hashtable;

    public SimpleHashtable() {
        this.hashtable = new StoredEmployee[10];
    }

    public void put(String key, Employee employee){
        int hashedKey = this.hashKey(key);
        if(this.isOccupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == this.hashtable.length - 1) {
                hashedKey = 0;
            }else{
                hashedKey++;
            }

            while (this.isOccupied(hashedKey) && hashedKey != stopIndex){
                hashedKey = (hashedKey + 1) % this.hashtable.length;
            }
        }
        if(this.hashtable[hashedKey] != null) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
            return;
        }

        this.hashtable[hashedKey] = new StoredEmployee(key, employee);
    }

    public Employee get(String key){
        int hashedKey = this.findKey(key);
        if(hashedKey == -1){
            return null;
        }
        return this.hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = this.findKey(key);

        if(hashedKey == -1){
            return null;
        }

        Employee employee = this.hashtable[hashedKey].employee;
        this.hashtable[hashedKey].employee = null;
        return employee;
    }

    private int hashKey(String key) {
        return key.length() % this.hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = this.hashKey(key);
        if(this.hashtable[hashedKey] != null && this.hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == this.hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (this.hashtable[hashedKey] != null && hashedKey != stopIndex && !this.hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % this.hashtable.length;
        }

        if(this.hashtable[hashedKey] != null && this.hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    private boolean isOccupied(int index) {
        return this.hashtable[index] != null;
    }

    public void print() {
        for (int i = 0; i < this.hashtable.length; i++) {
            if(this.hashtable[i] == null) {
                System.out.println("Empty");
                continue;
            }
            System.out.println("Position " + i + ": " + this.hashtable[i].employee);
        }
    }
}
