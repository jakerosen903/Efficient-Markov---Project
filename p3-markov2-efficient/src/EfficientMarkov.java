import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
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
	public ArrayList<String> getFollows(String key){


		if(!myMap.containsKey(key))
			throw new NoSuchElementException(key+" not in map");
		else
			return myMap.get(key);



		//myMap.clear();



	}
	/**
	 * Return word given its index
	 * @param text to create training set
	 * @void
	 */
	@Override
	public void setTraining(String text){

	myText = text;
	String sub;


	for(int i = 0; i < myText.length() - myOrder + 1; i++)
	{
		sub = myText.substring(i, i + myOrder);
		try {

			//if (!myMap.containsKey(sub)) {
				ArrayList<String> list = myMap.getOrDefault(sub, new ArrayList<String>());


				if(i == text.length() - myOrder)
					list.add(PSEUDO_EOS);
				else
					list.add(myText.substring(i + myOrder, i + myOrder + 1));

				myMap.put(sub, list);

			/*} else
				myMap.get(myText.substring(i, i + myOrder)).add(myText.substring(i + myOrder, i + myOrder + 1));
		*/}
		catch (StringIndexOutOfBoundsException e)
		{
			if(!myMap.containsKey(sub)) {
				ArrayList<String> list = new ArrayList<>();
				list.add(PSEUDO_EOS);
				myMap.put(sub, list);
			}
		}
	}


	}


}	
