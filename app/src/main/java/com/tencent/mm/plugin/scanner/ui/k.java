package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.a.g;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class k extends i implements e, a {
    private static int pXB = 300;
    private int pSO;
    private TextView pUs;
    private View pUt;
    private long pXC = 130;
    g pXD;
    private int pXE = 0;
    private int pXF = 1;
    private long pXG;
    private final int pXH = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int pXI = 300;
    private final int pXJ = 390;
    private final int pXK = 450;
    private final int pXL = 220;
    private final int pXM = 240;
    private final int pXN = 330;
    private final int pXO = 360;
    private float pXP;
    private final long pXQ = 30000;
    private long pXR;
    private final int pXS = 50;
    private com.tencent.mm.plugin.scanner.util.e.a pXT = new com.tencent.mm.plugin.scanner.util.e.a(this) {
        final /* synthetic */ k pXV;

        {
            this.pXV = r1;
        }

        public final void m(int i, Bundle bundle) {
            switch (i) {
                case 3:
                    this.pXV.pXp.bpb();
                    return;
                default:
                    return;
            }
        }
    };
    private OnTouchListener pXU;

    public k(b bVar, Point point) {
        super(bVar, point);
        if (d.yl()) {
            dl(220, 240);
            this.pXP = p.dp(330, this.pXl);
        } else {
            dl(GameJsApiLaunchApplication.CTRL_BYTE, 300);
            this.pXP = p.dp(390, this.pXl);
        }
        x.d("MicroMsg.scanner.ScanModeImage", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", Integer.valueOf(this.pXl), Integer.valueOf(this.pXm), Float.valueOf(this.pXP));
        if (bh.eY(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeImage", "memory is not much");
            this.pXC = 300;
        }
        this.pSO = (int) (System.currentTimeMillis() & -1);
        this.pXR = System.currentTimeMillis();
    }

    protected final void h(Rect rect) {
        this.pUt = this.pXp.findViewById(R.h.cIV);
        this.pUs = (TextView) this.pXp.findViewById(R.h.cIW);
        this.jCQ = (TextView) this.pXp.findViewById(R.h.cIZ);
        this.jCQ.setText(p.dV(p.qbh, this.pXp.getContext().getString(R.l.eHH)));
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jCQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.pXp.getContext(), 13.0f);
            this.jCQ.setLayoutParams(layoutParams);
        }
        if (d.yl()) {
            this.jCQ.setPadding(BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingTop(), BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingBottom());
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
        onResume();
    }

    protected final int boN() {
        return R.i.drd;
    }

    protected final com.tencent.mm.plugin.scanner.util.b boM() {
        if (this.pXj == null) {
            int i = 50;
            if (q.gFU.gEj > 0) {
                i = q.gFU.gEj;
                x.d("MicroMsg.scanner.ScanModeImage", "ImageQuality=[%s]", Integer.valueOf(q.gFU.gEj));
            }
            if (an.is2G(this.pXp.getContext())) {
                this.pXj = new j(this, i - 10, this.pXP, false, this.pXp.bpa());
            } else {
                this.pXj = new j(this, i, this.pXP, false, this.pXp.bpa());
            }
        }
        return this.pXj;
    }

    protected final void boL() {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else {
            bpo();
        }
    }

    private void bpo() {
        if (this.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeImage", "dealWithNetWork(), scanUICallback == null");
        } else if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
            this.pXp.eh(0);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
        } else if (bArr == null || bArr.length <= 0) {
            x.w("MicroMsg.scanner.ScanModeImage", "greyData null");
            if (System.currentTimeMillis() - this.pXG <= this.pXC + 1800 || !((j) this.pXj).qaO) {
                this.pXp.eg(this.pXC);
                return;
            }
            this.pXG = System.currentTimeMillis();
            this.pXp.eh(0);
        } else {
            bpp();
            if (this.pXE >= this.pXF) {
                x.i("MicroMsg.scanner.ScanModeImage", "too quick to send image, return now");
                this.pXp.eg(this.pXC);
                if (System.currentTimeMillis() - this.pXG <= this.pXC + 1800 || !((j) this.pXj).qaO) {
                    this.pXp.eg(this.pXC);
                    return;
                }
                this.pXG = System.currentTimeMillis();
                this.pXp.eh(0);
                return;
            }
            this.pXD = new g(bArr, bArr.length, this.pSO);
            ar.CG().a(this.pXD, 0);
            this.pXE++;
            this.pXq += bArr.length;
            x.d("MicroMsg.scanner.ScanModeImage", "totalNetworkFlow : [%s]", Integer.valueOf(this.pXq));
            if (System.currentTimeMillis() - this.pXG <= this.pXC + 1800 || !((j) this.pXj).qaO) {
                this.pXp.eg(this.pXC);
                return;
            }
            this.pXG = System.currentTimeMillis();
            this.pXp.eh(0);
        }
    }

    public final void boH() {
        x.d("MicroMsg.scanner.ScanModeImage", "decodeFail");
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        bpp();
        if (System.currentTimeMillis() - this.pXG <= 1800 + this.pXC || !((j) this.pXj).qaO) {
            this.pXp.eg(this.pXC);
            return;
        }
        this.pXG = System.currentTimeMillis();
        this.pXp.eh(0);
    }

    private void bpp() {
        ag.y(new 2(this));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        this.pXE = 0;
        if (this.pXp == null || kVar == null) {
            boolean z;
            String str2 = "MicroMsg.scanner.ScanModeImage";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            if (kVar == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
        } else if (kVar.getType() == 1062) {
            if (i == 0 && i2 == 0) {
                this.pXE = this.pXF;
                g gVar = (g) kVar;
                hz hzVar = (gVar.gJQ == null || gVar.gJQ.hmh.hmo == null) ? null : (hz) gVar.gJQ.hmh.hmo;
                if (hzVar != null) {
                    x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() clientScanID = %s, imageType = %s", Integer.valueOf(hzVar.vNT), Integer.valueOf(hzVar.vNX));
                    switch (n.a(hzVar.ktN, hzVar.vNZ, this, 3, this.pXT, 0, 0, false)) {
                        case 0:
                            this.pXp.boU();
                            if (!(this.pXp == null || this.pXp.getContext() == null)) {
                                this.pXp.bpb();
                                break;
                            }
                        case 1:
                            x.d("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                            break;
                        case 2:
                            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                            break;
                        default:
                            break;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd(), getResp() == null");
                return;
            }
            x.e("MicroMsg.scanner.ScanModeImage", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
            this.jCQ.setText(p.dV(p.qbh, this.pXp.getContext().getString(R.l.eHH)));
            if (this.pXD != null) {
                ar.CG().c(this.pXD);
            }
        }
    }

    protected final void onResume() {
        ar.CG().a(1062, (e) this);
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeImage", "scanUICallback == null");
            return;
        }
        this.pXE = 0;
        bpo();
    }

    protected final void onPause() {
        super.onPause();
        hI(false);
        ar.CG().b(1062, (e) this);
    }

    protected final int boO() {
        return pXB;
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
