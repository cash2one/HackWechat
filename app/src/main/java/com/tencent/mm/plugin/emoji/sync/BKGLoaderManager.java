package com.tencent.mm.plugin.emoji.sync;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements e {
    int hzu;
    public int lzB = 0;
    private int lzC = 0;
    public boolean lzD = false;
    boolean lzE = false;
    boolean lzF = false;
    public boolean lzG = false;
    public boolean lzH = false;
    private boolean lzI = false;
    boolean lzJ = false;
    boolean lzK = false;
    d lzL = null;
    private b lzM;
    public Vector<d> lzN = new Vector();
    public Vector<d> lzO = new Vector();
    public Vector<d> lzP = new Vector();
    public Set<c> lzQ = new HashSet();
    public ConnectivityReceiver lzR;
    long lzS = 0;
    long lzT = 0;
    ak lzU = new ak(Looper.getMainLooper(), new 1(this), false);
    public c lzV = new 2(this);
    public c lzW = new 3(this);
    int mNetWorkType = -1;

    public BKGLoaderManager(b bVar) {
        this.lzM = bVar;
        this.hzu = Process.myUid();
        this.mNetWorkType = an.getNetType(ac.getContext());
    }

    public final void aB(List<d> list) {
        if (this.lzO == null) {
            this.lzO = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) list.get(i);
                if (dVar == null || this.lzO.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", dVar.getKey());
                } else {
                    this.lzO.add(dVar);
                }
            }
        }
    }

    public final synchronized void aBZ() {
        if (an.isWifi(ac.getContext()) || this.lzD) {
            if (this.lzN != null && this.lzN.size() > 0) {
                this.lzJ = f.zf();
                this.lzE = true;
                this.lzF = false;
                this.lzH = false;
                this.lzG = false;
                if (this.lzJ) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.lzL = (d) this.lzN.remove(0);
                    this.lzL.a(this);
                    this.lzM.lzz.execute(this.lzL);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", this.lzL.getKey(), Integer.valueOf(this.lzN.size()));
                }
                aCb();
            } else if (this.lzO == null || this.lzO.size() <= 0) {
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                if (this.lzN == null || this.lzN.size() <= 0) {
                    if (this.lzE && this.lzK) {
                        this.lzH = true;
                    }
                    this.lzE = false;
                }
                if (this.lzO == null || this.lzO.size() <= 0) {
                    if (this.lzF && this.lzK) {
                        this.lzI = true;
                    }
                    this.lzF = false;
                }
                if ((this.lzN == null || this.lzN.size() <= 0) && ((this.lzO == null || this.lzO.size() <= 0) && ((this.lzE || this.lzF) && this.lzK))) {
                    this.lzF = false;
                    this.lzE = false;
                }
                this.lzD = false;
                aCb();
            } else {
                this.lzF = true;
                this.lzE = false;
                this.lzI = false;
                this.lzG = false;
                this.lzL = (d) this.lzO.remove(0);
                this.lzL.a(this);
                this.lzM.lzz.execute(this.lzL);
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", this.lzL.getKey(), Integer.valueOf(this.lzO.size()));
                aCb();
            }
            if (!(this.lzF || this.lzE)) {
                if (this.lzP == null || this.lzP.size() <= 0) {
                    this.lzG = false;
                } else {
                    this.lzG = true;
                    this.lzL = (d) this.lzP.remove(0);
                    this.lzL.a(this);
                    this.lzM.lzz.execute(this.lzL);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", this.lzL.getKey(), Integer.valueOf(this.lzP.size()));
                }
            }
        } else if (aAP()) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.lzE = false;
            this.lzF = false;
            this.lzH = false;
            this.lzG = false;
            aCb();
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
        }
    }

    public final void aCa() {
        this.lzE = false;
        this.lzF = false;
        this.lzD = false;
        aCb();
        if (this.lzL != null) {
            this.lzL.cancel();
        }
    }

    public final void aCb() {
        if (this.lzQ != null && this.lzQ.size() > 0) {
            for (c aCd : this.lzQ) {
                aCd.aCd();
            }
        }
    }

    public final void yC(String str) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", str);
    }

    public final void k(String str, int i, boolean z) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", str, Boolean.valueOf(z));
        if (this.lzL == null || bh.ov(str)) {
            x.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            return;
        }
        if (this.lzN.contains(this.lzL)) {
            this.lzN.remove(this.lzL);
        } else if (this.lzO.contains(this.lzL)) {
            this.lzO.remove(this.lzL);
        } else if (this.lzP.contains(this.lzL)) {
            this.lzP.remove(this.lzL);
        }
        if (!z) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        } else if (!(i == 2 || this.lzQ == null || this.lzQ.size() <= 0)) {
            for (c aCe : this.lzQ) {
                aCe.aCe();
            }
        }
        if (i == 2) {
            this.lzU.J(5000, 5000);
        } else {
            this.lzU.J(1000, 1000);
        }
    }

    public static boolean aCc() {
        NetworkInfo networkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean aAP() {
        return an.is3G(ac.getContext()) || an.is4G(ac.getContext()) || an.is2G(ac.getContext());
    }
}
