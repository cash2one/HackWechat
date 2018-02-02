package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.emoji.e.k.2;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.f.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.pluginsdk.ui.applet.e$a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.aep;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, e, a, b, c, MMPullDownView.e {
    private ListView Fv;
    private View Lr;
    private int irz;
    protected final int lAD = 131074;
    private final int lAE = 131075;
    private final int lAF = 131076;
    private final String lAG = "product_id";
    private final String lAH = "progress";
    private final String lAI = DownloadInfo.STATUS;
    private f lAL;
    private h lAM;
    private com.tencent.mm.sdk.b.c lAO = new 1(this);
    private g lAP;
    com.tencent.mm.plugin.emoji.a.f lAW;
    private int lAw = -1;
    private boolean lAx;
    private byte[] lAz;
    private TextView lFA;
    private TextView lFB;
    View lFC;
    private List<rw> lFD = new ArrayList();
    private View lFE;
    PreViewListGridView lFF;
    private d lFG;
    View lFH;
    View lFI;
    View lFJ;
    TextView lFK;
    View lFL;
    private MMPullDownView lFM;
    private aep lFN;
    private i lFO;
    private r lFP;
    private ak.b.a lFQ = new 8(this);
    private final int lFR = 10001;
    private final int lFS = 10002;
    private final int lFT = 10003;
    private p lFU;
    private int lFo;
    private String lFp;
    private String lFq;
    private x lFr;
    private View lFs;
    private BannerEmojiView lFt;
    private TextView lFu;
    private TextView lFv;
    private View lFw;
    private View lFx;
    private TextView lFy;
    private ImageView lFz;
    private long lxP;
    private String lxQ;
    private String lxU;
    private String lyT;
    private af mHandler = new af(this) {
        final /* synthetic */ EmojiStoreV2DesignerUI lFV;

        {
            this.lFV = r1;
        }

        public final void handleMessage(Message message) {
            String string;
            switch (message.what) {
                case 10001:
                    this.lFV.aDr();
                    return;
                case 10002:
                    this.lFV.updateData();
                    return;
                case 10003:
                    this.lFV.WT();
                    return;
                case 131075:
                    if (this.lFV.lAW != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.lFV.lAW.bd(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (this.lFV.lAW != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            this.lFV.lAW.bc(string, message.getData().getInt(DownloadInfo.STATUS));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.lFo != 0) {
            Intent intent = new Intent();
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, emojiStoreV2DesignerUI.lFo);
            intent.setClass(emojiStoreV2DesignerUI.mController.xIM, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
    }

    static /* synthetic */ void h(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.lFN != null && !bh.ov(emojiStoreV2DesignerUI.lFN.vLr)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.lFN.vLr);
            d.b(emojiStoreV2DesignerUI.mController.xIM, "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.report.service.g.pQN.h(12067, new Object[]{Integer.valueOf(3), "", "", "", ""});
        }
    }

    static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(emojiStoreV2DesignerUI.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new 5(emojiStoreV2DesignerUI);
        gVar.rKD = new 6(emojiStoreV2DesignerUI);
        gVar.bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.lFo)});
    }

    protected final int getLayoutId() {
        return R.i.dfO;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.lyT = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.lFo = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.lxU = getIntent().getStringExtra("name");
        this.lFp = getIntent().getStringExtra("headurl");
        this.lFq = getIntent().getStringExtra("rediret_url");
        this.irz = getIntent().getIntExtra("extra_scence", 0);
        this.lxP = getIntent().getLongExtra("searchID", 0);
        this.lxQ = bh.az(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lFo = EmojiLogic.yj(stringExtra);
            this.lxU = EmojiLogic.yk(stringExtra);
            this.lFq = EmojiLogic.yp(stringExtra);
        }
        initView();
        if (!bh.ov(this.lyT)) {
            abl XY = com.tencent.mm.plugin.emoji.model.i.aBE().lwR.XY(this.lyT);
            if (XY == null || XY.wkv == null || XY.wkv.wko == 0 || bh.ov(XY.wkv.nfp)) {
                z = true;
                if (z) {
                    WT();
                } else {
                    this.lFO = new i(this.lyT);
                    ar.CG().a(this.lFO, 0);
                    getString(R.l.dGO);
                    this.lFP = com.tencent.mm.ui.base.h.a(this, getString(R.l.dHc), true, new 7(this));
                }
                ar.CG().a(ai.CTRL_BYTE, this);
                ar.CG().a(720, this);
                com.tencent.mm.sdk.b.a.xef.b(this.lAO);
                com.tencent.mm.plugin.report.service.g.pQN.h(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
                com.tencent.mm.plugin.report.service.g.pQN.h(12740, new Object[]{Integer.valueOf(2), o.getString(this.lFo), "", "", Integer.valueOf(this.irz)});
            }
            this.lFo = XY.wkv.wko;
            this.lxU = XY.wkv.nfp;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[]{Integer.valueOf(this.lFo), this.lxU});
        }
        z = false;
        if (z) {
            this.lFO = new i(this.lyT);
            ar.CG().a(this.lFO, 0);
            getString(R.l.dGO);
            this.lFP = com.tencent.mm.ui.base.h.a(this, getString(R.l.dHc), true, new 7(this));
        } else {
            WT();
        }
        ar.CG().a(ai.CTRL_BYTE, this);
        ar.CG().a(720, this);
        com.tencent.mm.sdk.b.a.xef.b(this.lAO);
        com.tencent.mm.plugin.report.service.g.pQN.h(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
        com.tencent.mm.plugin.report.service.g.pQN.h(12740, new Object[]{Integer.valueOf(2), o.getString(this.lFo), "", "", Integer.valueOf(this.irz)});
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(423, this);
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(423, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lFU != null) {
            ar.CG().c(this.lFU);
        }
        ar.CG().b(ai.CTRL_BYTE, this);
        ar.CG().b(720, this);
        com.tencent.mm.sdk.b.a.xef.c(this.lAO);
    }

    protected final void initView() {
        if (!bh.ov(this.lxU)) {
            setMMTitle(this.lxU);
        }
        this.Lr = v.fv(this.mController.xIM).inflate(R.i.dfN, null);
        this.lFs = this.Lr.findViewById(R.h.caY);
        this.lFt = (BannerEmojiView) this.lFs.findViewById(R.h.cdn);
        this.lFu = (TextView) this.Lr.findViewById(R.h.cba);
        this.lFv = (TextView) this.Lr.findViewById(R.h.caW);
        this.lFw = this.Lr.findViewById(R.h.caV);
        this.lFx = this.Lr.findViewById(R.h.caU);
        this.lFy = (TextView) this.Lr.findViewById(R.h.cbi);
        this.lFz = (ImageView) this.Lr.findViewById(R.h.caZ);
        this.lFA = (TextView) this.Lr.findViewById(R.h.caX);
        this.lFB = (TextView) this.Lr.findViewById(R.h.cbj);
        this.lFC = this.Lr.findViewById(R.h.cbb);
        this.lFE = this.Lr.findViewById(R.h.cbe);
        this.lFE.setOnClickListener(new 10(this));
        this.lFF = (PreViewListGridView) this.Lr.findViewById(R.h.cbd);
        this.lFG = new d(this.mController.xIM);
        this.lFG.lIu = new 11(this);
        this.lFF.setAdapter(this.lFG);
        this.lFH = this.Lr.findViewById(R.h.cbf);
        this.lFI = this.Lr.findViewById(R.h.cbg);
        this.lFJ = this.Lr.findViewById(R.h.cbe);
        this.lFK = (TextView) this.Lr.findViewById(R.h.cbh);
        this.lFL = this.Lr.findViewById(R.h.cbc);
        this.lFM = (MMPullDownView) findViewById(R.h.cto);
        this.lFM.ycq = this;
        this.lFM.ycB = this;
        this.lFM.mo(false);
        this.lFM.mn(false);
        this.Fv = (ListView) findViewById(16908298);
        this.Fv.setOnItemClickListener(this);
        this.Fv.setOnScrollListener(this);
        this.lFx.setOnClickListener(new 12(this));
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI lFV;

            {
                this.lFV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lFV.finish();
                return false;
            }
        });
        addIconOptionMenu(0, R.k.dzQ, new 14(this));
    }

    private void WT() {
        setMMTitle(this.lxU);
        this.lAW = new com.tencent.mm.plugin.emoji.a.f(this.mController.xIM);
        this.Fv.addHeaderView(this.Lr);
        this.Fv.setAdapter(this.lAW);
        this.lAW.luC = this;
        this.lAW.ltX = n.aBk();
        this.lAW.ltY = false;
        this.lFu.setText(this.lxU);
        this.lFN = com.tencent.mm.plugin.emoji.model.i.aBE().lwO.Yd(String.valueOf(this.lFo));
        this.lAM = new h();
        this.lAM.kaK = this;
        this.lAM.lxL = this.lAW;
        this.lAM.lxO = 6;
        this.lAM.lxR = this;
        this.lAM.lxU = this.lxU;
        this.lAM.lxP = this.lxP;
        this.lAM.lxQ = this.lxQ;
        if (this.lFN != null) {
            c(p.a(this.lFN));
            List list = this.lFN.vLk;
            LinkedList linkedList = this.lFN.wkI;
            aC(list);
        }
        updateData();
        al(this.lAz);
    }

    private void updateData() {
        if (this.lFN == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            return;
        }
        aDr();
        if (bh.ov(this.lFN.vLr)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.lFw.setVisibility(8);
            this.lFx.setVisibility(8);
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[]{this.lFN.vLr});
            ar.Hg();
            this.lFr = com.tencent.mm.z.c.EY().WO(this.lFN.vLr);
        }
        if ((this.lFr == null || ((int) this.lFr.gJd) == 0) && ak.a.hfL != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[]{this.lFN.vLr});
            ak.a.hfL.a(this.lFN.vLr, "", this.lFQ);
        }
        this.lFA.setText(R.l.ebj);
        if (bh.ov(this.lFN.nfe)) {
            this.lFv.setVisibility(8);
        } else {
            this.lFv.setText(this.lFN.nfe);
            this.lFv.setVisibility(0);
        }
        aDs();
        if (this.lAL == null || this.lAL.lxC == null || this.lAL.lxC.isEmpty()) {
            this.lFB.setVisibility(8);
        } else {
            this.lFB.setVisibility(0);
        }
    }

    protected final void aDr() {
        if (this.lFN == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header faild. data is null.");
        } else if (this.lFt != null && !bh.ov(this.lFN.wmG)) {
            String str = this.lFN.wmG;
            com.tencent.mm.bv.a.getDensity(this);
            EmojiInfo a = EmojiLogic.a("Designer", 8, str, true);
            if (a == null) {
                com.tencent.mm.aq.o.PA().a(this.lFN.wmG, null, com.tencent.mm.plugin.emoji.e.f.c("Designer", this.lFN.wmG, new Object[]{"Designer", "BANNER"}), new 15(this));
                return;
            }
            this.lFt.cR(a.ckB(), null);
        }
    }

    private void aDs() {
        if (this.lFr == null || ((int) this.lFr.gJd) == 0) {
            this.lFx.setVisibility(8);
            this.lFw.setVisibility(8);
            return;
        }
        this.lFx.setVisibility(0);
        this.lFw.setVisibility(0);
        if (bh.ov(this.lFr.AP())) {
            this.lFy.setText(this.lFr.field_username);
        } else {
            this.lFy.setText(this.lFr.AP());
        }
        com.tencent.mm.pluginsdk.ui.a.b.o(this.lFz, this.lFr.field_username);
        this.lFA.setEnabled(true);
    }

    private void al(byte[] bArr) {
        this.lAx = true;
        this.lFU = new p(this.lFo, bArr);
        ar.CG().a(this.lFU, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case ai.CTRL_BYTE /*239*/:
                if (this.lFP != null && this.lFP.isShowing()) {
                    this.lFP.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    abl aBQ = ((i) kVar).aBQ();
                    if (aBQ != null && aBQ.wkv != null) {
                        this.lFo = aBQ.wkv.wko;
                        this.lxU = aBQ.wkv.nfp;
                        this.lFp = aBQ.wkv.waN;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                            return;
                        }
                        return;
                    }
                    return;
                }
                showOptionMenu(0, false);
                com.tencent.mm.ui.base.h.b(this.mController.xIM, getString(R.l.dZO), null, true);
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                return;
            case 423:
                g gVar = (g) kVar;
                if (i == 0 && i2 == 0) {
                    bd(gVar.lyH, 0);
                    return;
                }
                String str2 = gVar.lyH;
                String str3 = gVar.lyJ;
                String str4 = gVar.lyI;
                com.tencent.mm.ui.base.h.a(this, getString(R.l.eat, new Object[]{str4}), "", new 3(this, str2, str3, str4), new 4(this));
                bc(gVar.lyH, -1);
                return;
            case 720:
                this.lAx = false;
                if (i == 0 || i == 4) {
                    p pVar = (p) kVar;
                    f a = p.a(pVar.aBX());
                    if (i2 == 0) {
                        this.lFN = pVar.aBX();
                        c(a);
                    } else if (i2 == 2) {
                        this.lFN = pVar.aBX();
                        b(this.lAw, a);
                        this.lAw = 2;
                    } else if (i2 == 3) {
                        this.lFN = pVar.aBX();
                        b(this.lAw, a);
                        this.lAw = 1;
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[]{Integer.valueOf(i2)});
                    }
                    if (this.lAz == null && this.lFN != null) {
                        com.tencent.mm.plugin.emoji.model.i.aBE().lwO.a(String.valueOf(this.lFo), pVar.aBX());
                        this.lFD = this.lFN.vLk;
                        List list = this.lFD;
                        LinkedList linkedList = this.lFN.wkI;
                        aC(list);
                    }
                    this.lAz = pVar.lyZ;
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                return;
            default:
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                return;
        }
    }

    private void aC(final List<rw> list) {
        int i = 1;
        String value = com.tencent.mm.k.g.zY().getValue("ShowDesignerEmoji");
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[]{value});
        if (bh.ov(value) || bh.VI(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || r0 == 0) {
            this.lFC.setVisibility(8);
            return;
        }
        this.lFC.setVisibility(0);
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ EmojiStoreV2DesignerUI lFV;

            public final void run() {
                int i;
                int i2 = 8;
                EmojiStoreV2DesignerUI emojiStoreV2DesignerUI = this.lFV;
                if (list.size() > 3) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (emojiStoreV2DesignerUI.lFF != null) {
                    emojiStoreV2DesignerUI.lFF.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.lFI != null) {
                    emojiStoreV2DesignerUI.lFI.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.lFH != null) {
                    emojiStoreV2DesignerUI.lFH.setVisibility(0);
                }
                if (emojiStoreV2DesignerUI.lFJ != null) {
                    emojiStoreV2DesignerUI.lFJ.setVisibility(i != 0 ? 0 : 8);
                }
                if (emojiStoreV2DesignerUI.lFK != null) {
                    emojiStoreV2DesignerUI.lFK.setText(R.l.eaF);
                }
                if (emojiStoreV2DesignerUI.lFL != null) {
                    View view = emojiStoreV2DesignerUI.lFL;
                    if (i != 0) {
                        i2 = 0;
                    }
                    view.setVisibility(i2);
                }
                if (emojiStoreV2DesignerUI.lFC != null) {
                    emojiStoreV2DesignerUI.lFC.setPadding(0, 0, 0, 0);
                }
            }
        });
        this.lFG.aD(list);
    }

    private void c(f fVar) {
        b(this.lAw, fVar);
        this.lAw = 0;
    }

    private void b(int i, f fVar) {
        Object obj = 1;
        switch (i) {
            case -1:
                this.lAL = fVar;
                break;
            case 0:
                this.lAL = fVar;
                break;
            case 1:
                this.lAL = fVar;
                break;
            case 2:
                if (this.lAL == null) {
                    this.lAL = new f();
                }
                this.lAL.oL(fVar.lxB);
                this.lAL.aA(fVar.lxC);
                break;
            default:
                obj = null;
                break;
        }
        if (this.lAL != null && r0 != null) {
            if (this.lAW != null) {
                this.lAW.b(this.lAL);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.lAw == 0 || this.lAx) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
            return;
        }
        al(this.lAz);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final boolean azk() {
        return true;
    }

    public final boolean azm() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.lAW != null) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.lAW.oG(i - this.Fv.getHeaderViewsCount());
            if (oG != null) {
                Intent intent = new Intent();
                intent.setClass(this, EmojiStoreDetailUI.class);
                so soVar = oG.luN;
                if (soVar == null) {
                    intent = null;
                } else {
                    intent.putExtra("extra_id", soVar.vIR);
                    intent.putExtra("extra_name", soVar.war);
                    intent.putExtra("extra_copyright", soVar.waB);
                    intent.putExtra("extra_coverurl", soVar.waz);
                    intent.putExtra("extra_description", soVar.was);
                    intent.putExtra("extra_price", soVar.wau);
                    intent.putExtra("extra_type", soVar.wav);
                    intent.putExtra("extra_flag", soVar.waw);
                    intent.putExtra("preceding_scence", 106);
                    intent.putExtra("download_entrance_scene", 6);
                    intent.putExtra("call_by", 1);
                    intent.putExtra("check_clickflag", false);
                    intent.putExtra("extra_status", oG.mStatus);
                    intent.putExtra("extra_progress", oG.sm);
                    intent.putExtra("searchID", this.lxP);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!bh.ov(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aAt();
        objArr[1] = TextUtils.isEmpty(aVar.aAv()) ? "" : aVar.aAv();
        objArr[2] = Integer.valueOf(aVar.aAu());
        com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
        aVar.aAu();
        this.lAM.a(aVar);
    }

    public final void I(String str, String str2, String str3) {
        J(str, str2, str3);
        aCu();
    }

    public final void aBw() {
    }

    protected final g J(String str, String str2, String str3) {
        this.lAP = new g(str, str2, str3);
        return this.lAP;
    }

    protected final void aCu() {
        ar.CG().a(this.lAP, 0);
    }

    final void bd(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    final void bc(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt(DownloadInfo.STATUS, i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.lAM.onActivityResult(i, i2, intent);
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (bh.ov(stringExtra) || this.lFN == null) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", ".." + stringExtra);
                String str = this.lxU;
                String str2 = this.lFN.nfe;
                int i3 = this.lFo;
                String str3 = this.lFq;
                String str4 = this.lxU;
                String str5 = this.lFN.waN;
                String stringBuffer = new StringBuffer(getResources().getString(R.l.dEy)).append(str).toString();
                e$a com_tencent_mm_pluginsdk_ui_applet_e_a = new e$a(this);
                com_tencent_mm_pluginsdk_ui_applet_e_a.bS(stringExtra).Sp(stringBuffer).BW(R.l.dGA);
                com_tencent_mm_pluginsdk_ui_applet_e_a.Sq(str5).caT();
                com_tencent_mm_pluginsdk_ui_applet_e_a.Ss(getString(R.l.dUb)).a(new 2(stringExtra, str4, str2, i3, str3, str, str5, this)).pyk.show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
