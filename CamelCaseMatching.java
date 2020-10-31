import java.util.*;
public class CamelCaseMatching {
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        //Using 2 pointers - one for pattern(p1) and one for queries(p2)
        //First, split the pattern
        String[] pattern_array = pattern.split("");
        //Split the strings in the queries array
        String[][] queries_array = new String[queries.length][];
        List<Boolean> answerList = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            //split each string into string array - split returns string array
            String[] query_array = queries[i].split("");
            queries_array[i] = query_array;
        }
        //////////////////////
        for(int i = 0;i < pattern_array.length;i++){
            System.out.print(pattern_array[i]+' ');
        }
        //////////////////////
        for(int i = 0; i < queries_array.length; i++){
            Boolean matchResult = match(queries_array[i], pattern_array);
            answerList.add(matchResult);
        }
        return answerList;
    }

    private static boolean match(String[] query_array, String[] pattern_array){
        //pointer for pattern_arary
        int p = 0;
        //pointer for query_array
        int q = 0;
        //pointer to indicate that we found a match for the entire pattern in the query
        int matchFlag = 0;
        System.out.println("p: "+p);
        System.out.println("q: "+q);
        while(p < pattern_array.length || q < query_array.length){
            if(query_array[q].equals(pattern_array[p])){
                if(p == pattern_array.length-1){
                    matchFlag = 1;
                    if(q == query_array.length-1){
                        return true;
                    }
                }
                if(p < pattern_array.length-1){
                    p++;
                }
                if(q < query_array.length-1){
                    q++;
                }
            }else if(query_array[q].equals(query_array[q].toLowerCase())){
                if(q < query_array.length-1){
                    q++;
                }else{
                    break;
                }
            }else{
                return false;
            }
            System.out.println("Flag: "+matchFlag);
            System.out.println("q inside while loop: "+q);
            System.out.println(query_array[q]+" ");
            System.out.println("p inside while loop: "+p);
            System.out.println(pattern_array[p]+" ");
        }
        // if(p == pattern_array.length-1 && q == queries_array[i].length-1 && flag == 1){
        if(matchFlag == 1){
            return true;
        }else{
            return false;
        }
    }



    public static void main(String[] args){
        // String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        // String pattern = "FB";
        // List<Boolean> expectedAnswer = new ArrayList<Boolean>(Arrays.asList(true, false, true, true, false));
        // List<Boolean> finalList = CamelCaseMatching.camelMatch(queries, pattern);
        // for(int i = 0; i < finalList.size(); i++){
        //     System.out.print(finalList.get(i)+ " ");
        // }
        // String[] queries1 = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        // String pattern1 = "FoBaT";
        // List<Boolean> expectedAnswer1 = new ArrayList<Boolean>(Arrays.asList(false,true,false,false,false));
        // List<Boolean> finalList1 = CamelCaseMatching.camelMatch(queries1, pattern1);
        // for(int i = 0; i < finalList1.size(); i++){
        //     System.out.print(finalList1.get(i)+ " ");
        // }

        String[] queries2 = {"IXfGawluvnCa","IsXfGaxwulCa","IXfGawlqtCva","IXjfGawlmeCa","IXfGnaynwlCa","IXfGcamwelCa"};
        String pattern2 = "IXfGawlCa";
        List<Boolean> expectedAnswer2 = new ArrayList<Boolean>(Arrays.asList());
        List<Boolean> finalList2 = CamelCaseMatching.camelMatch(queries2, pattern2);
        for(int i = 0; i < finalList2.size(); i++){
            System.out.print(finalList2.get(i)+ " ");
        }
    }
}
