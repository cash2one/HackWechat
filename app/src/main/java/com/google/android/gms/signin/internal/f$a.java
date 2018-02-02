package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.signin.internal.e.a;

public abstract class f$a extends Binder implements f {
    public static f p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new a(iBinder) : (f) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        t tVar = null;
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt() != 0 ? (AuthAccountRequest) AuthAccountRequest.CREATOR.createFromParcel(parcel) : null, a.o(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt() != 0 ? (CheckServerAuthResult) CheckServerAuthResult.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                au(z);
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                ResolveAccountRequest resolveAccountRequest = parcel.readInt() != 0 ? (ResolveAccountRequest) ResolveAccountRequest.CREATOR.createFromParcel(parcel) : null;
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                    tVar = (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new t.a.a(readStrongBinder) : (t) queryLocalInterface;
                }
                a(resolveAccountRequest, tVar);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                dL(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt(), parcel.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(parcel) : null, a.o(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                p g = p.a.g(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                a(g, readInt, z);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(parcel.readInt() != 0 ? (RecordConsentRequest) RecordConsentRequest.CREATOR.createFromParcel(parcel) : null, a.o(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
                a(a.o(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
