package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

class w$a$a implements w {
    private IBinder aFi;

    w$a$a(IBinder iBinder) {
        this.aFi = iBinder;
    }

    public final void a(DataHolder dataHolder) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (dataHolder != null) {
                obtain.writeInt(1);
                dataHolder.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (amsEntityUpdateParcelable != null) {
                obtain.writeInt(1);
                amsEntityUpdateParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(9, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (ancsNotificationParcelable != null) {
                obtain.writeInt(1);
                ancsNotificationParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(6, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (capabilityInfoParcelable != null) {
                obtain.writeInt(1);
                capabilityInfoParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(8, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (channelEventParcelable != null) {
                obtain.writeInt(1);
                channelEventParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(7, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (messageEventParcelable != null) {
                obtain.writeInt(1);
                messageEventParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (nodeParcelable != null) {
                obtain.writeInt(1);
                nodeParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.aFi;
    }

    public final void b(NodeParcelable nodeParcelable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            if (nodeParcelable != null) {
                obtain.writeInt(1);
                nodeParcelable.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(4, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final void u(List<NodeParcelable> list) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
            obtain.writeTypedList(list);
            this.aFi.transact(5, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
