import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

class AllNumsMissingInArray{

    public static int[] allNumsMissingInArray(int[] arr){
        ArrayList<Integer> missing_nums = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        //put integers from 1 to array size(n) as keys in the hashMap, each with value 0
        for(int i  = 1; i <= arr.length; i++){
            hashMap.put(i,0);
        }
        //update hashMap
        for(int i = 0; i < arr.length; i++){
            int current = arr[i];
            int value = hashMap.get(current);
            hashMap.replace(current, value, value+1);
        }

        //get all keys in the hashMap
        Set<Integer> keys = hashMap.keySet();
        Integer[] keys_Integer = keys.toArray(new Integer[keys.size()]);

        for(int i = 0; i < keys_Integer.length; i++){
            if(hashMap.get(keys_Integer) == 0){
                int missing_int = keys_Integer[i].intValue();
                missing_nums.add(missing_int);
            }
        }

        return missing_nums_array;
    }
    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        int[] missing_nums_array = allNumsMissingInArray(arr);
    }

}