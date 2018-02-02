package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.aa.a.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String fpF;
    private af hae = new af(Looper.getMainLooper());
    private c iiU = ((c) t(c.class));
    private ListView iiV;
    private TextView iiW;
    private TextView iiX;
    private View iiY;
    private TextView iiZ;
    private boolean ija = false;
    private Map<String, String> ijb = new HashMap();
    private a ijc = null;
    private double ijd;
    private long ije = -1;
    private int ijf = -1;
    private boolean ijg;
    private boolean ijh = false;
    private Runnable iji = new Runnable(this) {
        final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

        {
            this.ijj = r1;
        }

        public final void run() {
            this.ijj.Xb();
            this.ijj.Xc();
        }
    };

    static /* synthetic */ void d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        launchAAByPersonAmountSelectUI.Xb();
        launchAAByPersonAmountSelectUI.Xc();
        if (!launchAAByPersonAmountSelectUI.ijg) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.ijb.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.ijb.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
    }

    static /* synthetic */ void m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        try {
            launchAAByPersonAmountSelectUI.iiW.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(a.c.uaH));
            launchAAByPersonAmountSelectUI.ija = false;
            launchAAByPersonAmountSelectUI.ijd = 0.0d;
            launchAAByPersonAmountSelectUI.iiX.setText(launchAAByPersonAmountSelectUI.getString(a$i.uJt, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.ijd)}));
            launchAAByPersonAmountSelectUI.ijb.clear();
            launchAAByPersonAmountSelectUI.Xb();
            launchAAByPersonAmountSelectUI.Xc();
            if (launchAAByPersonAmountSelectUI.ijc != null) {
                a aVar = launchAAByPersonAmountSelectUI.ijc;
                for (b bVar : aVar.dataList) {
                    bVar.ijq = "";
                }
                aVar.notifyDataSetChanged();
            }
        } catch (Exception e) {
            x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", new Object[]{e.getMessage()});
        }
        g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(9)});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.uJu);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

            {
                this.ijj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ijj.ijb == null || this.ijj.ijb.size() <= 0) {
                    this.ijj.finish();
                } else {
                    h.a(this.ijj, this.ijj.getString(a$i.uHl), null, this.ijj.getString(a$i.uHo), this.ijj.getString(a$i.uHn), false, new 1(this), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 ijk;

                        {
                            this.ijk = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ijk.ijj.finish();
                        }
                    });
                }
                return true;
            }
        });
        a(233, getString(a$i.dFU), new OnMenuItemClickListener(this) {
            final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;

            {
                this.ijj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.ijj.ijf <= 0 || this.ijj.ijb == null || this.ijj.ijb.size() <= this.ijj.ijf) {
                    LaunchAAByPersonAmountSelectUI.d(this.ijj);
                    g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(4)});
                } else {
                    h.b(this.ijj.mController.xIM, this.ijj.getString(a$i.uJv, new Object[]{Integer.valueOf(this.ijj.ijf)}), "", true);
                    g.pQN.h(13722, new Object[]{Integer.valueOf(8)});
                }
                return true;
            }
        }, b.xJz);
        this.iiV = (ListView) findViewById(f.ueD);
        this.iiW = (TextView) findViewById(f.uhM);
        this.iiX = (TextView) findViewById(f.ueE);
        this.iiX.setText(getString(a$i.uJt, new Object[]{Float.valueOf(0.0f)}));
        this.iiY = findViewById(f.uwF);
        this.iiZ = (TextView) findViewById(f.uey);
        this.iiH = this.iiV;
        this.iiY.setVisibility(8);
        this.iiW.setOnTouchListener(new 5(this));
        this.iiW.setOnClickListener(new 6(this));
        this.ija = true;
        this.iiV.setOnScrollListener(new 7(this));
        this.fpF = getIntent().getStringExtra("chatroom");
        this.ije = getIntent().getLongExtra("maxPerAmount", -1);
        this.ijf = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        x.i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", new Object[]{this.fpF, Long.valueOf(this.ije), stringArrayListExtra});
        this.ijb = new HashMap();
        HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(bh.getDouble(split[1], 0.0d)));
                            this.ijb.put(split[0], getString(a$i.uGM, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", new Object[]{e.getMessage()});
            }
        }
        this.iiU.K(c.a.class);
        this.iiU.a(c.a.class, new 4(this, hashMap));
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void Xb() {
        try {
            this.ijd = 0.0d;
            this.ijg = false;
            if (this.ijb != null) {
                for (String str : this.ijb.values()) {
                    double d = bh.getDouble(str, 0.0d);
                    this.ijd += d;
                    if (this.ije > 0 && d * 100.0d > ((double) this.ije)) {
                        this.ijg = true;
                    }
                }
                if (this.ijc != null) {
                    a aVar = this.ijc;
                    Map map = this.ijb;
                    for (b bVar : aVar.dataList) {
                        bVar.ijq = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (b bVar2 : aVar.dataList) {
                            if (map.containsKey(bVar2.username)) {
                                bVar2.ijq = (String) map.get(bVar2.username);
                            }
                        }
                    }
                }
            }
            this.iiX.setText(getString(a$i.uJt, new Object[]{Double.valueOf(this.ijd)}));
            if (this.ijb == null || this.ijb.size() <= 0) {
                updateOptionMenuText(233, getString(a$i.dFU));
            } else {
                updateOptionMenuText(233, getString(a$i.uGT, new Object[]{Integer.valueOf(this.ijb.size())}));
            }
            if (this.ijg) {
                g.pQN.h(13722, new Object[]{Integer.valueOf(7)});
                enableOptionMenu(233, false);
                CharSequence string = getString(a$i.uJD, new Object[]{Float.valueOf(((float) this.ije) / 100.0f)});
                if (!bh.ov(string)) {
                    this.iiZ.setText(string);
                    if (!this.iiZ.isShown()) {
                        this.iiZ.startAnimation(AnimationUtils.loadAnimation(this, a.a.uao));
                        this.iiZ.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            enableOptionMenu(233, true);
            if (this.iiZ.isShown()) {
                this.iiZ.setText("");
                this.iiZ.startAnimation(AnimationUtils.loadAnimation(this, a.a.uap));
                this.iiZ.setVisibility(8);
            }
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", new Object[]{e.getMessage()});
        }
    }

    private void Xc() {
        if (this.ijd > 0.0d) {
            this.ija = true;
            this.iiW.setTextColor(getResources().getColor(a.c.brB));
            return;
        }
        this.ija = false;
        this.iiW.setTextColor(getResources().getColor(a.c.uaH));
    }

    protected final int getLayoutId() {
        return a$g.uCd;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.ijb != null) {
            this.ijb.clear();
        }
    }
}
