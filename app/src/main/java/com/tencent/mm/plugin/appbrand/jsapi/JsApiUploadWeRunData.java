package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.protocal.c.bqr;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bu;
import org.json.JSONObject;

public class JsApiUploadWeRunData extends a {
    public static final int CTRL_INDEX = 323;
    public static final String NAME = "uploadWeRunData";
    private UploadMiniAppStepTask jeq;

    private static class UploadMiniAppStepTask extends MainProcessTask {
        public static final Creator<UploadMiniAppStepTask> CREATOR = new 2();
        private String appId;
        private boolean frp;
        private e jcL;
        private j jcM;
        private int jcN;
        private int jer;
        private boolean jes;

        public UploadMiniAppStepTask(e eVar, j jVar, int i, int i2, boolean z) {
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
            this.jcL = eVar;
            this.jcM = jVar;
            this.jcN = i;
            this.jer = i2;
            this.jes = z;
            this.appId = jVar.mAppId;
        }

        public UploadMiniAppStepTask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            long Ie = bu.Ie();
            x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[]{Long.valueOf(Ie / 1000)});
            if (Ie == 0) {
                Ie = System.currentTimeMillis();
            }
            a aVar = new a();
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_bqr = new bqr();
            aVar.hmj = com_tencent_mm_protocal_c_bqr;
            aVar.hmk = new bqs();
            aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
            aVar.hmi = 1949;
            aVar.hml = 0;
            aVar.hmm = 0;
            com_tencent_mm_protocal_c_bqr.ngo = this.appId;
            com_tencent_mm_protocal_c_bqr.ktL = this.jer;
            com_tencent_mm_protocal_c_bqr.wSe = this.jes;
            com_tencent_mm_protocal_c_bqr.nhw = (int) (Ie / 1000);
            u.a(aVar.JZ(), new 1(this), true);
        }

        public final void Ys() {
            if (this.frp) {
                this.jcM.E(this.jcN, this.jcL.e("ok", null));
            } else {
                this.jcM.E(this.jcN, this.jcL.e("fail", null));
            }
            afj();
        }

        public final void f(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.jer = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.jes = z;
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.frp = z2;
            this.appId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            byte b;
            byte b2 = (byte) 1;
            parcel.writeInt(this.jer);
            if (this.jes) {
                b = (byte) 1;
            } else {
                b = (byte) 0;
            }
            parcel.writeByte(b);
            if (!this.frp) {
                b2 = (byte) 0;
            }
            parcel.writeByte(b2);
            parcel.writeString(this.appId);
        }
    }

    public void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiUploadWeRunData", "JsApiUploadWeRunData!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiUploadWeRunData", "data is null");
            return;
        }
        a(this, jVar, i, jSONObject.optInt("step"), false);
    }

    public final void a(e eVar, j jVar, int i, int i2, boolean z) {
        if (i2 <= 0) {
            jVar.E(i, eVar.e("fail:step invalid", null));
            return;
        }
        this.jeq = new UploadMiniAppStepTask(eVar, jVar, i, i2, z);
        this.jeq.afi();
        AppBrandMainProcessService.a(this.jeq);
    }
}
