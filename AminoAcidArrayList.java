/**This is a Codon Bias Analysis on COVID-19
 *Date: 12 November 2024
 * @author Mariah Ogunlana
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Arrays;

import java.io.IOException;


public class AminoAcidArrayList {
    public static void main(String[] args) throws IOException {
        // Load in amino acid data
        File file = new File("aminoAcidTable.csv");
        Scanner infile = new Scanner(file);
        ArrayList<AminoAcid> acidList = new ArrayList<>();
        String nextLine, name, letter;

        // skip over the header line
        infile.nextLine();
        
        while (infile.hasNext()) {
            nextLine = infile.nextLine();
            String[] acids = nextLine.split(",");
            name = acids[0];
            letter = acids[2];
            ArrayList<String> codons = new ArrayList<>();

            // Load in codons from file
            for (int i = 3; i < acids.length; i++) {
                codons.add(acids[i]);
            }

            acidList.add(new AminoAcid(letter.charAt(0), name, codons));
        }
        infile.close();


        // Load in sequence data
        File covidFile = new File("covid19Sequence.csv");
        Scanner covidScanner = new Scanner(covidFile);
        String[] covidCodons = covidScanner.nextLine().split(",");
        covidScanner.close();

        // Count each codon for each amino acid
        for (AminoAcid aminoAcid : acidList) {
            for (String codon : aminoAcid.getPossibleCodons()) {
                int codonCount = seq_search(covidCodons, codon); // Count occurrences
                aminoAcid.addToTotalCodons(codonCount);
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter("Covid19BiasAnalysis.txt"));
        writer.println("***** COVID-19 Codon Bias Analysis *****\n");

        int genomeTotalCodons = covidCodons.length;

        for (AminoAcid aminoAcid : acidList) {
            double genomePercentage = 100.0 * aminoAcid.getTotalCodons() / genomeTotalCodons;
            writer.printf("%s(%s): %s\n", aminoAcid.getAcidName(), aminoAcid.getAcidLetter(),
                    Arrays.toString(aminoAcid.getPossibleCodons().toArray()));

            // Print each codon and its percent
            for (String codon : aminoAcid.getPossibleCodons()) {
                int codonCount = seq_search(covidCodons, codon);
                double codonPercentage = aminoAcid.getTotalCodons() > 0 ? 100.0 * codonCount / aminoAcid.getTotalCodons() : 0;
                writer.printf("%s: %4d   %6.2f%%\n", codon, codonCount, codonPercentage);
            }
            writer.printf("Overall Genome Encoding: %6.2f%%\n\n", genomePercentage);
        }
    }

    /**
     * Helper function to count occurrences of a codon in the sequence
     * This is a search algorithm to search for specific protein codons in the covid 19 sequence
     * @param all_codons = The string array to be iterated through to search for matches
     * @param codon = The codon to be matched with
     * @return The number of times the codon to be matched() was represented
     */
    public static int seq_search(String[] all_codons, String codon) {
        int counter = 0;
        for (String currentCodon : all_codons) {
            if (currentCodon.equals(codon)) {
                counter++;
            }
        }
        return counter;
    }
}
