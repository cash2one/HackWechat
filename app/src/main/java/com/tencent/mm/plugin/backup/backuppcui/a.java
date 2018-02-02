package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    static boolean koj = false;
    HashSet<Integer> kmb = new HashSet();
    BackupPcChooseUI koi;

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public a(BackupPcChooseUI backupPcChooseUI) {
        this.koi = backupPcChooseUI;
        koj = false;
    }

    public final int getCount() {
        LinkedList aoN = b.aps().apw().aoN();
        if (aoN != null) {
            return aoN.size();
        }
        return 0;
    }

    private static String kC(int i) {
        LinkedList aoN = b.aps().apw().aoN();
        return aoN.get(i) == null ? null : ((f.b) aoN.get(i)).kiP;
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.koi.getLayoutInflater().inflate(R.i.daQ, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.iip = (ImageView) view.findViewById(R.h.bLL);
            aVar2.iiq = (TextView) view.findViewById(R.h.cSu);
            aVar2.iis = (CheckBox) view.findViewById(R.h.cKI);
            aVar2.kme = (RelativeLayout) view.findViewById(R.h.cKJ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kme.setOnClickListener(new 1(this, i));
        String kC = kC(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, kC);
        if (s.eV(kC)) {
            aVar.iiq.setText(i.b(this.koi, r.L(kC, kC), aVar.iiq.getTextSize()));
        } else {
            aVar.iiq.setText(i.b(this.koi, r.gu(kC), aVar.iiq.getTextSize()));
        }
        if (this.kmb.contains(Integer.valueOf(i))) {
            aVar.iis.setChecked(true);
        } else {
            aVar.iis.setChecked(false);
        }
        return view;
    }
}
