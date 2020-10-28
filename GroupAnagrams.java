import java.util.*;
public class  GroupAnagrams{
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> sortedStrs = new ArrayList<>();
        //sort each string alphabetically and add to an arrayList called sortedStrs
        for(int i = 0; i < strs.length; i++){
            String currentString = strs[i];
            char[] charArray = currentString.toCharArray();
            //sort the charArray in alphabetical order
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);
            sortedStrs.add(sortedString);
        }
        /*Testing*/
        System.out.println("Sorted Strings:");
        for(String eachStr: sortedStrs){
            System.out.print(eachStr + " ");
        }
        System.out.println("End of sorted strings:");
        /**********************************************/
        /*  In a hashMap, store ecah string and the corresponding indexes  */
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        Integer index0 = new Integer(0);
        list0.add(index0);
        hashMap.put(sortedStrs.get(0), list0);
        for(int j = 1; j < sortedStrs.size(); j++){
            String currentString = sortedStrs.get(j);
            if(hashMap.containsKey(currentString)){
                ArrayList<Integer> currentValue = hashMap.get(currentString);
                /*add the index of the currentString to the ArrayList(value of that key in the hashMap)*/
                currentValue.add(j);
                hashMap.replace(currentString, currentValue);
            }else{
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(new Integer(j));
                hashMap.put(currentString, indexList);
            }
        }
        //Get set of values(set of arrayLists) of the hashMap
        Collection<ArrayList<Integer>> values = hashMap.values();
        ArrayList<ArrayList<Integer>> valuesList = new ArrayList<>(values);
        List<List<String>> finalList = new ArrayList<>();
        //iterate through values list
        /****************Testing***********************/
        System.out.println("Printing the values of the hashMap: ->");
        /*********************************************/
        for(ArrayList<Integer> list : valuesList){
            ArrayList<String> innerList = new ArrayList<>();
            System.out.println("List: ->");
            for(Integer index : list){
                System.out.print(index+" ");
                innerList.add(strs[index]);
            }
            finalList.add(innerList);
        }
        return finalList;
    }

    public static void main(String[] args){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> finalList = GroupAnagrams.groupAnagrams(strs);
        for(List<String> list : finalList){
            List<String> innerList = new ArrayList<>();
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println("");
        }
    }

}
