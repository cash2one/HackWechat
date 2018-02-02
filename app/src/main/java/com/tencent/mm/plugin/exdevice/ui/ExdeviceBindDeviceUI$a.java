package com.tencent.mm.plugin.exdevice.ui;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.e;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

final class ExdeviceBindDeviceUI$a extends BaseAdapter {
    private c lRR;
    List<f> lSM = new ArrayList();
    private String lSN;
    private int lSO;
    private String lSP;

    public final /* synthetic */ Object getItem(int i) {
        return pf(i);
    }

    public ExdeviceBindDeviceUI$a(String str, int i, String str2) {
        this.lSN = str;
        this.lSO = i;
        this.lSP = str2;
        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
        com_tencent_mm_aq_a_a_c_a.hDT = R.e.btP;
        this.lRR = com_tencent_mm_aq_a_a_c_a.PK();
    }

    public final void aES() {
        for (int i = 0; i < this.lSM.size(); i++) {
            f fVar = (f) this.lSM.get(i);
            fVar.lSY = c(fVar);
        }
    }

    public final boolean b(f fVar) {
        if (zo(fVar.getKey()) < 0) {
            return false;
        }
        fVar.lSY = c(fVar);
        return true;
    }

    public final boolean zm(String str) {
        return zo(str) >= 0;
    }

    public final f zn(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        for (int i = 0; i < this.lSM.size(); i++) {
            f fVar = (f) this.lSM.get(i);
            if (!zp(fVar.aET()) && str.equalsIgnoreCase(fVar.aET())) {
                return fVar;
            }
        }
        return null;
    }

    public final int getCount() {
        int i = 0;
        for (int i2 = 0; i2 < this.lSM.size(); i2++) {
            if (((f) this.lSM.get(i2)).lSY) {
                i++;
            }
        }
        return i;
    }

    public final f pf(int i) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.lSM.size(); i3++) {
            if (((f) this.lSM.get(i3)).lSY) {
                i2++;
            }
            if (i2 == i) {
                return (f) this.lSM.get(i3);
            }
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        f pf = pf(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = View.inflate(viewGroup.getContext(), R.i.dgE, null);
            aVar2.lgz = (TextView) view.findViewById(R.h.cyA);
            aVar2.jCP = (ImageView) view.findViewById(R.h.coK);
            view.setTag(aVar2);
            aVar = aVar2;
            view2 = view;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        if (pf == null || pf.lTd == null) {
            Assert.assertTrue(false);
            return view2;
        }
        String str;
        String str2;
        Object obj;
        CharSequence spannableString;
        if (pf.lSZ == ExdeviceBindDeviceUI$b.lSR) {
            x.d("MicroMsg.ExdeviceBindDeviceUI", "position(%s), broadcastname(%s), mac(%s), deviceTitle(%s).", new Object[]{Integer.valueOf(i), pf.lTa.lST, pf.lTa.bpq, pf.lTd.wqQ});
            str = "";
            str2 = pf.lTd.gfV;
            if (str2 != null && str2.length() >= 4) {
                str = str2.substring(str2.length() - 4, str2.length());
            } else if (pf.lTa.bpq != null && pf.lTa.bpq.length() >= 4) {
                str = pf.lTa.bpq;
                str = str.substring(str.length() - 4, str.length());
            }
            obj = pf.lTd.wqQ + " " + str;
            spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.bsO)), pf.lTd.wqQ.length() + 1, obj.length(), 17);
            aVar.lgz.setText(spannableString);
        } else if (pf.lSZ == ExdeviceBindDeviceUI$b.lSQ) {
            str = "";
            str2 = pf.lTd.gfV;
            if (str2 != null && str2.length() >= 4) {
                str = str2.substring(str2.length() - 4, str2.length());
            } else if (pf.lTd.vLs != null && pf.lTd.vLs.length() >= 4) {
                str = pf.lTd.vLs;
                str = str.substring(str.length() - 4, str.length());
            }
            obj = pf.lTd.wqQ + " " + str;
            spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(viewGroup.getContext().getResources().getColor(R.e.bsO)), pf.lTd.wqQ.length() + 1, obj.length(), 17);
            aVar.lgz.setText(spannableString);
        } else {
            Assert.assertTrue(false);
        }
        str = pf.lTd.nfT;
        if (!zp(str)) {
            o.PA().a(str, aVar.jCP, this.lRR);
        }
        return view2;
    }

    private int zo(String str) {
        for (int i = 0; i < this.lSM.size(); i++) {
            if (((f) this.lSM.get(i)).getKey().compareTo(str) == 0) {
                return i;
            }
        }
        return -1;
    }

    final int cr(String str, String str2) {
        for (int i = 0; i < this.lSM.size(); i++) {
            f fVar = (f) this.lSM.get(i);
            String str3 = fVar.lTc != null ? fVar.lTc.vJA : fVar.lSZ == ExdeviceBindDeviceUI$b.lSQ ? fVar.lTb.lRh : null;
            String str4 = fVar.lTc != null ? fVar.lTc.ksX : fVar.lSZ == ExdeviceBindDeviceUI$b.lSQ ? fVar.lTb.lLS : null;
            if (!zp(str3) && !zp(r0) && str.compareTo(str3) == 0 && str2.compareTo(r0) == 0) {
                return i;
            }
        }
        return -1;
    }

    final boolean c(f fVar) {
        if (fVar.lTd == null) {
            return false;
        }
        if (this.lSO == e.lSW) {
            if (fVar.lTd.wqJ == null || fVar.lTd.wqJ.compareTo(this.lSN) != 0 || fVar.lTd.wqS == null || fVar.lTd.wqS.compareTo(this.lSP) != 0) {
                return false;
            }
        } else if (this.lSO != e.lSV) {
            Assert.assertTrue(false);
            return false;
        } else if (fVar.lTd.gfR == 0) {
            return false;
        }
        return true;
    }

    private static boolean zp(String str) {
        return str == null || str.length() == 0;
    }
}
