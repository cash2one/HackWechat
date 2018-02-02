package com.tencent.mm.compatible.loader;

import java.lang.reflect.Field;

public final class c<T> {
    private String classname;
    private String fieldName;
    private boolean gGO;
    private Field gGP;
    private Object obj;

    public c(Object obj, String str, String str2) {
        if (obj == null) {
            throw new IllegalArgumentException("obj cannot be null");
        }
        this.obj = obj;
        this.fieldName = str;
        this.classname = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void prepare() {
        if (!this.gGO) {
            this.gGO = true;
            Class cls = this.obj.getClass();
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.fieldName);
                    declaredField.setAccessible(true);
                    this.gGP = declaredField;
                    cls.getSuperclass();
                    return;
                } catch (Exception e) {
                } catch (Throwable th) {
                    cls.getSuperclass();
                }
            }
        }
    }

    public final T get() {
        prepare();
        if (this.gGP == null) {
            throw new NoSuchFieldException();
        }
        try {
            return this.gGP.get(this.obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("unable to cast object");
        }
    }

    public final void set(T t) {
        prepare();
        if (this.gGP == null) {
            throw new NoSuchFieldException();
        }
        this.gGP.set(this.obj, t);
    }

    public final boolean yW() {
        prepare();
        return this.gGP != null;
    }
}
