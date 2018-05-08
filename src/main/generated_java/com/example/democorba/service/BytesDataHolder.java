package com.example.democorba.service;


/**
* com/example/democorba/service/BytesDataHolder.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* src/main/resources/GreetingService.idlから
* 2018年5月8日 20時49分23秒 JST
*/

public final class BytesDataHolder implements org.omg.CORBA.portable.Streamable
{
  public byte value[] = null;

  public BytesDataHolder ()
  {
  }

  public BytesDataHolder (byte[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.example.democorba.service.BytesDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.example.democorba.service.BytesDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.example.democorba.service.BytesDataHelper.type ();
  }

}
