package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class o$a extends Binder implements o {

    private static class a implements o {
        private IBinder mRemote;

        a(IBinder iBinder) {
            this.mRemote = iBinder;
        }

        public final IBinder asBinder() {
            return this.mRemote;
        }

        public final long aED() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                this.mRemote.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                long readLong = obtain2.readLong();
                return readLong;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final byte[] aEE() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                this.mRemote.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                byte[] createByteArray = obtain2.createByteArray();
                return createByteArray;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final int aEF() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                this.mRemote.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final int aEG() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                this.mRemote.transact(4, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final int aEH() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                this.mRemote.transact(5, obtain, obtain2, 0);
                obtain2.readException();
                int readInt = obtain2.readInt();
                return readInt;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public o$a() {
        attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
    }

    public static o O(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
            return new a(iBinder);
        }
        return (o) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        int aEF;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                long aED = aED();
                parcel2.writeNoException();
                parcel2.writeLong(aED);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                byte[] aEE = aEE();
                parcel2.writeNoException();
                parcel2.writeByteArray(aEE);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                aEF = aEF();
                parcel2.writeNoException();
                parcel2.writeInt(aEF);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                aEF = aEG();
                parcel2.writeNoException();
                parcel2.writeInt(aEF);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                aEF = aEH();
                parcel2.writeNoException();
                parcel2.writeInt(aEF);
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
