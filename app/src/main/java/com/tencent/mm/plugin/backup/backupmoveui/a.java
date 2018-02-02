package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashSet;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    BackupMoveChooseUI kma;
    HashSet<Integer> kmb;
    boolean kmc = false;

    public final /* synthetic */ Object getItem(int i) {
        return mG(i);
    }

    public a(BackupMoveChooseUI backupMoveChooseUI) {
        this.kma = backupMoveChooseUI;
        this.kmb = new HashSet();
        this.kmc = false;
    }

    public final int getCount() {
        LinkedList aoN = b.aoR().aoV().aoN();
        if (aoN != null) {
            return aoN.size();
        }
        return 0;
    }

    private static f.b mG(int i) {
        return (f.b) b.aoR().aoV().aoN().get(i);
    }

    public final long getItemId(int i) {
        return -1;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.kma.getLayoutInflater().inflate(R.i.daS, viewGroup, false);
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
        aVar.kme.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a kmd;

            public final void onClick(View view) {
                if (this.kmd.kmb.contains(Integer.valueOf(i))) {
                    this.kmd.kmb.remove(Integer.valueOf(i));
                } else {
                    this.kmd.kmb.add(Integer.valueOf(i));
                }
                this.kmd.notifyDataSetChanged();
                this.kmd.kma.a(this.kmd.kmb);
            }
        });
        f.b mG = mG(i);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.iip, mG.kiP);
        if (s.eV(mG.kiP)) {
            aVar.iiq.setText(i.b(this.kma, r.L(mG.kiP, mG.kiP), aVar.iiq.getTextSize()));
        } else {
            aVar.iiq.setText(i.b(this.kma, r.gu(mG.kiP), aVar.iiq.getTextSize()));
        }
        if (this.kmb.contains(Integer.valueOf(i))) {
            aVar.iis.setChecked(true);
        } else {
            aVar.iis.setChecked(false);
        }
        return view;
    }
}
