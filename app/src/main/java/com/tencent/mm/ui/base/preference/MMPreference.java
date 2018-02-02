package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public abstract class MMPreference extends MMActivity {
    public SharedPreferences gZO;
    private boolean mpK = false;
    public ListView nKG;
    private boolean sdn = false;
    public h yjd;
    protected RelativeLayout yje;
    protected TextView yjf;
    protected ImageView yjg;

    public abstract int XB();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return h.cwn;
    }

    public boolean XA() {
        return true;
    }

    public void onResume() {
        if (XA()) {
            this.yjd.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gZO = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.yjd = a(this.gZO);
        this.nKG = (ListView) findViewById(16908298);
        this.yje = (RelativeLayout) findViewById(g.gWb);
        this.yjf = (TextView) findViewById(g.gWa);
        this.yjg = (ImageView) findViewById(g.gVZ);
        int asz = asz();
        if (asz != -1) {
            this.nKG.addHeaderView(getLayoutInflater().inflate(asz, null));
        }
        View avu = avu();
        if (avu != null) {
            if (avu.getLayoutParams() != null) {
                avu.setLayoutParams(new LayoutParams(avu.getLayoutParams()));
            } else {
                x.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.nKG.addFooterView(avu);
        }
        View bqw = bqw();
        if (bqw != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(g.gVY);
            frameLayout.addView(bqw);
            frameLayout.setVisibility(0);
        }
        this.yjd.b(new 1(this));
        asz = XB();
        if (asz != -1) {
            this.yjd.addPreferencesFromResource(asz);
        }
        this.nKG.setAdapter(this.yjd);
        this.nKG.setOnItemClickListener(new 2(this));
        this.nKG.setOnItemLongClickListener(new 3(this));
        this.nKG.setOnScrollListener(new 4(this));
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean cqp() {
        return false;
    }

    public final void setSelection(int i) {
        this.nKG.setSelection(i);
    }

    public int asz() {
        return -1;
    }

    public View avu() {
        return null;
    }

    public View bqw() {
        return null;
    }

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, sharedPreferences);
    }
}
