package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMGridPaper;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    private Context mContext = null;
    private k nSp = null;
    private MMGridPaper nSq = null;
    private a nSr = null;
    private ViewGroup nSs = null;
    private RelativeLayout nSt = null;
    private ArrayList<String> nSu = null;
    private int nSv = 0;

    private b(Context context) {
        this.mContext = context;
        this.nSp = new k(this.mContext, R.m.eZe);
        this.nSs = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.daL, null);
        this.nSq = (MMGridPaper) this.nSs.findViewById(R.h.cbY);
        this.nSq.cpg();
        this.nSq.cpe();
        this.nSq.cpf();
        this.nSq.cpd();
        this.nSq.EM(3);
        this.nSq.cph();
        this.nSq.cpg();
        this.nSq.cpb();
        this.nSq.cpc();
        this.nSp.setCanceledOnTouchOutside(true);
        this.nSp.setContentView(this.nSs);
        this.nSr = new a();
        this.nSq.a(this.nSr);
    }

    public static void b(Context context, ArrayList<String> arrayList) {
        x.d("MicroMsg.AvatarsDialog", "showDialog, username.size = %d", new Object[]{Integer.valueOf(arrayList.size())});
        b bVar = new b(context);
        bVar.nSu = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bVar.nSu.add((String) it.next());
        }
        if (bVar.nSu.size() < 3) {
            bVar.nSq.EM(bVar.nSu.size());
        } else {
            bVar.nSq.EM(3);
        }
        LayoutParams layoutParams = bVar.nSq.getLayoutParams();
        bVar.nSv = a.fromDPToPix(bVar.mContext, 70);
        int fromDPToPix = a.fromDPToPix(bVar.mContext, 8);
        if (bVar.nSu.size() <= 0) {
            fromDPToPix = 0;
        } else if (bVar.nSu.size() < 3) {
            fromDPToPix = (fromDPToPix * (bVar.nSu.size() - 1)) + (bVar.nSv * bVar.nSu.size());
        } else {
            fromDPToPix = (fromDPToPix * 2) + (bVar.nSv * 3);
        }
        String eG = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.eG(bVar.mContext);
        x.d("MicroMsg.AvatarsDialog", "calculateGridWidth, result = %d, mUsername.size = %d, avatarSize = %d, densityType = %s", new Object[]{Integer.valueOf(fromDPToPix), Integer.valueOf(bVar.nSu.size()), Integer.valueOf(bVar.nSv), eG});
        layoutParams.width = fromDPToPix;
        bVar.nSv = a.fromDPToPix(bVar.mContext, 70);
        fromDPToPix = a.fromDPToPix(bVar.mContext, 15);
        if (bVar.nSu.size() > 0) {
            if (bVar.nSu.size() <= 3) {
                fromDPToPix += bVar.nSv;
            } else if (bVar.nSu.size() <= 6) {
                fromDPToPix += bVar.nSv * 2;
            } else {
                fromDPToPix = ((fromDPToPix * 2) + (bVar.nSv * 3)) + a.fromDPToPix(bVar.mContext, 10);
            }
            x.d("MicroMsg.AvatarsDialog", "calculateGridHeight, result = %d", new Object[]{Integer.valueOf(fromDPToPix)});
        } else {
            fromDPToPix = 0;
        }
        layoutParams.height = fromDPToPix;
        bVar.nSq.setLayoutParams(layoutParams);
        bVar.nSq.requestLayout();
        bVar.nSr.D(bVar.nSu);
        bVar.nSp.show();
    }
}
