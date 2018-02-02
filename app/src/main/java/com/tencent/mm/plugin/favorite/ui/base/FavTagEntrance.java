package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class FavTagEntrance extends LinearLayout implements a {
    private long fCb = -1;
    private TextView mvl;
    private String mvm = String.valueOf(this.fCb);

    public FavTagEntrance(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mvl = (TextView) findViewById(R.h.cQc);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavTagEntrance mvn;

            {
                this.mvn = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.mvn.getContext(), FavTagEditUI.class);
                intent.putExtra("key_fav_scene", 1);
                intent.putExtra("key_fav_item_id", this.mvn.fCb);
                this.mvn.getContext().startActivity(intent);
            }
        });
    }

    public final void ds(long j) {
        this.fCb = j;
        this.mvm = String.valueOf(j);
    }

    public final void aN(List<String> list) {
        if (this.mvl != null) {
            CharSequence a = j.a(getContext(), list);
            if (bh.ov(a)) {
                this.mvl.setText("");
                this.mvl.setHint(R.l.efc);
                return;
            }
            this.mvl.setText(i.b(getContext(), a, this.mvl.getTextSize()));
        }
    }

    public final void a(String str, l lVar) {
        x.d("MicroMsg.FavTagEntrence", "on notify change event %s, favIDStr %s", new Object[]{str, this.mvm});
        if (this.mvm.equals(str)) {
            f db = h.getFavItemInfoStorage().db(this.fCb);
            if (db == null) {
                x.w("MicroMsg.FavTagEntrence", "id[%d] info is null, return", new Object[]{Long.valueOf(this.fCb)});
                return;
            }
            aN(db.field_tagProto.wfj);
        }
    }
}
