package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;

class l$a$a implements l {
    private IBinder mRemote;

    l$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
            obtain.writeLong(j);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str);
            obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
