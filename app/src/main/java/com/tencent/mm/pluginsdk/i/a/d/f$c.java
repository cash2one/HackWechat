package com.tencent.mm.pluginsdk.i.a.d;

import com.tencent.mm.pluginsdk.i.a.d.f.b;
import java.util.concurrent.FutureTask;

protected class f$c<V> extends FutureTask<V> {
    protected final b vhC;

    public f$c(Runnable runnable, V v, b bVar) {
        super(runnable, v);
        this.vhC = bVar;
    }
}
