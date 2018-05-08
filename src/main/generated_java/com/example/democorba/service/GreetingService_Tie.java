package com.example.democorba.service;


/**
* com/example/democorba/service/GreetingService_Tie.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* /Users/shimizukazuki/git-me/democorba/src/main/resources/GreetingService.idlから
* 2018年5月8日 22時51分33秒 JST
*/

public class GreetingService_Tie extends _GreetingServiceImplBase
{

  // Constructors
  public GreetingService_Tie ()
  {
  }

  public GreetingService_Tie (com.example.democorba.service.GreetingServiceOperations impl)
  {
    super ();
    _impl = impl;
  }

  public String hello (String message)
  {
    return _impl.hello(message);
  } // hello

  public void execute (byte[] request, com.example.democorba.service.BytesDataHolder response)
  {
    _impl.execute(request, response);
  } // execute

  private com.example.democorba.service.GreetingServiceOperations _impl;

} // class GreetingService_Tie
