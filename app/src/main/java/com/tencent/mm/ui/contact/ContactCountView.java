package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;

public class ContactCountView extends FrameLayout {
    private int count = 0;
    private View lWv;
    private TextView nIu;
    private boolean visible = true;
    int yRv = 1;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ContactCountView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.i.deI, this);
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.lWv == null) {
            this.lWv = (FrameLayout) findViewById(R.h.bXi);
            this.nIu = (TextView) findViewById(R.h.bXh);
        }
        cvM();
        super.onMeasure(i, i2);
    }

    public final void cvM() {
        String[] strArr = s.hfr;
        if (this.yRv == 1) {
            ar.Hg();
            this.count = c.EY().b(strArr, new String[]{q.FS(), "weixin", "helper_entry", "filehelper"});
        } else {
            ar.Hg();
            this.count = c.EY().c(strArr, new String[]{q.FS(), "weixin", "helper_entry", "filehelper"});
        }
        x.d("MicroMsg.ContactCountView", "contact count %d", new Object[]{Integer.valueOf(this.count)});
        if (this.nIu != null) {
            if (this.yRv == 1) {
                this.nIu.setText(getContext().getResources().getQuantityString(R.j.dun, this.count, new Object[]{Integer.valueOf(this.count)}));
            } else {
                this.nIu.setText(getContext().getResources().getQuantityString(R.j.dum, this.count, new Object[]{Integer.valueOf(this.count)}));
            }
        }
        setVisible(this.visible);
    }

    public final void setVisible(boolean z) {
        this.visible = z;
        if (this.lWv != null) {
            View view = this.lWv;
            int i = (!z || this.count <= 0) ? 8 : 0;
            view.setVisibility(i);
        }
    }
}
