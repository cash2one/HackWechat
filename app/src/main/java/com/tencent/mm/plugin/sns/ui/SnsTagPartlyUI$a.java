package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;

class SnsTagPartlyUI$a extends o<s> {
    private Context context;
    final /* synthetic */ SnsTagPartlyUI rHh;
    public boolean rHj = false;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (s) obj;
        if (obj == null) {
            obj = new s();
            x.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
        }
        obj.b(cursor);
        return obj;
    }

    public SnsTagPartlyUI$a(SnsTagPartlyUI snsTagPartlyUI, Context context) {
        this.rHh = snsTagPartlyUI;
        super(context, new s());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, g.qGE, null);
            aVar.rHk = (TextView) view.findViewById(f.qFG);
            aVar.rHl = (TextView) view.findViewById(f.qFu);
            aVar.lgD = (Button) view.findViewById(f.bBE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (qY(i)) {
            aVar.rHk.setText(j.qMP);
            aVar.rHl.setVisibility(8);
            aVar.lgD.setVisibility(8);
        } else {
            int i2;
            s sVar = (s) getItem(i);
            aVar.rHk.setText(sVar.field_tagName);
            aVar.rHl.setVisibility(0);
            aVar.rHl.setText(" (" + sVar.field_count + ") ");
            Button button = aVar.lgD;
            if (this.rHj) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            button.setVisibility(i2);
            aVar.lgD.setOnClickListener(SnsTagPartlyUI.b(this.rHh));
            aVar.lgD.setTag(Integer.valueOf(i));
        }
        return view;
    }

    public final void Xy() {
        setCursor(ae.bvB().getCursor());
        notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    protected final int aRF() {
        return 1;
    }
}
