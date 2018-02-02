package com.tencent.mm.plugin.webview.fts.topstory.ui.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.webview.fts.topstory.ui.f;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public TextView ihS;
    public View lNu;
    public TextView pXZ;
    public f tqf;
    public FrameLayout tqg;
    public View tqh;
    public ImageView tqi;
    public TextView tqj;
    public TextView tqk;
    public View tql;
    public View tqm;
    public View tqn;

    public final void bQh() {
        x.d("MicroMsg.WebSearch.TopStoryTimeLineItemViewHolder", "showMaskView %d", new Object[]{Integer.valueOf(hashCode())});
        this.tqn.animate().cancel();
        this.tqm.animate().cancel();
        this.tql.animate().cancel();
        this.tql.setAlpha(0.8f);
        this.tqn.setAlpha(0.8f);
        this.tqm.setAlpha(0.8f);
    }

    public final void bPz() {
        this.tqn.animate().cancel();
        this.tqm.animate().cancel();
        this.tqn.setAlpha(0.0f);
        this.tqm.setAlpha(0.0f);
    }

    public final void bPy() {
        this.tqn.animate().cancel();
        this.tqm.animate().cancel();
        this.tqn.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
        this.tqm.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
    }
}
