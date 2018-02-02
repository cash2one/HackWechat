package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.av.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.d;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask extends MainProcessTask {
    public static final Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask> CREATOR = new 1();
    public String appId;
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    public String jeR;
    public String jey = "";

    public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(a aVar, j jVar, int i) {
        this.jcL = aVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
        try {
            JSONObject jSONObject = new JSONObject(this.jeR);
            String optString = jSONObject.optString("src");
            String optString2 = jSONObject.optString("title");
            String optString3 = jSONObject.optString("epname");
            String optString4 = jSONObject.optString("singer");
            String optString5 = jSONObject.optString("coverImgUrl");
            String optString6 = jSONObject.optString("webUrl");
            String optString7 = jSONObject.optString("protocol");
            int optInt = jSONObject.optInt("startTime", 0);
            d.a.aio();
            String optString8 = jSONObject.optString("operationType");
            if (!TextUtils.isEmpty(optString8)) {
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                optString7 = d.a.aio().jzA;
                if (bh.ov(optString7) || optString7.equals(this.appId)) {
                    this.jeA = false;
                    if (optString8.equalsIgnoreCase("pause")) {
                        if (c.Qv()) {
                            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                            return;
                        } else {
                            this.jeA = true;
                            this.jey = "pause music fail";
                        }
                    } else if (optString8.equalsIgnoreCase("stop")) {
                        if (c.Qw()) {
                            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                            return;
                        } else {
                            this.jeA = true;
                            this.jey = "stop music fail";
                        }
                    }
                    afp();
                    return;
                }
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{optString7, this.appId});
            } else if (TextUtils.isEmpty(optString)) {
                x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                this.jeA = true;
                this.jey = "src is null";
                afp();
            } else {
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d", new Object[]{optString, optString2, optString3, optString4, optString5, optString7, optString6, Integer.valueOf(optInt)});
                if (optString5 == null) {
                    optString5 = "";
                }
                String str = optString;
                asv a = ((com.tencent.mm.av.a.a) g.h(com.tencent.mm.av.a.a.class)).a(11, optString5, optString2, optString4, optString6, optString, str, (this.appId + optString + optString5).hashCode(), com.tencent.mm.compatible.util.e.bnF, com.tencent.mm.plugin.n.c.Fi() + optString5.hashCode(), optString3, "");
                a.hkt = optInt * 1000;
                d.a.aio().jzB = a.vVZ;
                b.b(a);
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.jeA = false;
                afp();
            }
        } catch (JSONException e) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
            this.jeA = true;
            this.jey = "parser data fail, data is invalid";
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
            afp();
        }
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        } else if (this.jeA) {
            x.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[]{this.jey});
            this.jcM.E(this.jcN, this.jcL.e("fail:" + this.jey, null));
        } else {
            x.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
            this.jcM.E(this.jcN, this.jcL.e("ok", null));
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.jeR = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jeA = z;
        this.jey = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.jeR);
        parcel.writeInt(this.jeA ? 1 : 0);
        parcel.writeString(this.jey);
    }
}
