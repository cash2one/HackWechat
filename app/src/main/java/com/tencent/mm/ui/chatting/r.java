package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;

public final class r {

    public static class e implements b {
        af handler = new 1(this);
        private q inJ = null;
        private ScrollView jjn = null;
        private long pzr = 0;
        boolean rZp = false;
        private boolean rZq = false;
        int twe = 0;
        private OnTouchListener xNn = null;
        private ChattingUI$a yqa = null;
        private MMTextView ytF = null;
        private TextView ytG = null;
        private final int ytH = 3;
        private int ytI = 0;
        private int ytJ = 0;

        public e(ChattingUI$a chattingUI$a) {
            this.yqa = chattingUI$a;
        }

        public final boolean do(View view) {
            if (view.getTag() instanceof ar) {
                ar arVar = (ar) view.getTag();
                if (!((!(view instanceof TextView) && !(view instanceof MMNeatTextView)) || arVar.fEJ == null || this.yqa == null)) {
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    } else if (view instanceof MMNeatTextView) {
                        charSequence = ((MMNeatTextView) view).mText;
                    }
                    Context context = this.yqa.getContext();
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    context.startActivity(intent);
                    com.tencent.mm.ui.base.b.fF(context);
                    return true;
                }
            }
            return false;
        }
    }

    public static class l extends d {
        public l(ChattingUI$a chattingUI$a) {
            super(chattingUI$a);
        }

        public final void a(View view, ChattingUI$a chattingUI$a, au auVar) {
            h.a(chattingUI$a.getContext(), chattingUI$a.getString(R.l.dZD), "", chattingUI$a.getString(R.l.dZF), chattingUI$a.getString(R.l.dZC), new 1(this), new 2(this));
        }
    }

    public static class n {
        au fEJ;
        String hcc;
        String rYX;

        public n(String str, au auVar, String str2) {
            this.hcc = str;
            this.fEJ = auVar;
            this.rYX = str2;
        }
    }
}
