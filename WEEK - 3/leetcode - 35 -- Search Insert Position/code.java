
public class code {

    public int searchInsert(int[] nums, int target) {

        int front = 0;
        int back = nums.length - 1;

        while (front <= back) {

            int mid = front + (back - front) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                front = mid + 1;
            }
            else {
                back = mid - 1;
            }
        }

        return front;
    }

    public static void main(String[] args) {

        code output = new code();

        int nums[] = {1, 3, 5, 6};

        int target = 5;

        int res = output.searchInsert(nums, target);

        System.out.println("Search Insert Position: " + res);
    }
}
