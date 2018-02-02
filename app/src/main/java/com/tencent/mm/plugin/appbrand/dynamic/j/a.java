package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.b.e;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.c.cag;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a {

    private static class b implements h<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            e.removeAll();
            x.v("MicroMsg.DynamicPkgUpdater", "clearCache");
            com.tencent.mm.plugin.appbrand.dynamic.i.b.adk();
        }
    }

    public static WxaPkgWrappingInfo a(String str, String str2, String str3, int i, int i2) {
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str3);
        WxaPkgWrappingInfo rq = e.rq(y(str2, i, i2));
        if (rq == null) {
            rq = (WxaPkgWrappingInfo) f.a("com.tencent.mm", bundle, a.class);
            if (rq != null) {
                e.a(y(str2, i, i2), rq);
            }
        }
        return rq;
    }

    public static d a(String str, int i, int i2, int i3, int i4, String str2) {
        Parcelable bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        bundle.putString("preloadLaunchData", str2);
        Bundle bundle2 = (Bundle) f.a("com.tencent.mm", bundle, c.class);
        if (bundle2 == null) {
            return null;
        }
        d dVar = new d();
        dVar.appId = str;
        dVar.iUR = (DebuggerInfo) bundle2.getParcelable("debuggerInfo");
        byte[] byteArray = bundle2.getByteArray("jsApiInfo");
        if (byteArray != null) {
            dVar.iUV = new nc();
            try {
                dVar.iUV.aF(byteArray);
            } catch (IOException e) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e});
            }
        }
        byteArray = bundle2.getByteArray("launchAction");
        if (byteArray != null) {
            dVar.iUU = new cag();
            try {
                dVar.iUU.aF(byteArray);
            } catch (IOException e2) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e2});
            }
        }
        byteArray = bundle2.getByteArray("versionInfo");
        if (byteArray != null) {
            dVar.iUW = new cah();
            try {
                dVar.iUW.aF(byteArray);
            } catch (IOException e22) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[]{e22});
            }
        }
        dVar.iUS = (WidgetSysConfig) bundle2.getParcelable("sysConfig");
        dVar.iUT = (WidgetRuntimeConfig) bundle2.getParcelable("runtimeConfig");
        if (dVar.iUT == null) {
            dVar.iUT = new WidgetRuntimeConfig();
        }
        return dVar;
    }

    private static String y(String str, int i, int i2) {
        return str + "#" + i + "#" + i2;
    }
}
