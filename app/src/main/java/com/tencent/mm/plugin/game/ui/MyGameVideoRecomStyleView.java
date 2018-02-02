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
import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MyGameVideoRecomStyleView extends LinearLayout implements OnClickListener {
    ImageView jKx;
    TextView lVg;
    String mAppId;
    Context mContext;
    int ndn;
    TextView nwA;
    TextView nwB;
    TextView nwC;
    TextView nwD;
    RelativeLayout nwE;
    private FrameLayout nwF;
    ImageView nwG;
    TextView nwz;

    public MyGameVideoRecomStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nwz = (TextView) findViewById(R.h.cxe);
        this.nwA = (TextView) findViewById(R.h.cxd);
        this.lVg = (TextView) findViewById(R.h.title);
        this.nwB = (TextView) findViewById(R.h.bKh);
        this.nwC = (TextView) findViewById(R.h.bKg);
        this.nwD = (TextView) findViewById(R.h.cbm);
        this.nwE = (RelativeLayout) findViewById(R.h.coM);
        this.nwF = (FrameLayout) findViewById(R.h.coN);
        this.jKx = (ImageView) findViewById(R.h.icon);
        this.nwG = (ImageView) findViewById(R.h.bZq);
        x.i("MicroMsg.MyGameVideoRecomStyleView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof an)) {
            x.w("MicroMsg.MyGameVideoRecomStyleView", "getTag is null");
            return;
        }
        an anVar = (an) view.getTag();
        if (bh.ov(anVar.nhb.nfg)) {
            x.w("MicroMsg.MyGameVideoRecomStyleView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, anVar.ngX, c.p(this.mContext, anVar.nhb.nfg, "game_center_mygame_comm"), this.mAppId, this.ndn, ap.BY(anVar.nfK));
    }
}
