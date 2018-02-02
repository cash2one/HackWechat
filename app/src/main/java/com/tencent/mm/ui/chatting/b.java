package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

final class b extends BaseAdapter {
    private Context context;
    private c lRR;
    private List<y> yqb;
    boolean yqc = false;

    public final /* synthetic */ Object getItem(int i) {
        return Fn(i);
    }

    public b(Context context) {
        this.context = context;
        this.yqb = new ArrayList();
        a aVar = new a();
        aVar.hDP = R.g.bDU;
        this.lRR = aVar.PK();
        aD(null);
    }

    public final void aD(List<y> list) {
        List list2;
        y yVar;
        this.yqb.clear();
        if (!(list == null || list.size() == 0)) {
            this.yqb.addAll(list);
        }
        if (this.yqc) {
            list2 = this.yqb;
            yVar = new y();
            yVar.mPo = R.g.bFJ;
            yVar.gBL = this.context.getString(R.l.dSY);
            list2.add(yVar);
        }
        list2 = this.yqb;
        yVar = new y();
        yVar.mPo = R.g.bFI;
        yVar.gBL = this.context.getString(R.l.eNt);
        list2.add(yVar);
        x.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[]{Integer.valueOf(this.yqb.size())});
    }

    public final int getCount() {
        return this.yqb.size();
    }

    private y Fn(int i) {
        return (y) this.yqb.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        al alVar;
        y Fn = Fn(i);
        if (view == null) {
            al alVar2 = new al();
            view = View.inflate(viewGroup.getContext(), R.i.drN, null);
            alVar2.lUV = view.findViewById(R.h.bYF);
            alVar2.lgz = (TextView) view.findViewById(R.h.cyA);
            alVar2.jCP = (ImageView) view.findViewById(R.h.coK);
            alVar2.yvg = (TextView) view.findViewById(R.h.cLr);
            alVar2.yxX = (SendDataToDeviceProgressBar) view.findViewById(R.h.cLq);
            alVar2.yxX.setVisibility(4);
            view.setTag(alVar2);
            alVar = alVar2;
        } else {
            alVar = (al) view.getTag();
        }
        alVar.lgz.setText(Fn.gBL);
        x.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[]{Integer.valueOf(i), Fn.gBL});
        if (Fn.mPo != 0) {
            alVar.jCP.setImageResource(Fn.mPo);
        } else {
            Bitmap b = g.b(Fn.appId, 1, com.tencent.mm.bv.a.getDensity(this.context));
            if (b == null || b.isRecycled()) {
                o.PA().a(Fn.iconUrl, alVar.jCP, this.lRR);
            } else {
                alVar.jCP.setImageBitmap(b);
            }
        }
        alVar.lUV.setTag(Integer.valueOf(i));
        return view;
    }
}
