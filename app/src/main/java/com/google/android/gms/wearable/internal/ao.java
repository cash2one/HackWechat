package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c$c;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.wearable.a$a;
import com.google.android.gms.wearable.b$a;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.r.a;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao extends k<x> {
    final ExecutorService beV = Executors.newCachedThreadPool();
    private final y<a> beW = new y();
    private final y<q.a> beX = new y();
    private final y<b$a> beY = new y();
    private final y<b> beZ = new y();
    private final y<com.google.android.gms.wearable.k.a> bfa = new y();
    private final y<n.b> bfb = new y();
    private final y<c> bfc = new y();
    private final Map<String, y<a$a>> bfd = new HashMap();

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, c$c com_google_android_gms_common_api_c_c, h hVar) {
        super(context, looper, 14, hVar, bVar, com_google_android_gms_common_api_c_c);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            if (i == 0) {
                this.beW.u(iBinder);
                this.beX.u(iBinder);
                this.beZ.u(iBinder);
                this.bfa.u(iBinder);
                this.bfb.u(iBinder);
                this.bfc.u(iBinder);
                synchronized (this.bfd) {
                    for (y u : this.bfd.values()) {
                        u.u(iBinder);
                    }
                }
            }
            super.a(i, iBinder, bundle, i2);
        }
        if (i == 0) {
            this.beW.u(iBinder);
            this.beX.u(iBinder);
            this.beZ.u(iBinder);
            this.bfa.u(iBinder);
            this.bfb.u(iBinder);
            this.bfc.u(iBinder);
            synchronized (this.bfd) {
                while (r2.hasNext()) {
                    u.u(iBinder);
                }
            }
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void a(e eVar) {
        int i = 7887000;
        if (!nW()) {
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", FileUtils.S_IWUSR).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 7887000);
                }
                if (i < com.google.android.gms.common.b.aJG) {
                    new StringBuilder("Android Wear out of date. Requires API version ").append(com.google.android.gms.common.b.aJG).append(" but found ").append(i);
                    Context context = this.mContext;
                    Context context2 = this.mContext;
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter(SlookAirButtonFrequentContactAdapter.ID, "com.google.android.wearable.app.cn").build());
                    }
                    a(eVar, new ConnectionResult(6, PendingIntent.getActivity(context, 0, intent, 0)));
                    return;
                }
            } catch (NameNotFoundException e) {
                a(eVar, new ConnectionResult(16, null));
                return;
            }
        }
        super.a(eVar);
    }

    public final void disconnect() {
        this.beW.a(this);
        this.beX.a(this);
        this.beZ.a(this);
        this.bfa.a(this);
        this.bfb.a(this);
        this.bfc.a(this);
        synchronized (this.bfd) {
            for (y a : this.bfd.values()) {
                a.a(this);
            }
        }
        super.disconnect();
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return x.a.t(iBinder);
    }

    public final boolean nW() {
        return !com.google.android.gms.common.k.po().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
    }

    protected final String nX() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String nY() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected final String oF() {
        return com.google.android.gms.common.k.po().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }
}
