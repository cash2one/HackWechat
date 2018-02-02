package com.tencent.mm.plugin.game.gamewebview.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bh.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private TextView ihS;
    private ImageView jNs;

    public c(Context context) {
        super(context);
        if (this.view != null) {
            this.ihS = (TextView) this.view.findViewById(R.h.cns);
            this.jNs = (ImageView) this.view.findViewById(R.h.cnr);
            this.view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c mXL;

                {
                    this.mXL = r1;
                }

                public final void onClick(View view) {
                    a aVar = a.hZm;
                    String Vc = a.Vc();
                    if (!bh.ov(Vc)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", Vc);
                        intent.putExtra("is_from_keep_top", true);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        d.b((Context) this.mXL.voC.get(), "game", ".gamewebview.ui.GameWebViewUI", intent);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.cnt;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cnt).setVisibility(i);
        }
    }

    public final boolean alg() {
        x.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible");
        a aVar = a.hZm;
        if (a.Vb()) {
            x.i("MicroMsg.GameWebViewBanner", "refreshAndReturnIsVisible, VISIBLE");
            aVar = a.hZm;
            CharSequence Vd = a.Vd();
            if (this.ihS != null) {
                this.ihS.setText(Vd);
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
