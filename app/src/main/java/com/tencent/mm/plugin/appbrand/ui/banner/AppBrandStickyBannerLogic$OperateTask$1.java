package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.OperateTask;

class AppBrandStickyBannerLogic$OperateTask$1 implements Creator<OperateTask> {
    AppBrandStickyBannerLogic$OperateTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        OperateTask operateTask = new OperateTask();
        operateTask.f(parcel);
        return operateTask;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new OperateTask[i];
    }
}
