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
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MyGameTextStyleView extends LinearLayout implements OnClickListener {
    String appId;
    TextView jpW;
    Context mContext;
    int ndn;
    TextView nwl;
    TextView nwm;
    EllipsizingTextView nwo;
    LinearLayout nwp;
    ImageView nwq;
    ImageView nwr;
    ImageView nws;
    LinearLayout nwt;
    ImageView nwu;
    RelativeLayout nwv;
    FrameLayout nww;
    ImageView nwx;
    ImageView nwy;

    public MyGameTextStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nwl = (TextView) findViewById(R.h.cxe);
        this.nwm = (TextView) findViewById(R.h.cxd);
        this.jpW = (TextView) findViewById(R.h.title);
        this.nwo = (EllipsizingTextView) findViewById(R.h.caP);
        this.nwo.setMaxLines(2);
        this.nwp = (LinearLayout) findViewById(R.h.cOK);
        this.nwq = (ImageView) findViewById(R.h.cae);
        this.nwr = (ImageView) findViewById(R.h.cOI);
        this.nws = (ImageView) findViewById(R.h.cOG);
        this.nwt = (LinearLayout) findViewById(R.h.cHd);
        this.nwu = (ImageView) findViewById(R.h.cHc);
        this.nwv = (RelativeLayout) findViewById(R.h.bMU);
        this.nww = (FrameLayout) findViewById(R.h.bMV);
        this.nwx = (ImageView) findViewById(R.h.bMS);
        this.nwy = (ImageView) findViewById(R.h.bMR);
        x.i("MicroMsg.MyGameTextStyleView", "initView finished");
    }

    static void g(ImageView imageView, String str) {
        if (bh.ov(str)) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        e.aRV().h(imageView, str);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof an)) {
            x.w("MicroMsg.MyGameTextStyleView", "getTag is null");
            return;
        }
        an anVar = (an) view.getTag();
        if (bh.ov(anVar.ngY.nfg)) {
            x.w("MicroMsg.MyGameTextStyleView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, anVar.ngX, c.p(this.mContext, anVar.ngY.nfg, "game_center_mygame_comm"), this.appId, this.ndn, ap.BY(anVar.nfK));
    }
}
