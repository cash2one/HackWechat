package com.tencent.mm.pluginsdk.model.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;

class ReportUtil$ReportArgs$1 implements Creator<ReportArgs> {
    ReportUtil$ReportArgs$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ReportArgs(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ReportArgs[i];
    }
}
