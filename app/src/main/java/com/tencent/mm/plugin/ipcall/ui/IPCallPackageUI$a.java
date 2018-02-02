package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bwp;
import java.util.List;

class IPCallPackageUI$a extends BaseAdapter {
    private IPCallPackageUI nLi = null;
    List<bwp> not = null;

    public IPCallPackageUI$a(IPCallPackageUI iPCallPackageUI) {
        this.nLi = iPCallPackageUI;
    }

    public final int getCount() {
        return this.not == null ? 0 : this.not.size();
    }

    public final Object getItem(int i) {
        if (this.not != null) {
            return this.not.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.nLi.getSystemService("layout_inflater")).inflate(R.i.dmo, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.nLm = (CdnImageView) view.findViewById(R.h.cCf);
            aVar.inw = (TextView) view.findViewById(R.h.cCi);
            aVar.nLn = (TextView) view.findViewById(R.h.cCj);
            aVar.nLo = (TextView) view.findViewById(R.h.cCc);
            aVar.iXX = (TextView) view.findViewById(R.h.cCd);
            aVar.nLp = (Button) view.findViewById(R.h.cCb);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bwp com_tencent_mm_protocal_c_bwp = (bwp) getItem(i);
        if (com_tencent_mm_protocal_c_bwp != null) {
            aVar.inw.setText(com_tencent_mm_protocal_c_bwp.fon);
            aVar.nLn.setText(com_tencent_mm_protocal_c_bwp.wEW);
            aVar.iXX.setText(com_tencent_mm_protocal_c_bwp.nfe);
            aVar.nLo.setText(com_tencent_mm_protocal_c_bwp.nGK);
            aVar.nLm.setVisibility(0);
            aVar.nLm.setUrl(com_tencent_mm_protocal_c_bwp.wXI);
            if (com_tencent_mm_protocal_c_bwp.vGN == 0) {
                aVar.nLp.setEnabled(true);
            } else {
                aVar.nLp.setEnabled(false);
            }
            aVar.nLp.setTag(Integer.valueOf(i));
            aVar.nLp.setOnClickListener(new 1(this));
        }
        return view;
    }
}
