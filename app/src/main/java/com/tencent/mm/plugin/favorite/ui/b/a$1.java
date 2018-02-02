package com.tencent.mm.plugin.favorite.ui.b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;

class a$1 implements OnCheckedChangeListener {
    final /* synthetic */ a mxN;

    a$1(a aVar) {
        this.mxN = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getTag() != null) {
            f fVar = (f) compoundButton.getTag();
            if (z) {
                this.mxN.mxM.muq.put(Long.valueOf(fVar.field_localId), h.getFavItemInfoStorage().db(fVar.field_localId));
            } else {
                this.mxN.mxM.muq.remove(Long.valueOf(fVar.field_localId));
            }
            if (this.mxN.mxM.mxO != null) {
                this.mxN.mxM.mxO.dq(fVar.field_localId);
            }
        }
    }
}
