/**
 * COSC 1437 - 008
 * 11/12/2024
 * This class holds the name, one letter character and array list of codons in an amino acid.
 * It comprises the basic gets and sets methods, a addToTotalCodons and a toString
 * @author Mariah Ogunlana
 * @author James Kramer
 */
import java.util.ArrayList;

public class AminoAcid {
    private final Character acid_letter;
    private final ArrayList<String> possible_codons;
    private final String acid_name;
    private int totalCodons;

    /**
     *This is a constructor for the Amino Acid class which takes the name, letter and possible codon matches for an amino acid
     * @param letter - The Amino acid letter
     * @param name - The name of the Amino Acid
     * @param possibleCodons - The possible codon matches which occur in a specific Amino Acid
     */
    public AminoAcid(Character letter, String name, ArrayList<String> possibleCodons) {
        this.acid_letter = letter;
        this.acid_name = name;
        this.possible_codons = possibleCodons;
        this.totalCodons = 0; // Initialize total codons to zero
    }
    /**
     * The getAcidLetter returns the letter of the amino acid
     * @return the one letter of the Amino acid
     */
    public Character getAcidLetter() {
        return acid_letter;
    }

    /**
     * The getPossibleCodons method returns an array of all the codon matches for an amino acid
     * @return all codom matches for an amino acid
     */
    public ArrayList<String> getPossibleCodons() {
        return possible_codons;
    }

    /**
     * The getAcidName returns the name of the acid
     * @return the  full name of the amino acid
     */
    public String getAcidName() {
        return acid_name;
    }

    /**
     * The addToTotalCodons updates total codons by adding occurrences of each matching codon
     * @param count - the value of each possible codons found in the sequence
     */
    public void addToTotalCodons(int count) {
        this.totalCodons += count;
    }

    /**
     * The getTotalCodons returns the total number of codons of each possible codons in the Amino acid
     * @return - the total number of codons
     */
    public int getTotalCodons() {
        return totalCodons;
    }
}
