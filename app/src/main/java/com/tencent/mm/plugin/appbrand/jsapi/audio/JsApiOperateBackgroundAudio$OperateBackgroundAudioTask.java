package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.av.c;
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

class JsApiOperateBackgroundAudio$OperateBackgroundAudioTask extends MainProcessTask {
    public static final Creator<JsApiOperateBackgroundAudio$OperateBackgroundAudioTask> CREATOR = new 1();
    public String appId;
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    public String jeR;
    public String jey = "";

    public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(a aVar, j jVar, int i) {
        this.jcL = aVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiOperateBackgroundAudio$OperateBackgroundAudioTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
        String str = d.a.aio().jzA;
        if (bh.ov(str) || str.equals(this.appId)) {
            try {
                JSONObject jSONObject = new JSONObject(this.jeR);
                String optString = jSONObject.optString("operationType");
                int optInt = jSONObject.optInt("currentTime", -1);
                if (TextUtils.isEmpty(optString)) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                    this.jeA = true;
                    this.jey = "operationType is null";
                    afp();
                    return;
                }
                x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", new Object[]{optString, Integer.valueOf(optInt)});
                this.jeA = false;
                if (optString.equalsIgnoreCase("play")) {
                    asv Qs = b.Qs();
                    if (Qs != null) {
                        d.a.aio().jzB = Qs.vVZ;
                    }
                    if (c.Qu()) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                    } else if (b.Qq()) {
                        this.jeA = true;
                        this.jey = "music is playing, don't play again";
                    } else {
                        this.jeA = true;
                        this.jey = "play music fail";
                    }
                } else if (optString.equalsIgnoreCase("pause")) {
                    if (c.Qv()) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                    } else {
                        this.jeA = true;
                        this.jey = "pause music fail";
                    }
                } else if (optString.equalsIgnoreCase("seek")) {
                    if (optInt < 0) {
                        x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                        this.jeA = true;
                        this.jey = "currentTime is invalid";
                    } else if (b.if(optInt * 1000)) {
                        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                    } else {
                        this.jeA = true;
                        this.jey = "seek music fail";
                    }
                } else if (!optString.equalsIgnoreCase("stop")) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                    this.jeA = true;
                    this.jey = "operationType is invalid";
                } else if (c.Qw()) {
                    x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                } else {
                    this.jeA = true;
                    this.jey = "stop music fail";
                }
                if (this.jeA) {
                    x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.jey);
                }
                afp();
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[]{this.jeR});
                this.jeA = true;
                this.jey = "parser data fail, data is invalid";
                x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e.getMessage());
                afp();
                return;
            }
        }
        x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
        this.jeA = true;
        this.jey = "appid not match cannot operate";
        afp();
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        } else if (this.jeA) {
            x.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[]{this.jey});
            this.jcM.E(this.jcN, this.jcL.e("fail:" + this.jey, null));
        } else {
            x.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
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
