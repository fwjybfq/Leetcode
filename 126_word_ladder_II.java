/**
 * 
 */
package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wenfang
 *
 */
public class Solution {
	public class WordNode {
	    String word;
	    int numSteps;
	    WordNode pre;
	    public WordNode (String word, int numSteps, WordNode pre) {
	    	this.word = word;
	    	this.numSteps = numSteps;
	    	this.pre = pre;
	    }
	}
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	LinkedList<WordNode> queue = new LinkedList<WordNode>();
    	queue.add(new WordNode(beginWord,1,null));
    	wordList.add(endWord);
    	int minStep = 0;
    	
    	HashSet<String> visited = new HashSet<String>();
    	HashSet<String> unvisited = new HashSet<String>();
    	unvisited.addAll(wordList);
    	
    	int preNumSteps = 0;
    	while (!queue.isEmpty()){
    		WordNode top = queue.remove();
    		String word = top.word;
    		int currNumSteps = top.numSteps;
    		
    		if (word.equals(endWord)){
    			if (minStep == 0){
    				minStep = top.numSteps;
    			}
    			if (top.numSteps == minStep && minStep!=0){
    				ArrayList<String> t = new ArrayList<String>();
    				t.add(top.word);
    				while (top.pre!=null){
    					t.add(0,top.pre.word);
    					top = top.pre;
    				}
    				result.add(t);
    				continue;
    			}
    		}
    		if (preNumSteps < currNumSteps) {
    			/*
    			 *这里preNumSteps指的是前一个从queue中移出的结点的steps，其实也就是上一个结点在图中的层数
    			 *currNumSteps指的是当前从queue中移出的正在进行处理的结点
    			 *只有当steps发生变化，才将置为visited 的结点从unvisited中移除，即在同一层的结点，不会走到这里
    			 *以便于后面unvisited.contains(newWord)进行处理
    			 * */
    			unvisited.removeAll(visited);
    		}
    		preNumSteps = currNumSteps;
    		char[] arr = word.toCharArray();
    		for (int i=0;i<arr.length;i++){
    			for (char c='a';c<='z';c++){
    				char tmp = arr[i];
    				if (arr[i]!=c){
    					arr[i] = c;
    				}
    				
    				String newWord = new String(arr);
    				if (unvisited.contains(newWord)){
    					queue.add(new WordNode(newWord,top.numSteps+1,top));
    					visited.add(newWord);
    				}
    				arr[i] = tmp;
    			}
    		}
    	}
    	return result;
    }
	public static void main(String srgs[]) {
		Solution s = new Solution();
		Set<String> wordList = new HashSet<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        List<List<String>> result1 = s.findLadders("hit", "cag", wordList);
		System.out.println(result1);
	}
}
