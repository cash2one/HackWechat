package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;

class GameGestureGalleryUI$a extends BaseAdapter {
    final /* synthetic */ GameGestureGalleryUI nrc;

    public GameGestureGalleryUI$a(GameGestureGalleryUI gameGestureGalleryUI) {
        this.nrc = gameGestureGalleryUI;
    }

    public final int getCount() {
        x.d("MicroMsg.GameGestureGalleryUI", "lstpicurl:" + GameGestureGalleryUI.b(this.nrc).size());
        return GameGestureGalleryUI.b(this.nrc).size();
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.nrc, R.i.dlI, null);
            aVar.nrd = (ProgressBar) view.findViewById(R.h.cEd);
            aVar.fyg = (ImageView) view.findViewById(R.h.image);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        aVar.nrd.setVisibility(8);
        Bitmap a = j.a(new ar((String) GameGestureGalleryUI.b(this.nrc).get(i)));
        if (a == null || a.isRecycled()) {
            aVar.nrd.setVisibility(0);
            if (!bh.ov(GameGestureGalleryUI.c(this.nrc))) {
                a = j.a(new ar(GameGestureGalleryUI.c(this.nrc)));
            }
            if (a == null || a.isRecycled()) {
                aVar.fyg.setVisibility(8);
                return view;
            }
            aVar.fyg.setImageBitmap(a);
            aVar.fyg.setVisibility(0);
            return view;
        } else if (g.coK()) {
            aVar.fyg.setVisibility(8);
            view = new MultiTouchImageView(this.nrc, a.getWidth(), a.getHeight());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(a);
            return view;
        } else {
            aVar.fyg.setImageBitmap(a);
            aVar.fyg.setVisibility(0);
            aVar.fyg.setScaleType(ScaleType.MATRIX);
            return view;
        }
    }
}
