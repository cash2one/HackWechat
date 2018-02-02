package com.tencent.mm.ipcinvoker.wx_extension.b;

import java.lang.ref.WeakReference;

class b$b<T> extends WeakReference<T> {
    public b$b(T t) {
        super(t);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b$b)) {
            return false;
        }
        Object obj2 = ((b$b) obj).get();
        Object obj3 = get();
        if (obj2 == obj3) {
            return true;
        }
        if (obj3 == null || !obj3.equals(obj2)) {
            return false;
        }
        return true;
    }
}
