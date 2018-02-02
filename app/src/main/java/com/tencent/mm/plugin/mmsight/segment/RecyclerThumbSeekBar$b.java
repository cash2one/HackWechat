package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class RecyclerThumbSeekBar$b implements Runnable {
    boolean hEW = false;
    private af handler;
    private WeakReference<ImageView> hkd;
    final /* synthetic */ RecyclerThumbSeekBar oyG;
    private Bitmap oyJ;
    private int time;

    RecyclerThumbSeekBar$b(RecyclerThumbSeekBar recyclerThumbSeekBar, int i, ImageView imageView, Bitmap bitmap, af afVar) {
        this.oyG = recyclerThumbSeekBar;
        this.time = i;
        this.hkd = new WeakReference(imageView);
        this.handler = afVar;
        this.oyJ = bitmap;
    }

    public final void run() {
        if (this.hEW) {
            o.han.g(this.oyJ);
        } else if (((ImageView) this.hkd.get()) == null) {
            o.han.g(this.oyJ);
        } else {
            try {
                d bbc = RecyclerThumbSeekBar.g(this.oyG).bbc();
                if (this.oyJ == null) {
                    this.oyJ = o.han.a(new b(bbc.getScaledWidth(), bbc.getScaledHeight()));
                }
                bbc.reuseBitmap(this.oyJ);
                if (!this.hEW) {
                    this.oyJ = bbc.getFrameAtTime((long) this.time);
                }
                RecyclerThumbSeekBar.g(this.oyG).a(bbc);
                if (this.oyJ == null || this.hEW || this.hkd.get() == null) {
                    o.han.g(this.oyJ);
                } else {
                    this.handler.post(new a(this.oyG, this.oyJ, (ImageView) this.hkd.get(), this));
                }
            } catch (Exception e) {
                x.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                o.han.g(this.oyJ);
            }
        }
    }
}
