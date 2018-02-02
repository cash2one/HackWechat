package com.tencent.mm.plugin.talkroom.component;

import android.os.IBinder;
import android.os.Parcel;
import com.tencent.mm.plugin.talkroom.component.e.a;

class a$a$a implements a {
    private IBinder mRemote;

    a$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final int bEv() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int uninitLive() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeInt(i3);
            obtain.writeLong(j);
            obtain.writeIntArray(iArr);
            obtain.writeIntArray(iArr2);
            obtain.writeInt(i4);
            this.mRemote.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int SetCurrentMicId(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            obtain.writeInt(i);
            this.mRemote.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final int Close() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            this.mRemote.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            int readInt = obtain2.readInt();
            return readInt;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final byte[] d(int[] iArr, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            if (iArr == null) {
                obtain.writeInt(-1);
            } else {
                obtain.writeInt(iArr.length);
            }
            obtain.writeString(str);
            this.mRemote.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            byte[] createByteArray = obtain2.createByteArray();
            obtain2.readIntArray(iArr);
            return createByteArray;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final e a(c cVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
            this.mRemote.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            e V = a.V(obtain2.readStrongBinder());
            return V;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final d bEw() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            this.mRemote.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            d U = d.a.U(obtain2.readStrongBinder());
            return U;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
