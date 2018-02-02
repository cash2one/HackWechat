package org.xwalk.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

class ReflectMethod {
    private Object[] mArguments;
    private Class<?> mClass;
    private Object mInstance;
    private Method mMethod;
    private String mName;
    private Class<?>[] mParameterTypes;

    public ReflectMethod(Object obj, String str, Class<?>... clsArr) {
        init(obj, null, str, clsArr);
    }

    public ReflectMethod(Class<?> cls, String str, Class<?>... clsArr) {
        init(null, cls, str, clsArr);
    }

    public boolean init(Object obj, Class<?> cls, String str, Class<?>... clsArr) {
        this.mInstance = obj;
        if (cls == null) {
            cls = obj != null ? obj.getClass() : null;
        }
        this.mClass = cls;
        this.mName = str;
        this.mParameterTypes = clsArr;
        this.mMethod = null;
        if (this.mClass == null) {
            return false;
        }
        try {
            this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
        } catch (NoSuchMethodException e) {
            Class cls2 = this.mClass;
            while (cls2 != null) {
                try {
                    this.mMethod = cls2.getDeclaredMethod(this.mName, this.mParameterTypes);
                    this.mMethod.setAccessible(true);
                    break;
                } catch (NoSuchMethodException e2) {
                    cls2 = cls2.getSuperclass();
                }
            }
        }
        return this.mMethod != null;
    }

    public Object invoke(Object... objArr) {
        Throwable e;
        if (this.mMethod == null) {
            throw new UnsupportedOperationException(toString());
        }
        try {
            return this.mMethod.invoke(this.mInstance, objArr);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RejectedExecutionException(e);
        } catch (NullPointerException e3) {
            e = e3;
            throw new RejectedExecutionException(e);
        } catch (IllegalArgumentException e4) {
            throw e4;
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5.getCause());
        }
    }

    public boolean isNull() {
        return this.mMethod == null;
    }

    public String toString() {
        if (this.mMethod != null) {
            return this.mMethod.toString();
        }
        String str = "";
        if (this.mClass != null) {
            str = str + this.mClass.toString() + ".";
        }
        if (this.mName != null) {
            return str + this.mName;
        }
        return str;
    }

    public String getName() {
        return this.mName;
    }

    public Object getInstance() {
        return this.mInstance;
    }

    public Object[] getArguments() {
        return this.mArguments;
    }

    public void setArguments(Object... objArr) {
        this.mArguments = objArr;
    }

    public Object invokeWithArguments() {
        return invoke(this.mArguments);
    }
}
