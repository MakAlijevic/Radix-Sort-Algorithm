package ibu.edu;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\IP-COUNTRY-REGION-CITY-SHUFFLED.csv";
        String RadixSortPath = "C:\\Users\\Korisnik\\Desktop\\IP-COUNTRY-REGION-CITY-SHUFFLED\\RadixSort IPs.csv";

        File file = new File(path);
        File newFileRadixSort = new File(RadixSortPath);

        Scanner input = new Scanner(file);

        FileWriter RadixSortFileWriter = new FileWriter(newFileRadixSort);


        String[] ips;
        IPAddress[] ipAddressesRadixSort = new IPAddress[50];

        int i = 0;
        while (input.hasNextLine() && i < 50) {

            String data = input.nextLine();
            data = data.replace("\"", "");
            ips = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            long ipFrom = Long.parseLong(ips[0]);
            long ipTo = Long.parseLong(ips[1]);
            ipAddressesRadixSort[i] = new IPAddress(ipFrom, ipTo, ips[2], ips[3], ips[4], ips[5]);
            i++;

        }
        input.close();

        //Radix sort
        long start = System.currentTimeMillis();

        RadixSort.sort(ipAddressesRadixSort);

        for (int a = 0; a < ipAddressesRadixSort.length; a++) {
            RadixSortFileWriter.write("\"" + ipAddressesRadixSort[a].ipFrom + "\"," + "\"" + ipAddressesRadixSort[a].ipTo + "\"," + "\"" + ipAddressesRadixSort[a].countryCode + "\"," + "\"" + ipAddressesRadixSort[a].countryName + "\"," + "\"" + ipAddressesRadixSort[a].regionName + "\"," + "\"" + ipAddressesRadixSort[a].cityName + "\n");
        }
        RadixSortFileWriter.close();
        System.out.println("Radix sort completed! Done in " + (System.currentTimeMillis() - start) + " ms");
    }
}
