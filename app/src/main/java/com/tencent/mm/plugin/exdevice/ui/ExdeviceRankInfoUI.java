package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j$a;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements j$a, e, f, d {
    private static int lVR = FileUtils.S_IWUSR;
    private boolean GO;
    private String jKk;
    private String jsF;
    private boolean lPh;
    public boolean lPt;
    public String lPu;
    private r lTm = null;
    private View lVF;
    private String lVH;
    private String lVI;
    private ImageView lVz;
    private ListView lWN;
    private b lWO;
    private View lWP;
    private ExdeviceRankListHeaderView lWQ;
    private ExdeviceRankChampionInfoView lWR;
    private View lWS;
    private String lWT;
    private String lWU;
    private String lWV;
    private String lWW;
    private a lWX;
    private String lWY;
    private int lWZ;
    private Map<String, String> lWk = new HashMap();
    private List<e> lXa;
    private ArrayList<c> lXb;
    private ArrayList<d> lXc;
    private boolean lXd;
    private boolean lXe;
    private String lXf;
    private boolean lXg;
    private j lXh;
    private b<j> lXi = new 12(this);

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bm.d.a(exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        g gVar = new g(exdeviceRankInfoUI.mController.xIM, g.ztp, false);
        gVar.rKC = new 19(exdeviceRankInfoUI);
        gVar.rKD = new 20(exdeviceRankInfoUI);
        gVar.bUk();
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        if (bh.ov(exdeviceRankInfoUI.lPu)) {
            a zc = ad.aEo().zc(exdeviceRankInfoUI.jKk);
            if (zc != null) {
                exdeviceRankInfoUI.lPu = zc.field_championUrl;
            }
        }
        d f = b.f(exdeviceRankInfoUI.jKk, exdeviceRankInfoUI.lXc);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a((Context) exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.lPu, new 13(exdeviceRankInfoUI));
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://ssl.gongyi.qq.com/yxj_health/index.html");
        com.tencent.mm.bm.d.b(exdeviceRankInfoUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        g gVar = new g(exdeviceRankInfoUI.mController.xIM, g.ztp, false);
        gVar.rKC = new p.c(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lXj;

            {
                this.lXj = r1;
            }

            public final void a(n nVar) {
                if (this.lXj.lPh) {
                    nVar.f(1, this.lXj.getString(R.l.edw));
                } else {
                    nVar.f(0, this.lXj.getString(R.l.edA));
                }
            }
        };
        gVar.rKD = new 17(exdeviceRankInfoUI);
        gVar.bUk();
    }

    private void eK(boolean z) {
        if (!this.lXe || z) {
            ad.aEs();
            this.lXc = com.tencent.mm.plugin.exdevice.f.b.c.yY(this.lWW);
            this.lXb = ad.aEm().aEy();
            this.lXa = this.lWO.b(this.lXb, this.lXc, this.lPt);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceRankInfoUI lXj;

                {
                    this.lXj = r1;
                }

                public final void run() {
                    this.lXj.lWO.lWj = this.lXj.lXa;
                    this.lXj.lWO.notifyDataSetChanged();
                    this.lXj.lWS.setVisibility(0);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.GO = false;
        this.jKk = q.FS();
        Intent intent = getIntent();
        this.lWT = intent.getStringExtra("key_rank_info");
        this.lWU = intent.getStringExtra("key_rank_semi");
        this.lWV = intent.getStringExtra("app_username");
        this.lWW = intent.getStringExtra("rank_id");
        this.lXd = intent.getBooleanExtra("key_is_latest", false);
        this.lWY = intent.getStringExtra("key_champioin_username");
        this.lWZ = intent.getIntExtra("device_type", 0);
        this.lXf = intent.getStringExtra("locate_to_username");
        this.lXe = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (bh.ov(this.lWW) || "#".equals(this.lWW)) {
            if (!this.lXe) {
                d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d aEl = ad.aEl();
                Cursor a = aEl.gJP.a(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (a == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (a.moveToFirst()) {
                        dVar = new d();
                        dVar.b(a);
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    }
                    a.close();
                }
                if (dVar != null) {
                    this.lWW = dVar.field_rankID;
                    this.lWV = dVar.field_appusername;
                }
            }
            this.lWY = null;
            this.lXd = true;
        }
        ad.aEs();
        this.lXc = com.tencent.mm.plugin.exdevice.f.b.c.yY(this.lWW);
        if (!this.lXe) {
            if (this.lXc == null || this.lXc.size() <= 0) {
                this.lXb = new ArrayList();
                this.lXc = com.tencent.mm.plugin.exdevice.f.a.a.a(this.lWW, this.lWV, this.lWT, this.lWU, this.lWk, this.lXb);
                ad.aEs();
                com.tencent.mm.plugin.exdevice.f.b.c.d(this.lWW, this.lXc);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.a(this.lWT, this.lWU, this.lWk);
            }
            this.lXb = ad.aEm().aEy();
        }
        this.lWO = new b(this, this.lWV);
        this.lWO.lWk = this.lWk;
        this.lXa = this.lWO.b(this.lXb, this.lXc, this.lPt);
        this.lWO.lWj = this.lXa;
        if (bh.ov(this.lWY)) {
            aFm();
        }
        this.lWX = ad.aEo().zc(this.lWY);
        if (this.lWX == null && !bh.ov(this.lWY)) {
            this.lWX = new a();
            this.lWX.field_username = this.lWY;
            this.lWX.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.lWX.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.aEs();
            ad.aEo().a(this.lWX, true);
        }
        initView();
        if (this.lXc != null && this.lXc.size() > 0) {
            this.lWR.zq(((d) this.lXc.get(0)).field_username);
        }
        ad.aEt().a(this);
        ad.aEs().lPD = this;
        aFk();
        setBackBtn(new 18(this));
        setMMTitle(R.l.edS);
        showOptionMenu(true);
        aFl();
        com.tencent.mm.sdk.b.b qoVar = new qo();
        qoVar.fIh.action = 2;
        com.tencent.mm.sdk.b.a.xef.a(qoVar, Looper.getMainLooper());
    }

    private void aFk() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.lXh = new j(this.lWW, this.lWV, this.lWY, this.lXd, this.lXi);
        this.lXh.lPw = this;
        ar.CG().a(this.lXh, 0);
    }

    private void aFl() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[]{this.lXf, this.jKk});
        if (!bh.ov(this.lXf)) {
            int i;
            String str = this.lXf;
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[]{str, this.jKk});
            if (bh.ov(str)) {
                i = -1;
            } else if (this.lXa == null || this.lXa.size() == 0) {
                i = -2;
            } else {
                i = 0;
                while (i < this.lXa.size()) {
                    d dVar = ((e) this.lXa.get(i)).lZj;
                    int i2 = ((e) this.lXa.get(i)).lZk;
                    if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.jKk) && (i2 & 2) != 2) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels)});
                        this.lWN.setSelectionFromTop(i, i2 / 4);
                        this.lWO.lWl = str;
                        this.lWO.notifyDataSetInvalidated();
                        aFo();
                        break;
                    }
                    i++;
                }
                this.lWO.lWl = null;
                i = -3;
            }
            if (i >= 0) {
                return;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
    }

    private void aFe() {
        if (this.lWX == null || this.jKk == null || !this.jKk.equals(this.lWX.field_username) || !bh.ov(this.lWX.field_championUrl)) {
            if (this.lVF != null) {
                this.lVF.setVisibility(8);
            }
            if (this.lWX != null && !bh.az(this.lWX.field_username, "").equals(this.jKk) && !bh.ov(this.lWX.field_championUrl)) {
                this.lWQ.lXn = new 22(this);
                return;
            }
            return;
        }
        if (this.lVF != null) {
            this.lVF.setVisibility(0);
        }
        if (this.lWQ != null) {
            this.lWQ.lXn = new 21(this);
        }
    }

    private void aFm() {
        String aFn = aFn();
        if (!bh.ov(aFn)) {
            this.lWY = aFn;
        }
    }

    private String aFn() {
        if (this.lXa != null) {
            for (e eVar : this.lXa) {
                d dVar = eVar.lZj;
                if (dVar != null && dVar.field_ranknum == 1) {
                    return dVar.field_username;
                }
            }
        }
        return null;
    }

    protected final void initView() {
        int dimensionPixelSize;
        int size;
        boolean z;
        this.lWP = findViewById(R.h.cAF);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.buO));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.buF);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.buG);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(R.f.buN);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.lWQ = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.cEi);
        this.lWN = (ListView) findViewById(R.h.cft);
        this.lWR = (ExdeviceRankChampionInfoView) findViewById(R.h.bSz);
        this.lVF = findViewById(R.h.cLE);
        this.lVF.setOnClickListener(new 23(this));
        this.lWQ.lXr = false;
        aFe();
        mMPullDownView.mn(false);
        mMPullDownView.mp(false);
        mMPullDownView.mo(false);
        mMPullDownView.mn(false);
        mMPullDownView.mm(false);
        mMPullDownView.ycJ = true;
        mMPullDownView.ycM = new 24(this);
        mMPullDownView.ycB = new 2(this);
        mMPullDownView.ycU = new 3(this);
        mMPullDownView.ycC = new 4(this);
        this.lWN.setOnScrollListener(new 5(this));
        this.lWN.addHeaderView(this.lWQ, null, false);
        View inflate = getLayoutInflater().inflate(R.i.dhd, null);
        this.lWS = inflate.findViewById(R.h.cpZ);
        inflate.findViewById(R.h.cpY).setOnClickListener(new 6(this));
        this.lWS.setVisibility(8);
        this.lWN.addFooterView(inflate);
        if (this.lXb != null) {
            dimensionPixelSize = this.lXb.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.lXc != null) {
            size = this.lXc.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.lXa = new ArrayList();
            this.lWO.lWj = this.lXa;
            getString(R.l.dGO);
            this.lTm = h.a(this, getString(R.l.ctB), true, new 7(this));
        }
        this.lWN.setAdapter(this.lWO);
        this.lWO.lWm = this;
        if (this.lWZ == 1) {
            this.lWN.setVisibility(0);
            this.lWP.setVisibility(8);
            z = true;
        } else {
            this.lWN.setVisibility(8);
            this.lWP.setVisibility(0);
            z = false;
        }
        if (z) {
            this.lVz = (ImageView) findViewById(R.h.ceW);
            mMPullDownView.ycJ = false;
            dimensionPixelSize = com.tencent.mm.bv.a.eA(this);
            i = ((Integer) this.lWQ.getTag()).intValue();
            if (this.lPt) {
                i += (getResources().getDimensionPixelSize(R.f.buQ) / 2) + getResources().getDimensionPixelSize(R.f.buP);
            }
            this.lVz.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            aFp();
            eL(false);
            return;
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
    }

    private void aFo() {
        View childAt = this.lWN.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.lWN.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (bh.ov(this.lXf) && lVR == FileUtils.S_IWUSR) {
                    lVR = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= lVR) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) lVR);
                    }
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[]{Float.valueOf(f)});
                    this.lWR.setAlpha(f);
                    this.lWR.setVisibility(0);
                    this.lVF.setAlpha(f);
                    return;
                }
            }
            this.lWR.setAlpha(0.0f);
            this.lVF.setAlpha(0.0f);
            this.lWR.setVisibility(8);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onRestart() {
        super.onRestart();
        eK(true);
    }

    protected void onDestroy() {
        this.GO = true;
        if (this.lWO != null) {
            b.finish();
        }
        super.onDestroy();
        if (this.lXh != null) {
            this.lXh.lPw = null;
        }
        ad.aEt().b(this);
        ad.aEs().lPD = null;
        ad.aEs().lPE = null;
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dhf;
    }

    private void aFp() {
        if (this.lWX == null) {
            this.lVz.setImageResource(R.e.brW);
            this.jsF = null;
        } else if (this.jsF == this.lWX.field_championUrl) {
        } else {
            if (this.jsF == null || !this.jsF.equals(this.lWX.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.lVz, this.lWX.field_championUrl, R.e.brW);
                this.jsF = this.lWX.field_championUrl;
            }
        }
    }

    private void eL(boolean z) {
        if (z) {
            aFm();
        }
        if (bh.ov(this.lWV)) {
            this.lWR.setVisibility(8);
            return;
        }
        this.lWR.zq(this.lWY);
        this.lWR.setVisibility(0);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        boolean z = (dVar == null || bh.ov(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.lWW != null && this.lWW.equals(dVar.lPj)) {
                x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[]{this.lWW});
                eK(true);
                if (bh.ov(this.lWY) || !this.lWY.equals(aFn())) {
                    aFm();
                    this.lWX = ad.aEo().zc(this.lWY);
                    runOnUiThread(new 8(this));
                }
                runOnUiThread(new 9(this));
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !bh.ov(this.lWY) && this.lWY.equals(dVar.username)) {
            this.lWX = ad.aEo().zc(this.lWY);
            runOnUiThread(new 10(this));
        }
    }

    public final void yZ(String str) {
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[]{str});
        this.lWW = str;
    }

    public final void zs(String str) {
        com.tencent.mm.plugin.sport.b.d.pY(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.lWk.get(str));
        intent.putExtra("app_username", this.lWV);
        intent.putExtra("rank_id", this.lWW);
        startActivityForResult(intent, 4);
    }

    public final void aFq() {
        com.tencent.mm.plugin.sport.b.d.pY(31);
        aFr();
    }

    public final void bh(String str, int i) {
        ad.aEs();
        String str2 = this.lWW;
        String str3 = this.lWV;
        com.tencent.mm.plugin.exdevice.f.b.b.d aEl = ad.aEl();
        boolean z = (bh.ov(str2) || bh.ov(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        d a = aEl.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            x.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    x.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            aEl.a(a, true);
        }
        com.tencent.mm.plugin.exdevice.f.b.c.b(str2, str3, str, i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.lWV) && i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        return;
                    }
                    ac.a((Context) this, stringExtra, ac.cw(this), intent.getStringExtra("custom_send_text"), this.lVI);
                    h.bu(this.mController.xIM, getResources().getString(R.l.dGG));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    return;
                case 2:
                    h.bu(this.mController.xIM, getResources().getString(R.l.dGG));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    return;
                case 3:
                    if (intent != null) {
                        List<String> F = bh.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : F) {
                            com.tencent.mm.plugin.messenger.a.f.aZh().k("gh_43f2581f6fd6", stringExtra3, s.eV(stringExtra3));
                            if (!bh.ov(stringExtra2)) {
                                com.tencent.mm.sdk.b.b orVar = new or();
                                orVar.fGI.fGJ = stringExtra3;
                                orVar.fGI.content = stringExtra2;
                                orVar.fGI.type = s.hp(stringExtra3);
                                orVar.fGI.flags = 0;
                                com.tencent.mm.sdk.b.a.xef.m(orVar);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        aFk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean zt(String str) {
        if (bh.ov(this.lWW) || "#".equals(this.lWW)) {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.l.edF), 0).show();
            return true;
        } else if (!q.FS().equals(str)) {
            return false;
        } else {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.lWV);
            intent.putExtra("rank_id", this.lWW);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            return true;
        }
    }

    private void aFr() {
        if (bh.ov(this.lPu)) {
            a zc = ad.aEo().zc(this.jKk);
            if (zc != null) {
                this.lPu = zc.field_championUrl;
            }
        }
        d f = b.f(this.jKk, this.lXc);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a((Context) this, str, str2, this.lPu, new 11(this));
    }

    public final void a(j jVar) {
        runOnUiThread(new 14(this));
        this.lVH = jVar.lOX;
        this.lVI = jVar.lOY;
        this.lPu = jVar.lPu;
        this.lPt = jVar.lPt;
        this.lPh = jVar.lPh;
        this.lXc = jVar.lPm;
        this.lXb = jVar.lPn;
        this.lXa = this.lWO.b(this.lXb, this.lXc, this.lPt);
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceRankInfoUI lXj;

            {
                this.lXj = r1;
            }

            public final void run() {
                this.lXj.lWO.lWj = this.lXj.lXa;
                this.lXj.lWO.notifyDataSetChanged();
                this.lXj.lWS.setVisibility(0);
            }
        });
    }
}
