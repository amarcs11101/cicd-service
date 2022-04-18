/**
 * 
 */
package com.in10s.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Abhishek Amar
 *
 */
public class Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String status;
	private Date timeStamp;

	public Exception(String message, String status, Date timeStamp) {
		super();
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
	}

}
