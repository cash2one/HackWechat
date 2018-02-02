package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedNoGamePlayTemplate extends LinearLayout implements OnClickListener {
    ImageView jVp;
    GameDownloadView nlO;
    f nlS;
    GameRoundImageView nqf;
    ImageView nqg;
    GameFeedTitleDescView nqs;
    FrameLayout nqt;
    RelativeLayout nqu;
    TextView nqv;

    public GameFeedNoGamePlayTemplate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.nqs = (GameFeedTitleDescView) findViewById(R.h.cmb);
        this.nqt = (FrameLayout) findViewById(R.h.cpq);
        this.nqf = (GameRoundImageView) findViewById(R.h.bZr);
        this.nqg = (ImageView) findViewById(R.h.cVg);
        this.nqu = (RelativeLayout) findViewById(R.h.ckU);
        this.jVp = (ImageView) findViewById(R.h.cml);
        this.nqv = (TextView) findViewById(R.h.cmV);
        this.nlO = (GameDownloadView) findViewById(R.h.clY);
        setOnClickListener(this);
        this.nqt.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nlS != null && this.nlS.nbs != null && this.nlS.nbs.ngJ != null) {
            if (view.getId() == R.h.cpq && !bh.ov(this.nlS.nbs.ngJ.nhE)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.ngJ.nhE), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "middle"));
            } else if (!bh.ov(this.nlS.nbs.nfg)) {
                ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.nfg), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "card"));
            }
        }
    }
}
