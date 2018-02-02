package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.plugin.brandservice.a.i;
import com.tencent.mm.plugin.brandservice.ui.c.a;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements e {
    private int irz = 0;
    private ListView kFD;
    c kFE;
    private TextView kFF;
    c kFG;
    private a kFH;
    i kFI;
    b kFJ;
    private long[] kFK;
    int kFL;
    private boolean kFM;
    int kFN;
    int kFn;

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.kFG.kFU || bizSearchResultItemContainer.kFG.hEP == 0 || bizSearchResultItemContainer.kFG.kFT) ? false : true;
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.cKa, this);
        this.kFG = new c((byte) 0);
        this.kFH = new a((byte) 0);
        this.kFF = (TextView) inflate.findViewById(R.h.cec);
        this.kFD = (ListView) inflate.findViewById(R.h.cHM);
    }

    public final void a(c cVar) {
        this.kFE = cVar;
        if (this.kFE != null) {
            this.kFE.lw(this.irz);
            ListView listView = this.kFD;
            a aVar = this.kFH;
            View inflate = View.inflate(getContext(), R.i.dmF, null);
            aVar.kFQ = inflate.findViewById(R.h.cty);
            aVar.kFR = inflate.findViewById(R.h.ctt);
            aVar.kFS = inflate.findViewById(R.h.ctA);
            aVar.kFQ.setVisibility(8);
            aVar.kFR.setVisibility(8);
            aVar.kFS.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.kFD.setAdapter(this.kFE);
            this.kFD.setOnScrollListener(new 1(this));
            this.kFD.setOnItemClickListener(this.kFE);
            if (this.kFG.kEM == 0) {
                d(1);
                return;
            }
            return;
        }
        this.kFD.setAdapter(this.kFE);
    }

    private void b(String str, int i, long j) {
        je jeVar = null;
        this.kFG.kFT = true;
        ar.CG().a(1071, this);
        a bN = this.kFE.bN(this.kFK[this.kFK.length - 1]);
        List list = bN != null ? bN.kFC : null;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        } else {
            jeVar = (je) list.get(list.size() - 1);
        }
        x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jeVar != null ? jeVar.vPs : ""});
        ar.CG().a(new h(str, j, i, this.irz, r6), 0);
        this.kFH.nx(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 3;
        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.kFJ != null) {
            this.kFJ.asr();
        }
        if (i == 0 && i2 == 0) {
            this.kFM = false;
            if (kVar == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                return;
            }
            int i4;
            int i5;
            if (kVar.getType() == 1070) {
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                ar.CG().b(1070, this);
                i iVar = (i) kVar;
                List list = iVar.kEN == null ? null : iVar.kEN.wKi;
                this.kFE.c(this.kFG.fod, list);
                a bN = this.kFE.bN(this.kFK[this.kFK.length - 1]);
                i5 = (bN == null || bN.kFB) ? 0 : bN.hEP;
                if (i5 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    je jeVar = (je) list.get(list.size() - 1);
                    if (jeVar != null) {
                        this.kFG.offset = jeVar.vNW + this.kFL;
                    }
                }
                i4 = i3;
                i3 = i5;
            } else if (kVar.getType() == 1071) {
                ar.CG().b(1071, this);
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                je asl = ((h) kVar).asl();
                if (asl == null || asl.ngS == null) {
                    x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i5 = asl == null ? 0 : asl.vPq;
                if (i5 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.kFE.a(asl, true);
                if (asl != null) {
                    x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[]{asl.vPs});
                    this.kFG.offset = asl.vNW + this.kFL;
                }
                i3 = i5;
            } else {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[]{Integer.valueOf(kVar.getType())});
                return;
            }
            if (this.kFE.isEmpty()) {
                new af(Looper.getMainLooper()).post(new 2(this));
            } else {
                this.kFG.kFU = true;
            }
            this.kFG.hEP = i3;
            this.kFH.nx(i4);
            this.kFG.kFT = false;
            x.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[]{Integer.valueOf(this.kFG.offset)});
            return;
        }
        this.kFG.kFT = false;
        this.kFM = true;
        Toast.makeText(getContext(), getContext().getString(R.l.eje, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }

    final void reset() {
        this.kFE.asp();
        this.kFH.nx(0);
        this.kFG.kFU = false;
        this.kFG.kFT = false;
        this.kFG.offset = 0;
        this.kFG.fod = null;
        this.kFG.hEP = 1;
    }

    public final void d(long... jArr) {
        this.kFK = jArr;
        this.kFG.kEM = 0;
        for (int i = 0; i <= 0; i++) {
            c cVar = this.kFG;
            cVar.kEM |= jArr[0];
        }
        this.kFE.c(jArr);
    }

    public final void aU(String str, int i) {
        if (this.kFE.isEmpty()) {
            this.kFF.setVisibility(8);
        }
        if (str != null) {
            String trim = str.trim();
            if (!"".equals(trim)) {
                if ((!trim.equals(this.kFG.fod) || this.kFM) && !this.kFG.kFT) {
                    reset();
                    this.kFG.kFT = true;
                    this.kFG.fod = trim;
                    this.kFL = i;
                    if (this.kFN != 1) {
                        ar.CG().a(1070, this);
                        this.kFI = new i(this.kFG.fod, this.kFG.kEM, this.irz);
                        ar.CG().a(this.kFI, 0);
                    } else if (this.kFK.length == 0) {
                        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                        return;
                    } else {
                        b(trim, i, this.kFK[0]);
                        this.kFH.nx(0);
                    }
                    if (this.kFJ != null) {
                        this.kFJ.asq();
                    }
                }
            }
        }
    }

    public final void lw(int i) {
        this.irz = i;
        this.kFE.lw(this.irz);
    }

    public final void dW(boolean z) {
        this.kFE.p(z, false);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.kFD.setOnTouchListener(onTouchListener);
    }
}
