package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public abstract class JsApiAppBrandNFCBase extends a {
    a joL = null;

    private static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Creator<CheckIsSupportHCETask> CREATOR = new Creator<CheckIsSupportHCETask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CheckIsSupportHCETask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckIsSupportHCETask[0];
            }
        };
        private int errCode;
        private String fnL;
        private JsApiAppBrandNFCBase joM = null;

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.joM = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            f(parcel);
        }

        public final void Yr() {
            b ibVar = new ib();
            com.tencent.mm.sdk.b.a.xef.m(ibVar);
            this.errCode = ibVar.fyz.errCode;
            this.fnL = ibVar.fyz.fnL;
            afp();
        }

        public final void Ys() {
            super.Ys();
            c.bk(this);
            if (this.joM != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.joM;
                int i = this.errCode;
                String str = this.fnL;
                x.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
                if (i != 0) {
                    if (bh.ov(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.joL != null) {
                        jsApiAppBrandNFCBase.joL.K(i, str);
                    }
                } else if (jsApiAppBrandNFCBase.joL != null) {
                    jsApiAppBrandNFCBase.joL.K(i, str);
                }
            }
        }

        public int describeContents() {
            return super.describeContents();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.fnL);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.errCode = parcel.readInt();
            this.fnL = parcel.readString();
        }
    }

    protected final void a(a aVar) {
        this.joL = aVar;
        MainProcessTask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        c.bj(checkIsSupportHCETask);
        AppBrandMainProcessService.a(checkIsSupportHCETask);
    }
}
