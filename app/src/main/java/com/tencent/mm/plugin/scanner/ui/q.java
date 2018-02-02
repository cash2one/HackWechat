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
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.beb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import java.util.Map;

@g(ceR = {BaseScanUI.class})
public final class q extends i implements e, a {
    private static int pXB = 300;
    private float gyA;
    private com.tencent.mm.modelgeo.a.a gyF = new 1(this);
    private float gyz;
    private c hpO;
    private boolean hpR = false;
    private TextView pUs;
    private final int pXH = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int pXI = 300;
    private final int pXL = 220;
    private final int pXM = 240;
    private String pYA;
    private boolean pYB = false;
    private float pYC = -10000.0f;
    private boolean pYD = false;
    private boolean pYE = false;
    private boolean pYF = false;
    private a pYG;
    protected af pYH = new 2(this);
    private int pYx;
    private int pYy;
    private String pYz;
    private float pitch = -10000.0f;

    static /* synthetic */ void b(q qVar) {
        if (!qVar.pYB || qVar.pYD || qVar.pYF) {
            x.i("MicroMsg.scanner.ScanModeStreetView", "!hasGetLbsInfo || hasPause || hasDoScene,abort");
            return;
        }
        qVar.pYF = true;
        axl com_tencent_mm_protocal_c_axl = new axl();
        com_tencent_mm_protocal_c_axl.wct = qVar.pYA;
        com_tencent_mm_protocal_c_axl.wcu = qVar.pYx;
        com_tencent_mm_protocal_c_axl.vQu = qVar.gyz;
        com_tencent_mm_protocal_c_axl.vQt = qVar.gyA;
        com_tencent_mm_protocal_c_axl.wcs = qVar.pYz;
        com_tencent_mm_protocal_c_axl.wcr = qVar.pYy;
        if (ar.Hj()) {
            ar.CG().a(new ab(com_tencent_mm_protocal_c_axl, qVar.pYC, qVar.pitch), 0);
        }
    }

    public q(b bVar, Point point) {
        super(bVar, point);
        if (d.yl()) {
            dl(220, 240);
        } else {
            dl(GameJsApiLaunchApplication.CTRL_BYTE, 300);
        }
    }

    protected final void h(Rect rect) {
        this.pUs = (TextView) this.pXp.findViewById(R.h.cIW);
        this.pUs.setText(R.l.eHS);
        this.jCQ = (TextView) this.pXp.findViewById(R.h.cIZ);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.jCQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.pXp.getContext(), 13.0f);
            this.jCQ.setLayoutParams(layoutParams);
        }
        if (d.yl()) {
            this.jCQ.setPadding(BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingTop(), BackwardSupportUtil.b.b(this.pXp.getContext(), 54.0f), this.jCQ.getPaddingBottom());
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
        return R.i.dri;
    }

    protected final com.tencent.mm.plugin.scanner.util.b boM() {
        return null;
    }

    protected final void boL() {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
        } else {
            bpo();
        }
    }

    private void bpo() {
        if (this.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
        } else if (this.pYE) {
            this.pXp.hG(true);
        } else if (!ar.Hj()) {
        } else {
            if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
                this.pXp.eh(0);
                if (this.hpO != null) {
                    return;
                }
                if (this.pXp == null) {
                    x.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
                    return;
                }
                if (this.hpO == null) {
                    this.hpO = c.OP();
                }
                this.gyz = -85.0f;
                this.gyA = -1000.0f;
                this.pYy = DownloadResult.CODE_UNDEFINED;
                this.pYx = 1;
                this.pYz = "";
                this.pYA = "";
                this.hpO.a(this.gyF, true);
            }
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
    }

    public final void boH() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            return;
        }
        this.pYF = false;
        switch (kVar.getType()) {
            case 424:
                if (i == 0 && i2 == 0) {
                    this.pYF = true;
                    beb Sn = ((ab) kVar).Sn();
                    if (Sn == null || Sn.vNZ == null) {
                        x.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                        return;
                    }
                    x.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Sn.ktN));
                    String my;
                    if (Sn.ktN == 0) {
                        my = ab.my(Sn.vNZ);
                        if (bh.ov(my)) {
                            x.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            return;
                        }
                        if (this.pYG == null) {
                            this.pYG = new a(this, (byte) 0);
                        }
                        this.pYG.url = my;
                        ag.K(this.pYG);
                        ag.h(this.pYG, 800);
                        return;
                    } else if (Sn.ktN == 2) {
                        if (this.pYH != null && !this.pYD) {
                            this.pYH.removeMessages(0);
                            this.pYH.sendEmptyMessageDelayed(0, 1000);
                            return;
                        }
                        return;
                    } else if (Sn.ktN == 1) {
                        try {
                            my = Sn.vNZ;
                            if (my != null) {
                                Map y = bi.y(my, "recommend");
                                if (y != null) {
                                    LinkedList f = ab.b.f(y, ".recommend");
                                    ab.b bVar = new ab.b();
                                    bVar.title = bh.ou((String) y.get(".recommend.title"));
                                    bVar.desc = bh.ou((String) y.get(".recommend.desc"));
                                    bVar.hOg = f;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e, "", new Object[0]);
                            x.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", e.getMessage());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            default:
                return;
        }
    }

    protected final void onResume() {
        if (ar.Hj()) {
            ar.CG().a(424, (e) this);
        }
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
        } else {
            bpo();
        }
    }

    protected final void onPause() {
        this.pYD = true;
        hI(false);
        if (ar.Hj()) {
            ar.CG().b(424, (e) this);
        }
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
        if (this.pYH != null) {
            this.pYH.removeMessages(0);
        }
    }

    protected final void onDestroy() {
    }

    protected final int boO() {
        return pXB;
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
