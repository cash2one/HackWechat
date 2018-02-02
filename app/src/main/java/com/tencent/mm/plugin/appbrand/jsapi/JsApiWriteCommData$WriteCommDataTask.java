package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

class JsApiWriteCommData$WriteCommDataTask extends MainProcessTask {
    public static final Creator<JsApiWriteCommData$WriteCommDataTask> CREATOR = new 1();
    private j iqB;
    private boolean jcC;
    private String jcD;
    private e jcq;
    private int jcs;
    private String mData;
    private String mPackageName;

    public JsApiWriteCommData$WriteCommDataTask(e eVar, j jVar, int i, JSONObject jSONObject) {
        this.jcq = eVar;
        this.iqB = jVar;
        this.jcs = i;
        this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        this.mData = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
        this.jcC = true;
    }

    public JsApiWriteCommData$WriteCommDataTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        boolean z = false;
        if (bh.ov(this.mPackageName)) {
            x.e("MicroMsg.JsApiWriteCommData", "packageName nil");
        } else {
            if (!ac.getContext().getSharedPreferences(ac.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
                z = true;
            }
            this.jcC = z;
        }
        afp();
    }

    public final void Ys() {
        if (this.jcC) {
            String str;
            if (bh.ov(this.jcD)) {
                str = "fail";
            } else {
                str = String.format("fail:%s", new Object[]{this.jcD});
            }
            this.iqB.E(this.jcs, this.jcq.e(str, null));
            return;
        }
        this.iqB.E(this.jcs, this.jcq.e("ok", null));
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.mPackageName = parcel.readString();
        this.mData = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jcC = z;
        this.jcD = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mData);
        parcel.writeInt(this.jcC ? 1 : 0);
        parcel.writeString(this.jcD);
    }
}
