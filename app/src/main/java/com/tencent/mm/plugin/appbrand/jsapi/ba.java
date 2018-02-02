package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public final class ba extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setKeepScreenOn";
    private static boolean jef = false;
    private j jcM;
    WakeLock wakeLock;

    public final void a(final j jVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn data is null");
            jVar.E(i, e("fail:data is null", null));
        } else if (jVar.getContext() == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, server context is nul");
            jVar.E(i, e("fail:context is null", null));
        } else {
            boolean optBoolean = jSONObject.optBoolean("keepScreenOn", false);
            jef = optBoolean;
            x.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn, keepScreenOn:%b, appId:%s", new Object[]{Boolean.valueOf(optBoolean), jVar.mAppId});
            synchronized (this) {
                this.jcM = jVar;
            }
            if (optBoolean) {
                c.a(jVar.mAppId, new b(this) {
                    final /* synthetic */ ba jeg;

                    public final void onDestroy() {
                        x.i("MicroMsg.JsApiSetKeepScreenOn", "onDestroy");
                        if (this.jeg.isHeld()) {
                            this.jeg.release();
                        }
                        c.b(jVar.mAppId, this);
                    }

                    public final void a(c.c cVar) {
                        x.i("MicroMsg.JsApiSetKeepScreenOn", "onPause");
                        if (this.jeg.isHeld()) {
                            this.jeg.release();
                        }
                    }

                    public final void onResume() {
                        x.i("MicroMsg.JsApiSetKeepScreenOn", "onResume");
                        if (ba.jef) {
                            this.jeg.afx();
                        }
                    }
                });
                optBoolean = afx();
            } else if (isHeld()) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "reset screen off");
                optBoolean = release();
            } else {
                x.e("MicroMsg.JsApiSetKeepScreenOn", "fail, has not set screen");
                jVar.E(i, e("fail:has not set screen", null));
                return;
            }
            if (optBoolean) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn ok");
                jVar.E(i, e("ok", null));
                return;
            }
            x.e("MicroMsg.JsApiSetKeepScreenOn", "setKeepScreenOn fail");
            jVar.E(i, e("fail", null));
        }
    }

    private synchronized boolean afx() {
        boolean z;
        if (this.jcM.getContext() == null) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "acquire fail, server context is nul");
            z = false;
        } else {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "acquire ok");
            MMActivity mMActivity = (MMActivity) this.jcM.getContext();
            if (this.wakeLock == null) {
                this.wakeLock = ((PowerManager) mMActivity.getSystemService("power")).newWakeLock(536870922, "MicroMsg.JsApiSetKeepScreenOn");
            }
            if (this.wakeLock.isHeld()) {
                x.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock has held ");
            } else {
                this.wakeLock.acquire();
                x.i("MicroMsg.JsApiSetKeepScreenOn", "wakeLock acquire");
            }
            z = true;
        }
        return z;
    }

    private synchronized boolean release() {
        boolean z;
        x.e("MicroMsg.JsApiSetKeepScreenOn", "release");
        if (this.wakeLock == null || !this.wakeLock.isHeld()) {
            x.e("MicroMsg.JsApiSetKeepScreenOn", "wakeLock is  null");
            z = false;
        } else {
            this.wakeLock.release();
            this.wakeLock = null;
            z = true;
        }
        return z;
    }

    private synchronized boolean isHeld() {
        boolean z;
        z = this.wakeLock != null && this.wakeLock.isHeld();
        return z;
    }
}
