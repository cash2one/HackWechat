package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedImageTextView extends LinearLayout implements OnClickListener {
    private int kDP = 0;
    f nlS;
    GameFeedTitleDescView nqb;
    GameRoundImageView nqf;
    LinearLayout nqj;
    GameRoundImageView nqk;
    GameRoundImageView nql;
    GameRoundImageView nqm;
    TextView nqn;
    GameFeedSubscriptView nqo;
    private int nqp = 0;
    private int nqq;

    public GameFeedImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nqb = (GameFeedTitleDescView) findViewById(R.h.cmb);
        this.nqf = (GameRoundImageView) findViewById(R.h.bMX);
        this.nqj = (LinearLayout) findViewById(R.h.cON);
        this.nqk = (GameRoundImageView) findViewById(R.h.cig);
        this.nql = (GameRoundImageView) findViewById(R.h.cKi);
        this.nqm = (GameRoundImageView) findViewById(R.h.cQP);
        this.nqn = (TextView) findViewById(R.h.cxo);
        this.nqo = (GameFeedSubscriptView) findViewById(R.h.cPC);
        setOnClickListener(this);
        this.kDP = (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.nqp = (this.kDP - (a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.nqq = a.fromDPToPix(getContext(), 105);
        if (this.nqp < this.nqq) {
            this.nqq = this.nqp;
        }
        LayoutParams layoutParams = this.nqk.getLayoutParams();
        layoutParams.width = this.nqq;
        layoutParams.height = this.nqq;
        this.nqk.setLayoutParams(layoutParams);
        this.nql.setLayoutParams(layoutParams);
        this.nqm.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        if (this.nlS != null && this.nlS.nbs != null && !bh.ov(this.nlS.nbs.nfg)) {
            ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nlS.position, c.ac(getContext(), this.nlS.nbs.nfg), this.nlS.nbs.ngo, GameIndexListView.aRA(), ap.L(this.nlS.nbs.nfK, "clickType", "card"));
        }
    }
}
