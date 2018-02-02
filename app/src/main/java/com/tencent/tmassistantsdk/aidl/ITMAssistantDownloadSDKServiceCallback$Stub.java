package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class ITMAssistantDownloadSDKServiceCallback$Stub extends Binder implements ITMAssistantDownloadSDKServiceCallback {
    private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback";
    static final int TRANSACTION_OnDownloadSDKServiceTaskProgressChanged = 2;
    static final int TRANSACTION_OnDownloadSDKServiceTaskStateChanged = 1;

    public ITMAssistantDownloadSDKServiceCallback$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static ITMAssistantDownloadSDKServiceCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ITMAssistantDownloadSDKServiceCallback)) {
            return new Proxy(iBinder);
        }
        return (ITMAssistantDownloadSDKServiceCallback) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                boolean z;
                boolean z2;
                parcel.enforceInterface(DESCRIPTOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                int readInt2 = parcel.readInt();
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (parcel.readInt() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                OnDownloadSDKServiceTaskStateChanged(readString, readString2, readInt, readInt2, readString3, z, z2);
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                OnDownloadSDKServiceTaskProgressChanged(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
