public class Decrypter {


    public String decrypt(String input){
        int[] todecrypt = new int[4];

        todecrypt = makeIntarray(input);
        todecrypt = decode(todecrypt);
        return makeString(todecrypt);
    }
    //Converts string to integer array
    public static int[] makeIntarray(String start) {
        int[] retval = new int[4];
        for (int i = 0; i < 4; i++) {
            retval[i] = Integer.parseInt(String.valueOf(start.charAt(i)));
        }
        return retval;
    }
    //Does the encoding
    public static int[] decode(int[] input){
        int[] retval = new int[4];
        for (int i = 0; i < 4; i++) {
            input[i] += 3;
            input[i] = input[i] % 10;
            retval[(i+2)%4] = input[i];
        }
        return retval;
    }
    //Concatenates the string to for every value
    public static String makeString(int[] start){
        String retval = "";
        for (int i = 0;i < 4;i++){
            retval += start[i];
        }
        return retval;
    }

}
