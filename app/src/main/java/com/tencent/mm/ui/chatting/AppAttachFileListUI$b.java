package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.AppAttachFileListUI.c;
import com.tencent.mm.ui.chatting.AppAttachFileListUI.d;
import com.tencent.mm.z.r;
import junit.framework.Assert;

class AppAttachFileListUI$b extends BaseAdapter {
    final /* synthetic */ AppAttachFileListUI ypG;

    private AppAttachFileListUI$b(AppAttachFileListUI appAttachFileListUI) {
        this.ypG = appAttachFileListUI;
    }

    public final int getCount() {
        return AppAttachFileListUI.a(this.ypG).size();
    }

    public final Object getItem(int i) {
        return AppAttachFileListUI.a(this.ypG).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        String str;
        if (view == null) {
            view = this.ypG.getLayoutInflater().inflate(R.i.daj, viewGroup, false);
            Assert.assertNotNull(view);
            dVar = new d(this.ypG, (byte) 0);
            dVar.ypI = (MMImageView) view.findViewById(R.h.chJ);
            dVar.ypJ = (TextView) view.findViewById(R.h.chL);
            dVar.ypK = (TextView) view.findViewById(R.h.chI);
            dVar.ypL = (TextView) view.findViewById(R.h.chK);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        Assert.assertNotNull(dVar);
        c cVar = (c) AppAttachFileListUI.a(this.ypG).get(i);
        dVar.ypJ.setText(cVar.ypH.title);
        if (cVar.fEJ.field_isSend == 1) {
            str = "自己";
        } else {
            str = r.gu(cVar.ypH.fzO);
        }
        dVar.ypK.setText(String.format("大小：%s，来自：%s", new Object[]{bh.bx((long) cVar.ypH.hbb), str}));
        dVar.ypL.setText(n.c(this.ypG, cVar.fEJ.field_createTime, true));
        dVar.ypI.setImageResource(com.tencent.mm.pluginsdk.model.r.Ry(cVar.ypH.hbc));
        return view;
    }
}
