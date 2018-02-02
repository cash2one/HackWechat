package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f {
    public static View g(RecyclerView recyclerView, int i) {
        if (recyclerView == null) {
            return null;
        }
        View bc;
        try {
            h hVar = recyclerView.TV;
            if (hVar instanceof LinearLayoutManager) {
                bc = ((LinearLayoutManager) hVar).bc(i);
                return bc;
            }
        } catch (Exception e) {
        }
        bc = null;
        return bc;
    }

    public static c cW(View view) {
        if (view == null) {
            return null;
        }
        WXRTEditText wXRTEditText = (WXRTEditText) view.findViewById(R.h.cIC);
        WXRTEditText wXRTEditText2 = (WXRTEditText) view.findViewById(R.h.bPb);
        WXRTEditText wXRTEditText3 = (WXRTEditText) view.findViewById(R.h.bOZ);
        c cVar = wXRTEditText != null ? new c(wXRTEditText) : (wXRTEditText2 == null || wXRTEditText3 == null) ? null : new c(wXRTEditText2, wXRTEditText3);
        return cVar;
    }
}
