package com.tencent.mm.plugin.exdevice.service;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mm.plugin.exdevice.service.o.a;

class p$a$a implements p {
    private IBinder mRemote;

    p$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final o aEI() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            o O = a.O(obtain2.readStrongBinder());
            return O;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final l aEJ() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            l N = l.a.N(obtain2.readStrongBinder());
            return N;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
