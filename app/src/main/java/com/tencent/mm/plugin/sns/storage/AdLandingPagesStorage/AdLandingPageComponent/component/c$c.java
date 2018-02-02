package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.a;
import com.tencent.mm.sdk.platformtools.x;

class c$c extends k {
    RecyclerView jNw;
    final /* synthetic */ c riI;
    private LinearLayoutManager riL;
    int riM = Integer.MAX_VALUE;
    private int riN = -1;
    private int riO = -1;
    private long riP = 0;
    Runnable riQ = new 1(this);

    public c$c(c cVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        this.riI = cVar;
        this.jNw = recyclerView;
        this.riL = linearLayoutManager;
    }

    private void bwZ() {
        this.jNw.getHandler().removeCallbacks(this.riQ);
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i != this.riM) {
            if (i != 1) {
                bwZ();
            }
            switch (i) {
                case 0:
                    c.a(this.riI);
                    if (this.riM == 2) {
                        int eZ = this.riL.eZ();
                        int fa = this.riL.fa();
                        if (fa >= this.riN) {
                            if (eZ > this.riO) {
                                g(this.riO, eZ, System.currentTimeMillis() - this.riP);
                                break;
                            }
                        }
                        g(fa, this.riN, System.currentTimeMillis() - this.riP);
                        break;
                    }
                    break;
                case 1:
                    bwZ();
                    this.jNw.postDelayed(this.riQ, 100);
                    break;
                case 2:
                    this.riN = this.riL.eZ();
                    this.riO = this.riL.fa();
                    this.riP = System.currentTimeMillis();
                    break;
            }
        }
        this.riM = i;
        x.d("AdLandingCarouselComp", "state " + i);
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
    }

    private void g(int i, int i2, long j) {
        int i3 = 1;
        x.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
        c cVar = this.riI;
        if (i > i2) {
            x.e("AdLandingCarouselComp", "wtf start > end");
            return;
        }
        cVar.dx(i, i2);
        if (i2 != i) {
            i3 = (i2 - i) + 1;
        }
        long j2 = j / ((long) i3);
        while (i <= i2) {
            a aVar = (a) cVar.riE.get(Integer.valueOf(i));
            if (aVar != null && aVar.isVisible) {
                aVar.isVisible = false;
                aVar.riH = 0;
                aVar.time += j2;
            }
            i++;
        }
    }
}
