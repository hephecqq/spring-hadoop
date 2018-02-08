package com.hephec.bigdata.spring_hadoop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class JCocoTest {

	private JCocoMain jcocoMain;
	
	/**
	 * 测试方法1
	 */
	@Test
	public void testMethod1() {
		Assert.assertNotNull(jcocoMain);
		
	}
	
	/**
	 * 测试方法2
	 * 
	 */
	@Test
	public void testMethod2() {
		jcocoMain = new JCocoMain();
		Assert.assertEquals(jcocoMain, jcocoMain);
	}
	
	
	
	@Before
	public void setUp() {
		jcocoMain = new JCocoMain();
	}
	
	/**
	 * GC full
	 */
	@After
	public void tearDown() {
		jcocoMain = null;
	}
}
