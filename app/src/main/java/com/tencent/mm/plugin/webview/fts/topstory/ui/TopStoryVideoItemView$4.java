package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.plugin.webview.fts.topstory.ui.a.b;
import com.tencent.mm.sdk.platformtools.bh;

class TopStoryVideoItemView$4 implements OnClickListener {
    final /* synthetic */ TopStoryVideoItemView tos;

    TopStoryVideoItemView$4(TopStoryVideoItemView topStoryVideoItemView) {
        this.tos = topStoryVideoItemView;
    }

    public final void onClick(View view) {
        boolean z;
        if (((a) g.h(a.class)).bFr() != this.tos.hashCode()) {
            TopStoryVideoItemView.b(this.tos).Ad(TopStoryVideoItemView.a(this.tos));
            com.tencent.mm.plugin.report.service.g.pQN.h(791, 4);
            d.Oc(TopStoryVideoItemView.c(this.tos).sey);
            c c = TopStoryVideoItemView.c(this.tos);
            int a = TopStoryVideoItemView.a(this.tos);
            if (view.getId() == this.tos.tom.ihS.getId()) {
                z = true;
            } else {
                z = false;
            }
            d.b(c, a, z);
            return;
        }
        b bVar = this.tos.tom;
        if (bVar.tqn.getAlpha() == 0.0f || bVar.tqm.getAlpha() == 0.0f) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.tos.tom.bPz();
            TopStoryVideoItemView.b(this.tos).bPz();
            this.tos.tom.bPy();
            TopStoryVideoItemView.b(this.tos).bPy();
        } else if (view.getId() == this.tos.tom.tqh.getId()) {
            if (!bh.ov(TopStoryVideoItemView.c(this.tos).pes)) {
                TopStoryVideoItemView.a(this.tos, TopStoryVideoItemView.c(this.tos).pes);
                TopStoryVideoItemView.d(this.tos);
                d.Oc(TopStoryVideoItemView.c(this.tos).sey);
                d.b(TopStoryVideoItemView.c(this.tos), TopStoryVideoItemView.a(this.tos), false);
            }
        } else if (view.getId() == this.tos.tom.ihS.getId()) {
            if (TopStoryVideoItemView.c(this.tos) != null && !bh.ov(TopStoryVideoItemView.c(this.tos).seG)) {
                TopStoryVideoItemView.a(this.tos, TopStoryVideoItemView.c(this.tos).seG);
                TopStoryVideoItemView.d(this.tos);
                d.Oc(TopStoryVideoItemView.c(this.tos).sey);
                d.b(TopStoryVideoItemView.c(this.tos), TopStoryVideoItemView.a(this.tos), true);
            }
        } else if (view.getId() == this.tos.tom.lNu.getId()) {
            com.tencent.mm.plugin.report.service.g.pQN.h(791, 8);
            TopStoryVideoItemView.a(this.tos.getContext(), this.tos.tom.tqf, TopStoryVideoItemView.a(this.tos));
        }
    }
}
