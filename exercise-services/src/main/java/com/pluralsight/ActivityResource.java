package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.Repository.ActivityRepository;
import com.pluralsight.Repository.ActivityRepositorySub;
import com.pluralsight.model.Activity;
import com.pluralsight.model.User;

@Path("activities") //http://localhost:8080/exercise-services/webapi/activity
public class ActivityResource {

	private ActivityRepository activityRepository=new ActivityRepositorySub();
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity)
	{
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		return activity;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public  Activity  createactivity(MultivaluedHashMap<String, String> formParams)
	{
		System.out.println(formParams.getFirst("desc"));
		System.out.println(formParams.getFirst("Time"));
		
		Activity activity=new Activity();
		activity.setDescription(formParams.getFirst("desc"));
		activity.setDuration(Integer.parseInt(formParams.getFirst("Time")));
		
		activityRepository.create(activity);
		return activity;		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public  List<Activity> getactivities()
	{
		return activityRepository.findallactivities();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}") //http://localhost:8080/exercise-services/webapi/activity/134
	public  Response getactivitiy(@PathParam("activityId") String activityId)
	{
		System.out.println("activity id is : " + activityId);
		if(activityId == null || activityId.length()<4)
		{
			return Response.status(Status.BAD_REQUEST).build();
		}

		Activity activity=activityRepository.findactivitiy(activityId);
		if( activity== null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(activity).build();

		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}/user") //http://localhost:8080/exercise-services/webapi/activity/134/user
	public  User getuser(@PathParam("activityId") String activityId)
	{
		Activity activity=activityRepository.findactivitiy(activityId);
		User user=activity.getUser();
	//	System.out.println("user is " + user);
		return user;
		//return activityRepository.findactivitiy(activityId).getUser();
		
	}
}
