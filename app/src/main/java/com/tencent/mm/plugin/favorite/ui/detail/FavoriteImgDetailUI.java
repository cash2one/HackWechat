package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements i {
    private c msq = new 9(this);
    private OnClickListener mtg = new 4(this);
    private LinearLayout mwA;
    private FavDetailTitleView mwB;
    private FavDetailFooterView mwC;
    private FavTagEntrance mwD;
    private int mwE = 0;
    private f mwF;
    private HashMap<String, a> mwG = new HashMap();
    private Bitmap mwH;
    private boolean mwI = true;
    private OnLongClickListener mwJ = new 5(this);

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar) {
        l lVar = aVar.jni;
        lVar.rKC = new 6(favoriteImgDetailUI, aVar);
        lVar.rKD = new 7(favoriteImgDetailUI, aVar);
        lVar.bBX();
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar, Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            bitmap = favoriteImgDetailUI.k(aVar.fve);
        }
        if (bitmap != null) {
            x.d("MicroMsg.FavoriteImgDetailUI", "update view bmp[%d, %d], displayWidth %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(favoriteImgDetailUI.mwE));
        }
        if (bitmap.getWidth() > favoriteImgDetailUI.mwE / 3) {
            LayoutParams layoutParams = aVar.fvf.getLayoutParams();
            layoutParams.height = (int) ((((float) favoriteImgDetailUI.mwE) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
            if (layoutParams.height > 2048) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (VERSION.SDK_INT >= 11) {
                    n nVar = new n();
                    if (width >= 2048 || height >= 2048) {
                        i = 1;
                    }
                }
                if (i != 0) {
                    layoutParams.height = WXMediaMessage.TITLE_LENGTH_LIMIT;
                    aVar.fvf.setScaleType(ScaleType.CENTER_CROP);
                } else {
                    aVar.fvf.setScaleType(ScaleType.FIT_XY);
                }
            } else {
                aVar.fvf.setScaleType(ScaleType.FIT_XY);
            }
        } else {
            LayoutParams layoutParams2 = aVar.fvf.getLayoutParams();
            if (bitmap.getHeight() > 2048) {
                layoutParams2.height = WXMediaMessage.TITLE_LENGTH_LIMIT;
                aVar.fvf.setScaleType(ScaleType.CENTER_CROP);
            } else {
                if (aVar.fvf.getMinimumWidth() > bitmap.getWidth()) {
                    layoutParams2.width = aVar.fvf.getMinimumWidth();
                }
                aVar.fvf.setScaleType(ScaleType.FIT_CENTER);
            }
        }
        com.tencent.mm.sdk.platformtools.l.k(aVar.fvf, bitmap.getWidth(), bitmap.getHeight());
        String h = j.h(aVar.fve);
        if (p.UR(h)) {
            try {
                Drawable cP = b.aSk().cP(h + "_detail", h);
                aVar.fvf.setImageDrawable(cP);
                cP.stop();
                cP.start();
                return;
            } catch (Exception e) {
            }
        }
        aVar.fvf.setImageBitmap(bitmap);
    }

    static /* synthetic */ void b(a aVar) {
        com.tencent.mm.sdk.b.b mpVar = new mp();
        mpVar.fEA.filePath = j.h(aVar.fve);
        a.xef.m(mpVar);
        aVar.mwR = true;
    }

    protected final MMLoadScrollView aIl() {
        return (MMLoadScrollView) findViewById(R.h.cJg);
    }

    protected final int getLayoutId() {
        return R.i.dhV;
    }

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        aJI();
        this.mwA = (LinearLayout) findViewById(R.h.cgQ);
        this.mwB = (FavDetailTitleView) findViewById(R.h.cgz);
        this.mwC = (FavDetailFooterView) findViewById(R.h.cgy);
        this.mwD = (FavTagEntrance) findViewById(R.h.chi);
        this.mwF = h.getFavItemInfoStorage().db(getIntent().getLongExtra("key_detail_info_id", -1));
        if (this.mwF == null) {
            finish();
            return;
        }
        h(this.mwF);
        this.mwB.F(this.mwF);
        this.mwC.F(this.mwF);
        Iterator it = this.mwF.field_favProto.weU.iterator();
        int i = 0;
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            x.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", Integer.valueOf(i), uqVar.mvG);
            a aVar = new a(this, (byte) 0);
            aVar.fve = uqVar;
            int i2 = i + 1;
            View imageView = new ImageView(this.mController.xIM);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvS);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.mwA.addView(imageView, layoutParams);
            imageView.setTag(uqVar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 50));
            imageView.setMinimumHeight(com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 50));
            imageView.setImageResource(R.k.dyy);
            imageView.setOnClickListener(this.mtg);
            imageView.setOnLongClickListener(this.mwJ);
            aVar.fvf = imageView;
            this.mwG.put(uqVar.mvG, aVar);
            a(aVar);
            if (uqVar.wdR != 0) {
                this.mwI = false;
            }
            i = i2;
        }
        this.mwD.ds(this.mwF.field_localId);
        this.mwD.aN(this.mwF.field_tagProto.wfj);
        setMMTitle(getString(R.l.eeK));
        setBackBtn(new 1(this));
        addIconOptionMenu(0, R.l.eRi, R.k.duY, new 2(this));
        e.i(this);
        h.getFavItemInfoStorage().c(this.mwD);
        h.aIs().a(this);
        a.xef.b(this.msq);
    }

    protected void onResume() {
        super.onResume();
        for (Entry value : this.mwG.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected void onDestroy() {
        h.getFavItemInfoStorage().j(this.mwD);
        h.aIs().b(this);
        a.xef.c(this.msq);
        super.onDestroy();
    }

    private void aJI() {
        DisplayMetrics displayMetrics;
        if (ac.getResources() != null) {
            displayMetrics = ac.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.mwE = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(R.f.buX) * 2);
        this.mwE = Math.max(this.mwE, 0);
        x.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", Integer.valueOf(this.mwE));
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aJI();
        for (Entry value : this.mwG.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected final String i(f fVar) {
        Iterator it = fVar.field_favProto.weU.iterator();
        long j = 0;
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            j = uqVar.wde + (j + uqVar.wdp);
        }
        return String.valueOf(j);
    }

    private void a(a aVar) {
        ar.Dm().F(new 3(this, aVar));
    }

    private Bitmap k(uq uqVar) {
        boolean z = true;
        Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(uqVar, this.mwF);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (a != null) {
            return a;
        }
        if (this.mwH == null) {
            this.mwH = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.k.dyy);
        }
        return this.mwH;
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null && cVar.isFinished()) {
            x.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", cVar.field_dataId);
            a aVar = (a) this.mwG.get(cVar.field_dataId);
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                d dVar = new d();
                if (d.k(this.mwF)) {
                    com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.dBN));
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                x.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", stringExtra);
                com.tencent.mm.plugin.favorite.a.e.a(this.mController.xIM, stringExtra, stringExtra2, this.mwF, new 8(this, com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null)));
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
