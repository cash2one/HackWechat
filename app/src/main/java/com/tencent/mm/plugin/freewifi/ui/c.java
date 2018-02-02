package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    static String TAG = "MicroMsg.FreeWifi.FreeWifiGetLocation";
    boolean bgH;
    com.tencent.mm.modelgeo.a.a jky;
    com.tencent.mm.modelgeo.a mHF;
    af mHG;

    class AnonymousClass1 implements com.tencent.mm.modelgeo.a.a {
        final /* synthetic */ a mHH;
        final /* synthetic */ c mHI;

        AnonymousClass1(c cVar, a aVar) {
            this.mHI = cVar;
            this.mHH = aVar;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            x.v(c.TAG, "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
            if (this.mHI.mHF != null) {
                this.mHI.mHF.c(this.mHI.jky);
            }
            if (this.mHI.jky == null) {
                x.w(c.TAG, "already callback");
                return false;
            }
            this.mHI.jky = null;
            this.mHH.v(f, f2);
            return false;
        }
    }

    public interface a {
        void v(float f, float f2);
    }

    private c() {
        this.mHF = null;
        this.jky = null;
        this.mHG = null;
        this.bgH = false;
    }

    public static c aMF() {
        return b.aMG();
    }
}
