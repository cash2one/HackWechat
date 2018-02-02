package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class c$a extends Binder implements c {
    public c$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int type;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                type = getType();
                parcel2.writeNoException();
                parcel2.writeInt(type);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                type = bRK();
                parcel2.writeNoException();
                parcel2.writeInt(type);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                type = bRL();
                parcel2.writeNoException();
                parcel2.writeInt(type);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                String KM = KM();
                parcel2.writeNoException();
                parcel2.writeString(KM);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                Bundle data = getData();
                parcel2.writeNoException();
                if (data != null) {
                    parcel2.writeInt(1);
                    data.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
