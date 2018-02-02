package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bh;

public final class e extends h {
    private int hbo = 0;
    private ImageView tXV;

    public e(View view, k kVar) {
        super(view, kVar);
        this.fvf.setVisibility(0);
        this.tYh.setVisibility(8);
        this.tYc.setVisibility(8);
        this.fvf.setTag(this);
        this.fvf.setOnClickListener(this.npY);
        this.tXV = (ImageView) view.findViewById(R.h.cpr);
        this.tXV.setVisibility(8);
        this.hbo = k.mScreenWidth - ((int) k.aq(20.0f));
    }

    public final void a(b bVar, int i, int i2) {
        String str;
        String str2 = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).fCa;
        String str3 = ((com.tencent.mm.plugin.wenote.model.a.e) bVar).tRR;
        if (com.tencent.mm.a.e.bO(str2)) {
            str = str2;
        } else if (com.tencent.mm.a.e.bO(str3)) {
            str = str3;
        } else {
            Object obj = null;
        }
        if (this.tWs.tUp != 3) {
            str3 = str;
        } else if (!com.tencent.mm.a.e.bO(str3)) {
            str3 = str;
        }
        Bitmap QU = bh.ov(str3) ? null : c.QU(str3);
        this.fvf.setImageBitmap(null);
        LayoutParams layoutParams = this.fvf.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.fvf.setLayoutParams(layoutParams);
        if (QU != null) {
            this.fvf.setImageBitmap(QU);
        } else {
            this.fvf.setImageBitmap(null);
            LayoutParams layoutParams2 = this.fvf.getLayoutParams();
            layoutParams2.width = this.hbo;
            layoutParams2.height = this.hbo;
            this.fvf.setLayoutParams(layoutParams2);
            this.fvf.setBackgroundColor(Color.parseColor("#f6f6f6"));
        }
        if (bVar.tRA) {
            this.tXV.setVisibility(0);
        } else {
            this.tXV.setVisibility(8);
        }
        super.a(bVar, i, i2);
    }

    public final int bXO() {
        return 2;
    }
}
