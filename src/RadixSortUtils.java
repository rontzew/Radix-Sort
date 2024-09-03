class RadixSortUtils {

    static int getMaxLen(int[] nums) {
        int maxLen = 0;
        for (int num : nums) {
            int crrLen = RadixSortUtils.numLength(num);
            if (crrLen > maxLen) {
                maxLen = crrLen;
            }
        }
        return maxLen;
    }

    static int numLength(int num) {
        int len = 0;
        while (num>0){
            num /= 10;
            len++;
        }
        return len;
    }

    static int getDigitAtIndexOfFromEnd(int num, int index) { //this method is called for every number to get the digit for the current index for which comparison is made
        int digit = 0;
        while(index > 0){
            digit = num % 10;
            index--;
            num /= 10;
        }
        return digit;
    }
}
