package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bvh;
import com.tencent.mm.protocal.c.bvn;
import com.tencent.mm.protocal.c.bvu;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.protocal.d;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class g {
    j iPT;
    final bvh iPU;
    private String iPV;
    private int iPW = 0;
    private int iPX = 0;
    bvy iPY;
    h iPZ;
    AtomicInteger iQa = new AtomicInteger(0);
    long iQb = 0;
    long iQc = 0;
    long iQd;
    long iQe = System.currentTimeMillis();
    AtomicInteger iQf = new AtomicInteger(0);
    private boolean iQg;
    private boolean iQh;
    final HashMap<String, Method> iQi = new HashMap();
    final HashMap<String, bvu> iQj = new HashMap();
    LinkedList<Pair<String, ValueCallback<String>>> iQk = new LinkedList();
    final LinkedList<j> iQl = new LinkedList();
    final Map<String, f> iQm = new HashMap();
    final LinkedList<bvn> iQn = new LinkedList();
    final HashMap<Integer, a> iQo = new HashMap();
    int iQp = 0;
    long iQq = 0;
    final Object mLock = new Object();
    private int mStatus = 0;

    public g(j jVar) {
        this.iPT = jVar;
        this.iPU = new bvh();
        this.iPU.vPS = d.vAz;
    }

    public final synchronized String aci() {
        return this.iPV;
    }

    public final synchronized void rd(String str) {
        this.iPV = str;
    }

    public final synchronized int acj() {
        return this.iPW;
    }

    public final synchronized void jR(int i) {
        this.iPW = i;
    }

    public final synchronized int ack() {
        return this.iPX;
    }

    public final synchronized void jS(int i) {
        if (this.iPX < i) {
            this.iPX = i;
        }
    }

    public final synchronized void bA(int i, int i2) {
        if (this.iPX >= i && this.iPX <= i2) {
            this.iPX = i2;
        }
    }

    public final synchronized void eQ(int i) {
        this.mStatus = i;
    }

    public final synchronized int getStatus() {
        return this.mStatus;
    }

    public final synchronized boolean isBusy() {
        return this.iQg;
    }

    public final synchronized void cu(boolean z) {
        this.iQg = z;
    }

    public final synchronized boolean is() {
        return getStatus() == 3;
    }

    public final synchronized boolean acl() {
        return this.iQh;
    }

    public final synchronized void cv(boolean z) {
        this.iQh = z;
    }

    public final boolean acm() {
        return getStatus() == 4;
    }

    public final boolean acn() {
        return this.iPZ.iQv == 3;
    }
}
