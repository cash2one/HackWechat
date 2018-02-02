package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public abstract class w$a extends Binder implements w {
    public w$a() {
        attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }

    public static w s(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof w)) ? new a(iBinder) : (w) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = null;
        NodeParcelable nodeParcelable;
        switch (i) {
            case 1:
                DataHolder a;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    g gVar = DataHolder.CREATOR;
                    a = g.a(parcel);
                }
                a(a);
                return true;
            case 2:
                MessageEventParcelable messageEventParcelable;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    messageEventParcelable = (MessageEventParcelable) MessageEventParcelable.CREATOR.createFromParcel(parcel);
                }
                a(messageEventParcelable);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(parcel);
                }
                a(nodeParcelable);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    nodeParcelable = (NodeParcelable) NodeParcelable.CREATOR.createFromParcel(parcel);
                }
                b(nodeParcelable);
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                u(parcel.createTypedArrayList(NodeParcelable.CREATOR));
                return true;
            case 6:
                AncsNotificationParcelable ancsNotificationParcelable;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(parcel);
                }
                a(ancsNotificationParcelable);
                return true;
            case 7:
                ChannelEventParcelable channelEventParcelable;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    channelEventParcelable = (ChannelEventParcelable) ChannelEventParcelable.CREATOR.createFromParcel(parcel);
                }
                a(channelEventParcelable);
                return true;
            case 8:
                CapabilityInfoParcelable capabilityInfoParcelable;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    capabilityInfoParcelable = (CapabilityInfoParcelable) CapabilityInfoParcelable.CREATOR.createFromParcel(parcel);
                }
                a(capabilityInfoParcelable);
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                if (parcel.readInt() != 0) {
                    amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) AmsEntityUpdateParcelable.CREATOR.createFromParcel(parcel);
                }
                a(amsEntityUpdateParcelable);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
