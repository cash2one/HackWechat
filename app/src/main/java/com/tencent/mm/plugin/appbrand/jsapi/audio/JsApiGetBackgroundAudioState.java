package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    private static class GetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<GetBackgroundAudioStateTask> CREATOR = new Creator<GetBackgroundAudioStateTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetBackgroundAudioStateTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetBackgroundAudioStateTask[i];
            }
        };
        public String appId = "";
        public int duration = 0;
        public int fnG;
        public int hQD;
        public int hkC;
        public String hkD;
        public int hkt;
        private e jcL;
        public j jcM;
        public int jcN;
        public boolean jeA = false;
        public String jeB;
        public String jeC;
        public String jeD;
        public String jeE;
        public String jey;
        public String protocol;
        public String title;

        public GetBackgroundAudioStateTask(e eVar, j jVar, int i) {
            this.jcL = eVar;
            this.jcM = jVar;
            this.jcN = i;
        }

        public GetBackgroundAudioStateTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            int i = -1;
            String str = d.a.aio().jzA;
            if (bh.ov(str) || str.equals(this.appId)) {
                asv Qs = b.Qs();
                if (Qs != null) {
                    int i2;
                    com.tencent.mm.av.d Qt = b.Qt();
                    if (Qt != null) {
                        i2 = Qt.mDuration;
                        i = Qt.mPosition;
                    } else {
                        i2 = -1;
                    }
                    if (Qt == null || i2 < 0 || i < 0) {
                        x.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                        this.jeA = true;
                        this.jey = "return parameter is invalid";
                        afp();
                        return;
                    }
                    i2 /= 1000;
                    int i3 = i / 1000;
                    int i4 = Qt.mStatus;
                    i = Qt.hHX;
                    if (i2 > 0) {
                        i = (i * i2) / 100;
                    } else {
                        i = 0;
                    }
                    this.duration = i2;
                    this.fnG = i3;
                    this.hQD = i4 == 1 ? 0 : 1;
                    this.hkD = Qs.wAo;
                    this.hkC = i;
                    this.title = Qs.wAk;
                    this.jeB = Qs.wAm;
                    this.jeC = Qs.wAl;
                    this.jeD = Qs.wAn;
                    this.jeE = Qs.wAq;
                    this.protocol = Qs.protocol;
                    this.hkt = Qs.hkt;
                    x.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", new Object[]{Integer.valueOf(this.duration), Integer.valueOf(this.fnG), Integer.valueOf(this.hQD), Integer.valueOf(this.hkC), this.hkD, Integer.valueOf(this.hkt), this.title, this.jeC, this.jeE, this.jeD, this.protocol});
                } else {
                    x.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                    this.jeA = true;
                    this.jey = "currentWrapper is null";
                }
                afp();
                return;
            }
            x.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", new Object[]{str, this.appId});
            this.jeA = true;
            this.jey = "appid not match cannot get background audio state";
            afp();
        }

        public final void Ys() {
            if (this.jcM == null) {
                x.e("MicroMsg.JsApiGetBackgroundAudioState", "service is null");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
            hashMap.put("currentTime", Integer.valueOf(this.fnG));
            hashMap.put("paused", Boolean.valueOf(this.hQD == 1));
            hashMap.put("buffered", Integer.valueOf(this.hkC));
            hashMap.put("src", this.hkD);
            hashMap.put("title", this.title);
            hashMap.put("epname", this.jeB);
            hashMap.put("singer", this.jeC);
            hashMap.put("coverImgUrl", this.jeD);
            hashMap.put("webUrl", this.jeE);
            hashMap.put("protocol", this.protocol == null ? "" : this.protocol);
            hashMap.put("startTime", Integer.valueOf(this.hkt / 1000));
            String str = TextUtils.isEmpty(this.jey) ? "" : this.jey;
            if (this.jeA) {
                x.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", new Object[]{str});
            } else {
                x.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
            }
            j jVar = this.jcM;
            int i = this.jcN;
            e eVar = this.jcL;
            if (this.jeA) {
                str = "fail:" + str;
            } else {
                str = "ok";
            }
            jVar.E(i, eVar.e(str, hashMap));
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.duration = parcel.readInt();
            this.fnG = parcel.readInt();
            this.hQD = parcel.readInt();
            this.hkC = parcel.readInt();
            this.hkD = parcel.readString();
            this.title = parcel.readString();
            this.jeB = parcel.readString();
            this.jeC = parcel.readString();
            this.jeD = parcel.readString();
            this.jeE = parcel.readString();
            this.protocol = parcel.readString();
            this.hkt = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.duration);
            parcel.writeInt(this.fnG);
            parcel.writeInt(this.hQD);
            parcel.writeInt(this.hkC);
            parcel.writeString(this.hkD);
            parcel.writeString(this.title);
            parcel.writeString(this.jeB);
            parcel.writeString(this.jeC);
            parcel.writeString(this.jeD);
            parcel.writeString(this.jeE);
            parcel.writeString(this.protocol);
            parcel.writeInt(this.hkt);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        String str = jVar.mAppId;
        MainProcessTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(this, jVar, i);
        getBackgroundAudioStateTask.appId = str;
        AppBrandMainProcessService.a(getBackgroundAudioStateTask);
    }
}
