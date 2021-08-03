package com.query.binaryQuery;

/**
 * ���ֲ���������.
 * */

public class BinaryQuery {

	/**
	 * ����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��
	 * дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��
	 * https://leetcode-cn.com/problems/binary-search/
	 * */
	public int search(int[] nums, int target) {
		if (nums==null || nums.length==0 ) {
			return -1;
		}
		int left = 0; 
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left + right)/2;
			if (nums[mid]==target) {
				return mid;
			}else if (nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return -1;
    }
	
	/**
	 * ���ǲ�Ʒ����Ŀǰ���ڴ���һ���Ŷӿ����µĲ�Ʒ�����ҵ��ǣ���Ĳ�Ʒ�����°汾û��ͨ��������⡣
	 * ����ÿ���汾���ǻ���֮ǰ�İ汾�����ģ����Դ���İ汾֮������а汾���Ǵ�ġ�
	 * 
	 * �������� n ���汾 [1, 2, ..., n]�� �����ҳ�����֮�����а汾����ĵ�һ������İ汾��
	 * 
	 * �����ͨ������ bool isBadVersion(version) �ӿ����жϰ汾�� version �Ƿ��ڵ�Ԫ�����г���
	 * ʵ��һ�����������ҵ�һ������İ汾����Ӧ�þ������ٶԵ��� API �Ĵ�����
	 * https://leetcode-cn.com/problems/first-bad-version/
	 */
	
	public int firstBadVersion(int n) {
        //������ص�����ƽ��ֵ���������   int mid = low + (high - low) / 2;
		int left = 1; 
		int right = n;
		while(left<=right) {
			int mid =  left + (right - left) / 2;
            boolean check = false;
			//boolean check = isBadVersion(mid);
			if(check  == false){
                left = mid + 1;
            }else{
                right = mid -1;
            }
		}
		return left;
    }
	
	
	/**
	 * 
	 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ���������������� 
	 * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
	 * 
	 * �����ʹ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨��
	 * https://leetcode-cn.com/problems/search-insert-position/
	 */
	public int searchInsert(int[] nums, int target) {
		if (nums==null || nums.length==0 ) {
			return -1;
		}
		int left = 0; 
		int right = nums.length-1;
		while(left<=right) {
			int mid = (left + right)/2;
			if (nums[mid]==target) {
				return mid;
			}else if (nums[mid] > target) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return left;
    }
}
