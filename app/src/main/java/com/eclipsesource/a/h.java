package com.eclipsesource.a;

import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;

public abstract class h implements Serializable {
    @Deprecated
    public static final h abt = a.abt;
    @Deprecated
    public static final h abu = a.abu;
    @Deprecated
    public static final h abv = a.abv;

    abstract void a(i iVar);

    h() {
    }

    public boolean isObject() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public e ht() {
        throw new UnsupportedOperationException("Not an object: " + toString());
    }

    public b ho() {
        throw new UnsupportedOperationException("Not an array: " + toString());
    }

    public int hq() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public long hr() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public double hs() {
        throw new UnsupportedOperationException("Not a number: " + toString());
    }

    public String hC() {
        throw new UnsupportedOperationException("Not a string: " + toString());
    }

    public boolean hp() {
        throw new UnsupportedOperationException("Not a boolean: " + toString());
    }

    public String toString() {
        return a(l.acd);
    }

    private String a(l lVar) {
        Writer stringWriter = new StringWriter();
        if (lVar == null) {
            try {
                throw new NullPointerException("config is null");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        Writer mVar = new m(stringWriter);
        a(lVar.a(mVar));
        mVar.flush();
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
