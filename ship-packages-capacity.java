// TC: O(nlogn)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int shipWithinDays(int[] weights, int D) {
    int left = 0, right = 0;
    for (int w: weights) {
        left = Math.max(left, w);
        right += w；
    }
    while (left < right) {
        int mid = (left + right) / 2, need = 1, cur = 0;
        for (int w: weights) {
            if (cur + w > mid) {
                need += 1;
                cur = 0;
            }
            cur += w;
        }
        if (need > D) left = mid + 1;
        else right = mid;
    }
    return left;
}