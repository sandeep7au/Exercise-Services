package com.pluralsight.Client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pluralsight.model.Activity;

public class ActivityClient {

		private Client client;
		
		public ActivityClient()
		{
			client=ClientBuilder.newClient();
		}
		
		public Activity get(String id)
		{
			WebTarget target=client.target("http://localhost:8080/exercise-services/webapi/");
			
			Response response=target.path("activities/" + id).request().get(Response.class);
			//String  response=target.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(String.class);
			System.out.println(response);
			if(200 != response.getStatus())
			{
				//throw new RuntimeException(response.getStatus() + "error"); 
				System.out.println("bad response");
			}
			return response.readEntity(Activity.class);
		}
		
		public List<Activity> getList()
		{
			WebTarget target=client.target("http://localhost:8080/exercise-services/webapi/");
			List<Activity> response= target.path("activities").request(MediaType.APPLICATION_JSON).get( new GenericType<List<Activity>>(){});
			System.out.println(response);
			
			return response;
		}
}
