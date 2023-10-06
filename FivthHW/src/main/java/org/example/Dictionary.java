package org.example;

import java.util.*;
import java.util.Map.Entry;

public class Dictionary {
   private Map<String, String> words = new HashMap<String,String>();
   private Map<String, Integer> wordCount = new HashMap<String,Integer>();

   public Dictionary(){
       words.put("Hello", "Привет");
       words.put("Goodbye", "Пока");
       words.put("House", "Дом");
       words.put("Garden", "Сад");
   }

   public String translateWord(String word)
   {
       int count = 0;
       if(wordCount.get(word) != null)
           count = wordCount.get(word);

       wordCount.put(word, count + 1);
       String result =  this.words.get(word);
      return result != null ? result : "The word has not been found!";
   }
   public String addWordWithTranslation(String word, String translation){
      return this.words.put(word, translation);
   }
   public String getTopTenMostSearchedWords(){
       StringBuilder builder = new StringBuilder();
       List<Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
       Collections.sort(entries, Comparator.comparing((Entry<String, Integer> entry) -> entry.getValue()).reversed());
       int count = 0;
       for (Entry<String, Integer> entry : entries) {
           count++;
           builder.append(entry.getKey() + ": " + entry.getValue() + "\n");
           if (count == 10)
               break;
       }
       return builder.toString();
   }
   public String changeTranslation(String word, String newTranslation){
       String result = words.replace(word, newTranslation);
     return result !=null ? result : "The word has not been found!" ;
   }
    public String changeWord(String keyWord, String newKeyWord){
        if (words.containsKey(keyWord)) {
            String value = words.get(keyWord);
            words.remove(keyWord);
            words.put(newKeyWord, value);
            return "The word has been added! New key is " + newKeyWord;
        } else
            return "The word has not been found!";

    }
    public String getTopTenLeastSearchedWords(){
        StringBuilder builder = new StringBuilder();
        List<Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        Collections.sort(entries, Comparator.comparing((Entry<String, Integer> entry) -> entry.getValue()));
        int count = 0;
        for (Entry<String, Integer> entry : entries) {
            count++;
            builder.append(entry.getKey() + ": " + entry.getValue() + "\n");
            if (count == 10)
                break;
        }
        return builder.toString();
    }
}
