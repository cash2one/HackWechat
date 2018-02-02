package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.ui.contact.a.a.b;

public class e$b extends b {
    final /* synthetic */ e yVr;

    public e$b(e eVar) {
        this.yVr = eVar;
        super(eVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.ey(context)) {
            inflate = LayoutInflater.from(context).inflate(a$f.qfz, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(a$f.qfy, viewGroup, false);
        }
        e.a aVar = this.yVr.yVq;
        aVar.iip = (ImageView) inflate.findViewById(e.bLL);
        aVar.kBH = (TextView) inflate.findViewById(e.cSu);
        aVar.iir = (TextView) inflate.findViewById(e.caS);
        aVar.iir.setVisibility(8);
        aVar.iis = (CheckBox) inflate.findViewById(e.cKI);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        e eVar = (e) aVar2;
        e.a aVar3 = (e.a) aVar;
        if (this.yVr.yVo == 0 || this.yVr.yVn == null) {
            com.tencent.mm.plugin.fts.d.e.a(eVar.iil, aVar3.kBH);
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.iip, eVar.username);
            if (this.yVr.ySW) {
                if (z) {
                    aVar3.iis.setChecked(true);
                    aVar3.iis.setEnabled(false);
                } else {
                    aVar3.iis.setChecked(z2);
                    aVar3.iis.setEnabled(true);
                }
                aVar3.iis.setVisibility(0);
                return;
            }
            aVar3.iis.setVisibility(8);
            return;
        }
        aVar3.iip.setImageResource(this.yVr.yVo);
        aVar3.kBH.setText(this.yVr.yVn);
    }

    public final boolean WS() {
        return false;
    }
}
