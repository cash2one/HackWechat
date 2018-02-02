package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;

public abstract class ITMAssistantDownloadSDKServiceInterface$Stub extends Binder implements ITMAssistantDownloadSDKServiceInterface {
    private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
    static final int TRANSACTION_cancelDownloadTask = 9;
    static final int TRANSACTION_getDownloadTaskInfo = 6;
    static final int TRANSACTION_getServiceVersion = 1;
    static final int TRANSACTION_isAllDownloadFinished = 5;
    static final int TRANSACTION_pauseDownloadTask = 8;
    static final int TRANSACTION_registerDownloadTaskCallback = 10;
    static final int TRANSACTION_setServiceSetingIsDownloadWifiOnly = 3;
    static final int TRANSACTION_setServiceSetingIsTaskAutoResume = 2;
    static final int TRANSACTION_setServiceSetingMaxTaskNum = 4;
    static final int TRANSACTION_startDownloadTask = 7;
    static final int TRANSACTION_unregisterDownloadTaskCallback = 11;

    public ITMAssistantDownloadSDKServiceInterface$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static ITMAssistantDownloadSDKServiceInterface asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof ITMAssistantDownloadSDKServiceInterface)) {
            return new Proxy(iBinder);
        }
        return (ITMAssistantDownloadSDKServiceInterface) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean z;
        switch (i) {
            case 1:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = getServiceVersion();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                setServiceSetingIsTaskAutoResume(z);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface(DESCRIPTOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                setServiceSetingIsDownloadWifiOnly(z);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface(DESCRIPTOR);
                setServiceSetingMaxTaskNum(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface(DESCRIPTOR);
                boolean isAllDownloadFinished = isAllDownloadFinished();
                parcel2.writeNoException();
                if (isAllDownloadFinished) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface(DESCRIPTOR);
                TMAssistantDownloadTaskInfo downloadTaskInfo = getDownloadTaskInfo(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                if (downloadTaskInfo != null) {
                    parcel2.writeInt(1);
                    downloadTaskInfo.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 7:
                parcel.enforceInterface(DESCRIPTOR);
                i3 = startDownloadTask(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface(DESCRIPTOR);
                pauseDownloadTask(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface(DESCRIPTOR);
                cancelDownloadTask(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface(DESCRIPTOR);
                registerDownloadTaskCallback(parcel.readString(), ITMAssistantDownloadSDKServiceCallback$Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface(DESCRIPTOR);
                unregisterDownloadTaskCallback(parcel.readString(), ITMAssistantDownloadSDKServiceCallback$Stub.asInterface(parcel.readStrongBinder()));
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
