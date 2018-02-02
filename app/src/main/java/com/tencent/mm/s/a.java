package com.tencent.mm.s;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.s.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a gLt;
    public b gLu = new b();
    ArrayList<WeakReference<a>> gLv = new ArrayList();
    private final int gLw = 0;
    private final int gLx = 1;
    private af handler = new 1(this, Looper.getMainLooper());
    public boolean initialized = false;

    static /* synthetic */ void a(a aVar, int i, int i2) {
        ArrayList arrayList = null;
        Iterator it = aVar.gLv.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).gf(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gLv.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        ArrayList arrayList = null;
        Iterator it = aVar.gLv.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).ge(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gLv.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.storage.w.a aVar2, com.tencent.mm.storage.w.a aVar3) {
        ArrayList arrayList = null;
        Iterator it = aVar.gLv.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                weakReference.get();
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.gLv.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    public final void init() {
        this.initialized = true;
        this.gLu.gLI = g.Dj().CU();
    }

    public final void o(int i, boolean z) {
        a(i, 1, !z ? "0" : "1");
    }

    public final void a(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 1, !z ? "0" : "1");
    }

    public final void p(int i, boolean z) {
        a(i, 2, !z ? "0" : "1");
    }

    public final void b(com.tencent.mm.storage.w.a aVar, boolean z) {
        a(aVar, 2, !z ? "0" : "1");
    }

    private void a(int i, int i2, String str) {
        if (this.initialized) {
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.s.b.a gj = bVar.gj(i);
            if (gj == null) {
                gj = bVar.a(i, i2, "", "");
                bVar.gLD.put(i, gj);
                bVar.a(gj);
            }
            gj.value = str;
            gj.type = i2;
            gj.frP = bVar.Bp();
            bVar.a(gj);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, i, i2, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    private void a(com.tencent.mm.storage.w.a aVar, int i, String str) {
        if (this.initialized) {
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", new Object[]{aVar, Integer.valueOf(i), str});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                f = bVar.a(aVar, i, "", "");
                bVar.gLE.put(aVar, f);
                bVar.a(f);
            }
            f.value = str;
            f.type = i;
            f.frP = bVar.Bp();
            bVar.a(f);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, aVar, i, str)));
            return;
        }
        x.w("MicroMsg.NewBadge", "updateDataSource NewBadge has not initialized");
    }

    public final boolean aQ(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a x = this.gLu.x(i, i2, 1);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a a = this.gLu.a(aVar, aVar2, 1);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasNew NewBadge has not initialized");
        return false;
    }

    public final boolean aR(int i, int i2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a x = this.gLu.x(i, i2, 2);
            if (x == null || parseInt(x.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean b(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            com.tencent.mm.s.b.a a = this.gLu.a(aVar, aVar2, 2);
            if (a == null || parseInt(a.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar, int i) {
        if (this.initialized) {
            com.tencent.mm.s.b.a aVar2;
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherId %d, type %d", new Object[]{aVar, Integer.valueOf(i), Integer.valueOf(2)});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
                aVar2 = null;
            } else if ((f.type & 2) == 0) {
                x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
                aVar2 = null;
            } else {
                b gk = bVar.gk(i);
                if (gk != null) {
                    String str = (String) gk.gLM.get(aVar.name());
                    if (str == null || !str.equals(f.frP)) {
                        if (str == null) {
                            gk.gLM.put(aVar.name(), bVar.Bp());
                            bVar.a(gk);
                        }
                        aVar2 = f;
                    } else {
                        aVar2 = null;
                    }
                } else {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
                    aVar2 = null;
                }
            }
            if (aVar2 == null) {
                return false;
            }
            if (parseInt(aVar2.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "hasDot NewBadge has not initialized");
        return false;
    }

    public final void aS(int i, int i2) {
        if (this.initialized) {
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %d, watcherId %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            com.tencent.mm.s.b.a gj = bVar.gj(i);
            if (gj == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b gk = bVar.gk(i2);
                if (gk == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gk = bVar.gi(i2);
                    bVar.gLF.put(i2, gk);
                }
                gk.gLL.put(i, gj.frP);
                bVar.a(gk);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i2, i)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void c(com.tencent.mm.storage.w.a aVar, com.tencent.mm.storage.w.a aVar2) {
        if (this.initialized) {
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %s", new Object[]{aVar, aVar2});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b g = bVar.g(aVar2);
                if (g == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    g = bVar.e(aVar2);
                    bVar.gLG.put(aVar2, g);
                }
                g.gLM.put(aVar.name(), f.frP);
                bVar.a(g);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, aVar2, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final void b(com.tencent.mm.storage.w.a aVar, int i) {
        if (this.initialized) {
            b bVar = this.gLu;
            x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, doWatch %s, watcherKey %d", new Object[]{aVar, Integer.valueOf(i)});
            com.tencent.mm.s.b.a f = bVar.f(aVar);
            if (f == null) {
                x.d("MicroMsg.NewBadgeDecoder", "[carl] doWatch, dataSource == null");
            } else {
                b gk = bVar.gk(i);
                if (gk == null) {
                    x.e("MicroMsg.NewBadgeDecoder", "[carl] doWatch, watcher == null, do some fix");
                    gk = bVar.gi(i);
                    bVar.gLF.put(i, gk);
                }
                gk.gLM.put(aVar.name(), f.frP);
                bVar.a(gk);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i, aVar)));
            return;
        }
        x.w("MicroMsg.NewBadge", "markRead NewBadge has not initialized");
    }

    public final boolean a(com.tencent.mm.storage.w.a aVar) {
        if (this.initialized) {
            com.tencent.mm.s.b.a f = this.gLu.f(aVar);
            if (f == null || parseInt(f.value) == 0) {
                return false;
            }
            return true;
        }
        x.w("MicroMsg.NewBadge", "queryHasDotSourceValue NewBadge has not initialized");
        return false;
    }

    public static int parseInt(String str) {
        if (bh.ov(str)) {
            return 0;
        }
        return bh.VI(str);
    }

    public final void a(a aVar) {
        if (this.initialized) {
            this.gLv.add(new WeakReference(aVar));
        } else {
            x.w("MicroMsg.NewBadge", "addWatch NewBadge has not initialized");
        }
    }

    public final void b(a aVar) {
        if (this.initialized) {
            ArrayList arrayList = null;
            for (int i = 0; i < this.gLv.size(); i++) {
                WeakReference weakReference = (WeakReference) this.gLv.get(i);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.gLv.remove((WeakReference) it.next());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        x.w("MicroMsg.NewBadge", "removeWatch NewBadge has not initialized");
    }
}
