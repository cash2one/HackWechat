package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.aq.o;
import com.tencent.mm.bc.g;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FTSEmojiDetailPageUI extends MMActivity implements e {
    private String designerName;
    private String fCa;
    private String fqV;
    private int fqd;
    private String fuX;
    private int hek;
    private l juS;
    private ProgressBar kmo;
    private EmojiInfo kqm;
    private MMAnimateView lEC;
    private Button lED;
    private Button lEE;
    private TextView lEF;
    private ImageView lEG;
    private View lEH;
    private boolean lEI;
    private boolean lEJ;
    private String lEK;
    private String lEL;
    private String lEM;
    private String lEN;
    private String lEO;
    private String lEP;
    private String lEQ;
    private c lER = new c<cq>(this) {
        final /* synthetic */ FTSEmojiDetailPageUI lEU;

        {
            this.lEU = r2;
            this.xen = cq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cq cqVar = (cq) bVar;
            if (this.lEU.kqm != null && cqVar.fqQ.fqR.equals(this.lEU.kqm.Nr())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", new Object[]{this.lEU.kqm.Nr()});
                ag.y(new 1(this));
            }
            return false;
        }
    };
    private i lES = new 10(this);
    private p$d lET = new 3(this);
    private a lxJ = new a(this) {
        final /* synthetic */ FTSEmojiDetailPageUI lEU;

        {
            this.lEU = r1;
        }

        public final void h(EmojiInfo emojiInfo) {
            if (emojiInfo == null || this.lEU.kqm == null || !this.lEU.kqm.Nr().equals(emojiInfo.Nr())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                return;
            }
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[]{this.lEU.kqm.Nr()});
            ag.y(new 1(this));
        }
    };
    private String lxQ;
    private int scene;
    private int type;

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2) {
        g.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lEK, fTSEmojiDetailPageUI.lxQ, 2, 0);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("emoji_activity_id", str2);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        d.a(fTSEmojiDetailPageUI, ".ui.transmit.SelectConversationUI", intent, 0);
        fTSEmojiDetailPageUI.overridePendingTransition(R.a.bqo, R.a.bqa);
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        g.a(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lEK, fTSEmojiDetailPageUI.lxQ, 1, 0);
        EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(str);
        ar.Hg();
        String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", str);
        if (XU == null && com.tencent.mm.a.e.bO(H)) {
            int i = p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.xAe;
            emojiInfo.field_type = i;
            emojiInfo.field_size = com.tencent.mm.a.e.bN(H);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            com.tencent.mm.plugin.emoji.model.i.aBE().lwL.n(emojiInfo);
            XU = emojiInfo;
        }
        if (XU != null) {
            boolean a = com.tencent.mm.plugin.emoji.model.i.aBA().a(fTSEmojiDetailPageUI, XU, 18, q.FS());
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", new Object[]{Boolean.valueOf(a)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        int i;
        int i2 = fTSEmojiDetailPageUI.scene;
        String str = fTSEmojiDetailPageUI.lEK;
        String str2 = fTSEmojiDetailPageUI.lxQ;
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                if (!bh.ov(fTSEmojiDetailPageUI.fqV)) {
                    i = 1;
                    break;
                }
            case 3:
                if (!bh.ov(fTSEmojiDetailPageUI.fuX)) {
                    i = 2;
                    break;
                }
            case 4:
                if (!bh.ov(fTSEmojiDetailPageUI.lEN)) {
                    i = 3;
                    break;
                }
            default:
                i = 0;
                break;
        }
        if (fTSEmojiDetailPageUI.aDm()) {
            i = 4;
        }
        g.a(i2, str, str2, 3, i);
        if (fTSEmojiDetailPageUI.aDm()) {
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 8);
            bundle.putString("stat_search_id", fTSEmojiDetailPageUI.lEK);
            String str3 = fTSEmojiDetailPageUI.lEK + ":" + fTSEmojiDetailPageUI.lxQ + ":" + String.valueOf(fTSEmojiDetailPageUI.scene) + ":" + String.valueOf(fTSEmojiDetailPageUI.type);
            Intent intent = new Intent();
            intent.putExtra("key_username", fTSEmojiDetailPageUI.lEQ);
            intent.putExtra("key_can_swipe_back", true);
            intent.putExtra("key_from_scene", 6);
            intent.putExtra("key_scene_note", str3);
            intent.putExtra("_stat_obj", bundle);
            d.b(fTSEmojiDetailPageUI.mController.xIM, "appbrand", ".ui.AppBrandProfileUI", intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("preceding_scence", fTSEmojiDetailPageUI.getIntent().getIntExtra("preceding_scence", 0));
        intent2.putExtra("download_entrance_scene", 27);
        intent2.putExtra("searchID", bh.getLong(fTSEmojiDetailPageUI.lEK, 0));
        intent2.putExtra("docID", fTSEmojiDetailPageUI.lxQ);
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreDetailUI.class);
                intent2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent2.putExtra("extra_scence", fTSEmojiDetailPageUI.scene);
                intent2.putExtra("extra_type", fTSEmojiDetailPageUI.type);
                intent2.putExtra("extra_id", fTSEmojiDetailPageUI.fqV);
                break;
            case 3:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreV2DesignerUI.class);
                intent2.putExtra("extra_scence", 27);
                intent2.putExtra(SlookAirButtonFrequentContactAdapter.ID, fTSEmojiDetailPageUI.fuX);
                intent2.putExtra("name", fTSEmojiDetailPageUI.designerName);
                intent2.putExtra("headurl", fTSEmojiDetailPageUI.lEP);
                break;
            case 4:
                if (!bh.ov(fTSEmojiDetailPageUI.lEN)) {
                    intent2.putExtra("rawUrl", fTSEmojiDetailPageUI.lEN);
                    d.b(ac.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            default:
                return;
        }
        fTSEmojiDetailPageUI.startActivity(intent2);
    }

    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.lEJ) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.eHg));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.eao));
        if (fTSEmojiDetailPageUI.juS == null) {
            fTSEmojiDetailPageUI.juS = new l(fTSEmojiDetailPageUI.mController.xIM);
        }
        fTSEmojiDetailPageUI.juS.rKC = new 11(fTSEmojiDetailPageUI, arrayList, arrayList2);
        fTSEmojiDetailPageUI.juS.rKD = fTSEmojiDetailPageUI.lET;
        fTSEmojiDetailPageUI.juS.e(new 2(fTSEmojiDetailPageUI));
        h.a(fTSEmojiDetailPageUI.mController.xIM, fTSEmojiDetailPageUI.juS.bBX());
    }

    static /* synthetic */ void g(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        x.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + w.cfi());
        String str = fTSEmojiDetailPageUI.getString(R.l.ekp) + w.cfi();
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(R.l.eao));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        d.b(fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        if (FileOp.bO(fTSEmojiDetailPageUI.fCa)) {
            k.h(fTSEmojiDetailPageUI.fCa, fTSEmojiDetailPageUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lED = (Button) findViewById(R.h.cdm);
        this.lEE = (Button) findViewById(R.h.cdI);
        this.lEC = (MMAnimateView) findViewById(R.h.cdB);
        this.kmo = (ProgressBar) findViewById(R.h.ctw);
        this.lEF = (TextView) findViewById(R.h.cdL);
        this.lEG = (ImageView) findViewById(R.h.cdK);
        this.lEH = findViewById(R.h.bottom_bar);
        setBackBtn(new 1(this));
        this.lED.setOnClickListener(new 4(this));
        this.lEE.setOnClickListener(new 5(this));
        this.lEH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSEmojiDetailPageUI lEU;

            {
                this.lEU = r1;
            }

            public final void onClick(View view) {
                FTSEmojiDetailPageUI.b(this.lEU);
            }
        });
        addIconOptionMenu(0, R.g.bDI, new 7(this));
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.kqm = new EmojiInfo();
        this.kqm.field_designerID = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.kqm.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.kqm.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.kqm.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.kqm.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.kqm.field_md5 = getIntent().getStringExtra("extra_md5");
        this.kqm.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.fqV = this.kqm.field_groupId;
        this.lEM = getIntent().getStringExtra("extra_product_name");
        this.lEL = getIntent().getStringExtra("productUrl");
        this.lEN = getIntent().getStringExtra("extra_article_url");
        this.lEO = getIntent().getStringExtra("extra_article_name");
        this.fuX = this.kqm.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.lEP = getIntent().getStringExtra("headurl");
        this.lEQ = getIntent().getStringExtra("weapp_user_name");
        this.hek = getIntent().getIntExtra("weapp_version", 0);
        this.fqd = getIntent().getIntExtra("source_type", 0);
        this.lEK = getIntent().getStringExtra("searchID");
        this.lxQ = getIntent().getStringExtra("docID");
        this.lEI = getIntent().getBooleanExtra("disableAddSticker", false);
        this.lEJ = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!bh.ov(stringExtra)) {
            this.kqm.field_activityid = stringExtra;
        }
        com.tencent.mm.sdk.b.a.xef.b(this.lER);
        com.tencent.mm.plugin.emoji.model.i.aBy().lxw = this.lxJ;
        g.g(this.scene, this.lEK, this.lxQ);
        eA(true);
        x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[]{this.fCa});
        g.g(this.scene, this.lEK, this.lxQ);
    }

    protected void onResume() {
        super.onResume();
        aDl();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            EmojiInfo emojiInfo;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.kqm.Nr());
            if (XU == null) {
                ar.Hg();
                String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", this.kqm.Nr());
                if (com.tencent.mm.a.e.bO(H)) {
                    int i3 = p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl;
                    EmojiInfo emojiInfo2 = new EmojiInfo();
                    emojiInfo2.field_md5 = this.kqm.Nr();
                    emojiInfo2.field_catalog = EmojiInfo.xAe;
                    emojiInfo2.field_type = i3;
                    emojiInfo2.field_size = com.tencent.mm.a.e.bN(H);
                    emojiInfo2.field_temp = 1;
                    if (!bh.ov(this.kqm.field_activityid)) {
                        emojiInfo2.field_activityid = this.kqm.field_activityid;
                    }
                    emojiInfo2.field_designerID = this.kqm.field_designerID;
                    emojiInfo2.field_thumbUrl = this.kqm.field_thumbUrl;
                    XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.n(emojiInfo2);
                }
                emojiInfo = XU;
            } else {
                XU.field_designerID = this.kqm.field_designerID;
                XU.field_thumbUrl = this.kqm.field_thumbUrl;
                emojiInfo = XU;
            }
            for (String str : bh.F(bh.az(stringExtra, "").split(","))) {
                if (emojiInfo != null) {
                    com.tencent.mm.plugin.emoji.model.i.aBA().a(str, emojiInfo, null);
                    if (!bh.ov(stringExtra2)) {
                        f.aZh().dj(stringExtra2, str);
                    }
                }
            }
            com.tencent.mm.ui.snackbar.a.h(this, this.mController.xIM.getString(R.l.eic));
        }
    }

    private void eA(boolean z) {
        if (z) {
            setMMTitle(this.kqm.getName());
        }
        switch (this.type) {
            case 2:
                o.PA().a(this.lEL, this.lEG);
                this.lEF.setText(this.lEM);
                this.fCa = this.kqm.ckB();
                break;
            case 3:
                o.PA().a(this.lEP, this.lEG);
                this.lEF.setText(this.designerName);
                this.fCa = this.kqm.ckB();
                break;
            case 4:
                this.lEG.setVisibility(8);
                if (!bh.ov(this.lEO)) {
                    this.lEF.setText(this.lEO);
                    break;
                } else {
                    this.lEF.setText(R.l.eIS);
                    break;
                }
        }
        if (FileOp.bO(this.fCa)) {
            this.kmo.setVisibility(8);
            this.lEC.setVisibility(0);
            EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.kqm.Nr());
            if (XU == null || (XU.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.lEC.cR(this.fCa, null);
            } else {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.lEC.g(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(XU), "");
            }
            aDl();
            EmojiInfo XU2 = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.kqm.Nr());
            if (XU2 == null) {
                XU = this.kqm;
            } else {
                XU = XU2;
            }
            if (XU.field_catalog == EmojiInfo.xAk || bh.ov(XU.field_groupId) || ((!bh.ov(XU.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yf(XU.field_groupId)) || this.type == 4)) {
                this.lEE.setEnabled(true);
            } else {
                String str = this.kqm.field_groupId;
                ar.CG().a(423, this);
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.g(str, (byte) 0), 0);
            }
        } else if (z) {
            if (this.type == 4) {
                File file = new File(getCacheDir(), com.tencent.mm.a.g.s(this.kqm.field_encrypturl.getBytes()));
                if (file.exists()) {
                    this.kqm.field_md5 = com.tencent.mm.a.g.i(file);
                    ar.Hg();
                    String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", this.kqm.field_md5);
                    if (!FileOp.bO(H)) {
                        FileOp.x(file.getAbsolutePath(), H);
                    }
                    this.fCa = H;
                    eA(false);
                } else {
                    com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                    aVar.hDA = true;
                    aVar.hDC = file.getAbsolutePath();
                    aVar.hEd = new Object[]{file.getAbsolutePath()};
                    com.tencent.mm.plugin.emoji.model.i.aBe().a(this.kqm.field_encrypturl, null, aVar.PK(), this.lES);
                }
            } else {
                this.lEC.setVisibility(8);
                this.kmo.setVisibility(0);
                this.lED.setText(R.l.eak);
                this.lEE.setText(R.l.eEG);
                this.lED.setEnabled(false);
                this.lEE.setEnabled(false);
                com.tencent.mm.plugin.emoji.model.i.aBy().g(this.kqm);
            }
        }
        if (this.lEI) {
            this.lED.setVisibility(8);
        }
    }

    private void aDl() {
        EmojiInfo XU = com.tencent.mm.plugin.emoji.model.i.aBE().lwL.XU(this.kqm.Nr());
        if (XU == null) {
            XU = this.kqm;
        }
        if (XU.field_catalog == EmojiGroupInfo.xAd) {
            this.lED.setEnabled(false);
            this.lED.setText(R.l.dDL);
            return;
        }
        this.lED.setText(R.l.eak);
        if (com.tencent.mm.a.e.bO(this.fCa)) {
            this.lED.setEnabled(true);
        } else {
            this.lED.setEnabled(false);
        }
    }

    private boolean aDm() {
        if (bh.ov(this.lEQ) || this.fqd != 1) {
            return false;
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.diU;
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.xef.c(this.lER);
        com.tencent.mm.plugin.emoji.model.i.aBy().lxw = null;
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.emoji.f.g) {
            ar.CG().b(423, this);
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bh.ov(gVar.lyH) || this.kqm == null || bh.ov(this.kqm.field_groupId) || !this.kqm.field_groupId.equalsIgnoreCase(gVar.lyH)) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                this.lEE.setEnabled(true);
            } else {
                this.lEE.setEnabled(false);
            }
        }
    }
}
