package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.u;
import com.tencent.mm.w.a.h;

public abstract class i extends u {
    private SharedPreferences gZO;
    private boolean mpK = false;
    private ListView nKG;
    private boolean sdn = false;
    private long ttl;
    public h yjd;
    public boolean yjv;

    public abstract int XB();

    public abstract boolean a(f fVar, Preference preference);

    protected int getLayoutId() {
        return h.dnT;
    }

    protected View getLayoutView() {
        return b.DY().a(getContext(), "R.layout.mm_preference_fragment_list_content", h.dnT);
    }

    public void onResume() {
        super.onResume();
        this.yjd.notifyDataSetChanged();
        this.ttl = System.currentTimeMillis();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.yjv = false;
        this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.yjd = new h(getContext(), this.gZO);
        this.nKG = (ListView) findViewById(16908298);
        this.yjd.b(new 1(this));
        this.nKG.setAdapter(this.yjd);
        this.nKG.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ i yjw;

            {
                this.yjw = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.yjw.nKG.getHeaderViewsCount()) {
                    x.i("MicroMsg.mmui.MMPreference", "click after resume %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.yjw.ttl)});
                    if (System.currentTimeMillis() - this.yjw.ttl < 400) {
                        x.w("MicroMsg.mmui.MMPreference", "too quick click after resume, ignore");
                        return;
                    }
                    Preference preference = (Preference) this.yjw.yjd.getItem(i - this.yjw.nKG.getHeaderViewsCount());
                    if (preference.isEnabled() && preference.yjG && !(preference instanceof CheckBoxPreference)) {
                        if (preference instanceof DialogPreference) {
                            DialogPreference dialogPreference = (DialogPreference) preference;
                            dialogPreference.showDialog();
                            dialogPreference.yid = new 1(this, dialogPreference, preference);
                        }
                        if (preference instanceof EditPreference) {
                            EditPreference editPreference = (EditPreference) preference;
                            editPreference.showDialog();
                            editPreference.yif = new 2(this, editPreference, preference);
                        }
                        if (preference.ibD != null) {
                            this.yjw.a(this.yjw.yjd, preference);
                        }
                    }
                }
            }
        });
        this.nKG.setOnItemLongClickListener(new 3(this));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean cqp() {
        return false;
    }
}
