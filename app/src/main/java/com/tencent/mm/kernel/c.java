package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.c.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class c {
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> gPT = new ConcurrentHashMap();
    private final ArrayList<f> gPU = new ArrayList();
    private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> gPV = new ConcurrentHashMap();
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> gPW = new ConcurrentHashMap();
    public com.tencent.mm.kernel.a.a.a<Class<? extends f>> gPX = new com.tencent.mm.kernel.a.a.a();
    private ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.c.a>, com.tencent.mm.kernel.c.c> gPY = new ConcurrentHashMap();
    protected a gPZ;
    public Class<? extends com.tencent.mm.kernel.b.a> gQa = null;
    private com.tencent.mm.kernel.a.a gQb;

    public interface a {
        void a(com.tencent.mm.kernel.c.a aVar);

        void b(f fVar);

        void b(com.tencent.mm.kernel.c.a aVar);

        void c(f fVar);

        void c(com.tencent.mm.kernel.c.a aVar);
    }

    public final synchronized f f(Class<? extends f> cls) {
        return a((Class) cls, false);
    }

    private synchronized f a(Class<? extends f> cls, boolean z) {
        f fVar;
        Assert.assertNotNull(cls);
        try {
            fVar = (f) cls.newInstance();
            if (z) {
                fVar.markAsPendingPlugin();
            }
            fVar = a(fVar);
        } catch (Throwable e) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
            fVar = null;
        }
        return fVar;
    }

    public final synchronized f fJ(String str) {
        return p(str, false);
    }

    public final synchronized f p(String str, boolean z) {
        f a;
        try {
            Class cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                a = a(cls, z);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                a = null;
            }
        } catch (ClassNotFoundException e) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            h.Do().Dg().CN();
            new Object[1][0] = str;
        }
        return a;
    }

    private synchronized f a(f fVar) {
        f fVar2;
        boolean z = false;
        synchronized (this) {
            if (g(fVar.getClass())) {
                j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", fVar.getClass());
                fVar2 = (f) l(fVar.getClass());
            } else {
                Assert.assertNotNull(fVar);
                String[] ofProcesses = fVar.ofProcesses();
                if (ofProcesses != null && ofProcesses.length > 0) {
                    g CN = h.Do().Dg().CN();
                    for (String fR : ofProcesses) {
                        z = CN.fR(fR);
                        if (z) {
                            break;
                        }
                    }
                    if (!z) {
                        throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{fVar, CN.gOs, Arrays.asList(ofProcesses)}));
                    }
                }
                this.gPT.put(fVar.getClass(), fVar);
                this.gPU.add(fVar);
                fVar.invokeInstalled();
                if (this.gPZ != null) {
                    this.gPZ.b(fVar);
                }
                fVar2 = fVar;
            }
        }
        return fVar2;
    }

    public final synchronized boolean g(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        return this.gPT.containsKey(cls);
    }

    public final synchronized void c(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        f fVar = (f) this.gPT.get(cls);
        Assert.assertNotNull(fVar);
        ArrayList arrayList = (ArrayList) this.gPV.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.gPV.put(cls, arrayList);
        }
        this.gPW.put(cls2, cls);
        arrayList.add(cls2);
        this.gPT.put(cls2, fVar);
    }

    public final <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        T i;
        T i2 = i(cls);
        if (i2 == null) {
            int i3;
            if (cls != null) {
                e eVar = (e) cls.getAnnotation(e.class);
                if (!(eVar == null || eVar.value() == null)) {
                    com.tencent.mm.kernel.b.a k = k(eVar.value());
                    i3 = (k == null || f.aA(k)) ? 0 : 1;
                    if (i3 != 0) {
                        j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                        i = i(cls);
                        if (i == null) {
                            return i;
                        }
                        h.Do().Dg().CN();
                        new Object[1][0] = cls;
                        return (com.tencent.mm.kernel.c.a) f.n(cls);
                    }
                }
            }
            i3 = 0;
            if (i3 != 0) {
                j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                i = i(cls);
                if (i == null) {
                    return i;
                }
                h.Do().Dg().CN();
                new Object[1][0] = cls;
                return (com.tencent.mm.kernel.c.a) f.n(cls);
            }
        }
        i = i2;
        if (i == null) {
            return i;
        }
        h.Do().Dg().CN();
        new Object[1][0] = cls;
        return (com.tencent.mm.kernel.c.a) f.n(cls);
    }

    private <T extends com.tencent.mm.kernel.c.a> T i(Class<T> cls) {
        int i;
        com.tencent.mm.kernel.c.a DV;
        com.tencent.mm.kernel.c.c cVar = (com.tencent.mm.kernel.c.c) this.gPY.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            j.w("MMSkeleton.CorePlugins", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!", new Object[0]);
            i = 1;
        }
        if (cVar != null) {
            DV = cVar.DV();
        } else {
            j.e("MMSkeleton.CorePlugins", "Service(%s) not found!!! ", cls);
            if (i != 0) {
                j.e("MMSkeleton.CorePlugins", "This error must cause by using implementation class to call service! Use interface instead! Understand?", new Object[0]);
            }
            T t = null;
        }
        if (this.gPZ != null) {
            this.gPZ.c(DV);
        }
        return DV;
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        this.gPY.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).DT();
        }
        if ((cVar instanceof d) && this.gPZ != null) {
            this.gPZ.a(cVar.DV());
        }
        j.i("MMSkeleton.CorePlugins", "register service %s %s", cls, cVar);
    }

    public final void j(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        com.tencent.mm.kernel.c.c cVar = (com.tencent.mm.kernel.c.c) this.gPY.remove(cls);
        if (cVar instanceof b) {
            ((b) cVar).DU();
        }
        if ((cVar instanceof d) && this.gPZ != null) {
            this.gPZ.b(cVar.DV());
        }
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T k(Class<T> cls) {
        T t;
        T l = l(cls);
        if (this.gPZ != null) {
            this.gPZ.c((f) l);
        }
        if (l == null) {
            t = (com.tencent.mm.kernel.b.a) f.n(cls);
        } else {
            t = l;
        }
        return t;
    }

    private synchronized <T extends com.tencent.mm.kernel.b.a> T l(Class<T> cls) {
        Assert.assertNotNull(cls);
        return (com.tencent.mm.kernel.b.a) this.gPT.get(cls);
    }

    private synchronized boolean m(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            Assert.assertNotNull(cls);
            if (g(cls)) {
                z = true;
            } else {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
            }
        }
        return z;
    }

    public final void d(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (m(cls2)) {
            if (this.gPW.containsKey(cls2)) {
                cls2 = (Class) this.gPW.get(cls2);
            }
            this.gPX.o(cls, cls2);
            if (this.gQb == null) {
                this.gQb = h.Do().Dg().CN().gQb;
            }
            f fVar = (f) l(cls);
            f fVar2 = (f) l(cls2);
            this.gQb.gRg.a(com.tencent.mm.kernel.b.b.class, fVar, fVar2);
            this.gQb.gRg.a(com.tencent.mm.kernel.a.c.b.class, fVar, fVar2);
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls2.getName(), cls.getName()});
        j.e("MMSkeleton.CorePlugins", format, new Object[0]);
        throw new IllegalAccessError(format);
    }

    public final synchronized void CL() {
        Iterator it = this.gPU.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.a("skip make dependency for plugin %s.", fVar);
            } else {
                com.tencent.mm.kernel.a.a.a("make dependency for plugin %s...", fVar);
                fVar.invokeDependency();
            }
        }
    }

    public final synchronized List<f> CM() {
        return this.gPU;
    }
}
