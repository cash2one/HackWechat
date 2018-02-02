package com.tencent.mm.plugin.appbrand.jsapi;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import org.json.JSONObject;

public final class JsApiInstallDownloadTask extends a {
    public static final int CTRL_INDEX = 442;
    public static final String NAME = "installDownloadTask";

    private static class InstallDownloadTask extends MainProcessTask {
        public static final Creator<InstallDownloadTask> CREATOR = new Creator<InstallDownloadTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new InstallDownloadTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new InstallDownloadTask[i];
            }
        };
        private j iqB;
        private boolean jcC;
        private String jcD;
        private long jcE;
        private e jcq;
        private int jcs;

        public InstallDownloadTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jcq = eVar;
            this.iqB = jVar;
            this.jcs = i;
            this.jcE = jSONObject.optLong("downloadId");
            this.jcC = true;
        }

        public InstallDownloadTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            boolean z = true;
            x.i("MicroMsg.JsApiInstallDownloadTask", "doInstallDownloadTask, downloadId = %d", new Object[]{Long.valueOf(this.jcE)});
            if (this.jcE <= 0) {
                this.jcD = "downloadId invalid";
            } else {
                FileDownloadTaskInfo bY = f.aAd().bY(this.jcE);
                if (bY.status == -1) {
                    this.jcD = "fail_apilevel_too_low";
                } else if (bY.status == 3 && e.bO(bY.path)) {
                    if (q.e(ac.getContext(), Uri.fromFile(new File(bY.path)))) {
                        z = false;
                    }
                    this.jcC = z;
                }
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
        AppBrandMainProcessService.a(new InstallDownloadTask(this, jVar, i, jSONObject));
    }
}
