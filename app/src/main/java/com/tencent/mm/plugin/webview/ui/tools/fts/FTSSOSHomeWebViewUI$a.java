package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.c;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.List;

class FTSSOSHomeWebViewUI$a extends BaseAdapter {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;
    private List<c> tDs;

    private FTSSOSHomeWebViewUI$a(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
        this.tDs = new ArrayList();
    }

    public final /* synthetic */ Object getItem(int i) {
        return AS(i);
    }

    public final void clear() {
        ag.y(new 4(this));
    }

    public final int getCount() {
        return this.tDs.size() > 6 ? 6 : this.tDs.size();
    }

    public final c AS(int i) {
        return (c) this.tDs.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this, (byte) 0);
            view = LayoutInflater.from(this.tDo.mController.xIM).inflate(R.i.dsQ, null);
            aVar2.jCP = (ImageView) view.findViewById(R.h.coO);
            aVar2.ldJ = (TextView) view.findViewById(R.h.bYS);
            aVar2.tDw = (ImageView) view.findViewById(R.h.cQg);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        c AS = AS(i);
        AS.position = i;
        if (AS.icon != 0) {
            aVar.jCP.setVisibility(0);
            aVar.jCP.setImageResource(AS.icon);
        } else {
            aVar.jCP.setVisibility(4);
        }
        if (AS.tDD != 0) {
            aVar.tDw.setVisibility(0);
            aVar.tDw.setImageResource(AS.tDD);
            aVar.tDw.setTag(AS);
            aVar.tDw.setOnClickListener(FTSSOSHomeWebViewUI.x(this.tDo));
        } else {
            aVar.tDw.setVisibility(4);
        }
        aVar.ldJ.setText(AS.content);
        return view;
    }
}
