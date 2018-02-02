package com.tencent.mm.plugin.gallery.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {
        public a() {
            attachInterface(this, "com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        }

        public static a Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    aj(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    aOk();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = zH();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(readString, readString2, z2, readInt, z);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = zF();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = zE();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    boolean z3;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z3 = fp(z3);
                    parcel2.writeNoException();
                    if (z3) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = Bw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = aOl();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = qq(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int Bw(String str);

    void a(String str, String str2, boolean z, int i, boolean z2);

    void aOk();

    int aOl();

    void aj(int i, String str);

    boolean fp(boolean z);

    int qq(int i);

    int zE();

    int zF();

    int zH();
}
