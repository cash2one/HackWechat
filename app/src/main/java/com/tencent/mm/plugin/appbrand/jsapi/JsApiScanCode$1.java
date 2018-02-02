package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.GetA8KeyTask;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.HashMap;

class JsApiScanCode$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiScanCode jdW;

    JsApiScanCode$1(JsApiScanCode jsApiScanCode, j jVar, int i) {
        this.jdW = jsApiScanCode;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        JsApiScanCode.ID();
        if (i == (this.jdW.hashCode() & 65535)) {
            switch (i2) {
                case -1:
                    Object stringExtra;
                    int intExtra;
                    int intExtra2;
                    int intExtra3;
                    String str = "";
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("key_scan_result");
                        intExtra = intent.getIntExtra("key_scan_result_type", 0);
                        intExtra2 = intent.getIntExtra("key_scan_result_code_type", 0);
                        intExtra3 = intent.getIntExtra("key_scan_result_code_version", 0);
                    } else {
                        intExtra2 = 0;
                        intExtra = 0;
                        String str2 = str;
                        intExtra3 = 0;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                    if (intExtra != 1) {
                        String[] split = stringExtra.split(",");
                        String str3 = "result";
                        if (split.length > 1) {
                            stringExtra = split[1];
                        }
                        hashMap.put(str3, stringExtra);
                        hashMap.put("scanType", split.length > 1 ? split[0] : "");
                        this.iZy.E(this.gOK, this.jdW.e("ok", hashMap));
                        return;
                    }
                    hashMap.put("result", intExtra2 == 22 ? "" : stringExtra);
                    hashMap.put("scanType", "QR_CODE");
                    MainProcessTask getA8KeyTask = new GetA8KeyTask();
                    getA8KeyTask.jea = stringExtra;
                    getA8KeyTask.fqb = intExtra2;
                    getA8KeyTask.fqc = intExtra3;
                    getA8KeyTask.jec = new 1(this, getA8KeyTask, hashMap);
                    getA8KeyTask.afi();
                    AppBrandMainProcessService.a(getA8KeyTask);
                    return;
                case 0:
                    this.iZy.E(this.gOK, this.jdW.e("cancel", null));
                    return;
                default:
                    this.iZy.E(this.gOK, this.jdW.e("fail", null));
                    return;
            }
        }
    }
}
