package com.tencent.mm.ipcinvoker.e;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> gNc;
    private String gNd;
    private boolean gNe;
    private Field mField;

    public a(Class<?> cls, String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.gNc = cls;
        this.gNd = str;
    }

    private synchronized void prepare() {
        if (!this.gNe) {
            Class cls = this.gNc;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.gNd);
                    declaredField.setAccessible(true);
                    this.mField = declaredField;
                    break;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
            this.gNe = true;
        }
    }

    private synchronized FieldType BA() {
        FieldType fieldType = null;
        synchronized (this) {
            prepare();
            if (this.mField == null) {
                x.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", new Object[]{this.gNd});
            } else {
                try {
                    fieldType = this.mField.get(null);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("unable to cast object");
                }
            }
        }
        return fieldType;
    }

    public final synchronized FieldType BB() {
        FieldType fieldType;
        fieldType = null;
        try {
            fieldType = BA();
        } catch (NoSuchFieldException e) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e});
        } catch (IllegalAccessException e2) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e2});
        } catch (IllegalArgumentException e3) {
            x.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", new Object[]{e3});
        }
        return fieldType;
    }
}
