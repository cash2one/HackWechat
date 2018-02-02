package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.h;
import com.tencent.mm.sdk.platformtools.bh;

public final class b extends com.tencent.mm.pluginsdk.ui.b.b {
    private TextView ihS = null;

    public b(Context context) {
        super(context);
        if (this.view != null) {
            this.ihS = (TextView) this.view.findViewById(R.h.cZt);
            this.ihS.setTextSize(0, (float) a.aa(this.ihS.getContext(), R.f.bvs));
            this.view.setOnClickListener(new 1(this));
        }
    }

    public final int getLayoutId() {
        return R.i.cZu;
    }

    public final int getOrder() {
        return 0;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cZu).setVisibility(i);
        }
    }

    public final boolean alg() {
        boolean z;
        p bWK = h.bWJ().bWK();
        if (bWK != null && bWK.tRS && bWK.tRU > 0 && !bh.ov(bWK.tRX)) {
            z = true;
        } else if (bWK == null || bWK.tRS || f.ea(bWK.tRT) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            CharSequence charSequence = bWK.tRW;
            if (this.ihS != null) {
                this.ihS.setText(charSequence);
            }
            setVisibility(0);
            return true;
        }
        if (bWK != null) {
            h.bWJ().a(null);
        }
        setVisibility(8);
        return false;
    }
}
