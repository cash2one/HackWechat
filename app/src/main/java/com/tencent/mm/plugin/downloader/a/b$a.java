package com.tencent.mm.plugin.downloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b$a extends Binder implements b {
    public b$a() {
        attachInterface(this, "com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
    }

    public static b I(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
            return new a(iBinder);
        }
        return (b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
                d(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
                i(parcel.readString(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
