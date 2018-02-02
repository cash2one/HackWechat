package com.tencent.a.a.a;

import android.os.IBinder;
import android.os.Parcel;

class a$a$a implements a {
    private IBinder mRemote;

    a$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final int a(String str, String str2, b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int a(b bVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final byte[] b(String str, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final void c(String str, byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.assistant.sdk.remote.BaseService");
            obtain.writeString(str);
            obtain.writeByteArray(bArr);
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
