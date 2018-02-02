package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class e {
    private final long aQd;
    private final int aQe;
    private final j<String, Long> aQf;

    public e() {
        this.aQd = 60000;
        this.aQe = 10;
        this.aQf = new j(10);
    }

    public e(long j) {
        this.aQd = j;
        this.aQe = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        this.aQf = new j();
    }

    public final Long aQ(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.aQd;
        synchronized (this) {
            long j2 = j;
            while (this.aQf.size() >= this.aQe) {
                for (int size = this.aQf.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - ((Long) this.aQf.valueAt(size)).longValue() > j2) {
                        this.aQf.removeAt(size);
                    }
                }
                j = j2 / 2;
                new StringBuilder("The max capacity ").append(this.aQe).append(" is not enough. Current durationThreshold is: ").append(j);
                j2 = j;
            }
            l = (Long) this.aQf.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public final boolean aR(String str) {
        boolean z;
        synchronized (this) {
            z = this.aQf.remove(str) != null;
        }
        return z;
    }
}
