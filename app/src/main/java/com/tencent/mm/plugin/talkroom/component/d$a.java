package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class d$a extends Binder implements d {
    public d$a() {
        attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
    }

    public static d U(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
            return new a(iBinder);
        }
        return (d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                bEx();
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                bEy();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                release();
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                int bEz = bEz();
                parcel2.writeNoException();
                parcel2.writeInt(bEz);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                start();
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
