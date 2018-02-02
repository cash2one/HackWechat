package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class BizContactEntranceView extends RelativeLayout {
    private View ltm = null;
    private Context mContext;
    private View yRh;
    private TextView yRi;
    private boolean yRj = true;
    private boolean yRk;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
        cvL();
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
        cvL();
    }

    public BizContactEntranceView(Context context) {
        super(context);
        this.mContext = context;
        init();
        cvL();
    }

    private void init() {
        this.yRk = false;
        View.inflate(getContext(), R.i.dbo, this);
        this.ltm = findViewById(R.h.bYF);
        this.yRh = this.ltm.findViewById(R.h.bNP);
        LayoutParams layoutParams = this.yRh.getLayoutParams();
        layoutParams.height = (int) (((float) a.ab(getContext(), R.f.buA)) * a.ex(getContext()));
        this.yRh.setLayoutParams(layoutParams);
        this.ltm.setOnClickListener(new 1(this));
        this.yRh.setOnTouchListener(new 2(this));
        MaskLayout maskLayout = (MaskLayout) this.yRh.findViewById(R.h.bNO);
        ImageView imageView = (ImageView) maskLayout.view;
        n.Jz();
        imageView.setImageBitmap(d.jf("service_officialaccounts"));
        this.yRi = (TextView) maskLayout.findViewById(R.h.cRX);
    }

    final void cvL() {
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        if (c.EY().cir() > 0) {
            this.yRj = true;
        } else {
            this.yRj = false;
        }
        this.yRh.setVisibility(this.yRj ? 0 : 8);
        if (this.yRj) {
            ar.Dm().F(new 3(this));
        }
        x.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", new Object[]{Integer.valueOf(r4), Boolean.valueOf(this.yRj), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void setVisible(boolean z) {
        int i = 0;
        x.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", new Object[]{Boolean.valueOf(true), Boolean.valueOf(this.yRj)});
        View view = this.ltm;
        if (!this.yRj) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
