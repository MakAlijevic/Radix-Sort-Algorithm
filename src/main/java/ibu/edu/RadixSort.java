package ibu.edu;

public class RadixSort {
    public static void sort(IPAddress[] elements){
        IPAddress[] array = elements;
        int i = array.length;
        sort(array, i);
    }
    private static void sort(IPAddress[] array, int arrayLen){
        long max = array[0].getIpFrom();

        for(int i = 0; i < arrayLen; i++){
            if(array[i].getIpFrom()>max){
                max = array[i].getIpFrom();
            }
        }
        for(int dig = 1; max / dig > 0; dig *= 10){
            countSort(array, dig);
        }
    }
    private static void countSort(IPAddress[] array, int dig){
        int[] frequency = {0,0,0,0,0,0,0,0,0,0};
        int len = array.length;
        IPAddress[] aux = new IPAddress[len];

        for (int i = 0; i < len; i++) {
            int digit = (int) ((array[i].getIpFrom() / dig) % 10);
            frequency[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = len - 1; i >= 0; i--) {
            int digit = (int) ((array[i].getIpFrom() / dig) % 10);
            aux[frequency[digit] - 1] = array[i];
            frequency[(int) ((array[i].getIpFrom() / dig) % 10)]--;
        }

        for (int i = 0; i < len; i++) {
            array[i] = aux[i];
        }
    }
}
