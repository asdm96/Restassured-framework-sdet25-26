package com.genericUtils;
/**
 * Interface to store all the endpoints
 * @author Adarsh M
 *
 */
public interface EndPoints {
	String DATABASE_URL="jdbc:mysql://localhost:3306/projects";
	
	String ADD_PROJECT="/addProject";
	String GET_ALLPROJECTS="/projects";
	String GETSINGLE_PROJECT="/projects/{projectId}";
	
	
	
	

}
