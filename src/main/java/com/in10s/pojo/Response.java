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
public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String status;
	private Date timeStamp;
	private Object data;

	public Response(String message, String status, Date timeStamp, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.timeStamp = timeStamp;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", status=" + status + ", timeStamp=" + timeStamp + ", data=" + data
				+ "]";
	}

}
