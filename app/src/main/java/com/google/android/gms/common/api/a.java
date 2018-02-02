package com.google.android.gms.common.api;

import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.Set;

public final class a<O> {
    private final a<?, O> aJQ;
    final e<?, O> aJR = null;
    private final c<?> aJS;
    final f<?> aJT;
    final String mName;

    public interface b {
        void a(e eVar);

        void a(p pVar);

        void a(p pVar, Set<Scope> set);

        void a(String str, PrintWriter printWriter);

        void disconnect();

        boolean isConnected();

        boolean nV();

        boolean nW();
    }

    public <C extends b> a(String str, a<C, O> aVar, c<C> cVar) {
        w.i(aVar, "Cannot construct an Api with a null ClientBuilder");
        w.i(cVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.aJQ = aVar;
        this.aJS = cVar;
        this.aJT = null;
    }

    public final a<?, O> nS() {
        w.d(this.aJQ != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.aJQ;
    }

    public final c<?> nT() {
        w.d(this.aJS != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.aJS;
    }
}
