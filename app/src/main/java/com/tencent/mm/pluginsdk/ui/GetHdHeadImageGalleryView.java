package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.MMGestureGallery;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    public String qhu;
    public String username;
    public q vjH;
    private Bitmap vjI;
    private Bitmap vjJ;
    private a vjK;

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.vjK = new a(this, (byte) 0);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.vjK);
        setSelection(0);
        this.zlf = new c(this, (byte) 0);
        this.zlg = new b(this, (byte) 0);
    }

    public final void setThumbImage(Bitmap bitmap) {
        this.vjI = bitmap;
        this.vjK.notifyDataSetChanged();
    }

    public final void N(Bitmap bitmap) {
        this.vjJ = bitmap;
        this.vjK.notifyDataSetChanged();
    }
}
