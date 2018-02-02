package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b$a extends Binder implements b {
    public b$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
    }

    public static b W(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
            return new a(iBinder);
        }
        return (b) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = 0;
        boolean bRJ;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                bRJ = bRJ();
                parcel2.writeNoException();
                if (bRJ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                bRJ = getResult();
                parcel2.writeNoException();
                if (bRJ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                i3 = getRet();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                i3 = getType();
                parcel2.writeNoException();
                parcel2.writeInt(i3);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
