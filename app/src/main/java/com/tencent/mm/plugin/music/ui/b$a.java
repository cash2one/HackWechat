package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.av.c;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.plugin.music.model.e.b;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.z.ar;
import com.tencent.smtt.sdk.WebView;

public class b$a {
    com.tencent.mm.av.a fAA;
    private int mode = 1;
    private AnimationListener oNA = new 3(this);
    final /* synthetic */ b oNq;
    MusicItemLayout oNr;
    View oNs;
    View oNt;
    View oNu;
    CdnImageView oNv;
    TextView oNw;
    TextView oNx;
    LyricView oNy;
    boolean oNz;

    public class a extends Animation {
        final int mvv;
        final /* synthetic */ b$a oNC;
        final int oNE;
        View view;

        public a(b$a com_tencent_mm_plugin_music_ui_b_a, View view, int i) {
            this.oNC = com_tencent_mm_plugin_music_ui_b_a;
            this.view = view;
            this.mvv = i;
            this.oNE = view.getHeight();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            this.view.getLayoutParams().height = (int) (((float) this.oNE) + (((float) (this.mvv - this.oNE)) * f));
            this.view.requestLayout();
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }

        public final boolean willChangeBounds() {
            return true;
        }
    }

    public b$a(b bVar) {
        this.oNq = bVar;
    }

    public final void h(com.tencent.mm.av.a aVar, boolean z) {
        if (aVar != null) {
            x.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[]{aVar.field_songName});
            this.fAA = aVar;
            if (bh.ov(aVar.field_songHAlbumUrl)) {
                e bdz = h.bdz();
                boolean z2 = this.oNq.oLO;
                if (aVar != null) {
                    if (bdz.oJG != null) {
                        ar.CG().c(bdz.oJG);
                        bdz.oJG = null;
                    }
                    if (aVar.field_songId <= 0) {
                        x.e("MicroMsg.Music.MusicPlayerManager", "can't get songId ");
                        g.pQN.k(10911, "1");
                    } else {
                        bdz.oJG = new b(aVar, z2);
                        ar.CG().a(bdz.oJG, 0);
                    }
                }
            }
            this.oNr.setTag(this);
            if ((!com.tencent.mm.plugin.music.model.g.d(aVar) || this.oNq.scene == 3) && !bh.ov(aVar.field_songSinger)) {
                this.oNx.setText(aVar.field_songSinger);
                this.oNx.setVisibility(0);
            } else {
                this.oNx.setVisibility(8);
            }
            this.oNw.setText(aVar.field_songName);
            this.oNw.setTag(aVar.field_songName);
            LyricView lyricView = this.oNy;
            com.tencent.mm.plugin.music.model.h.a bdA = h.bdA();
            lyricView.oMT = bdA.oMS.get(aVar.field_musicId) != null ? (com.tencent.mm.plugin.music.model.a) bdA.oMS.get(aVar.field_musicId) : bdA.g(aVar, this.oNq.oLO);
            lyricView.invalidate();
            if (!com.tencent.mm.plugin.music.model.g.d(aVar) || this.oNq.oLO) {
                this.oNy.dQ(1);
            }
            beI();
            d dVar = this.oNq.oNn;
            View view = this.oNv;
            Context context = this.oNq.context;
            boolean z3 = this.oNq.oLO;
            if (z) {
                dVar.gzu.remove(aVar.field_musicId);
            }
            Bitmap bitmap = (Bitmap) dVar.gzu.get(aVar.field_musicId);
            int[] o;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = null;
                x.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[]{aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath});
                view.setTag(aVar);
                c$a com_tencent_mm_aq_a_a_c_a;
                if (aVar.Qm()) {
                    com_tencent_mm_aq_a_a_c_a = new c$a();
                    com_tencent_mm_aq_a_a_c_a.hDC = com.tencent.mm.plugin.music.model.g.c(aVar, true);
                    com_tencent_mm_aq_a_a_c_a.hDA = true;
                    com_tencent_mm_aq_a_a_c_a.hDy = true;
                    com_tencent_mm_aq_a_a_c_a.hDP = R.g.bBD;
                    if (z3) {
                        com_tencent_mm_aq_a_a_c_a.hDK = true;
                        com_tencent_mm_aq_a_a_c_a.hDL = 10;
                    }
                    o.PA().a(aVar.field_songHAlbumUrl, view, com_tencent_mm_aq_a_a_c_a.PK(), dVar.oJv);
                } else {
                    switch (aVar.field_musicType) {
                        case 0:
                        case 5:
                        case 7:
                        case 10:
                        case 11:
                            break;
                        case 1:
                        case 8:
                        case 9:
                            aqr com_tencent_mm_protocal_c_aqr = new aqr();
                            com_tencent_mm_protocal_c_aqr.nGJ = aVar.field_songMediaId;
                            com_tencent_mm_protocal_c_aqr.wxE = aVar.field_songAlbumUrl;
                            com_tencent_mm_protocal_c_aqr.wxF = aVar.field_songAlbumType;
                            com_tencent_mm_protocal_c_aqr.nfX = com_tencent_mm_protocal_c_aqr.wxE;
                            if (n.qQy != null) {
                                bitmap = n.qQy.b(com_tencent_mm_protocal_c_aqr);
                                if (bitmap == null) {
                                    view.setImageResource(R.g.bBD);
                                    if (!(aVar.Ql() || dVar.oJu == null)) {
                                        dVar.oJu.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                                    }
                                    n.qQy.cu(view);
                                    n.qQy.a(com_tencent_mm_protocal_c_aqr, view, context.hashCode(), an.xyY);
                                    dVar.oJw.removeCallbacksAndMessages(null);
                                    dVar.oJw.postDelayed(new d.b(dVar, aVar), 1000);
                                    break;
                                }
                                bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                                break;
                            }
                            break;
                        case 4:
                            com_tencent_mm_aq_a_a_c_a = new c$a();
                            com_tencent_mm_aq_a_a_c_a.hDC = com.tencent.mm.plugin.music.model.g.c(aVar, false);
                            com_tencent_mm_aq_a_a_c_a.hDA = true;
                            com_tencent_mm_aq_a_a_c_a.hDy = true;
                            if (z3) {
                                com_tencent_mm_aq_a_a_c_a.hDK = true;
                                com_tencent_mm_aq_a_a_c_a.hDL = 10;
                            }
                            o.PA().a(aVar.field_songAlbumUrl, view, com_tencent_mm_aq_a_a_c_a.PK(), dVar.oJv);
                            break;
                        case 6:
                            bitmap = o.Pw().b(aVar.field_songAlbumLocalPath, com.tencent.mm.bv.a.getDensity(context), false);
                            break;
                        default:
                            break;
                    }
                    if (bitmap == null) {
                        bitmap = o.Pw().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bv.a.getDensity(context), false);
                    }
                    if (bitmap != null) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                    } else {
                        view.setImageResource(R.g.bBD);
                        if (!(aVar.Ql() || dVar.oJu == null)) {
                            dVar.oJu.a(aVar, new int[]{WebView.NIGHT_MODE_COLOR, -1});
                        }
                        x.i("MicroMsg.Music.MusicImageLoader", "field_songAlbumUrl:%s", new Object[]{aVar.field_songAlbumUrl});
                        if (!TextUtils.isEmpty(aVar.field_songAlbumUrl)) {
                            com_tencent_mm_aq_a_a_c_a = new c$a();
                            com_tencent_mm_aq_a_a_c_a.hDC = com.tencent.mm.plugin.music.model.g.c(aVar, true);
                            com_tencent_mm_aq_a_a_c_a.hDA = true;
                            com_tencent_mm_aq_a_a_c_a.hDy = true;
                            if (z3) {
                                com_tencent_mm_aq_a_a_c_a.hDK = true;
                                com_tencent_mm_aq_a_a_c_a.hDL = 10;
                            }
                            o.PA().a(aVar.field_songAlbumUrl, view, com_tencent_mm_aq_a_a_c_a.PK(), dVar.oJv);
                        }
                    }
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    dVar.a(aVar, bitmap);
                    view.setImageBitmap(bitmap);
                    o = c.o(bitmap);
                    if (!aVar.e(o)) {
                        aVar = h.bdA().M(aVar.field_musicId, o[0], o[1]);
                    }
                    if (dVar.oJu != null && aVar != null) {
                        dVar.oJu.a(aVar, o);
                        return;
                    }
                    return;
                }
                return;
            }
            x.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[]{aVar.field_musicId});
            view.setImageBitmap(bitmap);
            o = aVar.Ql() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : c.o(bitmap);
            if (dVar.oJu != null) {
                dVar.oJu.a(aVar, o);
            }
        }
    }

    public final boolean beH() {
        return this.mode == 2;
    }

    public final void beI() {
        if (!this.oNz && this.mode != 1) {
            f.cS(3, this.oNq.scene);
            if (this.oNq.oNo == 0) {
                this.oNq.oNo = this.oNs.getMeasuredHeight();
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.oNq.oNo);
                layoutParams.weight = 0.0f;
                this.oNs.setLayoutParams(layoutParams);
            }
            f.oJO = true;
            f.bdx();
            this.mode = 1;
            this.oNz = true;
            Animation aVar = new a(this, this.oNy, this.oNq.oNk);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.oNA);
            this.oNy.startAnimation(aVar);
        }
    }

    public final void beJ() {
        if (!this.oNz && this.mode != 2) {
            f.cS(2, this.oNq.scene);
            if (this.oNq.oNo == 0) {
                this.oNq.oNo = this.oNs.getMeasuredHeight();
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.oNq.oNo);
                layoutParams.weight = 0.0f;
                this.oNs.setLayoutParams(layoutParams);
            }
            f.oJO = true;
            f.bdx();
            this.mode = 2;
            this.oNz = true;
            Animation aVar = new a(this, this.oNy, this.oNq.oNl);
            aVar.setDuration(500);
            aVar.setAnimationListener(this.oNA);
            this.oNy.startAnimation(aVar);
        }
    }

    public final void beK() {
        f.oJO = true;
        f.bdx();
        if (this.mode == 1) {
            beJ();
        } else {
            beI();
        }
    }
}
