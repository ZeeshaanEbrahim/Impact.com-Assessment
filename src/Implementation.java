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
        if(input == null || input.isEmpty()){
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);
        List<String> result = new ArrayList<>();

        int start = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) != numbers.get(i-1) + 1){
                if (start == numbers.get(i-1)){
                    result.add(String.valueOf(start));
                }else{
                    result.add(start+"-"+numbers.get(i-1));
                }
                start = numbers.get(i);
            }
        }
        int last = numbers.get(numbers.size()-1);
        if(start == last){
            result.add(String.valueOf(start));
        }else{
            result.add(start+"-"+last);
        }
        return String.join(",",result);



    }
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new Implementation();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Collection<Integer> collected = summarizer.collect(input);
        System.out.println(summarizer.summarizeCollection(collected));
    }

}
