package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.av.b;
import com.tencent.mm.av.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.media.d.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;

class JsApiGetMusicPlayerState$GetMusicPlayerState extends MainProcessTask {
    public static final Creator<JsApiGetMusicPlayerState$GetMusicPlayerState> CREATOR = new 1();
    private e jcL;
    private j jcM;
    private int jcN;
    public boolean jeA = false;
    public String jeG;
    public int jeH;
    public String jeI;
    public String jey;
    public int mDuration;
    public int mPosition;
    public int mStatus;

    public JsApiGetMusicPlayerState$GetMusicPlayerState(e eVar, j jVar, int i) {
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
    }

    public JsApiGetMusicPlayerState$GetMusicPlayerState(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        int i = -1;
        String str = a.aio().jzA;
        if (bh.ov(str) || str.equals(this.jeG)) {
            asv Qs = b.Qs();
            if (Qs != null) {
                int i2;
                d Qt = b.Qt();
                if (Qt != null) {
                    i2 = Qt.mDuration;
                    i = Qt.mPosition;
                    this.mStatus = Qt.mStatus;
                    this.jeH = Qt.hHX;
                } else {
                    i2 = -1;
                }
                this.mDuration = i2 / 1000;
                this.mPosition = i / 1000;
                this.jeI = Qs.wAo;
                this.jey = "";
                this.jeA = false;
            } else {
                this.mStatus = 2;
                this.jey = "";
                this.jeA = false;
            }
            x.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", new Object[]{Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.jeH), this.jeI});
            afp();
            return;
        }
        x.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
        this.jeA = true;
        this.jey = "appid not match cannot operate";
        afp();
    }

    public final void Ys() {
        String str;
        Map hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.mDuration));
        hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
        hashMap.put(DownloadInfo.STATUS, Integer.valueOf(this.mStatus));
        hashMap.put("downloadPercent", Integer.valueOf(this.jeH));
        hashMap.put("dataUrl", this.jeI);
        j jVar = this.jcM;
        int i = this.jcN;
        e eVar = this.jcL;
        if (this.jeA) {
            str = "fail" + (TextUtils.isEmpty(this.jey) ? "" : ":" + this.jey);
        } else {
            str = "ok";
        }
        jVar.E(i, eVar.e(str, hashMap));
    }

    public final void f(Parcel parcel) {
        this.jeG = parcel.readString();
        this.jeA = parcel.readByte() != (byte) 0;
        this.mDuration = parcel.readInt();
        this.mPosition = parcel.readInt();
        this.mStatus = parcel.readInt();
        this.jeH = parcel.readInt();
        this.jeI = parcel.readString();
        this.jey = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.jeG);
        parcel.writeByte(this.jeA ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mStatus);
        parcel.writeInt(this.jeH);
        parcel.writeString(this.jeI);
        parcel.writeString(this.jey);
    }
}
