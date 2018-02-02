package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

class t$a$a implements t {
    private IBinder mRemote;

    t$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void b(long j, int i, int i2, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
            obtain.writeLong(j);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
