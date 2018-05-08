package com.example.democorba.service;


/**
* com/example/democorba/service/GreetingServicePOA.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* src/main/resources/GreetingService.idlから
* 2018年5月8日 20時49分23秒 JST
*/

public abstract class GreetingServicePOA extends org.omg.PortableServer.Servant
 implements com.example.democorba.service.GreetingServiceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("hello", new java.lang.Integer (0));
    _methods.put ("execute", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // com/example/democorba/service/GreetingService/hello
       {
         String message = in.read_string ();
         String $result = null;
         $result = this.hello (message);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // com/example/democorba/service/GreetingService/execute
       {
         byte request[] = com.example.democorba.service.BytesDataHelper.read (in);
         com.example.democorba.service.BytesDataHolder response = new com.example.democorba.service.BytesDataHolder ();
         this.execute (request, response);
         out = $rh.createReply();
         com.example.democorba.service.BytesDataHelper.write (out, response.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:com/example/democorba/service/GreetingService:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GreetingService _this() 
  {
    return GreetingServiceHelper.narrow(
    super._this_object());
  }

  public GreetingService _this(org.omg.CORBA.ORB orb) 
  {
    return GreetingServiceHelper.narrow(
    super._this_object(orb));
  }


} // class GreetingServicePOA
