import java.util.HashMap;
import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov{
    private HashMap< WordGram , ArrayList<String>> myMap = new HashMap<>();


    public EfficientWordMarkov(){
        this(3);
        myMap = new HashMap<>();
    }



    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
        //setTraining(myText);
    }

    /**
     * Return word given its index
     * @param key (wordgram) for the map to find next word elements
     * @return arraylist of next strings
     * @throws NoSuchElementException if there is no element in the map with that key
     */
    @Override
    public ArrayList<String> getFollows(WordGram key){


          if(myMap.containsKey(key))
            return myMap.get(key);
          else
            throw new NoSuchElementException(key+" not in map");



    }
    /**
     * Return word given its index
     * @param text to be used as training set
     * @void
     */
    @Override
    public void setTraining(String text) {
        myMap.clear();

        myWords = text.split("\\s+");
        System.out.print("PART 1" + myWords.length);
        int count = 0;
    for(int i = 0; i < myWords.length - myOrder + 1; i++)
    {

        WordGram w = new WordGram(myWords, i, myOrder);




           try {

              // if (!myMap.containsKey(w)) {
                   ArrayList<String> list = myMap.getOrDefault(w, new ArrayList<String>());


                   if(i + myOrder == myWords.length) {
                       list.add(PSEUDO_EOS);
                   }
                   else {
                       list.add(myWords[i + myOrder]);
                   }
                   myMap.put(w, list);

               /*} else
                   myMap.get(w).add(myWords[i + myOrder]);
*/
           }catch(ArrayIndexOutOfBoundsException e)
        {


           if(!myMap.containsKey(w))
           {
               ArrayList<String> list = new ArrayList<>();
               list.add(PSEUDO_EOS);
               myMap.put(w,list);
           }
           break;

        }

    }


    }
}
