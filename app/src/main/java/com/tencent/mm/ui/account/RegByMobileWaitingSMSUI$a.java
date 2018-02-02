package com.tencent.mm.ui.account;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.ArrayList;

class RegByMobileWaitingSMSUI$a extends ArrayAdapter<String> {
    private final LayoutInflater nny;
    final /* synthetic */ RegByMobileWaitingSMSUI xRA;
    private final ArrayList<String> xRC;

    public final /* synthetic */ void add(Object obj) {
        OI((String) obj);
    }

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        RegByMobileWaitingSMSUI$b regByMobileWaitingSMSUI$b;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            View inflate;
            RegByMobileWaitingSMSUI$b regByMobileWaitingSMSUI$b2 = new RegByMobileWaitingSMSUI$b(this.xRA);
            switch (itemViewType) {
                case 0:
                    inflate = this.nny.inflate(R.i.dag, null);
                    break;
                case 1:
                    inflate = this.nny.inflate(R.i.dah, null);
                    break;
                default:
                    throw new IllegalArgumentException("UNIMPLEMENT TYPE");
            }
            regByMobileWaitingSMSUI$b2.xRD = (TextView) inflate.findViewById(R.h.bTH);
            regByMobileWaitingSMSUI$b2.hvY = (ImageView) inflate.findViewById(R.h.bTu);
            inflate.setTag(regByMobileWaitingSMSUI$b2);
            view = inflate;
            regByMobileWaitingSMSUI$b = regByMobileWaitingSMSUI$b2;
        } else {
            regByMobileWaitingSMSUI$b = (RegByMobileWaitingSMSUI$b) view.getTag();
        }
        int intValue = ((Integer) RegByMobileWaitingSMSUI.h(this.xRA).get(i % RegByMobileWaitingSMSUI.h(this.xRA).size())).intValue();
        switch (itemViewType) {
            case 0:
                regByMobileWaitingSMSUI$b.hvY.setImageDrawable((Drawable) RegByMobileWaitingSMSUI.i(this.xRA).get(intValue % RegByMobileWaitingSMSUI.i(this.xRA).size()));
                break;
            case 1:
                regByMobileWaitingSMSUI$b.hvY.setImageDrawable(RegByMobileWaitingSMSUI.j(this.xRA));
                break;
        }
        regByMobileWaitingSMSUI$b.xRD.setText(kC(i));
        return view;
    }

    public final int getCount() {
        return this.xRC.size();
    }

    private String kC(int i) {
        return (String) this.xRC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        if (((Integer) RegByMobileWaitingSMSUI.h(this.xRA).get(i % RegByMobileWaitingSMSUI.h(this.xRA).size())).intValue() % 4 == 0) {
            return 1;
        }
        return 0;
    }

    public final void OI(String str) {
        this.xRC.add(str);
        notifyDataSetChanged();
    }
}
