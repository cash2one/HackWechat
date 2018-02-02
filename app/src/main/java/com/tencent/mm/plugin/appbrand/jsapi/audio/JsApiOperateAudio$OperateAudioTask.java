package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ac.a;
import com.tencent.mm.ac.b;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.x;

final class JsApiOperateAudio$OperateAudioTask extends MainProcessTask {
    public static final Creator<JsApiOperateAudio$OperateAudioTask> CREATOR = new 1();
    public String appId = "";
    public String fnF = "";
    public int fnG = 0;
    public String hkD = "";
    public String iEa;
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    public String jeK = "";
    public String jeL;
    public String jey;
    public String processName = "";

    public JsApiOperateAudio$OperateAudioTask(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiOperateAudio$OperateAudioTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        boolean z = false;
        x.i("MicroMsg.Audio.JsApiOperateAudio", "runInMainProcess");
        x.i("MicroMsg.Audio.JsApiOperateAudio", "operationType;%s, currentTime:%d", new Object[]{this.jeK, Integer.valueOf(this.fnG)});
        this.jeA = false;
        String str = this.jeK;
        if (str.equalsIgnoreCase("play")) {
            a iN = b.iN(this.fnF);
            if (iN == null) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                iN = com.tencent.mm.plugin.appbrand.media.e.b(this.appId, this.fnF, this.hkD, this.jeL, this.iEa, this.processName);
            }
            String str2 = this.fnF;
            if (!b.iM(str2)) {
                z = b.a(str2, iN);
            } else if (b.iM(str2) && !b.iL(str2)) {
                z = b.a(str2, iN);
            }
            if (z) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
            } else if (b.iL(this.fnF)) {
                this.jeA = true;
                this.jey = "audio is playing, don't play again";
            } else {
                this.jeA = true;
                this.jey = "play audio fail";
            }
        } else if (str.equalsIgnoreCase("pause")) {
            str = this.fnF;
            if (b.iL(str)) {
                r0 = b.iK(str);
            } else {
                b.iK(str);
                r0 = false;
            }
            if (r0) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
            } else {
                this.jeA = true;
                this.jey = "pause audio fail";
            }
        } else if (str.equalsIgnoreCase("seek")) {
            if (this.fnG < 0) {
                x.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", new Object[]{Integer.valueOf(this.fnG)});
                this.jeA = true;
                this.jey = "currentTime is invalid";
            } else {
                x.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", new Object[]{this.fnF, Integer.valueOf(this.fnG)});
                com.tencent.mm.sdk.b.b sVar = new s();
                sVar.fnD.action = 4;
                sVar.fnD.fnF = str;
                sVar.fnD.fnG = r1;
                com.tencent.mm.sdk.b.a.xef.m(sVar);
                if (sVar.fnE.fnI) {
                    x.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                } else {
                    this.jeA = true;
                    this.jey = "seek audio fail";
                }
            }
        } else if (str.equalsIgnoreCase("stop")) {
            str = this.fnF;
            com.tencent.mm.sdk.b.b sVar2 = new s();
            sVar2.fnD.action = 13;
            sVar2.fnD.fnF = str;
            com.tencent.mm.sdk.b.a.xef.m(sVar2);
            if (sVar2.fnE.fnI) {
                x.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", new Object[]{str});
                sVar2 = new s();
                sVar2.fnD.action = 14;
                sVar2.fnD.fnF = str;
                com.tencent.mm.sdk.b.a.xef.m(sVar2);
                r0 = sVar2.fnE.fnI;
            } else {
                sVar2 = new s();
                sVar2.fnD.action = 17;
                sVar2.fnD.fnF = str;
                com.tencent.mm.sdk.b.a.xef.m(sVar2);
                if (sVar2.fnE.fnI) {
                    r0 = true;
                } else {
                    x.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", new Object[]{str});
                    sVar2 = new s();
                    sVar2.fnD.action = 3;
                    sVar2.fnD.fnF = str;
                    com.tencent.mm.sdk.b.a.xef.m(sVar2);
                    r0 = sVar2.fnE.fnI;
                }
            }
            if (r0) {
                x.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
            } else {
                this.jeA = true;
                this.jey = "stop audio fail";
            }
        } else {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
            this.jeA = true;
            this.jey = "operationType is invalid";
        }
        if (this.jeA) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", this.jey);
        }
        afp();
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
        } else if (this.jeA) {
            this.jcM.E(this.jcN, this.jcL.e("fail:" + this.jey, null));
        } else {
            this.jcM.E(this.jcN, this.jcL.e("ok", null));
        }
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.fnF = parcel.readString();
        this.jeK = parcel.readString();
        this.fnG = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jeA = z;
        this.jey = parcel.readString();
        this.jeL = parcel.readString();
        this.iEa = parcel.readString();
        this.processName = parcel.readString();
        this.hkD = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fnF);
        parcel.writeString(this.jeK);
        parcel.writeInt(this.fnG);
        parcel.writeInt(this.jeA ? 1 : 0);
        parcel.writeString(this.jey);
        parcel.writeString(this.jeL);
        parcel.writeString(this.iEa);
        parcel.writeString(this.processName);
        parcel.writeString(this.hkD);
    }
}
