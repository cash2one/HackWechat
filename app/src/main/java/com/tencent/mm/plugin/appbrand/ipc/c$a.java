package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class c$a extends Binder implements c {
    public c$a() {
        attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    }

    public static c G(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new a(iBinder);
        }
        return (c) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                s(bundle);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                t(bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                a(parcel.readStrongBinder(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
