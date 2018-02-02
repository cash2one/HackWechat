package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference implements a {
    com.tencent.mm.ui.base.preference.f ilB;
    String lAb;
    private Context mContext;
    private View mView = null;
    private ImageView pTN = null;

    public f(Context context) {
        super(context);
        setLayoutResource(R.i.dpC);
        j.a(this);
        this.mContext = context;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pTN = (ImageView) view.findViewById(R.h.cvF);
        if (!bh.ov(this.lAb)) {
            Bitmap a = j.a(new o(this.lAb));
            if (a == null || a.isRecycled()) {
                this.pTN.setBackgroundColor(this.mContext.getResources().getColor(R.e.bsJ));
                this.pTN.setImageBitmap(null);
            } else {
                this.pTN.setImageBitmap(a);
                this.pTN.setBackgroundColor(0);
            }
            ((ImageView) view.findViewById(R.h.cvD)).setVisibility(0);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (!bh.ov(str) && str.equals(this.lAb) && bitmap != null && !bitmap.isRecycled()) {
            ag.y(new 1(this, bitmap));
        }
    }
}
