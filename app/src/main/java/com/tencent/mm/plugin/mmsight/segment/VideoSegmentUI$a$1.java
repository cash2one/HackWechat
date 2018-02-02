package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class VideoSegmentUI$a$1 extends MMTextureView {
    final /* synthetic */ a oAg;

    VideoSegmentUI$a$1(a aVar, Context context) {
        this.oAg = aVar;
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        x.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[]{Integer.valueOf(a.a(this.oAg)), Integer.valueOf(a.b(this.oAg)), Integer.valueOf(a.c(this.oAg)), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2))});
        if (a.c(this.oAg) == 90 || a.c(this.oAg) == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            int defaultSize = View.getDefaultSize(1, i);
            int defaultSize2 = View.getDefaultSize(1, i2);
            float f = ((float) defaultSize) / 2.0f;
            float f2 = ((float) defaultSize2) / 2.0f;
            float f3 = ((float) defaultSize2) / ((float) defaultSize);
            matrix.postRotate((float) a.c(this.oAg), f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
            x.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[]{Integer.valueOf(a.c(this.oAg)), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2)});
        }
        super.onMeasure(i, i2);
    }
}
