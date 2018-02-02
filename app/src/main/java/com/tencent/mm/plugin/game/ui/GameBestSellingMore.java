package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.bh;

public class GameBestSellingMore extends LinearLayout implements OnClickListener {
    f nlS;
    TextView nlT;
    ImageView nlU;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nlT = (TextView) findViewById(R.h.cxn);
        this.nlU = (ImageView) findViewById(R.h.cxm);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nlS != null && this.nlS.nbs != null && this.nlS.nbs.ngK != null && !bh.ov(this.nlS.nbs.ngK.nht)) {
            ap.a(getContext(), 10, 1022, 999, c.ac(getContext(), this.nlS.nbs.ngK.nht), null, GameIndexListView.aRA(), ap.BY(this.nlS.nbs.nfK));
        }
    }
}
