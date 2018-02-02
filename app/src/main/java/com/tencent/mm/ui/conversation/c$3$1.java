package com.tencent.mm.ui.conversation;

import android.os.Build.VERSION;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.c.3;

class c$3$1 implements Runnable {
    final /* synthetic */ 3 yWE;

    c$3$1(3 3) {
        this.yWE = 3;
    }

    public final void run() {
        int firstVisiblePosition;
        int i;
        int i2;
        int abs;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.yWE.yWC >= 3000 || this.yWE.yWD < 0) {
            firstVisiblePosition = (this.yWE.yWA.yVR.getFirstVisiblePosition() - this.yWE.yWA.yVR.getHeaderViewsCount()) + 1;
            if (firstVisiblePosition < 0) {
                i = 0;
            } else {
                i = firstVisiblePosition;
            }
        } else {
            i = this.yWE.yWD;
        }
        g gVar = this.yWE.yWA.yWw;
        if (this.yWE.yWA.yWv > 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        int count = gVar.getCount();
        if (count > 0) {
            for (abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                ae aeVar = (ae) gVar.DC(abs);
                if (aeVar != null && aeVar.field_unReadCount > 0) {
                    if (i2 == 0) {
                        i2 = abs;
                        break;
                    } else if (g.a(aeVar, gVar.i(aeVar)) == 2) {
                        i2 = abs;
                        break;
                    }
                }
            }
        }
        i2 = -1;
        if (i2 < 0) {
            c.a(this.yWE.yWA.yVR);
        } else {
            ListView listView = this.yWE.yWA.yVR;
            abs = this.yWE.yWA.yVR.getHeaderViewsCount() + i2;
            if (listView != null) {
                if (VERSION.SDK_INT >= 11) {
                    bb bbVar = new bb();
                    int firstVisiblePosition2 = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition2 < abs && firstVisiblePosition2 + 10 < abs) {
                        listView.setSelectionFromTop(abs - 10, 0);
                    } else if (firstVisiblePosition2 > abs && firstVisiblePosition2 - 10 > abs) {
                        listView.setSelectionFromTop(abs + 10, 0);
                    }
                    if (VERSION.SDK_INT >= 11) {
                        listView.smoothScrollToPositionFromTop(abs, 0);
                    }
                } else {
                    ba baVar = new ba();
                    listView.setSelectionFromTop(abs, 0);
                }
            }
        }
        this.yWE.yWC = currentTimeMillis;
        3 3 = this.yWE;
        if (i2 < 0) {
            firstVisiblePosition = 0;
        } else {
            firstVisiblePosition = i2;
        }
        3.yWD = firstVisiblePosition;
        x.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", new Object[]{Integer.valueOf(this.yWE.yWA.yVR.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
