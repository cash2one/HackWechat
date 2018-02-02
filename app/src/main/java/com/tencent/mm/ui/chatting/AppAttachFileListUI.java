package com.tencent.mm.ui.chatting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a {
    private OnItemClickListener kGC = new 2(this);
    private OnScrollListener lgq = new OnScrollListener(this) {
        final /* synthetic */ AppAttachFileListUI ypG;

        {
            this.ypG = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && !this.ypG.ypD && this.ypG.ypC && absListView.getLastVisiblePosition() == this.ypG.ypB.getCount()) {
                x.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = this.ypG.ypF;
                new a().execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(this.ypG);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ListView ypA;
    private b ypB;
    private boolean ypC = true;
    private boolean ypD = false;
    private View ypE;
    private int ypF;
    private ArrayList<c> ypy;
    private HashSet<Long> ypz;

    private class a extends AsyncTask<Integer, Integer, List<au>> {
        final /* synthetic */ AppAttachFileListUI ypG;

        private a(AppAttachFileListUI appAttachFileListUI) {
            this.ypG = appAttachFileListUI;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String FS = q.FS();
            ar.Hg();
            List K = c.Fa().K(FS, intValue, intValue2);
            this.ypG.ypF = intValue2 + this.ypG.ypF;
            return K;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(this.ypG);
            this.ypG.da(list);
            this.ypG.ypB.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        x.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.ypD = true;
        appAttachFileListUI.ypE.setVisibility(0);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        appAttachFileListUI.ypD = false;
        appAttachFileListUI.ypE.setVisibility(8);
        x.d("MicroMsg.AppAttachFileListUI", "stop to load");
    }

    protected final int getLayoutId() {
        return R.i.dak;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ehm);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachFileListUI ypG;

            {
                this.ypG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ypG.finish();
                return true;
            }
        });
        this.ypA = (ListView) findViewById(R.h.chM);
        this.ypE = getLayoutInflater().inflate(R.i.dai, null);
        this.ypA.addFooterView(this.ypE);
        this.ypE.setVisibility(8);
        this.ypy = new ArrayList();
        this.ypz = new HashSet();
        String FS = q.FS();
        ar.Hg();
        List K = c.Fa().K(FS, 0, 20);
        this.ypF += 20;
        da(K);
        this.ypB = new b(this, (byte) 0);
        this.ypA.setAdapter(this.ypB);
        this.ypA.setOnItemClickListener(this.kGC);
        this.ypA.setOnScrollListener(this.lgq);
        ar.Hg();
        c.Fa().a(this, getMainLooper());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ar.Hg();
        c.Fa().a(this);
        super.onDestroy();
    }

    private void da(List<au> list) {
        if (list.size() < 20) {
            this.ypC = false;
            this.ypA.removeFooterView(this.ypE);
        }
        for (au auVar : list) {
            c ag = ag(auVar);
            if (ag != null && ag.ypH.type == 6 && this.ypz.add(Long.valueOf(auVar.field_msgId))) {
                this.ypy.add(ag);
            }
        }
        x.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(this.ypy.size())});
    }

    private c ag(au auVar) {
        g$a fT = g$a.fT(auVar.field_content);
        if (fT == null) {
            return null;
        }
        c cVar = new c(this, (byte) 0);
        cVar.fEJ = auVar;
        cVar.ypH = fT;
        return cVar;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        if ("insert".equals(cVar2.ooU)) {
            x.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar2.ooV.size() - 1; size >= 0; size--) {
                au auVar = (au) cVar2.ooV.get(size);
                if (auVar.aNc()) {
                    c ag = ag(auVar);
                    if (ag != null && ag.ypH.type == 6) {
                        this.ypy.add(0, ag);
                    }
                }
            }
            if (this.ypB != null) {
                this.ypB.notifyDataSetChanged();
            }
        }
    }
}
