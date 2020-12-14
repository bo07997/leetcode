import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        Collections.fill(list, 1);
        System.out.println();
    }

    public static String rankTeams(String[] votes) {
        int width = votes[0].length();
        int[][] nums = new int[91][width];
        for (String str : votes) {
            IntStream.range(0, votes[0].length()).forEach(index->{
                int test = str.charAt(index);
                nums[str.charAt(index)][index] ++;
            });
        }
        Map<Integer,Integer> result = votes[0].chars().boxed().collect(Collectors.toMap(ch->ch,ch->0));
        for (int i=1;i<=90;i++){
            int count = 0;
            for (int j=0;j<width;j++){
                count = count*10 + nums[i][j];
            }
            if (result.containsKey(i)){
                result.put(i,count);
            }
        }
        List<Integer> test = result.entrySet().stream()
                .sorted((e1, e2) -> {
                     int vale=  e2.getValue().compareTo(e1.getValue());
                   return vale==0?e1.getKey().compareTo(e2.getKey()):vale ;
                }
                ).map(Map.Entry::getKey).collect(Collectors.toList());
        StringBuffer rs = new StringBuffer();
        test.stream().mapToInt(Integer::intValue).forEach(c->rs.append((char)c));
        return  rs.toString();
    }
}
