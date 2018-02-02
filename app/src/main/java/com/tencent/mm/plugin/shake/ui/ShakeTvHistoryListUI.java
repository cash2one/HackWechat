package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.l;
import java.util.GregorianCalendar;

public class ShakeTvHistoryListUI extends MMActivity {
    private d kBR = new 5(this);
    private a qst;
    private ListView qsu;
    private String username;

    class a extends o<n> {
        private LayoutInflater DF;
        final /* synthetic */ ShakeTvHistoryListUI qsv;

        class a {
            TextView jJn;
            TextView oid;
            MMImageView qsx;
            final /* synthetic */ a qsy;

            a(a aVar) {
                this.qsy = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (n) obj;
            if (obj == null) {
                obj = new n();
            }
            obj.b(cursor);
            return obj;
        }

        public a(ShakeTvHistoryListUI shakeTvHistoryListUI, Context context) {
            this.qsv = shakeTvHistoryListUI;
            super(context, new n());
            this.DF = LayoutInflater.from(context);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            if (view == null) {
                view = this.DF.inflate(R.i.dsv, viewGroup, false);
                aVar = new a(this);
                aVar.qsx = (MMImageView) view.findViewById(R.h.cNA);
                aVar.jJn = (TextView) view.findViewById(R.h.cNC);
                aVar.oid = (TextView) view.findViewById(R.h.cNB);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            n nVar = (n) getItem(i);
            e.a(aVar.qsx, nVar.field_iconurl, 0, true);
            aVar.jJn.setText(nVar.field_title);
            TextView textView = aVar.oid;
            Context context = this.qsv.mController.xIM;
            long j = nVar.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? com.tencent.mm.pluginsdk.h.n.ag(context.getString(R.l.eiK), j / 1000) : context.getString(R.l.eiV);
                } else {
                    charSequence = com.tencent.mm.pluginsdk.h.n.ag(context.getString(R.l.eiQ), j / 1000);
                }
            }
            textView.setText(charSequence);
            return view;
        }

        public final void Xy() {
            setCursor(m.brE().bsi());
            super.notifyDataSetChanged();
        }

        protected final void Xz() {
            Xy();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        this.qst.aUn();
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.ePb);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI qsv;

            {
                this.qsv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qsv.aWs();
                this.qsv.finish();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dEo), new 2(this));
        this.qsu = (ListView) findViewById(R.h.cND);
        this.qst = new a(this, this);
        this.qsu.setAdapter(this.qst);
        this.qsu.setOnItemClickListener(new 3(this));
        this.qsu.setOnItemLongClickListener(new 4(this, new l(this)));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.qst.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEw);
    }

    protected final int getLayoutId() {
        return R.i.dsw;
    }
}
