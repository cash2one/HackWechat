package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiAddDownloadTaskStraight extends a {
    public static final int CTRL_INDEX = 440;
    public static final String NAME = "addDownloadTaskStraight";

    private static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Creator<AddDownloadTaskStraightTask> CREATOR = new Creator<AddDownloadTaskStraightTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AddDownloadTaskStraightTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AddDownloadTaskStraightTask[i];
            }
        };
        private j iqB;
        private String jcA;
        private String jcB;
        private boolean jcC;
        private String jcD;
        private long jcE;
        private e jcq;
        private int jcs;
        private String jcv;
        private String jcw;
        private String jcx;
        private String jcy;
        private long jcz;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTaskStraightTask(e eVar, j jVar, int i, JSONObject jSONObject) {
            this.jcq = eVar;
            this.iqB = jVar;
            this.jcs = i;
            this.jcv = jSONObject.optString("taskName");
            this.jcw = jSONObject.optString("taskUrl");
            this.jcx = jSONObject.optString("fileMd5");
            this.jcy = jSONObject.optString("alternativeUrl");
            this.jcz = (long) jSONObject.optInt("taskSize", 0);
            this.jcA = jSONObject.optString("extInfo");
            this.jcB = jSONObject.optString("fileType");
            this.mAppId = jVar.mAppId;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.jcC = true;
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            g.Dk();
            if (!g.Dj().isSDCardAvailable()) {
                this.jcD = "fail_sdcard_not_ready";
            } else if (this.jcz > 0 && !f.aC(this.jcz)) {
                this.jcD = "fail_sdcard_has_not_enough_space";
            } else if (bh.ov(this.jcw)) {
                this.jcD = "fail_invalid_url";
            } else {
                x.i("MicroMsg.JsApiAddDownloadTaskStraight", "runInMainProcess taskUrl:%s md5:%s", new Object[]{this.jcw, this.jcx});
                a aVar = new a();
                aVar.xL(this.jcw);
                aVar.xM(this.jcy);
                aVar.ci(this.jcz);
                aVar.xN(this.jcv);
                aVar.xO(this.jcx);
                aVar.setAppId(this.mAppId);
                aVar.cu(this.mPackageName);
                aVar.ep(true);
                aVar.ox(bh.getInt(this.jcB, 1));
                aVar.lw(6001);
                long a = com.tencent.mm.plugin.downloader.model.f.aAd().a(aVar.lsE);
                x.i("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight, downloadId = " + a);
                if (a <= 0) {
                    x.e("MicroMsg.JsApiAddDownloadTaskStraight", "doAddDownloadTaskStraight fail, downloadId = " + a);
                    this.jcD = "";
                } else {
                    this.jcC = false;
                    this.jcE = a;
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
            Map hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.jcE));
            this.iqB.E(this.jcs, this.jcq.e("ok", hashMap));
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.jcv = parcel.readString();
            this.jcw = parcel.readString();
            this.jcx = parcel.readString();
            this.jcy = parcel.readString();
            this.jcz = parcel.readLong();
            this.jcA = parcel.readString();
            this.jcB = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.jcC = z;
            this.jcD = parcel.readString();
            this.jcE = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.jcv);
            parcel.writeString(this.jcw);
            parcel.writeString(this.jcx);
            parcel.writeString(this.jcy);
            parcel.writeLong(this.jcz);
            parcel.writeString(this.jcA);
            parcel.writeString(this.jcB);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.jcC ? 1 : 0);
            parcel.writeString(this.jcD);
            parcel.writeLong(this.jcE);
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(this, jVar, i, jSONObject));
    }
}
