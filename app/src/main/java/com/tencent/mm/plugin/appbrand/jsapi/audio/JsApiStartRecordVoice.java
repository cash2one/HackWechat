package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiStartRecordVoice extends a {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";
    static volatile String jfF = null;
    private StartRecordVoice jfG;
    private p jfg;
    private int jfh;

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        boolean z;
        int i2 = 60;
        int i3 = 600;
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new android.support.v4.app.a.a(this) {
            final /* synthetic */ JsApiStartRecordVoice jfH;

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 116) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        jVar.E(i, this.jfH.e("fail:system permission denied", null));
                    } else {
                        this.jfH.a(jVar, jSONObject, i);
                    }
                }
            }
        });
        Activity a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            z = false;
        } else {
            z = com.tencent.mm.pluginsdk.g.a.a(a, "android.permission.RECORD_AUDIO", 116, "", "");
            if (z) {
                com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
            }
        }
        if (z) {
            this.jfg = b(jVar);
            if (this.jfg == null) {
                jVar.E(i, e("fail", null));
                return;
            }
            int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 60);
            if (optInt <= 0) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
            } else {
                i2 = optInt;
            }
            if (i2 > 600) {
                x.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[]{Integer.valueOf(600)});
            } else {
                i3 = i2;
            }
            this.jfg.a(new 1(this, jVar));
            this.jfg.a(new e(this) {
                final /* synthetic */ JsApiStartRecordVoice jfH;

                public final void onDestroy() {
                    JsApiStopRecordVoice.d(jVar);
                    this.jfH.jfg.b(this);
                }
            });
            this.jfG = new StartRecordVoice(this, jVar, i3, i);
            jfF = StartRecordVoice.a(this.jfG);
            AppBrandMainProcessService.a(this.jfG);
            cI(true);
            return;
        }
        jVar.E(i, e("fail", null));
    }

    private void cI(boolean z) {
        if (this.jfg != null) {
            if (!ag.isMainThread()) {
                ag.y(new 3(this, z));
            } else if (z) {
                this.jfh = com.tencent.mm.plugin.appbrand.page.a.q(this.jfg.irP).a(com.tencent.mm.plugin.appbrand.page.a.a.jCq);
                i.pm(this.jfg.mAppId).irL = this.jfh;
            } else {
                com.tencent.mm.plugin.appbrand.page.a.q(this.jfg.irP).la(this.jfh);
            }
        }
    }
}
