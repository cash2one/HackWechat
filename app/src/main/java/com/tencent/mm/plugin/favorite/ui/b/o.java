package com.tencent.mm.plugin.favorite.ui.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.protocal.c.vg;

public final class o extends a {
    public o(h hVar) {
        super(hVar);
    }

    public final View a(View view, ViewGroup viewGroup, f fVar) {
        return new View(viewGroup.getContext());
    }

    public final void a(View view, vg vgVar) {
        if (view != null) {
            Toast.makeText(view.getContext(), R.l.egQ, 0).show();
        }
    }
}
