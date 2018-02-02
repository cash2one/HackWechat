package com.tencent.a.a.a;

import android.os.IBinder;
import android.os.Parcel;

class b$a$a implements b {
    private IBinder mRemote;

    b$a$a(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public final IBinder asBinder() {
        return this.mRemote;
    }

    public final void onActionResult(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.assistant.sdk.remote.SDKActionCallback");
            obtain.writeByteArray(bArr);
            this.mRemote.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
