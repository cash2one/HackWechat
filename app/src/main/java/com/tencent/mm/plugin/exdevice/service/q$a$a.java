package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

class q$a$a implements q {
    private IBinder mRemote;

    q$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
            obtain.writeDouble(d);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeByteArray(bArr);
            obtain.writeDouble(d2);
            obtain.writeInt(i3);
            obtain.writeString(str);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
