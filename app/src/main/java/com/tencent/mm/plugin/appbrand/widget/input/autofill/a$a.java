package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.input.b.a.b;

final class a$a implements OnClickListener {
    View VU;
    View iiS;
    final /* synthetic */ a jZV;
    TextView jZW;
    TextView jZX;
    View jZY;
    b jZZ;

    a$a(a aVar, View view) {
        this.jZV = aVar;
        this.VU = view;
        this.jZW = (TextView) view.findViewById(q$g.title);
        this.jZX = (TextView) view.findViewById(q$g.content);
        this.jZY = view.findViewById(q$g.ivo);
        this.iiS = view.findViewById(q$g.divider);
        view.setBackgroundResource(f.bEJ);
        view.setOnClickListener(this);
        this.jZY.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.jZZ == null) {
            return;
        }
        if (view.getId() == q$g.ivo) {
            this.jZV.remove(this.jZZ);
            if (a.a(this.jZV) != null) {
                a.a(this.jZV).a(this.jZZ.id, h$a.DELETE);
            }
        } else if (view == this.VU && a.a(this.jZV) != null) {
            if (this.jZZ != null) {
                a.a(this.jZV).a(this.jZZ.id, h$a.SELECT);
            }
            a.c(this.jZV);
            if (a.d(this.jZV) != null) {
                a.d(this.jZV).kaa.getView().clearFocus();
            }
        }
    }
}
