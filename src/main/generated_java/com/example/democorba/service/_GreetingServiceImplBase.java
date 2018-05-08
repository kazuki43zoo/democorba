package com.example.democorba.service;


/**
* com/example/democorba/service/_GreetingServiceImplBase.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* /Users/shimizukazuki/git-me/democorba/src/main/resources/GreetingService.idlから
* 2018年5月8日 22時51分33秒 JST
*/

public abstract class _GreetingServiceImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements com.example.democorba.service.GreetingService, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _GreetingServiceImplBase ()
  {
  }

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

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _GreetingServiceImplBase
