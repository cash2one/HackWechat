package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d$a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private String beo;
    public String gAb;
    private i ibT;
    private int irz;
    private rw lGW = new rw();
    private EmojiInfo lGX;
    private View lGY;
    private MMAnimateView lGZ;
    private ImageView lHa;
    private Button lHb;
    private Button lHc;
    private OnClickListener lHd = new 1(this);
    private OnClickListener lHe = new 2(this);
    private View.OnClickListener lHf = new 3(this);
    private com.tencent.mm.aq.a.c.i lHg = new 4(this);
    private c lHh = new 5(this);
    private ProgressBar lpy;
    private long lxP;
    private d$a lxw = new 6(this);
    private af mHandler = new af();

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, rw rwVar) {
        if (bh.ov(emojiStoreV2SingleProductDialogUI.gAb)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_Msg_thumb_path", rwVar.vZL);
            intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
            d.a(emojiStoreV2SingleProductDialogUI, ".ui.transmit.SelectConversationUI", intent, 9001);
            emojiStoreV2SingleProductDialogUI.overridePendingTransition(R.a.bqo, R.a.bqa);
            return;
        }
        emojiStoreV2SingleProductDialogUI.a(emojiStoreV2SingleProductDialogUI.gAb, rwVar);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, rw rwVar) {
        if (rwVar != null) {
            EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(rwVar.vZL);
            ar.Hg();
            String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), rwVar.vIR, rwVar.vZL);
            if (XU == null && e.bO(H)) {
                int i = p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl;
                EmojiInfo emojiInfo = new EmojiInfo();
                emojiInfo.field_md5 = rwVar.vZL;
                emojiInfo.field_catalog = EmojiInfo.xAe;
                emojiInfo.field_type = i;
                emojiInfo.field_size = e.bN(H);
                emojiInfo.field_temp = 1;
                emojiInfo.field_designerID = rwVar.vZM;
                emojiInfo.field_thumbUrl = rwVar.pbP;
                com.tencent.mm.plugin.emoji.model.i.aBE().lwL.n(emojiInfo);
                XU = emojiInfo;
            }
            if (XU != null) {
                com.tencent.mm.plugin.emoji.model.i.aBA().a(emojiStoreV2SingleProductDialogUI, XU, 5, q.FS());
                return;
            }
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "add failed");
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        if (emojiStoreV2SingleProductDialogUI.mHandler != null) {
            emojiStoreV2SingleProductDialogUI.mHandler.post(new 8(emojiStoreV2SingleProductDialogUI));
        }
    }

    public void onCreate(Bundle bundle) {
        View view;
        String str;
        a aVar;
        i akx;
        super.onCreate(bundle);
        setContentView(R.i.bHb);
        this.irz = getIntent().getIntExtra("scene", 0);
        this.lxP = getIntent().getLongExtra("searchID", 0);
        this.gAb = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                this.lGW = (rw) this.lGW.aF(byteArrayExtra);
                if (this.lGW != null) {
                    this.lGX = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.lGW.vZL);
                    if (!(this.lGX == null || bh.ov(this.lGX.field_groupId) || !bh.ov(this.lGW.vIR))) {
                        this.lGW.vIR = this.lGX.field_groupId;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.b.a.xef.b(this.lHh);
            com.tencent.mm.plugin.emoji.model.i.aBy().lxw = this.lxw;
            this.lGY = v.fv(this).inflate(R.i.dgb, null);
            this.lpy = (ProgressBar) this.lGY.findViewById(R.h.ccc);
            this.lGZ = (MMAnimateView) this.lGY.findViewById(R.h.cca);
            this.lHa = (ImageView) this.lGY.findViewById(R.h.cbX);
            this.lHa.setOnClickListener(this.lHf);
            view = this.lGY;
            str = "";
            if ((this instanceof Activity) || !isFinishing()) {
                aVar = new a(this);
                aVar.YF(str);
                aVar.dk(view);
                aVar.mi(true);
                akx = aVar.akx();
                akx.show();
                h.a(this, akx);
            } else {
                akx = null;
            }
            this.ibT = akx;
            this.ibT.a(getString(R.l.dGA), false, this.lHd);
            this.ibT.b(getString(R.l.dDL), false, this.lHe);
            this.ibT.setOnDismissListener(new 7(this));
            this.lHb = this.ibT.getButton(-1);
            this.lHb.setTextColor(getResources().getColor(R.e.bsE));
            this.lHc = this.ibT.getButton(-2);
            ar.Hg();
            this.beo = EmojiLogic.H(com.tencent.mm.z.c.Fp(), this.lGW.vIR, this.lGW.vZL);
            if (e.bN(this.beo) <= 0) {
                this.lGZ.setVisibility(0);
                this.lpy.setVisibility(8);
                this.lGX = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.lGW.vZL);
                if (this.lGX == null && (this.lGX.field_reserved4 & EmojiInfo.xAz) == EmojiInfo.xAz) {
                    this.lGZ.g(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(this.lGX), "");
                } else {
                    this.lGZ.cR(this.beo, null);
                }
                aDl();
            }
            this.lGZ.setVisibility(8);
            this.lpy.setVisibility(0);
            this.lHc.setText(R.l.eak);
            this.lHb.setText(R.l.dGA);
            this.lHc.setEnabled(false);
            this.lHc.setTextColor(getResources().getColor(R.e.bsG));
            this.lHb.setEnabled(false);
            this.lHb.setTextColor(getResources().getColor(R.e.bsG));
            com.tencent.mm.aq.a.a aBe = com.tencent.mm.plugin.emoji.model.i.aBe();
            String str2 = this.lGW.nfX;
            str = this.lGW.nfX;
            aBe.a(str2, null, f.h(this.beo, new Object[]{this.lGW}), this.lHg);
            return;
        }
        setResult(0);
        finish();
        com.tencent.mm.sdk.b.a.xef.b(this.lHh);
        com.tencent.mm.plugin.emoji.model.i.aBy().lxw = this.lxw;
        this.lGY = v.fv(this).inflate(R.i.dgb, null);
        this.lpy = (ProgressBar) this.lGY.findViewById(R.h.ccc);
        this.lGZ = (MMAnimateView) this.lGY.findViewById(R.h.cca);
        this.lHa = (ImageView) this.lGY.findViewById(R.h.cbX);
        this.lHa.setOnClickListener(this.lHf);
        view = this.lGY;
        str = "";
        if (this instanceof Activity) {
        }
        aVar = new a(this);
        aVar.YF(str);
        aVar.dk(view);
        aVar.mi(true);
        akx = aVar.akx();
        akx.show();
        h.a(this, akx);
        this.ibT = akx;
        this.ibT.a(getString(R.l.dGA), false, this.lHd);
        this.ibT.b(getString(R.l.dDL), false, this.lHe);
        this.ibT.setOnDismissListener(new 7(this));
        this.lHb = this.ibT.getButton(-1);
        this.lHb.setTextColor(getResources().getColor(R.e.bsE));
        this.lHc = this.ibT.getButton(-2);
        ar.Hg();
        this.beo = EmojiLogic.H(com.tencent.mm.z.c.Fp(), this.lGW.vIR, this.lGW.vZL);
        if (e.bN(this.beo) <= 0) {
            this.lGZ.setVisibility(8);
            this.lpy.setVisibility(0);
            this.lHc.setText(R.l.eak);
            this.lHb.setText(R.l.dGA);
            this.lHc.setEnabled(false);
            this.lHc.setTextColor(getResources().getColor(R.e.bsG));
            this.lHb.setEnabled(false);
            this.lHb.setTextColor(getResources().getColor(R.e.bsG));
            com.tencent.mm.aq.a.a aBe2 = com.tencent.mm.plugin.emoji.model.i.aBe();
            String str22 = this.lGW.nfX;
            str = this.lGW.nfX;
            aBe2.a(str22, null, f.h(this.beo, new Object[]{this.lGW}), this.lHg);
            return;
        }
        this.lGZ.setVisibility(0);
        this.lpy.setVisibility(8);
        this.lGX = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.lGW.vZL);
        if (this.lGX == null) {
        }
        this.lGZ.cR(this.beo, null);
        aDl();
    }

    protected void onResume() {
        super.onResume();
        aDl();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bh.ov(stringExtra) && this.lGW != null) {
                x.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", stringExtra, this.lGW.vZL);
                a(stringExtra, this.lGW);
                com.tencent.mm.plugin.messenger.a.f.aZh().dj(intent.getStringExtra("custom_send_text"), stringExtra);
            }
        }
    }

    private void aDl() {
        this.lGX = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.lGW.vZL);
        if (this.lGX != null && this.lGX.field_catalog == EmojiGroupInfo.xAd && bh.ov(this.lGX.field_groupId)) {
            this.lHc.setEnabled(false);
            this.lHc.setText(R.l.dDL);
            this.lHc.setTextColor(getResources().getColor(R.e.bsG));
        } else if (e.bO(this.beo)) {
            this.lHc.setEnabled(true);
            this.lHc.setText(R.l.eak);
            this.lHc.setTextColor(getResources().getColor(R.e.bsE));
        } else {
            this.lHc.setEnabled(false);
            this.lHc.setEnabled(false);
            this.lHc.setText(R.l.eak);
            this.lHc.setTextColor(getResources().getColor(R.e.bsG));
        }
    }

    private void a(String str, rw rwVar) {
        if (bh.ov(str) || rwVar == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
            return;
        }
        EmojiInfo emojiInfo;
        EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(rwVar.vZL);
        if (XU == null) {
            ar.Hg();
            String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), rwVar.vIR, rwVar.vZL);
            if (e.bO(H)) {
                XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.b(rwVar.vZL, "", EmojiInfo.xAe, p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl, e.bN(H), "");
                XU.field_designerID = rwVar.vZM;
                XU.field_thumbUrl = rwVar.pbP;
            }
            emojiInfo = XU;
        } else {
            XU.field_designerID = rwVar.vZM;
            XU.field_thumbUrl = rwVar.pbP;
            emojiInfo = XU;
        }
        for (String str2 : bh.F(bh.az(str, "").split(","))) {
            if (emojiInfo != null) {
                com.tencent.mm.plugin.emoji.model.i.aBA().a(str2, emojiInfo, null);
                setResult(-1);
                finish();
                overridePendingTransition(R.a.bqk, R.a.bql);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.lHh);
        com.tencent.mm.plugin.emoji.model.i.aBy().lxw = null;
        super.onDestroy();
    }
}
