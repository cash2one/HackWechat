package com.tencent.wcdb;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;

class IContentObserver$Stub$Proxy implements IContentObserver {
    private IBinder mRemote;

    IContentObserver$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "com.tencent.wcdb.IContentObserver";
    }

    public void onChange(boolean z, Uri uri) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.wcdb.IContentObserver");
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            if (uri != null) {
                obtain.writeInt(1);
                uri.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.mRemote.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
