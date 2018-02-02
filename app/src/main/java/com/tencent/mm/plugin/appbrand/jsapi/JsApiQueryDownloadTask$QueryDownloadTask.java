package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class JsApiQueryDownloadTask$QueryDownloadTask extends MainProcessTask {
    public static final Creator<JsApiQueryDownloadTask$QueryDownloadTask> CREATOR = new 1();
    private j iqB;
    private boolean jcC;
    private String jcD;
    private long jcE;
    private e jcq;
    private int jcs;
    private String jdO;
    private long jdP;

    public JsApiQueryDownloadTask$QueryDownloadTask(e eVar, j jVar, int i, JSONObject jSONObject) {
        this.jcq = eVar;
        this.iqB = jVar;
        this.jcs = i;
        this.jcE = jSONObject.optLong("downloadId");
        this.jcC = true;
    }

    public JsApiQueryDownloadTask$QueryDownloadTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.jcE)});
        if (this.jcE <= 0) {
            this.jcD = "downloadId invalid";
        } else {
            FileDownloadTaskInfo bY = f.aAd().bY(this.jcE);
            switch (bY.status) {
                case -1:
                    this.jcD = "fail_apilevel_too_low";
                    break;
                case 1:
                    this.jdO = "downloading";
                    break;
                case 2:
                    this.jdO = "download_pause";
                    break;
                case 3:
                    if (!e.bO(bY.path)) {
                        this.jdO = "default";
                        break;
                    } else {
                        this.jdO = "download_succ";
                        break;
                    }
                case 4:
                    this.jdO = "download_fail";
                    break;
                default:
                    this.jdO = "default";
                    break;
            }
            x.i("MicroMsg.JsApiQueryDownloadTask", "doQueryDownloadTask, state = %s", new Object[]{this.jdO});
            if (this.jdO == "downloading" && bY.fwg != 0) {
                this.jdP = (long) ((((float) bY.fwf) / ((float) bY.fwg)) * 100.0f);
            }
            this.jcC = false;
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
        Map hashMap = new HashMap();
        hashMap.put("downloadId", Long.valueOf(this.jcE));
        hashMap.put("state", this.jdO);
        hashMap.put("progress", Long.valueOf(this.jdP));
        this.iqB.E(this.jcs, this.jcq.e("ok", hashMap));
    }

    public final void f(Parcel parcel) {
        boolean z = true;
        this.jcE = parcel.readLong();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.jcC = z;
        this.jcD = parcel.readString();
        this.jdO = parcel.readString();
        this.jdP = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.jcE);
        parcel.writeInt(this.jcC ? 1 : 0);
        parcel.writeString(this.jcD);
        parcel.writeString(this.jdO);
        parcel.writeLong(this.jdP);
    }
}
