package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class AppBrandOpReportLogic {

    public static final class AppBrandOnOpReportStartEvent implements Parcelable {
        public static final Creator<AppBrandOnOpReportStartEvent> CREATOR = new 1();
        String appId;

        public static void sG(String str) {
            Parcelable appBrandOnOpReportStartEvent = new AppBrandOnOpReportStartEvent();
            appBrandOnOpReportStartEvent.appId = str;
            d.a(appBrandOnOpReportStartEvent);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
        }

        AppBrandOnOpReportStartEvent() {
        }

        AppBrandOnOpReportStartEvent(Parcel parcel) {
            this.appId = parcel.readString();
        }
    }
}
