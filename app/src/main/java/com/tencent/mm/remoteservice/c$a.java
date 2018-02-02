package com.tencent.mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.remoteservice.b.a;

public abstract class c$a extends Binder implements c {
    public c$a() {
        attachInterface(this, "com.tencent.mm.remoteservice.ICommRemoteServer");
    }

    public static c ac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new a(iBinder);
        }
        return (c) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Bundle bundle;
                parcel.enforceInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                a(readString, readString2, bundle, a.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.remoteservice.ICommRemoteServer");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
