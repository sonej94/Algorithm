import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> treeMap = new HashMap<>();
        int totalTrees = 0;

        String tree = br.readLine();
        while (tree != null && !tree.isEmpty()) {

            if (treeMap.containsKey(tree)) {
                int nowCnt = treeMap.get(tree);
                treeMap.put(tree, nowCnt + 1);
                
            } else {
                treeMap.put(tree, 1);
            }
            totalTrees++;

            tree = br.readLine();
        }

        Map<String, Integer> sortedTreeMap = new TreeMap<>(treeMap);

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> mapEntry : sortedTreeMap.entrySet()) {
        	
            String treeName = mapEntry.getKey();
            int treeCnt = mapEntry.getValue();

            double percentage = ((double) treeCnt / totalTrees) * 100;

            String result = String.format("%s %.4f\n", treeName, percentage);
            sb.append(result);
        }

        System.out.print(sb.toString());
    }
}
