package Corba;
/**
* interfaceCorba/DivisionPorCeroHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from interfaz.idl
* martes 27 de febrero de 2018 08:33:19 PM CST
*/

abstract public class DivisionPorCeroHelper
{
  private static String  _id = "IDL:interfaceCorba/DivisionPorCero:1.0";

  public static void insert (org.omg.CORBA.Any a, Corba.DivisionPorCero that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Corba.DivisionPorCero extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[0] = new org.omg.CORBA.StructMember (
            "op1",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[1] = new org.omg.CORBA.StructMember (
            "op2",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (Corba.DivisionPorCeroHelper.id (), "DivisionPorCero", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Corba.DivisionPorCero read (org.omg.CORBA.portable.InputStream istream)
  {
    Corba.DivisionPorCero value = new Corba.DivisionPorCero ();
    // read and discard the repository ID
    istream.read_string ();
    value.op1 = istream.read_float ();
    value.op2 = istream.read_float ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Corba.DivisionPorCero value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_float (value.op1);
    ostream.write_float (value.op2);
  }

}