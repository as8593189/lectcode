package com.array.doublepointer;



/**
 * ˫ָ��.
 * */

public class DoublePointer {
	
	/**
	 * ����һ���� �ǵݼ�˳�� ������������� nums��
	 * ���� ÿ�����ֵ�ƽ�� ��ɵ������飬Ҫ��Ҳ�� �ǵݼ�˳�� ����
	 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
	 * */
	public int[] sortedSquares(int[] nums) {
		if (nums == null || nums.length==0) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];
		}
		quick_sort(nums,0,nums.length-1);
		return nums;
    }
	
	void quick_sort(int arr[], int start, int end){
	    int pos;
	    if (start<end){
	        pos = partition(arr, start, end);
	        quick_sort(arr,start,pos-1);
	        quick_sort(arr,pos+1,end);
	    }
	    return;
	}
	
	public int  partition(int arr[], int low, int high){
	    int key;
	    key = arr[low];
	    while(low<high){
	        while(low <high && arr[high]>= key )
	            high--;
	        if(low<high)
	            arr[low++] = arr[high];
	        while( low<high && arr[low]<=key )
	            low++;
	        if(low<high)
	            arr[high--] = arr[low];
	    }
	    arr[low] = key;
	    return low;
	}
	
	/**
	 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����
	 * https://leetcode-cn.com/problems/rotate-array/
	 * 
	 * */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length==0) {
			return ;
		}
		//���εߵ�����
		int pos = k % nums.length-1;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, pos);
		reverse(nums, pos+1, nums.length-1);
    }
	
	public void reverse(int[] nums,int start ,int end ) {
		while(start<end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
            start ++;
            end -- ;
		}
	}
	
	/**
	 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
	 * https://leetcode-cn.com/problems/move-zeroes/
	 * */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length==0) {
			return ;
		}
		int left =0;
		int right = 0;
		while(right<nums.length) {
			if (nums[right]!=0) {
				nums[left] = nums[right];
				left++;
				right++;
			}else {
				right++;
			}
		}
		while(left<nums.length) {
			nums[left++] = 0;
		}
    }
	
	/**
	 * ����һ���Ѱ��� �������� ���������� numbers �� ������������ҳ��������������֮�͵���Ŀ���� target ��
	 * 
	 * ����Ӧ���Գ���Ϊ 2 �������������ʽ���������������±�ֵ�� numbers ���±� �� 1 ��ʼ���� �� ���Դ�����Ӧ������ 1 <=
	 * answer[0] < answer[1] <= numbers.length ��
	 * 
	 * ����Լ���ÿ������ֻ��ӦΨһ�Ĵ𰸣������㲻�����ظ�ʹ����ͬ��Ԫ�ء�
	 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
	 */
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length==0) {
			return null;
		}
		int left = 0;
		int right = numbers.length-1;
		while(left<right) {
			if (numbers[left]+numbers[right]<target) {
				left++;
			}else if (numbers[left] + numbers[right] ==target) {
				return new int[] {numbers[left], numbers[right]};
			}else  {
				while(right>left) {
					if (numbers[left] + numbers[right] ==target) {
						return new int[] {numbers[left], numbers[right]};
					}else {
						right--;
					}
				}
				right = numbers.length-1;
				left++;
			}
		}
		return null;
    }
	
	/**
	 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������
	 * 
	 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
	 * 
	 * ����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
	 * https://leetcode-cn.com/problems/reverse-string/
	 */
	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length-1;
		while(left<right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
    }
	
	/**
	 * ����һ���ַ���������Ҫ��ת�ַ�����ÿ�����ʵ��ַ�˳��ͬʱ�Ա����ո�͵��ʵĳ�ʼ˳��
	 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
	 */
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		String res = "";
		for (int i = 0; i < words.length; i++) {
			char[] chars = words[i].toCharArray();
			int left = 0;
			int right = chars.length-1;
			while(left<right) {
				char temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
			res = res + String.valueOf(chars) + " ";
		}
		return res.trim();
    }
}
