package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a$a extends Binder implements a {
    public a$a() {
        attachInterface(this, "android.support.v4.os.IResultReceiver");
    }

    public static a b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
            return new a(iBinder);
        }
        return (a) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                Bundle bundle;
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle = null;
                }
                send(readInt, bundle);
                return true;
            case 1598968902:
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
