package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.protocal.c.cbu;
import com.tencent.mm.sdk.platformtools.x;

class a$c implements j<Bundle, Bundle> {
    private a$c() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return j((Bundle) obj);
    }

    private static Bundle j(Bundle bundle) {
        boolean z = true;
        String string = bundle.getString("appId");
        int i = bundle.getInt("pkgType");
        int i2 = bundle.getInt("pkgVersion");
        int i3 = bundle.getInt("scene");
        int i4 = bundle.getInt("widgetType");
        String string2 = bundle.getString("preloadLaunchData", "");
        Bundle bundle2 = new Bundle();
        try {
            com.tencent.mm.plugin.appbrand.widget.j acZ = new a(string, i, i2, i3, i4, string2).acZ();
            if (acZ == null) {
                return bundle2;
            }
            boolean z2;
            if (acZ.field_jsApiInfo != null) {
                bundle2.putByteArray("jsApiInfo", acZ.field_jsApiInfo.toByteArray());
            }
            if (acZ.field_launchAction != null) {
                bundle2.putByteArray("launchAction", acZ.field_launchAction.toByteArray());
            }
            if (acZ.field_versionInfo != null) {
                bundle2.putByteArray("versionInfo", acZ.field_versionInfo.toByteArray());
            }
            Parcelable widgetRuntimeConfig = new WidgetRuntimeConfig();
            widgetRuntimeConfig.appId = string;
            widgetRuntimeConfig.iUf = i4;
            cbu com_tencent_mm_protocal_c_cbu = acZ.field_widgetSetting;
            if (com_tencent_mm_protocal_c_cbu != null) {
                widgetRuntimeConfig.iUv = com_tencent_mm_protocal_c_cbu.xaO;
                widgetRuntimeConfig.iUx = com_tencent_mm_protocal_c_cbu.xaQ;
                widgetRuntimeConfig.iUw = com_tencent_mm_protocal_c_cbu.xaP;
            }
            bundle2.putParcelable("runtimeConfig", widgetRuntimeConfig);
            l uS = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zk().uS(string);
            DebuggerInfo rr = b.rr(string);
            widgetRuntimeConfig = new DebuggerInfo();
            if (uS == null || !uS.field_openDebug) {
                z2 = false;
            } else {
                z2 = true;
            }
            widgetRuntimeConfig.iSS = z2;
            if (d$a.hf(i) || (rr != null && rr.iSR)) {
                z2 = true;
            } else {
                z2 = false;
            }
            widgetRuntimeConfig.iSR = z2;
            if (rr == null || !rr.iST) {
                z = false;
            }
            widgetRuntimeConfig.iST = z;
            bundle2.putParcelable("debuggerInfo", widgetRuntimeConfig);
            AppBrandGlobalSystemConfig abS = AppBrandGlobalSystemConfig.abS();
            Parcelable widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.iNy = abS.iNy;
            widgetSysConfig.iNz = abS.iNz;
            widgetSysConfig.iNA = abS.iNA;
            bundle2.putParcelable("sysConfig", widgetSysConfig);
            return bundle2;
        } catch (Exception e) {
            x.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[]{e});
        }
    }
}
