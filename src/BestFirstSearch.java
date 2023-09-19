/**
 * This is a basic example of a best-first search. It opens up a graph file (as
 * described in the specs), and then searches from the start node to a goal
 * node, printing out its progress as it goes. Your job is to implement the
 * PriorityQueue class that it makes use of.
 *
 * Note that java.util already contains a PriorityQueue. Make sure that your
 * code doesn't conflict with this one!
 *
 * @author Adam A. Smith
 * @version 2023.09.13
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.io.*;

public class BestFirstSearch {
    /**
     * Standard main() method, that takes the command-line arguments and kicks things off.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // test command-line args
        if (args.length != 1) {
            System.err.println("Sorry--I need a graph file to explore.");
            System.exit(0);
        }

        // load the file
        String[] fileLines = null;
        try {
            System.out.println("Loading file \"" +args[0]+ "\".");
            fileLines = readFile(args[0]);
        }
        catch (FileNotFoundException ex) {
            System.err.println("Sorry--couldn't find file \"" +args[0]+ "\".");
            System.exit(0);
        }

        // extract the needed data
        String startNode = fileLines[0];
        HashMap<String, String[]> paths = extractPaths(fileLines);
        HashMap<String, Integer> scores = extractScores(fileLines);

        // and do it!!!!
        doBestFirstSearch(startNode, paths, scores);
    }

    // do the best-1st search, given the setup done in main()
    private static void doBestFirstSearch(String startNode, HashMap<String, String[]> paths, HashMap<String, Integer> scores) {

        // set up the open list (containing the start node) & the empty closed list
        PriorityQueue<String> openList = new PriorityQueue<String>(false); //MAKE SURE TO UNCOMMENT THIS WHEN CLASS IS DONE!!
        openList.add(startNode, scores.get(startNode));
        HashSet<String> closedList = new HashSet<>();

        // main loop for a best-first search
        while (!openList.isEmpty()) {

            // check out the next node in the list
            String activeNode = openList.getNext();
            if (closedList.contains(activeNode)) continue;
            closedList.add(activeNode);
            System.out.print("Exploring node " +activeNode+ "... ");

            // check to see if we found a goal (stop search if so)
            int score = scores.get(activeNode);
            if (score == 0) {
                System.out.println("GOAL!");
                break;
            }

            // add other nodes
            String[] neighbors = paths.get(activeNode);
            boolean firstAdd = true;
            for (String neighbor : neighbors) {
                // handle output (skipping if already done)
                if (closedList.contains(neighbor)) continue;
                if (firstAdd) System.out.print("adding nodes " +neighbor);
                else System.out.print("," +neighbor);
                firstAdd = false;

                // actually add the neighbor to the open list
                openList.add(neighbor, scores.get(neighbor));
            }

            // end this node
            if (firstAdd) System.out.println("no neighboring nodes added");
            else System.out.println();
        }

        // the search is done--do final report
        if (openList.isEmpty()) System.out.println("No path was found from node " + startNode + " to a goal node.");
        else {
            System.out.println("Upon termination, there were " +openList.size()+ " nodes ready to explore: " + openList);
        }
    }

    // read lines from a file, returning a String[]
    private static String[] readFile(String fileName) throws FileNotFoundException {
        // setup
        Scanner scanner = new Scanner(new File(fileName));
        ArrayList<String> lines = new ArrayList<>();

        // read in the file
        while (scanner.hasNextLine()) lines.add(scanner.nextLine());
        scanner.close();

        // convert & return
        return lines.toArray(new String[lines.size()]);
    }

    // create a hash mapping a string to an array of strings, based on the lines
    private static HashMap<String,String[]> extractPaths(String[] lines) {
        HashMap<String,String[]> hash = new HashMap<>();

        for (String line : lines) {
            String[] tokens = line.split("\t"), targets;
            if (tokens.length <= 1) continue;
            if (tokens.length == 2) targets = new String[0];
            else targets = tokens[2].split(",");
            hash.put(tokens[0], targets);
        }

        return hash;
    }

    // create a hash mapping a string to an integer, based on the lines
    private static HashMap<String,Integer> extractScores(String[] lines) {
        HashMap<String,Integer> hash = new HashMap<>();
        for (String line : lines) {
            String[] tokens = line.split("\t");
            if (tokens.length <= 1) continue;
            hash.put(tokens[0], Integer.parseInt(tokens[1]));
        }
        return hash;
    }
}
