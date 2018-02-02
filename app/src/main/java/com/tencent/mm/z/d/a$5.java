package com.tencent.mm.z.d;

import android.content.pm.IPackageStatsObserver$Stub;
import android.content.pm.PackageStats;
import com.tencent.mm.sdk.platformtools.x;

class a$5 extends IPackageStatsObserver$Stub {
    final /* synthetic */ a hiZ;

    a$5(a aVar) {
        this.hiZ = aVar;
    }

    public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
        a.m(this.hiZ)[0] = packageStats.cacheSize;
        a.m(this.hiZ)[1] = packageStats.dataSize;
        a.m(this.hiZ)[2] = packageStats.codeSize;
        x.i("MicroMsg.HandlerTraceManager", "package cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[]{Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize)});
    }
}
