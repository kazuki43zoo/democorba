package com.example.democorba.service;


/**
* com/example/democorba/service/GreetingServiceOperations.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* src/main/resources/GreetingService.idlから
* 2018年5月8日 20時49分23秒 JST
*/

public interface GreetingServiceOperations 
{
  String hello (String message);
  void execute (byte[] request, com.example.democorba.service.BytesDataHolder response);
} // interface GreetingServiceOperations
