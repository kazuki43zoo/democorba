package com.example.democorba.service;

/**
 * Generated from IDL interface "GreetingService".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public final class GreetingServiceHolder	implements org.omg.CORBA.portable.Streamable{
	 public GreetingService value;
	public GreetingServiceHolder()
	{
	}
	public GreetingServiceHolder (final GreetingService initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return GreetingServiceHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = GreetingServiceHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		GreetingServiceHelper.write (_out,value);
	}
}
