package com.sun.btrace.samples;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace public class YarnCalls {
    @OnMethod(
	      clazz="/org\\.apache\\.hadoop\\.yarn.+/",
	      method="/.*/"
    )
    public static void yarn1(@Self Object self, @ProbeClassName String pcm, @ProbeMethodName String pmn, AnyType[] args)
    {
	println("Context: " + pcm + "#" +  pmn);
	println(self);
        printArray(args);
	jstack();
	println("\n\n");
    }

} 
