package com.tencent.mm.sdk.b;

import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class c<T extends b> {
    final int priority;
    public int xen;
    private b<c> xeo;

    public abstract boolean a(T t);

    public c() {
        this(0);
    }

    public c(int i) {
        this.xen = 0;
        this.priority = i;
    }

    final int ceN() {
        if (this.xen == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            Type genericSuperclass = getClass().getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                genericSuperclass = getClass().getSuperclass().getGenericSuperclass();
            }
            this.xen = ((Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]).getName().hashCode();
            x.v("IListener", "genEventID, %s<%s>, useTime:%d", getClass().getName(), r1, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return this.xen;
    }

    public final synchronized b<c> ceO() {
        if (this.xeo == null) {
            ListenerInstanceMonitor.bU(this);
            this.xeo = a.xef.a(this);
        }
        return this.xeo;
    }

    public final synchronized void dead() {
        if (this.xeo != null) {
            ListenerInstanceMonitor.bV((c) this.xeo.zBN);
            this.xeo.dead();
            this.xeo = null;
        }
    }
}
