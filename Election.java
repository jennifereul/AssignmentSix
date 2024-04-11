import java.util.*;

public class Election {
    private Map<String, Integer> candidates;
    private PriorityQueue<Map.Entry<String, Integer>> maxHeap;

    private static class EntryComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            return b.getValue().compareTo(a.getValue());
        }
    }

    private static class MaxHeapComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            return b.getValue().compareTo(a.getValue());
        }
    }

    public Election() {
        candidates = new HashMap<>();
        maxHeap = new PriorityQueue<>(new MaxHeapComparator());
    }

    public void initializeCandidates(List<String> candidatesList) {
        for (int i = 0; i < candidatesList.size(); i++) {
            String candidate = candidatesList.get(i);
            candidates.put(candidate, Integer.valueOf(0));
        }
    }

    public void castVote(String candidate) {
        if (candidates.containsKey(candidate)) {
            candidates.put(candidate, candidates.get(candidate) + 1);
        } else {
            System.out.println("Error: " + candidate + " NOT VALID.");
        }
    }

    public void castRandomVote() {
        Random random = new Random();
        List<String> candidateList = new ArrayList<>(candidates.keySet());
        String randomCandidate = candidateList.get(random.nextInt(candidateList.size()));
        castVote(randomCandidate);
    }

    public void rigElection(String candidate) {
        if (candidates.containsKey(candidate)) {
            int remainingVotes = ElectionSystem.p - calculateTotalVotes();
            candidates.put(candidate, candidates.get(candidate) + remainingVotes);
        } else {
            System.out.println("Error: " + candidate + " NOT VALID.");
        }
    }

    private int calculateTotalVotes() {
        int totalVotes = 0;
        for (Iterator<Integer> iterator = candidates.values().iterator(); iterator.hasNext();) {
            Integer voteCount = iterator.next();
            totalVotes += voteCount.intValue();
        }
        return totalVotes;
    }

    public List<String> getTopKCandidates(int k) {
        maxHeap.clear();
        maxHeap.addAll(candidates.entrySet());
        List<String> topCandidates = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                topCandidates.add(maxHeap.poll().getKey());
            }
        }
        return topCandidates;
    }

    public void auditElection() {
        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(candidates.entrySet());
        sortedCandidates.sort(new EntryComparator());
        for (int i = 0; i < sortedCandidates.size(); i++) {
            Map.Entry<String, Integer> entry = sortedCandidates.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}

