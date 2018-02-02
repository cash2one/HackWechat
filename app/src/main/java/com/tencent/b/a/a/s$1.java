package com.tencent.b.a.a;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class s$1 implements Comparator<ScanResult> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        ScanResult scanResult = (ScanResult) obj2;
        int abs = Math.abs(((ScanResult) obj).level);
        int abs2 = Math.abs(scanResult.level);
        if (abs > abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }

    s$1() {
    }
}
