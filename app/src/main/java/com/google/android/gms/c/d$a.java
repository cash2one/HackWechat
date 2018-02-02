package com.google.android.gms.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class d$a extends Binder implements d {
    public static d n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        String id;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            case 2:
                int i3;
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean at = at(parcel.readInt() != 0);
                parcel2.writeNoException();
                if (at) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                id = aW(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                id = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                g(id, z);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
