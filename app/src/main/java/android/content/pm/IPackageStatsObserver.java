package android.content.pm;

import android.os.IInterface;

public interface IPackageStatsObserver extends IInterface {
    void onGetStatsCompleted(PackageStats packageStats, boolean z);
}
