import java.util.*;
/**
 * Implementation of the NumberRangeSummarizer interface.
 * This class provides functionality to parse comma-separated numbers and
 * summarize them by grouping consecutive numbers into ranges.
 *
 * Example: "1,3,6,7,8,12" becomes "1,3,6-8,12"
 *
 * @author Zeeshaan Ebrahim
 * @version 1.0
 */
public class Implementation implements NumberRangeSummarizer {
    /**
     * Parses a comma-separated string of numbers and returns them as a collection.
     * Whitespace around numbers is automatically trimmed.
     *
     * @param input A string containing comma-separated integers (e.g., "1,3,6,7,8")
     * @return A collection of Integer objects parsed from the input string
     * @throws NumberFormatException if the input contains non-numeric values
     */
    @Override
    public Collection<Integer> collect(String input){
        List<Integer> numbers = new ArrayList<>(); // Create a list to store the parsed numbers
        String[] parts = input.split(",");// Split the input string by commas
        for (String part : parts){// Parse each part as an integer and add to the list
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }

    /**
     * Summarizes a collection of integers by grouping consecutive numbers into ranges.
     * Numbers that are sequential (differ by 1) are grouped with a hyphen.
     * Non-sequential numbers are separated by commas.
     *
     * Examples:
     *   [1,2,3,5,7,8,9] -> "1-3,5,7-9"
     *   [1,3,5,7] -> "1,3,5,7"
     *   [1,2,3] -> "1-3"
     *
     * @param input A collection of integers to be summarized
     * @return A string representation of the summarized ranges
     *         Returns empty string if input is null or empty
     */
    @Override
    public String summarizeCollection(Collection<Integer> input){
        if(input == null || input.isEmpty()){ // Handle edge cases: null or empty collection
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);// Convert collection to list for indexed access
        List<String> result = new ArrayList<>(); // List to store the summarized ranges as strings

        int start = numbers.get(0);// Track the start of the current range
        for (int i = 1; i < numbers.size(); i++) {// Iterate through the list starting from the second element
            if (numbers.get(i) != numbers.get(i-1) + 1){// Check if current number is NOT consecutive to the previous number
                if (start == numbers.get(i-1)){// End of a range detected - add it to results
                    result.add(String.valueOf(start));// Single number (no range) - add as-is
                }else{
                    result.add(start+"-"+numbers.get(i-1));// Multiple consecutive numbers - create a range (e.g., "6-8")
                }
                start = numbers.get(i);// Start a new range with the current number
            }
        }
        int last = numbers.get(numbers.size()-1);// Handle the last range after the loop ends
        if(start == last){
            result.add(String.valueOf(start));// Last element is a single number
        }else{
            result.add(start+"-"+last);// Last element is part of a range
        }
        return String.join(",",result);// Join all ranges with commas and return



    }
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new Implementation();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Collection<Integer> collected = summarizer.collect(input);
        System.out.println(summarizer.summarizeCollection(collected));
    }

}
