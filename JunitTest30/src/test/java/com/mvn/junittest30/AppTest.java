package com.mvn.junittest30;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
{
	
	private App app = new App();
	//assertArrayEquals(expectArr, valueArr)
	// 실습1
    @Test
    public void test1(){
    	int arr[] = {10, 20};
		/*
		 * int result = app.sortArr();
		 */
        
        if(arr[0] < arr[1]) {
        	fail();
        }
    }
    
    @Before
    public void before() {
    	
    }
    
    
    //실습2
    @Test
    public void test2()
    {
    	String path = "D:/JavaApp1/Dropbox/Java30/JavaWork/JunitTest30/TEST";
    	File file = new File(path);
    	int[][] array = new int[][] {
    		{20,30},
    		{50,5},
    		{3,1}
    	};
    	if(!file.exists()) {
    		try {
    			file.mkdir();
    			System.out.println("폴더생성");
    			
    			for(int i = 0; i < array.length; i++) {
    				int max = app.max(array[i]);
    				int min = app.min(array[i]);
    				
    				OutputStream output = new FileOutputStream(
    						"D:/JavaApp1/Dropbox/Java30/JavaWork/JunitTest30/TEST/test.txt");
    				String str = "최대: " + max + "최소: " + min;
    				byte[] barr = str.getBytes();
    				output.write(barr);
    			}
    		} catch(Exception e) {
    			e.getStackTrace();
    		}
    	} else {
    		System.out.println("생성된 폴더가 이미 존재합니다.");
    	}
    	
    }

}
