package c.t.m.g;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class dr extends dq {
    public static final dr a = new dr(Collections.emptyList(), 0);
    public final List<ScanResult> b;
    public final long c;

    public dr(List<ScanResult> list, long j) {
        this.c = j;
        this.b = new ArrayList(list);
    }
}
