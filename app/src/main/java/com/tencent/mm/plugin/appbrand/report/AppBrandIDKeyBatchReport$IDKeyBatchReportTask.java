package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b;
import com.tencent.mm.protocal.c.cba;
import com.tencent.mm.sdk.platformtools.x;

final class AppBrandIDKeyBatchReport$IDKeyBatchReportTask extends MainProcessTask {
    public static final Creator<AppBrandIDKeyBatchReport$IDKeyBatchReportTask> CREATOR = new Creator<AppBrandIDKeyBatchReport$IDKeyBatchReportTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandIDKeyBatchReport$IDKeyBatchReportTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandIDKeyBatchReport$IDKeyBatchReportTask[i];
        }
    };
    public int jGT;
    int jGU;
    cba jGV;

    AppBrandIDKeyBatchReport$IDKeyBatchReportTask() {
    }

    AppBrandIDKeyBatchReport$IDKeyBatchReportTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        if (1 == this.jGT) {
            b.hc(0);
            b.uj();
        } else if (2 == this.jGT) {
            b.ajM();
        } else if (3 == this.jGT) {
            b.c(this.jGV);
        }
    }

    public final void f(Parcel parcel) {
        this.jGT = parcel.readInt();
        this.jGU = parcel.readInt();
        if (3 == this.jGT) {
            try {
                this.jGV = new cba();
                this.jGV.aF(parcel.createByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", new Object[]{e});
                this.jGV = null;
            }
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jGT);
        parcel.writeInt(this.jGU);
        if (3 == this.jGT) {
            try {
                parcel.writeByteArray(this.jGV.toByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", new Object[]{e});
            }
        }
    }
}
