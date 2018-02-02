package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class e$a extends Binder implements e {
    public e$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
    }

    public static e Y(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
            return new a(iBinder);
        }
        return (e) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        boolean z = false;
        boolean Ar;
        int readInt;
        boolean n;
        int i3;
        String bRM;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                Ar = Ar(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(Ar ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                n = n(readInt, bundle);
                parcel2.writeNoException();
                if (n) {
                    readInt = 1;
                } else {
                    readInt = 0;
                }
                parcel2.writeInt(readInt);
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 3:
                c com_tencent_mm_plugin_webview_stub_c_a_a;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                    com_tencent_mm_plugin_webview_stub_c_a_a = (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new c$a$a(readStrongBinder) : (c) queryLocalInterface;
                }
                Ar = a(com_tencent_mm_plugin_webview_stub_c_a_a);
                parcel2.writeNoException();
                if (Ar) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                if (parcel.readInt() != 0) {
                    n = true;
                } else {
                    n = false;
                }
                Ar = a(readString, readString2, bundle, n);
                parcel2.writeNoException();
                if (Ar) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bRM = bRM();
                parcel2.writeNoException();
                parcel2.writeString(bRM);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bRM = aeq();
                parcel2.writeNoException();
                parcel2.writeString(bRM);
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bRM = bRN();
                parcel2.writeNoException();
                parcel2.writeString(bRM);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                ko(z);
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                kp(z);
                parcel2.writeNoException();
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                i3 = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                p(i3, bundle);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bRO();
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                O(bundle);
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                OK(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                eM(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                bRP();
                parcel2.writeNoException();
                return true;
            case 16:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                e(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                bundle = e(readInt, bundle);
                parcel2.writeNoException();
                if (bundle != null) {
                    parcel2.writeInt(1);
                    bundle.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 18:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                P(bundle);
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                if (parcel.readInt() != 0) {
                    z = true;
                }
                kq(z);
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                eN(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
