package com.tencent.mm.plugin.sport.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
    }

    public static a S(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        long bDh;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                bDh = bDh();
                parcel2.writeNoException();
                parcel2.writeLong(bDh);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                Mg(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                bDi();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                J(parcel.readInt(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                bDh = getLong(parcel.readInt(), parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeLong(bDh);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                bDj();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
