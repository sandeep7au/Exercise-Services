package com.pluralsight.Repository;

import java.util.List;

import com.pluralsight.model.Activity;

public interface ActivityRepository {

	List<Activity> findallactivities();

	Activity findactivitiy(String activityId);

	void create(Activity activity);
}