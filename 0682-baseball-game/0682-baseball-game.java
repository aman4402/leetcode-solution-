import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        // Iterate through each operation in the input array
        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("+")) {
                int last = stack.peek();
                int secondLast = stack.get(stack.size() - 2);
                stack.push(last + secondLast);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        // Calculate the sum of all valid scores left in the stack
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        return total;
    }
}