package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;

public class GameDownloadView extends FrameLayout implements OnClickListener {
    private b noH = new 4(this);
    private o noJ;
    private Button npM;
    private TextProgressBar npN;
    private e npO;

    public GameDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dkg, this, true);
        this.npM = (Button) inflate.findViewById(R.h.clX);
        this.npN = (TextProgressBar) inflate.findViewById(R.h.clZ);
        this.npN.rd(14);
        this.npM.setOnClickListener(this);
        this.npN.setOnClickListener(this);
        this.npO = new e(getContext());
        this.npO.nlx = new 1(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n.b(this.noH);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n.a(this.noH);
    }

    public final void a(o oVar) {
        this.noJ = oVar;
        c.Dm().F(new 2(this));
        aRz();
    }

    private void aRz() {
        ag.y(new 3(this));
    }

    public void onClick(View view) {
        this.noJ.cP(ac.getContext());
        this.npO.a(this.noJ.nbT, this.noJ);
    }
}
