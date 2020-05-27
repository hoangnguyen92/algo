package problemsolver;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NGram {

    private HashMap<String, List<String>> nGramsMap; // Mapping of the Ngrams
    private BigInteger totalWords = BigInteger.ZERO;
    private BigInteger totalUniqueNgrams = BigInteger.ZERO;

    public void solve() throws IOException {
        nGramsMap = new HashMap<>();
//        FileInputStream inputStream = null;
//        Scanner sc = null;
//        try {
//            inputStream = new FileInputStream("/Users/hoangnguyen/dev/projects/Practice/JavaPractice/src/problemsolver/en_US.blogs.txt");
//            sc = new Scanner(inputStream, "UTF-8");
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine();
//                generateNgrams(line);
//            }
//        } finally {
//            if (inputStream != null) {
//                inputStream.close();
//            }
//            if (sc != null) {
//                sc.close();
//            }
//        }

        System.out.println("Ngram map: " + generateNgrams("I was I wish I was a I was \"i"));
        System.out.println("totalWords: " + totalWords);
        System.out.println("totalUniqueNgrams: " + totalUniqueNgrams);
        System.out.println("Calculate probability of 'I was':" + calculateProbability("I was"));
    }

    private Map<String, BigDecimal> calculateProbability(String term) {
        List<String> folowingWords = nGramsMap.get(term.toLowerCase());
        if (folowingWords == null || folowingWords.isEmpty()) {
            return new HashMap<>();
        }

        int totalFollowingWords = folowingWords.size();
        Map<String, BigDecimal> wordsProbability = new HashMap<>();
        Map<String, Integer> wordsRepeated = new HashMap<>();

        for (String word : folowingWords) {
            if (wordsRepeated.containsKey(word)) {
                Integer numRepeat = wordsRepeated.get(word);
                numRepeat++;
                wordsRepeated.put(word, numRepeat);
            } else {
                wordsRepeated.put(word, Integer.valueOf(1));
            }
        }

        for (String word : wordsRepeated.keySet()) {
            BigDecimal probability = BigDecimal.valueOf(wordsRepeated.get(word)).divide(BigDecimal.valueOf(totalFollowingWords), 3, RoundingMode.HALF_UP);
            wordsProbability.put(word, probability);
        }
        LinkedHashMap<String, BigDecimal> sortedMap = new LinkedHashMap<>();
        wordsProbability.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    if (entry1.getValue().equals(entry2.getValue())) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }

                    return entry1.getValue().compareTo(entry2.getValue());
                })
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        return sortedMap;
    }

    public Map<String, List<String>> generateNgrams(String line) {
        line = line
                .toLowerCase()
                .replace(",", "")
                .replace(".", "")
                .replace("!", "")
                .replace("?", "")
                .replace("\"", "");
        String[] words;
        words = line.split(" ");

        // Value for NGram
        int valueOfNgram = 2;
        for (int i = 0; i < words.length - valueOfNgram + 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < valueOfNgram; j++) {
                sb.append(words[i + j].trim());
                if (j < valueOfNgram - 1)
                    sb.append(" ");
            }

            String key = sb.toString();

            String value = "";

            if (i + valueOfNgram < words.length)
                value = words[i + valueOfNgram];

            if (!nGramsMap.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(value);
                nGramsMap.put(key, list);
                totalUniqueNgrams = totalUniqueNgrams.add(BigInteger.ONE);
            } else {
                List<String> list = nGramsMap.get(key);
                list.add(value);
            }
            totalWords = totalWords.add(BigInteger.ONE);
        }
        return nGramsMap;
    }

}
