package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.e.c;

public final class b {

    public interface a extends c<b> {
        String WW();

        android.support.v7.widget.RecyclerView.a Zm(String str);

        g cuq();

        void cur();

        e cus();

        com.tencent.mm.pluginsdk.ui.tools.p.a cut();

        String cuu();

        <T extends h> T fM(Context context);

        int getType();
    }

    public interface b extends com.tencent.mm.ui.chatting.h.a<a> {
        void bn(String str, boolean z);

        void cuv();

        void onFinish();

        void z(boolean z, int i);
    }
}
