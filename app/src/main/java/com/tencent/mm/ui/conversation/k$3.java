package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;

class k$3 implements Runnable {
    final /* synthetic */ k yZT;

    k$3(k kVar) {
        this.yZT = kVar;
    }

    public final void run() {
        if (!this.yZT.yZP) {
            int lastVisiblePosition = this.yZT.yVR.getLastVisiblePosition();
            int firstVisiblePosition = this.yZT.yVR.getFirstVisiblePosition();
            int i = lastVisiblePosition - firstVisiblePosition;
            if (firstVisiblePosition != this.yZT.yZS) {
                this.yZT.yZS = firstVisiblePosition;
                x.d("MicroMsg.PreLoadHelper", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(i)});
                int i2 = lastVisiblePosition + 1;
                while (i2 < this.yZT.yWw.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                    this.yZT.yWw.Gs(i2);
                    i2++;
                }
                i2 = firstVisiblePosition - 1;
                while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                    this.yZT.yWw.Gs(i2);
                    i2--;
                }
            }
        }
    }
}
