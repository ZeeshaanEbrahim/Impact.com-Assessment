import java.util.*;


public class Implementation implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");
        for (String part : parts){
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input){

        return "";

    }
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new Implementation();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Collection<Integer> collected = summarizer.collect(input);
        System.out.println(collected);
    }

}
