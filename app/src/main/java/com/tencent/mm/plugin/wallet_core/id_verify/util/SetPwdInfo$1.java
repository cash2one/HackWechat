package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SetPwdInfo$1 implements Creator<SetPwdInfo> {
    SetPwdInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SetPwdInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SetPwdInfo[i];
    }
}
