package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.f.a;
import com.tencent.mapsdk.rastercore.tile.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b implements e$a {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private static final int b = Runtime.getRuntime().availableProcessors();
    private e c;
    private Map<String, List<a>> d = new HashMap();
    private Map<String, List<a>> e = new HashMap();
    private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
    private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private ExecutorService h;
    private ExecutorService i;
    private ThreadFactory j = new ThreadFactory(this) {
        private int a = 0;

        public final Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("TileFetchThread#");
            int i = this.a;
            this.a = i + 1;
            Thread thread = new Thread(runnable, stringBuilder.append(i).toString());
            thread.setPriority(10);
            return thread;
        }
    };

    public b(e eVar) {
        int i;
        int i2 = 3;
        this.c = eVar;
        if (b < 4) {
            i = 3;
        } else {
            i2 = 4;
            i = 4;
        }
        this.i = new ThreadPoolExecutor(i, i2, 30, TimeUnit.SECONDS, this.g, this.j);
        this.h = new ThreadPoolExecutor(1, 1, 30, a, this.f);
    }

    static /* synthetic */ void a(b bVar, a aVar, boolean z, c cVar) {
        String aVar2 = aVar.toString();
        synchronized (bVar.d) {
            List list = (List) bVar.d.get(aVar2);
            if (list != null) {
                list.add(aVar);
            } else {
                list = new ArrayList();
                list.add(aVar);
                bVar.d.put(aVar2, list);
                try {
                    Callable eVar = new e(bVar, aVar);
                    eVar.a(z);
                    eVar.a(cVar);
                    if (!bVar.i.isShutdown()) {
                        bVar.i.submit(eVar);
                    }
                } catch (Exception e) {
                    new StringBuilder("Submit get error:").append(e.getMessage());
                }
            }
        }
    }

    public final void a() {
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
        if (this.h != null) {
            this.h.shutdownNow();
            this.h = null;
        }
        if (this.i != null) {
            this.i.shutdown();
            this.i = null;
        }
    }

    public final void a(e eVar) {
        if (eVar != null) {
            List<a> list;
            String b = eVar.b();
            Bitmap a = eVar.a();
            synchronized (this.d) {
                list = (List) this.e.remove(b);
                this.d.remove(b);
            }
            if (!(list == null || a == null || a.isRecycled())) {
                for (a aVar : list) {
                    if (!aVar.i()) {
                        aVar.a(a.copy(a.getConfig(), false));
                    }
                }
            }
            eVar.c();
        }
        this.c.c().postInvalidate();
    }

    public final void a(ArrayList<MapTile> arrayList) {
        if (!a.a(arrayList)) {
            this.f.clear();
            Runnable 2 = new 2(this, arrayList);
            try {
                if (!this.h.isShutdown()) {
                    this.h.execute(2);
                }
            } catch (Exception e) {
                new StringBuilder("getTiles get error:").append(e.getMessage());
            }
        }
    }

    public final void b(e eVar) {
        if (eVar != null) {
            String b = eVar.b();
            synchronized (this.d) {
                this.e.put(b, (List) this.d.remove(b));
            }
        }
    }
}
