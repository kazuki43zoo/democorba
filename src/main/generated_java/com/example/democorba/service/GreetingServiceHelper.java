package com.example.democorba.service;


/**
* com/example/democorba/service/GreetingServiceHelper.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* /Users/shimizukazuki/git-me/democorba/src/main/resources/GreetingService.idlから
* 2018年5月8日 22時51分33秒 JST
*/

abstract public class GreetingServiceHelper
{
  private static String  _id = "IDL:com/example/democorba/service/GreetingService:1.0";

  public static void insert (org.omg.CORBA.Any a, com.example.democorba.service.GreetingService that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.example.democorba.service.GreetingService extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (com.example.democorba.service.GreetingServiceHelper.id (), "GreetingService");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.example.democorba.service.GreetingService read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GreetingServiceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.example.democorba.service.GreetingService value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static com.example.democorba.service.GreetingService narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.example.democorba.service.GreetingService)
      return (com.example.democorba.service.GreetingService)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.example.democorba.service._GreetingServiceStub stub = new com.example.democorba.service._GreetingServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static com.example.democorba.service.GreetingService unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof com.example.democorba.service.GreetingService)
      return (com.example.democorba.service.GreetingService)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      com.example.democorba.service._GreetingServiceStub stub = new com.example.democorba.service._GreetingServiceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
