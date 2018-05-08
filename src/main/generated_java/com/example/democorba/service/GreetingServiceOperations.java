package com.example.democorba.service;


/**
 * Generated from IDL interface "GreetingService".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public interface GreetingServiceOperations
{
	/* constants */
	/* operations  */
	java.lang.String hello(java.lang.String message);
	void execute(byte[] request, com.example.democorba.service.BytesDataHolder response);
}
