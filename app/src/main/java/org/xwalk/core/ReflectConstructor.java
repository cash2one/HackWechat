package org.xwalk.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

class ReflectConstructor {
    private Class<?> mClass;
    private Constructor<?> mConstructor;
    private Class<?>[] mParameterTypes;

    public ReflectConstructor(Class<?> cls, Class<?>... clsArr) {
        init(cls, clsArr);
    }

    public boolean init(Class<?> cls, Class<?>... clsArr) {
        this.mClass = cls;
        this.mParameterTypes = clsArr;
        this.mConstructor = null;
        if (this.mClass == null) {
            return false;
        }
        try {
            this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
        } catch (NoSuchMethodException e) {
            try {
                this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
                this.mConstructor.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
        }
        if (this.mConstructor != null) {
            return true;
        }
        return false;
    }

    public Object newInstance(Object... objArr) {
        if (this.mConstructor == null) {
            throw new UnsupportedOperationException(toString());
        }
        try {
            return this.mConstructor.newInstance(objArr);
        } catch (Throwable e) {
            throw new RejectedExecutionException(e);
        } catch (Throwable e2) {
            throw new RejectedExecutionException(e2);
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4.getCause());
        }
    }

    public boolean isNull() {
        return this.mConstructor == null;
    }

    public String toString() {
        if (this.mConstructor != null) {
            return this.mConstructor.toString();
        }
        String str = "";
        if (this.mClass != null) {
            return str + this.mClass.toString();
        }
        return str;
    }
}
