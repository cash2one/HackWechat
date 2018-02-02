package org.xwalk.core.extension;

import java.lang.reflect.AccessibleObject;
import org.xwalk.core.extension.ReflectionHelper.MemberType;

public class ReflectionHelper$MemberInfo {
    AccessibleObject accesser;
    boolean isEntryPoint;
    boolean isStatic;
    boolean isWritable;
    String javaName;
    String jsName;
    Class<?> mainClass;
    final /* synthetic */ ReflectionHelper this$0;
    MemberType type;
    boolean withPromise;
    String wrapArgs = "";
    String wrapReturns = "";

    public ReflectionHelper$MemberInfo(ReflectionHelper reflectionHelper) {
        this.this$0 = reflectionHelper;
    }
}
