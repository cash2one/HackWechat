package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 431;
    public static final String NAME = "requestMallPayment";

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        MMActivity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        try {
            jSONObject.put("appId", jVar.mAppId);
            jSONObject.put("pay_for_wallet_type", 3);
            PString pString = new PString();
            if (a.joW.a(a, jVar.irP.iqH, jSONObject, new b.a(this) {
                final /* synthetic */ d jpc;

                public final void a(int i, String str, Map<String, Object> map) {
                    switch (i) {
                        case 1:
                            jVar.E(i, this.jpc.e("ok", null));
                            return;
                        case 2:
                            jVar.E(i, this.jpc.e("fail:" + str, null));
                            return;
                        case 3:
                            jVar.E(i, this.jpc.e("cancel", null));
                            return;
                        default:
                            return;
                    }
                }
            }, pString)) {
                p b = b(jVar);
                String str = pString.value;
                if (b != null) {
                    MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(b.mAppId);
                    reportSubmitFormTask.type = 0;
                    reportSubmitFormTask.jhm = str.replace("prepay_id=", "");
                    reportSubmitFormTask.fCp = b.getURL();
                    AppBrandMainProcessService.a(reportSubmitFormTask);
                    return;
                }
                return;
            }
            jVar.E(i, e("fail", null));
        } catch (Exception e) {
            x.e("MicroMsg.JsApiRequestMallPayment", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
