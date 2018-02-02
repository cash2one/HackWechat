package com.tencent.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {
        public static a y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.assistant.sdk.remote.BaseService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
                    a = a(parcel.readString(), parcel.readString(), com.tencent.a.a.a.b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
                    a = a(com.tencent.a.a.a.b.a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
                    byte[] b = b(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(b);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.assistant.sdk.remote.BaseService");
                    c(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.assistant.sdk.remote.BaseService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(b bVar);

    int a(String str, String str2, b bVar);

    byte[] b(String str, byte[] bArr);

    void c(String str, byte[] bArr);
}
