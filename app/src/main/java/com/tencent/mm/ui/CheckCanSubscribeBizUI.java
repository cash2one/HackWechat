package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.b.af;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.mr;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements e, a, b {
    private String appId;
    private int cOY;
    private String extInfo;
    private int fromScene;
    private String ftj;
    private boolean hik = false;
    private String mOi;
    private int scene;
    private String toUserName;
    private int xDT;
    private LinkedList<bdo> xDU;
    private boolean xDV = false;
    private boolean xDW = false;
    private boolean xDX = false;
    private boolean xDY = false;
    private String xDZ;
    private int xEa = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!ar.Hi() || ar.Cs()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        ar.CG().a(605, this);
        ar.Hg();
        c.EY().a(this);
        y.Mf().c(this);
        if (adl()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.xDT;
            LinkedList linkedList = this.xDU;
            String str4 = this.ftj;
            int i2 = this.cOY;
            int i3 = this.scene;
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new mr();
            aVar.hmk = new ms();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.hmi = 605;
            com.tencent.mm.ae.b JZ = aVar.JZ();
            mr mrVar = (mr) JZ.hmg.hmo;
            mrVar.nfn = str;
            mrVar.nko = str2;
            mrVar.nkB = str3;
            mrVar.vVp = i;
            mrVar.vVq = linkedList;
            mrVar.vVr = null;
            mrVar.vVs = str4;
            mrVar.vHW = i2;
            mrVar.rYW = i3;
            x.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3)});
            u.a(JZ, new 2(this));
            return;
        }
        setResult(2);
        clR();
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.xDU != null) {
            this.xDU.clear();
        }
        if (ar.Hj()) {
            ar.CG().b(605, this);
            y.Mf().j(this);
            ar.Hg();
            c.EY().b(this);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dmv;
    }

    private boolean adl() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (bh.ov(this.toUserName)) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            return false;
        }
        this.extInfo = intent.getStringExtra("extInfo");
        this.cOY = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.xEa = intent.getIntExtra("jump_profile_type", 0);
        switch (this.cOY) {
            case 1:
                if (!bh.ov(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.xDU = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!bh.ov(str)) {
                                x.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", new Object[]{Integer.valueOf(i), str});
                                this.xDU.add(n.os(str));
                            }
                        }
                        if (this.xDU.size() != 0) {
                            this.xDT = this.xDU.size();
                            break;
                        }
                        x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        return false;
                    }
                    x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    return false;
                }
                x.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                x.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", new Object[]{Integer.valueOf(this.cOY)});
                return false;
        }
        this.ftj = intent.getStringExtra("fromURL");
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (kVar.getType() == 605) {
            return;
        }
        if (kVar.getType() == 233) {
            ar.CG().b(233, this);
            if (i == 0 && i2 == 0) {
                l lVar = (l) kVar;
                int RG = lVar.RG();
                x.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", new Object[]{Integer.valueOf(RG)});
                if (RG == 15) {
                    x.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", new Object[]{Integer.valueOf(RG), lVar.RE()});
                    com.tencent.mm.sdk.b.b gwVar = new gw();
                    gwVar.fxb.actionCode = RG;
                    gwVar.fxb.result = r1;
                    gwVar.fxb.context = this;
                    com.tencent.mm.sdk.b.a.xef.a(gwVar, Looper.myLooper());
                    finish();
                    return;
                }
                clQ();
                return;
            }
            clQ();
            return;
        }
        x.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", new Object[]{Integer.valueOf(kVar.getType())});
    }

    private synchronized void clO() {
        x.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.xDV);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.xDZ);
            d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
        } else if (this.scene == 0 && this.xEa == 1) {
            if (this.xDX) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
            } else {
                this.xDX = true;
                ar.CG().a(233, this);
                ar.CG().a(new l(this.extInfo, null, 4, (int) System.currentTimeMillis(), new byte[0]), 0);
            }
        } else if (clP() && this.xDV) {
            if (!this.xDX) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (bh.ov(this.toUserName)) {
                    com.tencent.mm.ui.contact.e.a(intent, this.toUserName);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.xDW) {
                    setResult(-1);
                    this.xDX = true;
                    startActivity(intent);
                    finish();
                }
            }
        } else if (this.xDV && !this.xDX) {
            x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
            ar.Hg();
            af WO = c.EY().WO(this.toUserName);
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_Scene", this.fromScene);
            intent2.putExtra("Verify_ticket", this.mOi);
            if (WO != null) {
                intent2.putExtra("Contact_Alias", WO.vN());
                intent2.putExtra("Contact_Nick", WO.field_nickname);
                intent2.putExtra("Contact_Signature", WO.signature);
                intent2.putExtra("Contact_RegionCode", WO.fWv);
                intent2.putExtra("Contact_Sex", WO.fWf);
                intent2.putExtra("Contact_VUser_Info", WO.fWu);
                intent2.putExtra("Contact_VUser_Info_Flag", WO.field_verifyFlag);
                intent2.putExtra("Contact_KWeibo_flag", WO.field_weiboFlag);
                intent2.putExtra("Contact_KWeibo", WO.fWt);
                intent2.putExtra("Contact_KWeiboNick", WO.field_weiboNickname);
            }
            com.tencent.mm.ui.contact.e.l(intent2, this.toUserName);
            if (!this.xDW) {
                setResult(-1);
                this.xDX = true;
                d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                finish();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean clP() {
        boolean z = false;
        synchronized (this) {
            boolean z2;
            ar.Hg();
            af WO = c.EY().WO(this.toUserName);
            if (WO == null || ((int) WO.gJd) == 0) {
                x.w("MicroMsg.CheckCanSubscribeBizUI", "contact is null.");
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.ag.d dVar = null;
            if (!z2) {
                dVar = f.jS(this.toUserName);
            }
            if (dVar == null || dVar.KY()) {
                x.e("MicroMsg.CheckCanSubscribeBizUI", "BizInfo(" + dVar + ") is null or should update.");
                z2 = true;
            }
            if (this.xDY) {
                if (WO == null) {
                    this.xDV = false;
                    setResult(5);
                    clR();
                    finish();
                } else {
                    this.xDV = true;
                    this.hik = true;
                }
            } else if (!z2) {
                if (!com.tencent.mm.l.a.fZ(WO.field_type)) {
                    x.w("MicroMsg.CheckCanSubscribeBizUI", "is not contact.");
                    this.xDV = true;
                }
                this.xDV = true;
                this.hik = true;
                z = true;
            } else if (this.xDV) {
                setResult(5);
                clR();
                finish();
            } else {
                ak.a.hfL.a(this.toUserName, "", new 1(this));
            }
        }
        return z;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.xDW = true;
            if (this.xDX) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void clQ() {
        Toast.makeText(this, getString(R.l.eSH), 1).show();
        aEW();
    }

    private void clR() {
        Toast.makeText(this, R.l.eEd, 1).show();
        aEW();
    }

    private void aEW() {
        if (this.cOY == 1) {
            LauncherUI.fr(this);
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        new com.tencent.mm.sdk.platformtools.af().post(new 3(this, str));
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }
}
