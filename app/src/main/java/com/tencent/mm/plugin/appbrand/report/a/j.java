package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;

public final class j {
    public static void a(String str, String str2, String str3, String str4, long j, long j2, int i, int i2, int i3) {
        AppBrandSysConfig oS = a.oS(str);
        if (oS != null) {
            try {
                str4 = p.encode(str4, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
            }
            int i4 = oS.iOI.iGL;
            int i5 = oS.iOI.iGK + 1;
            String ce = com.tencent.mm.plugin.appbrand.report.a.ce(ac.getContext());
            g.pQN.h(14510, new Object[]{str, Integer.valueOf(i4), Integer.valueOf(i5), ce, str2, str4, str3, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            StringBuilder stringBuilder = new StringBuilder("report kv_14510{");
            stringBuilder.append("appId='").append(str).append('\'').append(", appVersion=").append(i4).append(", appState=").append(i5).append(", networkType='").append(ce).append('\'').append(", functionName='").append(str2).append('\'').append(", url='").append(str4).append('\'').append(", method='").append(str3).append('\'').append(", sentsize=").append(j).append(", receivedsize=").append(j2).append(", statusCode=").append(i).append(", result=").append(i2).append(", costtime=").append(i3).append('}');
            x.d("MicroMsg.AppBrand.Report.kv_14510", stringBuilder.toString());
            return;
        }
        x.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[]{str});
    }
}
