package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> oUk;

    public b() {
        this.currentIndex = 0;
        this.oUk = new ArrayList();
        this.currentIndex = 0;
    }

    public final void dV(long j) {
        x.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oUk.size()));
        this.oUk.add(Long.valueOf(j));
    }

    public final long bgB() {
        long j = -1;
        if (this.oUk.size() > 0 && this.currentIndex < this.oUk.size()) {
            j = ((Long) this.oUk.get(this.currentIndex)).longValue();
        }
        x.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oUk.size()));
        this.currentIndex++;
        return j;
    }

    public final boolean dW(long j) {
        return this.oUk.contains(Long.valueOf(j));
    }

    public final void clear() {
        this.oUk.clear();
        this.currentIndex = 0;
    }

    public final long get(int i) {
        return ((Long) this.oUk.get(i)).longValue();
    }

    public final void remove(long j) {
        this.oUk.remove(Long.valueOf(j));
    }
}
