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
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedVideoView extends LinearLayout implements OnClickListener {
    f nlS;
    GameRoundImageView nqH;
    LinearLayout nqI;
    ImageView nqJ;
    TextView nqK;
    GameFeedTitleDescView nqb;
    FrameLayout nqe;
    GameFeedSubscriptView nqo;

    public GameFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nqb = (GameFeedTitleDescView) findViewById(R.h.cmb);
        this.nqe = (FrameLayout) findViewById(R.h.cVd);
        this.nqH = (GameRoundImageView) findViewById(R.h.cUK);
        this.nqI = (LinearLayout) findViewById(R.h.cUL);
        this.nqJ = (ImageView) findViewById(R.h.cVt);
        this.nqK = (TextView) findViewById(R.h.cUM);
        this.nqo = (GameFeedSubscriptView) findViewById(R.h.cPC);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nlS != null && !bh.ov(this.nlS.nbs.nfg)) {
            ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.nfg), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "card"));
        }
    }
}
