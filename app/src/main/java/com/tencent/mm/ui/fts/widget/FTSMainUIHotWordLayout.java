package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout extends LinearLayout {
    private TextView iiq = null;
    protected OnClickListener qdi;
    protected List<LinearLayout> zee = null;
    protected int zeo = 2;
    protected boolean zep = true;
    public b zeq = null;

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.zee = new ArrayList();
    }

    public final void q(OnClickListener onClickListener) {
        this.qdi = onClickListener;
    }

    public final String cxi() {
        if (this.zeq == null || this.zeq.iRN == null) {
            return "";
        }
        return this.zeq.iRN;
    }

    public void setVisibility(int i) {
        if ((this.zee.size() > 0 ? 1 : null) == null) {
            i = 8;
        }
        super.setVisibility(i);
    }
}
