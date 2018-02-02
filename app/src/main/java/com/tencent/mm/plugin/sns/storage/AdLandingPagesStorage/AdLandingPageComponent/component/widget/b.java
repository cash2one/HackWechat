package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class b {
    private RecyclerView jNw;
    public Map<Integer, a> riE = new HashMap();
    private LinearLayoutManager riF;
    public b rmw;
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b rmx;

    public interface b {
        void a(int i, b bVar);

        void onDestroy();

        void xc(int i);

        boolean xd(int i);
    }

    private class c extends k {
        RecyclerView jNw;
        private LinearLayoutManager riL;
        int riM = Integer.MAX_VALUE;
        private int riN = -1;
        private int riO = -1;
        private long riP = 0;
        Runnable riQ = new 1(this);
        final /* synthetic */ b rmy;

        public c(b bVar, RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
            this.rmy = bVar;
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
                        this.rmy.bxy();
                        if (this.riM == 2) {
                            int eZ = this.riL.eZ();
                            int fa = this.riL.fa();
                            if (fa >= this.riN) {
                                if (eZ > this.riO) {
                                    dy(this.riO, eZ);
                                    break;
                                }
                            }
                            dy(fa, this.riN);
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
        }

        public final void c(RecyclerView recyclerView, int i, int i2) {
            super.c(recyclerView, i, i2);
        }

        private void dy(int i, int i2) {
            b bVar = this.rmy;
            if (i <= i2) {
                bVar.dx(i, i2);
                while (i <= i2) {
                    a aVar = (a) bVar.riE.get(Integer.valueOf(i));
                    if (aVar != null && aVar.rfE) {
                        bVar.rmw.xc(i);
                        aVar.bwY();
                    }
                    i++;
                }
            }
        }
    }

    public b(RecyclerView recyclerView, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
        this.jNw = recyclerView;
        this.rmx = bVar;
        if (recyclerView.TV == null || !(recyclerView.TV instanceof LinearLayoutManager)) {
            throw new IllegalArgumentException("set LinearLayoutManger to RecyclerView first");
        } else if (recyclerView.fm() == null || !(recyclerView.fm() instanceof b)) {
            throw new IllegalArgumentException("set Adapter which implemented ExposureListener to RecyclerView first");
        } else {
            this.rmw = (b) recyclerView.fm();
            this.riF = (LinearLayoutManager) recyclerView.TV;
            this.jNw.a(new c(this, recyclerView, (LinearLayoutManager) recyclerView.TV));
        }
    }

    public final void bxy() {
        bwX();
        int eZ = this.riF.eZ();
        int fa = this.riF.fa();
        for (Entry entry : this.riE.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < eZ || ((Integer) entry.getKey()).intValue() > fa) {
                if (((a) entry.getValue()).rfE) {
                    this.rmw.xc(((Integer) entry.getKey()).intValue());
                    ((a) entry.getValue()).bwY();
                }
            } else if (((a) entry.getValue()).rfE && !this.rmw.xd(((Integer) entry.getKey()).intValue())) {
                this.rmw.xc(((Integer) entry.getKey()).intValue());
                ((a) entry.getValue()).bwY();
            }
        }
    }

    public final void bwX() {
        if (this.riF != null) {
            int eZ = this.riF.eZ();
            int fa = this.riF.fa();
            if (eZ != fa || eZ != -1) {
                dx(eZ, fa);
            }
        }
    }

    final void dx(int i, int i2) {
        while (i <= i2) {
            a aVar = (a) this.riE.get(Integer.valueOf(i));
            if (aVar == null) {
                aVar = new a(this, (byte) 0);
                this.riE.put(Integer.valueOf(i), aVar);
            }
            if (!aVar.rfE && this.rmw.xd(i)) {
                this.rmw.a(i, this);
                if (!aVar.rfE) {
                    aVar.rfE = true;
                }
            }
            i++;
        }
    }

    public final void bxz() {
        if (this.riF != null) {
            int eZ = this.riF.eZ();
            int fa = this.riF.fa();
            if (eZ != fa || eZ != -1) {
                for (int i = eZ; i <= fa; i++) {
                    a aVar = (a) this.riE.get(Integer.valueOf(i));
                    if (aVar != null && aVar.rfE) {
                        this.rmw.xc(i);
                        aVar.bwY();
                    }
                }
            }
        }
    }
}
