package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.game.ui.s.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class GameRankFooter extends LinearLayout {
    private Context mContext;
    private boolean mHasInit = false;
    TextView nuk;
    private View nul;
    private TextView num;
    private ImageView nun;
    private TextView nuo;
    private TextView nup;

    public GameRankFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            init();
            this.mHasInit = true;
        }
    }

    public final void aRK() {
        this.nuk.setVisibility(0);
    }

    public final void aRL() {
        this.nuk.setVisibility(8);
    }

    public final void a(a aVar) {
        if (this.mHasInit && this.nul.getVisibility() != 0) {
            this.nul.setVisibility(0);
            ar.Hg();
            af WO = c.EY().WO(aVar.fDC);
            if (WO != null) {
                b.a(this.nun, WO.field_username);
                this.nuo.setText(i.b(this.mContext, WO.AQ(), this.nuo.getTextSize()));
            }
            this.num.setText(aVar.ndy);
            this.nup.setText(bh.formatNumber(aVar.mMe));
        }
    }

    public final void aRM() {
        if (this.nul != null && this.nul.getVisibility() != 8) {
            this.nul.setVisibility(8);
        }
    }

    private void init() {
        this.nuk = (TextView) findViewById(R.h.ctn);
        this.nul = findViewById(R.h.cyy);
        this.num = (TextView) findViewById(R.h.cFm);
        this.nun = (ImageView) findViewById(R.h.cUh);
        this.nuo = (TextView) findViewById(R.h.cUj);
        this.nup = (TextView) findViewById(R.h.cUn);
    }
}
