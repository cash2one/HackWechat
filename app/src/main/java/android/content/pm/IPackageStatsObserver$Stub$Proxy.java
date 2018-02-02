package android.content.pm;

import android.os.IBinder;
import android.os.Parcel;

class IPackageStatsObserver$Stub$Proxy implements IPackageStatsObserver {
    private IBinder mRemote;

    IPackageStatsObserver$Stub$Proxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public String getInterfaceDescriptor() {
        return "IPackageStatsObserver";
    }

    public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
        int i = 1;
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("IPackageStatsObserver");
            if (packageStats != null) {
                obtain.writeInt(1);
                packageStats.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!z) {
                i = 0;
            }
            obtain.writeInt(i);
            this.mRemote.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
