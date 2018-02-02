package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProductFurtherInfoUI$a extends u implements a {
    private Context mContext;
    final /* synthetic */ ProductFurtherInfoUI pVB;
    List<String> pVD = new ArrayList();
    private Map<String, ImageView> pVE = new HashMap();
    private int pVF;

    public ProductFurtherInfoUI$a(ProductFurtherInfoUI productFurtherInfoUI, Context context) {
        this.pVB = productFurtherInfoUI;
        this.mContext = context;
        j.a(this);
        this.pVF = this.mContext.getResources().getColor(R.e.bsP);
    }

    private ImageView IE(String str) {
        if (this.pVE.containsKey(str)) {
            return (ImageView) this.pVE.get(str);
        }
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ScaleType.FIT_XY);
        imageView.setLayoutParams(new LayoutParams(-1, -1));
        this.pVE.put(str, imageView);
        return imageView;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        String str = (String) this.pVD.get(i);
        View IE = IE(str);
        Bitmap a = j.a(new o(str));
        if (a == null || a.isRecycled()) {
            IE.setImageBitmap(null);
            IE.setBackgroundColor(this.pVF);
        } else {
            IE.setImageBitmap(a);
            IE.setBackgroundColor(0);
        }
        try {
            viewGroup.addView(IE);
        } catch (Exception e) {
            x.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
        }
        return IE;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((ImageView) obj);
        String str = (String) this.pVD.get(i);
        if (this.pVE.containsKey(str)) {
            this.pVE.remove(str);
        }
    }

    public final int getCount() {
        return this.pVD.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void l(String str, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && !bh.ov(str)) {
            ImageView IE = IE(str);
            if (IE != null) {
                ag.y(new 1(this, IE, bitmap));
            }
        }
    }
}
