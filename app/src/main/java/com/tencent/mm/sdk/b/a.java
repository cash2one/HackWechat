package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a {
    public static a xef = new a();
    private a xee = new a();
    private final HashMap<Integer, LinkedList<c>> xeg = new HashMap();
    private final HashMap<Integer, b> xeh = new HashMap();

    public static class a extends d {
        public final void f(Runnable runnable) {
            runnable.run();
        }

        public final void f(Runnable runnable, long j) {
            runnable.run();
        }

        public final String getType() {
            return Thread.currentThread().toString();
        }

        public final void cancel() {
        }
    }

    private class b extends com.tencent.mm.vending.b.a<c> {
        final /* synthetic */ a xej;

        public b(a aVar) {
            this.xej = aVar;
            super(aVar.xee);
        }

        public final void a(com.tencent.mm.vending.j.a aVar) {
            LinkedList czM = czM();
            b bVar = (b) aVar.get(0);
            if (bVar == null) {
                x.e("MicroMsg.EventCenter", "event is null! fatal!");
                return;
            }
            if (bVar.xel) {
                Collections.sort(czM, new Comparator<com.tencent.mm.vending.b.b>(this) {
                    final /* synthetic */ b xek;

                    {
                        this.xek = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((c) ((com.tencent.mm.vending.b.b) obj2).zBN).priority - ((c) ((com.tencent.mm.vending.b.b) obj).zBN).priority;
                    }
                });
            }
            com.tencent.mm.vending.b.b[] bVarArr = new com.tencent.mm.vending.b.b[czM.size()];
            czM.toArray(bVarArr);
            int length = bVarArr.length;
            int i = 0;
            while (i < length && (!((c) bVarArr[i].zBN).a(bVar) || !bVar.xel)) {
                i++;
            }
            if (bVar.fqI != null) {
                bVar.fqI.run();
            }
        }
    }

    private a() {
    }

    public final com.tencent.mm.vending.b.b<c> a(c cVar) {
        com.tencent.mm.vending.b.b<c> a;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            x.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.ceN()));
            com.tencent.mm.vending.b.a aVar = (b) this.xeh.get(Integer.valueOf(cVar.ceN()));
            if (aVar == null) {
                HashMap hashMap = this.xeh;
                Integer valueOf = Integer.valueOf(cVar.ceN());
                aVar = new b(this);
                hashMap.put(valueOf, aVar);
            }
            a = aVar.a(new com.tencent.mm.vending.b.b(cVar, aVar));
        }
        return a;
    }

    @Deprecated
    public final boolean b(c cVar) {
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            x.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.ceN()));
            LinkedList linkedList = (LinkedList) this.xeg.get(Integer.valueOf(cVar.ceN()));
            if (linkedList == null) {
                HashMap hashMap = this.xeg;
                Integer valueOf = Integer.valueOf(cVar.ceN());
                linkedList = new LinkedList();
                hashMap.put(valueOf, linkedList);
            }
            if (linkedList.contains(cVar)) {
                return true;
            }
            ListenerInstanceMonitor.bU(cVar);
            boolean add = linkedList.add(cVar);
            return add;
        }
    }

    @Deprecated
    public final boolean c(c cVar) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.remove", cVar);
            x.v("MicroMsg.EventCenter", "removeListener %s(%d)", cVar, Integer.valueOf(cVar.ceN()));
            LinkedList linkedList = (LinkedList) this.xeg.get(Integer.valueOf(cVar.ceN()));
            if (linkedList != null) {
                z2 = linkedList.remove(cVar);
            }
            b bVar = (b) this.xeh.get(Integer.valueOf(cVar.ceN()));
            if (bVar != null) {
                bVar.b(new com.tencent.mm.vending.b.b(cVar, bVar));
                z = true;
            } else {
                z = z2;
            }
            ListenerInstanceMonitor.bV(cVar);
        }
        return z;
    }

    public final boolean m(b bVar) {
        boolean z = false;
        boolean z2 = true;
        Assert.assertNotNull("EventPoolImpl.publish", bVar);
        x.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.ceN()));
        LinkedList linkedList = null;
        synchronized (this) {
            int ceN = bVar.ceN();
            LinkedList linkedList2 = (LinkedList) this.xeg.get(Integer.valueOf(ceN));
            if (linkedList2 != null) {
                linkedList = new LinkedList(linkedList2);
                z = true;
            }
            b bVar2 = (b) this.xeh.get(Integer.valueOf(ceN));
            if (bVar2 == null) {
                z2 = z;
            }
            if (!z2) {
                x.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", bVar, Integer.valueOf(ceN), "");
            }
        }
        if (linkedList != null) {
            a(linkedList, bVar);
        }
        if (bVar2 != null) {
            bVar2.a(g.cq(bVar));
        }
        return z2;
    }

    public final void a(final b bVar, Looper looper) {
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        x.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.ceN()));
        new af(looper).post(new Runnable(this) {
            final /* synthetic */ a xej;

            public final void run() {
                a.xef.m(bVar);
            }
        });
    }

    public final synchronized boolean B(Class<? extends b> cls) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.xeg.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            b bVar = (b) this.xeh.get(Integer.valueOf(cls.getName().hashCode()));
            if (bVar == null || bVar.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized boolean d(c cVar) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hadListened", cVar);
        LinkedList linkedList = (LinkedList) this.xeg.get(Integer.valueOf(cVar.ceN()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(cVar)) {
            b bVar = (b) this.xeh.get(Integer.valueOf(cVar.ceN()));
            if (bVar == null || bVar.size() <= 0 || !bVar.contains(cVar)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        if (bVar.xel) {
            Collections.sort(linkedList, new Comparator<c>(this) {
                final /* synthetic */ a xej;

                {
                    this.xej = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj2).priority - ((c) obj).priority;
                }
            });
        }
        c[] cVarArr = new c[linkedList.size()];
        linkedList.toArray(cVarArr);
        int length = cVarArr.length;
        int i = 0;
        while (i < length && (!cVarArr[i].a(bVar) || !bVar.xel)) {
            i++;
        }
        if (bVar.fqI != null) {
            bVar.fqI.run();
        }
    }
}
