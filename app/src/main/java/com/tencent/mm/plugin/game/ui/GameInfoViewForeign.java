package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.sdk.platformtools.x;

public class GameInfoViewForeign extends RelativeLayout {
    private int gzM = 0;
    private Context mContext;
    int ndn = 0;
    private int nrG = 2;
    private TextView nrK;
    private OnClickListener nrL = new 1(this);

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this.nrL);
        this.nrK = (TextView) findViewById(R.h.cmU);
        aRC();
        x.i("MicroMsg.GameInfoViewForeign", "initView finished");
    }

    public final void aRC() {
        this.gzM = SubCoreGameCenter.aRd().aQx();
        if (this.gzM > 0 && this.gzM <= 99) {
            this.nrK.setVisibility(0);
            this.nrK.setText(this.gzM);
        } else if (this.gzM > 99) {
            this.nrK.setVisibility(0);
            this.nrK.setText("99+");
            this.nrK.setTextSize(1, 9.0f);
        } else {
            this.nrK.setVisibility(4);
        }
    }
}
