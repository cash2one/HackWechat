package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Keep
public class JsClassUtils {
    private static final int BOOLEAN = 1;
    private static final int BYTE = 3;
    private static final int CHAR = 2;
    private static final int DOUBLE = 8;
    private static final int FLOAT = 6;
    private static final int INT = 5;
    private static final int LONG = 7;
    private static final int SHORT = 4;
    private static final int VOID = 0;
    private static final int string = 9;
    private static final int unknown = 10;

    public static boolean hasJavascriptInterface(Object obj) {
        try {
            for (Method isAnnotationPresent : obj.getClass().getMethods()) {
                if (isAnnotationPresent.isAnnotationPresent(JavascriptInterface.class)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Keep
    public static Method[] getJavascriptInterfaceMethod(Object obj) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    arrayList.add(method);
                }
            }
        } catch (Exception e) {
        }
        return (Method[]) arrayList.toArray(new Method[arrayList.size()]);
    }

    @Keep
    public static String getMethodSignature(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Class descriptor : parameterTypes) {
            getDescriptor(stringBuilder, descriptor);
        }
        stringBuilder.append(')');
        getDescriptor(stringBuilder, method.getReturnType());
        return stringBuilder.toString();
    }

    @Keep
    public static String getMethodName(Method method) {
        return method.getName();
    }

    private static void getDescriptor(StringBuilder stringBuilder, Class<?> cls) {
        char charAt;
        while (!cls.isPrimitive()) {
            if (cls.isArray()) {
                stringBuilder.append('[');
                cls = cls.getComponentType();
            } else {
                stringBuilder.append('L');
                String name = cls.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = '/';
                    }
                    stringBuilder.append(charAt);
                }
                stringBuilder.append(';');
                return;
            }
        }
        if (cls == Integer.TYPE) {
            charAt = 'I';
        } else if (cls == Void.TYPE) {
            charAt = 'V';
        } else if (cls == Boolean.TYPE) {
            charAt = 'Z';
        } else if (cls == Byte.TYPE) {
            charAt = 'B';
        } else if (cls == Character.TYPE) {
            charAt = 'C';
        } else if (cls == Short.TYPE) {
            charAt = 'S';
        } else if (cls == Double.TYPE) {
            charAt = 'D';
        } else if (cls == Float.TYPE) {
            charAt = 'F';
        } else {
            charAt = 'J';
        }
        stringBuilder.append(charAt);
    }

    private static int getJavaType(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 5;
        }
        if (cls == Void.TYPE) {
            return 0;
        }
        if (cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Byte.TYPE) {
            return 3;
        }
        if (cls == Character.TYPE) {
            return 2;
        }
        if (cls == Short.TYPE) {
            return 4;
        }
        if (cls == Double.TYPE) {
            return 8;
        }
        if (cls == Float.TYPE) {
            return 6;
        }
        if (cls.getCanonicalName().equals("java.lang.String")) {
            return 9;
        }
        return 10;
    }

    @Keep
    public static int[] getMethodType(Method method) {
        int i = 0;
        Class[] parameterTypes = method.getParameterTypes();
        int[] iArr = new int[(parameterTypes.length + 2)];
        iArr[0] = parameterTypes.length;
        iArr[1] = getJavaType(method.getReturnType());
        while (i < parameterTypes.length) {
            iArr[i + 2] = getJavaType(parameterTypes[i]);
            i++;
        }
        return iArr;
    }
}
