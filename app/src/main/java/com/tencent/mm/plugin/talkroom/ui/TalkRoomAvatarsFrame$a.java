package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.LinkedList;
import java.util.List;

class TalkRoomAvatarsFrame$a extends BaseAdapter {
    private Context mContext;
    String nTT;
    List<String> scC = new LinkedList();

    public TalkRoomAvatarsFrame$a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.scC.size();
    }

    public final Object getItem(int i) {
        return this.scC.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str = (String) this.scC.get(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dsW, null);
            a aVar2 = new a(this);
            aVar2.iip = (ImageView) view.findViewById(R.h.crU);
            aVar2.kBH = (TextView) view.findViewById(R.h.cTp);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.iip.setBackgroundResource(str.equals(this.nTT) ? R.g.bGD : 0);
        aVar.kBH.setVisibility(8);
        b.b(aVar.iip, str, true);
        return view;
    }
}
