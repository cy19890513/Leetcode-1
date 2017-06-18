package yang;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import com.google.gson.Gson;
//import org.json.simple.*;
//import org.json.simple.JSONObject;
//json id, name, parentId
// san francisco bay area, south bay, san jose -south bay --san jose





public class Test1 {
	
	static class Location implements Comparable< Location >{
	    public Integer id;
	    public String name;
	    public Integer parent_id ;
	    

		@Override
		public int compareTo(Location o) {
			// TODO Auto-generated method stub
			return this.name.compareTo( o.name );
		}
	}
	class Locations{
		public List<Location> objects;
	}
	
	
	public static String jasonString = "{\"objects\":[{\"id\":1,\"name\":\"Chicago -+" +
			"\",\"parent_id\":null},{\"id\":2,\"name\":\"San Jose\",\"parent_id\":3},{\"id\":3,\"name\":\"South Bay\",\"parent_id\":4},{\"id\":4,\"name\":\"San Francisco Bay Area\",\"parent_id\":null}]}";
	public static HashMap<Integer, ArrayList<Location>> map;
    public static void main(String args[] ) throws Exception {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // String input = br.readLine();
        
        //List< ArrayList<Location>> Biglist = new ArrayList<ArrayList<Location>>();
        map = new HashMap<Integer, ArrayList<Location>>();
        
        Locations locs = new Gson().fromJson(jasonString, Locations.class);
        List<Location> locList = locs.objects;
        
        for(Location l:locList){
        	if(!map.containsKey(l.parent_id)){
        		ArrayList<Location> locsValue = new ArrayList<Location>();
        		locsValue.add(l);
        		map.put(l.parent_id, locsValue);
        	}else{
        		ArrayList<Location> locsValue = map.get(l.parent_id);
        		locsValue.add(l);
        	}
        	
        }
        
        printMap(null,0);
        
        System.out.println("Hello world");
    }
    
    public static void printMap(Integer parentId ,int level){
    	StringBuilder sbd = new StringBuilder();
    	for(int i=0;i<level;i++){
    		sbd.append("-");
    	}
    	
    	List<Location> locList = map.get(parentId);
    	Collections.sort(locList);
    	
    	for(int i=0;i<locList.size();i++){
    		System.out.println(sbd.toString()+locList.get(i).name);
    		if(map.containsKey(locList.get(i).id)){
    			printMap(locList.get(i).id,level+1);
    		}
       	}
    	
    }
    
    
    
}


