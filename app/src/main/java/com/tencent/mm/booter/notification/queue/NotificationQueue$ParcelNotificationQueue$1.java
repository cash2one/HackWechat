package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue;

class NotificationQueue$ParcelNotificationQueue$1 implements Creator<ParcelNotificationQueue> {
    NotificationQueue$ParcelNotificationQueue$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ParcelNotificationQueue parcelNotificationQueue = new ParcelNotificationQueue();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            parcelNotificationQueue.add((NotificationItem) parcel.readParcelable(NotificationItem.class.getClassLoader()));
        }
        return parcelNotificationQueue;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ParcelNotificationQueue[i];
    }
}
