package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.c;
import com.google.android.gms.analytics.d;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ah;
import com.google.android.gms.c.ah.1;
import com.google.android.gms.c.ai;
import com.google.android.gms.c.aj;
import com.google.android.gms.c.ak;
import com.google.android.gms.c.g;
import com.google.android.gms.c.h;
import com.google.android.gms.common.internal.f;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

final class w extends o {
    private final u aGH;
    private final h aGI;
    private final g aGJ;
    private final t aGK;
    private long aGL = Long.MIN_VALUE;
    private final ae aGM;
    private final ae aGN;
    private final j aGO;
    private long aGP;
    private boolean aGQ;
    private boolean oO;

    protected w(q qVar, r rVar) {
        super(qVar);
        com.google.android.gms.common.internal.w.ag(rVar);
        this.aGJ = new g(qVar);
        this.aGH = new u(qVar);
        this.aGI = new h(qVar);
        this.aGK = r.d(qVar);
        this.aGO = new j(this.aFo.aFD);
        this.aGM = new 1(this, qVar);
        this.aGN = new 2(this, qVar);
    }

    private void a(s sVar, ak akVar) {
        com.google.android.gms.common.internal.w.ag(sVar);
        com.google.android.gms.common.internal.w.ag(akVar);
        c cVar = new c(this.aFo);
        String str = sVar.aGn;
        com.google.android.gms.common.internal.w.aM(str);
        Uri aG = d.aG(str);
        ListIterator listIterator = cVar.pP().listIterator();
        while (listIterator.hasNext()) {
            if (aG.equals(((ai) listIterator.next()).nL())) {
                listIterator.remove();
            }
        }
        cVar.pP().add(new d(cVar.aHf, str));
        cVar.aIn = sVar.aGo;
        ae nK = cVar.nK();
        h hVar = (h) nK.b(h.class);
        hVar.aWo = SlookAirButtonFrequentContactAdapter.DATA;
        hVar.aWt = true;
        nK.b(akVar);
        g gVar = (g) nK.b(g.class);
        aj ajVar = (aj) nK.b(aj.class);
        for (Entry entry : sVar.aFb.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if ("an".equals(str2)) {
                ajVar.aEW = str3;
            } else if ("av".equals(str2)) {
                ajVar.aEX = str3;
            } else if ("aid".equals(str2)) {
                ajVar.aYv = str3;
            } else if ("aiid".equals(str2)) {
                ajVar.aYw = str3;
            } else if ("uid".equals(str2)) {
                hVar.aWp = str3;
            } else {
                gVar.aFb.put(g.aX(str2), str3);
            }
        }
        b("Sending installation campaign to", sVar.aGn, akVar);
        nK.aYc = mO().ms();
        ah ahVar = nK.aXZ.aYj;
        if (nK.aYg) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (nK.aYa) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            ae pN = nK.pN();
            pN.aYd = pN.aFD.elapsedRealtime();
            if (pN.aYc != 0) {
                pN.aYb = pN.aYc;
            } else {
                pN.aYb = pN.aFD.currentTimeMillis();
            }
            pN.aYa = true;
            ahVar.aYp.execute(new 1(ahVar, pN));
        }
    }

    static /* synthetic */ void a(w wVar) {
        try {
            wVar.aGH.nc();
            wVar.nl();
        } catch (SQLiteException e) {
            wVar.e("Failed to delete stale hits", e);
        }
        wVar.aGN.Z(86400000);
    }

    private boolean aC(String str) {
        return this.aFo.mContext.checkCallingOrSelfPermission(str) == 0;
    }

    private long nd() {
        ah.mY();
        mQ();
        try {
            return this.aGH.nd();
        } catch (SQLiteException e) {
            f("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    private void nj() {
        if (!this.aGQ && ac.nv() && !this.aGK.isConnected()) {
            if (this.aGO.V(((Long) aj.aIg.get()).longValue())) {
                this.aGO.start();
                au("Connecting to service");
                if (this.aGK.connect()) {
                    au("Connected to service");
                    this.aGO.aFE = 0;
                    onServiceConnected();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean nk() {
        boolean z = true;
        ah.mY();
        mQ();
        au("Dispatching a batch of local hits");
        boolean z2 = (this.aGK.isConnected() || f.aNs) ? false : true;
        if (this.aGI.mp()) {
            z = false;
        }
        if (z2 && r1) {
            au("No network or service available. Will retry later");
        } else {
            long max = (long) Math.max(ac.nz(), ac.nA());
            List arrayList = new ArrayList();
            long j = 0;
            while (true) {
                try {
                    this.aGH.beginTransaction();
                    arrayList.clear();
                    List<c> X = this.aGH.X(max);
                    if (X.isEmpty()) {
                        break;
                    }
                    c cVar;
                    c("Hits loaded from store. count", Integer.valueOf(X.size()));
                    for (c cVar2 : X) {
                        if (cVar2.aFd == j) {
                            break;
                        }
                    }
                    if (this.aGK.isConnected() && !f.aNs) {
                        au("Service connected, sending hits to the service");
                        while (!X.isEmpty()) {
                            cVar2 = (c) X.get(0);
                            if (!this.aGK.d(cVar2)) {
                                break;
                            }
                            j = Math.max(j, cVar2.aFd);
                            X.remove(cVar2);
                            d("Hit sent do device AnalyticsService for delivery", cVar2);
                            try {
                                this.aGH.Y(cVar2.aFd);
                                arrayList.add(Long.valueOf(cVar2.aFd));
                            } catch (SQLiteException e) {
                                f("Failed to remove hit that was send for delivery", e);
                                nn();
                                try {
                                    this.aGH.setTransactionSuccessful();
                                    this.aGH.endTransaction();
                                } catch (SQLiteException e2) {
                                    f("Failed to commit local dispatch transaction", e2);
                                    nn();
                                }
                            }
                        }
                    }
                    long j2 = j;
                    if (this.aGI.mp()) {
                        Collection<Long> q = this.aGI.q(X);
                        j = j2;
                        for (Long longValue : q) {
                            j = Math.max(j, longValue.longValue());
                        }
                        X.removeAll(q);
                        try {
                            this.aGH.s(q);
                            arrayList.addAll(q);
                            j2 = j;
                        } catch (SQLiteException e22) {
                            f("Failed to remove successfully uploaded hits", e22);
                            nn();
                            try {
                                this.aGH.setTransactionSuccessful();
                                this.aGH.endTransaction();
                            } catch (SQLiteException e222) {
                                f("Failed to commit local dispatch transaction", e222);
                                nn();
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            break;
                        } catch (SQLiteException e2222) {
                            f("Failed to commit local dispatch transaction", e2222);
                            nn();
                        }
                    } else {
                        try {
                            this.aGH.setTransactionSuccessful();
                            this.aGH.endTransaction();
                            j = j2;
                        } catch (SQLiteException e22222) {
                            f("Failed to commit local dispatch transaction", e22222);
                            nn();
                        }
                    }
                } catch (SQLiteException e222222) {
                    e("Failed to read hits from persisted store", e222222);
                    nn();
                    return false;
                } finally {
                    try {
                        this.aGH.setTransactionSuccessful();
                        this.aGH.endTransaction();
                    } catch (SQLiteException e2222222) {
                        f("Failed to commit local dispatch transaction", e2222222);
                        nn();
                    }
                }
            }
            au("Store is empty, nothing to dispatch");
            nn();
            try {
                this.aGH.setTransactionSuccessful();
                this.aGH.endTransaction();
            } catch (SQLiteException e22222222) {
                f("Failed to commit local dispatch transaction", e22222222);
                nn();
            }
        }
        return false;
    }

    private void nm() {
        ag mN = mN();
        if (mN.aHp && !mN.aHq) {
            long nd = nd();
            if (nd != 0 && Math.abs(this.aFo.aFD.currentTimeMillis() - nd) <= ((Long) aj.aHF.get()).longValue()) {
                c("Dispatch alarm scheduled (ms)", Long.valueOf(ac.ny()));
                mN.nI();
            }
        }
    }

    private void nn() {
        if (this.aGM.nG()) {
            au("All hits dispatched or no network/service. Going to power save mode");
        }
        this.aGM.cancel();
        ag mN = mN();
        if (mN.aHq) {
            mN.cancel();
        }
    }

    private long no() {
        if (this.aGL != Long.MIN_VALUE) {
            return this.aGL;
        }
        return this.aFo.mW().mF() ? ((long) this.aFo.mW().mG()) * 1000 : ((Long) aj.aHA.get()).longValue();
    }

    private void np() {
        mQ();
        q.mY();
        this.aGQ = true;
        this.aGK.disconnect();
        nl();
    }

    public final void aD(String str) {
        com.google.android.gms.common.internal.w.aM(str);
        q.mY();
        mM();
        ak a = k.a(this.aFo.mS(), str);
        if (a == null) {
            e("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence mw = mO().mw();
        if (str.equals(mw)) {
            ax("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(mw)) {
            mO().aq(str);
            if (mO().mt().V(ac.nF())) {
                e("Campaign received too late, ignoring", a);
                return;
            }
            d("Received installation campaign", a);
            for (s a2 : this.aGH.ne()) {
                a(a2, a);
            }
        } else {
            d("Ignoring multiple install campaigns. original, new", mw, str);
        }
    }

    public final void b(ah ahVar) {
        long j = this.aGP;
        ah.mY();
        mQ();
        long j2 = -1;
        long mu = mO().mu();
        if (mu != 0) {
            j2 = Math.abs(this.aFo.aFD.currentTimeMillis() - mu);
        }
        d("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!f.aNs) {
            nj();
        }
        try {
            nk();
            mO().mv();
            nl();
            if (ahVar != null) {
                ahVar.mc();
            }
            if (this.aGP != j) {
                g gVar = this.aGJ;
                if (VERSION.SDK_INT > 10) {
                    Context context = gVar.aFo.mContext;
                    Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                    intent.addCategory(context.getPackageName());
                    intent.putExtra(g.aFn, true);
                    context.sendOrderedBroadcast(intent, null);
                }
            }
        } catch (Throwable th) {
            f("Local dispatch failed", th);
            mO().mv();
            nl();
            if (ahVar != null) {
                ahVar.mc();
            }
        }
    }

    public final void c(c cVar) {
        com.google.android.gms.common.internal.w.ag(cVar);
        ah.mY();
        mQ();
        if (this.aGQ) {
            av("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            c("Delivering hit", cVar);
        }
        if (TextUtils.isEmpty(cVar.k("_m", ""))) {
            Pair pair;
            i$a com_google_android_gms_analytics_internal_i_a = mO().aFA;
            long my = com_google_android_gms_analytics_internal_i_a.my();
            my = my == 0 ? 0 : Math.abs(my - com_google_android_gms_analytics_internal_i_a.aFC.aFo.aFD.currentTimeMillis());
            if (my < com_google_android_gms_analytics_internal_i_a.aFB) {
                pair = null;
            } else if (my > com_google_android_gms_analytics_internal_i_a.aFB * 2) {
                com_google_android_gms_analytics_internal_i_a.mx();
                pair = null;
            } else {
                String string = com_google_android_gms_analytics_internal_i_a.aFC.aFx.getString(com_google_android_gms_analytics_internal_i_a.mB(), null);
                long j = com_google_android_gms_analytics_internal_i_a.aFC.aFx.getLong(com_google_android_gms_analytics_internal_i_a.mA(), 0);
                com_google_android_gms_analytics_internal_i_a.mx();
                pair = (string == null || j <= 0) ? null : new Pair(string, Long.valueOf(j));
            }
            if (pair != null) {
                String str = ((Long) pair.second) + ":" + ((String) pair.first);
                Map hashMap = new HashMap(cVar.aFb);
                hashMap.put("_m", str);
                cVar = new c(this, hashMap, cVar.aFe, cVar.aFg, cVar.aFd, cVar.aFf, cVar.aFc);
            }
        }
        nj();
        if (this.aGK.d(cVar)) {
            av("Hit sent to the device AnalyticsService for delivery");
        } else if (f.aNs) {
            this.aFo.mS().a(cVar, "Service unavailable on package side");
        } else {
            try {
                this.aGH.e(cVar);
                nl();
            } catch (SQLiteException e) {
                f("Delivery failed to save hit to a database", e);
                this.aFo.mS().a(cVar, "deliver: failed to insert hit to database");
            }
        }
    }

    protected final void c(s sVar) {
        q.mY();
        d("Sending first hit to property", sVar.aGn);
        if (!mO().mt().V(ac.nF())) {
            Object mw = mO().mw();
            if (!TextUtils.isEmpty(mw)) {
                ak a = k.a(this.aFo.mS(), mw);
                d("Found relevant installation campaign", a);
                a(sVar, a);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long d(s sVar) {
        com.google.android.gms.common.internal.w.ag(sVar);
        mQ();
        q.mY();
        try {
            this.aGH.beginTransaction();
            this.aGH.b(sVar.aGl, sVar.aGm);
            long a = this.aGH.a(sVar.aGl, sVar.aGm, sVar.aGn);
            sVar.aGp = 1 + a;
            this.aGH.b(sVar);
            this.aGH.setTransactionSuccessful();
            try {
                this.aGH.endTransaction();
                return a;
            } catch (SQLiteException e) {
                f("Failed to end transaction", e);
                return a;
            }
        } catch (SQLiteException e2) {
            f("Failed to update Analytics property", e2);
            return -1;
        } catch (Throwable th) {
            try {
                this.aGH.endTransaction();
            } catch (SQLiteException e3) {
                f("Failed to end transaction", e3);
            }
        }
    }

    public final void mK() {
        ah.mY();
        mQ();
        au("Service disconnected");
    }

    final void mL() {
        q.mY();
        this.aGP = this.aFo.aFD.currentTimeMillis();
    }

    protected final void mf() {
        this.aGH.mR();
        this.aGI.mR();
        this.aGK.mR();
    }

    protected final void ni() {
        mQ();
        mO().ms();
        if (!aC("android.permission.ACCESS_NETWORK_STATE")) {
            ay("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            np();
        }
        if (!aC("android.permission.INTERNET")) {
            ay("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            np();
        }
        if (AnalyticsService.z(this.aFo.mContext)) {
            au("AnalyticsService registered in the app manifest and enabled");
        } else if (f.aNs) {
            ay("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            ax("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.aGQ || f.aNs || this.aGH.isEmpty())) {
            nj();
        }
        nl();
    }

    public final void nl() {
        long j = 0;
        q.mY();
        mQ();
        boolean z = !this.aGQ && ((!f.aNs || this.aFo.aFW.nu()) && no() > 0);
        if (!z) {
            this.aGJ.unregister();
            nn();
        } else if (this.aGH.isEmpty()) {
            this.aGJ.unregister();
            nn();
        } else {
            if (((Boolean) aj.aIb.get()).booleanValue()) {
                z = true;
            } else {
                BroadcastReceiver broadcastReceiver = this.aGJ;
                broadcastReceiver.mo();
                if (!broadcastReceiver.aFp) {
                    Context context = broadcastReceiver.aFo.mContext;
                    context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                    intentFilter.addCategory(context.getPackageName());
                    context.registerReceiver(broadcastReceiver, intentFilter);
                    broadcastReceiver.aFq = broadcastReceiver.mp();
                    broadcastReceiver.aFo.mS().c("Registering connectivity change receiver. Network connected", Boolean.valueOf(broadcastReceiver.aFq));
                    broadcastReceiver.aFp = true;
                }
                g gVar = this.aGJ;
                if (!gVar.aFp) {
                    gVar.aFo.mS().ax("Connectivity unknown. Receiver not registered");
                }
                z = gVar.aFq;
            }
            if (z) {
                nm();
                long no = no();
                long mu = mO().mu();
                if (mu != 0) {
                    mu = no - Math.abs(this.aFo.aFD.currentTimeMillis() - mu);
                    if (mu <= 0) {
                        mu = Math.min(ac.nx(), no);
                    }
                } else {
                    mu = Math.min(ac.nx(), no);
                }
                c("Dispatch scheduled (ms)", Long.valueOf(mu));
                if (this.aGM.nG()) {
                    ae aeVar = this.aGM;
                    mu = Math.max(1, mu + (aeVar.aHm == 0 ? 0 : Math.abs(aeVar.aFo.aFD.currentTimeMillis() - aeVar.aHm)));
                    aeVar = this.aGM;
                    if (!aeVar.nG()) {
                        return;
                    }
                    if (mu < 0) {
                        aeVar.cancel();
                        return;
                    }
                    mu -= Math.abs(aeVar.aFo.aFD.currentTimeMillis() - aeVar.aHm);
                    if (mu >= 0) {
                        j = mu;
                    }
                    aeVar.getHandler().removeCallbacks(aeVar.aHl);
                    if (!aeVar.getHandler().postDelayed(aeVar.aHl, j)) {
                        aeVar.aFo.mS().f("Failed to adjust delayed post. time", Long.valueOf(j));
                        return;
                    }
                    return;
                }
                this.aGM.Z(mu);
                return;
            }
            nn();
            nm();
        }
    }

    protected final void onServiceConnected() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        com.google.android.gms.analytics.internal.q.mY();
        r0 = com.google.android.gms.common.internal.f.aNs;
        if (r0 != 0) goto L_0x002a;
    L_0x0007:
        com.google.android.gms.c.ah.mY();
        r6.mQ();
        mM();
        r0 = com.google.android.gms.analytics.internal.ac.nv();
        if (r0 != 0) goto L_0x001c;
    L_0x0016:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.ax(r0);
    L_0x001c:
        r0 = r6.aGK;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x002b;
    L_0x0024:
        r0 = "Service not connected";
        r6.au(r0);
    L_0x002a:
        return;
    L_0x002b:
        r0 = r6.aGH;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x002a;
    L_0x0033:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.au(r0);
    L_0x0039:
        r0 = r6.aGH;	 Catch:{ SQLiteException -> 0x004e }
        r1 = com.google.android.gms.analytics.internal.ac.nz();	 Catch:{ SQLiteException -> 0x004e }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004e }
        r1 = r0.X(r2);	 Catch:{ SQLiteException -> 0x004e }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004e }
        if (r0 == 0) goto L_0x0063;	 Catch:{ SQLiteException -> 0x004e }
    L_0x004a:
        r6.nl();	 Catch:{ SQLiteException -> 0x004e }
        goto L_0x002a;
    L_0x004e:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.f(r1, r0);
        r6.nn();
        goto L_0x002a;
    L_0x0059:
        r1.remove(r0);
        r2 = r6.aGH;	 Catch:{ SQLiteException -> 0x007c }
        r4 = r0.aFd;	 Catch:{ SQLiteException -> 0x007c }
        r2.Y(r4);	 Catch:{ SQLiteException -> 0x007c }
    L_0x0063:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0039;
    L_0x0069:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.c) r0;
        r2 = r6.aGK;
        r2 = r2.d(r0);
        if (r2 != 0) goto L_0x0059;
    L_0x0078:
        r6.nl();
        goto L_0x002a;
    L_0x007c:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.f(r1, r0);
        r6.nn();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.w.onServiceConnected():void");
    }

    final void start() {
        mQ();
        com.google.android.gms.common.internal.w.d(!this.oO, "Analytics backend already started");
        this.oO = true;
        if (!f.aNs) {
            Context context = this.aFo.mContext;
            if (!AnalyticsReceiver.y(context)) {
                ax("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!AnalyticsService.z(context)) {
                ay("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
            }
            if (!CampaignTrackingReceiver.y(context)) {
                ax("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            } else if (!CampaignTrackingService.z(context)) {
                ax("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
            }
        }
        this.aFo.mT().d(new Runnable(this) {
            final /* synthetic */ w aGR;

            {
                this.aGR = r1;
            }

            public final void run() {
                this.aGR.ni();
            }
        });
    }
}
