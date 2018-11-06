/* no idea of kyu, probably 7kyu
being given an integer array, we need to return one of those:
"no" - which means that the numbers are not in an order
"yes, ascending" - which means that numbers are in ascending order
"yes, descending" - which means that numbers are in descending order
*/

class OrderAscOrDesc {

    public static String isSortedAndHow(int[] array) {
        String order = "";
        /*
        this while is not needed here but I added it
        to make a code work for {1,1,1,2,3,5},{8,8,8,3,1,-7,-12} etc.
        (first few numbers are the same)
        */
        int j=1;
        while (array[j]==array[j-1]){
            j++;
        }

        if (array[j-1]<array[j]){
            order = "ascending";
            for (int i=j; i<array.length; i++){
                if (array[i]<array[i-1]) return "no";
            }
        }

        else if (array[j-1]>array[j]){
            order = "descending";
            for (int i=j; i<array.length; i++){
                if (array[i]>array[i-1]) return "no";
            }
        }

        return "yes, " + order;
    }
}
