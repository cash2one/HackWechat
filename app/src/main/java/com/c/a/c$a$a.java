package com.c.a;

import android.os.IBinder;
import android.os.Parcel;

class c$a$a implements c {
    private IBinder mRemote;

    c$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final boolean a(b bVar, int i) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int a(b bVar, int[] iArr, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeIntArray(iArr);
            obtain.writeByteArray(bArr);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void a(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void b(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] c(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] rQ() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            this.mRemote.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean ec(int i) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeInt(i);
            this.mRemote.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int ed(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeInt(i);
            this.mRemote.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean bp(String str) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeString(str);
            this.mRemote.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            obtain2.recycle();
            obtain.recycle();
            return z;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final String b(b bVar, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            this.mRemote.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int[] c(b bVar, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            this.mRemote.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            int[] createIntArray = obtain2.createIntArray();
            return createIntArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int d(b bVar, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            this.mRemote.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final boolean a(b bVar, int i, boolean z) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            int i2;
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            if (z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            obtain.writeInt(i2);
            this.mRemote.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            obtain2.recycle();
            obtain.recycle();
            return z2;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final long d(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            long readLong = obtain2.readLong();
            return readLong;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int a(b bVar, int[] iArr, byte[] bArr, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeIntArray(iArr);
            obtain.writeByteArray(bArr);
            obtain.writeInt(i);
            this.mRemote.transact(15, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final byte[] e(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(16, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
