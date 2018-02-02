package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView Fv;
    private MRecyclerView jLT;

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final t a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(t tVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    protected final int getLayoutId() {
        return h.ixl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Fv = (ListView) findViewById(g.ivR);
        this.jLT = (MRecyclerView) findViewById(g.ivL);
        this.Fv.setAdapter(new b(getLayoutInflater()));
        this.Fv.setOnItemClickListener(new 1(this));
        this.jLT.a(new LinearLayoutManager(1, false));
        this.jLT.a(new a());
        this.jLT.addHeaderView(getLayoutInflater().inflate(h.ixk, null));
    }
}
