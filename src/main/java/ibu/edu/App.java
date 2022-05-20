package ibu.edu;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String QuickSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\QuickSort IPs.csv";

        File file = new File(path);
        File newFileQuickSort = new File(QuickSortPath);

        Scanner input = new Scanner(file);

        FileWriter QuickSortFileWriter = new FileWriter(newFileQuickSort);


        String[] ips;
        IPAddress[] ipAddressesQuickSort = new IPAddress[50];

        int i = 0;
        while (input.hasNextLine() && i < 50) {

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddressesQuickSort[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //Quick sort
        long start = System.currentTimeMillis();

        //QuickSort.sort(ipAddressesQuickSort);

        for (int a = 0; a < ipAddressesQuickSort.length; a++) {
            QuickSortFileWriter.write("\"" + ipAddressesQuickSort[a].ipFrom + "\"," + "\"" + ipAddressesQuickSort[a].ipTo + "\"," + "\"" + ipAddressesQuickSort[a].countryCode + "\"," + "\"" + ipAddressesQuickSort[a].countryName + "\"," + "\"" + ipAddressesQuickSort[a].regionName + "\"," + "\"" + ipAddressesQuickSort[a].cityName + "\n");
        }
        QuickSortFileWriter.close();
        System.out.println("Recursive Merge sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");
    }
}
