package hashit;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static int n;
    public static ArrayList<Long>[] ht = new ArrayList[400000];
    public static String[] argInput;
    public static double[] argNumbers;
    public static int[] targets = new int[20001];
    public static int numTargets = 0;
//    public static HashMap<Integer, Double> hm = new HashMap<>(20,2);

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        long startTime = System.nanoTime();

        log("Begin Program");
        grabFile("2sum");
        initTarget();
        parse();
        collision();
        findTargets();
        log("Length:" + argInput.length);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        log("End Program");
        log("Program ran for " + duration / 1000000 + " milliseconds");
    }

    public static void initTarget() {
        for (int i = 0; i < targets.length; i++) {
            targets[i] = -10000 + i;
        }
        for (int i = 0; i < ht.length; i++) {
            ht[i] = new ArrayList<>();
        }
    }

    public static void findTargets() {
        boolean notFound = true;
        int j;
        for (int i = 0; i < targets.length; i++) {
            j = 0;
            while(notFound && (j<ht.length)) {
                for (int k = 0;k<ht[j].size();j++){

                }
                j++;
            }
        }
    }

    public static void parse() {
        long next;
        Long keyTemp;
        int key;
        boolean duplicate;
        for (int i = 0; i < n; i++) {
            next = Long.parseLong(argInput[i]);
            keyTemp = Math.abs(next % 357158);
            key = keyTemp.intValue();
            duplicate = false;
            for (int j = 0; j < ht[key].size(); j++) {
                if (ht[key].get(j) == next) {
                    duplicate = true;
//                    log("DUPLICATE!");
                }
            }
            if (!duplicate) {
                ht[key].add(next);
            }
        }
//        log("where'd it go?");
//        for (int i = 0;i<100;i++){
//            for (int j = 0;j<ht[i].size();j++){
//                System.out.print(Long.toString(ht[i].get(j))+" ");
//            }
//            log("");
//        }
//        log("");
        log("Done Parsing");
    }

    public static void collision() {
        int colavg = 0;
        int numcol = 0;
        int maxsize = 0;
        for (int i = 0; i < ht.length; i++) {
            if (ht[i].size() > 0) {
                numcol++;
                colavg += ht[i].size();
                maxsize = i;
            }
        }
        log("average size in ht:" + (colavg / numcol));
        log("the highest accessed index is: " + maxsize);
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
