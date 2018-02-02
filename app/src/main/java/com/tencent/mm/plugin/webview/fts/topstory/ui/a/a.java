package com.tencent.mm.plugin.webview.fts.topstory.ui.a;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.fts.topstory.ui.TopStoryVideoItemView;
import com.tencent.mm.plugin.webview.fts.topstory.ui.b;

public final class a {
    public static final TopStoryVideoItemView a(b bVar) {
        for (int i = 0; i < bVar.getListView().getChildCount(); i++) {
            View childAt = bVar.getListView().getChildAt(i);
            if (childAt instanceof TopStoryVideoItemView) {
                TopStoryVideoItemView topStoryVideoItemView = (TopStoryVideoItemView) childAt;
                Object obj = (topStoryVideoItemView.getTop() < com.tencent.mm.plugin.webview.fts.topstory.a.b.tnr + ((-(topStoryVideoItemView.getHeight() - topStoryVideoItemView.too)) / 2) || topStoryVideoItemView.getBottom() > topStoryVideoItemView.qWe.y + (topStoryVideoItemView.getHeight() / 2)) ? null : 1;
                if (obj != null) {
                    return topStoryVideoItemView;
                }
            }
        }
        return null;
    }

    public static final TopStoryVideoItemView b(b bVar) {
        for (int i = 0; i < bVar.getListView().getChildCount(); i++) {
            View childAt = bVar.getListView().getChildAt(i);
            if (childAt.hashCode() == ((com.tencent.mm.plugin.topstory.a.a) g.h(com.tencent.mm.plugin.topstory.a.a.class)).bFr()) {
                return (TopStoryVideoItemView) childAt;
            }
        }
        return a(bVar);
    }
}
