package com.example.democorba.service;

import org.omg.PortableServer.POA;

/**
 * Generated from IDL interface "GreetingService".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public class GreetingServicePOATie
	extends GreetingServicePOA
{
	private GreetingServiceOperations _delegate;

	private POA _poa;
	public GreetingServicePOATie(GreetingServiceOperations delegate)
	{
		_delegate = delegate;
	}
	public GreetingServicePOATie(GreetingServiceOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public com.example.democorba.service.GreetingService _this()
	{
		org.omg.CORBA.Object __o = _this_object() ;
		com.example.democorba.service.GreetingService __r = com.example.democorba.service.GreetingServiceHelper.narrow(__o);
		return __r;
	}
	public com.example.democorba.service.GreetingService _this(org.omg.CORBA.ORB orb)
	{
		org.omg.CORBA.Object __o = _this_object(orb) ;
		com.example.democorba.service.GreetingService __r = com.example.democorba.service.GreetingServiceHelper.narrow(__o);
		return __r;
	}
	public GreetingServiceOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(GreetingServiceOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		return super._default_POA();
	}
	public java.lang.String hello(java.lang.String message)
	{
		return _delegate.hello(message);
	}

	public void execute(byte[] request, com.example.democorba.service.BytesDataHolder response)
	{
_delegate.execute(request,response);
	}

}
