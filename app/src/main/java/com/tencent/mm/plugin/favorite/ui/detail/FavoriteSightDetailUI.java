package com.tencent.mm.plugin.favorite.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f$a;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;

public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements i, a {
    private uq fve;
    private d mtt = new d();
    private f mtx;
    private boolean mvD = false;
    private ImageView mvy;
    private FavDetailTitleView mwT;
    private FavDetailFooterView mwU;
    private FavTagEntrance mwV;
    private View mwW;
    private ImageView mwX;
    private MMPinProgressBtn mwY;
    private VideoPlayerTextureView mwZ;
    private boolean mwg = false;
    private boolean mwm = false;
    private long mxa;
    private boolean mxb = true;
    private Runnable mxc = new 5(this);
    private boolean mxd = false;

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        uq p = j.p(favoriteSightDetailUI.mtx);
        if (p == null) {
            x.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
        } else if (p.wdJ == null || (bh.ov(p.wdJ.hdo) && bh.ov(p.wdJ.hds))) {
            r1 = new Intent(context, FavoriteVideoPlayUI.class);
            r1.putExtra("key_detail_fav_scene", favoriteSightDetailUI.moJ.scene);
            r1.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.moJ.moj);
            r1.putExtra("key_detail_fav_path", j.h(p));
            r1.putExtra("key_detail_fav_thumb_path", j.i(p));
            r1.putExtra("key_detail_fav_video_duration", p.duration);
            r1.putExtra("key_detail_statExtStr", p.fGG);
            r1.putExtra("key_detail_data_valid", z);
            context.startActivity(r1);
        } else {
            x.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            r1 = new Intent(context, FavoriteFileDetailUI.class);
            r1.putExtra("key_detail_fav_scene", favoriteSightDetailUI.moJ.scene);
            r1.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.moJ.moj);
            r1.putExtra("key_detail_info_id", favoriteSightDetailUI.mtx.field_localId);
            r1.putExtra("key_detail_data_id", p.mvG);
            r1.putExtra("key_detail_can_delete", false);
            context.startActivity(r1);
        }
    }

    protected final int getLayoutId() {
        return R.i.dhW;
    }

    protected final MMLoadScrollView aIl() {
        return (MMLoadScrollView) findViewById(R.h.cJg);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        this.mxa = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mtx = h.getFavItemInfoStorage().db(this.mxa);
        if (this.mtx == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[]{Long.valueOf(this.mxa)});
            finish();
            return;
        }
        h(this.mtx);
        com.tencent.mm.plugin.favorite.a.h.m(this.mtx);
        this.fve = j.p(this.mtx);
        this.mwT = (FavDetailTitleView) findViewById(R.h.cgz);
        this.mwU = (FavDetailFooterView) findViewById(R.h.cgy);
        this.mwV = (FavTagEntrance) findViewById(R.h.chi);
        this.mwX = (ImageView) findViewById(R.h.cPl);
        this.mwY = (MMPinProgressBtn) findViewById(R.h.cVj);
        this.mwW = findViewById(R.h.bWh);
        this.mwZ = (VideoPlayerTextureView) findViewById(R.h.cVC);
        this.mvy = (ImageView) findViewById(R.h.cVw);
        this.mwV.ds(this.mtx.field_localId);
        this.mwV.aN(this.mtx.field_tagProto.wfj);
        this.mwT.F(this.mtx);
        this.mwU.F(this.mtx);
        this.mwW.setOnClickListener(new 1(this));
        this.mwZ.quG = new f$a(this) {
            final /* synthetic */ FavoriteSightDetailUI mxe;

            {
                this.mxe = r1;
            }

            public final void hX() {
                x.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
                this.mxe.mwZ;
                this.mxe.mvD = this.mxe.mwZ.start();
                ag.y(new 1(this));
            }

            public final void onError(int i, int i2) {
                x.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i == -1) {
                    this.mxe.mwZ.stop();
                    if (com.tencent.mm.a.e.bO(j.h(this.mxe.fve))) {
                        this.mxe.aJJ();
                    } else if (com.tencent.mm.a.e.bO(j.i(this.mxe.fve))) {
                        this.mxe.mvy.setVisibility(0);
                    }
                } else if (this.mxe.mvD) {
                    vh();
                } else {
                    this.mxe.mwZ.stop();
                    if (!this.mxe.mwg) {
                        this.mxe.mwg = true;
                        ag.y(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 mxf;

                            {
                                this.mxf = r1;
                            }

                            public final void run() {
                                com.tencent.mm.ui.base.h.h(this.mxf.mxe.mController.xIM, R.l.eTc, R.l.dSB);
                            }
                        });
                    }
                }
            }

            public final void vh() {
                this.mxe.mwZ.q(0.0d);
            }

            public final int cf(int i, int i2) {
                return 0;
            }

            public final void cg(int i, int i2) {
            }
        };
        setMMTitle(getString(R.l.eeK));
        setBackBtn(new 3(this));
        addIconOptionMenu(0, R.l.eRi, R.g.bDI, new OnMenuItemClickListener(this) {
            final /* synthetic */ FavoriteSightDetailUI mxe;

            {
                this.mxe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g gVar = new g(this.mxe.mController.xIM, g.ztp, false);
                gVar.rKC = new 1(this);
                gVar.rKD = new 2(this);
                gVar.bUk();
                return true;
            }
        });
        if (com.tencent.mm.a.e.bO(j.i(this.fve))) {
            Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(this.fve, this.mtx);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.mxd) {
                    this.mxd = true;
                    DisplayMetrics displayMetrics = this.mwW.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.mwW.getLayoutParams();
                    if (layoutParams == null) {
                        x.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.mwW.setLayoutParams(layoutParams);
                    }
                }
                this.mvy.setImageBitmap(a);
                this.mvy.setVisibility(0);
            }
        } else if (!bh.ov(this.fve.hbj)) {
            j.b(this.mtx, this.fve, true);
        }
        fh(false);
        h.getFavItemInfoStorage().c(this.mwV);
        h.getFavItemInfoStorage().c(this);
        h.aIs().a(this);
        e.i(this);
    }

    protected void onDestroy() {
        if (this.mwZ != null) {
            this.mwZ.quG = null;
            this.mwZ.stop();
        }
        if (this.mwV != null) {
            h.getFavItemInfoStorage().j(this.mwV);
        }
        h.getFavItemInfoStorage().j(this);
        h.aIs().b((i) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.mwZ != null) {
            if (!this.mxb) {
                aJJ();
            } else if (!this.mwZ.isPlaying()) {
                this.mwZ.start();
            }
            this.mxb = false;
        }
    }

    protected void onPause() {
        if (this.mwZ != null) {
            this.mwZ.stop();
        }
        super.onPause();
    }

    @SuppressLint({"ResourceType"})
    private void fh(boolean z) {
        if (this.mtx.isDone()) {
            if (j.e(this.fve)) {
                this.mwX.setVisibility(8);
                this.mwY.setVisibility(8);
                aJJ();
                return;
            } else if (bh.ov(this.fve.wcJ)) {
                this.mwX.setImageResource(R.k.dAI);
            } else {
                x.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                this.mwX.setImageResource(R.k.dAI);
            }
        } else if (this.mtx.aHN()) {
            if (bh.ov(this.fve.wcJ)) {
                this.mwX.setImageResource(R.k.dAI);
                if (z) {
                }
            } else {
                this.mwX.setImageResource(R.k.dAI);
                if (z) {
                    com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.dYZ));
                }
            }
        } else if (this.mtx.aHM()) {
            this.mwX.setImageResource(R.k.dAI);
            if (z) {
                com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.eSf));
            }
        } else if (this.mtx.isDownloading() || this.mtx.aHL()) {
            this.mwX.setVisibility(8);
            this.mwY.setVisibility(0);
            c zT = h.aIs().zT(this.fve.mvG);
            if (zT != null) {
                this.mwY.setProgress((int) zT.getProgress());
            } else {
                this.mwY.setProgress(0);
            }
            this.mvy.setVisibility(0);
            return;
        } else {
            x.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            this.mwX.setImageResource(R.k.dAI);
        }
        this.mwX.setVisibility(0);
        this.mwY.setVisibility(8);
        this.mvy.setVisibility(0);
    }

    public final void a(String str, l lVar) {
        int i = 0;
        x.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.mtx.field_localId)});
        f db = h.getFavItemInfoStorage().db(this.mtx.field_localId);
        if (db == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            return;
        }
        this.mtx = db;
        this.fve = j.p(db);
        c zT = h.aIs().zT(this.fve.mvG);
        if (!(zT == null || this.mwm)) {
            if (zT.field_status == 4 && h.aIs().zT(this.fve.mvG).field_extFlag != 0) {
                j.a(this.mtx, this.fve, true);
                this.mwm = true;
            }
            x.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.mwm)});
            i = this.mwm;
        }
        if (i == 0) {
            ag.K(this.mxc);
            ag.h(this.mxc, 500);
        }
    }

    public final void a(c cVar) {
        if (cVar == null || cVar.field_dataId == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            return;
        }
        x.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[]{this.fve.mvG, cVar.field_dataId, Integer.valueOf(cVar.field_offset), Integer.valueOf(cVar.field_totalLen), Integer.valueOf(cVar.field_status), Integer.valueOf(cVar.field_type)});
        if (cVar.field_offset > cVar.field_totalLen) {
            x.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == cVar.field_type) {
                cVar.field_status = 2;
            } else {
                cVar.field_status = 4;
            }
            h.aIs().a(cVar, new String[0]);
            if (cVar.field_type == 0) {
                b.e(cVar);
            }
            if (cVar.field_type == 1) {
                b.f(cVar);
            }
        }
        if (cVar.field_dataId.equals(this.fve.mvG)) {
            this.mwY.post(new 6(this, (int) cVar.getProgress()));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            com.tencent.mm.plugin.favorite.a.e.a(this.mController.xIM, stringExtra, str, this.mtx, new 7(this, com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null)));
            boolean eV = s.eV(stringExtra);
            com.tencent.mm.plugin.favorite.a.h.a(eV ? com.tencent.mm.plugin.favorite.a.h.c.mqe : com.tencent.mm.plugin.favorite.a.h.c.mqd, this.mtx, com.tencent.mm.plugin.favorite.a.h.d.mqh, eV ? m.gl(stringExtra) : 0);
            com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.eic));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void aJJ() {
        String h = j.h(this.fve);
        if (com.tencent.mm.a.e.bO(h)) {
            this.mwZ.stop();
            this.mwZ.setMute(true);
            this.mwZ.setVideoPath(h);
        }
    }

    protected final String i(f fVar) {
        if (this.mtx.field_favProto.weU.size() > 0) {
            return String.valueOf(j.p(this.mtx).duration);
        }
        return "0";
    }
}
