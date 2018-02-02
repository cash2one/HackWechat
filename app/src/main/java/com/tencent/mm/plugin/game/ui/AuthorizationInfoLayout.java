package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class AuthorizationInfoLayout extends LinearLayout {
    private Context mContext;
    private ArrayList<String> nkG;

    public AuthorizationInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public final void C(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            x.i("MicroMsg.AuthorizationInfoLayout", "authinfo is null or nill");
            return;
        }
        this.nkG = arrayList;
        Iterator it = this.nkG.iterator();
        while (it.hasNext()) {
            addView(new a(this.mContext, (String) it.next()));
        }
    }
}
