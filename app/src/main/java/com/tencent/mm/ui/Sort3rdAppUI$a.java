package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

class Sort3rdAppUI$a extends ArrayAdapter<f> {
    private c lRR;
    List<f> ltR;
    private Context mContext;
    private long xMF;

    public Sort3rdAppUI$a(Context context, List<f> list, long j) {
        super(context, R.i.dsM, list);
        this.xMF = j;
        this.mContext = context;
        this.ltR = list;
        a aVar = new a();
        aVar.hDP = R.g.bDU;
        this.lRR = aVar.PK();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z = true;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dsM, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        aVar.iiq.setText(fVar.field_appName);
        Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bv.a.getDensity(this.mContext));
        if (b == null || b.isRecycled()) {
            o.PA().a(fVar.field_appIconUrl, aVar.jCP, this.lRR);
        } else {
            aVar.jCP.setImageBitmap(b);
        }
        MMSwitchBtn mMSwitchBtn = aVar.tPM;
        if ((fVar.field_appInfoFlag & 16384) != 0) {
            z = false;
        }
        mMSwitchBtn.nB(z);
        aVar.tPM.zvp = new 1(this, fVar);
        view.setVisibility(0);
        return view;
    }
}
