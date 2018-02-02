package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.aq.a.c.j;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k.1;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, e, a {
    private View kgl;
    private int lAK;
    private c lAO = new 1(this);
    private sk lBc = new sk();
    private String lBd = "";
    private int lCE;
    private String lCF;
    private boolean lCG;
    private boolean lCH = false;
    private int lCI = -1;
    private l lCJ;
    private g lCK;
    private o lCL;
    private a lCM;
    private acb lCN = null;
    private boolean lCO;
    private TextView lCP;
    private View lCQ;
    private EmojiDetailScrollView lCR;
    private BannerEmojiView lCS;
    private TextView lCT;
    private MMAutoSizeTextView lCU;
    private TextView lCV;
    private TextView lCW;
    private TextView lCX;
    private EmojiDetailGridView lCY;
    private ImageView lCZ;
    private boolean lDA = true;
    private abt lDB;
    private boolean lDC = false;
    private boolean lDD = true;
    private OnClickListener lDE = new 12(this);
    private OnClickListener lDF = new 16(this);
    private OnClickListener lDG = new 17(this);
    private OnClickListener lDH = new 18(this);
    private i lDI = new 20(this);
    private i lDJ = new 21(this);
    private j lDK = new 22(this);
    private com.tencent.mm.pluginsdk.model.i.a lDL = new 15(this);
    private View lDa;
    private TextView lDb;
    private TextView lDc;
    private int lDd;
    private View lDe;
    private ProgressBar lDf;
    private View lDg;
    private ImageView lDh;
    private TextView lDi;
    private View lDj;
    private View lDk;
    private MMCopiableTextView lDl;
    private Button lDm;
    private DonorsAvatarView lDn;
    private TextView lDo;
    private int lDp;
    private int lDq;
    private int lDr;
    private String lDs;
    private boolean lDt;
    private int lDu;
    private int lDv = -1;
    private String lDw;
    private String[] lDx = new String[1];
    private boolean lDy = false;
    private View lDz;
    private int lee;
    private ProgressDialog ltM;
    private ProgressBar ltx;
    private long lxP = 0;
    private String lxQ = "";
    private b lxT;
    private String lyH;
    private String lyI;
    private String lyJ;
    private Context mContext;
    private af mHandler = new af(this) {
        final /* synthetic */ EmojiStoreDetailUI lDM;

        {
            this.lDM = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(this.lDM);
                    return;
                case 1002:
                    this.lDM.aCZ();
                    return;
                case 1003:
                    this.lDM.aDc();
                    return;
                case 1004:
                    if (this.lDM.lCW.getVisibility() == 0) {
                        this.lDM.lCW.setVisibility(8);
                        this.lDM.lDa.setVisibility(0);
                        this.lDM.lCZ.setVisibility(0);
                    }
                    this.lDM.ltx.setProgress(this.lDM.sm);
                    return;
                case 1005:
                    this.lDM.lCR.scrollTo(0, 0);
                    return;
                case 1006:
                    this.lDM.ex(false);
                    return;
                case 1007:
                    this.lDM.aDa();
                    return;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    private int mNumColumns;
    private int sm;

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        if (!com.tencent.mm.plugin.emoji.h.a.yO(emojiStoreDetailUI.lyH)) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.i.aBE().lwM.XP(emojiStoreDetailUI.lyH)) {
                if (com.tencent.mm.plugin.emoji.model.i.aBE().lwL.ym(emojiStoreDetailUI.lyH) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    File file = new File(stringBuilder.append(com.tencent.mm.z.c.Fp()).append(emojiStoreDetailUI.lyH).toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            com.tencent.mm.plugin.emoji.model.i.aBE().lwM.XQ(emojiStoreDetailUI.lyH);
                            com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XX(emojiStoreDetailUI.lyH);
                        } else {
                            emojiStoreDetailUI.lCO = true;
                            emojiStoreDetailUI.lCI = 7;
                            emojiStoreDetailUI.aDc();
                            return;
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XX(emojiStoreDetailUI.lyH);
            }
            emojiStoreDetailUI.lCO = false;
        }
    }

    static /* synthetic */ void u(EmojiStoreDetailUI emojiStoreDetailUI) {
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(emojiStoreDetailUI.mContext, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new 13(emojiStoreDetailUI);
        gVar.rKD = new 14(emojiStoreDetailUI);
        gVar.bUk();
        com.tencent.mm.plugin.report.service.g.pQN.h(13224, Integer.valueOf(0), Integer.valueOf(0), "", "");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lDt = q.Ge();
        this.lxT = new b(2003);
        Intent intent = getIntent();
        this.lyH = getIntent().getStringExtra("extra_id");
        this.lAK = getIntent().getIntExtra("preceding_scence", -1);
        this.lyI = getIntent().getStringExtra("extra_name");
        this.lCE = getIntent().getIntExtra("call_by", -1);
        Object stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lyH = EmojiLogic.yi(stringExtra);
            this.lAK = 0;
            this.lAK = 10;
            com.tencent.mm.plugin.report.service.g.pQN.h(10993, Integer.valueOf(3), this.lyH);
        }
        if (TextUtils.isEmpty(this.lyH)) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.lAK == -1) {
            x.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.lDA = intent.getBooleanExtra("check_clickflag", true);
        this.lDs = intent.getStringExtra("cdn_client_id");
        this.lDr = intent.getIntExtra("download_entrance_scene", 0);
        this.lxP = intent.getLongExtra("searchID", 0);
        this.lxQ = bh.az(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.waB = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.waz = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.was = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.wau = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.lBc.wav = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.lBc.waw = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.waD = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.lBc.waC = stringExtra;
        }
        if (this.lDt) {
            this.lDw = intent.getStringExtra("google_price");
            if (TextUtils.isEmpty(this.lDw)) {
                this.lDu = 11;
                com.tencent.mm.pluginsdk.model.i.a(this, this.lDx, this.lDL);
            }
        }
        this.lCG = intent.getBooleanExtra("reward_tip", false);
        this.lDx[0] = this.lyH;
        this.lBc.vIR = this.lyH;
        this.lBc.war = this.lyI;
        this.lBc.waJ = this.lCF;
        this.lBc.ktM = -1;
        this.mContext = this;
        initView();
        if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH)) {
            Context context = this.mController.xIM;
            sk skVar = new sk();
            skVar.vIR = EmojiGroupInfo.xAb;
            skVar.war = context.getString(R.l.ebe);
            skVar.was = context.getString(R.l.ebc);
            skVar.wat = context.getString(R.l.eba);
            skVar.wau = "";
            skVar.wav = 0;
            skVar.waw = 1;
            skVar.waz = "";
            skVar.waA = 0;
            skVar.waB = context.getString(R.l.ebb);
            skVar.waE = "";
            skVar.waC = "";
            skVar.waD = "";
            skVar.waI = context.getString(R.l.ebd);
            this.lBc = skVar;
            this.lDC = true;
            this.lDB = EmojiLogic.aBu();
            aCY();
        } else {
            com.tencent.mm.storage.emotion.i Ya = com.tencent.mm.plugin.emoji.model.i.aBE().lwP.Ya(this.lyH);
            if (!(Ya == null || Ya.field_content == null)) {
                abv com_tencent_mm_protocal_c_abv = new abv();
                try {
                    com_tencent_mm_protocal_c_abv.aF(Ya.field_content);
                    this.lBc = com_tencent_mm_protocal_c_abv.wkD;
                    this.lBd = Ya.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "exception:%s", bh.i(e));
                }
            }
            if (this.lBc == null) {
                this.lCJ = new l(this.lyH, this.lAK);
            } else if (bh.ov(this.lBd) || !this.lBd.equalsIgnoreCase(w.eL(this.mContext))) {
                this.lCJ = new l(this.lyH, this.lAK);
            } else {
                this.lCJ = new l(this.lyH, this.lAK, this.lBc.ktM);
            }
            ar.CG().a(this.lCJ, 0);
            if (this.lCE == -1 || this.lCE == 3) {
                this.lCQ.setVisibility(8);
                this.kgl.setVisibility(8);
                getString(R.l.dGO);
                this.ltM = h.a(this, getString(R.l.dHc), true, new 5(this));
            }
            aCW();
            if (this.lDA) {
                ar.CG().a(new k(this.lyH), 0);
            } else {
                this.lDC = true;
                this.lDB = EmojiLogic.aBu();
            }
        }
        aCZ();
        com.tencent.mm.plugin.emoji.model.i.aBE().lwM.c(this);
        com.tencent.mm.sdk.b.a.xef.b(this.lAO);
        ar.CG().a(423, (e) this);
        ar.CG().a(822, (e) this);
        g(this.lyH, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.lDs);
        this.lDD = true;
        com.tencent.mm.plugin.report.service.g.pQN.h(12740, Integer.valueOf(1), "", this.lyH, "", Integer.valueOf(this.lDr));
        if (this.lCG && this.lCR != null) {
            this.mHandler.postDelayed(new 2(this), 0);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.cdP;
    }

    protected final void initView() {
        if (!bh.ov(this.lyI)) {
            setMMTitle(this.lyI);
        }
        setBackBtn(new 3(this));
        this.lee = com.tencent.mm.bv.a.aa(this.mContext, R.f.bwY);
        this.lDp = getResources().getDimensionPixelSize(R.f.bwX);
        this.lDp = com.tencent.mm.bv.a.aa(this.mContext, R.f.bwX);
        this.mNumColumns = 4;
        this.lCR = (EmojiDetailScrollView) findViewById(R.h.cJh);
        this.kgl = findViewById(R.h.empty);
        this.lCP = (TextView) this.kgl.findViewById(R.h.cef);
        this.lCQ = findViewById(R.h.cdP);
        this.lCS = (BannerEmojiView) findViewById(R.h.cdA);
        this.lCS.setMinimumHeight((int) (((float) (((this.lCS.getRight() - this.lCS.getLeft()) - this.lCS.getPaddingRight()) - this.lCS.getPaddingLeft())) * 0.56f));
        this.lCT = (TextView) findViewById(R.h.cdY);
        this.lCU = (MMAutoSizeTextView) findViewById(R.h.cdZ);
        this.lCV = (TextView) findViewById(R.h.cdq);
        this.lCW = (TextView) findViewById(R.h.cea);
        this.lCX = (TextView) findViewById(R.h.cdt);
        this.lDd = com.tencent.mm.bv.a.eA(this.mController.xIM);
        this.lDe = findViewById(R.h.cdl);
        this.lCY = (EmojiDetailGridView) findViewById(R.h.cdx);
        if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH)) {
            this.lCM = new b(this);
        } else {
            this.lCM = new a(this);
        }
        this.lDa = findViewById(R.h.cdG);
        this.ltx = (ProgressBar) findViewById(R.h.cdv);
        this.lCZ = (ImageView) findViewById(R.h.cdo);
        this.lCZ.setOnClickListener(this);
        this.lDa.setVisibility(8);
        this.lCZ.setVisibility(8);
        this.ltx.setProgress(0);
        this.lCY.setAdapter(this.lCM);
        this.lCY.setColumnWidth(this.lDp);
        this.lCY.setNumColumns(this.mNumColumns);
        this.lCY.setHorizontalSpacing(this.lee);
        this.lCY.setVerticalSpacing(this.lee);
        this.lCY.lCn = this.lCR;
        this.lCY.zEe = true;
        this.lCW.setOnClickListener(this);
        this.lDb = (TextView) findViewById(R.h.cdJ);
        this.lDc = (TextView) findViewById(R.h.cdp);
        this.lDb.setOnClickListener(this.lDE);
        this.lDc.setOnClickListener(this.lDF);
        this.lDf = (ProgressBar) findViewById(R.h.cdw);
        this.lDf.setVisibility(this.lDt ? 0 : 8);
        this.lDz = findViewById(R.h.cdD);
        this.lDj = findViewById(R.h.cds);
        this.lDg = findViewById(R.h.caU);
        this.lDh = (ImageView) findViewById(R.h.caZ);
        this.lDi = (TextView) findViewById(R.h.cbi);
        this.lDk = findViewById(R.h.cdH);
        this.lDl = (MMCopiableTextView) findViewById(R.h.cHT);
        this.lDm = (Button) findViewById(R.h.cHU);
        this.lDo = (TextView) findViewById(R.h.cHY);
        this.lDn = (DonorsAvatarView) findViewById(R.h.cHS);
        this.lDm.setOnClickListener(this.lDG);
        this.lDo.setOnClickListener(this.lDH);
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(412, (e) this);
        ar.CG().a(521, (e) this);
        this.lDy = false;
        if (!this.lDD) {
            aCW();
            oP(1007);
        }
        aCX();
        this.lDD = false;
        oP(1001);
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(412, (e) this);
        ar.CG().b(521, (e) this);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.i.aBE().lwM.j(this);
        com.tencent.mm.sdk.b.a.xef.c(this.lAO);
        ar.CG().b(423, (e) this);
        ar.CG().b(822, (e) this);
        if (this.lCY != null) {
            this.lCY.release();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(DownloadInfo.STATUS, this.lCI);
        bundle.putInt("progress", this.sm);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.lCI = bundle.getInt(DownloadInfo.STATUS);
        this.sm = bundle.getInt("progress");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.cea) {
            String stringExtra;
            if (this.lCI == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (bh.ov(stringExtra) || !this.lCH) {
                    this.lxT.n(this);
                    com.tencent.mm.plugin.report.service.g.pQN.h(12069, Integer.valueOf(2), this.lyH);
                } else {
                    b.a(stringExtra, this.lyH, (Activity) this);
                }
                x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                com.tencent.mm.plugin.report.service.g.pQN.k(11076, "0, ");
                return;
            }
            switch (this.lCI) {
                case -1:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                case 0:
                case 3:
                    aDf();
                    this.lCI = 6;
                    aDc();
                    com.tencent.mm.plugin.report.service.g.pQN.h(12066, Integer.valueOf(1), Integer.valueOf(this.lDr), "", this.lyH, Long.valueOf(this.lxP), this.lxQ);
                    return;
                case 4:
                    if (!this.lDy) {
                        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", this.lyH, this.lBc.wau, this.lBc.waD);
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.lyH);
                        if (this.lDt) {
                            intent.putExtra("key_currency_type", "");
                            intent.putExtra("key_price", this.lDw);
                        } else {
                            intent.putExtra("key_currency_type", this.lBc.waD);
                            intent.putExtra("key_price", this.lBc.waC);
                        }
                        d.b(this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        com.tencent.mm.plugin.report.service.g.pQN.h(12066, Integer.valueOf(2), Integer.valueOf(this.lDr), "", this.lyH, Long.valueOf(this.lxP), this.lxQ);
                        this.lDy = true;
                        return;
                    }
                    return;
                case 5:
                    this.lCI = 3;
                    aDc();
                    return;
                case 10:
                case 12:
                    switch (this.lDv) {
                        case 10233:
                            stringExtra = getString(R.l.dZV);
                            break;
                        case 10234:
                            stringExtra = getString(R.l.dZQ);
                            break;
                        case 10235:
                            stringExtra = getString(R.l.ebt);
                            break;
                        default:
                            stringExtra = getString(R.l.ebx);
                            break;
                    }
                    h.b(this, stringExtra, null, true);
                    return;
                case 11:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                default:
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", Integer.valueOf(this.lCI));
                    return;
            }
        } else if (id == R.h.cdv) {
            aDe();
        } else if (id == R.h.cdo) {
            aDe();
        } else {
            x.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
        switch (kVar.getType()) {
            case 412:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                l lVar = (l) kVar;
                if (lVar == null || bh.ov(lVar.lyH) || !lVar.lyH.equalsIgnoreCase(this.lyH)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0) {
                    if (i2 == 0) {
                        this.lBc = lVar.aBS();
                        oP(1002);
                        return;
                    } else if (i2 == 1) {
                        aCU();
                        return;
                    } else {
                        this.lCP.setText(R.l.eax);
                        aCV();
                        return;
                    }
                } else if (i2 == 5) {
                    if (!(lVar == null || lVar.aBS() == null)) {
                        this.lBc.waw = lVar.aBS().waw;
                    }
                    oP(1002);
                    return;
                } else if (i2 == 1) {
                    aCU();
                    return;
                } else {
                    this.lCR.setVisibility(8);
                    this.kgl.setVisibility(0);
                    this.lCP.setText(R.l.eay);
                    aCV();
                    return;
                }
            case 423:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                g gVar = (g) kVar;
                if (gVar == null || bh.ov(gVar.lyH) || !gVar.lyH.equalsIgnoreCase(this.lyH)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.lDs = gVar.hBn;
                    this.lCI = 6;
                    aDc();
                    return;
                } else {
                    this.lCI = -1;
                    aDc();
                    String str2 = this.lyI;
                    h.a(this, String.format(getString(R.l.eat), new Object[]{str2}), "", new 10(this), new 11(this));
                    return;
                }
            case 521:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                k kVar2 = (k) kVar;
                if (kVar2 == null || bh.ov(kVar2.lyx) || !kVar2.lyx.equalsIgnoreCase(this.lyH)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.lDB = (abt) kVar2.gJQ.hmh.hmo;
                    } else {
                        this.lDB = null;
                    }
                    this.lDC = true;
                    aDd();
                }
                this.lDC = true;
                aDd();
                return;
            case 822:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                if (i == 0 && i2 == 0) {
                    this.lCN = ((o) kVar).aBW();
                    oP(1007);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aCU() {
        this.kgl.setVisibility(0);
        this.lCQ.setVisibility(8);
        this.lCR.setVisibility(8);
        this.lCP.setText(R.l.dZU);
    }

    private void aCV() {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.lBc == null || this.lBc.waw == 0) {
            this.kgl.setVisibility(0);
            this.lCQ.setVisibility(8);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", Integer.valueOf(i), Integer.valueOf(i2));
        String str;
        String stringExtra;
        if (i == 2001) {
            str = "";
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + intExtra);
                stringExtra = intent.getStringExtra("key_err_msg");
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + stringExtra);
            } else {
                stringExtra = str;
                intExtra = 0;
            }
            this.lDy = false;
            if (i2 != -1) {
                this.lCI = -1;
                aDc();
                if (q.Ge()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 2, 1, false);
                }
            } else if (intent != null && r0 == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.lyH)) {
                    this.lCI = -1;
                    aDc();
                    yy(stringExtra);
                    return;
                }
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    if (this.lyH.equals(stringArrayListExtra.get(i3))) {
                        this.lyJ = (String) stringArrayListExtra2.get(i3);
                    }
                }
                this.lBc.waw = 1;
                aDf();
                this.lCI = 6;
                h.bu(this, stringExtra);
                if (q.Ge()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 4, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 0, 1, false);
                }
            } else if (intent != null && r0 == 100000002) {
                aDf();
                this.lCI = 6;
                this.lCM.notifyDataSetChanged();
                if (q.Ge()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 7, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 3, 1, false);
                }
            } else if (intent == null || r0 != 1) {
                this.lCI = -1;
                aDc();
                yy(stringExtra);
                if (q.Ge()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 5, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 1, 1, false);
                }
            } else {
                this.lCI = -1;
                aDc();
                if (q.Ge()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 6, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(166, 2, 1, false);
                }
            }
        } else if (i == 2002) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                if (!bh.ov(stringExtra)) {
                    x.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + stringExtra);
                    String str2 = this.lyH;
                    String str3 = this.lBc.war;
                    String str4 = this.lBc.was;
                    String str5 = this.lBc.nfT;
                    String str6 = this.lBc.waK;
                    int i4 = this.lBc.waw;
                    str = new StringBuffer(getResources().getString(R.l.dEI)).append(str3).toString();
                    com.tencent.mm.pluginsdk.ui.applet.e.a aVar = new com.tencent.mm.pluginsdk.ui.applet.e.a(this);
                    aVar.bS(stringExtra).Sp(str).BW(R.l.dGA);
                    aVar.Sq(str5).caT();
                    aVar.Ss(getString(R.l.dUb)).a(new 1(stringExtra, str2, str3, str4, str5, str6, i4, this)).pyk.show();
                }
            }
        } else if (i == this.lxT.jKN && i2 == -1) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", intent.getStringExtra("Select_Conv_User"));
            b.a(intent, this.lyH, (Activity) this);
            com.tencent.mm.plugin.report.service.g.pQN.h(12069, Integer.valueOf(3), this.lyH);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        oP(1001);
    }

    private void yy(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.dZY);
        }
        h.a(this, str, "", new 4(this));
    }

    private void aCW() {
        this.lCN = com.tencent.mm.plugin.emoji.model.i.aBE().lwQ.Yb(this.lyH);
    }

    private void aCX() {
        if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.waw, 64) && n.aBk()) {
            this.lCL = new o(this.lyH, o.lze);
            ar.CG().a(this.lCL, 0);
        }
    }

    private boolean aCY() {
        boolean aCY = com.tencent.mm.plugin.emoji.h.a.aCY();
        this.lCO = aCY;
        this.lCI = aCY ? 7 : 3;
        return aCY;
    }

    private void aCZ() {
        if (!bh.ov(this.lBc.war)) {
            setMMTitle(this.lBc.war);
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", this.lBc.waE);
        this.lCQ.setVisibility(0);
        this.kgl.setVisibility(8);
        ex(true);
        this.lCU.setText(this.lBc.war);
        this.lCV.setText(this.lBc.waB);
        this.lCX.setText(this.lBc.was);
        if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.wav, 1)) {
            this.lCT.setVisibility(8);
        } else {
            this.lCT.setVisibility(0);
            this.lCT.setText(R.l.ebw);
        }
        aDb();
        aDc();
        aDd();
        if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH) || !(this.lBc.waH == null || this.lBc.waH.size() <= 0 || ((avh) this.lBc.waH.get(0)).wCX == null)) {
            this.lCY.zEh = true;
            this.lDz.setVisibility(0);
        } else {
            this.lDz.setVisibility(8);
            this.lCY.zEh = false;
        }
        this.lCY.lyH = this.lyH;
        if (this.lCM != null) {
            this.lCM.notifyDataSetInvalidated();
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", this.lBc.waw);
        if ((this.lBc.waw & 16) == 16) {
            addIconOptionMenu(0, R.k.dzQ, new 7(this));
        }
        this.lCU.setMaxWidth((((this.lDd - this.lDe.getWidth()) - (com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvJ) * 2)) - this.lCT.getWidth()) - (com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvy) * 2));
        this.lCU.setVisibility(8);
        this.lCU.setVisibility(0);
        if (this.lBc.waM == null || this.lBc.waM.wko == 0 || this.lDr == 6) {
            this.lDj.setVisibility(8);
            this.lDg.setVisibility(8);
        } else {
            this.lDj.setVisibility(0);
            this.lDg.setVisibility(0);
            com.tencent.mm.aq.o.PA().a(this.lBc.waM.waN, this.lDh, f.ch(this.lyH, this.lBc.waM.waN));
            this.lDi.setText(this.lBc.waM.nfp);
            this.lDg.setOnClickListener(new 6(this));
        }
        LayoutParams layoutParams;
        if ((this.lBc.waw & 32) == 32) {
            layoutParams = (LayoutParams) this.lDc.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.lDb.getLayoutParams();
            this.lDc.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvJ);
            this.lDc.setLayoutParams(layoutParams);
            this.lDc.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bv.a.aa(this.mController.xIM, R.f.bvJ);
            this.lDb.setLayoutParams(layoutParams2);
            this.lDb.setGravity(5);
        } else {
            layoutParams = (LayoutParams) this.lDb.getLayoutParams();
            layoutParams.gravity = 17;
            this.lDb.setLayoutParams(layoutParams);
            this.lDb.setGravity(17);
            this.lDc.setVisibility(8);
        }
        aDa();
    }

    private void ex(boolean z) {
        EmojiInfo emojiInfo;
        if (bh.ov(this.lBc.waz)) {
            emojiInfo = null;
        } else if (z) {
            r0 = this.lyH;
            String str = this.lBc.waz;
            com.tencent.mm.bv.a.getDensity(this.mContext);
            emojiInfo = EmojiLogic.a(r0, str, this.lDI);
        } else {
            r0 = this.lyH;
            String str2 = this.lBc.waz;
            com.tencent.mm.bv.a.getDensity(this.mContext);
            emojiInfo = EmojiLogic.a(r0, 4, str2, true);
        }
        if (!(emojiInfo == null || this.lCS == null)) {
            this.lCS.cR(emojiInfo.ckB(), null);
        }
        if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH)) {
            this.lCS.setImageResource(R.g.bHc);
        }
    }

    public final void aDa() {
        if (!com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.waw, 64) || !n.aBk()) {
            this.lDk.setVisibility(8);
        } else if (this.lCN != null) {
            this.lDk.setVisibility(0);
            this.lDm.setText(R.l.eaJ);
            this.lDl.setText(this.lCN.wkV.waR);
            this.lDl.setLongClickable(false);
            if (this.lCN.wkE > 0) {
                this.lDo.setVisibility(0);
                String valueOf = String.valueOf(this.lCN.wkE);
                Object format = String.format(getString(R.l.eaL), new Object[]{Integer.valueOf(this.lCN.wkE)});
                CharSequence spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.bsd)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.lDo.setText(spannableString);
            } else {
                this.lDo.setVisibility(8);
            }
            if (this.lCN.wkF == null || this.lCN.wkF.size() <= 0) {
                this.lDn.setVisibility(8);
                return;
            }
            this.lDn.setVisibility(0);
            this.lDn.b(this.lyH, this.lCN.wkF);
        } else {
            this.lDk.setVisibility(8);
            aCX();
        }
    }

    private void aDb() {
        if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.wav, 8)) {
            this.lDq = 0;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.wav, 4)) {
            this.lDq = 0;
        } else if (this.lDt || !TextUtils.isEmpty(this.lBc.wau)) {
            this.lDq = 1;
        } else {
            this.lDq = 0;
        }
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", Integer.valueOf(this.lBc.waw));
        if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.waw, 8) && com.tencent.mm.plugin.emoji.a.a.e.oK(this.lBc.wav)) {
            this.lCI = 8;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.waw, 1) || com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.wav, 8)) {
            this.lCI = 3;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.oK(this.lBc.wav)) {
            this.lCI = 0;
        } else if (!this.lDt && (TextUtils.isEmpty(this.lBc.waC) || this.lBc.waC.equals("0"))) {
            this.lCI = 0;
        } else if (!this.lDt) {
            this.lCI = 4;
        } else if (TextUtils.isEmpty(this.lDw)) {
            this.lCI = this.lDu;
        } else {
            this.lCI = 4;
        }
        if (this.lCO) {
            this.lCI = 7;
        }
    }

    private void aDc() {
        while (true) {
            if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH)) {
                aCY();
            }
            switch (this.lCI) {
                case -1:
                    aDb();
                case 0:
                    this.lDf.setVisibility(8);
                    this.lCW.setTextColor(getResources().getColorStateList(R.e.bul));
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setText(R.l.eas);
                    this.lCW.setEnabled(true);
                    return;
                case 3:
                    this.lDf.setVisibility(8);
                    this.lCW.setTextColor(getResources().getColorStateList(R.e.bul));
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setText(R.l.eas);
                    this.lCW.setEnabled(true);
                    return;
                case 4:
                    this.lDf.setVisibility(8);
                    this.lCW.setTextColor(getResources().getColorStateList(R.e.bul));
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setEnabled(true);
                    if (!this.lDt) {
                        this.lCW.setText(this.lBc.wau);
                        this.lCI = 4;
                        return;
                    } else if (bh.ov(this.lDw)) {
                        this.lCW.setText("");
                        return;
                    } else {
                        this.lCW.setText(this.lDw);
                        return;
                    }
                case 5:
                    this.lDf.setVisibility(8);
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setText(R.l.eas);
                    this.lCW.setEnabled(true);
                    break;
                case 6:
                    this.lDf.setVisibility(8);
                    this.lCW.setEnabled(false);
                    this.lDa.setVisibility(0);
                    this.lCZ.setVisibility(0);
                    this.lCW.setVisibility(4);
                    if (this.lCE == 3) {
                        return;
                    }
                    return;
                case 7:
                    this.lDf.setVisibility(8);
                    this.lCW.setEnabled(true);
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setText(R.l.ebh);
                    this.lDa.setVisibility(8);
                    this.ltx.setProgress(0);
                    this.lCZ.setVisibility(4);
                    this.lCW.setVisibility(0);
                    if (this.lCE == 3) {
                        return;
                    }
                    return;
                case 8:
                    this.lDf.setVisibility(8);
                    this.lCW.setTextColor(getResources().getColorStateList(R.e.bsc));
                    this.lCW.setBackgroundResource(R.g.bAe);
                    this.lCW.setText(R.l.eav);
                    this.lCW.setEnabled(false);
                    return;
                case 10:
                case 12:
                    this.lDf.setVisibility(8);
                    this.lCW.setVisibility(0);
                    this.lCW.setBackgroundResource(R.g.bAb);
                    this.lCW.setText(R.l.eaE);
                    this.lCW.setEnabled(true);
                    this.lDa.setVisibility(8);
                    this.ltx.setProgress(0);
                    this.lCZ.setVisibility(4);
                    return;
                case 11:
                    break;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", Integer.valueOf(this.lCI));
                    return;
            }
            this.lDf.setVisibility(0);
            this.lCW.setVisibility(0);
            this.lCW.setBackgroundResource(R.g.bHZ);
            this.lCW.setText("");
            this.lCW.setEnabled(false);
            this.lDa.setVisibility(8);
            this.ltx.setProgress(0);
            this.lCZ.setVisibility(4);
            return;
        }
    }

    private void aDd() {
        if (!this.lDC) {
            return;
        }
        if (this.lDB != null && (this.lDB.wkC & 1) == 1) {
            return;
        }
        if ((this.lBc == null || !com.tencent.mm.plugin.emoji.a.a.e.co(this.lBc.waw, 1)) && this.lDB != null && !TextUtils.isEmpty(this.lDB.wkB)) {
            this.lCW.setText(this.lDB.wkB);
            this.lCW.setTextColor(this.mController.xIM.getResources().getColor(R.e.bsK));
            this.lCW.setBackgroundDrawable(null);
            this.lCW.setEnabled(false);
        }
    }

    private void aDe() {
        h.a(this, R.l.ean, 0, R.l.eaV, R.l.eap, new 8(this), new 9(this));
    }

    public final void g(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        if (!bh.ov(str) && str.equals(this.lyH)) {
            if (!TextUtils.isEmpty(str2)) {
                this.lDs = str2;
            }
            if (i == -1) {
                if (this.lCI != -1) {
                    this.lCI = -1;
                    oP(1003);
                }
            } else if (i == 7) {
                this.lCI = 7;
                oP(1003);
            } else if (i != 6) {
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
            } else if (!TextUtils.isEmpty(str) && str.equals(this.lyH)) {
                this.lCI = 6;
                this.sm = i2;
                oP(1004);
            }
        }
    }

    private void aDf() {
        if (com.tencent.mm.plugin.emoji.h.a.yO(this.lyH)) {
            com.tencent.mm.plugin.emoji.f.a.aBJ();
            com.tencent.mm.plugin.emoji.f.a.aBK();
            return;
        }
        this.lCK = new g(this.lyH, this.lyJ, this.lyI);
        ar.CG().a(this.lCK, 0);
        switch (this.lAK) {
            case 9:
                com.tencent.mm.plugin.report.service.g.pQN.h(11598, Integer.valueOf(2), this.lyH);
                return;
            case 10:
                com.tencent.mm.plugin.report.service.g.pQN.h(11598, Integer.valueOf(1), this.lyH);
                return;
            case 11:
                com.tencent.mm.plugin.report.service.g.pQN.h(11598, Integer.valueOf(3), this.lyH);
                return;
            default:
                return;
        }
    }

    public final void oP(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
    }
}
