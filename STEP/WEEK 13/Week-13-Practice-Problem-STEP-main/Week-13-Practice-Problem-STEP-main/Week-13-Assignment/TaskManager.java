class Task {
    String name;
    int time;
    Task next;
    
    Task(String name, int time) {
        this.name = name;
        this.time = time;
        this.next = null;
    }
}

class TaskManager {
    Task tail;
    
    void addTask(String name, int time) {
        Task newTask = new Task(name, time);
        if (tail == null) {
            tail = newTask;
            newTask.next = newTask;
        } else {
            newTask.next = tail.next;
            tail.next = newTask;
            tail = newTask;
        }
    }
    
    void executeRoundRobin() {
        if (tail == null) return;
        
        Task current = tail.next;
        
        while (tail != null) {
            System.out.print(current.name + " ");
            current.time--;
            
            if (current.time == 0) {
                if (current == tail && current.next == current) {
                    tail = null;
                    break;
                } else {
                    Task temp = current;
                    if (current == tail) {
                        tail = findPrevious(current);
                    }
                    
                    Task prev = findPrevious(current);
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
        System.out.println("(All Completed)");
    }
    
    Task findPrevious(Task target) {
        Task current = tail.next;
        while (current.next != target) {
            current = current.next;
        }
        return current;
    }
    
    void displayTasks() {
        if (tail == null) return;
        
        Task current = tail.next;
        do {
            System.out.print(current.name + "(" + current.time + "s) ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        
        // Add tasks T1(3s), T2(2s), T3(4s)
        tm.addTask("T1", 3);
        tm.addTask("T2", 2);
        tm.addTask("T3", 4);
        
        System.out.print("Tasks: ");
        tm.displayTasks();
        
        System.out.print("Execution order: ");
        tm.executeRoundRobin();
    }
}