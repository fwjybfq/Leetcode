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
    			 *����preNumStepsָ����ǰһ����queue���Ƴ��Ľ���steps����ʵҲ������һ�������ͼ�еĲ���
    			 *currNumStepsָ���ǵ�ǰ��queue���Ƴ������ڽ��д���Ľ��
    			 *ֻ�е�steps�����仯���Ž���Ϊvisited �Ľ���unvisited���Ƴ�������ͬһ��Ľ�㣬�����ߵ�����
    			 *�Ա��ں���unvisited.contains(newWord)���д���
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
