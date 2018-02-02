package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.d;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$c extends a<e> {
    final /* synthetic */ RecyclerThumbSeekBar oyG;
    d oyK;
    int oyL;
    int oyM;
    private View oyN;
    private View oyO;

    private RecyclerThumbSeekBar$c(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
        this.oyK = new d(this.oyG);
        this.oyL = RecyclerThumbSeekBar.f(this.oyG);
        this.oyM = RecyclerThumbSeekBar.f(this.oyG);
    }

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        View view;
        if (i == 1 || i == 2) {
            view = new View(this.oyG.getContext());
            if (i == 1) {
                this.oyN = view;
            } else {
                this.oyO = view;
            }
            return new e(this.oyG, view, 1);
        }
        View imageView = new ImageView(this.oyG.getContext());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        imageView.setMinimumWidth(RecyclerThumbSeekBar.c(this.oyG));
        imageView.setMinimumHeight(RecyclerThumbSeekBar.d(this.oyG));
        view = new LinearLayout(this.oyG.getContext());
        view.addView(imageView, RecyclerThumbSeekBar.c(this.oyG), RecyclerThumbSeekBar.d(this.oyG));
        return new e(this.oyG, view, 0);
    }

    public final /* synthetic */ void a(t tVar, int i) {
        e eVar = (e) tVar;
        if (getItemViewType(i) == 1 || getItemViewType(i) == 2) {
            if (i == 0) {
                eVar.VU.setMinimumWidth(this.oyL);
            } else {
                eVar.VU.setMinimumWidth(this.oyM);
            }
            eVar.VU.setBackgroundColor(0);
            eVar.VU.setMinimumHeight(RecyclerThumbSeekBar.d(this.oyG));
        } else if (this.oyK != null) {
            d dVar = this.oyK;
            int b = RecyclerThumbSeekBar.b(this.oyG) * (i - 1);
            ImageView imageView = eVar.fvf;
            if (imageView != null && b >= 0) {
                x.i("RecyclerThumbSeekBar", "loadImageAsync() called with: time = [" + b + "], view = [" + imageView + "]");
                Object tag = imageView.getTag();
                b bVar = (tag == null || !(tag instanceof b)) ? null : (b) tag;
                if (bVar == null || b.a(bVar) != b) {
                    if (bVar != null) {
                        bVar.hEW = true;
                    }
                    Bitmap bitmap = (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) ? null : ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                    imageView.setImageBitmap(null);
                    Runnable bVar2 = new b(dVar.oyG, b, imageView, bitmap, dVar.handler);
                    imageView.setTag(bVar2);
                    int i2 = dVar.oyQ % dVar.otB;
                    dVar.oyQ++;
                    if (dVar.oyP[i2] != null) {
                        new af(dVar.oyP[i2].getLooper()).post(bVar2);
                        return;
                    }
                    return;
                }
                x.i("RecyclerThumbSeekBar", "SimpleImageLoader.loadImageAsync time equals %d return directly", new Object[]{Integer.valueOf(b)});
            }
        } else {
            x.e("RecyclerThumbSeekBar", "onBindViewHolder ImageLoader invoked after released.");
        }
    }

    public final int getItemViewType(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == getItemCount() - 1) {
            return 2;
        }
        return 0;
    }

    public final void o(boolean z, int i) {
        if (z) {
            if (this.oyN != null) {
                this.oyN.setMinimumWidth(i);
            }
            if (((LinearLayoutManager) RecyclerThumbSeekBar.m(this.oyG).TV).eZ() == 0) {
                RecyclerThumbSeekBar.m(this.oyG).scrollBy(i - this.oyL, 0);
            }
            this.oyL = i;
            return;
        }
        this.oyM = i;
        if (this.oyO != null) {
            this.oyO.setMinimumWidth(this.oyM);
        }
    }

    public final int getItemCount() {
        return RecyclerThumbSeekBar.i(this.oyG) <= 0 ? 0 : Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.i(this.oyG)) / ((float) RecyclerThumbSeekBar.b(this.oyG))))) + 2;
    }
}
