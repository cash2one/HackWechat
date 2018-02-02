package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ahx;
import com.tencent.mm.protocal.c.bwn;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;
import junit.framework.Assert;

class IPCallMyGiftCardUI$a extends BaseAdapter {
    private IPCallMyGiftCardUI nKR = null;
    ahx nKS = null;
    List<bwn> not = null;

    public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        Assert.assertTrue(iPCallMyGiftCardUI != null);
        this.nKR = iPCallMyGiftCardUI;
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

    public final int getViewTypeCount() {
        return 2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.nKR.getSystemService("layout_inflater")).inflate(R.i.dmm, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.nKT = (TextView) view.findViewById(R.h.bZi);
            aVar.nKU = (TextView) view.findViewById(R.h.cam);
            aVar.nKV = (TextView) view.findViewById(R.h.cfI);
            aVar.nKW = (CdnImageView) view.findViewById(R.h.coq);
            aVar.nKX = (ImageView) view.findViewById(R.h.cas);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        bwn com_tencent_mm_protocal_c_bwn = (bwn) getItem(i);
        if (com_tencent_mm_protocal_c_bwn != null) {
            if (bh.ov(com_tencent_mm_protocal_c_bwn.wXF)) {
                aVar.nKT.setVisibility(0);
                aVar.nKU.setVisibility(0);
                aVar.nKV.setVisibility(8);
                aVar.nKT.setText(com_tencent_mm_protocal_c_bwn.wEW);
                aVar.nKU.setText(com_tencent_mm_protocal_c_bwn.wXE);
            } else {
                aVar.nKT.setVisibility(8);
                aVar.nKU.setVisibility(8);
                aVar.nKV.setVisibility(0);
                aVar.nKV.setText(com_tencent_mm_protocal_c_bwn.wXF);
            }
            b.a(aVar.nKX, "", 0.5f, false);
            if (bh.ov(com_tencent_mm_protocal_c_bwn.nfZ)) {
                aVar.nKX.setVisibility(0);
                aVar.nKW.setVisibility(4);
            } else {
                aVar.nKW.setVisibility(0);
                aVar.nKW.setUrl(com_tencent_mm_protocal_c_bwn.nfZ);
                aVar.nKX.setVisibility(4);
            }
        }
        return view;
    }
}
