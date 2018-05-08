package com.example.democorba.service;


/**
 * Generated from IDL interface "GreetingService".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public abstract class GreetingServicePOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, com.example.democorba.service.GreetingServiceOperations
{
	static private final java.util.HashMap<String,Integer> m_opsHash = new java.util.HashMap<String,Integer>();
	static
	{
		m_opsHash.put ( "hello", Integer.valueOf(0));
		m_opsHash.put ( "execute", Integer.valueOf(1));
	}
	private String[] ids = {"IDL:com/example/democorba/service/GreetingService:1.0"};
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
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // hello
			{
				java.lang.String _arg0=_input.read_string();
				_out = handler.createReply();
				java.lang.String tmpResult1 = hello(_arg0);
_out.write_string( tmpResult1 );
				break;
			}
			case 1: // execute
			{
				byte[] _arg0=com.example.democorba.service.BytesDataHelper.read(_input);
				com.example.democorba.service.BytesDataHolder _arg1= new com.example.democorba.service.BytesDataHolder();
				_out = handler.createReply();
				execute(_arg0,_arg1);
				com.example.democorba.service.BytesDataHelper.write(_out,_arg1.value);
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
