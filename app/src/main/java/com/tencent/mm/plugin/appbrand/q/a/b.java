package com.tencent.mm.plugin.appbrand.q.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.xwalk.core.Log;

final class b implements e {
    private final IntentFilter bnd = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Intent jSA = null;
    final e jSB = this;
    private a jSC;
    private final d jSz = new d();
    protected Context mContext;

    b() {
    }

    public final synchronized void init(Context context) {
        this.jSA = null;
        this.mContext = context.getApplicationContext();
    }

    public final synchronized void release() {
        if (this.mContext != null) {
            if (this.jSC != null) {
                this.mContext.unregisterReceiver(this.jSC);
            }
            this.mContext = null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized c alM() {
        c cVar;
        boolean z = true;
        int i = -1;
        synchronized (this) {
            if (this.mContext == null) {
                Log.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
                cVar = a.jSw;
            } else {
                Intent intent;
                Context context = this.mContext;
                if (this.jSA != null) {
                    intent = this.jSA;
                } else {
                    this.jSC = new a(this, (byte) 0);
                    Intent registerReceiver = context.getApplicationContext().registerReceiver(this.jSC, this.bnd);
                    this.jSA = registerReceiver;
                    intent = registerReceiver;
                }
                if (intent == null) {
                    Log.e("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
                    cVar = a.jSw;
                } else {
                    cVar = new c();
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("level", -1);
                        int intExtra2 = intent.getIntExtra("scale", -1);
                        if (intExtra2 > 0 && intExtra >= 0) {
                            i = Math.min(Math.max((int) Math.floor((double) ((((float) intExtra) * 100.0f) / ((float) intExtra2))), 0), 100);
                        }
                    }
                    cVar.jSF = i;
                    if (intent != null) {
                        i = intent.getIntExtra(DownloadInfo.STATUS, -1);
                        int intExtra3 = intent.getIntExtra("plugged", 0);
                        if (i != 2) {
                            if (intExtra3 != 1) {
                                if (intExtra3 != 2) {
                                    if (VERSION.SDK_INT >= 17) {
                                    }
                                }
                            }
                        }
                        cVar.jSE = z;
                    }
                    z = false;
                    cVar.jSE = z;
                }
            }
        }
        return cVar;
    }
}
