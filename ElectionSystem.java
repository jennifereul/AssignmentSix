import java.util.*;

public class ElectionSystem {
    private Election election;

    public static int p;

    public ElectionSystem() {
        election = new Election();
    }

    public void initializeElection(List<String> candidates, int pVotes) {
        p = pVotes;
        election.initializeCandidates(candidates);
    }

    public void castVotes(List<String> votes) {
        for (String candidate : votes) {
            election.castVote(candidate);
        }
    }

    public void rigElection(String candidate) {
        election.rigElection(candidate);
    }

    public List<String> getTopKCandidates(int k) {
        return election.getTopKCandidates(k);
    }

    public void auditElection() {
        election.auditElection();
    }
}
