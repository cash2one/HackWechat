package com.tencent.mm.sdk.f;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e implements a {
    private static e xkb;
    static int[] xkc = new int[]{19, 16, 13, 10, 0, -2, -4, -5, -6, -8};
    static long xkd = 0;
    static long xke = 0;
    private static b xkf;
    private static a xkg;
    private static b xkh;
    private boolean fni = false;
    volatile boolean fvI = false;
    Object lock = new Object();
    private f xjT = new f(this.xjU + 2, TimeUnit.SECONDS, this.xjV, this);
    private int xjU = cgS();
    private PriorityBlockingQueue<Runnable> xjV = new PriorityBlockingQueue(33);
    private LinkedList<g> xjW = new LinkedList();
    private ArrayList<g> xjX = new ArrayList();
    private HashMap<g, Thread> xjY = new HashMap();
    private ArrayList<c> xjZ = new ArrayList();
    private c xka;

    public interface b {
    }

    class a implements c {
        private final Runnable r;
        final /* synthetic */ e xki;

        public a(e eVar, Runnable runnable) {
            this.xki = eVar;
            this.r = runnable;
        }

        public final void z(Runnable runnable) {
            if (runnable.equals(this.r)) {
                synchronized (this.r) {
                    this.r.notifyAll();
                    e.c(this);
                }
            }
        }
    }

    class c extends af {
        final /* synthetic */ e xki;

        public c(e eVar, Looper looper) {
            this.xki = eVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    removeMessages(message.what);
                    if (this.xki.fvI) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (e.xkd > 0 && Math.abs(e.xke - currentTimeMillis) > e.xkd) {
                            x.i("MicroMsg.ThreadPool", "|MMThreadPool thread pool is auto wakeup");
                            e eVar = this.xki;
                            synchronized (eVar.lock) {
                                eVar.fvI = false;
                                e.xke = 0;
                                e.xkd = 0;
                            }
                        }
                        sendEmptyMessageDelayed(1, 1000);
                        return;
                    }
                    e.a(this.xki);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void a(e eVar) {
        synchronized (eVar.lock) {
            if (!eVar.xjW.isEmpty()) {
                Iterator it = eVar.xjW.iterator();
                if (it != null && it.hasNext()) {
                    g gVar = (g) it.next();
                    it.remove();
                    eVar.cgT();
                    eVar.xjT.execute(gVar);
                    it = new ArrayList(eVar.xjZ).iterator();
                    while (it.hasNext()) {
                        it.next();
                        Runnable runnable = gVar.xfV;
                        eVar.xjT.getActiveCount();
                    }
                }
            }
            if (!eVar.xjW.isEmpty()) {
                eVar.xka.sendEmptyMessage(1);
            }
        }
    }

    public static e cgR() {
        if (xkb == null) {
            synchronized (e.class) {
                if (xkb == null) {
                    xkb = new e();
                }
            }
        }
        return xkb;
    }

    private e() {
        HandlerThread Wf = Wf("THREAD_POOL_HANDLER");
        Wf.start();
        this.xka = new c(this, Wf.getLooper());
    }

    private static int cgS() {
        int availableProcessors = (Runtime.getRuntime().availableProcessors() * 4) + 2;
        if (availableProcessors > 32) {
            return 32;
        }
        return availableProcessors;
    }

    public final void beforeExecute(Thread thread, Runnable runnable) {
        int i = 10;
        synchronized (this.lock) {
            Iterator it = this.xjX.iterator();
            if (it != null) {
                Object obj;
                g gVar = (g) runnable;
                int i2 = gVar.priority;
                if (i2 <= 0) {
                    i = 1;
                } else if (i2 <= 10) {
                    i = i2;
                }
                thread.setPriority(i);
                thread.setName(gVar.mWn);
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    this.xjY.put(gVar, thread);
                    ArrayList arrayList = new ArrayList(this.xjZ);
                    if (!this.fni) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                    }
                    this.fni = true;
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        it3.next();
                        Runnable runnable2 = gVar.xfV;
                    }
                }
            }
        }
    }

    public final void P(Runnable runnable) {
        synchronized (this.lock) {
            g gVar = (g) runnable;
            Iterator it = this.xjY.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    if (gVar2 != null && gVar2.equals(gVar)) {
                        it.remove();
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Iterator it2 = new ArrayList(this.xjZ).iterator();
                    while (it2.hasNext()) {
                        ((c) it2.next()).z(gVar.xfV);
                    }
                }
            }
            int activeCount = this.xjT.getActiveCount();
            int size = this.xjT.getQueue().size();
            int corePoolSize = this.xjT.getCorePoolSize();
            if (activeCount == 1 && size == 0) {
                if (corePoolSize > 0) {
                    this.xjU = cgS();
                    this.xjT.setCorePoolSize(0);
                    this.xjT.setMaximumPoolSize(this.xjU + 2);
                }
                Iterator it3 = new ArrayList(this.xjZ).iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                this.fni = false;
            }
        }
    }

    public static void a(c cVar) {
        cgR().b(cVar);
    }

    private void b(c cVar) {
        synchronized (this.lock) {
            if (!this.xjZ.contains(cVar)) {
                this.xjZ.add(cVar);
            }
        }
    }

    public static void c(c cVar) {
        e cgR = cgR();
        synchronized (cgR.lock) {
            cgR.xjZ.remove(cVar);
        }
    }

    public static void post(Runnable runnable, String str) {
        cgR().c(runnable, str, 5);
    }

    public static void b(Runnable runnable, String str, int i) {
        cgR().c(runnable, str, i);
    }

    private void c(Runnable runnable, String str, int i) {
        synchronized (this.lock) {
            g gVar = new g(runnable, str, i, true, xkh);
            this.xjW.add(gVar);
            this.xjX.add(gVar);
            this.xka.sendEmptyMessage(1);
            lF(false);
        }
    }

    public static void a(Runnable runnable, String str) {
        e cgR = cgR();
        synchronized (cgR.lock) {
            Object gVar = new g(runnable, str, Integer.MAX_VALUE, true, xkh);
            cgR.xjX.add(gVar);
            cgR.xjT.execute(gVar);
            if (cgR.xjT.getActiveCount() < cgR.xjU || cgR.xjU >= cgS() * 2) {
                cgR.cgT();
            } else {
                cgR.xjU++;
                cgR.xjT.setCorePoolSize(cgR.xjU);
                cgR.xjT.setMaximumPoolSize(cgR.xjU);
                x.i("MicroMsg.ThreadPool", "|MMThreadPool postAtFront expand core pool size=" + cgR.xjU);
            }
            Iterator it = new ArrayList(cgR.xjZ).iterator();
            while (it.hasNext()) {
                it.next();
                Runnable runnable2 = gVar.xfV;
            }
            cgR.lF(false);
        }
    }

    public static void Q(Runnable runnable) {
        e cgR = cgR();
        synchronized (cgR.lock) {
            Thread R = cgR.R(runnable);
            if (R != null) {
                R.interrupt();
            } else {
                cgR.X(runnable);
            }
        }
    }

    private Thread R(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        synchronized (this.lock) {
            Iterator it = this.xjY.keySet().iterator();
            if (it != null) {
                Object obj;
                while (it.hasNext()) {
                    obj = (g) it.next();
                    if (obj != null && obj.xfV.equals(runnable)) {
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    Thread thread = (Thread) this.xjY.get(obj);
                    return thread;
                }
            }
            return null;
        }
    }

    public static void S(Runnable runnable) {
        cgR().T(runnable);
    }

    private void T(Runnable runnable) {
        Assert.assertNotNull("join arg runnable is null!", runnable);
        Object obj = null;
        synchronized (this.lock) {
            if (W(runnable)) {
                obj = new a(this, runnable);
                b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (this.xjZ.contains(obj)) {
                    runnable.wait();
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static void U(Runnable runnable) {
        int i = 1;
        e cgR = cgR();
        Assert.assertNotNull("join arg runnable is null!", runnable);
        if (5000 < 0) {
            throw new IllegalArgumentException();
        }
        int i2;
        if (5000 >= 9223372036854L) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (5000 != 0) {
            i = 0;
        }
        if ((i | i2) != 0) {
            cgR.T(runnable);
            return;
        }
        Object obj = null;
        synchronized (cgR.lock) {
            if (cgR.W(runnable)) {
                obj = new a(cgR, runnable);
                cgR().b(obj);
            }
        }
        if (obj != null) {
            synchronized (runnable) {
                if (cgR.xjZ.contains(obj)) {
                    runnable.wait(5000, 0);
                } else {
                    x.d("MicroMsg.ThreadPool", "|MMThreadPool joinTask runnable is not in observerList, just removed!");
                }
            }
        }
    }

    public static boolean V(Runnable runnable) {
        return cgR().W(runnable);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean W(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            g gVar;
            Iterator it = this.xjX.iterator();
            if (it != null) {
                while (it.hasNext()) {
                    gVar = (g) it.next();
                    if (gVar != null && gVar.xfV.equals(runnable)) {
                        return true;
                    }
                }
            }
            it = this.xjY.keySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    gVar = (g) it.next();
                    if (gVar != null && gVar.xfV.equals(runnable)) {
                        return true;
                    }
                }
            }
        }
    }

    public static boolean remove(Runnable runnable) {
        return cgR().X(runnable);
    }

    private boolean X(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        synchronized (this.lock) {
            Iterator it = this.xjX.iterator();
            if (it != null) {
                Runnable runnable2;
                while (it.hasNext()) {
                    runnable2 = (g) it.next();
                    if (runnable2 != null && runnable2.xfV.equals(runnable)) {
                        it.remove();
                        break;
                    }
                }
                runnable2 = null;
                if (runnable2 != null) {
                    this.xjT.remove(runnable2);
                    return true;
                }
            }
            return false;
        }
    }

    private void cgT() {
        if (this.xjT.getCorePoolSize() < this.xjU) {
            this.xjT.setCorePoolSize(this.xjU);
            this.xjT.setMaximumPoolSize(this.xjU);
        }
    }

    public static void cgU() {
        cgR().lF(true);
    }

    private void lF(boolean z) {
        if (z) {
            synchronized (this.lock) {
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
                Iterator it = this.xjW.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool adding task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.xjX.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool waiting task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                it = this.xjY.keySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        x.i("MicroMsg.ThreadPool", "|MMThreadPool running task{" + ((g) it.next()) + "}");
                    }
                }
                x.i("MicroMsg.ThreadPool", "-----------");
                x.i("MicroMsg.ThreadPool", "|MMThreadPool poolSize=" + this.xjT.getPoolSize() + "|activeCount=" + this.xjT.getActiveCount() + "|corePoolSize=" + this.xjT.getPoolSize() + "|largestPoolSize=" + this.xjT.getLargestPoolSize() + "|maximuPoolSize=" + this.xjT.getMaximumPoolSize());
                x.i("MicroMsg.ThreadPool", "------------------------------------------");
            }
        }
    }

    private static b cgV() {
        if (xkf == null) {
            xkf = new b(xkh);
        }
        return xkf;
    }

    public static Thread b(Runnable runnable, String str) {
        return cgV().a(runnable, str, 5);
    }

    public static Thread d(Runnable runnable, String str, int i) {
        return cgV().a(runnable, str, i);
    }

    private static a cgW() {
        if (xkg == null) {
            xkg = new a(xkh);
        }
        return xkg;
    }

    public static HandlerThread Wf(String str) {
        cgW();
        return a.cY(str, 0);
    }

    public static HandlerThread cZ(String str, int i) {
        cgW();
        return a.cY(str, i);
    }
}
