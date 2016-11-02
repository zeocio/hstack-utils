package com.sun.btrace.samples;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class YarnWebCalls {
    @OnMethod(
	      clazz="/org\\.apache\\.hadoop\\.yarn.+(webapp|webproxy|http).+/",
	      method="/.+/"
    )
    public static void yarn1(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args)
    {
	Thread t = currentThread();
	println(t + " id(" + threadId(t) + ")");
	println("Context: " + pcm + "#" +  pmn);
	println("This: " + self);
        printArray(args);
	jstack();
	println("\n\n");
    }

    @OnMethod(
	      clazz="/org\\.apache\\.hadoop\\.yarn.+(webapp|webproxy|http).+/",
	      method="/.+/",
	      location=@Location(Kind.RETURN)
    )
    public static void yarn2(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, @Return AnyType ret)
    {
	Thread t = currentThread();
	println(t + " id(" + threadId(t) + ")");
	println("Context: " + pcm + "#" +  pmn);
	println("This: " + self);
        //printArray(args);
	println("Return: " + ret);
	println("\n\n");
    }

} 
