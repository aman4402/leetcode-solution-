class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population=new int[101];
        int maxpopulation=0;
        int answer=1950;
        int currentpopulation=0;
        for(int i=0;i<logs.length;i++){
            int birth=logs[i][0];
            int death=logs[i][1];
            population[birth-1950]++;
            population[death-1950]--;
        }
        for(int i=0;i<population.length;i++){
            currentpopulation+=population[i];
            if(currentpopulation>maxpopulation){
                maxpopulation=currentpopulation;
                answer=i+1950; 
            }
        }
        return answer;
    }
}