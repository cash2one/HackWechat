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
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    TextView jpW;
    d ndK;
    b noH;
    o noJ;
    TextView nof;
    TextView nuq;
    private ImageView nur;

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jpW = (TextView) findViewById(R.h.clQ);
        this.nuq = (TextView) findViewById(R.h.clC);
        this.nof = (TextView) findViewById(R.h.clP);
        this.nur = (ImageView) findViewById(R.h.cmM);
        x.i("MicroMsg.GameRankHeadView", "initView finished");
    }

    final void aRz() {
        if (g.a(getContext(), this.ndK)) {
            if (this.ndK.versionCode > c.Cl(this.ndK.field_packageName)) {
                this.nof.setText(R.l.emb);
                return;
            } else {
                this.nof.setText(R.l.elZ);
                return;
            }
        }
        switch (this.ndK.status) {
            case 0:
                if (this.noJ == null) {
                    this.nof.setVisibility(8);
                    this.nur.setVisibility(8);
                    return;
                }
                this.nof.setVisibility(0);
                this.nur.setVisibility(0);
                switch (this.noJ.status) {
                    case 0:
                        this.nof.setText(R.l.elW);
                        return;
                    case 1:
                        this.nof.setText(R.l.elX);
                        return;
                    case 2:
                        this.nof.setText(R.l.elV);
                        return;
                    case 3:
                        this.nof.setText(R.l.elY);
                        return;
                    default:
                        return;
                }
            default:
                this.nof.setText(R.l.elW);
                return;
        }
    }

    public void onClick(View view) {
        new e(getContext()).a(this.ndK, new o(this.ndK));
    }
}
