import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

//Problem -> Find all numbers disappeared in an array
class AllNumsMissingInArray{

    public static List<Integer> allNumsMissingInArray(int[] nums){
        ArrayList<Integer> missing_nums = new ArrayList<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        //put integers from 1 to array size(n) as keys in the hashMap, each with value 0
        for(int i  = 1; i <= nums.length; i++){
            hashMap.put(i,0);
        }
        //update hashMap
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            int value = hashMap.get(current);
            hashMap.replace(current, value, value+1);
        }

        //iterate through the hashMap
        hashMap.forEach((k,v)->{
            if(v == 0){
                missing_nums.add(k);
            }
        });
        return missing_nums;
    }
    public static void main(String[] args){
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> missing_nums = allNumsMissingInArray(arr);
        for(int i = 0; i < missing_nums.size(); i++){
            System.out.println(missing_nums.get(i));
        }
    }

}