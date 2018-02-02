package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.talkroom.component.b.a.a;

public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
    }

    public static a T(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int bEv;
        IBinder readStrongBinder;
        IInterface queryLocalInterface;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                bEv = bEv();
                parcel2.writeNoException();
                parcel2.writeInt(bEv);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                bEv = uninitLive();
                parcel2.writeNoException();
                parcel2.writeInt(bEv);
                return true;
            case 3:
                b bVar;
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    bVar = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    bVar = (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(readStrongBinder) : (b) queryLocalInterface;
                }
                bEv = a(bVar, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(bEv);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                bEv = SetCurrentMicId(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(bEv);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                bEv = Close();
                parcel2.writeNoException();
                parcel2.writeInt(bEv);
                return true;
            case 6:
                int[] iArr;
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                bEv = parcel.readInt();
                if (bEv < 0) {
                    iArr = null;
                } else {
                    iArr = new int[bEv];
                }
                byte[] d = d(iArr, parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(d);
                parcel2.writeIntArray(iArr);
                return true;
            case 7:
                c cVar;
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    cVar = null;
                } else {
                    queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    cVar = (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new c.a.a(readStrongBinder) : (c) queryLocalInterface;
                }
                e a = a(cVar);
                parcel2.writeNoException();
                parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                d bEw = bEw();
                parcel2.writeNoException();
                parcel2.writeStrongBinder(bEw != null ? bEw.asBinder() : null);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
