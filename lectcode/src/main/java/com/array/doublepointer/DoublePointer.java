package com.array.doublepointer;



/**
 * 双指针.
 * */

public class DoublePointer {
	
	/**
	 * 给你一个按 非递减顺序 排序的整数数组 nums，
	 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
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
	 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	 * https://leetcode-cn.com/problems/rotate-array/
	 * 
	 * */
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length==0) {
			return ;
		}
		//三次颠倒即可
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
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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
	 * 给定一个已按照 升序排列 的整数数组 numbers ， 请你从数组中找出两个数满足相加之和等于目标数 target 。
	 * 
	 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。 numbers 的下标 从 1 开始计数 ， 所以答案数组应当满足 1 <=
	 * answer[0] < answer[1] <= numbers.length 。
	 * 
	 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
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
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	 * 
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 * 
	 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
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
	 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
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
