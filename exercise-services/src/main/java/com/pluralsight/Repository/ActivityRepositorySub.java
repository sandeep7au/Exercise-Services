package com.pluralsight.Repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

public class ActivityRepositorySub implements  ActivityRepository  {

	@Override
		public void create(Activity activity) {
			// TODO Auto-generated method stub
			
		}
	
public	List<Activity> findallactivities ()
	{
		List<Activity> activities=new ArrayList<>();
		
		Activity activity1=new Activity();
		
		activity1.setDescription("dancing");
		activity1.setDuration(55);
		
		activities.add(activity1); 
		
		Activity activity2=new Activity();
		activity2.setDescription("jogging");
		activity2.setDuration(120);
		
		activities.add(activity2);
		
		return activities;
	}

@Override
	public Activity findactivitiy(String activityId) {
		
	if(activityId.equals("7777"))
	{
		return null;
	}
	Activity activity1=new Activity();
	
	activity1.setId("1234");
	activity1.setDescription("dancing");
	activity1.setDuration(55);
	
	User user=new User();
	user.setId("9211");
	user.setName("sandeep");
	
	activity1.setUser(user);
	
	System.out.println("new activity id is : "+ activityId);
		return activity1;
	}
}
