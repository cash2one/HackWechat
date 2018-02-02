package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T> {
    private static final Object aEw = new Object();
    static a aXt = null;
    private static int aXu = 0;
    private static String aXv = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private T aIl = null;
    protected final String aXw;
    protected final T aXx;

    protected j(String str, T t) {
        this.aXw = str;
        this.aXx = t;
    }

    public static j<Float> a(String str, Float f) {
        return new 4(str, f);
    }

    public static j<Integer> a(String str, Integer num) {
        return new j<Integer>(str, num) {
            protected final /* synthetic */ Object py() {
                return j.aXt.pC();
            }
        };
    }

    public static j<Long> a(String str, Long l) {
        return new 2(str, l);
    }

    public static j<Boolean> h(String str, boolean z) {
        return new j<Boolean>(str, Boolean.valueOf(z)) {
            protected final /* synthetic */ Object py() {
                return j.aXt.pA();
            }
        };
    }

    public static boolean isInitialized() {
        return aXt != null;
    }

    public static j<String> n(String str, String str2) {
        return new 5(str, str2);
    }

    public static int px() {
        return aXu;
    }

    public final T get() {
        return this.aIl != null ? this.aIl : py();
    }

    protected abstract T py();

    public final T pz() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
