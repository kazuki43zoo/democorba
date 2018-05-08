package com.example.democorba.service;


/**
 * Generated from IDL interface "GreetingService".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public abstract class GreetingServiceHelper
{
	private volatile static org.omg.CORBA.TypeCode _type;
	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			synchronized(GreetingServiceHelper.class)
			{
				if (_type == null)
				{
					_type = org.omg.CORBA.ORB.init().create_interface_tc("IDL:com/example/democorba/service/GreetingService:1.0", "GreetingService");
				}
			}
		}
		return _type;
	}

	public static void insert (final org.omg.CORBA.Any any, final com.example.democorba.service.GreetingService s)
	{
			any.insert_Object(s);
	}
	public static com.example.democorba.service.GreetingService extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static String id()
	{
		return "IDL:com/example/democorba/service/GreetingService:1.0";
	}
	public static GreetingService read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object(com.example.democorba.service._GreetingServiceStub.class));
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final com.example.democorba.service.GreetingService s)
	{
		_out.write_Object(s);
	}
	public static com.example.democorba.service.GreetingService narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof com.example.democorba.service.GreetingService)
		{
			return (com.example.democorba.service.GreetingService)obj;
		}
		else if (obj._is_a("IDL:com/example/democorba/service/GreetingService:1.0"))
		{
			com.example.democorba.service._GreetingServiceStub stub;
			stub = new com.example.democorba.service._GreetingServiceStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
		else
		{
			throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
		}
	}
	public static com.example.democorba.service.GreetingService unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
		{
			return null;
		}
		else if (obj instanceof com.example.democorba.service.GreetingService)
		{
			return (com.example.democorba.service.GreetingService)obj;
		}
		else
		{
			com.example.democorba.service._GreetingServiceStub stub;
			stub = new com.example.democorba.service._GreetingServiceStub();
			stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
			return stub;
		}
	}
}
