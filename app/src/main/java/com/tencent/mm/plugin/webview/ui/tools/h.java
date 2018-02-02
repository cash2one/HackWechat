package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bh.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class h extends b {
    private TextView ihS;

    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.ihS = (TextView) this.view.findViewById(R.h.cYH);
            this.view.setOnClickListener(new 1(this));
        }
    }

    public final int getLayoutId() {
        return R.i.duc;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cYI).setVisibility(i);
        }
    }

    private void setTitle(String str) {
        if (this.ihS != null) {
            this.ihS.setText(str);
        }
    }

    public final boolean alg() {
        c cVar = c.hZo;
        if (c.Vb()) {
            cVar = c.hZo;
            if (c.Vf() == 2) {
                cVar = c.hZo;
                setTitle(c.Vd());
            } else {
                Context context = ac.getContext();
                int i = R.l.eYs;
                Object[] objArr = new Object[1];
                c cVar2 = c.hZo;
                objArr[0] = c.Vd();
                setTitle(context.getString(i, objArr));
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
