package com.Main;

import com.query.binaryQuery.BinaryQuery;

public class Main {

	public static void main(String[] args) {
		BinaryQuery binaryQuery = new BinaryQuery();
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		binaryQuery.search(nums , target );
	}
}
