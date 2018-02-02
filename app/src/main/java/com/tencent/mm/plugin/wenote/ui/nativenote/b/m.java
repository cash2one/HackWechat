package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class m extends h {
    public ImageView tYC;
    public MMPinProgressBtn tYD;
    public ImageView tYE;
    private ImageView tYF;

    public m(View view, k kVar) {
        super(view, kVar);
        this.tYC = (ImageView) view.findViewById(R.h.cPl);
        this.tYD = (MMPinProgressBtn) view.findViewById(R.h.cVj);
        this.tYE = (ImageView) view.findViewById(R.h.cVw);
        this.tYC.setImageResource(R.k.dAI);
        this.tYF = (ImageView) view.findViewById(R.h.cVe);
        this.tYh.setVisibility(8);
        this.tYc.setVisibility(8);
        this.tYF.setVisibility(8);
        this.tYg.setTag(this);
        this.tYg.setOnClickListener(this.npY);
    }

    public final void a(b bVar, int i, int i2) {
        Bitmap bitmap;
        j jVar = (j) bVar;
        Bitmap QU = c.QU(jVar.fvC);
        if (QU == null && e.bO(jVar.fCa)) {
            QU = com.tencent.mm.pluginsdk.model.c.Rs(jVar.fCa);
            if (QU != null) {
                try {
                    if (e.bO(jVar.fvC)) {
                        com.tencent.mm.loader.stub.b.deleteFile(jVar.fvC);
                    }
                    com.tencent.mm.pluginsdk.k.e.a(QU, CompressFormat.JPEG, jVar.fvC);
                    bitmap = QU;
                } catch (Exception e) {
                }
                if (bitmap == null) {
                    LayoutParams layoutParams = this.tYE.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.tYE.setLayoutParams(layoutParams);
                    this.tYE.setImageBitmap(bitmap);
                    this.tYE.setBackground(null);
                } else {
                    DisplayMetrics displayMetrics = this.tYE.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 40.0f) + 0.5f;
                    LayoutParams layoutParams2 = this.tYE.getLayoutParams();
                    layoutParams2.width = displayMetrics.widthPixels - ((int) f);
                    layoutParams2.height = (layoutParams2.width * 52) / 68;
                    this.tYE.setLayoutParams(layoutParams2);
                }
                if (bVar.tRA) {
                    this.tYF.setVisibility(8);
                } else {
                    this.tYF.setVisibility(0);
                }
                super.a(bVar, i, i2);
            }
        }
        bitmap = QU;
        if (bitmap == null) {
            DisplayMetrics displayMetrics2 = this.tYE.getResources().getDisplayMetrics();
            float f2 = (displayMetrics2.density * 40.0f) + 0.5f;
            LayoutParams layoutParams22 = this.tYE.getLayoutParams();
            layoutParams22.width = displayMetrics2.widthPixels - ((int) f2);
            layoutParams22.height = (layoutParams22.width * 52) / 68;
            this.tYE.setLayoutParams(layoutParams22);
        } else {
            LayoutParams layoutParams3 = this.tYE.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            this.tYE.setLayoutParams(layoutParams3);
            this.tYE.setImageBitmap(bitmap);
            this.tYE.setBackground(null);
        }
        if (bVar.tRA) {
            this.tYF.setVisibility(8);
        } else {
            this.tYF.setVisibility(0);
        }
        super.a(bVar, i, i2);
    }

    public final int bXO() {
        return 6;
    }
}
