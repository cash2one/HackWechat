package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$a implements Runnable {
    private Bitmap bitmap;
    private ImageView fvf;
    final /* synthetic */ RecyclerThumbSeekBar oyG;
    private b oyI;

    RecyclerThumbSeekBar$a(RecyclerThumbSeekBar recyclerThumbSeekBar, Bitmap bitmap, ImageView imageView, b bVar) {
        this.oyG = recyclerThumbSeekBar;
        this.bitmap = bitmap;
        this.fvf = imageView;
        this.oyI = bVar;
    }

    public final void run() {
        boolean z = true;
        if (this.bitmap == null || this.bitmap.isRecycled()) {
            String str = "RecyclerThumbSeekBar";
            String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
            Object[] objArr = new Object[1];
            if (this.bitmap != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
        } else if (this.oyI == null || this.oyI.hEW || this.fvf == null) {
            x.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
        } else {
            ImageView imageView = this.fvf;
            imageView.setTag(null);
            ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
            imageView.setImageBitmap(this.bitmap);
        }
    }
}
