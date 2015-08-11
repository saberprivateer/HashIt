package hashit;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int n;
    public static String[] argInput;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        long startTime = System.nanoTime();

        log("Begin Program");
        log("End Program");
        grabFile("2sum");
        log("Lenght:"+argInput.length);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        log("Program ran for " + duration / 1000000 + " milliseconds");
    }

    public static void grabFile(String arg) throws IOException, URISyntaxException {
        argInput = new String[n];
        argInput = data(arg);
    }

    public static String[] data(String datafile) throws URISyntaxException, IOException {
        //System.out.println("Opening " + datafile + ".");
        //Name of the file
        String filePath = new File("").getAbsolutePath();
        String fullPath = filePath + "/src/Files/" + datafile + ".txt";
        //System.out.println (filePath);

        LineNumberReader lnr = new LineNumberReader(new FileReader(new File(fullPath)));
        lnr.skip(Long.MAX_VALUE);
        n = lnr.getLineNumber() + 1;
        //System.out.println(lnr.getLineNumber());
        //Add 1 because line index starts at 0
        // Finally, the LineNumberReader object should be closed to prevent resource leak
        String[] arr = new String[lnr.getLineNumber() + 1];
        lnr.close();
        try {
            //Create object of FileReader
            FileReader inputFile = new FileReader(filePath + "/src/Files/" + datafile + ".txt");
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);
            //Variable to hold the one line data
            String line;
            int i;
            i = 0;
            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                arr[i] = line;
                i++;
                // System.out.println(line);
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        /*
        int[] arr = ints.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer i) {
                return i;
            }
        }).toArray(); */
        return arr;
    }

}
