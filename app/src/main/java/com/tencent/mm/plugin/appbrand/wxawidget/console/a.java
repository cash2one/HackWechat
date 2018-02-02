package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.support.v7.widget.RecyclerView$t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a {
    private static final SimpleDateFormat khp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    LayoutInflater DF;
    List<LogInfo> khq = new LinkedList();

    a(Context context) {
        this.DF = LayoutInflater.from(context);
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new a(this.DF.inflate(c.khd, viewGroup, false), i);
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        LogInfo logInfo = (LogInfo) this.khq.get(i);
        ((a) recyclerView$t).inu.setText(String.format("[%s] %s", new Object[]{khp.format(new Date(logInfo.hjC)), logInfo.message}));
    }

    public final int getItemCount() {
        return this.khq.size();
    }

    public final int getItemViewType(int i) {
        return ((LogInfo) this.khq.get(i)).level;
    }
}
