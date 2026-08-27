class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int n=height.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            int element=(i==n)?0:height[i];
            while(!stack.isEmpty() && height[stack.peek()]>element){
                int h=height[stack.pop()];
                int ps=(stack.isEmpty())?-1:stack.peek();
                int w=i-ps-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);
        }
        return (max==Integer.MIN_VALUE)?0:max;

    }

}