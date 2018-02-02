package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiStartRecordVoice$StartRecordVoice extends MainProcessTask {
    public static final Creator<JsApiStartRecordVoice$StartRecordVoice> CREATOR = new 2();
    private String appId;
    private int duration;
    private String filePath;
    private j jcM;
    private int jcN;
    private JsApiStartRecordVoice jfI;
    private boolean jfJ = false;
    private int result;

    JsApiStartRecordVoice$StartRecordVoice(JsApiStartRecordVoice jsApiStartRecordVoice, j jVar, int i, int i2) {
        this.jfI = jsApiStartRecordVoice;
        this.jcM = jVar;
        this.duration = i;
        this.jcN = i2;
        this.appId = jVar.mAppId;
        this.filePath = AppBrandLocalMediaObjectManager.genMediaFilePath(this.appId, u.oe(this.appId));
    }

    JsApiStartRecordVoice$StartRecordVoice(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        c.Dm().F(new 1(this));
    }

    public final void Ys() {
        if (this.result == -1) {
            x.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
            this.jcM.E(this.jcN, this.jfI.e("fail:record_error", null));
            return;
        }
        if (this.jfJ) {
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.jcM.mAppId, this.filePath, "silk", true);
            if (attach != null) {
                Map hashMap = new HashMap(1);
                hashMap.put("tempFilePath", attach.fus);
                this.jcM.E(this.jcN, this.jfI.e("ok", hashMap));
                x.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.jfJ)});
                JsApiStartRecordVoice.a(this.jfI, false);
            }
        }
        this.jcM.E(this.jcN, this.jfI.e("fail", null));
        x.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[]{this.appId, Boolean.valueOf(this.jfJ)});
        JsApiStartRecordVoice.a(this.jfI, false);
    }

    public final void f(Parcel parcel) {
        this.jcN = parcel.readInt();
        this.appId = parcel.readString();
        this.filePath = parcel.readString();
        this.jfJ = parcel.readByte() != (byte) 0;
        this.duration = parcel.readInt();
        this.result = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jcN);
        parcel.writeString(this.appId);
        parcel.writeString(this.filePath);
        parcel.writeByte(this.jfJ ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.result);
    }
}
