package com.sun.btrace.samples;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class SparkCalls {
    /*
    @OnMethod(
	      clazz="org.apache.spark.util.ByteBufferInputStream",
	      method="buffer",
	      location=@Location(value=Kind.CALL, clazz="/.+/", method="/.+/")
	      )
    public static void o(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args) //, @Return AnyType ret)
    {
	println("Context: " + pcm + "#" +  pmn);
	println(self);
        printArray(args);
	//println(ret);
	jstack();
	println("\n\n");
    }
*/

    @OnMethod(
	      clazz="/org\\.apache\\.spark\\..+/",
	      method="/.+huffle.*/"
    )
    public static void shuffle1(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args)
    {
	println("Context: " + pcm + "#" +  pmn);
	println(self);
        printArray(args);
	jstack();
	println("\n\n");
    }

    @OnMethod(
	      clazz="/org\\.apache\\.spark\\..+huffl.+/",
	      method="/.+/"
    )
    public static void shuffle2(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args)
    {
	println("Context: " + pcm + "#" +  pmn);
	println(self);
        printArray(args);
	jstack();
	println("\n\n");
    }

    @OnMethod(
	      clazz="/org\\.apache\\.spark\\.scheduler.+/",
	      method="/.+/"
    )
    public static void sched1(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args)
    {
	println("Context: " + pcm + "#" +  pmn);
	println(self);
        printArray(args);
	jstack();
	println("\n\n");
    }

} 
