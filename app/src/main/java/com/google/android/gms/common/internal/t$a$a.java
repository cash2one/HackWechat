package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

class t$a$a implements t {
    private IBinder aFi;

    public t$a$a(IBinder iBinder) {
        this.aFi = iBinder;
    }

    public final void a(ResolveAccountResponse resolveAccountResponse) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IResolveAccountCallbacks");
            if (resolveAccountResponse != null) {
                obtain.writeInt(1);
                resolveAccountResponse.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.aFi.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.aFi;
    }
}
