package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class JsApiSetAudioState$AudioPlayerEventListenerTask extends MainProcessTask {
    public static final Creator<JsApiSetAudioState$AudioPlayerEventListenerTask> CREATOR = new 1();
    public int action;
    public String appId = "";
    private e jcL;
    public j jcM;
    public int jcN;
    public String jeW;
    private c jft = new 2(this);

    public JsApiSetAudioState$AudioPlayerEventListenerTask(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiSetAudioState$AudioPlayerEventListenerTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.Audio.JsApiSetAudioState", "AudioPlayerEventListenerTask, runInMainProcess");
        com.tencent.mm.plugin.appbrand.media.c.th(this.appId);
        com.tencent.mm.plugin.appbrand.media.c.tf(this.appId);
        com.tencent.mm.plugin.appbrand.media.c.b(this.appId, this.jft);
        com.tencent.mm.plugin.appbrand.media.c.aim();
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
            return;
        }
        x.i("MicroMsg.Audio.JsApiSetAudioState", "AudioPlayerEventListenerTask action:%d, retJson:%s", Integer.valueOf(this.action), this.jeW);
        if (bh.ov(this.jeW)) {
            x.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
            return;
        }
        f a = new a().a(this.jcM);
        a.mData = this.jeW;
        a.afs();
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.jeW = parcel.readString();
        this.action = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.jeW);
        parcel.writeInt(this.action);
    }
}
