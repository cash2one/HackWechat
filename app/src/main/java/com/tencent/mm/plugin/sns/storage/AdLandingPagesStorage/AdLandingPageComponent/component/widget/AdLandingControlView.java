package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void xa(int i) {
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
                        this.fvf = (ImageView) View.inflate(this.context, this.ych, null).findViewById(f.gVS);
                        this.map.put(Integer.valueOf(i3), this.fvf);
                    }
                    this.fvf.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.fvf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fvf == null) {
                        this.fvf = (ImageView) View.inflate(this.context, this.ych, null).findViewById(f.gVS);
                        this.map.put(Integer.valueOf(i3), this.fvf);
                    }
                    this.fvf.setSelected(false);
                }
                addView(this.fvf);
            }
        }
    }
}
