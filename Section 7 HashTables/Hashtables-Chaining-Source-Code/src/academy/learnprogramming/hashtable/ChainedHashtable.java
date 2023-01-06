package academy.learnprogramming.hashtable;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {

    private LinkedList<StoredEmployee>[] hashtable;

    public ChainedHashtable(){
        this.hashtable = new LinkedList[10];
        for (int i = 0; i < this.hashtable.length; i++) {
            this.hashtable[i] = new LinkedList<StoredEmployee>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = this.hashKey(key);
        this.hashtable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key){
        int hashedKey = this.hashKey(key);
        ListIterator<StoredEmployee> iterator = this.hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if(employee.key.equals(key)){
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = this.hashKey(key);
        ListIterator<StoredEmployee> iterator = this.hashtable[hashedKey].listIterator();
        StoredEmployee employee = null;
        int index = -1;
        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if(employee.key.equals(key)){
                break;
            }
        }

        if(employee == null || !employee.key.equals(key)) {
            return null;
        }

        hashtable[hashedKey].remove(index);
        return employee.employee;
    }

    private int hashKey(String key) {
        //return key.length() % this.hashtable.length;
        return Math.abs(key.hashCode() % this.hashtable.length);
    }

    public void print() {
        for (int i = 0; i < this.hashtable.length; i++) {
            if(this.hashtable[i].isEmpty()){
                System.out.println("Position " + i + ": empty");
                continue;
            }

            System.out.print("Position " + i + ": NULL <- ");
            ListIterator<StoredEmployee> iterator = this.hashtable[i].listIterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next().employee);
                System.out.print(" <=> ");
            }
            System.out.println("NULL");
        }
    }
}
