package com.tencent.mm.plugin.webview.wepkg.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.wepkg.ipc.IWepkgMainProcessService");
    }

    public static a Z(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.wepkg.ipc.IWepkgMainProcessService");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        switch (i) {
            case 1:
                Message message;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.wepkg.ipc.IWepkgMainProcessService");
                if (parcel.readInt() != 0) {
                    message = (Message) Message.CREATOR.createFromParcel(parcel);
                }
                p(message);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.wepkg.ipc.IWepkgMainProcessService");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                t(bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.wepkg.ipc.IWepkgMainProcessService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
