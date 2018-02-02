package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class a extends Preference implements com.tencent.mm.platformtools.j.a {
    private f jKn;
    private ImageView jVp;
    String lRA;
    private View mView = null;
    private TextView pTK = null;
    String pTL = null;

    public a(Context context) {
        super(context);
        setLayoutResource(R.i.drg);
        j.a(this);
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
        this.pTK = (TextView) view.findViewById(R.h.ccd);
        this.jVp = (ImageView) view.findViewById(R.h.bIX);
        if (bh.ov(this.pTL)) {
            this.pTK.setVisibility(8);
        } else {
            this.pTK.setText(this.pTL);
            this.pTK.setVisibility(0);
        }
        if (!bh.ov(this.lRA)) {
            Bitmap a = j.a(new o(this.lRA));
            if (a != null && !a.isRecycled()) {
                this.jVp.setImageBitmap(a);
                this.jVp.setVisibility(0);
            }
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (!bh.ov(str) && str.equals(this.lRA) && bitmap != null && !bitmap.isRecycled() && this.jVp != null) {
            ag.y(new 1(this, bitmap));
        }
    }
}
