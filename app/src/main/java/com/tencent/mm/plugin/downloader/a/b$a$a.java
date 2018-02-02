package com.tencent.mm.plugin.downloader.a;

import android.os.IBinder;
import android.os.Parcel;

class b$a$a implements b {
    private IBinder mRemote;

    b$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void d(String str, int i, int i2, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str2);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void i(String str, long j, long j2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.downloader.aidl.ICDNDownloadServiceCallback");
            obtain.writeString(str);
            obtain.writeLong(j);
            obtain.writeLong(j2);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
