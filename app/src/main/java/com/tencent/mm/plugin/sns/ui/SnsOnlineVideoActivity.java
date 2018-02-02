package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.VelocityTracker;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pt;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.g.a.rt;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.z.s;
import com.tencent.wcdb.FileUtils;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity {
    private aqr fHC;
    private VelocityTracker ft;
    private String fus;
    private String fvC;
    private String hDC;
    private GestureDetector jtw;
    private Bundle kRZ;
    private boolean kSa = false;
    private g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private boolean kTc;
    private boolean mxb = true;
    private RelativeLayout mxu;
    private ImageView mxv;
    d onK = new d(this) {
        final /* synthetic */ SnsOnlineVideoActivity rEF;

        {
            this.rEF = r1;
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            boolean z = false;
            Intent intent;
            b qmVar;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    m Lm = ae.bvv().Lm(this.rEF.fus);
                    if (Lm != null) {
                        x.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + Lm.bxW());
                    }
                    intent.putExtra("k_expose_msg_id", Lm == null ? Integer.valueOf(0) : Lm.bxW());
                    intent.putExtra("k_username", Lm == null ? "" : Lm.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bm.d.b(this.rEF, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    b qmVar2 = new qm();
                    qmVar2.fHY.fuL = 2;
                    qmVar2.fHY.fHZ = 17;
                    qm.a aVar = qmVar2.fHY;
                    if (this.rEF.scene == 0) {
                        z = true;
                    }
                    aVar.fIa = z;
                    qmVar2.fHY.fus = this.rEF.fus;
                    com.tencent.mm.sdk.b.a.xef.m(qmVar2);
                    return;
                case 3:
                    this.rEF.rEx = true;
                    qmVar = new qm();
                    qmVar.fHY.fuL = 1;
                    qmVar.fHY.fIb = 4097;
                    qmVar.fHY.fus = this.rEF.fus;
                    com.tencent.mm.sdk.b.a.xef.m(qmVar);
                    return;
                case 4:
                    m Lm2 = ae.bvv().Lm(this.rEF.fus);
                    if (Lm2 != null) {
                        intent = new Intent();
                        if (Lm2.bxV().wQo.vYc == 15 && ((aqr) Lm2.bxV().wQo.vYd.get(0)) == null) {
                            x.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                            return;
                        }
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", this.rEF.fus);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bm.d.a(this.rEF, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    }
                    return;
                case 5:
                    qmVar = new qm();
                    qmVar.fHY.fuL = 3;
                    qmVar.fHY.fus = this.rEF.fus;
                    com.tencent.mm.sdk.b.a.xef.m(qmVar);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean oqs;
    private float rEA = 0.0f;
    private boolean rEB = false;
    private boolean rEC = false;
    private boolean rED = false;
    p$c rEE = new 2(this);
    private OnlineVideoView rEw;
    private boolean rEx = false;
    private boolean rEy;
    private float rEz = 0.0f;
    private com.tencent.mm.ui.widget.g rsB;
    private boolean ruS;
    private Button ryZ;
    private m ryi;
    private float rzi = 1.0f;
    private int rzj = 0;
    private int rzk = 0;
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        OnlineVideoView onlineVideoView;
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        try {
            if (com.tencent.mm.compatible.util.d.fM(19)) {
                getWindow().setFlags(201327616, 201327616);
                this.oqs = true;
            } else {
                getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.oqs = false;
            }
            getWindow().addFlags(FileUtils.S_IWUSR);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e, "", new Object[0]);
        }
        this.kRZ = bundle;
        this.fvC = getIntent().getStringExtra("intent_thumbpath");
        this.fus = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.ruS = getIntent().getBooleanExtra("intent_ispreview", false);
        this.kTc = getIntent().getBooleanExtra("intent_ismute", false);
        x.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[]{this.fvC, this.fus, Integer.valueOf(this.scene), Boolean.valueOf(this.ruS), Boolean.valueOf(this.kTc), getIntent().getStringExtra("intent_videopath")});
        if (this.ruS) {
            this.hDC = r0;
        } else {
            try {
                this.ryi = ae.bvv().Lm(this.fus);
                this.fHC = (aqr) this.ryi.bxV().wQo.vYd.get(0);
                this.hDC = am.r(ae.getAccSnsPath(), this.fHC.nGJ) + i.j(this.fHC);
                x.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[]{this.ryi.byq()});
            } catch (Exception e2) {
                x.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e2.toString());
            }
        }
        this.mxu = (RelativeLayout) findViewById(f.cVB);
        this.rEw = (OnlineVideoView) findViewById(f.cVC);
        if (this.ruS) {
            onlineVideoView = this.rEw;
            String str = this.hDC;
            String str2 = this.fvC;
            onlineVideoView.ruT = str;
            onlineVideoView.ruS = true;
            onlineVideoView.mvy.setImageBitmap(BackwardSupportUtil.b.b(str2, 1.0f));
            x.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.ruS)});
        } else {
            this.rEw.a(this.fHC, this.ryi.byq(), this.ryi.field_createTime);
        }
        onlineVideoView = this.rEw;
        onlineVideoView.kTc = this.kTc;
        onlineVideoView.kTe.setMute(onlineVideoView.kTc);
        this.mxv = (ImageView) findViewById(f.ckv);
        this.mxv.setLayerType(2, null);
        this.mxu.setOnTouchListener(new 1(this));
        this.jtw = new GestureDetector(this.mController.xIM, new 4(this));
        this.rEw.setOnTouchListener(new 5(this));
        this.kSb = new g(this.mController.xIM);
        m mVar = this.ryi;
        if (mVar == null) {
            x.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.ryZ = (Button) findViewById(f.qCi);
            bnp bxV = mVar.bxV();
            at atVar = bxV != null ? bxV.qYu : null;
            ay ayVar = new ay();
            ag.a(this, ayVar, bxV.qYu);
            if (ayVar.rKy) {
                this.ryZ.setVisibility(0);
                this.ryZ.setText(ayVar.rKz);
                this.ryZ.setOnClickListener(new 6(this, atVar, bxV));
                if (getRequestedOrientation() != 0) {
                    bBo();
                }
            } else {
                this.ryZ.setVisibility(8);
            }
        }
        avX();
        b rtVar = new rt();
        rtVar.fJy.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(rtVar);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.qIk;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            bBo();
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.ryZ != null && this.ryZ.getVisibility() == 0) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ryZ.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.qyL)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.qyL);
                    this.ryZ.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void bBo() {
        boolean fy = com.tencent.mm.ui.ae.fy(this);
        int fx = com.tencent.mm.ui.ae.fx(this);
        if (this.oqs && fy && this.ryZ != null && this.ryZ.getVisibility() == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.ryZ.getLayoutParams();
            marginLayoutParams.bottomMargin = fx + marginLayoutParams.bottomMargin;
            this.ryZ.setLayoutParams(marginLayoutParams);
        }
    }

    private void avX() {
        if (this.ruS) {
            x.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
        } else {
            this.rEw.setOnLongClickListener(new 7(this));
        }
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT >= 12) {
                this.kSc = getIntent().getIntExtra("img_gallery_top", 0);
                this.kSd = getIntent().getIntExtra("img_gallery_left", 0);
                this.kSe = getIntent().getIntExtra("img_gallery_width", 0);
                this.kSf = getIntent().getIntExtra("img_gallery_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.rEw.getViewTreeObserver().addOnPreDrawListener(new 10(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!this.mxb) {
            this.rEw.onResume();
        }
        this.mxb = false;
        if (this.rEx) {
            this.rEx = false;
        }
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        this.rEw.onPause();
        if (!this.rEx) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.rEy) {
                new af().postDelayed(new Runnable(this) {
                    final /* synthetic */ SnsOnlineVideoActivity rEF;

                    {
                        this.rEF = r1;
                    }

                    public final void run() {
                        this.rEF.finish();
                    }
                }, 500);
            } else {
                new af().post(new 9(this));
            }
        }
        super.onPause();
    }

    protected void onDestroy() {
        this.rEw.onDestroy();
        try {
            getWindow().clearFlags(FileUtils.S_IWUSR);
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    public final void avV() {
        if (this.ryZ != null && this.ryZ.getVisibility() == 0) {
            this.ryZ.setVisibility(8);
        }
        int width = this.mxu.getWidth();
        int height = this.mxu.getHeight();
        if (!(this.kSe == 0 || this.kSf == 0)) {
            height = (int) ((((float) width) / ((float) this.kSe)) * ((float) this.kSf));
        }
        this.kSb.fg(width, height);
        this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
        if (((double) this.rzi) != 1.0d) {
            this.kSb.zkM = 1.0f / this.rzi;
            if (!(this.rzj == 0 && this.rzk == 0)) {
                this.kSb.fh(((int) (((float) (this.mxu.getWidth() / 2)) * (1.0f - this.rzi))) + this.rzj, (int) (((float) ((this.mxu.getHeight() / 2) + this.rzk)) - (((float) (height / 2)) * this.rzi)));
            }
        }
        this.kSb.a(this.rEw, this.mxv, new 11(this), null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
        avV();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : bh.F(stringExtra.split(","))) {
                if (this.scene == 0) {
                    m Lm = ae.bvv().Lm(this.fus);
                    if (Lm != null) {
                        b psVar;
                        if (s.eV(str)) {
                            psVar = new ps();
                            psVar.fHv.fzW = i.g(Lm);
                            psVar.fHv.frH = Lm.byq();
                            com.tencent.mm.sdk.b.a.xef.m(psVar);
                        } else {
                            psVar = new pt();
                            psVar.fHw.fzW = i.g(Lm);
                            psVar.fHw.frH = Lm.byq();
                            com.tencent.mm.sdk.b.a.xef.m(psVar);
                        }
                    }
                }
                bnp bxV = this.ryi.bxV();
                int JS = i.JS(this.hDC);
                if (bh.ov(this.fvC)) {
                    aqr com_tencent_mm_protocal_c_aqr = this.fHC;
                    if (com_tencent_mm_protocal_c_aqr == null) {
                        stringExtra = "";
                    } else {
                        String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                        stringExtra = r + i.e(com_tencent_mm_protocal_c_aqr);
                        x.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[]{stringExtra, Boolean.valueOf(FileOp.bO(stringExtra))});
                        if (!FileOp.bO(stringExtra)) {
                            stringExtra = r + i.n(com_tencent_mm_protocal_c_aqr);
                            x.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[]{stringExtra});
                        }
                    }
                } else {
                    stringExtra = this.fvC;
                }
                this.fvC = stringExtra;
                x.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str, this.hDC, this.fvC, this.fHC.wxL, Integer.valueOf(this.fHC.rNe), Integer.valueOf(JS)});
                com.tencent.mm.plugin.messenger.a.f.aZh().a(this, str, this.hDC, this.fvC, 43, JS, bxV.rtA);
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.messenger.a.f.aZh().dj(stringExtra2, str);
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(j.epb));
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getForceOrientation() {
        return 2;
    }
}
