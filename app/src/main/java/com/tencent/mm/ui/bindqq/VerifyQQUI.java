package com.tencent.mm.ui.bindqq;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public class VerifyQQUI extends MMWizardActivity implements e {
    private String fxT;
    private String fxV;
    private byte[] hkS = null;
    private String sPj = "";
    private r tipDialog = null;
    private SecurityImage xKa = null;
    private long ymS = 0;
    private String ymT = "";
    private String ymU;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, this);
    }

    public void onDestroy() {
        super.onDestroy();
        ar.CG().b(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, this);
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbm;
    }

    public final boolean akK() {
        aWs();
        finish();
        return true;
    }

    protected final void initView() {
        b hoVar = new ho();
        hoVar.fxR.context = this;
        a.xef.m(hoVar);
        this.fxT = hoVar.fxS.fxT;
        hoVar = new hp();
        a.xef.m(hoVar);
        this.fxV = hoVar.fxU.fxV;
        setMMTitle(R.l.dMc);
        setBackBtn(new 1(this));
        addTextOptionMenu(0, getString(R.l.dFl), new 2(this, (EditText) findViewById(R.h.bNG), (EditText) findViewById(R.h.bNF)));
    }

    public final void a(int i, int i2, String str, k kVar) {
        byte[] a;
        x.i("MicroMsg.VerifyQQUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.af.a aVar = (com.tencent.mm.af.a) kVar;
        byte[] aP = ar.Cq().aP(aVar.hnZ);
        x.i("MicroMsg.NetSceneBindQQ", "getRespImgBuf getWtloginMgr getVerifyImg:%d  uin:%d", new Object[]{Integer.valueOf(bh.i(aP, new byte[0]).length), Long.valueOf(aVar.hnZ)});
        if (bh.bw(aP)) {
            a = n.a(((ha) aVar.gJQ.hmh.hmo).vHb);
        } else {
            a = aP;
        }
        this.hkS = a;
        this.ymT = ((ha) ((com.tencent.mm.af.a) kVar).gJQ.hmh.hmo).vMC;
        if (this.hkS != null) {
            x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ymT + " img len" + this.hkS.length + " " + g.zh());
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.c.a.ift.um();
            h.a(this.mController.xIM, R.l.dLZ, R.l.dMa, new 3(this));
            return;
        }
        Object obj;
        if (i == 4) {
            com.tencent.mm.h.a eA;
            switch (i2) {
                case -311:
                case -310:
                case -6:
                    x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ymT + " img len" + this.hkS.length + " " + g.zh());
                    if (!ar.Hj()) {
                        obj = 1;
                        break;
                    }
                    if (this.xKa == null) {
                        this.xKa = SecurityImage.a.a(this.mController.xIM, R.l.eEi, 0, this.hkS, this.ymT, this.ymU, new 4(this), null, new 5(this), new a(this));
                    } else {
                        x.d("MicroMsg.VerifyQQUI", "imgSid:" + this.ymT + " img len" + this.hkS.length + " " + g.zh());
                        this.xKa.a(0, this.hkS, this.ymT, this.ymU);
                    }
                    obj = 1;
                    break;
                case -72:
                    h.h(this.mController.xIM, R.l.dLV, R.l.dGO);
                    obj = 1;
                    break;
                case -34:
                    h.h(this.mController.xIM, R.l.dLU, R.l.dGO);
                    obj = 1;
                    break;
                case -12:
                    h.h(this.mController.xIM, R.l.dLS, R.l.dLW);
                    obj = 1;
                    break;
                case -5:
                    h.h(this.mController.xIM, R.l.dLT, R.l.dGO);
                    obj = 1;
                    break;
                case -4:
                case -3:
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA == null) {
                        h.h(this.mController.xIM, R.l.dMb, R.l.dLW);
                        obj = 1;
                        break;
                    }
                    eA.a(this, null, null);
                    obj = 1;
                    break;
                default:
                    eA = com.tencent.mm.h.a.eA(str);
                    if (eA != null) {
                        eA.a(this, null, null);
                        obj = 1;
                        break;
                    }
                    break;
            }
        }
        obj = null;
        if (obj == null) {
            Toast.makeText(this, getString(R.l.eio, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
