package com.example.democorba.service;

/**
 * Generated from IDL alias "BytesData".
 *
 * @author JacORB IDL compiler V 3.9
 * @version generated at 2018/05/08 23:09:57
 */

public final class BytesDataHolder
	implements org.omg.CORBA.portable.Streamable
{
	public byte[] value;

	public BytesDataHolder ()
	{
	}
	public BytesDataHolder (final byte[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return BytesDataHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = BytesDataHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		BytesDataHelper.write (out,value);
	}
}
