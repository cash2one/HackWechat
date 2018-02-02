package com.tencent.mm.plugin.favorite.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI.b;
import com.tencent.mm.plugin.favorite.ui.base.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class FavImgGalleryUI$a extends BaseAdapter {
    final /* synthetic */ FavImgGalleryUI msr;
    SparseBooleanArray msu;

    private FavImgGalleryUI$a(FavImgGalleryUI favImgGalleryUI) {
        this.msr = favImgGalleryUI;
        this.msu = new SparseBooleanArray();
    }

    public final /* synthetic */ Object getItem(int i) {
        return pK(i);
    }

    public final int getCount() {
        return FavImgGalleryUI.g(this.msr).size();
    }

    public final d pK(int i) {
        if (i < FavImgGalleryUI.g(this.msr).size()) {
            return (d) FavImgGalleryUI.g(this.msr).get(i);
        }
        x.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", new Object[]{Integer.valueOf(i)});
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b(this.msr, (byte) 0);
            view = View.inflate(this.msr.mController.xIM, R.i.dhv, null);
            bVar2.msv = view.findViewById(R.h.cpd);
            bVar2.msw = (MultiTouchImageView) view.findViewById(R.h.image);
            bVar2.lAk = (ProgressBar) view.findViewById(R.h.ccV);
            bVar2.msx = (ImageView) view.findViewById(R.h.cRi);
            bVar2.msy = (TextView) view.findViewById(R.h.ccW);
            bVar2.msz = (LinearLayout) view.findViewById(R.h.cgE);
            bVar2.msA = (TextView) view.findViewById(R.h.cgF);
            bVar2.msA.setText(R.l.eeN);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        d pK = pK(i);
        boolean z = this.msu.get(i, true);
        this.msu.put(i, false);
        Bitmap a = h.a(pK.fve, pK.mvf, z);
        if (pK.mvf != null) {
            x.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(pK.mvf.field_id), Long.valueOf(pK.mvf.field_localId), Integer.valueOf(pK.mvf.field_itemStatus)});
        }
        if (pK.fve != null) {
            x.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", new Object[]{pK.fve.mvG, pK.fve.wcJ, pK.fve.wcL, Long.valueOf(pK.fve.wde), pK.fve.hbj, pK.fve.wcF, Long.valueOf(pK.fve.wdp)});
        }
        if (a == null) {
            this.msr.enableOptionMenu(false);
            x.w("MicroMsg.FavImgGalleryUI", "get big image fail");
            c zT = com.tencent.mm.plugin.favorite.h.aIs().zT(pK.fve != null ? pK.fve.mvG : "");
            if (zT == null) {
                bVar.msz.setVisibility(8);
                if (pK.mvf == null || pK.mvf.field_id >= 0) {
                    bVar.lAk.setVisibility(8);
                    bVar.msy.setVisibility(8);
                    bVar.msx.setVisibility(8);
                    bVar.msv.setVisibility(0);
                    if (pK.fve.wdR != 0) {
                        bVar.msz.setVisibility(0);
                    }
                    b(bVar, a(pK), "");
                } else {
                    bVar.lAk.setVisibility(0);
                    bVar.msy.setVisibility(0);
                    bVar.msx.setVisibility(0);
                    bVar.msv.setVisibility(8);
                    bVar.msx.setImageBitmap(a(pK));
                    bVar.lAk.setProgress(0);
                    bVar.msy.setText(new StringBuilder("0%").toString());
                }
            } else {
                x.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", new Object[]{Integer.valueOf(zT.field_status)});
                bVar.lAk.setVisibility(0);
                bVar.msy.setVisibility(0);
                bVar.msx.setVisibility(0);
                bVar.msv.setVisibility(8);
                bVar.msx.setImageBitmap(a(pK));
                int i2 = zT.field_totalLen > 0 ? ((zT.field_offset * 100) / zT.field_totalLen) - 1 : 0;
                if (i2 < 0) {
                    i2 = 0;
                }
                bVar.lAk.setProgress(i2);
                bVar.msy.setText(i2 + "%");
            }
        } else {
            this.msr.enableOptionMenu(true);
            if (p.UR(j.h(pK.fve))) {
                a(bVar, a, j.h(pK.fve));
            } else {
                a(bVar, a, "");
            }
        }
        return view;
    }

    private void a(b bVar, Bitmap bitmap, String str) {
        bVar.lAk.setVisibility(8);
        bVar.msy.setVisibility(8);
        bVar.msx.setVisibility(8);
        bVar.msv.setVisibility(0);
        bVar.msz.setVisibility(8);
        b(bVar, bitmap, str);
    }

    private Bitmap a(d dVar) {
        if (dVar != null) {
            Bitmap a = h.a(dVar.fve, dVar.mvf);
            if (a != null) {
                return a;
            }
        }
        return a.decodeResource(this.msr.getResources(), R.k.dyt);
    }

    private void b(b bVar, Bitmap bitmap, String str) {
        l.k(bVar.msw, bitmap.getWidth(), bitmap.getHeight());
        int width = bVar.msw.getWidth();
        int height = bVar.msw.getHeight();
        Matrix matrix = new Matrix();
        matrix.reset();
        float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
        x.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
        if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
            height2 = ((float) width) / ((float) bitmap.getWidth());
            if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                matrix.postScale(height2, height2);
                bitmap.getHeight();
                matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
            } else {
                matrix.postScale(1.0f, 1.0f);
                matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
            }
        } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
            width2 = ((float) width) / ((float) bitmap.getWidth());
            height2 = ((float) height) / ((float) bitmap.getHeight());
            if (width2 >= height2) {
                width2 = height2;
            }
            height2 = ((float) bitmap.getWidth()) / ((float) width);
            float height3 = ((float) bitmap.getHeight()) / ((float) height);
            if (height2 <= height3) {
                height2 = height3;
            }
            if (((double) height2) > 1.0d) {
                matrix.postScale(width2, width2);
            } else {
                width2 = 1.0f;
            }
            matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
        } else {
            width2 = ((float) bitmap.getHeight()) / 480.0f;
            height2 = 480.0f / ((float) bitmap.getHeight());
            if (((double) width2) > 1.0d) {
                matrix.postScale(width2, height2);
                matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
            } else {
                matrix.postScale(1.0f, 1.0f);
                width2 = (float) ((height - bitmap.getHeight()) / 2);
                x.d("MicroMsg.FavImgGalleryUI", " offsety " + width2);
                matrix.postTranslate(0.0f, width2);
            }
        }
        bVar.msw.setImageMatrix(matrix);
        bVar.msw.eS(bitmap.getWidth(), bitmap.getHeight());
        bVar.msw.yfr = true;
        if (bh.ov(str)) {
            bVar.msw.setImageBitmap(bitmap);
            return;
        }
        try {
            Drawable cVar = new com.tencent.mm.plugin.gif.c(str);
            MultiTouchImageView multiTouchImageView = bVar.msw;
            multiTouchImageView.yfy = true;
            multiTouchImageView.yfz = cVar;
            multiTouchImageView.setImageDrawable(multiTouchImageView.yfz);
            multiTouchImageView = bVar.msw;
            int eA = com.tencent.mm.bv.a.eA(this.msr.mController.xIM);
            multiTouchImageView.lXR = com.tencent.mm.bv.a.eB(this.msr.mController.xIM);
            multiTouchImageView.lXQ = eA;
            bVar.msw.eS(cVar.getIntrinsicWidth(), cVar.getIntrinsicHeight());
            MultiTouchImageView multiTouchImageView2 = bVar.msw;
            if (multiTouchImageView2.yfy && multiTouchImageView2.yfz != null) {
                ((com.tencent.mm.ui.e.b.a) multiTouchImageView2.yfz).start();
            }
            bVar.msw.cpV();
        } catch (Throwable e) {
            x.e("MicroMsg.FavImgGalleryUI", bh.i(e));
            bVar.msw.setImageBitmap(bitmap);
        }
    }
}
