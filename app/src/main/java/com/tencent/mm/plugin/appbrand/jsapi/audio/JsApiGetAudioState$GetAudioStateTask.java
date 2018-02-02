package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.a.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiGetAudioState$GetAudioStateTask extends MainProcessTask {
    public static final Creator<JsApiGetAudioState$GetAudioStateTask> CREATOR = new 1();
    public String appId = "";
    public int duration = 0;
    public String fnF = "";
    public int fnG;
    public int hQD;
    public int hkC;
    public String hkD;
    public int hkt;
    private e jcL;
    public j jcM;
    public int jcN;
    public boolean jeA = false;
    public String jey;

    public JsApiGetAudioState$GetAudioStateTask(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiGetAudioState$GetAudioStateTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        String str = this.fnF;
        b sVar = new s();
        sVar.fnD.action = 6;
        sVar.fnD.fnF = str;
        a.xef.m(sVar);
        c cVar = sVar.fnE.fnJ;
        if (cVar == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null");
            this.jeA = true;
            this.jey = "return parameter is invalid";
            afp();
        } else if (cVar.duration < 0 || cVar.fnG < 0) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", new Object[]{Integer.valueOf(cVar.duration), Integer.valueOf(cVar.fnG)});
            this.jeA = true;
            this.jey = "return parameter is invalid";
            afp();
        } else {
            this.duration = cVar.duration;
            this.fnG = cVar.fnG;
            this.hQD = cVar.hkA ? 1 : 0;
            this.hkD = cVar.hkD;
            this.hkC = cVar.hkC;
            this.hkt = cVar.hkt;
            x.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", new Object[]{Integer.valueOf(this.duration), Integer.valueOf(this.fnG), Integer.valueOf(this.hQD), Integer.valueOf(this.hkC), this.hkD, Integer.valueOf(this.hkt)});
            afp();
        }
    }

    public final void Ys() {
        if (this.jcM == null) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
        hashMap.put("currentTime", Integer.valueOf(this.fnG));
        hashMap.put("paused", Boolean.valueOf(this.hQD == 1));
        hashMap.put("buffered", Integer.valueOf(this.hkC));
        hashMap.put("src", this.hkD);
        hashMap.put("startTime", Integer.valueOf(this.hkt));
        String str = TextUtils.isEmpty(this.jey) ? "" : this.jey;
        if (this.jeA) {
            x.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", new Object[]{str});
            this.jcM.E(this.jcN, this.jcL.e("fail:" + str, null));
            return;
        }
        this.jcM.E(this.jcN, this.jcL.e("ok", hashMap));
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.fnF = parcel.readString();
        this.duration = parcel.readInt();
        this.fnG = parcel.readInt();
        this.hQD = parcel.readInt();
        this.hkC = parcel.readInt();
        this.hkD = parcel.readString();
        this.hkt = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fnF);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.fnG);
        parcel.writeInt(this.hQD);
        parcel.writeInt(this.hkC);
        parcel.writeString(this.hkD);
        parcel.writeInt(this.hkt);
    }
}
