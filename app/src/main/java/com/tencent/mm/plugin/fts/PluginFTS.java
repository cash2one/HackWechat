package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.bw;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.b.d;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.bv;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class PluginFTS extends f implements b, c, m {
    public static boolean mJC;
    private Runnable mJA = new 1(this);
    private d mJB = new d(this) {
        final /* synthetic */ PluginFTS mJM;

        {
            this.mJM = r1;
        }

        public final void aMQ() {
            g.Dk();
            int intValue = ((Integer) g.Dj().CU().get(a.xvX, Integer.valueOf(3))).intValue();
            x.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue > 0) {
                intValue--;
                g.Dk();
                g.Dj().CU().a(a.xvX, Integer.valueOf(intValue));
                this.mJM.destroyNativeLogic();
                this.mJM.destroyStorage();
                this.mJM.mJu.close();
                c.aMO();
                this.mJM.mJt.a(-131072, new b(this.mJM, (byte) 0));
            }
        }
    };
    private bv.a mJD = new 3(this);
    private com.tencent.mm.sdk.b.c mJE = new com.tencent.mm.sdk.b.c<bw>(this) {
        final /* synthetic */ PluginFTS mJM;

        {
            this.mJM = r2;
            this.xen = bw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((bw) bVar) instanceof bw) {
                this.mJM.mJE.dead();
                this.mJM.mJw = true;
                x.i("MicroMsg.FTS.PluginFTS", "All account post reset");
                this.mJM.waitAndStartDaemon();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mJF = new 5(this);
    private e mJG = new 6(this);
    private com.tencent.mm.sdk.b.c mJH = new 7(this);
    private BroadcastReceiver mJI = new 8(this);
    private ConcurrentHashMap<Integer, h> mJJ = new ConcurrentHashMap();
    private e mJK;
    private SparseArray<j> mJL = new SparseArray();
    private volatile f mJt;
    private volatile c mJu;
    private volatile boolean mJv = false;
    private volatile boolean mJw = false;
    private boolean mJx = false;
    private boolean mJy = false;
    private boolean mJz;

    public boolean isCharging() {
        return this.mJx;
    }

    public boolean isInBackground() {
        return this.mJy;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        File file = new File(com.tencent.mm.plugin.fts.a.c.mKv);
        if (!file.exists()) {
            file.mkdir();
        }
        if (this.mJt != null) {
            this.mJt.quit();
        }
        initFTSTaskDaemon();
        Intent registerReceiver = ac.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            boolean z = intExtra == 2 || intExtra == 5;
            this.mJx = z;
        } else {
            this.mJx = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ac.getContext().registerReceiver(this.mJI, intentFilter);
        g.Dl().a(this.mJD);
        this.mJF.ceO();
        this.mJH.ceO();
        this.mJE.ceO();
        g.CG().a(138, this.mJG);
        this.mJt.a(-131072, new b(this, (byte) 0));
        this.mJt.a(-131071, new a(this, (byte) 0));
    }

    public void onAccountRelease() {
        destroyNativeLogic();
        destroyStorage();
        if (this.mJt != null) {
            this.mJt.quit();
            this.mJt = null;
        }
        if (this.mJu != null) {
            this.mJu.close();
            this.mJu = null;
        }
        ac.getContext().unregisterReceiver(this.mJI);
        this.mJF.dead();
        this.mJE.dead();
        this.mJH.dead();
        g.CG().b(138, this.mJG);
        g.Dl().b(this.mJD);
        this.mJv = false;
        this.mJw = false;
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public void initFTSTaskDaemon() {
        if (this.mJt == null) {
            this.mJt = new f();
            f fVar = this.mJt;
            if (fVar.mJj == null || !fVar.mJj.isAlive()) {
                fVar.mJj = new f.a(fVar);
                x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
            } else {
                x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
            }
            fVar = this.mJt;
            Runnable runnable = this.mJA;
            if (fVar.mJj != null) {
                fVar.mJj.mJp = runnable;
            }
            this.mJt.mJj.mJq = this.mJB;
        }
    }

    public l getFTSTaskDaemon() {
        initFTSTaskDaemon();
        return this.mJt;
    }

    public com.tencent.mm.plugin.fts.a.g getFTSIndexDB() {
        return this.mJu;
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).aJ(g.h(com.tencent.mm.plugin.chatroom.b.b.class));
    }

    private void registerSearchLogic() {
        registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
        registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
        registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
        registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
        registerNativeLogic(8, new d());
        registerNativeLogic(10000, new com.tencent.mm.plugin.fts.b.f());
    }

    private void registerStorage() {
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
    }

    private void createNativeLogic() {
        x.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i = 0; i < this.mJL.size(); i++) {
            j jVar = (j) this.mJL.get(this.mJL.keyAt(i));
            if (jVar != null) {
                try {
                    jVar.create();
                } catch (Throwable e) {
                    x.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{jVar.getName(), bh.i(e)});
                }
            }
        }
    }

    private void destroyNativeLogic() {
        x.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i = 0; i < this.mJL.size(); i++) {
            j jVar = (j) this.mJL.get(this.mJL.keyAt(i));
            if (jVar != null) {
                try {
                    jVar.destroy();
                } catch (Throwable e) {
                    x.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{jVar.getName(), bh.i(e)});
                }
            }
        }
    }

    private void createIndexStorage() {
        x.i("MicroMsg.FTS.PluginFTS", "Create Index Storage");
        LinkedList linkedList = new LinkedList();
        for (h add : this.mJJ.values()) {
            linkedList.add(add);
        }
        Collections.sort(linkedList);
        for (int i = 0; i < linkedList.size(); i++) {
            ((h) linkedList.get(i)).create();
        }
    }

    private void destroyStorage() {
        x.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (h hVar : this.mJJ.values()) {
            if (hVar != null) {
                hVar.destroy();
            }
        }
    }

    private void waitAndStartDaemon() {
        g.Dk();
        this.mJv = bh.e((Integer) g.Dj().CU().get(15, null)) != 0;
        if (this.mJv) {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        } else {
            g.CG().a(138, this.mJG);
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        }
        if (this.mJw) {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        } else {
            x.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.mJv && this.mJw) {
            startDaemon();
        }
    }

    private void startDaemon() {
        if (!this.mJt.agj()) {
            f fVar = this.mJt;
            fVar.mJj.start();
            x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + fVar.mJj.getId());
        }
    }

    public com.tencent.mm.plugin.fts.a.a.a search(int i, com.tencent.mm.plugin.fts.a.a.g gVar) {
        Runnable bVar = new b(gVar);
        if (isFTSContextReady()) {
            bVar.errorCode = -4;
            if (!isFTSIndexReady()) {
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            } else if (this.mJL.indexOfKey(i) >= 0) {
                j jVar = (j) this.mJL.get(i);
                if (jVar.aMU()) {
                    return jVar.a(gVar);
                }
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            } else {
                x.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", new Object[]{Integer.valueOf(this.mJL.size())});
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            }
        }
        com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
        return bVar;
    }

    public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (isFTSContextReady()) {
            f fVar = this.mJt;
            if (fVar.mJj != null) {
                f.a aVar2 = fVar.mJj;
                aVar.iu = true;
                aVar2.mJl.remove(aVar);
                if (aVar2.mJn == aVar) {
                    aVar2.interrupt();
                }
            }
        }
    }

    public void updateTopHitsRank(String str, com.tencent.mm.plugin.fts.a.a.j jVar, int i) {
        if (isFTSContextReady() && this.mJL.indexOfKey(1) >= 0) {
            ((j) this.mJL.get(1)).a(str, jVar, i, com.tencent.mm.plugin.fts.a.d.aMV());
        }
    }

    public void addSOSHistory(String str) {
        if (isFTSContextReady() && this.mJL.indexOfKey(8) >= 0) {
            ((j) this.mJL.get(8)).addSOSHistory(str);
        }
    }

    public void deleteSOSHistory() {
        if (isFTSContextReady() && this.mJL.indexOfKey(8) >= 0) {
            ((j) this.mJL.get(8)).deleteSOSHistory();
        }
    }

    public void deleteSOSHistory(String str) {
        if (isFTSContextReady() && this.mJL.indexOfKey(8) >= 0) {
            ((j) this.mJL.get(8)).deleteSOSHistory(str);
        }
    }

    public void registerIndexStorage(h hVar) {
        this.mJJ.put(Integer.valueOf(hVar.getType()), hVar);
    }

    public void unregisterIndexStorage(int i) {
        if (this.mJJ.containsKey(Integer.valueOf(i))) {
            try {
                ((h) this.mJJ.get(Integer.valueOf(i))).destroy();
            } catch (Throwable e) {
                x.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", new Object[]{r0.getName(), bh.i(e)});
            }
        }
        this.mJJ.remove(Integer.valueOf(i));
    }

    public h getFTSIndexStorage(int i) {
        return (h) this.mJJ.get(Integer.valueOf(i));
    }

    public i getFTSMainDB() {
        if (this.mJK == null) {
            this.mJK = new e();
        }
        return this.mJK;
    }

    public int stringCompareUtfBinary(String str, String str2) {
        return FTSJNIUtils.stringCompareUtfBinary(str, str2);
    }

    public void registerNativeLogic(int i, j jVar) {
        this.mJL.put(i, jVar);
    }

    public void unregisterNativeLogic(int i) {
        if (this.mJL.indexOfKey(i) >= 0) {
            try {
                ((j) this.mJL.get(i)).destroy();
            } catch (Throwable e) {
                x.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", new Object[]{r0.getName(), bh.i(e)});
            }
        }
        this.mJL.remove(i);
    }

    public boolean isFTSContextReady() {
        return getFTSTaskDaemon().agj();
    }

    public boolean isFTSIndexReady() {
        return this.mJz;
    }

    public void setFTSIndexReady(boolean z) {
        this.mJz = z;
    }

    public com.tencent.mm.plugin.fts.b.e getTopHitsLogic() {
        return (com.tencent.mm.plugin.fts.b.e) this.mJL.get(1);
    }
}
