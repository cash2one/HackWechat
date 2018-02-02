package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class JsApiCreateAudioInstance$CreateAudioTask extends MainProcessTask {
    public static final Creator<JsApiCreateAudioInstance$CreateAudioTask> CREATOR = new 1();
    private String appId = "";
    public int fDt = 0;
    private String fnF = "";
    private e jcL;
    public j jcM;
    private String jey = "";
    public boolean jez = false;

    public JsApiCreateAudioInstance$CreateAudioTask(e eVar, j jVar) {
        this.jcL = eVar;
        this.jcM = jVar;
    }

    public JsApiCreateAudioInstance$CreateAudioTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "runInMainProcess flag:%d, appId:%s", Integer.valueOf(this.fDt), this.appId);
        this.jey = "";
        if (this.fDt == 0) {
            x.i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", this.appId, this.fnF);
            b sVar = new s();
            sVar.fnD.action = 10;
            sVar.fnD.appId = r0;
            sVar.fnD.fnF = r1;
            a.xef.m(sVar);
            this.fnF = sVar.fnD.fnF;
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", this.fnF);
            if (TextUtils.isEmpty(this.fnF)) {
                this.jey = "fail to create audio instance";
            }
        } else if (this.fDt == 3) {
            x.i("MicroMsg.AudioPlayerHelper", "getAudioPlayerCount, appId:%s", this.appId);
            r1 = new s();
            r1.fnD.action = 11;
            r1.fnD.appId = r0;
            a.xef.m(r1);
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "getAudioPlayerCount appId:%s, count:%d", this.appId, Integer.valueOf(r1.fnE.count));
            if (r1.fnE.count < 10) {
                this.jez = true;
            } else {
                this.jez = false;
                this.jey = "create audio player count is exceed max count";
            }
        } else if (this.fDt == 1) {
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
            x.i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", this.appId);
            r1 = new s();
            r1.fnD.action = 12;
            r1.fnD.appId = r0;
            a.xef.m(r1);
        } else if (this.fDt == 2) {
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
            x.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", this.appId);
            r1 = new s();
            r1.fnD.action = 9;
            r1.fnD.appId = r0;
            a.xef.m(r1);
            c.th(this.appId);
        }
        afp();
    }

    public final void Ys() {
        if (this.fDt == 0) {
            if (TextUtils.isEmpty(this.fnF)) {
                x.e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
            } else {
                x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
            }
        } else if (this.fDt == 3) {
            x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "can create player? isCanCreate:%b", Boolean.valueOf(this.jez));
        } else if (this.fDt != 1) {
            x.e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.fDt = parcel.readInt();
        this.appId = parcel.readString();
        this.fnF = parcel.readString();
        this.jey = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jez = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fDt);
        parcel.writeString(this.appId);
        parcel.writeString(this.fnF);
        parcel.writeString(this.jey);
        parcel.writeInt(this.jez ? 1 : 0);
    }
}
