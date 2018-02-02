package com.tencent.mm.booter.notification.queue;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.booter.notification.NotificationItem;
import java.util.Iterator;
import java.util.LinkedList;

public class NotificationQueue$ParcelNotificationQueue extends LinkedList<NotificationItem> implements Parcelable {
    public static final Creator<NotificationQueue$ParcelNotificationQueue> CREATOR = new 1();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            parcel.writeParcelable((NotificationItem) it.next(), 0);
        }
    }
}
