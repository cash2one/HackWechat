package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.launching.AppBrandTaskUsageRecorder.UpdateTask;

class AppBrandTaskUsageRecorder$UpdateTask$1 implements Creator<UpdateTask> {
    AppBrandTaskUsageRecorder$UpdateTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new UpdateTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new UpdateTask[i];
    }
}
