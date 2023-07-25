
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        Dequeue dequeue = new Dequeue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());


        for (int i=0; i<count; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                    case "front" :
                        dequeue.front();
                        break;
                    case "back" :
                        dequeue.back();
                        break;
                    case "size" :
                        dequeue.size();
                        break;
                    case "empty" :
                        dequeue.empty();
                        break;
                    case "pop_front" :
                        dequeue.popFront();
                        break;
                    case "pop_back" :
                        dequeue.popBack();
                        break;
                    case "push_back" :
                        dequeue.pushBack(Integer.parseInt(command[1]));
                        break;
                    case "push_front" :
                        dequeue.pushFront(Integer.parseInt(command[1]));
                        break;
                }
            }
    }
}

class Dequeue {
    private List<Integer> list = new ArrayList<>();

    public void pushBack(int x) {
        list.add(x);
    }

    public void pushFront(int x) {
        list.add(0, x);
    }

    public void popFront() {
        if (list.size() != 0) {
            int element = list.get(0);
            list.remove(0);
            System.out.println(element);
            return;
        }

        System.out.println(-1);
    }

    public void popBack() {
        if (list.size() != 0) {
            int element = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            System.out.println(element);
            return;
        }

        System.out.println(-1);
    }

    public void size() {
        System.out.println(list.size());
    }

    public void empty() {
        System.out.println(list.isEmpty() ? 1 : 0);
    }

    public void front() {
        System.out.println(list.isEmpty() ? -1 : list.get(0));
    }

    public void back() {
        System.out.println(list.isEmpty() ? -1 : list.get(list.size() - 1));
    }


}
