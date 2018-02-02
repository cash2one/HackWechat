package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, e {
    private View Lr;
    private boolean acS = false;
    private String gAb;
    private int irz;
    private MMPullDownView lFM;
    private i lFO;
    private int lFo = 0;
    private int lHA = -1;
    private String lHB;
    private LabelContainerView lHC;
    private TextView lHD;
    private MMTagPanel lHE;
    private HashMap<String, Integer> lHF = new HashMap();
    private ArrayList<String> lHG;
    private boolean lHH = false;
    private c lHI = new 6(this);
    private MMPullDownView.e lHJ = new 7(this);
    private MMPullDownView.c lHK = new MMPullDownView.c(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

        {
            this.lHL = r1;
        }

        public final boolean azm() {
            return false;
        }
    };
    private int lHj;
    private String lHk;
    private int lHl = -1;
    private String lHm;
    private String lHn;
    private String lHo;
    private String lHp;
    private String lHq;
    private int lHr = 0;
    private PreViewListGridView lHs;
    private d lHt;
    private View lHu;
    private TextView lHv;
    private View lHw;
    private boolean lHx = true;
    private abj lHy;
    private byte[] lHz;
    private ProgressDialog ltM;
    private long lxP;
    private String lyR;
    private String lyT;
    private af mHandler = new af(this) {
        final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

        {
            this.lHL = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (this.lHL.lHw != null) {
                        this.lHL.lHw.setVisibility(8);
                        return;
                    }
                    return;
                case 1002:
                    if (this.lHL.lHw != null) {
                        this.lHL.lHw.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    return;
                case 1004:
                    this.lHL.WT();
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        emojiStoreV2SingleProductUI.setMMTitle(R.l.eaG);
        emojiStoreV2SingleProductUI.showOptionMenu(1001, emojiStoreV2SingleProductUI.lHx);
        if (emojiStoreV2SingleProductUI.lHF == null || !emojiStoreV2SingleProductUI.lHF.containsKey(str)) {
            emojiStoreV2SingleProductUI.lHz = null;
            emojiStoreV2SingleProductUI.lHA = -1;
            emojiStoreV2SingleProductUI.lHB = emojiStoreV2SingleProductUI.getString(R.l.eaW);
            emojiStoreV2SingleProductUI.lHr = 1;
            emojiStoreV2SingleProductUI.lHj = 0;
            emojiStoreV2SingleProductUI.am(emojiStoreV2SingleProductUI.lHz);
            emojiStoreV2SingleProductUI.yH("");
        } else {
            emojiStoreV2SingleProductUI.lHA = -1;
            emojiStoreV2SingleProductUI.lHB = str;
            emojiStoreV2SingleProductUI.lHr = 4;
            emojiStoreV2SingleProductUI.lHj = ((Integer) emojiStoreV2SingleProductUI.lHF.get(emojiStoreV2SingleProductUI.lHB)).intValue();
            emojiStoreV2SingleProductUI.am(null);
            emojiStoreV2SingleProductUI.yH(str);
        }
        if (emojiStoreV2SingleProductUI.lHC != null) {
            emojiStoreV2SingleProductUI.lHC.setVisibility(8);
        }
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        g gVar = new g(emojiStoreV2SingleProductUI.mController.xIM, g.ztp, false);
        gVar.rKC = new 4(emojiStoreV2SingleProductUI);
        gVar.rKD = new 5(emojiStoreV2SingleProductUI);
        gVar.bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.lHl)});
    }

    protected final int getLayoutId() {
        return R.i.dgd;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.lFo = getIntent().getIntExtra(OpenSDKTool4Assistant.EXTRA_UIN, 0);
        this.gAb = getIntent().getStringExtra("Select_Conv_User");
        this.lxP = getIntent().getLongExtra("searchID", 0);
        this.lyT = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        String stringExtra = getIntent().getStringExtra("tag_id");
        if (!bh.ov(stringExtra)) {
            try {
                this.lHj = Integer.valueOf(stringExtra).intValue();
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", bh.i(e));
            }
        }
        this.lHk = getIntent().getStringExtra("tag_desc");
        this.lyR = getIntent().getStringExtra("keyword");
        this.lHl = getIntent().getIntExtra("set_id", 0);
        this.lHm = getIntent().getStringExtra("set_title");
        this.lHn = getIntent().getStringExtra("set_iconURL");
        this.lHo = getIntent().getStringExtra("set_desc");
        this.lHp = getIntent().getStringExtra("headurl");
        this.lHq = getIntent().getStringExtra("sns_object_data");
        this.lHr = getIntent().getIntExtra("pageType", 0);
        if (!bh.ov(this.lHq)) {
            this.lHl = EmojiLogic.yq(this.lHq);
            this.lHm = EmojiLogic.yr(this.lHq);
            this.lHn = EmojiLogic.yt(this.lHq);
            this.lHo = EmojiLogic.ys(this.lHq);
            this.lHp = EmojiLogic.yu(this.lHq);
            this.lHr = EmojiLogic.yv(this.lHq);
        }
        switch (this.lHr) {
            case 0:
                if (bh.ov(this.lyR)) {
                    if (bh.ov(this.lyT)) {
                        if (this.lFo == 0) {
                            if (this.lHj == 0) {
                                if (this.lHl <= 0) {
                                    this.lHr = 1;
                                    this.irz = 0;
                                    break;
                                }
                                this.lHr = 6;
                                this.irz = 4;
                                break;
                            }
                            this.irz = 3;
                            this.lHr = 4;
                            break;
                        }
                        this.lHr = 3;
                        this.irz = 1;
                        break;
                    }
                    this.lHr = 2;
                    this.irz = 1;
                    break;
                }
                this.lHr = 5;
                this.lHx = false;
                this.irz = 2;
                break;
            case 1:
                this.irz = 0;
                break;
            case 2:
                if (bh.ov(this.lyT)) {
                }
                break;
            case 3:
                if (this.lFo == 0) {
                }
                break;
            case 4:
                if (this.lHj == 0) {
                }
                break;
            case 5:
                if (bh.ov(this.lyR)) {
                }
                break;
            case 6:
                if (this.lHl == 0) {
                }
                break;
            default:
                this.lHH = true;
                break;
        }
        if (this.lHH) {
            Intent intent = new Intent();
            com.tencent.mm.plugin.emoji.model.i.aBA();
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
            intent.putExtra("showShare", false);
            d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            finish();
        }
        initView();
        if (this.lFo == 0 && this.lHr == 2) {
            abl XY = com.tencent.mm.plugin.emoji.model.i.aBE().lwR.XY(this.lyT);
            if (XY == null || XY.wkv == null || XY.wkv.wko == 0 || bh.ov(XY.wkv.nfp)) {
                z = true;
                if (z) {
                    WT();
                } else {
                    this.lFO = new i(this.lyT);
                    ar.CG().a(this.lFO, 0);
                    yG(getString(R.l.dHc));
                }
                ar.Hg();
                com.tencent.mm.z.c.CU().a(a.xnq, Boolean.valueOf(false));
                ar.CG().a(821, this);
                ar.CG().a(ai.CTRL_BYTE, this);
            }
            this.lFo = XY.wkv.wko;
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "uin:%s ", new Object[]{Integer.valueOf(this.lFo)});
        }
        z = false;
        if (z) {
            this.lFO = new i(this.lyT);
            ar.CG().a(this.lFO, 0);
            yG(getString(R.l.dHc));
        } else {
            WT();
        }
        ar.Hg();
        com.tencent.mm.z.c.CU().a(a.xnq, Boolean.valueOf(false));
        ar.CG().a(821, this);
        ar.CG().a(ai.CTRL_BYTE, this);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.sdk.b.a.xef.b(this.lHI);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.lHI);
    }

    protected void onDestroy() {
        ar.CG().b(ai.CTRL_BYTE, this);
        ar.CG().b(821, this);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 2002:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bh.ov(stringExtra)) {
                        x.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", ".." + stringExtra);
                        int i3 = this.lHl;
                        String str = this.lHm;
                        String str2 = this.lHo;
                        String str3 = this.lHn;
                        String str4 = this.lHp;
                        int i4 = this.lHr;
                        com.tencent.mm.plugin.emoji.model.i.aBA();
                        k.a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case 5001:
                if (i2 == -1) {
                    com.tencent.mm.ui.snackbar.a.h(this, this.mController.xIM.getString(R.l.eic));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void initView() {
        if (this.lHr != 6 || bh.ov(this.lHm)) {
            setMMTitle(R.l.eaG);
        } else {
            setMMTitle(this.lHm);
        }
        setBackBtn(new 9(this));
        this.lHt = new d(this.mController.xIM);
        this.lHt.lIu = new 10(this);
        this.lHs = (PreViewListGridView) findViewById(R.h.list);
        this.Lr = v.fv(this.mController.xIM).inflate(R.i.dfT, null);
        this.lHu = this.Lr.findViewById(R.h.cdE);
        this.lHv = (TextView) this.Lr.findViewById(R.h.cdX);
        this.lHs.addHeaderView(this.Lr);
        this.lHw = v.fv(this.mController.xIM).inflate(R.i.dfK, null);
        this.lHs.addFooterView(this.lHw);
        this.lHw.setVisibility(8);
        this.lHs.setAdapter(this.lHt);
        this.lHs.setOnScrollListener(this);
        this.lFM = (MMPullDownView) findViewById(R.h.ctp);
        this.lFM.mp(false);
        this.lFM.ycq = this.lHJ;
        this.lFM.ycB = this.lHK;
        this.lFM.mo(false);
        this.lFM.mn(false);
        this.lFM.ycL = true;
        this.lHC = (LabelContainerView) findViewById(R.h.cKM);
        this.lHD = (TextView) this.lHC.findViewById(16908310);
        this.lHD.setText(R.l.esD);
        this.lHE = (MMTagPanel) this.lHC.findViewById(R.h.bYk);
        this.lHE.nKq = R.g.bGC;
        this.lHE.nKr = R.e.bui;
        this.lHB = getString(R.l.eaW);
        this.lHC.yST = new 11(this);
        this.lHE.ydL = new 12(this);
        addIconOptionMenu(1001, R.g.byz, new 13(this));
        addIconOptionMenu(1002, R.k.dzQ, new 2(this));
        showOptionMenu(1001, false);
        showOptionMenu(1002, false);
    }

    public void onBackPressed() {
        if (this.lHC == null || this.lHC.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        this.lHC.setVisibility(8);
        showOptionMenu(1001, this.lHx);
        setMMTitle(R.l.eaG);
    }

    private void WT() {
        if (this.lHH) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            return;
        }
        this.lHz = null;
        switch (this.lHr) {
            case 1:
                this.lHy = com.tencent.mm.plugin.emoji.model.i.aBE().lwR.XZ("0");
                if (this.lHy == null || this.lHy.wkt == null || this.lHt == null) {
                    yG(getString(R.l.dHc));
                } else {
                    a(this.lHy);
                    this.lHt.aD(this.lHy.wkt);
                }
                this.lHx = true;
                com.tencent.mm.plugin.report.service.g.pQN.h(12875, new Object[]{Integer.valueOf(0), ""});
                break;
            case 2:
            case 3:
                showOptionMenu(1001, false);
                this.lHx = false;
                com.tencent.mm.plugin.report.service.g.pQN.h(12875, new Object[]{Integer.valueOf(1), this.lyT});
                break;
            case 4:
                showOptionMenu(1001, false);
                this.lHB = this.lHk;
                yH(this.lHB);
                this.lHx = false;
                com.tencent.mm.plugin.report.service.g.pQN.h(12875, new Object[]{Integer.valueOf(1), ""});
                break;
            case 5:
                this.lHB = "";
                yH(this.lyR);
                this.lHx = false;
                com.tencent.mm.plugin.report.service.g.pQN.h(12875, new Object[]{Integer.valueOf(2), ""});
                break;
            case 6:
                this.lHB = "";
                showOptionMenu(1001, false);
                showOptionMenu(1002, true);
                com.tencent.mm.plugin.report.service.g.pQN.h(12875, new Object[]{Integer.valueOf(3), ""});
                break;
        }
        am(this.lHz);
    }

    private void yG(String str) {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.dGO);
        this.ltM = h.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ EmojiStoreV2SingleProductUI lHL;

            {
                this.lHL = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.lHL.lFO != null) {
                    ar.CG().c(this.lHL.lFO);
                }
            }
        });
    }

    private void aCx() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }

    private void am(byte[] bArr) {
        this.lHz = null;
        switch (this.lHr) {
            case 1:
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.h(1, this.lFo, this.lHj, this.lyR, this.lHl, bArr), 0);
                return;
            case 2:
            case 3:
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.h(2, this.lFo, this.lHj, this.lyR, this.lHl, bArr), 0);
                return;
            case 4:
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.h(3, this.lFo, this.lHj, this.lyR, this.lHl, bArr), 0);
                return;
            case 5:
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.h(4, this.lFo, this.lHj, this.lyR, this.lHl, bArr), 0);
                return;
            case 6:
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.h(5, this.lFo, this.lHj, this.lyR, this.lHl, bArr), 0);
                return;
            default:
                return;
        }
    }

    private void a(abj com_tencent_mm_protocal_c_abj) {
        boolean z = false;
        if (com_tencent_mm_protocal_c_abj == null || com_tencent_mm_protocal_c_abj.wku == null || com_tencent_mm_protocal_c_abj.wku.size() <= 0) {
            showOptionMenu(1001, false);
            return;
        }
        if (this.lHx) {
            z = true;
        }
        showOptionMenu(1001, z);
        if (this.lHE != null) {
            if (this.lHG == null) {
                this.lHG = new ArrayList();
            } else {
                this.lHG.clear();
            }
            if (this.lHF == null) {
                this.lHF = new HashMap();
            }
            this.lHF.clear();
            this.lHG.add(getString(R.l.eaW));
            Iterator it = com_tencent_mm_protocal_c_abj.wku.iterator();
            while (it.hasNext()) {
                rx rxVar = (rx) it.next();
                if (!(rxVar == null || bh.ov(rxVar.vZT))) {
                    this.lHG.add(rxVar.vZT);
                    this.lHF.put(rxVar.vZT, Integer.valueOf(rxVar.vZS));
                }
            }
            Collection arrayList = new ArrayList();
            arrayList.add(this.lHB);
            this.lHE.a(arrayList, this.lHG);
        }
    }

    private void yH(String str) {
        if (this.lHu != null && this.lHv != null) {
            switch (this.lHr) {
                case 4:
                    if (!bh.ov(str)) {
                        this.lHv.setText(getString(R.l.eaX, new Object[]{str}));
                        this.lHv.setVisibility(0);
                        this.lHu.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!bh.ov(str)) {
                        this.lHv.setText(getString(R.l.eaT, new Object[]{str}));
                        this.lHv.setVisibility(0);
                        this.lHu.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (bh.ov(str)) {
                this.lHv.setText("");
                this.lHv.setVisibility(8);
                this.lHu.setVisibility(8);
            }
        }
    }

    private void eD(boolean z) {
        if (!this.acS) {
            am(this.lHz);
            this.acS = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
    }

    private void J(LinkedList<rw> linkedList) {
        if (this.lHt != null && linkedList != null) {
            if (this.lHA == -1) {
                this.lHt.aD(linkedList);
                return;
            }
            d dVar = this.lHt;
            if (dVar.ltR == null) {
                dVar.ltR = new ArrayList();
            }
            dVar.ltR.addAll(linkedList);
            dVar.notifyDataSetChanged();
        }
    }

    private void aDw() {
        Toast.makeText(this.mController.xIM, getString(R.l.ebx), 0).show();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        int type = kVar.getType();
        if (type == 821) {
            aCx();
            com.tencent.mm.plugin.emoji.f.h hVar = (com.tencent.mm.plugin.emoji.f.h) kVar;
            abj aBP = hVar.aBP();
            this.acS = false;
            if (this.lHw != null) {
                this.lHw.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i3 = hVar.hyU;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.lHz == null || this.lHz.length <= 0) && i3 != 3)) {
                a(aBP);
            }
            if (i == 0 || i == 4) {
                this.lHz = hVar.lyP;
                if (i2 == 0) {
                    J(aBP.wkt);
                    this.lHA = 0;
                    return;
                } else if (i2 == 2) {
                    J(aBP.wkt);
                    this.lHA = 2;
                    return;
                } else if (i2 == 3) {
                    this.lHA = -1;
                    J(aBP.wkt);
                    return;
                } else {
                    aDw();
                    return;
                }
            }
            aDw();
        } else if (type == ai.CTRL_BYTE) {
            aCx();
            if (i2 == 0 && i == 0) {
                abl aBQ = ((i) kVar).aBQ();
                if (aBQ != null && aBQ.wkv != null) {
                    this.lFo = aBQ.wkv.wko;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(1004);
                        return;
                    }
                    return;
                }
                return;
            }
            showOptionMenu(1001, false);
            h.b(this.mController.xIM, getString(R.l.dZO), null, true);
            x.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.lHA == 2 && !this.acS) {
            x.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            eD(true);
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (i != 0 && this.lHs != null) {
            this.lHs.aDA();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
