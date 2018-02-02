package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.webview.stub.e.a;
import java.util.List;
import java.util.Map;
import org.xwalk.core.R$styleable;

public abstract class d$a extends Binder implements d {
    public d$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
    }

    public static d X(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
            return new a(iBinder);
        }
        return (d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        int i3 = 0;
        boolean OQ;
        String gu;
        int ek;
        int readInt;
        Bundle bundle2;
        List LT;
        String readString;
        boolean z;
        String readString2;
        String[] bRQ;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = OQ(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(OQ ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = gu(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = gE(parcel.readString());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = hn(parcel.readString());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = gF(parcel.readString());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = OM(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = ze();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = isSDCardAvailable();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = aOD();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = Gz();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek = ek(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(ek);
                return true;
            case 12:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                el(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = aN(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 14:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                a(readInt, bundle2, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 15:
                IBinder asBinder;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                b R = R(bundle2);
                parcel2.writeNoException();
                if (R != null) {
                    asBinder = R.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 16:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                OQ = S(bundle2);
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 17:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek = OT(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(ek);
                return true;
            case 18:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                favEditTag();
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                OQ = r(readInt, bundle2);
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 20:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = r(parcel.readLong(), parcel.readString());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 21:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OU(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = LU();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 23:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                LT = LT();
                parcel2.writeNoException();
                parcel2.writeStringList(LT);
                return true;
            case 24:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                f(parcel.readInt(), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString = parcel.readString();
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                OQ = a(readString, z2, bundle2);
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 26:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = ON(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 27:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                cx(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 28:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                aP(gu, z);
                parcel2.writeNoException();
                return true;
            case 29:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = cG(parcel.readString());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 30:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                h(readInt, bundle2);
                parcel2.writeNoException();
                return true;
            case 31:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                bundle2 = o(readInt, bundle2);
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 32:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                i(gu, z, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bundle2 = As(parcel.readInt());
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 34:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = At(parcel.readInt());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 35:
                Bundle bundle3;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString2 = parcel.readString();
                readString = parcel.readString();
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle3 = null;
                }
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                OQ = a(readString2, readString, readString3, bundle3, bundle, parcel.readInt());
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 36:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                E(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                a(readString2, bundle2, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 38:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OO(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = OP(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 40:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ab(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                a(a.Y(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Au(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bRQ = bRQ();
                parcel2.writeNoException();
                parcel2.writeStringArray(bRQ);
                return true;
            case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = bRR();
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = BP(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 46:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = bRS();
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 47:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = OR(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Map bRU = bRU();
                parcel2.writeNoException();
                parcel2.writeMap(bRU);
                return true;
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = eO(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 50:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OS(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 51:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = cy(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 52:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = getLanguage();
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 53:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = bRT();
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 54:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek = bRV();
                parcel2.writeNoException();
                parcel2.writeInt(ek);
                return true;
            case 55:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek = bRW();
                parcel2.writeNoException();
                parcel2.writeInt(ek);
                return true;
            case 56:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bRX();
                parcel2.writeNoException();
                return true;
            case 57:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bRY();
                parcel2.writeNoException();
                return true;
            case 58:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Av(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 59:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Aw(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 60:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Aq(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 61:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                cz(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 62:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = bRZ();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 63:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gu = OW(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gu);
                return true;
            case 64:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = bSb();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 65:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = bSa();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 66:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OQ = bSe();
                parcel2.writeNoException();
                if (OQ) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 67:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                c(parcel.readString(), parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            case 68:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                OV(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 69:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                g(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 70:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                bundle2 = e(readInt, bundle2);
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                Intent intent;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                } else {
                    intent = null;
                }
                aa(intent);
                parcel2.writeNoException();
                return true;
            case 72:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                y(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 73:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                LT = bSc();
                parcel2.writeNoException();
                parcel2.writeStringList(LT);
                return true;
            case 74:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek = bSd();
                parcel2.writeNoException();
                parcel2.writeInt(ek);
                return true;
            case R$styleable.AppCompatTheme_listPopupWindowStyle /*75*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bRQ = bSf();
                parcel2.writeNoException();
                parcel2.writeStringArray(bRQ);
                return true;
            case R$styleable.AppCompatTheme_textAppearanceListItem /*76*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                q(readInt, bundle2);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
