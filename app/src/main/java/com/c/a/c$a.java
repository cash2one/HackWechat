package com.c.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.c.a.b.a;

public abstract class c$a extends Binder implements c {
    public static c x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
            return new a(iBinder);
        }
        return (c) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean a;
        int[] c;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = a(a.w(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = a(a.w(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a(a.w(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                b(a.w(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = c(a.w(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 6:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = rQ();
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 7:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = ec(parcel.readInt());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = ed(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 9:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                a = bp(parcel.readString());
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                String b = b(a.w(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 11:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                c = c(a.w(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeIntArray(c);
                return true;
            case 12:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = d(a.w(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 13:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                b w = a.w(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    a = true;
                } else {
                    a = false;
                }
                a = a(w, readInt, a);
                parcel2.writeNoException();
                if (a) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 14:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                long d = d(a.w(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeLong(d);
                return true;
            case 15:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                i3 = a(a.w(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 16:
                parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                byte[] e = e(a.w(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeByteArray(e);
                return true;
            case 1598968902:
                parcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
