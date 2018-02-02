package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.a.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.e.1;
import com.tencent.mm.plugin.card.ui.e.5;
import com.tencent.mm.plugin.card.ui.j.2;
import com.tencent.mm.plugin.card.ui.j.3;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.protocal.c.kg;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardDetailUI extends CardDetailBaseUI implements e, a, d.a, j.a, av.a {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float gyA = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gyF = new 1(this);
    private float gyz = -85.0f;
    private String hcc = "";
    private c hpO;
    private r jmO = null;
    private Vibrator kEd;
    private int kFm = 3;
    private b kIK;
    private ArrayList<kj> kIQ;
    private String kIw = "";
    private String kJJ = "";
    private boolean kJZ = false;
    private int kNT = -1;
    private boolean kOg = false;
    private int kPZ = 0;
    private boolean kPc = false;
    private boolean kQA = false;
    private boolean kQB = false;
    private String kQC = "";
    private e.a kQD;
    private boolean kQE = false;
    private boolean kQF = true;
    private boolean kQG = false;
    private boolean kQH = false;
    private String kQI = "";
    private i kQJ = new i();
    private String kQa = "";
    private String kQb = "";
    private String kQc = "";
    e kQv;
    private String kQw = "";
    private String kQx = "";
    private String kQy = "";
    private boolean kQz = false;
    af mHandler = new af();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardDetailUI cardDetailUI, String str) {
        cardDetailUI.dY(true);
        ar.CG().a(new com.tencent.mm.plugin.card.model.af(cardDetailUI.kIK.atF(), str, 18), 0);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        int i;
        cardDetailUI.dY(true);
        bia com_tencent_mm_protocal_c_bia = new bia();
        if (cardDetailUI.kFm == 3) {
            com_tencent_mm_protocal_c_bia.fGU = cardDetailUI.kIw;
            i = 1;
        } else {
            com_tencent_mm_protocal_c_bia.kJN = cardDetailUI.kIw;
            i = 0;
        }
        com_tencent_mm_protocal_c_bia.fGV = cardDetailUI.kQy;
        com_tencent_mm_protocal_c_bia.vEH = cardDetailUI.kQa;
        com_tencent_mm_protocal_c_bia.vEG = cardDetailUI.kQb;
        com_tencent_mm_protocal_c_bia.vEI = cardDetailUI.kPZ;
        LinkedList linkedList = new LinkedList();
        linkedList.add(com_tencent_mm_protocal_c_bia);
        bii a = l.a(cardDetailUI.kQv.kOu, cardDetailUI.kQv.kOx, cardDetailUI.kQv.kOy);
        blp com_tencent_mm_protocal_c_blp = new blp();
        com_tencent_mm_protocal_c_blp.wPf = cardDetailUI.hcc;
        com_tencent_mm_protocal_c_blp.kLc = cardDetailUI.kQC;
        x.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", cardDetailUI.hcc);
        ar.CG().a(new g(i, linkedList, cardDetailUI.kIK.atB().vRF, cardDetailUI.kQc, a, cardDetailUI.kFm, com_tencent_mm_protocal_c_blp), 0);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.kIw);
        cardDetailUI.dY(true);
        ar.CG().a(new com.tencent.mm.plugin.card.model.r(linkedList), 0);
    }

    static /* synthetic */ void k(CardDetailUI cardDetailUI) {
        cardDetailUI.dY(true);
        String atG = (cardDetailUI.kFm == 6 || TextUtils.isEmpty(cardDetailUI.kIK.atG())) ? cardDetailUI.kIw : cardDetailUI.kIK.atG();
        int avS = cardDetailUI.kQv.avS();
        blp com_tencent_mm_protocal_c_blp = new blp();
        com_tencent_mm_protocal_c_blp.wPf = cardDetailUI.hcc;
        com_tencent_mm_protocal_c_blp.kLc = cardDetailUI.kQC;
        x.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", cardDetailUI.hcc);
        ar.CG().a(new o(atG, cardDetailUI.kFm, cardDetailUI.kQw, cardDetailUI.kQy, cardDetailUI.kQa, cardDetailUI.kQb, cardDetailUI.kPZ, avS, com_tencent_mm_protocal_c_blp), 0);
    }

    protected final int getLayoutId() {
        return R.i.dbW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        avv();
        e auL = am.auL();
        ActionBarActivity actionBarActivity = this.mController.xIM;
        ar.CG().a(910, auL);
        am.auH().a(auL);
        com.tencent.mm.plugin.card.a.b auz = am.auz();
        if (auz.kIv == null) {
            auz.kIv = new ArrayList();
        }
        if (auL != null) {
            auz.kIv.add(new WeakReference(auL));
        }
        auL.Zt = new WeakReference(actionBarActivity);
        am.auL().a((d.a) this);
        am.auM().a(this);
        auL = am.auN();
        ar.CG().a(577, auL);
        auL.kIx.clear();
        auL.kIy = 0;
        am.auN().a(this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        avv();
        if (this.hpO != null) {
            this.hpO.a(this.gyF, true);
        }
        this.kQv.fvI = false;
        av.a(this);
        am.auL().a(this, true);
        if ((this.kQz || this.kQA) && this.kIK.ath()) {
            if (this.kIK.atu()) {
                am.auM().aV(this.kIw, 2);
                Boolean bool = (Boolean) am.auL().kIJ.get(this.kIw);
                boolean z = bool != null && bool.booleanValue();
                if (!z || TextUtils.isEmpty(am.auL().kIM)) {
                    x.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                } else {
                    x.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
                    vX(am.auL().kIM);
                }
                this.kQv.kQT.d(com.tencent.mm.plugin.card.b.c.kXt);
            } else {
                am.auM().aV(this.kIw, 1);
                com.tencent.mm.plugin.card.ui.view.g gVar = this.kQv.kQT;
                if (gVar != null) {
                    gVar.d(com.tencent.mm.plugin.card.b.c.kXt);
                }
            }
        }
        if (this.kQJ.isInit) {
            this.kQJ.start();
        }
    }

    protected void onPause() {
        avw();
        super.onPause();
        this.kQv.fvI = true;
        am.auL().a(this, false);
        av.a(null);
        e eVar = this.kQJ;
        if (eVar.auf()) {
            x.i("MicroMsg.CardLbsOrBluetooth", "stop");
            if (eVar.kJd != null) {
                eVar.kJd.aui();
            }
            eVar.aud();
            ar.CG().b(2574, eVar);
        }
    }

    public final void alG() {
        com.tencent.mm.plugin.card.ui.view.g gVar = this.kQv.kQT;
        if (gVar != null) {
            gVar.axa();
        }
    }

    protected void onDestroy() {
        am.auL().c(this);
        avw();
        am.auL().b(this);
        am.auL().release();
        am.auM().b(this);
        am.auN().b(this);
        am.auN().release();
        e eVar = this.kQv;
        f fVar = eVar.kRh;
        fVar.kIK = null;
        fVar.kIO.clear();
        eVar.kRh = null;
        j jVar = eVar.kRf;
        l.u(jVar.kUY);
        for (int size = jVar.kVf.size() - 1; size >= 0; size--) {
            l.u((Bitmap) jVar.kVf.remove(size));
        }
        jVar.kVf.clear();
        if (jVar.inJ.isShowing()) {
            jVar.inJ.dismiss();
        }
        jVar.inJ = null;
        jVar.awh();
        jVar.iqt = null;
        jVar.kIK = null;
        eVar.kRf = null;
        if (eVar.kQS != null) {
            eVar.kQS.release();
        }
        eVar.kQM.jwN = null;
        com.tencent.mm.sdk.b.a.xef.c(eVar.kRq);
        eVar.kQO.destroy();
        eVar.kQR.destroy();
        eVar.kQQ.destroy();
        eVar.kRd.destroy();
        if (eVar.kRe != null) {
            eVar.kRe.destroy();
        }
        if (eVar.kQW != null) {
            eVar.kQW.destroy();
        }
        if (eVar.kQV != null) {
            eVar.kQV.destroy();
        }
        if (eVar.kQX != null) {
            eVar.kQX.destroy();
        }
        if (eVar.kQY != null) {
            eVar.kQY.destroy();
        }
        if (eVar.kQZ != null) {
            eVar.kQZ.destroy();
        }
        if (eVar.kRa != null) {
            eVar.kRa.destroy();
        }
        if (eVar.kRb != null) {
            eVar.kRb.destroy();
        }
        if (eVar.kRc != null) {
            eVar.kRc.destroy();
        }
        if (eVar.kQT != null) {
            eVar.kQT.destroy();
        }
        eVar.kQN = null;
        com.tencent.mm.plugin.card.a.g auQ = am.auQ();
        if (auQ.kIv != null && eVar != null) {
            for (int i = 0; i < auQ.kIv.size(); i++) {
                WeakReference weakReference = (WeakReference) auQ.kIv.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.a.g.a aVar = (com.tencent.mm.plugin.card.a.g.a) weakReference.get();
                    if (aVar != null && aVar.equals(eVar)) {
                        auQ.kIv.remove(weakReference);
                        break;
                    }
                }
            }
        }
        am.auQ().release();
        this.kEd.cancel();
        ata();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.kIK != null) {
            com.tencent.mm.plugin.report.service.g.pQN.h(13219, "CardDetailView", Integer.valueOf(this.kFm), this.kIK.atG(), this.kIK.atF(), Long.valueOf(currentTimeMillis));
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.h(13219, "CardDetailView", Integer.valueOf(this.kFm), this.kIw, this.kIw, Long.valueOf(currentTimeMillis));
        }
        if ((this.kQz || this.kQA) && this.kIK != null && this.kIK.ath()) {
            if (this.kIK.atu()) {
                am.auM().aV(this.kIw, 2);
            } else {
                am.auM().aV(this.kIw, 1);
            }
        }
        i iVar = this.kQJ;
        x.i("MicroMsg.CardLbsOrBluetooth", "uninit");
        if (iVar.kJd != null) {
            i.a aVar2 = iVar.kJd;
            if (aVar2.jjH == null) {
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothStateListener null, return");
            } else {
                ac.getContext().unregisterReceiver(aVar2.jjH);
                aVar2.jjH = null;
            }
            iVar.kJd = null;
        }
        iVar.aud();
        iVar.kJi = null;
        iVar.kIV = null;
        super.onDestroy();
    }

    private void avv() {
        ar.CG().a(645, (e) this);
        ar.CG().a(651, (e) this);
        ar.CG().a(563, (e) this);
        ar.CG().a(652, (e) this);
        ar.CG().a(560, (e) this);
        ar.CG().a(699, (e) this);
        ar.CG().a(902, (e) this);
        ar.CG().a(904, (e) this);
        ar.CG().a(1163, (e) this);
    }

    private void avw() {
        ar.CG().b(645, (e) this);
        ar.CG().b(651, (e) this);
        ar.CG().b(563, (e) this);
        ar.CG().b(652, (e) this);
        ar.CG().b(560, (e) this);
        ar.CG().b(699, (e) this);
        ar.CG().b(902, (e) this);
        ar.CG().b(904, (e) this);
        ar.CG().b(1163, (e) this);
    }

    protected final void initView() {
        boolean z;
        setBackBtn(new 2(this));
        this.kEd = (Vibrator) getSystemService("vibrator");
        if (this.kQv == null) {
            this.kQv = new e(this, this.mController.contentView);
            Object obj = this.kQv;
            obj.kRf = new j(obj.kQM);
            j jVar = obj.kRf;
            jVar.kNP = jVar.iqt.getWindow().getAttributes().screenBrightness;
            if (jVar.inJ == null) {
                View inflate = View.inflate(jVar.iqt, R.i.dcw, null);
                jVar.inL = inflate.findViewById(R.h.cDh);
                jVar.inK = (ImageView) inflate.findViewById(R.h.cDg);
                jVar.kUZ = (TextView) inflate.findViewById(R.h.cDj);
                jVar.kVa = (TextView) inflate.findViewById(R.h.cDi);
                jVar.kVb = inflate.findViewById(R.h.cDf);
                jVar.kVc = (ImageView) inflate.findViewById(R.h.cDe);
                jVar.kVd = (MMVerticalTextView) inflate.findViewById(R.h.cUB);
                jVar.kVe = (MMVerticalTextView) inflate.findViewById(R.h.cUC);
                inflate.setOnClickListener(new 2(jVar));
                jVar.inJ = new q(inflate, -1, -1, true);
                jVar.inJ.update();
                jVar.inJ.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.inJ.setOnDismissListener(new 3(jVar));
            }
            obj.kRh = new f(obj.kQM);
            obj.kQM.jwN = obj;
            com.tencent.mm.sdk.b.a.xef.b(obj.kRq);
            e eVar = this.kQv;
            if (eVar.kQO == null) {
                eVar.kQO = new com.tencent.mm.plugin.card.ui.view.x();
                eVar.kQO.a(eVar);
            }
            if (eVar.kQQ == null) {
                eVar.kQQ = new com.tencent.mm.plugin.card.ui.view.o();
                eVar.kQQ.a(eVar);
            }
            if (eVar.kQR == null) {
                eVar.kQR = new com.tencent.mm.plugin.card.ui.view.a();
                eVar.kQR.a(eVar);
            }
            eVar.Fv = (ListView) eVar.findViewById(R.h.bSy);
            eVar.kQU = new m(eVar.kQM.mController.xIM);
            eVar.kQU.kVM = eVar.inN;
            eVar.Fv.setAdapter(eVar.kQU);
            eVar.kQU.notifyDataSetChanged();
            eVar.Fv.setOnItemClickListener(new 1(eVar));
            x.i("MicroMsg.CardDetailUIContoller", "initMenu");
            eVar.kQM.kQp.setOnClickListener(new 5(eVar));
            eVar.ee = (LinearLayout) eVar.findViewById(R.h.coy);
            eVar.kRd = new com.tencent.mm.plugin.card.ui.view.d();
            eVar.kRd.a(eVar);
            eVar.kRf.kIK = eVar.kIK;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        x.i("MicroMsg.CardDetailUI", "scene:%d", Integer.valueOf(intExtra));
        String stringExtra;
        com.tencent.mm.plugin.card.model.d wJ;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.kFm = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            wJ = com.tencent.mm.plugin.card.b.g.wJ(stringExtra);
            if (wJ != null) {
                this.kIw = wJ.fGU;
                this.kQw = wJ.kKY;
                this.kQy = wJ.fGV;
                int i = wJ.kLb;
                x.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.kFm = 23;
                }
                this.kQC = wJ.kLc;
                x.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kQC);
            }
            this.kQx = com.tencent.mm.plugin.card.b.g.wK(stringExtra);
        } else if (l.nZ(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.kFm = intExtra;
            this.kIw = getIntent().getStringExtra("key_card_id");
            this.kQy = getIntent().getStringExtra("key_card_ext");
            this.kJZ = getIntent().getBooleanExtra("key_is_share_card", false);
            this.kPZ = getIntent().getIntExtra("key_stastic_scene", 0);
            this.kQc = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.kQa = getIntent().getStringExtra("src_username");
                this.kQb = getIntent().getStringExtra("js_url");
                this.hcc = getIntent().getStringExtra("key_template_id");
            } else if (this.kJZ && intExtra == 3) {
                this.kJJ = getIntent().getStringExtra("key_card_tp_id");
                this.kIw = com.tencent.mm.plugin.card.sharecard.a.b.bS(this.kIw, this.kJJ);
            } else if (intExtra == 8) {
                this.kQE = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else if (intExtra == 50 || intExtra == 27) {
            this.kFm = getIntent().getIntExtra("key_previous_scene", 50);
            if (!(this.kFm == 26 || this.kFm == 27)) {
                this.kFm = 3;
            }
            this.hcc = getIntent().getStringExtra("key_template_id");
            if (this.kFm == 27) {
                b bVar = (b) getIntent().getParcelableExtra("key_card_info");
                if (bVar != null) {
                    this.kIK = bVar;
                    this.kIw = this.kIK.atF();
                    avx();
                    avA();
                    if (this.kIK.atv()) {
                        am.auN().vV(this.kIK.atF());
                    }
                    ava();
                }
                avy();
                l.axe();
            } else {
                LinkedList aZ = k.aZ(getIntent().getStringExtra("card_list"), this.kFm);
                if (aZ == null || aZ.size() == 0) {
                    x.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    ec(true);
                } else {
                    dY(true);
                    this.kIw = ((kp) aZ.get(0)).kJN;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    blp com_tencent_mm_protocal_c_blp = new blp();
                    com_tencent_mm_protocal_c_blp.wPf = this.hcc;
                    x.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", this.hcc);
                    ar.CG().a(new t(aZ, com_tencent_mm_protocal_c_blp, intExtra), 0);
                }
                avx();
            }
            this.kQv.a(this.kIK, this.kQD, this.kIQ);
            this.kQv.kRn = new 3(this);
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.kPc = z;
            if (!this.kPc) {
                this.hpO = c.OP();
                asY();
            }
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.kFm = 26;
            } else {
                this.kFm = 3;
            }
            this.kIw = getIntent().getStringExtra("key_card_id");
            this.kIK = am.auF().kIm;
            if (this.kIK == null) {
                this.kIK = am.auA().wf(this.kIw);
            }
            avx();
            if (this.kIK == null) {
                x.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                ec(true);
            } else {
                avA();
                ava();
                avy();
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                }
            }
            this.kQv.a(this.kIK, this.kQD, this.kIQ);
            this.kQv.kRn = new 3(this);
            x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.kPc = z;
            if (!this.kPc) {
                this.hpO = c.OP();
                asY();
            }
        } else if (intExtra == 26) {
            this.kFm = intExtra;
            this.kIw = getIntent().getStringExtra("key_card_id");
            this.kQy = getIntent().getStringExtra("key_card_ext");
        } else {
            this.kFm = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            wJ = com.tencent.mm.plugin.card.b.g.wJ(stringExtra);
            if (wJ != null) {
                this.kIw = wJ.fGU;
                this.kQw = wJ.kKY;
                this.kQy = wJ.fGV;
            }
            this.kQx = com.tencent.mm.plugin.card.b.g.wK(stringExtra);
        }
        avx();
        if (TextUtils.isEmpty(this.kIw)) {
            x.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            ec(true);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.kJZ) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = am.auF().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.kIK = (CardInfo) value;
                    z = false;
                }
            } else if (this.kJZ) {
                this.kIK = am.auI().wv(this.kIw);
                z = false;
            } else {
                this.kIK = am.auA().wf(this.kIw);
                z = false;
            }
            if (z || this.kIK == null) {
                x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kIw + " isShareCard is " + this.kJZ);
                dY(true);
                if (this.kJZ) {
                    avB();
                } else {
                    avz();
                }
            } else {
                x.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kIw);
                kj atE = this.kIK.atE();
                if (atE != null) {
                    this.kIQ = new ArrayList();
                    this.kIQ.add(atE);
                }
                ava();
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                }
                if (this.kJZ) {
                    this.kQF = true;
                    z = true;
                } else {
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.kIK.atI() >= 86400) {
                        this.kQF = true;
                        z = true;
                    } else if (this.kIK.ats()) {
                        this.kQF = true;
                        z = true;
                    }
                }
                if (z) {
                    x.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kIw + " isShareCard is " + this.kJZ);
                    if (this.kJZ) {
                        avB();
                    } else {
                        avz();
                    }
                } else {
                    avA();
                }
                avy();
            }
        }
        this.kQv.a(this.kIK, this.kQD, this.kIQ);
        this.kQv.kRn = new 3(this);
        x.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.kPc = z;
        if (!this.kPc) {
            this.hpO = c.OP();
            asY();
        }
    }

    private void avx() {
        this.kNT = this.kFm;
        this.kQD = new e.a();
        this.kQD.kFm = this.kFm;
        this.kQD.kNT = this.kNT;
        this.kQD.kIw = this.kIw;
        this.kQD.kQw = this.kQw;
        this.kQD.kQy = this.kQy;
        this.kQD.kQx = this.kQx;
        this.kQD.kQa = this.kQa;
        this.kQD.kQb = this.kQb;
        this.kQD.kJZ = this.kJZ;
        this.kQD.kRu = getIntent().getIntExtra("key_from_appbrand_type", 0);
    }

    private void avy() {
        int i = 1;
        if (!this.kQG && this.kIK != null) {
            this.kQG = true;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (this.kJZ) {
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[9];
                objArr[0] = "ShareCardDetailUI";
                objArr[1] = Integer.valueOf(this.kIK.atB().kJO);
                objArr[2] = this.kIK.atG();
                objArr[3] = this.kIK.atF();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kNT);
                objArr[6] = this.kQw;
                if (!this.kIK.atz()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.h(11324, objArr);
                return;
            }
            gVar = com.tencent.mm.plugin.report.service.g.pQN;
            objArr = new Object[9];
            objArr[0] = "CardDetailView";
            objArr[1] = Integer.valueOf(this.kIK.atB().kJO);
            objArr[2] = this.kIK.atG();
            objArr[3] = this.kIK.atF();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.kNT);
            objArr[6] = this.kQw;
            if (!this.kIK.atz()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.h(11324, objArr);
        }
    }

    private void ava() {
        this.kQD.kFm = this.kFm;
        this.kQD.kNT = this.kNT;
        this.kQD.kIw = this.kIw;
        this.kQv.a(this.kIK, this.kQD, this.kIQ);
        this.kQv.ava();
        am.auL().kIK = this.kIK;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            dY(false);
            b bVar;
            b cardInfo;
            if (kVar instanceof aa) {
                Object obj = ((aa) kVar).kLN;
                if (TextUtils.isEmpty(obj)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    return;
                }
                bVar = this.kIK;
                cardInfo = new CardInfo();
                com.tencent.mm.plugin.card.b.f.a((CardInfo) cardInfo, obj);
                if (!TextUtils.isEmpty(cardInfo.atF())) {
                    this.kIw = cardInfo.atF();
                } else if (TextUtils.isEmpty(cardInfo.atF()) && !this.kIw.equals(cardInfo.atG())) {
                    x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kIw, cardInfo.atG());
                    return;
                }
                this.kIK = cardInfo;
                avA();
                if (this.kFm == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.kIK).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.kIK).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.kIK).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        ((CardInfo) this.kIK).field_label_wording = ((CardInfo) bVar).field_label_wording;
                        this.kIK.a(bVar.atE());
                    }
                    if (this.kQF) {
                        l.j(this.kIK);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                ava();
                avy();
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                }
                this.kQJ.a(this, this.kIw, this.kIK, this.gyz, this.gyA);
                return;
            } else if (kVar instanceof o) {
                if (this.kNT == 26) {
                    dY(false);
                }
                r1 = ((o) kVar).kLN;
                r2 = ((o) kVar).kLO;
                r0 = ((o) kVar).kLP;
                if (r2 != 0) {
                    b(i2, str, r2, r0);
                } else {
                    h.bu(this, getResources().getString(R.l.dNH));
                }
                if (TextUtils.isEmpty(r1)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    return;
                }
                this.kFm = 3;
                if (this.kIK == null) {
                    this.kIK = new CardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((CardInfo) this.kIK, r1);
                if (!TextUtils.isEmpty(this.kIK.atF())) {
                    this.kIw = this.kIK.atF();
                }
                if (this.kQv.avS() == 1) {
                    e eVar = this.kQv;
                    if (eVar.kRh != null) {
                        f fVar = eVar.kRh;
                        if (fVar.kIP != null) {
                            fVar.kIP.kKc = false;
                        }
                    }
                }
                if (this.kNT != 26) {
                    avA();
                    ava();
                }
                l.axe();
                cardInfo = this.kIK;
                if (cardInfo.ati()) {
                    ar.Hg();
                    r0 = (Integer) com.tencent.mm.z.c.CU().get(w.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(0));
                    if (r0 == null || r0.intValue() != 1) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().a(w.a.USERINFO_CARD_IS_SHOW_MEMBERSHIP_TIP_INT_SYNC, Integer.valueOf(1));
                    }
                    this.kQI = this.kIK.atL();
                    if (this.kNT != 7 || this.kNT == 16) {
                        r0 = new Intent();
                        r0.putExtra("key_code", this.kQI);
                        setResult(-1, r0);
                        nS(-1);
                    } else if (!this.kQE && this.kNT == 8) {
                        ec(true);
                    } else if (this.kNT == 26 && r2 == 0) {
                        ec(true);
                    }
                    if (this.kIK.atv()) {
                        am.auN().vV(this.kIK.atF());
                    }
                    this.kQJ.a(this, this.kIw, this.kIK, this.gyz, this.gyA);
                    return;
                }
                ar.Hg();
                r0 = (Integer) com.tencent.mm.z.c.CU().get(282884, null);
                if (r0 == null || r0.intValue() != 1) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().set(282884, Integer.valueOf(1));
                }
                this.kQI = this.kIK.atL();
                if (this.kNT != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.kQI);
                setResult(-1, r0);
                nS(-1);
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                }
                this.kQJ.a(this, this.kIw, this.kIK, this.gyz, this.gyA);
                return;
                if (l.axh()) {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcF, R.l.dNE, cardInfo.atB().kKZ);
                } else {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcE, R.l.dND, cardInfo.atB().kKZ);
                }
                this.kQI = this.kIK.atL();
                if (this.kNT != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.kQI);
                setResult(-1, r0);
                nS(-1);
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                }
                this.kQJ.a(this, this.kIw, this.kIK, this.gyz, this.gyA);
                return;
            } else if (kVar instanceof v) {
                this.kIQ = ((v) kVar).kLW;
                if (this.kIK != null && this.kIQ != null && this.kIQ.size() > 0) {
                    this.kIK.a((kj) this.kIQ.get(0));
                    ava();
                    com.tencent.mm.sdk.e.c wv;
                    if (this.kIK.ath()) {
                        wv = am.auI().wv(this.kIw);
                        if (wv != null) {
                            wv.a((kj) this.kIQ.get(0));
                            am.auI().c(wv, new String[]{this.kIw});
                            return;
                        }
                        return;
                    }
                    wv = am.auA().wf(this.kIw);
                    if (wv != null) {
                        wv.a((kj) this.kIQ.get(0));
                        am.auA().c(wv, new String[]{this.kIw});
                        return;
                    }
                    return;
                } else if (this.kIK != null && this.kIQ == null) {
                    this.kIK.a(null);
                    ava();
                    com.tencent.mm.sdk.e.c wv2;
                    if (this.kIK.ath()) {
                        wv2 = am.auI().wv(this.kIw);
                        if (wv2 != null) {
                            wv2.a(null);
                            am.auI().c(wv2, new String[]{this.kIw});
                            return;
                        }
                        return;
                    }
                    wv2 = am.auA().wf(this.kIw);
                    if (wv2 != null) {
                        wv2.a(null);
                        am.auA().c(wv2, new String[]{this.kIw});
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof com.tencent.mm.plugin.card.model.af) {
                i3 = ((com.tencent.mm.plugin.card.model.af) kVar).kLO;
                r0 = ((com.tencent.mm.plugin.card.model.af) kVar).kLP;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(r0)) {
                        r0 = getString(R.l.dOj);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, r0);
                    return;
                }
                this.kQy = ((com.tencent.mm.plugin.card.model.af) kVar).fGV;
                eb(true);
                kg atC = this.kIK.atC();
                atC.status = 3;
                this.kIK.a(atC);
                l.j(this.kIK);
                ava();
                if (this.kNT == 3) {
                    ec(true);
                    return;
                } else if (this.kNT == 15) {
                    com.tencent.mm.sdk.b.a.xef.m(new pa());
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof com.tencent.mm.plugin.card.model.r) {
                h.bu(this, getResources().getString(R.l.dNY));
                am.auz();
                com.tencent.mm.plugin.card.a.b.nF(4);
                ec(true);
                return;
            } else if (kVar instanceof t) {
                LinkedList linkedList = ((t) kVar).kLU;
                if (linkedList != null && linkedList.size() > 0) {
                    b bVar2 = (b) linkedList.get(0);
                    if (bVar2 == null || this.kIw.equals(bVar2.atG())) {
                        this.kIK = bVar2;
                        if (this.kIK != null) {
                            this.kIw = this.kIK.atF();
                            avA();
                            if (this.kIK.atv()) {
                                am.auN().vV(this.kIK.atF());
                            }
                        }
                        if (this.kFm == 26) {
                            this.kFm = 3;
                        }
                        ava();
                    } else {
                        x.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", this.kIw, bVar2.atG());
                        return;
                    }
                }
                avy();
                l.axe();
                return;
            } else if (kVar instanceof g) {
                r1 = ((g) kVar).kLN;
                r2 = ((g) kVar).kLO;
                r0 = ((g) kVar).kLP;
                if (r2 != 0) {
                    if (TextUtils.isEmpty(r0)) {
                        r0 = getString(R.l.dNw);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, r0);
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", r0);
                    return;
                }
                h.bu(this, getResources().getString(R.l.dNz));
                if (TextUtils.isEmpty(r1)) {
                    x.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    return;
                }
                this.kFm = 3;
                if (this.kIK == null) {
                    this.kIK = new ShareCardInfo();
                } else if (this.kIK instanceof CardInfo) {
                    this.kIK = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((ShareCardInfo) this.kIK, r1);
                r0 = (ShareCardInfo) this.kIK;
                if (TextUtils.isEmpty(r1)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(r1).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            r0.kJS = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            x.i("MicroMsg.CardInfoParser", "encrypt_code:" + r0.kJS);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        x.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.kIK.atF())) {
                    this.kIw = this.kIK.atF();
                }
                if (TextUtils.isEmpty(this.kIK.atH())) {
                    ((ShareCardInfo) this.kIK).field_from_username = com.tencent.mm.z.q.FS();
                }
                l.a((ShareCardInfo) this.kIK);
                avA();
                ava();
                l.axg();
                am.auH().asi();
                this.kQI = this.kIK.atL();
                if (this.kNT == 7 || this.kNT == 16) {
                    r0 = new Intent();
                    r0.putExtra("key_code", this.kQI);
                    setResult(-1, r0);
                    nS(-1);
                } else if (!this.kQE && this.kNT == 8) {
                    ec(true);
                }
                ar.Hg();
                r0 = (Integer) com.tencent.mm.z.c.CU().get(w.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(0));
                if (r0 == null || r0.intValue() != 1) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(w.a.USERINFO_CARD_IS_SHOW_SHARE_CARD_TIP_INT_SYNC, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.dcH, R.l.dPn, "");
                }
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                    return;
                }
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                r1 = ((com.tencent.mm.plugin.card.sharecard.model.c) kVar).kLN;
                if (TextUtils.isEmpty(r1)) {
                    x.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    return;
                }
                bVar = this.kIK;
                this.kIK = new ShareCardInfo();
                r0 = (ShareCardInfo) this.kIK;
                if (TextUtils.isEmpty(r1)) {
                    x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.b.f.a(r0, new JSONObject(r1));
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.atH())) {
                        ((ShareCardInfo) this.kIK).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.kIK).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.kIK).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.kIK).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.kIK).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.kIK).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.kIK).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.kIK).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.kIK.a(bVar.atE());
                    ((ShareCardInfo) this.kIK).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.kIK).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.kIK).field_status) {
                        x.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.kIK).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.kIK);
                    }
                }
                if (!TextUtils.isEmpty(this.kIK.atF())) {
                    this.kIw = this.kIK.atF();
                }
                ava();
                avA();
                avy();
                if (this.kFm == 3) {
                    if (this.kQF) {
                        l.j(this.kIK);
                    } else {
                        x.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.kIK.atv()) {
                    am.auN().vV(this.kIK.atF());
                    return;
                }
                return;
            } else if (!(kVar instanceof com.tencent.mm.plugin.card.sharecard.model.a)) {
                return;
            } else {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) kVar).kLO != 0) {
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dNW));
                    return;
                }
                x.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.kIK.atF());
                com.tencent.mm.plugin.card.sharecard.a.b.a(this, this.kIK);
                h.bu(this, getResources().getString(R.l.dNY));
                am.auH().auR();
                ec(true);
                return;
            }
        }
        CharSequence charSequence;
        x.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + kVar.getType());
        dY(false);
        Object obj2;
        if (kVar instanceof com.tencent.mm.plugin.card.model.af) {
            eb(false);
            i3 = ((com.tencent.mm.plugin.card.model.af) kVar).kLO;
            charSequence = ((com.tencent.mm.plugin.card.model.af) kVar).kLP;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = getString(R.l.dOj);
                }
            }
            obj2 = str;
        } else if (kVar instanceof o) {
            nS(0);
            b(i2, str, ((o) kVar).kLO, ((o) kVar).kLP);
            return;
        } else {
            if (kVar instanceof v) {
                return;
            }
            obj2 = str;
        }
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = getString(R.l.dPR);
        }
        Toast.makeText(this.mController.xIM, charSequence, 0).show();
    }

    private void b(int i, String str, int i2, String str2) {
        x.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dNx);
            }
            this.kIK.atC().status = 4;
            ava();
        } else if (i2 == 10001) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dNA);
            }
            this.kIK.atC().status = 5;
            ava();
        } else if (i2 == 10002) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dOQ);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.l.dNv);
        }
        com.tencent.mm.plugin.card.b.d.b(this, str2);
    }

    private void dY(boolean z) {
        if (z) {
            this.jmO = r.b(this, getString(R.l.ctB), true, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    private void eb(boolean z) {
        if (z) {
            l.bZ(this.kQv.kRj, this.kQv.kRi);
        }
    }

    private void avz() {
        blp com_tencent_mm_protocal_c_blp = new blp();
        com_tencent_mm_protocal_c_blp.wPf = this.hcc;
        com_tencent_mm_protocal_c_blp.kLc = this.kQC;
        x.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", this.hcc);
        ar.CG().a(new aa(this.kIw, this.kFm, this.kQw, this.kQy, this.kQa, this.kQb, this.kPZ, this.kQc, com_tencent_mm_protocal_c_blp), 0);
    }

    private void avA() {
        String atG;
        if (!TextUtils.isEmpty(this.kIK.atG())) {
            atG = this.kIK.atG();
        } else if (TextUtils.isEmpty(this.kIw)) {
            x.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            return;
        } else {
            atG = this.kIw;
        }
        if (this.kIK != null && this.kIK.atB().vRM == 1) {
            float f = this.gyz;
            float f2 = this.gyA;
            if (f == -85.0f || f2 == -1000.0f) {
                f = am.auG().gyz;
                f2 = am.auG().gyA;
            }
            ar.CG().a(new v(atG, f2, f, this.kIK.atF()), 0);
        } else if (this.kIK == null || this.kIK.atB().vRM <= 1) {
            if (this.kIK != null) {
                this.kIK.a(null);
                ava();
                com.tencent.mm.sdk.e.c wv;
                if (this.kIK.ath()) {
                    wv = am.auI().wv(this.kIw);
                    if (wv != null) {
                        wv.a(null);
                        am.auI().c(wv, new String[]{this.kIw});
                        return;
                    }
                    return;
                }
                wv = am.auA().wf(this.kIw);
                if (wv != null) {
                    wv.a(null);
                    am.auA().c(wv, new String[]{this.kIw});
                }
            }
        } else if (this.gyz != -85.0f && this.gyA != -1000.0f) {
            this.kQH = false;
            ar.CG().a(new v(atG, this.gyA, this.gyz, this.kIK.atF()), 0);
        } else if (!this.kQH) {
            this.kQH = true;
            if (this.kPc) {
                asY();
            }
        }
    }

    private void avB() {
        ar.CG().a(new com.tencent.mm.plugin.card.sharecard.model.c(this.kIw), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            ec(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ec(boolean z) {
        if ((this.kNT == 7 || this.kNT == 8 || this.kNT == 16 || this.kNT == 26) && this.kFm == 3) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.kQI);
            setResult(-1, intent);
            if (z) {
                finish();
            }
        } else if ((this.kNT == 7 && this.kFm == 7) || ((this.kNT == 16 && this.kFm == 16) || ((this.kNT == 8 && this.kFm == 8) || (this.kNT == 26 && this.kFm == 26)))) {
            setResult(0);
            if (z) {
                finish();
            }
        } else if (z) {
            finish();
        }
    }

    private void nS(int i) {
        if (this.kNT == 7 || this.kNT == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.kJN = this.kIK.atG();
            eVar.fGV = this.kQy;
            eVar.code = this.kQI;
            linkedList.add(eVar);
            com.tencent.mm.sdk.b.b bVar = new com.tencent.mm.g.a.b();
            bVar.fmJ.bjW = i;
            if (i == -1) {
                bVar.fmJ.fmK = com.tencent.mm.plugin.card.b.h.a(linkedList, true, this.kNT);
            } else {
                bVar.fmJ.fmK = com.tencent.mm.plugin.card.b.h.a(linkedList, false, this.kNT);
            }
            com.tencent.mm.sdk.b.a.xef.m(bVar);
            return;
        }
        x.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
    }

    private void asY() {
        if (this.hpO == null) {
            this.hpO = c.OP();
        }
        this.hpO.a(this.gyF, true);
    }

    private void ata() {
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
    }

    private void avj() {
        this.hpO = c.OP();
        asY();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.kPc);
                    if (!this.kPc) {
                        this.kPc = true;
                        avj();
                        return;
                    }
                    return;
                }
                h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ CardDetailUI kQK;

                    {
                        this.kQK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kQK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    private synchronized void vW(String str) {
        if (this.kOg) {
            x.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
        } else {
            x.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.kOg = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.kIK.atF());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.kIK.atB().hbM);
            intent.putExtra("key_stastic_scene", this.kFm);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
        }
    }

    public final void f(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
        } else if (this.kIK == null || !this.kIK.atF().equals(bVar.atF())) {
            x.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
        } else if (this.kQv.avT()) {
            x.i("MicroMsg.CardDetailUI", "onDataChange");
            this.kIK = bVar;
            this.kIw = this.kIK.atF();
            if (this.kIK.atv() && am.auN().isEmpty()) {
                am.auN().vV(this.kIK.atF());
            }
            ava();
        } else {
            x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
        }
    }

    public final void atY() {
        x.i("MicroMsg.CardDetailUI", "onVibrate");
        this.kEd.vibrate(300);
    }

    public final void atZ() {
        x.i("MicroMsg.CardDetailUI", "onFinishUI");
    }

    public final void vX(final String str) {
        if (this.kQv.avT()) {
            x.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ CardDetailUI kQK;

                public final void run() {
                    this.kQK.vW(str);
                }
            });
            return;
        }
        x.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
    }

    public final void b(String str, j.b bVar) {
        if (TextUtils.isEmpty(str) || str.equals(this.kIw)) {
            dY(false);
            x.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            x.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.kJB + " markCardId: " + bVar.kJC);
            this.kQA = false;
            if (bVar.kJB != 1) {
                this.kQz = false;
                com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dOD));
                return;
            } else if (TextUtils.isEmpty(bVar.kJC) || this.kIK.atF().equals(bVar.kJC)) {
                x.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.kQz = true;
                a(bVar);
                return;
            } else {
                x.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.kIK.ath()) {
                    b wv = am.auI().wv(bVar.kJC);
                    if (wv != null) {
                        this.kIK = wv;
                        this.kIw = bVar.kJC;
                        ava();
                        am.auL().d(this.kIK);
                        x.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.kQz = true;
                        a(bVar);
                        return;
                    }
                    x.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dOC));
                    this.kQz = false;
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bO(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.kIw)) {
            x.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.kQz = false;
            this.kQA = false;
            dY(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dOC);
            }
            com.tencent.mm.plugin.card.b.d.b(this, str2);
            return;
        }
        x.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void wa(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.kIw)) {
            this.kQz = false;
        } else {
            x.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        }
    }

    private void a(j.b bVar) {
        if (this.kQv.fvI) {
            x.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            return;
        }
        x.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.kQv.a(this.kQB, bVar, true);
    }

    public final void atT() {
        x.i("MicroMsg.CardDetailUI", "code change");
        if (this.kQv.kQT instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.kQv.kQT).kVg = am.auN().getCode();
            this.kQv.ava();
        }
    }

    public final void vU(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.b.d.a(this, str, true);
        }
    }

    public final void onSuccess() {
        if (this.kQv.kQT instanceof com.tencent.mm.plugin.card.ui.view.q) {
            ((com.tencent.mm.plugin.card.ui.view.q) this.kQv.kQT).kVg = am.auN().getCode();
            this.kQv.ava();
        }
        x.i("MicroMsg.CardDetailUI", "code get success");
    }
}
