package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a extends Binder implements a {
    public static a v(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3;
        switch (i) {
            case 1:
                Intent intent;
                Bundle bundle;
                parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                if (parcel.readInt() != 0) {
                    intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                } else {
                    intent = null;
                }
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                boolean a = a(intent, bundle);
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                i3 = getVersion();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.search.verification.api.ISearchActionVerificationService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
