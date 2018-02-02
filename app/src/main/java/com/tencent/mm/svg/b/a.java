package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class a<T> {
    private String classname;
    private String fieldName;
    private boolean gGO;
    public Field gGP;
    public Object obj;

    public a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("obj cannot be null");
        }
        this.obj = obj;
        this.fieldName = str;
        this.classname = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepare() {
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
}
