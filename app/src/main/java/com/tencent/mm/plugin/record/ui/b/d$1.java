package com.tencent.mm.plugin.record.ui.b;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.ui.widget.i;

class d$1 implements OnLongClickListener {
    final /* synthetic */ b pGJ;
    final /* synthetic */ d pGS;

    d$1(d dVar, b bVar) {
        this.pGS = dVar;
        this.pGJ = bVar;
    }

    public final boolean onLongClick(View view) {
        final TextView textView = (TextView) view;
        CharSequence spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new BackgroundColorSpan(this.pGS.context.getResources().getColor(R.e.bsY)), 0, textView.getText().length(), 33);
        textView.setText(spannableString);
        i iVar = new i(this.pGS.context, textView);
        iVar.zum = new 1(this);
        iVar.rKD = new 2(this, textView);
        iVar.znd = new OnDismissListener(this) {
            final /* synthetic */ d$1 pGT;

            public final void onDismiss() {
                textView.setText(this.pGT.pGJ.fve.desc);
                com.tencent.mm.pluginsdk.ui.d.i.f(textView, 1);
            }
        };
        if (view.getTag(R.h.cSF) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(R.h.cSF);
            iVar.bQ(iArr[0], iArr[1]);
        } else {
            iVar.bQ(this.pGS.kGp, this.pGS.kGq);
        }
        return true;
    }
}
