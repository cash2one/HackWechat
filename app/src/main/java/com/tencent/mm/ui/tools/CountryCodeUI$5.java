package com.tencent.mm.ui.tools;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar$a;

class CountryCodeUI$5 implements VerticalScrollBar$a {
    final /* synthetic */ CountryCodeUI zgY;

    CountryCodeUI$5(CountryCodeUI countryCodeUI) {
        this.zgY = countryCodeUI;
    }

    public final void xh(String str) {
        int i = 0;
        if (this.zgY.getString(R.l.eIq).equals(str)) {
            CountryCodeUI.b(this.zgY).setSelection(0);
            return;
        }
        int intValue = Integer.decode(str.substring(0, str.length() - 1)).intValue();
        int[] iArr = CountryCodeUI.c(this.zgY).nJa;
        if (iArr != null) {
            while (i < iArr.length) {
                if (iArr[i] == intValue) {
                    CountryCodeUI.b(this.zgY).setSelection(i + CountryCodeUI.b(this.zgY).getHeaderViewsCount());
                    return;
                }
                i++;
            }
        }
    }
}
