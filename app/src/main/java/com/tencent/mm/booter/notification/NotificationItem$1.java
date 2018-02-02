package com.tencent.mm.booter.notification;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class NotificationItem$1 implements Creator<NotificationItem> {
    NotificationItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new NotificationItem(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new NotificationItem[i];
    }
}
