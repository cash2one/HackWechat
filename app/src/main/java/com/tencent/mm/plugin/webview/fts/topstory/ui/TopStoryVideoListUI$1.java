package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.webview.fts.topstory.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class TopStoryVideoListUI$1 implements OnScrollListener {
    int toQ = -1;
    int toR = -1;
    int toS = -1;
    long toT = -1;
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$1(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0) {
            return;
        }
        if (this.toT <= 0 || bh.bA(this.toT) >= 3000) {
            d.bPr();
            this.toT = bh.Wq();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (((a) g.h(a.class)).bFq()) {
            TopStoryVideoListUI.b(this.toU).removeCallbacks(TopStoryVideoListUI.a(this.toU));
            TopStoryVideoListUI.b(this.toU).postDelayed(TopStoryVideoListUI.a(this.toU), 50);
            if (!d.bPB().nbV) {
                b bVar = this.toU;
                ListView listView = bVar.getListView();
                TopStoryVideoItemView a = com.tencent.mm.plugin.webview.fts.topstory.ui.a.a.a(bVar);
                int hashCode = a != null ? a.hashCode() : -1;
                if (hashCode != ((a) g.h(a.class)).bFr() && g.bQd().tpZ) {
                    g.bQd().stopPlay();
                }
                for (int i4 = 0; i4 < listView.getChildCount(); i4++) {
                    View childAt = listView.getChildAt(i4);
                    if (childAt instanceof TopStoryVideoItemView) {
                        a = (TopStoryVideoItemView) childAt;
                        f fVar;
                        if (a.hashCode() == hashCode) {
                            a.bPE();
                            if (!g.bQd().tpZ) {
                                fVar = a.tom.tqf;
                                x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setListScrollPlayContainerStatus");
                                fVar.tpb.setVisibility(8);
                                fVar.tpk.setVisibility(0);
                                fVar.tpg.setVisibility(8);
                                fVar.toZ.setVisibility(8);
                                fVar.toY.setVisibility(8);
                                fVar.tpx.setVisibility(8);
                            }
                        } else {
                            x.d("MicroMsg.WebSearch.TopStoryVideoItemView", "showDarkMask, position: %s", new Object[]{Integer.valueOf(a.position)});
                            a.tom.bQh();
                            fVar = a.tom.tqf;
                            x.i("MicroMsg.WebSearch.TopStoryVideoViewContainer", "setListScrollStopContainerStatus");
                            fVar.tpb.setVisibility(0);
                            fVar.tpk.setVisibility(0);
                            fVar.tpg.setVisibility(8);
                            fVar.toZ.setVisibility(8);
                            fVar.toY.setVisibility(8);
                            fVar.tpx.setVisibility(8);
                            fVar.tpd.setVisibility(0);
                            fVar.tpc.setVisibility(8);
                            fVar.tpf.setVisibility(8);
                            fVar.tpt.setVisibility(8);
                            fVar.tpu.setVisibility(8);
                            fVar.tpv.setVisibility(8);
                            fVar.tpl.setVisibility(0);
                            fVar.tpm.setVisibility(8);
                            fVar.tpp.setVisibility(8);
                        }
                    }
                }
                bVar.bPz();
                ((a) g.h(a.class)).yp(hashCode);
            }
        }
        if (TopStoryVideoListUI.c(this.toU) <= 0 || bh.bA(TopStoryVideoListUI.c(this.toU)) >= 50) {
            TopStoryVideoListUI.a(this.toU, bh.Wq());
            this.toQ = i;
            this.toR = i;
            this.toS = i2;
            d.ei(i, i + i2);
            Object obj = null;
            if (!TopStoryVideoItemView.agN()) {
                if (b.tnB) {
                    if (i3 - (i + i2) <= 2 && !b.tnD && ((TopStoryVideoListUI.d(this.toU) <= 0 || bh.bA(TopStoryVideoListUI.d(this.toU)) >= 50) && !b.tnE)) {
                        obj = 1;
                    }
                } else if (i + i2 >= i3 && !b.tnD && ((TopStoryVideoListUI.d(this.toU) <= 0 || bh.bA(TopStoryVideoListUI.d(this.toU)) >= 50) && !b.tnE)) {
                    obj = 1;
                }
                if (b.tnE && TopStoryVideoListUI.e(this.toU) && !b.tnD && i + i2 >= i3 && r0 == null) {
                    obj = 1;
                }
                if (obj != null) {
                    TopStoryVideoListUI.f(this.toU);
                }
            }
        }
    }
}
