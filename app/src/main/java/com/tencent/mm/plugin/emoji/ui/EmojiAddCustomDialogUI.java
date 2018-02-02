package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements e {
    private int irz;
    private String jcx;
    private String lBq;
    private EmojiInfo lBr;
    private i lBs;
    private i lBt;
    private ProgressDialog ltM;
    private Context mContext;
    private af mHandler = new 1(this);

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        emojiAddCustomDialogUI.getString(R.l.dGO);
        emojiAddCustomDialogUI.ltM = h.a(emojiAddCustomDialogUI, str, true, new 7(emojiAddCustomDialogUI));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        this.mContext = this;
        this.jcx = getIntent().getStringExtra("extra_id");
        this.irz = getIntent().getIntExtra("extra_scence", -1);
        this.lBq = getIntent().getStringExtra("extra_username");
        if (bh.ov(this.jcx)) {
            x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            finish();
        }
        this.lBr = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.jcx);
        ar.CG().a(698, (e) this);
        ar.CG().a(423, (e) this);
        ar.CG().a(703, (e) this);
        this.mHandler.sendEmptyMessageDelayed(1001, 300);
        Context context = this.mContext;
        EmojiInfo emojiInfo = this.lBr;
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
        } else {
            b aac = b.aac(emojiInfo.ckB());
            aac.hX = com.tencent.mm.k.b.zD();
            aac.GM(com.tencent.mm.k.b.zE()).a(new 2(this, emojiInfo));
        }
    }

    protected void onDestroy() {
        ar.CG().b(698, (e) this);
        ar.CG().b(423, (e) this);
        ar.CG().b(703, (e) this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        if (type == 698) {
            if (i2 == -434) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                aCx();
                aCG();
                g.pQN.h(10431, Integer.valueOf(this.irz), this.lBr.Nr(), this.lBr.field_designerID, this.lBr.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.lBr.field_size), this.lBq, this.lBr.field_activityid);
            } else if (i == 0 && i2 == 0) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                ek ekVar = (ek) ((c) kVar).gJQ.hmh.hmo;
                if (ekVar == null || ekVar.vJM == null || ekVar.vJM.size() <= 0) {
                    aCF();
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", Integer.valueOf(ekVar.vJM.size()));
                ekVar.vJM.get(0);
                ar.CG().a(new f(this.lBr), 0);
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
            } else {
                aCE();
            }
        } else if (type == 423) {
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bh.ov(gVar.lyH) || this.lBr == null || bh.ov(this.lBr.field_groupId) || !this.lBr.field_groupId.equalsIgnoreCase(gVar.lyH)) {
                x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                i(this.lBr);
            } else if (i2 == 4) {
                aCx();
                yE(getString(R.l.dZy));
            } else if (i2 == 8) {
                aCx();
                yE(getString(R.l.dZx));
            } else if (i2 == 9) {
                aCx();
                yE(getString(R.l.dZw));
            } else if (i2 == -2) {
                aCx();
                yE(getString(R.l.dZz));
            } else {
                aCx();
                yE(getString(R.l.dZv));
            }
        } else if (type != 703) {
        } else {
            if (i == 0 && i2 == 0) {
                aCF();
            } else {
                aCE();
            }
        }
    }

    private void aCE() {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        aCx();
        h.bu(this.mContext, ac.getContext().getString(R.l.dZv));
        g.pQN.h(10431, Integer.valueOf(this.irz), this.lBr.Nr(), this.lBr.field_designerID, this.lBr.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.lBr.field_size), this.lBq, this.lBr.field_activityid);
        finish();
    }

    private void aCF() {
        x.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.lBr.field_catalog != EmojiInfo.xAk) {
            this.lBr.field_catalog = EmojiInfo.xAk;
            int ckI = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.ckI();
            if (ckI < n.aBn()) {
                ckI = n.aBn();
            } else {
                ckI++;
            }
            this.lBr.field_reserved3 = ckI;
            com.tencent.mm.plugin.emoji.model.i.aBE().lwL.p(this.lBr);
            g.pQN.h(10431, Integer.valueOf(this.irz), this.lBr.Nr(), this.lBr.field_designerID, this.lBr.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.lBr.field_size), this.lBq, this.lBr.field_activityid);
            com.tencent.mm.plugin.emoji.e.e.aAR().c(this.lBr, false);
        }
        String str = this.lBr.ckB() + "_cover";
        if (!(bh.ov(this.lBr.field_thumbUrl) || com.tencent.mm.a.e.bO(str))) {
            a aVar = new a();
            aVar.hDC = str;
            aVar.hDA = true;
            aVar.hDy = false;
            o.PA().a(this.lBr.field_thumbUrl, null, aVar.PK());
        }
        com.tencent.mm.storage.emotion.a aVar2 = com.tencent.mm.plugin.emoji.model.i.aBE().lwM;
        if (!com.tencent.mm.storage.emotion.a.ckh()) {
            com.tencent.mm.plugin.emoji.model.i.aBE().lwM.cki();
        }
        aCx();
        h.bu(this.mContext, ac.getContext().getString(R.l.dDL));
        finish();
    }

    private static void i(EmojiInfo emojiInfo) {
        x.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate ");
        List arrayList = new ArrayList();
        arrayList.add(emojiInfo.Nr());
        ar.CG().a(new c(1, arrayList), 0);
    }

    private void aCG() {
        this.lBs = h.a(this.mContext, R.l.eby, R.l.dEJ, R.l.eaB, R.l.dEn, new 3(this), new 4(this));
        if (this.lBs != null) {
            this.lBs.setOnDismissListener(new 5(this));
        }
    }

    private void yE(String str) {
        this.lBt = h.b(this, str, "", true);
        this.lBt.setOnDismissListener(new 8(this));
    }

    protected final void aCx() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1001);
        }
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }
}
