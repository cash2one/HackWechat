package com.google.android.exoplayer2.i;

import java.util.PriorityQueue;

public final class m {
    public final PriorityQueue<Integer> aCt;
    public int aCu;
    public final Object lock;

    public final void lP() {
        synchronized (this.lock) {
            this.aCt.remove(Integer.valueOf(0));
            this.aCu = this.aCt.isEmpty() ? Integer.MIN_VALUE : ((Integer) this.aCt.peek()).intValue();
            this.lock.notifyAll();
        }
    }
}
