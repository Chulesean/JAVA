import java.util.*;

public class HW1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        StringBuilder max = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    int value = sc.nextInt();
                    mainStack.push(value);
                    if (maxStack.isEmpty()) {
                        maxStack.push(value);
                    } else {
                        maxStack.push(Math.max(value, maxStack.peek()));
                    }
                    break;

                case "pop":
                    mainStack.pop();
                    maxStack.pop();
                    break;

                case "max":
                    max.append(maxStack.peek()).append('\n');
                    break;
            }
        }
        System.out.println(max);
    }
}