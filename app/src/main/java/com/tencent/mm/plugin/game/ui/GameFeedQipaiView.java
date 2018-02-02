package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;

public class GameFeedQipaiView extends LinearLayout implements OnClickListener {
    TextView jJn;
    TextView nqw;
    ImageView nqx;
    LinearLayout nqy;
    ag nqz;

    public GameFeedQipaiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jJn = (TextView) findViewById(R.h.title);
        this.nqw = (TextView) findViewById(R.h.cxl);
        this.nqx = (ImageView) findViewById(R.h.cxi);
        this.nqy = (LinearLayout) findViewById(R.h.cmt);
        this.nqw.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.nqz != null) {
            if (view.getId() != R.h.cxl) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue >= 0 && intValue <= this.nqz.ngN.nfN.size() - 1) {
                    as asVar = (as) this.nqz.ngN.nfN.get(intValue);
                    if (!bh.ov(asVar.nfg)) {
                        ap.a(getContext(), 10, 1023, intValue + 1, c.ac(getContext(), asVar.nfg), asVar.ngo, GameIndexListView.aRA(), ap.BY(this.nqz.nfK));
                    }
                }
            } else if (!bh.ov(this.nqz.ngN.nht)) {
                ap.a(getContext(), 10, 1023, 999, c.ac(getContext(), this.nqz.ngN.nht), null, GameIndexListView.aRA(), ap.BY(this.nqz.nfK));
            }
        }
    }
}
