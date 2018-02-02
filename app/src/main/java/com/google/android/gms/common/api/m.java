package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class m implements p {
    final o aKH;
    final Lock aKJ;
    private ConnectionResult aKK;
    private int aKL;
    private int aKM = 0;
    private boolean aKN = false;
    private int aKO;
    private final Bundle aKP = new Bundle();
    private final Set<c> aKQ = new HashSet();
    d aKR;
    private int aKS;
    boolean aKT;
    boolean aKU;
    p aKV;
    boolean aKW;
    boolean aKX;
    private final com.google.android.gms.common.internal.h aKY;
    private final Map<a<?>, Integer> aKZ;
    private final b aKg;
    private final a<? extends d, e> aKh;
    private ArrayList<Future<?>> aLa = new ArrayList();
    final Context mContext;

    private abstract class i implements Runnable {
        final /* synthetic */ m aLb;

        private i(m mVar) {
            this.aLb = mVar;
        }

        protected abstract void oj();

        public void run() {
            this.aLb.aKJ.lock();
            try {
                if (!Thread.interrupted()) {
                    oj();
                    this.aLb.aKJ.unlock();
                }
            } catch (RuntimeException e) {
                o oVar = this.aLb.aKH;
                oVar.aLv.sendMessage(oVar.aLv.obtainMessage(4, e));
            } finally {
                this.aLb.aKJ.unlock();
            }
        }
    }

    private class h extends i {
        final /* synthetic */ m aLb;
        private final ArrayList<a.b> aLo;

        public h(m mVar, ArrayList<a.b> arrayList) {
            this.aLb = mVar;
            super();
            this.aLo = arrayList;
        }

        public final void oj() {
            Iterator it = this.aLo.iterator();
            while (it.hasNext()) {
                ((a.b) it.next()).a(this.aLb.aKV);
            }
        }
    }

    public m(o oVar, com.google.android.gms.common.internal.h hVar, Map<a<?>, Integer> map, b bVar, a<? extends d, e> aVar, Lock lock, Context context) {
        this.aKH = oVar;
        this.aKY = hVar;
        this.aKZ = map;
        this.aKg = bVar;
        this.aKh = aVar;
        this.aKJ = lock;
        this.mContext = context;
    }

    private void aq(boolean z) {
        if (this.aKR != null) {
            if (this.aKR.isConnected() && z) {
                this.aKR.qu();
            }
            this.aKR.disconnect();
            this.aKV = null;
        }
    }

    private static String dj(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void oo() {
        boolean z = true;
        o oVar = this.aKH;
        oVar.aKJ.lock();
        try {
            oVar.ot();
            oVar.aLA = new l(oVar);
            oVar.aLA.begin();
            oVar.aLp.signalAll();
            q.ou().execute(new 1(this));
            if (this.aKR != null) {
                if (this.aKW) {
                    this.aKR.a(this.aKV, this.aKX);
                }
                aq(false);
            }
            for (c cVar : this.aKH.aLy.keySet()) {
                ((a.b) this.aKH.aLx.get(cVar)).disconnect();
            }
            if (this.aKN) {
                this.aKN = false;
                disconnect();
                return;
            }
            Bundle bundle = this.aKP.isEmpty() ? null : this.aKP;
            l lVar = this.aKH.aLq;
            w.d(Looper.myLooper() == lVar.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
            synchronized (lVar.aNX) {
                w.ar(!lVar.aOv);
                lVar.mHandler.removeMessages(1);
                lVar.aOv = true;
                if (lVar.aOr.size() != 0) {
                    z = false;
                }
                w.ar(z);
                ArrayList arrayList = new ArrayList(lVar.aOq);
                int i = lVar.aOu.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.b bVar = (c.b) it.next();
                    if (lVar.aOt && lVar.aOp.isConnected() && lVar.aOu.get() == i) {
                        if (!lVar.aOr.contains(bVar)) {
                            bVar.e(bundle);
                        }
                    }
                }
                lVar.aOr.clear();
                lVar.aOv = false;
            }
        } finally {
            oVar.aKJ.unlock();
        }
    }

    private void oq() {
        Iterator it = this.aLa.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.aLa.clear();
    }

    public final <A extends a.b, R extends g, T extends k$a<R, A>> T a(T t) {
        this.aKH.aLr.add(t);
        return t;
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
        if (di(3)) {
            b(connectionResult, aVar, i);
            if (ok()) {
                oo();
            }
        }
    }

    public final <A extends a.b, T extends k$a<? extends g, A>> T b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void b(ConnectionResult connectionResult, a<?> aVar, int i) {
        Object obj = 1;
        if (i != 2) {
            aVar.nS();
            if (i == 1) {
                Object obj2;
                if (connectionResult.nQ()) {
                    obj2 = 1;
                } else if (b.dd(connectionResult.aJD) != null) {
                    int i2 = 1;
                } else {
                    obj2 = null;
                }
            }
            if (this.aKK != null) {
            }
            if (obj != null) {
                this.aKK = connectionResult;
                this.aKL = Integer.MAX_VALUE;
            }
        }
        this.aKH.aLy.put(aVar.nT(), connectionResult);
    }

    public final void begin() {
        this.aKH.aLq.aOt = true;
        this.aKH.aLy.clear();
        this.aKN = false;
        this.aKT = false;
        this.aKK = null;
        this.aKM = 0;
        this.aKS = 2;
        this.aKU = false;
        this.aKW = false;
        Map hashMap = new HashMap();
        for (a aVar : this.aKZ.keySet()) {
            a.b bVar = (a.b) this.aKH.aLx.get(aVar.nT());
            int intValue = ((Integer) this.aKZ.get(aVar)).intValue();
            aVar.nS();
            if (bVar.nV()) {
                this.aKT = true;
                if (intValue < this.aKS) {
                    this.aKS = intValue;
                }
                if (intValue != 0) {
                    this.aKQ.add(aVar.nT());
                }
            }
            hashMap.put(bVar, new d(this, aVar, intValue));
        }
        if (this.aKT) {
            this.aKY.aNS = Integer.valueOf(System.identityHashCode(this.aKH));
            c.b gVar = new g(this, (byte) 0);
            this.aKR = (d) this.aKh.a(this.mContext, this.aKH.aKf, this.aKY, this.aKY.aNR, gVar, gVar);
        }
        this.aKO = this.aKH.aLx.size();
        this.aLa.add(q.ou().submit(new e(this, hashMap)));
    }

    public final void connect() {
        this.aKN = false;
    }

    final boolean d(ConnectionResult connectionResult) {
        return this.aKS != 2 ? this.aKS == 1 && !connectionResult.nQ() : true;
    }

    public final void dh(int i) {
        e(new ConnectionResult(8, null));
    }

    final boolean di(int i) {
        if (this.aKM == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + dj(this.aKM) + " but received callback for step " + dj(i));
        e(new ConnectionResult(8, null));
        return false;
    }

    public final void disconnect() {
        Iterator it = this.aKH.aLr.iterator();
        while (it.hasNext()) {
            ((o.e) it.next()).cancel();
            it.remove();
        }
        this.aKH.os();
        if (this.aKK != null || this.aKH.aLr.isEmpty()) {
            oq();
            aq(true);
            this.aKH.aLy.clear();
            this.aKH.f(null);
            this.aKH.aLq.oO();
            return;
        }
        this.aKN = true;
    }

    public final void e(Bundle bundle) {
        if (di(3)) {
            if (bundle != null) {
                this.aKP.putAll(bundle);
            }
            if (ok()) {
                oo();
            }
        }
    }

    final void e(ConnectionResult connectionResult) {
        boolean z = false;
        this.aKN = false;
        oq();
        aq(!connectionResult.nQ());
        this.aKH.aLy.clear();
        this.aKH.f(connectionResult);
        if (!this.aKH.aLs || !b.l(this.mContext, connectionResult.aJD)) {
            this.aKH.ot();
            l lVar = this.aKH.aLq;
            if (Looper.myLooper() == lVar.mHandler.getLooper()) {
                z = true;
            }
            w.d(z, "onConnectionFailure must only be called on the Handler thread");
            lVar.mHandler.removeMessages(1);
            synchronized (lVar.aNX) {
                ArrayList arrayList = new ArrayList(lVar.aOs);
                int i = lVar.aOu.get();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c.c cVar = (c.c) it.next();
                    if (!lVar.aOt || lVar.aOu.get() != i) {
                        break;
                    } else if (lVar.aOs.contains(cVar)) {
                        cVar.a(connectionResult);
                    }
                }
            }
        }
        this.aKH.aLq.oO();
    }

    public final String getName() {
        return TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING;
    }

    final boolean ok() {
        this.aKO--;
        if (this.aKO > 0) {
            return false;
        }
        if (this.aKO < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            e(new ConnectionResult(8, null));
            return false;
        } else if (this.aKK == null) {
            return true;
        } else {
            e(this.aKK);
            return false;
        }
    }

    final void ol() {
        if (this.aKO == 0) {
            if (!this.aKT) {
                on();
            } else if (this.aKU) {
                ArrayList arrayList = new ArrayList();
                this.aKM = 1;
                this.aKO = this.aKH.aLx.size();
                for (c cVar : this.aKH.aLx.keySet()) {
                    if (!this.aKH.aLy.containsKey(cVar)) {
                        arrayList.add(this.aKH.aLx.get(cVar));
                    } else if (ok()) {
                        om();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.aLa.add(q.ou().submit(new h(this, arrayList)));
                }
            }
        }
    }

    final void om() {
        this.aKM = 2;
        this.aKH.aLz = or();
        this.aLa.add(q.ou().submit(new c(this, (byte) 0)));
    }

    final void on() {
        ArrayList arrayList = new ArrayList();
        this.aKM = 3;
        this.aKO = this.aKH.aLx.size();
        for (c cVar : this.aKH.aLx.keySet()) {
            if (!this.aKH.aLy.containsKey(cVar)) {
                arrayList.add(this.aKH.aLx.get(cVar));
            } else if (ok()) {
                oo();
            }
        }
        if (!arrayList.isEmpty()) {
            this.aLa.add(q.ou().submit(new f(this, arrayList)));
        }
    }

    final void op() {
        this.aKT = false;
        this.aKH.aLz = Collections.emptySet();
        for (c cVar : this.aKQ) {
            if (!this.aKH.aLy.containsKey(cVar)) {
                this.aKH.aLy.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    final Set<Scope> or() {
        Set<Scope> hashSet = new HashSet(this.aKY.aJU);
        Map map = this.aKY.aNQ;
        for (a aVar : map.keySet()) {
            if (!this.aKH.aLy.containsKey(aVar.nT())) {
                hashSet.addAll(((com.google.android.gms.common.internal.h.a) map.get(aVar)).aKo);
            }
        }
        return hashSet;
    }
}
