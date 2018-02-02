package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, e, a, b {
    private ListView Fv;
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String fqV;
    private EmojiInfo kqm;
    protected final int lAD = 131074;
    private final int lAE = 131075;
    private final int lAF = 131076;
    private final String lAG = "product_id";
    private final String lAH = "progress";
    private final String lAI = DownloadInfo.STATUS;
    private c lAO = new 3(this);
    private g lAP;
    f lAW;
    private View lAX;
    private ImageView lAY;
    private TextView lAZ;
    private TextView lBa;
    private abl lBb;
    private sk lBc = new sk();
    private String lBd;
    private TextView lBe;
    private h lBf;
    private abr lBg;
    private final int lBh = 131077;
    private long lBi;
    String lBj;
    private String lBk;
    private c lBl = new c<nz>(this) {
        final /* synthetic */ CustomSmileyPreviewUI lBm;

        {
            this.lBm = r2;
            this.xen = nz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nz nzVar = (nz) bVar;
            if (this.lBm.lBi != 0 && nzVar.fFS.fFV == this.lBm.lBi) {
                x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.h.a(this.lBm.mController.xIM, nzVar.fFS.fFT, "", this.lBm.getString(R.l.dSJ), false, new 1(this));
            }
            return false;
        }
    };
    af mHandler = new 1(this);

    static /* synthetic */ void a(CustomSmileyPreviewUI customSmileyPreviewUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(4), customSmileyPreviewUI.kqm.Nr(), Integer.valueOf(1), customSmileyPreviewUI.kqm.field_designerID, customSmileyPreviewUI.kqm.field_groupId, "", "", "", "", customSmileyPreviewUI.kqm.field_activityid});
    }

    static /* synthetic */ void f(CustomSmileyPreviewUI customSmileyPreviewUI) {
        customSmileyPreviewUI.kqm = i.aBE().lwL.XU(customSmileyPreviewUI.kqm.Nr());
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(customSmileyPreviewUI, com.tencent.mm.ui.widget.g.ztp, false);
        gVar.rKC = new p.c(customSmileyPreviewUI) {
            final /* synthetic */ CustomSmileyPreviewUI lBm;

            {
                this.lBm = r1;
            }

            public final void a(n nVar) {
                if (!(this.lBm.kqm.field_catalog == EmojiInfo.xAk || this.lBm.kqm.ckv())) {
                    nVar.eQ(0, R.l.dCB);
                }
                if (this.lBm.kqm.field_catalog == EmojiInfo.xAk || bh.ov(this.lBm.kqm.field_groupId) || (!bh.ov(this.lBm.kqm.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yf(this.lBm.kqm.field_groupId))) {
                    nVar.eQ(1, R.l.eEG);
                }
                nVar.eQ(2, R.l.dZP);
            }
        };
        gVar.rKD = new 2(customSmileyPreviewUI);
        gVar.bUk();
    }

    static /* synthetic */ void n(CustomSmileyPreviewUI customSmileyPreviewUI) {
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.b.ifs.l(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.g.pQN.h(12789, new Object[]{Integer.valueOf(1), customSmileyPreviewUI.kqm.Nr(), Integer.valueOf(1), customSmileyPreviewUI.kqm.field_designerID, customSmileyPreviewUI.kqm.field_groupId, customSmileyPreviewUI.lBj, "", "", "", customSmileyPreviewUI.kqm.field_activityid});
    }

    static /* synthetic */ void o(CustomSmileyPreviewUI customSmileyPreviewUI) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.lBk);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        intent.putExtra("k_username", customSmileyPreviewUI.lBj);
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.lBi);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int getLayoutId() {
        return R.i.dfo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(412, this);
        ar.CG().a(521, this);
        ar.CG().a(411, this);
        ar.CG().a(ai.CTRL_BYTE, this);
        ar.CG().a(368, this);
        com.tencent.mm.sdk.b.a.xef.b(this.lAO);
        com.tencent.mm.sdk.b.a.xef.b(this.lBl);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ar.CG().b(412, this);
        ar.CG().b(521, this);
        ar.CG().b(411, this);
        ar.CG().b(ai.CTRL_BYTE, this);
        ar.CG().b(368, this);
        com.tencent.mm.sdk.b.a.xef.c(this.lAO);
        com.tencent.mm.sdk.b.a.xef.c(this.lBl);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.lBi = getIntent().getLongExtra("msg_id", 0);
        this.lBj = getIntent().getStringExtra("msg_sender");
        this.lBk = getIntent().getStringExtra("msg_content");
        x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[]{stringExtra});
        Object ou = bh.ou(stringExtra);
        if (TextUtils.isEmpty(ou)) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.lBe = (TextView) findViewById(R.h.cai);
        final MMEmojiView mMEmojiView = (MMEmojiView) findViewById(R.h.caj);
        if (com.tencent.mm.sdk.a.b.ceK()) {
            mMEmojiView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CustomSmileyPreviewUI lBm;

                public final void onClick(View view) {
                    Toast.makeText(this.lBm.mController.xIM, "isHevc:" + mMEmojiView.vsB, 0).show();
                }
            });
        }
        if (mMEmojiView == null) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
            finish();
            return;
        }
        String str;
        String str2;
        boolean z;
        com.tencent.mm.plugin.report.service.g gVar;
        Object[] objArr;
        this.kqm = i.aBE().lwL.XU(ou);
        if (this.kqm.ckv()) {
            InputStream bk = EmojiInfo.bk(this, this.kqm.getName());
            if (bk != null) {
                mMEmojiView.a(bk, this.kqm.getName());
            } else {
                str = "MicroMsg.emoji.CustomSmileyPreviewUI";
                str2 = "input stream is null. emoji name is:%s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.kqm == null ? "null" : this.kqm.getName();
                x.e(str, str2, objArr2);
            }
        } else {
            mMEmojiView.a(this.kqm, "");
            if (!(this.kqm == null || this.kqm.ckA())) {
                com.tencent.mm.plugin.emoji.e.c.aAO();
                com.tencent.mm.plugin.emoji.e.c.a(this.kqm, true);
            }
        }
        CharSequence xZ = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().xZ(this.kqm.Nr());
        if (!(this.lBe == null || bh.ov(xZ))) {
            this.lBe.setText(xZ);
            mMEmojiView.setContentDescription(xZ);
        }
        str2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.h.bLh);
        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str2, true);
        str = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? stringExtra2 : aZ.field_appName;
        if (str2 != null && str2.length() > 0) {
            if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                textView.setText(getString(R.l.dTb, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xIM, aZ, str)}));
                textView.setVisibility(0);
                l.b bVar = new l.b();
                bVar.appId = str2;
                bVar.fEL = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str2, 2, com.tencent.mm.bv.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bEm));
                } else {
                    a(this, textView, b);
                }
                setBackBtn(new 6(this));
                if (this.kqm.field_catalog != EmojiInfo.xAk || this.kqm.ckv()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.kqm.field_catalog == EmojiInfo.xAk || bh.ov(this.kqm.field_groupId) || (!bh.ov(this.kqm.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yf(this.kqm.field_groupId))) {
                    z = true;
                }
                addIconOptionMenu(0, R.g.bDI, new 7(this));
                showOptionMenu(z);
                this.lAX = findViewById(R.h.caU);
                this.lAY = (ImageView) this.lAX.findViewById(R.h.caZ);
                this.lAZ = (TextView) this.lAX.findViewById(R.h.cbi);
                this.lBa = (TextView) this.lAX.findViewById(R.h.caX);
                this.lAX.setVisibility(8);
                if (!(this.kqm == null || bh.ov(this.kqm.field_designerID))) {
                    this.lBb = i.aBE().lwR.XY(this.kqm.field_designerID);
                    ar.CG().a(new com.tencent.mm.plugin.emoji.f.i(this.kqm.field_designerID), 0);
                }
                if (!(this.kqm == null || bh.ov(this.kqm.field_activityid))) {
                    this.lBg = i.aBE().lwO.Ye(this.kqm.field_activityid);
                    stringExtra = this.kqm.field_activityid;
                    stringExtra2 = this.kqm.field_md5;
                    if (this.lBg == null && (this.lBg == null || this.lBg.wkz == null || ((long) this.lBg.wkz.wae) >= System.currentTimeMillis() / 1000)) {
                        x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
                    } else {
                        ar.CG().a(new j(stringExtra, stringExtra2), 0);
                    }
                }
                aCC();
                this.lAX.setOnClickListener(new 8(this));
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = this.fqV;
                objArr[2] = ou;
                if (this.kqm != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.kqm.field_designerID;
                }
                objArr[3] = stringExtra;
                if (this.kqm != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.kqm.field_activityid;
                }
                objArr[4] = stringExtra;
                gVar.h(12067, objArr);
            }
        }
        textView.setVisibility(8);
        this.fqV = this.kqm.field_groupId;
        ar.CG().a(new k(this.fqV), 0);
        this.Fv = (ListView) findViewById(16908298);
        this.lAW = new f(this.mController.xIM);
        this.lAW.luC = this;
        this.lAW.ltV = true;
        this.lAW.ltY = false;
        this.Fv.setOnItemClickListener(this);
        this.Fv.setAdapter(this.lAW);
        this.lAW.luA = this.Fv;
        if (!bh.ov(this.fqV)) {
            com.tencent.mm.storage.emotion.i Ya = i.aBE().lwP.Ya(this.fqV);
            if (!(Ya == null || Ya.field_content == null)) {
                abv com_tencent_mm_protocal_c_abv = new abv();
                try {
                    com_tencent_mm_protocal_c_abv.aF(Ya.field_content);
                    this.lBc = com_tencent_mm_protocal_c_abv.wkD;
                    this.lBd = Ya.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[]{bh.i(e)});
                }
            }
            if (this.lBc == null || bh.ov(this.lBd) || !this.lBd.equalsIgnoreCase(w.eL(this.mController.xIM))) {
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.l(this.fqV, 1), 0);
            } else {
                com.tencent.mm.plugin.emoji.a.a.c aCD = aCD();
                if (this.lAW != null) {
                    this.lAW.a(aCD);
                }
                ar.CG().a(new com.tencent.mm.plugin.emoji.f.l(this.fqV, 1, this.lBc.ktM), 0);
            }
        }
        this.lBf = new h();
        this.lBf.kaK = this;
        this.lBf.lxL = this.lAW;
        this.lBf.lxO = 9;
        this.lBf.lxR = this;
        a(this.fqV, this.kqm);
        setBackBtn(new 6(this));
        if (this.kqm.field_catalog != EmojiInfo.xAk) {
        }
        z = false;
        z = true;
        addIconOptionMenu(0, R.g.bDI, new 7(this));
        showOptionMenu(z);
        this.lAX = findViewById(R.h.caU);
        this.lAY = (ImageView) this.lAX.findViewById(R.h.caZ);
        this.lAZ = (TextView) this.lAX.findViewById(R.h.cbi);
        this.lBa = (TextView) this.lAX.findViewById(R.h.caX);
        this.lAX.setVisibility(8);
        this.lBb = i.aBE().lwR.XY(this.kqm.field_designerID);
        ar.CG().a(new com.tencent.mm.plugin.emoji.f.i(this.kqm.field_designerID), 0);
        this.lBg = i.aBE().lwO.Ye(this.kqm.field_activityid);
        stringExtra = this.kqm.field_activityid;
        stringExtra2 = this.kqm.field_md5;
        if (this.lBg == null) {
        }
        ar.CG().a(new j(stringExtra, stringExtra2), 0);
        aCC();
        this.lAX.setOnClickListener(new 8(this));
        gVar = com.tencent.mm.plugin.report.service.g.pQN;
        objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.fqV;
        objArr[2] = ou;
        if (this.kqm != null) {
            stringExtra = this.kqm.field_designerID;
        } else {
            stringExtra = "";
        }
        objArr[3] = stringExtra;
        if (this.kqm != null) {
            stringExtra = this.kqm.field_activityid;
        } else {
            stringExtra = "";
        }
        objArr[4] = stringExtra;
        gVar.h(12067, objArr);
    }

    private void aCC() {
        this.mHandler.post(new 9(this));
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(R.f.bvs);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        switch (kVar.getType()) {
            case ai.CTRL_BYTE /*239*/:
                this.lBb = ((com.tencent.mm.plugin.emoji.f.i) kVar).aBQ();
                aCC();
                return;
            case 368:
                if (i2 == 0) {
                    j jVar = (j) kVar;
                    abr com_tencent_mm_protocal_c_abr = (abr) jVar.gJQ.hmh.hmo;
                    if (!(com_tencent_mm_protocal_c_abr == null || com_tencent_mm_protocal_c_abr.wkz == null)) {
                        com_tencent_mm_protocal_c_abr.wkz.wae = ((int) (System.currentTimeMillis() / 1000)) + com_tencent_mm_protocal_c_abr.wkz.wae;
                        i.aBE().lwO.a(jVar.lyU, com_tencent_mm_protocal_c_abr);
                    }
                    this.lBg = com_tencent_mm_protocal_c_abr;
                    aCC();
                    return;
                }
                x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                return;
            case 411:
                i.aBE().lwO.a(12, ((com.tencent.mm.plugin.emoji.f.n) kVar).aBU());
                return;
            case 412:
                com.tencent.mm.plugin.emoji.f.l lVar = (com.tencent.mm.plugin.emoji.f.l) kVar;
                String str2;
                String str3;
                Object[] objArr;
                com.tencent.mm.plugin.emoji.a.a.c aCD;
                if (i == 0) {
                    if (i2 == 0) {
                        this.lBc = lVar.aBS();
                        if (this.lBc == null || TextUtils.isEmpty(this.fqV) || !this.fqV.equals(this.lBc.vIR)) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.fqV;
                            objArr[1] = this.lBc == null ? "" : this.lBc.vIR;
                            x.i(str2, str3, objArr);
                            return;
                        }
                        aCD = aCD();
                        if (this.lAW != null) {
                            this.lAW.a(aCD);
                        }
                        this.mHandler.sendEmptyMessage(0);
                        x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.lBc.vIR);
                        return;
                    } else if (i2 != 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (i2 != 5) {
                    return;
                } else {
                    if (this.lBc == null || lVar.aBS() == null || TextUtils.isEmpty(this.fqV) || !this.fqV.equals(this.lBc.vIR) || this.lBc.waw == lVar.aBS().waw) {
                        str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                        str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                        objArr = new Object[2];
                        objArr[0] = this.fqV;
                        objArr[1] = this.lBc == null ? "" : this.lBc.vIR;
                        x.i(str2, str3, objArr);
                        return;
                    }
                    this.lBc.waw = lVar.aBS().waw;
                    aCD = aCD();
                    if (this.lAW != null) {
                        this.lAW.a(aCD);
                    }
                    this.mHandler.sendEmptyMessage(0);
                    x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.lBc.vIR);
                    return;
                }
            case 521:
                if (i2 == 0) {
                    this.mHandler.sendEmptyMessage(2);
                    this.mHandler.sendEmptyMessageDelayed(131077, 500);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private com.tencent.mm.plugin.emoji.a.a.c aCD() {
        List arrayList = new ArrayList();
        so soVar = new so();
        soVar.waz = this.lBc.waz;
        soVar.nfT = this.lBc.nfT;
        soVar.war = this.lBc.war;
        soVar.waw = this.lBc.waw;
        soVar.was = this.lBc.was;
        soVar.waA = this.lBc.waA;
        soVar.wav = this.lBc.wav;
        soVar.wau = this.lBc.wau;
        soVar.waC = this.lBc.waC;
        soVar.waD = this.lBc.waD;
        soVar.vIR = this.lBc.vIR;
        arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(soVar));
        return new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
    }

    private void a(String str, EmojiInfo emojiInfo) {
        if (!bh.ov(str) && emojiInfo != null) {
            if (!bh.ov(str) && emojiInfo.field_catalog != EmojiGroupInfo.xAc && emojiInfo.field_catalog != EmojiGroupInfo.xAb && ((emojiInfo.field_type != EmojiInfo.xAo || emojiInfo.field_type != EmojiInfo.xAp) && i.aBE().lwN.XR(str))) {
                if (this.Fv != null) {
                    this.Fv.setVisibility(0);
                }
                if (this.lAW == null) {
                    return;
                }
                if (i.aBE().lwN.XS(str)) {
                    this.lAW.ltW = true;
                } else {
                    this.lAW.ltW = false;
                }
            } else if (this.Fv != null) {
                this.Fv.setVisibility(8);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aAt();
        objArr[1] = TextUtils.isEmpty(aVar.aAv()) ? "" : aVar.aAv();
        objArr[2] = Integer.valueOf(aVar.aAu());
        x.i(str, str2, objArr);
        this.lBf.a(aVar);
    }

    public final void I(String str, String str2, String str3) {
        this.lAP = new g(str, str2, str3);
        ar.CG().a(this.lAP, 0);
    }

    public final void aBw() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.lAW != null && i >= 0 && i < this.lAW.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.lAW.oG(i);
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
                intent.putExtra("preceding_scence", 4);
                intent.putExtra("call_by", 1);
                intent.putExtra("download_entrance_scene", 9);
                intent.putExtra("check_clickflag", true);
                intent.putExtra("extra_status", oG.mStatus);
                intent.putExtra("extra_progress", oG.sm);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!bh.ov(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            startActivity(intent);
        }
    }
}
