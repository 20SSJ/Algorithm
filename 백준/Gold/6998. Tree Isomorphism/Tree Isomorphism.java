import java.io.*;
import java.util.*;

public class Main {

	static class Node{
		int num;
		String value;
		
		public Node(int num, String value) {
			this.num = num;
			this.value = value;
		}
	}
    private static boolean solveTreeIsomorphism(String one, String two) {
        /* *
         *
         * The procedure should return true if the two trees (represented by one, and two) are isomorphic to each other.
         *
         * */

    	if(one.length() != two.length()) return false;
    	
    	StringTokenizer st = new StringTokenizer(one);
    	StringTokenizer st2 = new StringTokenizer(two);
    	int SIZE = one.length() / 2 + 1;
    	
    	List<Node> treeOne [] = new ArrayList[SIZE];
    	List<Node> treeTwo [] = new ArrayList[SIZE];
    	
    	for(int i = 0; i < SIZE; i++) {
    		treeOne[i] = new ArrayList<>();
    		treeTwo[i] = new ArrayList<>();
    	}
    	
    	String rootOne = st.nextToken();
    	treeOne[0].add(new Node(0, rootOne));
    	int idx = 0;
    	int level = 0;
    	boolean bflg = true;
    	for(int i = 1; i < SIZE; i++) {
    		String v = st.nextToken();
    		if(v.equals("#")) {
    			level--;
    		}
    		if(v.equals("#") && bflg) {
    			idx = i - 2;
    			bflg = false;
    		} else if(!v.equals("#") && bflg){
    			treeOne[++level].add(new Node(i - 1, v));
    		} else if(!v.equals("#")){
    			treeOne[level++].add(new Node(idx, v));
    			bflg = true;
    		}
    	}
    	
    	String rootTwo = st2.nextToken();
    	treeTwo[0].add(new Node(0, rootTwo));
    	bflg = true;
    	level = 0;
    	for(int i = 1; i < SIZE; i++) {
    		String v = st2.nextToken();
    		if(v.equals("#")) {
    			level--;
    		}
    		if(v.equals("#") && bflg) {
    			idx = i - 2;
    			bflg = false;
    		} else if(!v.equals("#") && bflg){
    			treeTwo[++level].add(new Node(i - 1, v));
    		} else if(!v.equals("#")){
    			treeTwo[level++].add(new Node(idx, v));
    			bflg = true;
    		}
    	}
        /* -------------------- END OF INSERTION --------------------*/
    	
    	for(int i = 0; i < SIZE; i++) {
    		if(treeOne[i].size() != treeTwo[i].size()) return false;
    	}
    	
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(br.readLine());
        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String line1 = br.readLine();
            String line2 = br.readLine();

            System.out.println("The two trees are " + (solveTreeIsomorphism(line1, line2) ? "isomorphic." : "not isomorphic."));
        }
        br.close();
    }
}
