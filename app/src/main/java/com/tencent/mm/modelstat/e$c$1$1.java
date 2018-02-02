package com.tencent.mm.modelstat;

import android.net.wifi.ScanResult;
import com.tencent.mm.modelstat.e.c.1;
import java.util.Comparator;

class e$c$1$1 implements Comparator<ScanResult> {
    final /* synthetic */ 1 hRr;

    e$c$1$1(1 1) {
        this.hRr = 1;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }
}
