package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ae {
    public final v aFD;
    public final ag aXZ;
    public boolean aYa;
    public long aYb;
    public long aYc;
    public long aYd;
    private long aYe;
    private long aYf;
    public boolean aYg;
    final Map<Class<? extends af>, af> aYh;
    final List<ai> aYi;

    private ae(ae aeVar) {
        this.aXZ = aeVar.aXZ;
        this.aFD = aeVar.aFD;
        this.aYb = aeVar.aYb;
        this.aYc = aeVar.aYc;
        this.aYd = aeVar.aYd;
        this.aYe = aeVar.aYe;
        this.aYf = aeVar.aYf;
        this.aYi = new ArrayList(aeVar.aYi);
        this.aYh = new HashMap(aeVar.aYh.size());
        for (Entry entry : aeVar.aYh.entrySet()) {
            af c = c((Class) entry.getKey());
            ((af) entry.getValue()).a(c);
            this.aYh.put(entry.getKey(), c);
        }
    }

    ae(ag agVar, v vVar) {
        w.ag(agVar);
        w.ag(vVar);
        this.aXZ = agVar;
        this.aFD = vVar;
        this.aYe = 1800000;
        this.aYf = 3024000000L;
        this.aYh = new HashMap();
        this.aYi = new ArrayList();
    }

    private static <T extends af> T c(Class<T> cls) {
        try {
            return (af) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public final <T extends af> T a(Class<T> cls) {
        return (af) this.aYh.get(cls);
    }

    public final <T extends af> T b(Class<T> cls) {
        af afVar = (af) this.aYh.get(cls);
        if (afVar != null) {
            return afVar;
        }
        T c = c(cls);
        this.aYh.put(cls, c);
        return c;
    }

    public final void b(af afVar) {
        w.ag(afVar);
        Class cls = afVar.getClass();
        if (cls.getSuperclass() != af.class) {
            throw new IllegalArgumentException();
        }
        afVar.a(b(cls));
    }

    public final ae pN() {
        return new ae(this);
    }
}
