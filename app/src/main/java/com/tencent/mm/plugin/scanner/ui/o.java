package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class o extends i implements e, a {
    private int pSO;
    int pXE = 0;
    int pXF = 2;
    private long pXG;
    private final int pXH = 184;
    private final int pXI = 46;
    private final int pXJ = JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX;
    private final int pXK = 70;
    private float pXP;
    private final int pXS = 50;
    com.tencent.mm.plugin.scanner.a.e pXX;
    private int pXY = 0;
    private TextView pXZ;
    private TextView pYa;
    private final int pYb = 5000;
    private final int pYc = 8000;
    private af pYd = new 1(this);

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        dl(184, 46);
        this.pXP = p.dp(JsApiCheckIsSupportSoterAuthentication.CTRL_INDEX, this.pXl);
        x.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", Integer.valueOf(this.pXl), Integer.valueOf(this.pXm), Float.valueOf(this.pXP));
        this.pSO = (int) (System.currentTimeMillis() & -1);
    }

    protected final void h(Rect rect) {
        this.jCQ = (TextView) this.pXp.findViewById(R.h.cIZ);
        this.pYa = (TextView) this.pXp.findViewById(R.h.cBy);
        this.pXZ = (TextView) this.pXp.findViewById(R.h.cBz);
        this.jCQ = (TextView) this.pXp.findViewById(R.h.cIZ);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jCQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.pXp.getContext(), 13.0f);
            this.jCQ.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.pXZ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.pXp.getContext(), 13.0f);
            this.pXZ.setLayoutParams(layoutParams);
            this.pXZ.setVisibility(4);
        }
        if (d.yl()) {
            this.jCQ.setPadding(BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingTop(), BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingBottom());
            this.pXZ.setPadding(BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.pXZ.getPaddingTop(), BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.pXZ.getPaddingBottom());
        }
        if (this.pXj != null) {
            ((j) this.pXj).otW = this.pXp.bpa();
        }
        bpo();
        hI(true);
    }

    protected final void boP() {
        h(new Rect(0, 0, 0, 0));
        this.pXp.b(4, null);
        this.pXp.eh(0);
        onResume();
    }

    protected final int boN() {
        return R.i.drf;
    }

    protected final com.tencent.mm.plugin.scanner.util.b boM() {
        if (this.pXj == null) {
            int i = 50;
            if (q.gFU.gEj > 0) {
                i = q.gFU.gEj;
                x.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", Integer.valueOf(q.gFU.gEj));
            }
            if (an.is2G(this.pXp.getContext())) {
                this.pXj = new j(this, i - 10, this.pXP, true, this.pXp.bpa());
            } else {
                this.pXj = new j(this, i, this.pXP, true, this.pXp.bpa());
            }
        }
        return this.pXj;
    }

    protected final void boL() {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bpo();
        }
    }

    private void bpo() {
        if (this.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
        } else if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
            this.pXp.eh(0);
        } else {
            this.pXZ.setText("");
            this.pYa.setText("");
            this.pXp.hG(true);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr == null);
            x.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.pXG <= 1840 || !((j) this.pXj).qaO) {
                this.pXp.eg(40);
            } else {
                this.pXG = System.currentTimeMillis();
                this.pXp.eh(0);
            }
            this.pXY = 0;
        } else if (this.pXE >= this.pXF) {
            if (System.currentTimeMillis() - this.pXG <= 1840 || !((j) this.pXj).qaO) {
                this.pXp.eg(40);
            } else {
                this.pXG = System.currentTimeMillis();
                this.pXp.eh(0);
            }
            x.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", Integer.valueOf(this.pXE), Integer.valueOf(this.pXF));
        } else {
            this.pXX = new com.tencent.mm.plugin.scanner.a.e(bArr, "en", "zh_CN", this.pSO);
            ar.CG().a(this.pXX, 0);
            this.pXE++;
            this.pYd.removeMessages(0);
            if (an.is2G(this.pXp.getContext())) {
                this.pYd.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.pYd.sendEmptyMessageDelayed(0, 5000);
            }
            this.pXq += bArr.length;
            x.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", Integer.valueOf(this.pXq), Integer.valueOf(this.pXY), Integer.valueOf(this.pXF));
            if (System.currentTimeMillis() - this.pXG <= 1840 || !((j) this.pXj).qaO) {
                this.pXp.eg(40);
            } else {
                this.pXG = System.currentTimeMillis();
                this.pXp.eh(0);
            }
            x.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.pXE + "," + this.pXY);
        }
    }

    public final void boH() {
        x.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (System.currentTimeMillis() - this.pXG <= 1840 || !((j) this.pXj).qaO) {
            this.pXp.eg(40);
        } else {
            this.pXG = System.currentTimeMillis();
            this.pXp.eh(0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.pYd.removeMessages(0);
        switch (kVar.getType()) {
            case 392:
                this.pXE--;
                if (i == 0 && i2 == 0) {
                    atn com_tencent_mm_protocal_c_atn;
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                    com.tencent.mm.plugin.scanner.a.e eVar = (com.tencent.mm.plugin.scanner.a.e) kVar;
                    if (eVar.gJQ == null || eVar.gJQ.hmh.hmo == null) {
                        com_tencent_mm_protocal_c_atn = null;
                    } else {
                        com_tencent_mm_protocal_c_atn = (atn) eVar.gJQ.hmh.hmo;
                    }
                    if (com_tencent_mm_protocal_c_atn == null) {
                        x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                        dT(null, null);
                        return;
                    }
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", Integer.valueOf(com_tencent_mm_protocal_c_atn.vNT), Integer.valueOf(com_tencent_mm_protocal_c_atn.vNX), com_tencent_mm_protocal_c_atn.wBD, com_tencent_mm_protocal_c_atn.wBE);
                    if (!bh.ov(com_tencent_mm_protocal_c_atn.wBE)) {
                        dT(com_tencent_mm_protocal_c_atn.wBD, com_tencent_mm_protocal_c_atn.wBE);
                        if (this.pXX != null) {
                            ar.CG().c(this.pXX);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                this.pXG -= 300;
                dT(null, null);
                return;
            default:
                return;
        }
    }

    private void dT(String str, String str2) {
        if (bh.ov(str)) {
            this.pXZ.setText("");
        } else {
            this.jCQ.setVisibility(8);
            this.pXZ.setText(str);
            this.pXZ.setVisibility(0);
        }
        if (bh.ov(str2)) {
            this.pYa.setText("");
            return;
        }
        this.jCQ.setVisibility(8);
        this.pYa.setText(str2);
        this.pYa.setVisibility(0);
    }

    protected final void onResume() {
        ar.CG().a(392, (e) this);
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bpo();
        }
    }

    protected final void onPause() {
        hI(false);
        ar.CG().b(392, (e) this);
    }

    protected final int boO() {
        return 0;
    }

    protected final void onDestroy() {
    }

    protected final boolean boQ() {
        return true;
    }

    protected final boolean boR() {
        return true;
    }

    public final void D(Bundle bundle) {
    }
}
