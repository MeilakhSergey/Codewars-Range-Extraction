import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] a = new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        System.out.println(rangeExtraction(a));
    }

    public static String rangeExtraction(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        Arrays.sort(arr);

        int rangeAmount = 0;
        StringBuilder result = new StringBuilder();
        result.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - 1 != arr[i-1]) {
                switch (rangeAmount) {
                    case 0:
                        result.append(",").append(arr[i]);
                        break;
                    case 1:
                        result.append(",").append(arr[i - 1]);
                        result.append(",").append(arr[i]);
                        break;
                    default:
                        result.append("-").append(arr[i-1]);
                        result.append(",").append(arr[i]);
                        break;
                }
                rangeAmount = 0;
            } else {
                rangeAmount++;
            }
        }
        if (rangeAmount > 0) {
            switch (rangeAmount) {
                case 1:
                    result.append(",").append(arr[arr.length - 1]);
                    break;
                default:
                    result.append("-").append(arr[arr.length - 1]);
                    break;
            }
        }

        return result.toString();
    }
}
