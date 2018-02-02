package com.tencent.mm.plugin.talkroom.component;

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

    public final void j(int i, int i2, boolean z) {
        int i3 = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
            obtain.writeInt(i);
            obtain.writeInt(i2);
            if (!z) {
                i3 = 0;
            }
            obtain.writeInt(i3);
            this.mRemote.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
