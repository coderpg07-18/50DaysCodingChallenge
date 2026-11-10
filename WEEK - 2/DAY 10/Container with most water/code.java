
public class code {

    public static int maxArea(int height[]) {

        // Two Pointer Approach ---
        int si = 0;
        int ei = height.length - 1;

        int maxWaterArea = 0;

        while (si < ei) {

            int width = ei - si;
            int waterLevel = Math.min(height[si], height[ei]);

            int waterArea = width * waterLevel;

            maxWaterArea = Math.max(maxWaterArea, waterArea);

            if (height[si] < height[ei]) {
                si++;
            } else {
                ei--;
            }
        }

        return maxWaterArea;
    }

    public static void main(String args[]) {

        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println( maxArea(height) );
    }
}