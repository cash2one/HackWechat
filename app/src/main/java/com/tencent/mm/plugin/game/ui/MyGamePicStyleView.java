package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;

public class MyGamePicStyleView extends LinearLayout implements OnClickListener {
    String appId;
    Context mContext;
    int ndn;
    TextView nwl;
    TextView nwm;
    ImageView nwn;

    public MyGamePicStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nwl = (TextView) findViewById(R.h.cxe);
        this.nwm = (TextView) findViewById(R.h.cxd);
        this.nwn = (ImageView) findViewById(R.h.cCB);
        x.i("MicroMsg.MyGamePicStyleView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof an)) {
            x.w("MicroMsg.MyGamePicStyleView", "jumpURL is null");
            return;
        }
        an anVar = (an) view.getTag();
        ap.a(this.mContext, 10, 1002, anVar.ngX, c.p(this.mContext, anVar.ngZ.nfg, "game_center_mygame_comm"), this.appId, this.ndn, ap.BY(anVar.nfK));
    }
}
