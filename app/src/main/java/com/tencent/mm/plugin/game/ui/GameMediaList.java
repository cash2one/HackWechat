package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements OnClickListener {
    String appId = "";
    Context mContext;
    int mfA = -1;
    int nqL = 0;
    int nsT;
    private LinkedList<String> nsU;

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void R(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            return;
        }
        this.nsU = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            a aVar = (a) linkedList.get(i);
            if (!bh.ov(aVar.url) && aVar.type == 0) {
                this.nsU.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar2 = (a) linkedList.get(i2);
            if (!bh.ov(aVar2.nsV)) {
                View inflate = layoutInflater.inflate(this.nsT, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cvF);
                a PA = o.PA();
                String str = aVar2.nsV;
                c.a aVar3 = new c.a();
                aVar3.hDz = true;
                PA.a(str, imageView, aVar3.PK());
                if (aVar2.type == 1) {
                    inflate.findViewById(R.h.cvB).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            x.i("MicroMsg.GameMediaList", "Invalid tag");
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.nsU.indexOf(aVar.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.nsU.size()];
                this.nsU.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.mfA);
                intent.putExtra("SOURCE_SCENE", this.nqL);
                getContext().startActivity(intent);
                return;
            case 1:
                com.tencent.mm.plugin.game.d.c.ac(getContext(), aVar.url);
                ap.a(this.mContext, this.mfA, 1202, 1, 13, this.appId, this.nqL, null);
                return;
            default:
                return;
        }
    }
}
