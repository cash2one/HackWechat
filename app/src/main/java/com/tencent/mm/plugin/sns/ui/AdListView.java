package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p$a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.b;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public class AdListView extends ListView {
    b rpX;
    f rpY;
    e rpZ;
    private boolean rqa = true;
    private HashSet<String> rqb = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void layoutChildren() {
        super.layoutChildren();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void detachViewFromParent(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.frH;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
    }

    protected void detachViewFromParent(int i) {
        if (r.idT) {
            x.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
    }

    protected void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.frH;
            d.rdA.KU(cVar.rOK.nGJ);
            d.rdA.eg(cVar.rOK.nGJ, cVar.rOK.wQn == null ? "" : cVar.rOK.wQn.nGJ);
            if (this.rpX != null && cVar.qQH) {
                this.rpX.a(cVar.position, cVar.frH, cVar.iTh, cVar.nbi, view, cVar.rND, cVar.qQI, cVar.qOc, cVar.kTK, 1);
            }
            if (!this.rqb.contains(cVar.fzW) && ((cVar.qQH && cVar.rOK.wQo.vYc == 15) || cVar.rOK.wQo.vYc == 18)) {
                boolean z = false;
                if (cVar.rOK.wQo.vYc == 15 && (cVar.rOF.qvN instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.rOF.qvN).quA.bsK();
                }
                j.a(ae.bvv().Ll(cVar.fzW), false, z);
                this.rqb.add(cVar.fzW);
            }
            if (this.rpY != null) {
                this.rpY.a(cVar.frH, cVar.rOK);
            }
            if (this.rpZ != null) {
                this.rpZ.a(cVar.position, cVar.frH, cVar.rND, cVar.iTh, cVar.rOK, cVar.qQH, cVar.qQI);
            }
            str = str2;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewAdded(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.frH;
            d.rdA.KU(cVar.rOK.nGJ);
            d.rdA.eg(cVar.rOK.nGJ, cVar.rOK.wQn == null ? "" : cVar.rOK.wQn.nGJ);
            if (this.rpX != null && cVar.qQH) {
                this.rpX.a(cVar.position, cVar.frH, cVar.iTh, cVar.nbi, view, cVar.rND, cVar.qQI, cVar.qOc, cVar.kTK, 1);
            }
            if (!this.rqb.contains(cVar.fzW) && ((cVar.qQH && cVar.rOK.wQo.vYc == 15) || cVar.rOK.wQo.vYc == 18)) {
                boolean z = false;
                if (cVar.rOK.wQo.vYc == 15 && (cVar.rOF.qvN instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.rOF.qvN).quA.bsK();
                }
                j.a(ae.bvv().Ll(cVar.fzW), false, z);
                this.rqb.add(cVar.fzW);
            }
            if (this.rpY != null) {
                this.rpY.a(cVar.frH, cVar.rOK);
            }
            if (this.rpZ != null) {
                this.rpZ.a(cVar.position, cVar.frH, cVar.rND, cVar.iTh, cVar.rOK, cVar.qQH, cVar.qQI);
            }
            str = str2;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewRemoved(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.frH;
            if (this.rpX != null && cVar.qQH) {
                this.rpX.t(cVar.position, cVar.frH, cVar.iTh);
            }
            if (this.rpY != null) {
                this.rpY.JY(cVar.frH);
            }
            if (this.rpZ != null) {
                this.rpZ.a(cVar.position, cVar.frH, cVar.rND, cVar.iTh, cVar.rOK, cVar.qQH);
            }
            if (cVar.rOK.wQo.vYc == 3) {
                m Ll = ae.bvv().Ll(cVar.fzW);
                int byC = Ll == null ? 0 : Ll.byC();
                p$a com_tencent_mm_modelstat_p_a = p$a.Sns;
                String str3 = cVar.rOK.rtA;
                String eq = i.eq(cVar.rND);
                if (!bh.ov(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, null, new Object[0]);
                    }
                    blt com_tencent_mm_protocal_c_blt = new blt();
                    try {
                        com_tencent_mm_protocal_c_blt.aF(bArr);
                        if (com_tencent_mm_protocal_c_blt.wPl == null) {
                            str = str2;
                        } else {
                            x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", Integer.valueOf(com_tencent_mm_modelstat_p_a.value), str3, com_tencent_mm_protocal_c_blt.wPl.wPo, com_tencent_mm_protocal_c_blt.wPl.wPp);
                            ((com.tencent.mm.plugin.sns.b.c) g.h(com.tencent.mm.plugin.sns.b.c.class)).a(13235, byC, new Object[]{com_tencent_mm_modelstat_p_a.value, com_tencent_mm_protocal_c_blt.wPl.wPo, com_tencent_mm_protocal_c_blt.wPl.wPp, eq});
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    public void removeViewInLayout(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.frH;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
    }

    public void removeView(View view) {
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.frH;
        }
        if (r.idT) {
            x.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    protected void detachViewsFromParent(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof c)) {
                c cVar = (c) childAt.getTag();
                if (this.rpX != null && cVar.qQH) {
                    this.rpX.t(cVar.position, cVar.frH, cVar.iTh);
                }
                if (this.rpY != null) {
                    this.rpY.JY(cVar.frH);
                }
                if (this.rpZ != null) {
                    this.rpZ.a(cVar.position, cVar.frH, cVar.rND, cVar.iTh, cVar.rOK, cVar.qQH);
                }
                str = cVar.position + " " + cVar.frH;
            }
            if (r.idT) {
                x.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
    }
}
