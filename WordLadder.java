

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String []> queue = new LinkedList<String []>();
        String[] startLevel = {beginWord,"1"};
        queue.add(startLevel);
        HashMap visitedWords = new HashMap();

        // int level = 0
        while(!queue.isEmpty()){
            String [] tempList = queue.remove();
            String curWord = tempList[0];
            int level = Integer.parseInt(tempList[1]);
            
            for(int i=0;i<wordList.size();i++){
                if (!visitedWords.containsKey(i)){
                    if(check_neighbours(curWord,wordList.get(i))){

                        if (wordList.get(i).equals(endWord)){
                            return level+1;
                        }
                        String [] tempWordLevel = {wordList.get(i),Integer.toString(level+1)};
                        queue.add(tempWordLevel) ;
                        visitedWords.put(i, 1);
                    }
                }
            }
        }
        return 0;
    }
    
    public boolean check_neighbours(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }else{
            boolean foundChangedLetter = false;
            for(int i =0;i<word1.length();i++){
               if(word1.charAt(i) != word2.charAt(i)){
                   if (foundChangedLetter){
                       return false;
                   }
                   foundChangedLetter = true;
               }//if
            }//for
            return true;
        }//else
    }
}
