package com.tencent.mm.plugin.subapp.ui.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class GestureGalleryUI$a extends BaseAdapter {
    final /* synthetic */ GestureGalleryUI rXs;

    public GestureGalleryUI$a(GestureGalleryUI gestureGalleryUI) {
        this.rXs = gestureGalleryUI;
    }

    public final int getCount() {
        x.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.k(this.rXs).size());
        return GestureGalleryUI.k(this.rXs).size();
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
            view = View.inflate(this.rXs, R.i.dql, null);
            aVar.nrd = (ProgressBar) view.findViewById(R.h.cEd);
            aVar.rXv = (MMAnimateView) view.findViewById(R.h.image);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        String str = (String) GestureGalleryUI.k(this.rXs).get(i);
        if (!e.bO(str)) {
            str = GestureGalleryUI.n(this.rXs).c(str, GestureGalleryUI.l(this.rXs), i, GestureGalleryUI.m(this.rXs));
        }
        if (bh.ov(str)) {
            aVar.nrd.setVisibility(0);
            aVar.rXv.setVisibility(8);
        } else {
            Bitmap bitmap;
            aVar.nrd.setVisibility(8);
            if (str == null) {
                bitmap = null;
            } else {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(str, options);
                if (bitmap != null) {
                    x.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                bitmap = d.UN(str);
                if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                    Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                    String str2 = "MicroMsg.GestureGalleryUI";
                    String str3 = "Progressive jpeg, result isNull:%b";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                    x.i(str2, str3, objArr);
                    bitmap = decodeAsBitmap;
                }
                if (bitmap == null) {
                    x.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                    bitmap = null;
                }
            }
            if (p.UR(str)) {
                try {
                    aVar.rXv.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    aVar.rXv.setVisibility(0);
                    aVar.rXv.Cq(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.GestureGalleryUI", bh.i(e));
                    aVar.rXv.setVisibility(0);
                    aVar.rXv.setImageBitmap(bitmap);
                }
            } else if (!(bitmap == null || bitmap.isRecycled())) {
                aVar.rXv.setVisibility(8);
                view = new MultiTouchImageView(this.rXs, bitmap.getWidth(), bitmap.getHeight());
                if (VERSION.SDK_INT == 20) {
                    view.setLayerType(1, null);
                } else {
                    l.k(view, bitmap.getWidth(), bitmap.getHeight());
                }
                view.rCd = false;
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(bitmap);
            }
        }
        return view;
    }
}
