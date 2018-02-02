package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

class p$a$a implements p {
    private IBinder aFi;

    p$a$a(IBinder iBinder) {
        this.aFi = iBinder;
    }

    public final IBinder asBinder() {
        return this.aFi;
    }

    public final Account oE() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
            this.aFi.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Account account = obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
            obtain2.recycle();
            obtain.recycle();
            return account;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
