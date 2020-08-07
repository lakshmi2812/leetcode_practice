class CountGoodTriplets {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int num_good_triplets = 0;
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i+1; j < arr.length - 1; j++){
                for(int k = j+1; k < arr.length; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                        num_good_triplets += 1;
                    }
                }
            }
        }
        return num_good_triplets;
    }

    public static void main(String[] args){
        int[] arr = {3,0,1,1,9,7};
        int[] arr1 = {1,1,2,2,3};
        int[] arr2 = {7,3,7,3,12,1,12,2,3};
        //System.out.println(countGoodTriplets(arr, 7,2,3));
        //System.out.println(countGoodTriplets(arr1, 0,0,1));
        System.out.println(countGoodTriplets(arr2, 5,8,1));
    }
}