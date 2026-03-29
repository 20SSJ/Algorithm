import java.io.*;
import java.util.*;

class Solution {
    
    static int[] island;
    static Node[] edgeList;
    static class Node implements Comparable<Node>{
        int from, to, weight;
        
        public Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(weight, o.weight);
        }
    }
    
    private static int find(int i){
        if(island[i] < 0) return i;
        return island[i] = find(island[i]);
    }
    
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot == bRoot) return false;
        
        if(island[aRoot] <= island[bRoot]){
            island[aRoot] += island[bRoot];
            island[bRoot] = aRoot;
        } else{
            island[bRoot] += island[aRoot];
            island[aRoot] = bRoot;
        }
        
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        edgeList = new Node[costs.length];
        
        for(int i = 0; i < costs.length; i++){
            int A = costs[i][0];
            int B = costs[i][1];
            int E = costs[i][2];
            edgeList[i] = new Node(A, B, E);
        }
        
        Arrays.sort(edgeList);
        
        island = new int[n];
        for(int i = 0; i < n; i++){
            island[i] = -1;
        }
        
        int count = 0;
        for(Node edge: edgeList){
            if(union(edge.from, edge.to)){
                answer += edge.weight;
                if(++count == n - 1);
            }
        }
        
        return answer;
    }
}