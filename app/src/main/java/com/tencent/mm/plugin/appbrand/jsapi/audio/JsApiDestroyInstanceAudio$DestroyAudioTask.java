package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class JsApiDestroyInstanceAudio$DestroyAudioTask extends MainProcessTask {
    public static final Creator<JsApiDestroyInstanceAudio$DestroyAudioTask> CREATOR = new Creator<JsApiDestroyInstanceAudio$DestroyAudioTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiDestroyInstanceAudio$DestroyAudioTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiDestroyInstanceAudio$DestroyAudioTask[i];
        }
    };
    public String appId = "";
    public String fnF = "";
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;

    public JsApiDestroyInstanceAudio$DestroyAudioTask(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiDestroyInstanceAudio$DestroyAudioTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runInMainProcess");
        x.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", new Object[]{this.fnF});
        b sVar = new s();
        sVar.fnD.action = 5;
        sVar.fnD.fnF = r0;
        a.xef.m(sVar);
        this.jeA = sVar.fnE.fnI;
        afp();
    }

    public final void Ys() {
        x.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runInClientProcess");
        if (this.jcM == null) {
            x.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
        } else if (this.jeA) {
            this.jcM.E(this.jcN, this.jcL.e("fail", null));
        } else {
            this.jcM.E(this.jcN, this.jcL.e("ok", null));
        }
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.fnF = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fnF);
    }
}
