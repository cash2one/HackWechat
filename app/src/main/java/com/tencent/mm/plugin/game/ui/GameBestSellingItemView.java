package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.widget.AutoResizeTextView;
import com.tencent.mm.plugin.game.widget.GameTagListView;
import com.tencent.mm.sdk.platformtools.bh;

public class GameBestSellingItemView extends LinearLayout implements OnClickListener {
    AutoResizeTextView nlK;
    ImageView nlL;
    TextView nlM;
    GameTagListView nlN;
    GameDownloadView nlO;
    View nlP;
    int nlQ;
    aa nlR;
    f nlS;

    public GameBestSellingItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nlK = (AutoResizeTextView) findViewById(R.h.cmX);
        this.nlL = (ImageView) findViewById(R.h.cml);
        this.nlM = (TextView) findViewById(R.h.cmV);
        this.nlN = (GameTagListView) findViewById(R.h.cQd);
        this.nlO = (GameDownloadView) findViewById(R.h.ckI);
        this.nlP = findViewById(R.h.cOU);
        this.nlQ = c.getScreenWidth(getContext()) - a.fromDPToPix(getContext(), 190);
        setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nlR != null && !bh.ov(this.nlR.nfh.nfj)) {
            ap.a(getContext(), 10, 1022, this.nlS.nbt + 1, c.ac(getContext(), this.nlR.nfh.nfj), this.nlR.nfh.nfn, GameIndexListView.aRA(), ap.BY(this.nlS.nbs.nfK));
        }
    }
}
