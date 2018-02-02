package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class o$1 implements Comparator<ScanResult> {
    o$1() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }
}
