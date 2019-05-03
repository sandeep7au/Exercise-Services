package com.pluralsight.Client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGet() {
		//fail("Not yet implemented");
		
		final ActivityClient activityClient=new ActivityClient();
		final Activity activity=activityClient.get("1234");
		
		System.out.println("activity is : "+activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList()
	{
		final ActivityClient activityClient=new ActivityClient();
		final List<Activity> activities=activityClient.getList();
		
		assertNotNull(activities);
	}

	@Test(expected=RuntimeException.class)
	public void testGetwithBadRequest()
	{
		final ActivityClient activityClient=new ActivityClient();
		activityClient.get("123");		
		
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetwithNotFound()
	{
		final ActivityClient activityClient=new ActivityClient();
		activityClient.get("7777");		
		
	}
}
