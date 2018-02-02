package com.tencent.mm.ipcinvoker.b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class a$a$a implements a {
    private IBinder mRemote;

    a$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void a(Bundle bundle, String str, b bVar) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (bVar != null) {
                iBinder = bVar.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.mRemote.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public final Bundle d(Bundle bundle, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            Bundle bundle2;
            obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
            } else {
                bundle2 = null;
            }
            obtain2.recycle();
            obtain.recycle();
            return bundle2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
