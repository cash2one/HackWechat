package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.b;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$a implements Runnable {
    private Context context;
    private int oAc;
    private int oAd;
    private int oAe;
    private b oAf;
    private ViewGroup oxy;
    final /* synthetic */ VideoSegmentUI ozX;

    private VideoSegmentUI$a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, b bVar) {
        this.ozX = videoSegmentUI;
        this.oAc = i;
        this.oAd = i2;
        this.oAe = i3;
        this.context = viewGroup.getContext();
        this.oxy = viewGroup;
        this.oAf = bVar;
    }

    public final void run() {
        if (!this.ozX.isFinishing()) {
            View 1 = new 1(this, this.context);
            int width = this.oxy.getWidth();
            int aa = a.aa(this.context, k.b.oyp);
            int top = ((View) VideoSegmentUI.j(this.ozX)).getTop() - (aa * 2);
            int i = this.oAd;
            int i2 = this.oAc;
            Point point = new Point();
            float f = ((float) i2) / ((float) i) > ((float) top) / ((float) width) ? ((float) top) / ((float) i2) : ((float) width) / ((float) i);
            point.x = (int) (((float) i) * f);
            point.y = (int) (f * ((float) i2));
            x.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.oAd), Integer.valueOf(this.oAc), Integer.valueOf(this.oAe), Integer.valueOf(aa), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
            if (point.x <= 0 || point.y <= 0) {
                x.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.oAd), Integer.valueOf(this.oAc), Integer.valueOf(aa), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                if (this.oAf != null) {
                    b bVar = this.oAf;
                    x.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                    VideoSegmentUI.m(bVar.ozX);
                    bVar.ozX.finish();
                    VideoSegmentUI.b(bVar.ozX);
                    return;
                }
                return;
            }
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
            aa += (int) (((float) (top - point.y)) / 2.0f);
            layoutParams.topMargin = aa;
            layoutParams.bottomMargin = aa;
            width = (int) (((float) (width - point.x)) / 2.0f);
            layoutParams.leftMargin = width;
            layoutParams.rightMargin = width;
            1.setSurfaceTextureListener(this.oAf);
            this.oxy.addView(1, 0, layoutParams);
        }
    }
}
