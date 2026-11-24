class Solution {
    public String simplifyPath(String path) {
       Stack<String> stack=new Stack<>();
       String[] parts=path.split("/");
       for(int i=0;i<parts.length;i++){
        String dir=parts[i];
        if(dir.equals("")||dir.equals(".")){
            continue;
        }else if(dir.equals("..")){
            if(!stack.isEmpty()){
                stack.pop();
            }
            }else{
                stack.push(dir);
            }
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<stack.size();i++){
            result.append("/");
            result.append(stack.get(i));
            } 
            if(result.length()==0){
                return "/";
            }
        return result.toString();
    }
}