package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    public Context context;
    public int count;
    public ImageView fvf;
    public Map<Integer, ImageView> map = new HashMap();
    public int ych = h.gYa;

    public final void eR(int i, int i2) {
        this.count = i;
        xa(i2);
    }

    public MMPageControlView(Context context) {
        super(context);
        this.context = context;
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void xa(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.fvf = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.fvf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fvf == null) {
                        this.fvf = (ImageView) View.inflate(this.context, this.ych, null).findViewById(g.gVS);
                        this.map.put(Integer.valueOf(i3), this.fvf);
                    }
                    this.fvf.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.fvf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fvf == null) {
                        this.fvf = (ImageView) View.inflate(this.context, this.ych, null).findViewById(g.gVS);
                        this.map.put(Integer.valueOf(i3), this.fvf);
                    }
                    this.fvf.setSelected(false);
                }
                if (i3 == 0) {
                    this.fvf.setPadding(0, 0, 0, 0);
                }
                addView(this.fvf);
            }
        }
    }
}
