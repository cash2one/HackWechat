package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class dk$3 implements Comparator<ScanResult> {
    dk$3() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((ScanResult) obj2).level - ((ScanResult) obj).level;
    }
}
