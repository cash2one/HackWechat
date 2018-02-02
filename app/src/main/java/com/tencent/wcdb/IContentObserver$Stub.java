package com.tencent.wcdb;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IContentObserver$Stub extends Binder implements IContentObserver {
    private static final String DESCRIPTOR = "com.tencent.wcdb.IContentObserver";
    static final int TRANSACTION_onChange = 1;

    public IContentObserver$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IContentObserver asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
        if (queryLocalInterface == null || !(queryLocalInterface instanceof IContentObserver)) {
            return new Proxy(iBinder);
        }
        return (IContentObserver) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Uri uri;
                parcel.enforceInterface(DESCRIPTOR);
                boolean z = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                } else {
                    uri = null;
                }
                onChange(z, uri);
                return true;
            case 1598968902:
                parcel2.writeString(DESCRIPTOR);
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
