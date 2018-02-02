package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

class a$1 implements OnClickListener {
    final /* synthetic */ a vsY;

    a$1(a aVar) {
        this.vsY = aVar;
    }

    public final void onClick(View view) {
        View inflate = View.inflate(a.a(this.vsY), R.i.drP, null);
        ((TextView) inflate.findViewById(R.h.cLB)).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.h.cZH);
        textView.setVisibility(0);
        textView.setText("50");
        EditText editText = (EditText) inflate.findViewById(R.h.cLA);
        editText.setSingleLine(false);
        c.d(editText).GN(100).a(null);
        editText.addTextChangedListener(new 1(this, textView));
        h.a(a.a(this.vsY), a.a(this.vsY).getString(R.l.dGu), inflate, new 2(this, editText), null);
        editText.post(new 3(this));
    }
}
