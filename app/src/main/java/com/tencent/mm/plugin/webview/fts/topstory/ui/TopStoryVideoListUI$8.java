package com.tencent.mm.plugin.webview.fts.topstory.ui;

import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.a.b;
import com.tencent.mm.plugin.webview.fts.topstory.a.c$a;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class TopStoryVideoListUI$8 implements c$a {
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$8(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final void cl(List<c> list) {
        if (list != null && list.size() > 0) {
            List cn = TopStoryVideoListUI.cn(list);
            b.h(cn, false);
            TopStoryVideoListUI.g(this.toU).cm(cn);
            if (cn != null && cn.size() > 0) {
                TopStoryVideoListUI.k(this.toU).seo = ((c) cn.get(0)).seC;
                b.tnw = TopStoryVideoListUI.k(this.toU);
            }
            x.i("MicroMsg.WebSearch.TopStoryVideoListUI", "update recCategory: %s", new Object[]{Long.valueOf(TopStoryVideoListUI.k(this.toU).seo)});
        }
        TopStoryVideoListUI.l(this.toU);
        b.tnD = false;
        b.tnE = false;
        d.ei(0, 1);
        if (TopStoryVideoListUI.m(this.toU) != null) {
            TopStoryVideoListUI.m(this.toU).dismiss();
            TopStoryVideoListUI.n(this.toU);
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            Collection singletonList = Collections.singletonList(cVar);
            b.h(singletonList, true);
            e g = TopStoryVideoListUI.g(this.toU);
            if (singletonList != null && singletonList.size() > 0) {
                g.tot.clear();
                g.tot.addAll(singletonList);
                g.notifyDataSetChanged();
            }
        }
    }

    public final void Ob(String str) {
        TopStoryVideoListUI.l(this.toU);
        b.tnD = false;
        b.tnE = true;
        if (TopStoryVideoListUI.m(this.toU) != null) {
            TopStoryVideoListUI.m(this.toU).dismiss();
            TopStoryVideoListUI.n(this.toU);
        }
        TopStoryVideoListUI.a(this.toU, str);
    }
}
