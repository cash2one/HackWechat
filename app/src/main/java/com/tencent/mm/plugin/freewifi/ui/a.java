package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Date;

public final class a extends b {
    private static Date mGC = null;
    private boolean hasInit = false;
    private Runnable mGD = new 2(this);

    public a(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.diI;
    }

    private void initialize() {
        if (this.view != null) {
            View findViewById = this.view.findViewById(R.h.cjS);
            if (!this.hasInit) {
                this.hasInit = true;
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a mGE;

                    {
                        this.mGE = r1;
                    }

                    public final void onClick(View view) {
                        Date date = new Date();
                        if (a.mGC == null || date.getTime() - a.mGC.getTime() >= 1000) {
                            a.mGC = date;
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_source", 2);
                            intent.addFlags(67108864);
                            d.b((Context) this.mGE.voC.get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    }
                });
                findViewById.setVisibility(8);
            }
        }
    }

    public final void destroy() {
    }

    public final boolean alg() {
        if (this.hasInit) {
            ag.K(this.mGD);
            ag.h(this.mGD, 500);
            return true;
        }
        initialize();
        return false;
    }
}
