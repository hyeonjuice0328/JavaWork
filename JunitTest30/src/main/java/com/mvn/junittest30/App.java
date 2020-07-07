package com.mvn.junittest30;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    // 실습1
    public void sortArr(int [] arr) {
    	Arrays.sort(arr);
    	
    	for(int i : arr) {
    		System.out.print(i);
    	}
    }
    
    // 실습2
    public int max(int [] arr) {
    	Arrays.sort(arr);
    	System.out.println("최대값: " + arr[0]);
    	return arr[0];
    }
    public int min(int [] arr) {
    	Arrays.sort(arr);
    	System.out.println("최소값: " + arr[arr.length-1]);
    	return arr[arr.length-1];
    }
    
    // 실습3
    public String toNumber(String str) {
    	String result = "";
    	
    	result = str.replaceAll("-", "");
    	return result;
    }
}
