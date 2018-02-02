package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.1;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

class h$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JSONObject jel;
    final /* synthetic */ h jiz;

    h$1(h hVar, JSONObject jSONObject, j jVar, int i) {
        this.jiz = hVar;
        this.jel = jSONObject;
        this.iZy = jVar;
        this.gOK = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        int optInt = this.jel.optInt("cameraId");
        String optString = this.jel.optString(DownloadSettingTable$Columns.TYPE);
        x.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[]{Integer.valueOf(optInt), optString});
        a afZ = a.afZ();
        Integer valueOf = Integer.valueOf(optInt);
        AppBrandCameraView appBrandCameraView = afZ.jhY.containsKey(valueOf) ? (AppBrandCameraView) afZ.jhY.get(valueOf) : null;
        if (appBrandCameraView == null) {
            this.iZy.E(this.gOK, this.jiz.e("fail:no such camera", null));
            return;
        }
        appBrandCameraView.jil = new 1(this);
        switch (optString.hashCode()) {
            case -1909077165:
                if (optString.equals(JsApiStartRecordVoice.NAME)) {
                    boolean z = true;
                    break;
                }
            case -1391995149:
                if (optString.equals(JsApiStopRecordVoice.NAME)) {
                    optInt = 2;
                    break;
                }
            case 1484838379:
                if (optString.equals("takePhoto")) {
                    optInt = 0;
                    break;
                }
            default:
                optInt = -1;
                break;
        }
        switch (optInt) {
            case 0:
                String optString2 = this.jel.optString("quality", "high");
                if (!bh.fu(appBrandCameraView.jie, optString2)) {
                    appBrandCameraView.jie = optString2;
                }
                x.i("MicroMsg.AppBrandCameraView", "takePicture.");
                if (appBrandCameraView.jin == null) {
                    x.i("MicroMsg.AppBrandCameraView", "recordView is null");
                    return;
                } else if (appBrandCameraView.jir == 2) {
                    x.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
                    return;
                } else if (appBrandCameraView.jis || bh.bA(appBrandCameraView.jit) < 300) {
                    x.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
                    return;
                } else {
                    appBrandCameraView.jit = bh.Wq();
                    appBrandCameraView.jis = true;
                    appBrandCameraView.jir = 3;
                    appBrandCameraView.jin.a(new 1(appBrandCameraView), "on".equals(appBrandCameraView.jid));
                    return;
                }
            case 1:
                x.i("MicroMsg.AppBrandCameraView", "startRecord.");
                a afZ2 = a.afZ();
                if (!(afZ2.jhW && afZ2.jhX)) {
                    x.i("MicroMsg.AppBrandCameraMrg", "no all permission");
                }
                z = afZ2.jhW && afZ2.jhX;
                if (!z) {
                    Toast.makeText(appBrandCameraView.mContext, q.j.iBY, 1).show();
                    x.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
                    appBrandCameraView.I(-1, "permission");
                    return;
                } else if (appBrandCameraView.jir == 2) {
                    x.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                    appBrandCameraView.I(-1, "is recording");
                    return;
                } else {
                    appBrandCameraView.jiu = bh.Wq();
                    appBrandCameraView.jin.oqX.vr();
                    appBrandCameraView.jir = 2;
                    appBrandCameraView.I(0, "");
                    appBrandCameraView.agf();
                    return;
                }
            case 2:
                long bA = bh.bA(appBrandCameraView.jiu);
                if (bA < 1500) {
                    x.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[]{Long.valueOf(1500 - bA)});
                    ag.h(new Runnable(appBrandCameraView) {
                        final /* synthetic */ AppBrandCameraView jiw;

                        {
                            this.jiw = r1;
                        }

                        public final void run() {
                            this.jiw.uE();
                        }
                    }, 1500 - bA);
                    return;
                }
                appBrandCameraView.uE();
                return;
            default:
                x.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[]{optString});
                this.iZy.E(this.gOK, this.jiz.e("fail:operateType not supported", null));
                return;
        }
    }
}
