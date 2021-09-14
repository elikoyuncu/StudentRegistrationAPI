package com.sputniktechnology.SchoolRegistrationAPI.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Result Class
 * 
 * @author Ali (Eli) Koyuncu
 *
 */
public class Result implements Serializable {
	
	/**
	 * Status = 0 --> No problem
	 */
	private int status;
	
	/**
	 * Result
	 */
	private String result;
	
	/**
	 * Error/Exception Code. Empty if Status = 0
	 */
	private String errCode;
	
	/**
	 * Error/Exception Message. Empty if Status = 0
	 */
	private String description;
	
	/**
	 * Construction
	 * 
	 * @param status
	 * @param result
	 * @param errCode
	 * @param description
	 */
	public Result(int status, String result, String errCode, String description)
	{
		this.status = status;
		this.result = result;
		this.errCode = (errCode==null)?"":errCode;
		this.description = (description==null)?"":description;
	}
	
	/**
	 * JSON Map
	 * 
	 * @return
	 */
	public Map<String, String> getResultMapping()
	{
		HashMap<String, String> map = new HashMap<>();
		
		map.put("Status", Integer.toString(this.status));
		map.put("Result", this.result);
		map.put("ErrorCode", this.errCode);
		map.put("Description", this.description);
		return map;
	}
}
