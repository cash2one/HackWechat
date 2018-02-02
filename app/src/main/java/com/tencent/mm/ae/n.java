package com.tencent.mm.ae;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class n implements e {
    private static n hmU = null;
    private static int hnf = 1;
    public boolean foreground = false;
    private final af handler = new af(this, Looper.getMainLooper()) {
        final /* synthetic */ n hng;

        public final void handleMessage(Message message) {
            this.hng.a((k) message.obj, 0);
        }
    };
    public e hmV;
    public ag hmW = null;
    private Vector<k> hmX = new Vector();
    private Vector<k> hmY = new Vector();
    private final Map<Integer, Set<e>> hmZ = new HashMap();
    private Boolean hna = null;
    private final a hnb;
    private long hnc = 21600000;
    private boolean hnd = false;
    private ak hne = new ak(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ n hng;

        {
            this.hng = r1;
        }

        public final boolean uF() {
            boolean z = false;
            if (this.hng.hnb == null) {
                return false;
            }
            x.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(this.hng.hmX.size()), Integer.valueOf(this.hng.hmY.size()), Boolean.valueOf(this.hng.foreground));
            a b = this.hng.hnb;
            n nVar = this.hng;
            if (this.hng.hnd && this.hng.hmX.isEmpty() && this.hng.hmY.isEmpty()) {
                z = true;
            }
            b.a(nVar, z);
            return true;
        }
    }, true);
    private final Object lock = new Object();

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ n hng;
        final /* synthetic */ int hnh;

        public AnonymousClass4(n nVar, int i) {
            this.hng = nVar;
            this.hnh = i;
        }

        public final void run() {
            n.b(this.hng, this.hnh);
        }

        public final String toString() {
            return super.toString() + "|cancelImp_" + this.hnh;
        }
    }

    public interface a {
        void a(n nVar);

        void a(n nVar, boolean z);
    }

    static /* synthetic */ void a(n nVar, int i) {
        synchronized (nVar.lock) {
            Iterator it = nVar.hmX.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
            it = nVar.hmY.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
        }
    }

    static /* synthetic */ void b(n nVar, int i) {
        synchronized (nVar.lock) {
            Iterator it = nVar.hmX.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
            it = nVar.hmY.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
        }
    }

    public final void bC(boolean z) {
        this.hnd = z;
        if (this.hnd) {
            x.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            ak akVar = this.hne;
            long j = this.hnc;
            akVar.J(j, j);
            return;
        }
        this.hne.TG();
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.hmV == null) {
            x.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            this.hmV.a(i, str, i2, z);
        }
    }

    public final void bD(boolean z) {
        this.foreground = z;
        this.hna = Boolean.valueOf(z);
        b.bD(z);
        HardCoderJNI.foreground = z;
        if (this.hmV == null) {
            x.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
        } else {
            this.hmV.bE(z);
        }
    }

    public final int Km() {
        try {
            if (this.hmV != null && this.hmV.Ky() != null) {
                return this.hmV.Ky().Vr();
            }
            x.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
            if (an.isConnected(ac.getContext())) {
                return 6;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneQueue", "exception:%s", bh.i(e));
        }
    }

    public final boolean Kn() {
        if (this.hmV != null) {
            return this.hmV.Kn();
        }
        return true;
    }

    public final String getNetworkServerIp() {
        if (this.hmV != null) {
            return this.hmV.getNetworkServerIp();
        }
        return "unknown";
    }

    private n(a aVar) {
        this.hnb = aVar;
    }

    public final void d(e eVar) {
        this.hmV = eVar;
        eVar.bE(this.foreground);
        Kq();
    }

    public static n a(a aVar) {
        if (hmU == null) {
            hmU = new n(aVar);
        }
        return hmU;
    }

    public final void a(int i, e eVar) {
        synchronized (this.hmZ) {
            if (!this.hmZ.containsKey(Integer.valueOf(i))) {
                this.hmZ.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) this.hmZ.get(Integer.valueOf(i))).contains(eVar) && ((Set) this.hmZ.get(Integer.valueOf(i))).add(eVar)) {
                ListenerInstanceMonitor.bU(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        synchronized (this.hmZ) {
            try {
                if (this.hmZ.get(Integer.valueOf(i)) != null && ((Set) this.hmZ.get(Integer.valueOf(i))).remove(eVar)) {
                    ListenerInstanceMonitor.bV(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void reset() {
        if (this.hmV != null) {
            this.hmV.reset();
        }
        Ko();
        List<k> list = this.hmY;
        this.hmY = new Vector();
        for (k kVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearWaitingQueue", kVar);
        }
        list.clear();
    }

    public final void Ko() {
        List<k> list = this.hmX;
        this.hmX = new Vector();
        for (k kVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearRunningQueue", kVar);
        }
        list.clear();
    }

    public final void Kp() {
        x.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.hmV != null) {
            this.hmV.reset();
            this.hmV = null;
        }
    }

    public final e CK() {
        return this.hmV;
    }

    public final void cancel(final int i) {
        x.k("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.hmW.F(new Runnable(this) {
            final /* synthetic */ n hng;

            public final void run() {
                n.a(this.hng, i);
            }

            public final String toString() {
                return super.toString() + "|cancelImp_" + i;
            }
        });
    }

    public final void c(k kVar) {
        if (kVar != null) {
            x.k("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
            kVar.cancel();
            synchronized (this.lock) {
                this.hmY.remove(kVar);
                this.hmX.remove(kVar);
            }
        }
    }

    public final boolean d(k kVar) {
        return a(kVar, 0);
    }

    public final boolean a(k kVar, int i) {
        boolean z = kVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.hmW != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (!e(kVar)) {
            return false;
        }
        b(kVar, i);
        return true;
    }

    private void b(final k kVar, int i) {
        boolean Kr = Kr();
        int size = this.hmX.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.Kh());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.hmY.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(Kr);
        objArr[7] = Integer.valueOf(this.hmV == null ? 0 : this.hmV.hashCode());
        x.i(str, str2, objArr);
        if (i == 0 && Kr && this.hmV != null) {
            synchronized (this.lock) {
                this.hmX.add(kVar);
                if (size == this.hmX.size()) {
                    x.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(kVar.getType()), Integer.valueOf(kVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.hmX.size()), Integer.valueOf(this.hmY.size()));
                }
            }
            this.hmW.F(new Runnable(this) {
                final /* synthetic */ n hng;

                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    kVar.hmE = this.hng;
                    if (kVar.aBT || this.hng.hmV == null) {
                        i = 0;
                    } else {
                        i = kVar.a(this.hng.hmV, this.hng);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(kVar.getType());
                            objArr[1] = Integer.valueOf(kVar.hashCode());
                            objArr[2] = Integer.valueOf(kVar.Kh());
                            objArr[3] = Integer.valueOf(this.hng.hmX.size());
                            objArr[4] = Integer.valueOf(this.hng.hmY.size());
                            objArr[5] = Integer.valueOf(i);
                            if (this.hng.hmV == null) {
                                i = 0;
                            } else {
                                i = this.hng.hmV.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            x.i(str, str2, objArr);
                            kVar.hmF = false;
                            return;
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(kVar.getType());
                    objArr[1] = Integer.valueOf(kVar.hashCode());
                    objArr[2] = Integer.valueOf(kVar.Kh());
                    objArr[3] = Boolean.valueOf(kVar.aBT);
                    objArr[4] = Integer.valueOf(this.hng.hmX.size());
                    objArr[5] = Integer.valueOf(this.hng.hmY.size());
                    objArr[6] = Integer.valueOf(i);
                    if (this.hng.hmV != null) {
                        i2 = this.hng.hmV.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    x.w(str, str2, objArr);
                    kVar.hmE = null;
                    synchronized (this.hng.lock) {
                        this.hng.hmX.remove(kVar);
                    }
                    if (!kVar.aBT) {
                        this.hng.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 hni;

                            {
                                this.hni = r1;
                            }

                            public final void run() {
                                this.hni.hng.a(3, -1, "doScene failed", kVar);
                            }
                        });
                    }
                }

                public final String toString() {
                    return super.toString() + "|doSceneImp_" + kVar + "_type=" + kVar.getType();
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = kVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            x.i("MicroMsg.NetSceneQueue", "timed: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_after_sec=" + i);
        } else {
            x.i("MicroMsg.NetSceneQueue", "waited: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hmY.size());
            synchronized (this.lock) {
                this.hmY.add(kVar);
            }
            x.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.hmY.size());
        }
        if (this.hmV != null) {
            hnf = 1;
        } else if (this.hnb == null) {
            x.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.hnb);
        } else {
            this.hnb.a(this);
            ak akVar = new ak(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
                final /* synthetic */ n hng;
                private long hnk = 10;

                {
                    this.hng = r3;
                }

                public final boolean uF() {
                    if (this.hng.hmV == null) {
                        long j = this.hnk;
                        this.hnk = j - 1;
                        if (j > 0) {
                            return true;
                        }
                    }
                    this.hng.Kq();
                    return false;
                }
            }, true);
            long j = (long) (hnf * 100);
            akVar.J(j, j);
            if (hnf < WXMediaMessage.TITLE_LENGTH_LIMIT) {
                hnf *= 2;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        kVar.hmF = true;
        synchronized (this.lock) {
            this.hmX.remove(kVar);
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.Kh());
        objArr[3] = Integer.valueOf(this.hmX.size());
        objArr[4] = Integer.valueOf(this.hmY.size());
        if (this.hmV != null) {
            i3 = this.hmV.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        x.i(str2, str3, objArr);
        Kq();
        c(i, i2, str, kVar);
        if (this.hnd && this.hmX.isEmpty() && this.hmY.isEmpty()) {
            ak akVar = this.hne;
            long j = this.hnc;
            akVar.J(j, j);
        }
    }

    private void c(int i, int i2, String str, k kVar) {
        final k kVar2 = kVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ n hng;

            public final void run() {
                Set set = (Set) this.hng.hmZ.get(Integer.valueOf(kVar2.getType()));
                if (set != null && set.size() > 0) {
                    Set<e> hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i3, i4, str2, kVar2);
                        }
                    }
                }
                set = (Set) this.hng.hmZ.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar2 : hashSet) {
                        if (eVar2 != null && set.contains(eVar2)) {
                            eVar2.a(i3, i4, str2, kVar2);
                        }
                    }
                }
            }
        });
    }

    private void Kq() {
        synchronized (this.lock) {
            if (this.hmY.size() > 0) {
                k kVar = (k) this.hmY.get(0);
                int i = 1;
                int i2 = kVar.priority;
                k kVar2 = kVar;
                while (i < this.hmY.size()) {
                    k kVar3;
                    int i3;
                    if (((k) this.hmY.get(i)).priority > i2) {
                        this.hmY.get(i);
                        if (Kr()) {
                            kVar = (k) this.hmY.get(i);
                            kVar3 = kVar;
                            i3 = kVar.priority;
                            i++;
                            kVar2 = kVar3;
                            i2 = i3;
                        }
                    }
                    i3 = i2;
                    kVar3 = kVar2;
                    i++;
                    kVar2 = kVar3;
                    i2 = i3;
                }
                this.hmY.remove(kVar2);
                x.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.hmY.size());
                b(kVar2, 0);
            }
        }
    }

    private boolean Kr() {
        if (this.hmX.size() >= 50) {
            return false;
        }
        return true;
    }

    private boolean e(k kVar) {
        int type = kVar.getType();
        if (kVar.Kd()) {
            synchronized (this.lock) {
                k kVar2;
                Iterator it = this.hmX.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.hmX.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.hmX.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + "acinfo[" + kVar2.getInfo() + "] scinfo[" + kVar.getInfo() + "]");
                                x.cfk();
                                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                it = this.hmY.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hmY.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hmY.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                x.cfk();
                                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
