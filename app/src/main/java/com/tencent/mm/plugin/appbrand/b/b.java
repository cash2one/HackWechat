package com.tencent.mm.plugin.appbrand.b;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    final String TAG;
    public final c iGV;
    public final a<a, b> iGW = new a();
    public final d iGX = new d(this) {
        final /* synthetic */ b iGY;

        {
            this.iGY = r1;
        }

        public final void onTrimMemory(int i) {
            switch (i) {
                case 5:
                case 10:
                case 15:
                    if (this.iGY.iGV.aas() == a.iGS && com.tencent.mm.protocal.d.vAC) {
                        x.i(this.iGY.TAG, "onTrimMemory level %d, finishRuntime", new Object[]{Integer.valueOf(i)});
                        b.a(this.iGY);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    final e irP;

    static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] iGZ = new int[a.values().length];

        static {
            try {
                iGZ[a.iGS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iGZ[a.iGT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    static /* synthetic */ void a(b bVar) {
        if (!bVar.irP.mFinished) {
            bVar.irP.finish();
        }
    }

    public b(e eVar) {
        this.TAG = String.format("MicroMsg.AppBrand.AppRunningStateController[%s]", new Object[]{eVar.mAppId});
        this.irP = eVar;
        this.iGV = new 2(this, eVar);
    }

    public final void a(a aVar) {
        if (aVar != null && a.iGT != this.iGV.aas()) {
            synchronized (this.iGW) {
                this.iGW.put(aVar, this);
            }
        }
    }
}
