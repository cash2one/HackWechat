package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class JsApiPauseDownloadTask extends a {
    public static final int CTRL_INDEX = 443;
    public static final String NAME = "pauseDownloadTask";

    private static class PauseDownloadTask extends MainProcessTask {
        public static final Creator<PauseDownloadTask> CREATOR = new 1();
        private j iqB;
        private boolean jcC;
        private String jcD;
        private long jcE;
        private e jcq;
        private int jcs;

        public PauseDownloadTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jcq = eVar;
            this.iqB = jVar;
            this.jcs = i;
            this.jcE = jSONObject.optLong("downloadId");
            this.jcC = true;
        }

        public PauseDownloadTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            boolean z = true;
            x.i("MicroMsg.JsApiPauseDownloadTask", "doQueryDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.jcE)});
            if (this.jcE <= 0) {
                this.jcD = "downloadId invalid";
            } else {
                if (f.aAd().bZ(this.jcE)) {
                    z = false;
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
            this.jcE = parcel.readLong();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jcC = z;
            this.jcD = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.jcE);
            parcel.writeInt(this.jcC ? 1 : 0);
            parcel.writeString(this.jcD);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new PauseDownloadTask(this, jVar, i, jSONObject));
    }
}
