package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;

protected class t$a implements ServiceConnection {
    final /* synthetic */ t aGu;
    private volatile d aGv;
    private volatile boolean aGw;

    protected t$a(t tVar) {
        this.aGu = tVar;
    }

    public final d na() {
        d dVar = null;
        q.mY();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.aGu.aFo.mContext;
        intent.putExtra("app_package_name", context.getPackageName());
        b pi = b.pi();
        synchronized (this) {
            this.aGv = null;
            this.aGw = true;
            boolean a = pi.a(context, intent, this.aGu.aGq, 129);
            this.aGu.c("Bind to service requested", Boolean.valueOf(a));
            if (a) {
                try {
                    wait(((Long) aj.aId.get()).longValue());
                } catch (InterruptedException e) {
                    this.aGu.ax("Wait for service connect was interrupted");
                }
                this.aGw = false;
                dVar = this.aGv;
                this.aGv = null;
                if (dVar == null) {
                    this.aGu.ay("Successfully bound to service but never got onServiceConnected callback");
                }
            } else {
                this.aGw = false;
            }
        }
        return dVar;
    }

    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.t$a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0009, B:9:0x0017]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.w.aN(r0);
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0016;
    L_0x0009:
        r0 = r4.aGu;	 Catch:{ all -> 0x005e }
        r1 = "Service connected with null binder";	 Catch:{ all -> 0x005e }
        r0.ay(r1);	 Catch:{ all -> 0x005e }
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
    L_0x0015:
        return;
    L_0x0016:
        r0 = 0;
        r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0054 }
        r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0054 }
        r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0054 }
        if (r2 == 0) goto L_0x004b;	 Catch:{ RemoteException -> 0x0054 }
    L_0x0024:
        r0 = com.google.android.gms.analytics.internal.d$a.d(r6);	 Catch:{ RemoteException -> 0x0054 }
        r1 = r4.aGu;	 Catch:{ RemoteException -> 0x0054 }
        r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0054 }
        r1.au(r2);	 Catch:{ RemoteException -> 0x0054 }
    L_0x0030:
        if (r0 != 0) goto L_0x0063;
    L_0x0032:
        r0 = com.google.android.gms.common.stats.b.pi();	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r4.aGu;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r1.aFo;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r1 = r1.mContext;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r2 = r4.aGu;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r2 = r2.aGq;	 Catch:{ IllegalArgumentException -> 0x0083 }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0083 }
    L_0x0043:
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        goto L_0x0015;	 Catch:{ all -> 0x0048 }
    L_0x0048:
        r0 = move-exception;	 Catch:{ all -> 0x0048 }
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r2 = r4.aGu;	 Catch:{ RemoteException -> 0x0054 }
        r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0054 }
        r2.f(r3, r1);	 Catch:{ RemoteException -> 0x0054 }
        goto L_0x0030;
    L_0x0054:
        r1 = move-exception;
        r1 = r4.aGu;	 Catch:{ all -> 0x005e }
        r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005e }
        r1.ay(r2);	 Catch:{ all -> 0x005e }
        goto L_0x0030;
    L_0x005e:
        r0 = move-exception;
        r4.notifyAll();	 Catch:{ all -> 0x0048 }
        throw r0;	 Catch:{ all -> 0x0048 }
    L_0x0063:
        r1 = r4.aGw;	 Catch:{ all -> 0x005e }
        if (r1 != 0) goto L_0x0080;	 Catch:{ all -> 0x005e }
    L_0x0067:
        r1 = r4.aGu;	 Catch:{ all -> 0x005e }
        r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005e }
        r1.ax(r2);	 Catch:{ all -> 0x005e }
        r1 = r4.aGu;	 Catch:{ all -> 0x005e }
        r1 = r1.aFo;	 Catch:{ all -> 0x005e }
        r1 = r1.mT();	 Catch:{ all -> 0x005e }
        r2 = new com.google.android.gms.analytics.internal.t$a$1;	 Catch:{ all -> 0x005e }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x005e }
        r1.d(r2);	 Catch:{ all -> 0x005e }
        goto L_0x0043;	 Catch:{ all -> 0x005e }
    L_0x0080:
        r4.aGv = r0;	 Catch:{ all -> 0x005e }
        goto L_0x0043;
    L_0x0083:
        r0 = move-exception;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.t$a.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        w.aN("AnalyticsServiceConnection.onServiceDisconnected");
        this.aGu.aFo.mT().d(new 2(this, componentName));
    }
}
