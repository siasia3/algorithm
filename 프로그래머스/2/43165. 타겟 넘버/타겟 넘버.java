class Solution {
    
    public int[] numArr;
    public int globalTarget;
    public int count;
    
    public int solution(int[] numbers, int target) {
        globalTarget = target;
        numArr = numbers;
        
        DFS(numArr[0],1, 0);
        DFS(-numArr[0],1, 0);
    
        return count;
    }
    
    public void DFS(int number,int depth,int sum){

        sum += number;

        if(globalTarget==sum && (depth == numArr.length)){
            count++;
            return;
        }
        if(depth >= numArr.length){
            return;
        }

        DFS(numArr[depth],depth+1,sum);
        DFS(-numArr[depth],depth+1,sum);

    }
}