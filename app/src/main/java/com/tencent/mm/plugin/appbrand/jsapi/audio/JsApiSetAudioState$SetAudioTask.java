package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ac.a;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.a.c;
import com.tencent.mm.sdk.platformtools.x;

class JsApiSetAudioState$SetAudioTask extends MainProcessTask {
    public static final Creator<JsApiSetAudioState$SetAudioTask> CREATOR = new Creator<JsApiSetAudioState$SetAudioTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiSetAudioState$SetAudioTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetAudioState$SetAudioTask[i];
        }
    };
    public String appId = "";
    public String fnF = "";
    public String hkD = "";
    public int hkt = 0;
    public boolean hkv = false;
    public boolean hkw = false;
    public double hky;
    public String iEa;
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    public String jey;
    public String processName = "";

    public JsApiSetAudioState$SetAudioTask(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiSetAudioState$SetAudioTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Audio.JsApiSetAudioState", "runInMainProcess");
        this.jeA = false;
        this.jey = "";
        a iN = b.iN(this.fnF);
        a aVar = new a();
        aVar.fnF = this.fnF;
        aVar.hks = this.hkD;
        aVar.hkt = this.hkt;
        aVar.hku = this.hkt;
        aVar.hkv = this.hkv;
        aVar.hkw = this.hkw;
        aVar.processName = this.processName;
        aVar.hky = this.hky;
        aVar.appId = this.appId;
        aVar.fromScene = 0;
        if (iN != null && this.hkD.equalsIgnoreCase(iN.hks) && b.iL(this.fnF)) {
            com.tencent.mm.sdk.b.b sVar;
            x.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
            x.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", new Object[]{aVar.fnF, aVar.hks});
            sVar = new s();
            sVar.fnD.action = 18;
            sVar.fnD.fnF = aVar.fnF;
            sVar.fnD.fnH = aVar;
            com.tencent.mm.sdk.b.a.xef.m(sVar);
            if (!sVar.fnE.fnI) {
                this.jeA = true;
                this.jey = "not to set audio param, the audioId is err";
                x.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
            }
            afp();
            return;
        }
        x.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", new Object[]{this.appId, this.fnF, this.hkD, Integer.valueOf(this.hkt)});
        if (this.hkD.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            aVar.filePath = this.hkD.substring(9);
            x.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", new Object[]{aVar.filePath});
        } else if (!(this.hkD.startsWith("http://") || this.hkD.startsWith("https://"))) {
            d bu = c.bu(this.hkD, this.iEa);
            if (bu.isOpen()) {
                aVar.filePath = this.hkD;
                aVar.hkz = bu;
            } else {
                this.jeA = true;
                this.jey = "the file not exist for src";
                x.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", new Object[]{this.hkD});
                try {
                    bu.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Audio.JsApiSetAudioState", e, "", new Object[0]);
                }
                afp();
                return;
            }
        }
        afp();
        if (!this.jeA) {
            x.i("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s, src:%s, startTime:%d, fromScene:%d", new Object[]{aVar.fnF, aVar.hks, Integer.valueOf(aVar.hkt), Integer.valueOf(aVar.fromScene)});
            sVar = new s();
            sVar.fnD.action = 0;
            sVar.fnD.fnF = aVar.fnF;
            sVar.fnD.fnH = aVar;
            com.tencent.mm.sdk.b.a.xef.m(sVar);
        }
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
        } else if (this.jeA) {
            this.jcM.E(this.jcN, this.jcL.e("fail:" + this.jey, null));
        } else {
            this.jcM.E(this.jcN, this.jcL.e("ok", null));
        }
    }

    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.appId = parcel.readString();
        this.fnF = parcel.readString();
        this.hkD = parcel.readString();
        this.hkt = parcel.readInt();
        this.hkv = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.hkw = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.jeA = z2;
        this.jey = parcel.readString();
        this.iEa = parcel.readString();
        this.processName = parcel.readString();
        this.hky = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.appId);
        parcel.writeString(this.fnF);
        parcel.writeString(this.hkD);
        parcel.writeInt(this.hkt);
        parcel.writeInt(this.hkv ? 1 : 0);
        if (this.hkw) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.jeA) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.jey);
        parcel.writeString(this.iEa);
        parcel.writeString(this.processName);
        parcel.writeDouble(this.hky);
    }
}
