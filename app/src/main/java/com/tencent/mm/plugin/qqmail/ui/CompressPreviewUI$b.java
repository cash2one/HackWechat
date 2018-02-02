package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import java.util.List;

class CompressPreviewUI$b extends BaseAdapter {
    final /* synthetic */ CompressPreviewUI prM;
    a prR;
    List<a> prS;

    private CompressPreviewUI$b(CompressPreviewUI compressPreviewUI) {
        this.prM = compressPreviewUI;
        this.prS = null;
    }

    public final /* synthetic */ Object getItem(int i) {
        return vc(i);
    }

    public final String bkM() {
        if (this.prR == null || this.prR.prO == null) {
            return null;
        }
        if (this.prR.prO.length() == 0) {
            return "";
        }
        int indexOf = this.prR.id.indexOf(this.prR.prO);
        if (indexOf >= 0) {
            return this.prR.id.substring(0, indexOf) + this.prR.prO;
        }
        return null;
    }

    public final int getCount() {
        return this.prS != null ? this.prS.size() : 0;
    }

    public final a vc(int i) {
        return (this.prS == null || this.prS.size() <= i) ? null : (a) this.prS.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        int SM;
        if (view == null) {
            view = View.inflate(this.prM.mController.xIM, R.i.dmO, null);
            a aVar = new a(this, (byte) 0);
            aVar.jCP = (ImageView) view.findViewById(R.h.chH);
            aVar.lgz = (TextView) view.findViewById(R.h.chN);
            aVar.prT = (TextView) view.findViewById(R.h.chO);
            aVar.prU = (ImageView) view.findViewById(R.h.chP);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        a vc = vc(i);
        if (i != 0 || bkM() == null) {
            imageView = aVar2.jCP;
            SM = vc.bkL() ? R.g.bES : FileExplorerUI.SM(vc.name);
        } else {
            imageView = aVar2.jCP;
            SM = R.g.bER;
        }
        imageView.setImageResource(SM);
        aVar2.prU.setVisibility(vc.prQ ? 0 : 4);
        aVar2.lgz.setText(vc.name);
        aVar2.prT.setText(vc.prP);
        return view;
    }
}
