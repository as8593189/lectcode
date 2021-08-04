package com.Main;

import com.array.doublepointer.DoublePointer;
import com.query.binaryQuery.BinaryQuery;

public class Main {

	public static void main(String[] args) {
		BinaryQuery binaryQuery = new BinaryQuery();
		DoublePointer doublePointer = new DoublePointer();
		int[] nums = {-5,-3,-2,-1};
		doublePointer.sortedSquares(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
