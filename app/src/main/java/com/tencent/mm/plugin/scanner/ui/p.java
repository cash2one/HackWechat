package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.ac.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.c$a;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b$a;
import com.tencent.mm.plugin.scanner.util.d;
import com.tencent.mm.plugin.scanner.util.d.AnonymousClass1;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.n;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p extends i implements e, a, i.a, b$a {
    int bufferSize;
    int fqw = 0;
    Object hpF = new Object();
    private int mMode = 0;
    long pXC = 80;
    private com.tencent.mm.plugin.scanner.util.e.a pXT = new 1(this);
    d pYf;
    AtomicBoolean pYg = new AtomicBoolean(false);
    boolean pYh = false;
    boolean pYi = false;
    private float pYj = DownloadHelper.SAVE_FATOR;
    byte[] pYk;
    Point pYl;
    int pYm;
    private TextView pYn;
    boolean pYo = false;
    private OnClickListener pYp = new 2(this);

    static /* synthetic */ void a(p pVar) {
        pVar.pYi = true;
        pVar.pYh = true;
        pVar.pXp.boZ();
    }

    public p(b bVar, Point point, int i, int i2) {
        super(bVar, point);
        dl(c$a.CTRL_INDEX, c$a.CTRL_INDEX);
        this.fqw = i;
        this.mMode = i2;
        this.pXr = true;
        this.pXh = 1000;
        if (bh.eY(bVar.getContext()) < 100) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "memory is not much");
            this.pXC = 280;
        }
    }

    protected final void f(Point point) {
        this.pXi = null;
        super.f(point);
    }

    protected final Rect hJ(boolean z) {
        Rect rect = new Rect(y(true, z));
        x.i("MicroMsg.scanner.ScanModeQRCode", "display rect:" + rect);
        int width = rect.width();
        int height = rect.height();
        int i = (int) (((float) width) * this.pYj);
        int i2 = (int) (((float) height) * this.pYj);
        if (i > this.pXk.x) {
            i = this.pXk.x;
        }
        if (i2 > this.pXk.y) {
            i2 = this.pXk.y;
        }
        if (i2 % 2 == 1) {
            i2--;
        }
        if (i % 2 == 1) {
            i--;
        }
        x.i("MicroMsg.scanner.ScanModeQRCode", "newWidth:%d,newHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        rect.left -= (i - width) / 2;
        rect.right = ((i - width) / 2) + rect.right;
        rect.top -= (i2 - height) / 2;
        rect.bottom += (i2 - height) / 2;
        x.i("MicroMsg.scanner.ScanModeQRCode", "scan rect:" + rect);
        return rect;
    }

    public final void bpq() {
        this.pXr = false;
    }

    public final boolean bpr() {
        return this.pXr;
    }

    protected final void h(Rect rect) {
        this.pYn = (TextView) this.pXp.findViewById(R.h.cJc);
        this.pYn.setOnClickListener(this.pYp);
        this.jCQ = (TextView) this.pXp.findViewById(R.h.cIZ);
        if (rect.bottom > 0) {
            this.pYn.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) this.jCQ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.pXp.getContext(), 13.0f);
            this.jCQ.setLayoutParams(layoutParams);
        }
        if (this.pYf != null) {
            this.pYf.otW = this.pXp.bpa();
        }
        bpo();
        if (this.mMode == 2) {
            this.jCQ.setText(R.l.eBi);
        } else if (this.mMode == 1) {
            this.jCQ.setText(R.l.eBh);
        } else if (this.fqw == 1) {
            this.jCQ.setText(R.l.eBC);
        } else if (this.fqw == 2) {
            this.jCQ.setText(R.l.eXg);
        } else {
            this.jCQ.setText(R.l.eBD);
        }
        hI(true);
    }

    protected final void boP() {
        h(new Rect(0, 0, 0, 0));
        if (this.mMode == 2) {
            this.pXp.b(4, null);
        } else {
            this.pXp.b(0, new 3(this));
        }
        this.pXp.a(this);
        onResume();
    }

    protected final int boN() {
        return R.i.drh;
    }

    protected final com.tencent.mm.plugin.scanner.util.b boM() {
        if (this.pYf == null && this.pXp != null) {
            this.pYf = new d(this, this.mMode, this.pXp.bpa());
        }
        return this.pYf;
    }

    protected final void boL() {
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "handleNetworkChange(), scanUICallback == null");
        } else {
            bpo();
        }
    }

    private void bpo() {
        if (this.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "dealWithNetWork(), scanUICallback == null");
        } else if (ar.CG().Km() == 6 || ar.CG().Km() == 4) {
            this.pXp.eh(0);
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        this.pYg.set(false);
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
        } else if (this.pYh) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "is decoding, return");
        } else {
            this.pYh = true;
            x.d("MicroMsg.scanner.ScanModeQRCode", "decode success:%s", new Object[]{str});
            if (bh.ov(str)) {
                this.pYh = false;
            } else if (ar.CG().Km() == 0) {
                Toast.makeText(this.pXp.getContext(), this.pXp.getContext().getString(R.l.eiE), 0).show();
                this.pYh = false;
            } else {
                m.qbb.stop();
                m.qbb.stop();
                b(i, str, i2, i3);
            }
        }
    }

    private void b(int i, String str, int i2, int i3) {
        int i4 = 1;
        Activity context = this.pXp.getContext();
        com.tencent.mm.sdk.b.b lyVar = new ly();
        if (i == 1) {
            lyVar.fDv.fDx = 0;
        } else {
            lyVar.fDv.fDx = 1;
        }
        lyVar.fDv.scanResult = str;
        if (this.pYo) {
            x.d("MicroMsg.scanner.ScanModeQRCode", "need to finish on decode success");
            lyVar.fDv.fDt = 1;
            com.tencent.mm.sdk.b.a.xef.m(lyVar);
            Intent intent = new Intent();
            intent.putExtra("key_scan_result", str);
            intent.putExtra("key_scan_result_type", i);
            intent.putExtra("key_scan_result_code_type", i2);
            intent.putExtra("key_scan_result_code_version", i3);
            context.setResult(-1, intent);
            context.finish();
            context.overridePendingTransition(0, 0);
            return;
        }
        lyVar.fDv.fDt = 0;
        com.tencent.mm.sdk.b.a.xef.m(lyVar);
        if (lyVar.fDw.ret == 1 || lyVar.fDw.ret == 2) {
            context.finish();
            context.overridePendingTransition(0, 0);
        }
        if (i == 1) {
            this.pXp.boU();
            this.pXp.hG(true);
            this.pYh = false;
            if (lyVar.fDw.ret != 2) {
                if (!this.pYi) {
                    i4 = 0;
                }
                this.pXp.a(str, i4, i2, i3, this.pXT);
            }
        } else if (i != 2) {
        } else {
            if (str == null || str.length() <= 0) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "result is null");
                this.pYh = false;
                this.pXp.hG(false);
                return;
            }
            String[] split = str.split(",", 2);
            if (split == null || split.length < 2) {
                x.e("MicroMsg.scanner.ScanModeQRCode", "wrong zbar format");
                this.pYh = false;
                this.pXp.hG(false);
                return;
            }
            k fVar = new f(com.tencent.mm.plugin.scanner.util.p.IN(split[0]), split[1], i2, i3);
            fVar.pSP = this.pYi;
            ar.CG().a(fVar, 0);
            this.pXp.boU();
            this.pXp.hG(true);
            Context context2 = this.pXp.getContext();
            this.pXp.getContext().getString(R.l.dGO);
            this.iln = h.a(context2, this.pXp.getContext().getString(R.l.eBB), true, new 5(this, fVar));
        }
    }

    public final void boH() {
        x.i("MicroMsg.scanner.ScanModeQRCode", "decodeFail");
        this.pYg.set(false);
        synchronized (this.hpF) {
            bps();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd: errType = [%s] errCode = [%s] errMsg = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iln != null) {
            this.iln.dismiss();
            this.iln = null;
        }
        if (this.pXp == null || kVar == null) {
            String str2 = "MicroMsg.scanner.ScanModeQRCode";
            String str3 = "onSceneEnd() scene is null [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(kVar == null);
            x.e(str2, str3, objArr);
            this.pYh = false;
        } else if (i == 4 && i2 == -4) {
            h.a(this.pXp.getContext(), R.l.eBw, R.l.dGO, new 4(this));
        } else {
            boolean z;
            switch (i) {
                case 1:
                    if (ar.CG().Kn()) {
                        this.pXp.getContext();
                        ar.CG().getNetworkServerIp();
                        new StringBuilder().append(i2);
                    } else if (ab.bC(this.pXp.getContext())) {
                        com.tencent.mm.pluginsdk.ui.k.eo(this.pXp.getContext());
                    } else {
                        Toast.makeText(this.pXp.getContext(), this.pXp.getContext().getString(R.l.eiD, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                    }
                    z = true;
                    break;
                case 2:
                    Toast.makeText(this.pXp.getContext(), this.pXp.getContext().getString(R.l.eiE, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), 1).show();
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                hs(true);
            } else if (i == 4 && i2 == -2004) {
                h.h(this.pXp.getContext(), R.l.eBr, R.l.dGO);
                hs(true);
            } else if (i != 0 || i2 != 0) {
                Toast.makeText(this.pXp.getContext(), this.pXp.getContext().getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                hs(true);
            } else if (kVar.getType() == 1061) {
                hx boD = ((f) kVar).boD();
                if (boD == null) {
                    x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd(), getResp() == null");
                    hs(true);
                    return;
                }
                x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(boD.ktN)});
                if (bh.ov(boD.vNR)) {
                    hs(true);
                    return;
                }
                switch (n.a(boD.ktN, boD.vNR, this, 4, this.pXT, ((f) kVar).fqb, ((f) kVar).fqc, ((f) kVar).pSP)) {
                    case 0:
                        this.pXp.getContext().finish();
                        this.pXp.getContext().overridePendingTransition(0, 0);
                        return;
                    case 1:
                        x.d("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        break;
                    case 2:
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        this.pXp.eh(0);
                        break;
                }
                this.pXp.hG(false);
            } else if (kVar.getType() == 666) {
                if (kVar instanceof aa) {
                    this.pXp.hG(true);
                    this.pXp.getContext().finish();
                    this.pXp.getContext().overridePendingTransition(0, 0);
                }
            } else if (kVar.getType() == 971) {
                this.pXp.hG(true);
                this.pXp.getContext().finish();
                this.pXp.getContext().overridePendingTransition(0, 0);
            }
        }
    }

    protected final void onResume() {
        ar.CG().a(1061, this);
        ar.CG().a(666, this);
        ar.CG().a(971, this);
        if (this.pXp == null) {
            x.w("MicroMsg.scanner.ScanModeQRCode", "scanUICallback == null");
            return;
        }
        if (!this.pYi) {
            this.pYh = false;
        }
        bpo();
    }

    protected final void onPause() {
        super.onPause();
        hI(false);
        ar.CG().b(1061, this);
        ar.CG().b(666, this);
        ar.CG().b(971, this);
    }

    protected final int boO() {
        return c$a.CTRL_INDEX;
    }

    public final void b(Activity activity, int i, int i2, Intent intent) {
        if (activity != null) {
            this.pYh = true;
            if (i2 != -1) {
                this.pYh = false;
                this.pYg.set(false);
                this.pYi = false;
                return;
            }
            switch (i) {
                case 1:
                    this.pXp.bpc();
                    return;
                case 4660:
                    if (intent == null) {
                        x.e("MicroMsg.scanner.ScanModeQRCode", "onActivityResult data == null");
                        this.pYh = false;
                        this.pYg.set(false);
                        this.pYi = false;
                        return;
                    }
                    this.pYg.set(true);
                    ar.Hg();
                    x.d("MicroMsg.scanner.ScanModeQRCode", "select: [%s]", new Object[]{com.tencent.mm.ui.tools.a.c(activity, intent, c.Fi())});
                    new af().post(new 6(this, activity));
                    if (this.pYf != null) {
                        this.pYf.kL();
                    }
                    if (this.pXp != null) {
                        this.pXp.hG(true);
                    }
                    l.pST.reset();
                    com.tencent.mm.plugin.scanner.c.boA().pSf.a(r0, new 7(this, activity), null);
                    return;
                default:
                    return;
            }
        }
    }

    protected final void onDestroy() {
        this.pYk = null;
    }

    public final Context getContext() {
        if (this.pXp != null) {
            return this.pXp.getContext();
        }
        x.e("MicroMsg.scanner.ScanModeQRCode", "getContext(), scanUICallback == null");
        return null;
    }

    public final void hs(boolean z) {
        if (this.pXp == null) {
            x.e("MicroMsg.scanner.ScanModeQRCode", "continueScan, scanUICallback == null");
        } else if (z) {
            this.pXp.hG(false);
        } else {
            this.pXp.getContext().finish();
            this.pXp.getContext().overridePendingTransition(0, 0);
        }
    }

    protected final boolean boQ() {
        return true;
    }

    protected final boolean boR() {
        return true;
    }

    public final void D(Bundle bundle) {
        if (bundle.containsKey("zoom_action") && bundle.containsKey("zoom_type") && bundle.containsKey("zoom_scale") && this.pXp != null) {
            this.pXp.W(bundle.getInt("zoom_action"), bundle.getInt("zoom_type"), bundle.getInt("zoom_scale"));
        }
    }

    private void bps() {
        if (!this.pYg.get() && this.bufferSize > 0) {
            this.pYg.set(true);
            this.bufferSize--;
            if (l.pST.pSW % 2 == 0 && (this.mMode == 1 || this.mMode == 0)) {
                ((d) boM()).pZP = 3;
            } else {
                ((d) boM()).pZP = this.mMode;
            }
            x.i("MicroMsg.scanner.ScanModeQRCode", "try decode,buffer size:" + this.bufferSize);
            if (l.pST.pSW > 0 && this.pXp != null) {
                this.pXp.eg(30);
            }
            if (!(this.pYk == null || this.pYl == null)) {
                d dVar = (d) boM();
                Set dn = d.dn(dVar.pZP, 0);
                if (dVar.pZN) {
                    dVar.f(dn);
                }
                com.tencent.mm.sdk.f.e.b(new AnonymousClass1((d) boM(), this.pYk, this.pYl), "scan_decode", 10);
            }
            if (l.pST.pSW == 30 && this.pXp != null) {
                this.pXp.bpe();
            }
        } else if (this.pXp != null) {
            this.pXp.eg(0);
        }
    }

    protected final void a(byte[] bArr, Point point, int i, Rect rect) {
        synchronized (this.hpF) {
            if (this.bufferSize == 1) {
                x.d("MicroMsg.scanner.ScanModeQRCode", "decode too slow");
                this.bufferSize = 0;
            }
        }
        if (this.pYl == null) {
            this.pYl = new Point();
        }
        com.tencent.mm.sdk.f.e.post(new 8(this, bArr, point, i, rect), "prepare_decode_data");
    }
}
