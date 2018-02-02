package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.u.a;
import org.xwalk.core.R$styleable;

public abstract class x$a extends Binder implements x {
    public static x t(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof x)) ? new a(iBinder) : (x) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        ConnectionConfiguration connectionConfiguration = null;
        v r;
        Uri uri;
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                }
                b(r, connectionConfiguration);
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                n(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                o(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                p(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 6:
                PutDataRequest putDataRequest;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    putDataRequest = (PutDataRequest) PutDataRequest.CREATOR.createFromParcel(parcel);
                }
                a(r, putDataRequest);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                a(r, uri);
                parcel2.writeNoException();
                return true;
            case 8:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                b(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                b(r, uri);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                c(r, uri);
                parcel2.writeNoException();
                return true;
            case 12:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.createByteArray());
                parcel2.writeNoException();
                return true;
            case 13:
                Asset asset;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    asset = (Asset) Asset.CREATOR.createFromParcel(parcel);
                }
                a(r, asset);
                parcel2.writeNoException();
                return true;
            case 14:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                c(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                d(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 16:
                AddListenerRequest addListenerRequest;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    addListenerRequest = (AddListenerRequest) AddListenerRequest.CREATOR.createFromParcel(parcel);
                }
                a(r, addListenerRequest);
                parcel2.writeNoException();
                return true;
            case 17:
                RemoveListenerRequest removeListenerRequest;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    removeListenerRequest = (RemoveListenerRequest) RemoveListenerRequest.CREATOR.createFromParcel(parcel);
                }
                a(r, removeListenerRequest);
                parcel2.writeNoException();
                return true;
            case 18:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                e(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                f(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    connectionConfiguration = (ConnectionConfiguration) ConnectionConfiguration.CREATOR.createFromParcel(parcel);
                }
                a(r, connectionConfiguration);
                parcel2.writeNoException();
                return true;
            case 21:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                b(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 24:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                c(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                g(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                h(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                AncsNotificationParcelable ancsNotificationParcelable;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    ancsNotificationParcelable = (AncsNotificationParcelable) AncsNotificationParcelable.CREATOR.createFromParcel(parcel);
                }
                a(r, ancsNotificationParcelable);
                parcel2.writeNoException();
                return true;
            case 28:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                b(v$a.r(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 29:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                c(v$a.r(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 30:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                i(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 32:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                f(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 33:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                b(v$a.r(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 34:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), a.q(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 35:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                b(v$a.r(parcel.readStrongBinder()), a.q(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 37:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                j(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 38:
                ParcelFileDescriptor parcelFileDescriptor;
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                }
                a(r, readString, parcelFileDescriptor);
                parcel2.writeNoException();
                return true;
            case 39:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readLong(), parcel.readLong());
                parcel2.writeNoException();
                return true;
            case 40:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                a(r, uri, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 41:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                r = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                }
                b(r, uri, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 46:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                d(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 47:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                e(v$a.r(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readInt() != 0);
                parcel2.writeNoException();
                return true;
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                k(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 50:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                v r2 = v$a.r(parcel.readStrongBinder());
                if (parcel.readInt() != 0) {
                    z = true;
                }
                b(r2, z);
                parcel2.writeNoException();
                return true;
            case 51:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                l(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 52:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                m(v$a.r(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 53:
                parcel.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                a(v$a.r(parcel.readStrongBinder()), parcel.readByte());
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
