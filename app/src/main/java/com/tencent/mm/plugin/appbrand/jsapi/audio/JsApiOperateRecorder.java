package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;
import org.json.JSONObject;

public final class JsApiOperateRecorder extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 295;
    public static final String NAME = "operateRecorder";
    private static Vector<String> jev = new Vector();
    private b jeV;
    private OperateRecordTask jff;
    private p jfg;
    private int jfh;

    public static final class a extends f {
        private static final int CTRL_INDEX = 296;
        private static final String NAME = "onRecorderStateChange";
    }

    static /* synthetic */ void a(JsApiOperateRecorder jsApiOperateRecorder, boolean z) {
        if (!ag.isMainThread()) {
            ag.y(new 2(jsApiOperateRecorder, z));
        } else if (jsApiOperateRecorder.jfg != null && jsApiOperateRecorder.jfg.irP != null) {
            if (z) {
                jsApiOperateRecorder.jfh = com.tencent.mm.plugin.appbrand.page.a.q(jsApiOperateRecorder.jfg.irP).a(com.tencent.mm.plugin.appbrand.page.a.a.jCq);
            } else {
                com.tencent.mm.plugin.appbrand.page.a.q(jsApiOperateRecorder.jfg.irP).la(jsApiOperateRecorder.jfh);
            }
        }
    }

    public final void a(final j jVar, JSONObject jSONObject, final int i) {
        boolean z;
        com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 3(this, jVar, jSONObject, i));
        Activity a = a(jVar);
        if (a == null) {
            x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, pageContext is null");
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
            } else if (jSONObject == null) {
                x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, data is null");
                jVar.E(i, e("fail:data is null", null));
                return;
            } else {
                final String str = jVar.mAppId;
                x.i("MicroMsg.JsApiOperateRecorder", "operateRecorder appId:%s, data:%s", new Object[]{str, jSONObject.toString()});
                if (this.jff == null) {
                    this.jff = new OperateRecordTask(this, jVar, i);
                }
                this.jff.jcN = i;
                this.jff.appId = str;
                this.jff.jfl = jSONObject.toString();
                this.jff.processName = ac.Br();
                if (this.jeV == null) {
                    this.jeV = new b(this) {
                        final /* synthetic */ JsApiOperateRecorder jfi;

                        public final void a(c cVar) {
                            x.i("MicroMsg.JsApiOperateRecorder", "onPause, appId:%s", new Object[]{str});
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "pause");
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e, "", new Object[0]);
                            }
                            if (this.jfi.jff == null) {
                                this.jfi.jff = new OperateRecordTask(this.jfi, jVar, i);
                            }
                            this.jfi.jff.jfl = jSONObject.toString();
                            this.jfi.jff.appId = str;
                            this.jfi.jff.action = -1;
                            AppBrandMainProcessService.a(this.jfi.jff);
                        }

                        public final void onDestroy() {
                            x.i("MicroMsg.JsApiOperateRecorder", "onDestroy, appId:%s", new Object[]{str});
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.JsApiOperateRecorder", e, "", new Object[0]);
                            }
                            if (this.jfi.jff == null) {
                                this.jfi.jff = new OperateRecordTask(this.jfi, jVar, i);
                            }
                            this.jfi.jff.jfl = jSONObject.toString();
                            this.jfi.jff.appId = str;
                            this.jfi.jff.action = -1;
                            AppBrandMainProcessService.b(this.jfi.jff);
                            com.tencent.mm.plugin.appbrand.c.b(str, this);
                            JsApiOperateRecorder.jev.remove(str);
                        }
                    };
                }
                this.jff.jeV = this.jeV;
                AppBrandMainProcessService.a(this.jff);
                return;
            }
        }
        x.e("MicroMsg.JsApiOperateRecorder", "operateRecorder, requestPermission fail");
        jVar.E(i, e("fail:system permission denied", null));
    }
}
