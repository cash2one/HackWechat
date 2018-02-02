package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.g$a;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.e;
import com.tencent.mm.plugin.favorite.a.h$c;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.Iterator;

public class FavoriteFileDetailUI extends BaseFavDetailReportUI implements i, a {
    private boolean fBV = true;
    private long fqk;
    private uq fve;
    private af hae;
    private TextView jCQ;
    private f kTe = null;
    private ProgressBar lAk;
    private TextView lgz;
    private com.tencent.mm.plugin.fav.a.f mqC;
    private d mtt = new d();
    private Button mvW;
    private Button mvX;
    private Button mvY;
    private MMImageView mvZ;
    private TextView mwa;
    private View mwb;
    private View mwc;
    private TextView mwd;
    private ImageView mwe;
    private TextView mwf;
    private boolean mwg = false;
    private boolean mwh = false;
    private String mwi;
    private String mwj;
    private boolean mwk = false;
    private boolean mwl = false;
    private boolean mwm = false;

    static /* synthetic */ void a(FavoriteFileDetailUI favoriteFileDetailUI, String str) {
        g$a com_tencent_mm_plugin_fav_a_g_a = favoriteFileDetailUI.moJ;
        com_tencent_mm_plugin_fav_a_g_a.moc++;
        com.tencent.mm.pluginsdk.ui.tools.a.b(favoriteFileDetailUI, str, favoriteFileDetailUI.fve.wcY, 2);
    }

    static /* synthetic */ void l(FavoriteFileDetailUI favoriteFileDetailUI) {
        int i;
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(favoriteFileDetailUI.getType() != 15 ? favoriteFileDetailUI.getType() : 16);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        gVar.h(10651, objArr);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (favoriteFileDetailUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", e.d(favoriteFileDetailUI.fve));
        } else if (favoriteFileDetailUI.getType() == 4) {
            intent.putExtra("image_path", e.d(favoriteFileDetailUI.fve));
            i = 1;
        } else {
            intent.putExtra("desc_title", favoriteFileDetailUI.fve.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        com.tencent.mm.bm.d.a((Context) favoriteFileDetailUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void p(FavoriteFileDetailUI favoriteFileDetailUI) {
        String nG = t.nG(j.h(favoriteFileDetailUI.fve));
        x.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[]{Integer.valueOf(favoriteFileDetailUI.hashCode()), r0, nG});
        if (bh.ov(nG)) {
            Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.l.eTd), 1).show();
            return;
        }
        Toast.makeText(favoriteFileDetailUI, favoriteFileDetailUI.getString(R.l.eTe, new Object[]{nG}), 1).show();
        k.b(nG, favoriteFileDetailUI);
    }

    static /* synthetic */ void t(FavoriteFileDetailUI favoriteFileDetailUI) {
        if (favoriteFileDetailUI.getType() == 8 && j.e(favoriteFileDetailUI.fve) && j.f(favoriteFileDetailUI.fve)) {
            g$a com_tencent_mm_plugin_fav_a_g_a = favoriteFileDetailUI.moJ;
            com_tencent_mm_plugin_fav_a_g_a.moc++;
            Context context = favoriteFileDetailUI.mController.xIM;
            com.tencent.mm.plugin.fav.a.f fVar = favoriteFileDetailUI.mqC;
            vg vgVar = new vg();
            vgVar.scene = favoriteFileDetailUI.moJ.scene;
            vgVar.moj = favoriteFileDetailUI.moJ.moj;
            vgVar.index = favoriteFileDetailUI.moJ.index;
            com.tencent.mm.plugin.favorite.ui.b.e.d(context, fVar, vgVar);
        }
    }

    protected final int getLayoutId() {
        return R.i.dhU;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void aJD() {
        this.mwj = getIntent().getStringExtra("key_detail_data_id");
        Iterator it = this.mqC.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (uqVar.mvG.equals(this.mwj)) {
                this.fve = uqVar;
                break;
            }
        }
        if (this.fve == null) {
            this.fve = j.p(this.mqC);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.hae = new af();
        this.fqk = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mwh = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        this.fBV = getIntent().getBooleanExtra("show_share", true);
        this.mwi = getIntent().getStringExtra("fav_note_xml");
        this.mqC = h.getFavItemInfoStorage().db(this.fqk);
        if (this.mwh && !bh.ov(this.mwi)) {
            this.mqC = j.Af(this.mwi);
        }
        if (this.mqC == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "error, cannot find download info");
            finish();
            return;
        }
        String string;
        h(this.mqC);
        com.tencent.mm.plugin.favorite.a.h.m(this.mqC);
        aJD();
        this.mvW = (Button) findViewById(R.h.cDp);
        this.mvX = (Button) findViewById(R.h.cBI);
        this.mvY = (Button) findViewById(R.h.ccw);
        this.mvZ = (MMImageView) findViewById(R.h.coO);
        this.lgz = (TextView) findViewById(R.h.cyB);
        this.jCQ = (TextView) findViewById(R.h.cSe);
        this.mwc = findViewById(R.h.ccO);
        this.mwb = findViewById(R.h.ccK);
        this.lAk = (ProgressBar) findViewById(R.h.ccJ);
        this.mwa = (TextView) findViewById(R.h.ccL);
        this.mwd = (TextView) findViewById(R.h.cOg);
        this.mwe = (ImageView) findViewById(R.h.cgG);
        this.mwf = (TextView) findViewById(R.h.cgH);
        int type = getType();
        if (4 == type) {
            setMMTitle(R.l.egS);
        } else if (15 == type) {
            setMMTitle(R.l.egS);
            findViewById(R.h.cUI).setBackgroundResource(R.e.black);
            this.lgz.setVisibility(8);
        } else {
            setMMTitle(R.l.efx);
        }
        if (this.fve.bjS == 4) {
            this.mvZ.setImageResource(R.k.dvA);
        } else {
            this.mvZ.setImageResource(r.Ry(this.fve.wcY));
        }
        this.lgz.setText(this.fve.title);
        ut utVar = this.fve.wdJ;
        if (utVar == null) {
            this.mwd.setVisibility(8);
        } else if (bh.ov(utVar.hdo)) {
            x.i("MicroMsg.FavoriteFileDetailUI", " there is no attachurl, show more info btn");
            CharSequence charSequence = utVar.hdr;
            final String str = utVar.hds;
            if (bh.ov(charSequence) || bh.ov(str)) {
                this.mwd.setVisibility(8);
            } else {
                this.mwd.setText(charSequence);
                this.mwd.setVisibility(0);
                this.mwd.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FavoriteFileDetailUI mwo;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("key_snsad_statextstr", this.mwo.fve.fGG);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        ar.CG().a(new c("", ""), 0);
                        new af(Looper.getMainLooper()).post(new 1(this, intent));
                    }
                });
            }
        } else {
            string = getResources().getString(R.l.ePM);
            if (utVar.weC / 60 > 0) {
                string = string + getResources().getString(R.l.ePO, new Object[]{Integer.valueOf(utVar.weC / 60)});
            }
            if (utVar.weC % 60 > 0) {
                string = string + getResources().getString(R.l.ePP, new Object[]{Integer.valueOf(utVar.weC % 60)});
            }
            this.mwd.setText(string + getResources().getString(R.l.ePN));
            this.mwd.setVisibility(0);
            this.mwd.setOnClickListener(new 7(this));
        }
        setBackBtn(new 8(this));
        this.mvX.setOnClickListener(new 9(this));
        string = this.fve.wcQ;
        if (!bh.ov(string)) {
            this.mvW.setOnClickListener(new 10(this, string));
        }
        this.mvY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavoriteFileDetailUI mwo;

            {
                this.mwo = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.FavoriteFileDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(this.mwo.mqC.field_id), Long.valueOf(this.mwo.mqC.field_localId), Integer.valueOf(this.mwo.mqC.field_itemStatus)});
                if (com.tencent.mm.compatible.util.f.ze()) {
                    if (this.mwo.mqC.aHM() || bh.ov(this.mwo.fve.wcJ)) {
                        j.n(this.mwo.mqC);
                    } else if (this.mwo.mwh) {
                        this.mwo.mqC.field_itemStatus = 7;
                        j.a(this.mwo.fve, 18);
                    } else {
                        j.a(this.mwo.mqC, this.mwo.fve, true);
                    }
                    this.mwo.aJF();
                    return;
                }
                com.tencent.mm.ui.base.h.h(this.mwo.mController.xIM, R.l.efU, R.l.eeE);
            }
        });
        this.mwc.setOnClickListener(new 12(this));
        if (this.fBV) {
            boolean z2;
            boolean booleanExtra = getIntent().getBooleanExtra("key_detail_can_delete", true);
            int type2 = getType();
            if (type2 == 8) {
                z = this.mqC.aHJ();
            } else if (type2 == 15) {
                z2 = this.mqC.aHJ() && bh.VI(com.tencent.mm.k.g.zY().getValue("SIGHTCannotTransmitForFav")) == 0;
                if (z2 || booleanExtra) {
                    addIconOptionMenu(0, R.l.eRi, R.g.bDI, new 13(this, z2, booleanExtra, type2));
                }
            } else if (!(this.mqC.aHK() || this.mqC.aHJ())) {
                z = false;
            }
            z2 = z;
            addIconOptionMenu(0, R.l.eRi, R.g.bDI, new 13(this, z2, booleanExtra, type2));
        }
        fg(false);
    }

    private int getType() {
        if (this.fve == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "get type but data item is null");
            return 8;
        } else if (this.fve.bjS == 0) {
            x.w("MicroMsg.FavoriteFileDetailUI", "get data type, but data item type is 0, info type %d", new Object[]{Integer.valueOf(this.mqC.field_type)});
            if (4 == this.mqC.field_type) {
                return 4;
            }
            if (16 != this.mqC.field_type) {
                return 8;
            }
            if (!(this.fve == null || this.fve.wdJ == null)) {
                if (!bh.ov(this.fve.wdJ.hdo)) {
                    return 15;
                }
                if (!bh.ov(this.fve.wdJ.hds)) {
                    return 15;
                }
            }
            return 4;
        } else if (this.fve.bjS != 15) {
            return this.fve.bjS;
        } else {
            if (!(this.fve == null || this.fve.wdJ == null)) {
                if (!bh.ov(this.fve.wdJ.hdo)) {
                    return 15;
                }
                if (!bh.ov(this.fve.wdJ.hds)) {
                    return 15;
                }
            }
            return 4;
        }
    }

    private void fg(boolean z) {
        boolean e = j.e(this.fve);
        x.i("MicroMsg.FavoriteFileDetailUI", "init status, info type %d, exist:%B path:%s", new Object[]{Integer.valueOf(this.mqC.field_itemStatus), Boolean.valueOf(e), j.h(this.fve)});
        if (this.fve.wdR != 0) {
            aJE();
        } else if (this.mqC.isDone() || e || !bh.ov(this.fve.wcJ)) {
            if (e) {
                if (!(getType() != 15 || this.fve.wdJ == null || bh.ov(this.fve.wdJ.hdo) || bh.ov(this.fve.wdJ.hds))) {
                    this.mwl = true;
                    this.mvZ.setVisibility(8);
                    this.mwb.setVisibility(8);
                    this.mvY.setVisibility(8);
                    this.mvW.setVisibility(8);
                    this.mvX.setVisibility(8);
                    this.jCQ.setVisibility(8);
                    String h = j.h(this.fve);
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zg() + " initView: fullpath:" + h);
                    ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cUI);
                    this.kTe = n.er(this.mController.xIM);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    viewGroup.addView((View) this.kTe, 0, layoutParams);
                    this.kTe.a(new f.a(this) {
                        final /* synthetic */ FavoriteFileDetailUI mwo;

                        {
                            this.mwo = r1;
                        }

                        public final void hX() {
                            x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zg() + " onPrepared");
                            this.mwo.kTe.cP(true);
                            this.mwo.kTe.start();
                        }

                        public final void onError(int i, int i2) {
                            this.mwo.kTe.stop();
                            if (!this.mwo.mwg) {
                                this.mwo.mwg = true;
                                ag.y(new 1(this));
                            }
                        }

                        public final void vh() {
                        }

                        public final int cf(int i, int i2) {
                            return 0;
                        }

                        public final void cg(int i, int i2) {
                        }
                    });
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zg() + " initView :" + h);
                    if (h != null) {
                        this.kTe.stop();
                        this.kTe.setVideoPath(h);
                    }
                    x.d("MicroMsg.FavoriteFileDetailUI", com.tencent.mm.compatible.util.g.zg() + " initView");
                    if (ar.ux() != null) {
                        ar.ux().wB();
                    }
                    g.pQN.h(11444, new Object[]{Integer.valueOf(4)});
                }
                if (getType() != 15 && getType() != 4) {
                    e = j.e(this.fve) && j.f(this.fve);
                    if (e) {
                        this.mwb.setVisibility(8);
                        this.mvY.setVisibility(8);
                        this.mvW.setVisibility(0);
                        this.mvX.setVisibility(8);
                        this.jCQ.setVisibility(8);
                        this.mvW.setOnClickListener(new 2(this));
                    } else {
                        this.mwb.setVisibility(8);
                        this.mvY.setVisibility(8);
                        if (bh.ov(this.fve.wcQ)) {
                            this.mvW.setVisibility(8);
                        } else {
                            this.mvW.setVisibility(0);
                        }
                        this.mvX.setVisibility(0);
                        this.moJ.mob = true;
                        this.jCQ.setVisibility(0);
                    }
                } else if (!this.mwl) {
                    this.mwb.setVisibility(8);
                    this.mvY.setVisibility(8);
                    this.mvW.setVisibility(8);
                    this.mvX.setVisibility(0);
                    this.mvX.setText(R.l.efI);
                    this.jCQ.setVisibility(8);
                    aJH();
                }
                ar.Dm().F(new Runnable(this) {
                    final /* synthetic */ FavoriteFileDetailUI mwo;

                    {
                        this.mwo = r1;
                    }

                    public final void run() {
                        j.v(this.mwo.mqC);
                    }
                });
            } else if (bh.ov(this.fve.wcJ)) {
                aJE();
            } else {
                x.w("MicroMsg.FavoriteFileDetailUI", "? info is done, source file not exist, cdn data url is not null");
                aJG();
            }
        } else if (this.mqC.aHN()) {
            if (bh.ov(this.fve.wcJ)) {
                aJE();
                if (z) {
                    int type = getType();
                    type = (4 == type || 15 == type) ? R.l.egp : R.l.egk;
                    com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(type));
                    return;
                }
                return;
            }
            aJG();
            if (z) {
                com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.dYZ));
            }
        } else if (this.mqC.aHM()) {
            aJG();
            if (z) {
                com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.eSf));
            }
        } else if (this.mqC.isDownloading() || this.mqC.aHL()) {
            aJF();
        } else {
            x.w("MicroMsg.FavoriteFileDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
            aJG();
        }
    }

    private void aJE() {
        this.mvZ.setVisibility(8);
        this.lgz.setVisibility(8);
        this.mvY.setVisibility(8);
        this.mvW.setVisibility(8);
        this.mvX.setVisibility(8);
        this.mwb.setVisibility(8);
        this.jCQ.setVisibility(8);
        this.mwe.setVisibility(0);
        this.mwf.setVisibility(0);
        if (this.fve.bjS == 4) {
            this.jCQ.setGravity(17);
            this.jCQ.setText(R.l.efY);
            return;
        }
        this.jCQ.setGravity(17);
        this.jCQ.setText(R.l.efX);
        if (this.fve.wdR == 2) {
            this.mwf.setText(R.l.eeL);
        } else {
            this.mwf.setText(R.l.eeM);
        }
    }

    private void aJF() {
        int progress;
        int i;
        int i2;
        this.mvY.setVisibility(8);
        this.mvW.setVisibility(8);
        this.mvX.setVisibility(8);
        this.jCQ.setVisibility(8);
        this.mwb.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(this.fve.mvG);
        if (zT != null) {
            progress = (int) zT.getProgress();
            i = zT.field_offset;
            i2 = zT.field_totalLen;
        } else {
            i2 = (int) this.fve.wde;
            i = 0;
            progress = 0;
        }
        if (this.mqC.aHL() && bh.ov(this.fve.wcJ)) {
            a((float) progress, getString(R.l.egR, new Object[]{j.ah((float) i), j.ah((float) i2)}));
            return;
        }
        a((float) progress, getString(R.l.eeV, new Object[]{j.ah((float) i), j.ah((float) i2)}));
    }

    private void aJG() {
        this.mwb.setVisibility(8);
        this.mvX.setVisibility(8);
        if (bh.ov(this.fve.wcQ)) {
            this.mvW.setVisibility(8);
        } else {
            this.mvW.setVisibility(0);
        }
        this.mvY.setVisibility(0);
        com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(this.fve.mvG);
        if (zT == null || zT.field_offset <= 0) {
            this.mvY.setText(this.mqC.aHM() ? R.l.efL : R.l.efH);
        } else {
            this.mvY.setText(this.mqC.aHM() ? R.l.efK : R.l.efJ);
        }
        this.jCQ.setVisibility(8);
    }

    protected void onDestroy() {
        setResult(0, getIntent().putExtra("key_activity_browse_time", cmZ()));
        if (this.kTe != null) {
            this.kTe.a(null);
            this.kTe.stop();
            this.kTe.onDetach();
            if (ar.ux() != null) {
                ar.ux().wA();
            }
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        h.getFavItemInfoStorage().c(this);
        h.aIs().a(this);
        if (this.kTe != null) {
            this.kTe.start();
        }
    }

    protected void onPause() {
        super.onPause();
        h.getFavItemInfoStorage().j(this);
        h.aIs().b(this);
        if (this.kTe != null) {
            this.kTe.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.dZc, R.l.dZd, 2);
        if (i2 == -1 && i == 1) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
            x.d("MicroMsg.FavoriteFileDetailUI", "do share msg, fav msg type %d", new Object[]{Integer.valueOf(getType())});
            Runnable 4 = new 4(this, a);
            int type = getType();
            if (!bh.ov(stringExtra)) {
                for (String str2 : bh.F(stringExtra.split(","))) {
                    if (type == 4 || type == 15) {
                        Context context = this.mController.xIM;
                        uq uqVar = this.fve;
                        if (context == null) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                        } else if (bh.ov(str2)) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                        } else if (uqVar == null) {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but dataItem is null");
                        } else {
                            ar.Dm().F(new e$3(uqVar, context, str2, 4));
                        }
                        boolean eV = s.eV(str2);
                        com.tencent.mm.plugin.favorite.a.h.a(eV ? h$c.Chatroom : h$c.Chat, this.mqC, com.tencent.mm.plugin.favorite.a.h.d.mqi, eV ? m.gl(str2) : 0);
                    } else {
                        e.a(this.mController.xIM, str2, this.mqC, this.fve, 4);
                    }
                    if (!bh.ov(str)) {
                        com.tencent.mm.plugin.messenger.a.f.aZh().A(str2, str, s.hp(str2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.eic));
            }
        }
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar == null || cVar.field_dataId == null) {
            x.w("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, item is null");
            return;
        }
        x.d("MicroMsg.FavoriteFileDetailUI", "on cdn status changed, dataID is %s, field id is %s", new Object[]{this.fve.mvG, cVar.field_dataId});
        if (!cVar.field_dataId.equals(this.fve.mvG)) {
            return;
        }
        if (this.mqC.aHL() && bh.ov(this.fve.wcJ)) {
            a(cVar.getProgress(), getString(R.l.egR, new Object[]{j.ah((float) cVar.field_offset), j.ah((float) cVar.field_totalLen)}));
            return;
        }
        a(cVar.getProgress(), getString(R.l.eeV, new Object[]{j.ah((float) cVar.field_offset), j.ah((float) cVar.field_totalLen)}));
        if (this.mwh && com.tencent.mm.a.e.bO(cVar.field_path)) {
            this.mqC.field_itemStatus = 10;
            a("", null);
        }
    }

    private void a(float f, String str) {
        this.hae.post(new 5(this, f, str));
    }

    public final void a(String str, l lVar) {
        int i = 0;
        x.i("MicroMsg.FavoriteFileDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[]{str, Long.valueOf(this.mqC.field_localId)});
        com.tencent.mm.plugin.fav.a.f db = h.getFavItemInfoStorage().db(this.mqC.field_localId);
        if (db != null || this.mwh) {
            if (!this.mwh) {
                this.mqC = db;
            }
            aJD();
            com.tencent.mm.plugin.fav.a.c zT = h.aIs().zT(this.fve.mvG);
            if (zT != null) {
                if (zT.field_status == 1) {
                    i = 1;
                } else if (!(this.fve.bjS == 8 || this.mwm)) {
                    if (zT.field_status == 4 && h.aIs().zT(this.fve.mvG).field_extFlag != 0) {
                        j.a(this.mqC, this.fve, true);
                        this.mwm = true;
                    }
                    x.i("MicroMsg.FavoriteFileDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[]{Boolean.valueOf(this.mwm)});
                    i = this.mwm;
                }
            }
            if (i == 0) {
                this.hae.post(new 6(this));
                return;
            }
            return;
        }
        x.w("MicroMsg.FavoriteFileDetailUI", "error, on notify change, cannot find info");
        finish();
    }

    private void aJH() {
        if (!this.mwk) {
            g$a com_tencent_mm_plugin_fav_a_g_a = this.moJ;
            com_tencent_mm_plugin_fav_a_g_a.moc++;
            this.mwk = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", j.h(this.fve));
            intent.putExtra("key_detail_fav_thumb_path", j.i(this.fve));
            intent.putExtra("key_detail_fav_video_duration", this.fve.duration);
            intent.putExtra("key_detail_statExtStr", this.fve.fGG);
            com.tencent.mm.bm.d.b(this, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }

    protected final String i(com.tencent.mm.plugin.fav.a.f fVar) {
        Iterator it = fVar.field_favProto.weU.iterator();
        long j = 0;
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            j = uqVar.wde + (j + uqVar.wdp);
        }
        return String.valueOf(j);
    }
}
