package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.ui.base.FavVideoView;
import com.tencent.mm.plugin.favorite.ui.base.FavVideoView.5;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g$b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.io.File;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private boolean fBV = true;
    private String fvC;
    private String hDC;
    private Bundle kRZ;
    private boolean kSa = false;
    private g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private OnClickListener mtg = new 1(this);
    private String mvG = "";
    private OnLongClickListener mwJ = new 2(this);
    private boolean mxA = false;
    private boolean mxb = true;
    private int mxs;
    private String mxt;
    private RelativeLayout mxu;
    private ImageView mxv;
    private FavVideoView mxw;
    private LinearLayout mxx;
    private boolean mxy = true;
    private int mxz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (d.fM(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.kRZ = bundle;
        getWindow().addFlags(FileUtils.S_IWUSR);
        this.mxy = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.hDC = getIntent().getStringExtra("key_detail_fav_path");
        this.fvC = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.mxs = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.mxt = getIntent().getStringExtra("key_detail_statExtStr");
        this.mxz = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.fBV = getIntent().getBooleanExtra("show_share", true);
        this.mxA = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.mvG = getIntent().getStringExtra("key_detail_data_id");
        if (!e.bO(this.fvC)) {
            Bitmap Rs = c.Rs(this.hDC);
            if (Rs != null) {
                try {
                    x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    com.tencent.mm.pluginsdk.k.e.a(Rs, CompressFormat.JPEG, this.fvC);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str = "MicroMsg.FavoriteVideoPlayUI";
        String str2 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mxy);
        objArr[1] = bh.ov(this.fvC) ? "" : this.fvC;
        objArr[2] = bh.ov(this.hDC) ? "" : this.hDC;
        x.i(str, str2, objArr);
        this.mxu = (RelativeLayout) findViewById(R.h.cVB);
        this.mxw = (FavVideoView) findViewById(R.h.cVC);
        ImageView imageView = (ImageView) findViewById(R.h.cVw);
        this.mxv = (ImageView) findViewById(R.h.ckv);
        this.mxx = (LinearLayout) findViewById(R.h.cgE);
        if (!(this.mxy || this.mxx == null)) {
            this.mxx.setVisibility(0);
        }
        if (this.mxv != null) {
            this.mxv.setLayerType(2, null);
        }
        if (bh.ov(this.hDC)) {
            b(imageView);
        } else if (FileOp.bO(this.hDC)) {
            this.mxw.hDC = this.hDC;
            x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            b(imageView);
        }
        this.mxw.setOnClickListener(this.mtg);
        if (this.fBV) {
            this.mxw.setOnLongClickListener(this.mwJ);
        }
        this.kSb = new g(null);
    }

    protected final int getLayoutId() {
        return R.i.dhR;
    }

    private void b(ImageView imageView) {
        FavVideoView favVideoView = this.mxw;
        String str = this.hDC;
        boolean z = this.mxA;
        String str2 = this.mvG;
        favVideoView.hDC = str;
        if (z) {
            favVideoView.kRY.post(new 5(favVideoView));
            favVideoView.mvG = str2;
        }
        if (imageView != null) {
            if (e.bO(this.fvC)) {
                imageView.setImageBitmap(b.b(this.fvC, 1.0f));
            } else {
                imageView.setImageResource(R.g.bAQ);
            }
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT >= 12) {
                this.kSc = getIntent().getIntExtra("img_gallery_top", 0);
                this.kSd = getIntent().getIntExtra("img_gallery_left", 0);
                this.kSe = getIntent().getIntExtra("img_gallery_width", 0);
                this.kSf = getIntent().getIntExtra("img_gallery_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.mxw.getViewTreeObserver().addOnPreDrawListener(new 4(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[]{Boolean.valueOf(this.mxb)});
        if (!this.mxb) {
            this.mxw.onResume();
        }
        this.mxb = false;
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.mxw;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.kTe.isPlaying()) {
            x.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.kTe.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        setResult(0, getIntent().putExtra("key_activity_browse_time", cmZ()));
        FavVideoView favVideoView = this.mxw;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        favVideoView.kTe.stop();
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(favVideoView.mvI);
        ((r) com.tencent.mm.kernel.g.k(r.class)).getFavCdnStorage().b(favVideoView.mvI);
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
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
            Runnable 3 = new 3(this, h.a(this.mController.xIM, getString(R.l.efz), false, null));
            if (!bh.ov(stringExtra)) {
                for (String stringExtra2 : bh.F(stringExtra2.split(","))) {
                    Context context = this.mController.xIM;
                    String str2 = this.hDC;
                    String str3 = this.fvC;
                    int i3 = this.mxs;
                    String str4 = this.mxt;
                    if (context == null) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                    } else if (bh.ov(stringExtra2)) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                    } else {
                        File file = new File(str2);
                        if (!bh.ov(str2) || file.exists()) {
                            ar.Dm().F(new com.tencent.mm.plugin.favorite.a.e.5(context, stringExtra2, str2, str3, i3, str4, 3));
                        } else {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                        }
                    }
                    if (!bh.ov(str)) {
                        f.aZh().A(stringExtra2, str, s.hp(stringExtra2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.eic));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void avV() {
        this.mxx.setVisibility(8);
        int width = this.mxu.getWidth();
        int height = this.mxu.getHeight();
        if (!(this.kSe == 0 || this.kSf == 0)) {
            height = (int) ((((float) width) / ((float) this.kSe)) * ((float) this.kSf));
        }
        this.kSb.fg(width, height);
        this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
        this.kSb.a(this.mxw, this.mxv, new g$b(this) {
            final /* synthetic */ FavoriteVideoPlayUI mxB;

            {
                this.mxB = r1;
            }

            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new af().post(new 1(this));
            }
        }, null);
    }

    public void onBackPressed() {
        avV();
    }
}
