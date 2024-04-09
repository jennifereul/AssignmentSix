import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<String> candidates = Arrays.asList("Marcus Fenix", "Dominic Santiago", "Damon Baird", "Cole Train", "Anya Stroud");
        int p = 5;

        ElectionSystem system = new ElectionSystem();
        system.initializeElection(candidates, p);

        system.castVotes(Arrays.asList("Cole Train", "Cole Train", "Marcus Fenix", "Anya Stroud", "Anya Stroud"));
        System.out.println("Top 3 candidates after 5 votes: " + system.getTopKCandidates(3));

        system.rigElection("Marcus Fenix");
        System.out.println("Top 3 candidates after rigging the election: " + system.getTopKCandidates(3));

        System.out.println("Audit of the election:");
        system.auditElection();
    }
}