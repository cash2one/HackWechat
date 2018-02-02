package com.tencent.mm.ui.chatting;

import android.graphics.Matrix;
import com.tencent.mm.sdk.platformtools.x;

class ChattingImageBGView$1 implements Runnable {
    final /* synthetic */ ChattingImageBGView ysy;

    ChattingImageBGView$1(ChattingImageBGView chattingImageBGView) {
        this.ysy = chattingImageBGView;
    }

    public final void run() {
        if (ChattingImageBGView.a(this.ysy) == null) {
            x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but bmp is null");
            return;
        }
        if (ChattingImageBGView.a(this.ysy).getWidth() == 0) {
            x.w("MicroMsg.ChattingImageBGView", "want to reset matrix, but measured width error");
        }
        Matrix matrix = new Matrix();
        float measuredWidth = ((float) this.ysy.getMeasuredWidth()) / ((float) ChattingImageBGView.a(this.ysy).getWidth());
        float measuredHeight = ((float) this.ysy.getMeasuredHeight()) / ((float) ChattingImageBGView.a(this.ysy).getHeight());
        x.d("MicroMsg.ChattingImageBGView", "scaleW[%f], scaleH[%f] measured width[%d] measured height[%d]", new Object[]{Float.valueOf(measuredWidth), Float.valueOf(measuredHeight), Integer.valueOf(this.ysy.getMeasuredWidth()), Integer.valueOf(this.ysy.getMeasuredHeight())});
        if (measuredWidth > measuredHeight) {
            matrix.setScale(measuredWidth, measuredWidth);
        } else {
            matrix.setScale(measuredHeight, measuredHeight);
            matrix.postTranslate((((float) this.ysy.getMeasuredWidth()) - (((float) ChattingImageBGView.a(this.ysy).getWidth()) * measuredHeight)) / 2.0f, 0.0f);
        }
        this.ysy.setImageMatrix(matrix);
    }
}
