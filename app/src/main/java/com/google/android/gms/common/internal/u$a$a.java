package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.a;

class u$a$a implements u {
    private IBinder aFi;

    u$a$a(IBinder iBinder) {
        this.aFi = iBinder;
    }

    public final a a(a aVar, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.aFi.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            a k = a.a.k(obtain2.readStrongBinder());
            return k;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.aFi;
    }
}
