/**
 * 
 */
package com.model.enrity;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Response {

	int idr;
	String response;
	boolean istrue;
	
	
	
	
	@Override
	public String toString() {
		return "Response [idr=" + idr + ", response=" + response + ", istrue=" + istrue + "]";
	}
	public int getIdr() {
		return idr;
	}
	public void setIdr(int idr) {
		this.idr = idr;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public boolean isIstrue() {
		return istrue;
	}
	public void setIstrue(boolean istrue) {
		this.istrue = istrue;
	}
	public Response(int idr, String response, boolean istrue) {
		super();
		this.idr = idr;
		this.response = response;
		this.istrue = istrue;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
