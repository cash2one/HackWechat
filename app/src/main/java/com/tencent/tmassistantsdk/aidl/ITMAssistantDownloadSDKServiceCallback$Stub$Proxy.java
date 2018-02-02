package com.tencent.tmassistantsdk.aidl;

import android.os.IBinder;
import android.os.Parcel;

class ITMAssistantDownloadSDKServiceCallback$Stub$Proxy implements ITMAssistantDownloadSDKServiceCallback {
    private IBinder mRemote;

    ITMAssistantDownloadSDKServiceCallback$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
    }

    public void OnDownloadSDKServiceTaskStateChanged(String str, String str2, int i, int i2, String str3, boolean z, boolean z2) {
        int i3 = 1;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            obtain.writeString(str3);
            obtain.writeInt(z ? 1 : 0);
            if (!z2) {
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

    public void OnDownloadSDKServiceTaskProgressChanged(String str, String str2, long j, long j2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeLong(j);
            obtain.writeLong(j2);
            this.mRemote.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
