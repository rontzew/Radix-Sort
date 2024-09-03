import java.util.*;

public class Main {

    private static final int ASCENDING_ORDER = 1;

    private static List<Deque<Integer>> arrayByNumber = new ArrayList<>();

    private static void initializeList() {

        for(int i = 0; i < 10; i++){
            arrayByNumber.add(new ArrayDeque<>());
        }
    }

    private static void sortByDigit(int[] nums, int index){

        for(int num : nums){
            arrayByNumber.get(RadixSortUtils.getDigitAtIndexOfFromEnd(num,index)).add(num);
        }
    }

    private static int[] reorderArray(){
        List<Integer> result = new ArrayList<>();

        for(Deque<Integer> queue : arrayByNumber){
            while(!queue.isEmpty()){
                result.add(queue.pollFirst());
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void radixSort(int[] nums, boolean ascending) {
        // TO DO:
        initializeList();
        int len = RadixSortUtils.getMaxLen(nums);
        int[] copyNums = nums;

        for (int i = 1; i <= len; i++){
            sortByDigit(copyNums, i);
            copyNums = reorderArray();
        }

        if(ascending){
            System.arraycopy(copyNums, 0, nums, 0, copyNums.length);
        }else{
            for(int i = 0; i < copyNums.length; i++){
                nums[i] = copyNums[nums.length - i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type 1 for ascending order or *really any other INT number* for descending order: ");
        int order = scanner.nextInt();
        System.out.print("Insert how many numbers you want to sort: ");
        int n = scanner.nextInt();
        System.out.println("Insert the " + n + " numbers: ");
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Your numbers are, in order: ");

        boolean ascending = (order == ASCENDING_ORDER ? true : false);
        radixSort(nums, ascending);
        System.out.println(Arrays.toString(nums));
    }
}