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
           int numSteps ;
           public WordNode (String word , int numSteps) {
               this.word = word ;
               this.numSteps = numSteps ;
           }
       }
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
             LinkedList<WordNode> queue = new LinkedList<WordNode>();
              queue.add( new WordNode(beginWord ,1));
              wordList.add( endWord);
             
              while (!queue .isEmpty()){
                    WordNode top = queue.remove();
                    String word = top. word;
                     if (word .equals(endWord )){
                            return top .numSteps;
                    }
                    
                     char[] arr = word .toCharArray();
                     for (int i =0; i <arr .length ;i ++){
                            for (char c ='a' ;c <='z' ;c ++) {
                                  char tmp = arr [i ];
                                  if (arr [i ]!=c ) {
                                         arr[ i] = c;
                                 }
                                 String newWord = new String(arr );
                                  if (wordList .contains(newWord)) {
                                         queue.add( new WordNode(newWord , top.numSteps +1));
                                         wordList.remove( newWord); // 移除已访问的结点
                                 }
                                  arr[ i] = tmp;
                           }
                    }
             }
              return 0;           
       }
        public static void main(String srgs[]) {
             Solution s = new Solution();
             Set<String> wordList = new HashSet<String>();
        wordList.add( "hot");
        wordList.add( "dot");
        wordList.add( "dog");
        wordList.add( "lot");
        wordList.add( "log");
              int len = s .ladderLength("hit", "cog", wordList );
             System. out.println(len );
       }
}
