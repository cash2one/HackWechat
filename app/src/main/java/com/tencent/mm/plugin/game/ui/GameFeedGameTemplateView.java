package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedGameTemplateView extends LinearLayout implements OnClickListener {
    TextView lkn;
    int nlQ;
    f nlS;
    ImageView noM;
    TextView noN;
    GameTagListView nqd;
    FrameLayout nqe;
    GameRoundImageView nqf;
    ImageView nqg;
    GameFeedSubscriptView nqh;
    GameDownloadView nqi;

    public GameFeedGameTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.noM = (ImageView) findViewById(R.h.cml);
        this.noN = (TextView) findViewById(R.h.cmV);
        this.nqd = (GameTagListView) findViewById(R.h.cno);
        this.lkn = (TextView) findViewById(R.h.caP);
        this.nqe = (FrameLayout) findViewById(R.h.cVd);
        this.nqf = (GameRoundImageView) findViewById(R.h.image);
        this.nqg = (ImageView) findViewById(R.h.cVg);
        this.nqh = (GameFeedSubscriptView) findViewById(R.h.cPC);
        this.nqi = (GameDownloadView) findViewById(R.h.clY);
        setOnClickListener(this);
        this.nlQ = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), ac.CTRL_BYTE);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onClick(View view) {
        if (this.nlS != null && this.nlS.nbs != null) {
            if (view.getId() == R.h.cVd && !bh.ov(this.nlS.nbs.ngI.nhD)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.ngI.nhD), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "middle"));
            } else if (!bh.ov(this.nlS.nbs.nfg)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.nfg), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "card"));
            }
        }
    }

    final void b(ImageView imageView, String str) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvi);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.bvh);
        e.aRV().a(imageView, str, dimensionPixelSize, dimensionPixelSize2, (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
    }
}
