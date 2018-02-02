package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.a;
import org.xwalk.core.Log;

class TopStoryVideoListUI$2 implements Runnable {
    final /* synthetic */ TopStoryVideoListUI toU;

    TopStoryVideoListUI$2(TopStoryVideoListUI topStoryVideoListUI) {
        this.toU = topStoryVideoListUI;
    }

    public final void run() {
        if (((a) g.h(a.class)).bFq()) {
            b bVar = this.toU;
            Log.d("MicroMsg.WebSearch.TopStoryTimeLineItemViewController", "onScrollStop");
            int childCount = bVar.getListView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = bVar.getListView().getChildAt(i);
                if (childAt.hashCode() == ((a) g.h(a.class)).bFr()) {
                    TopStoryVideoItemView topStoryVideoItemView = (TopStoryVideoItemView) childAt;
                    if (!g.bQd().tpZ) {
                        if (((a) g.h(a.class)).aCc()) {
                            topStoryVideoItemView.kf(true);
                        } else {
                            if (((a) g.h(a.class)).isConnected()) {
                                topStoryVideoItemView.tom.tqf.bPP();
                            } else {
                                topStoryVideoItemView.tom.tqf.bPQ();
                            }
                            g.bQd().stopPlay();
                        }
                    }
                    topStoryVideoItemView.bPy();
                }
            }
        }
        ((a) g.h(a.class)).iX(false);
    }
}
