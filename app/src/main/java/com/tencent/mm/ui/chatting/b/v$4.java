package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aq.l;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.z.ar;

class v$4 implements OnClickListener {
    final /* synthetic */ v yBc;
    final /* synthetic */ boolean yBe;
    final /* synthetic */ String yBf;

    v$4(v vVar, boolean z, String str) {
        this.yBc = vVar;
        this.yBe = z;
        this.yBf = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!this.yBe || this.yBc.fhr.csB() == null || this.yBc.fhr.csB().vjC == null || !(this.yBc.fhr.csB().vjC instanceof v)) {
            ar.CG().a(new l(5, this.yBc.fhr.csv(), this.yBc.fhr.crz(), this.yBf, 0, null, 0, "", "", true, R.g.bAH), 0);
            return;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if ((d.decodeFile(this.yBf, options) == null || options.outHeight <= b.zE()) && options.outWidth <= b.zE()) {
            String a = ((c) g.k(c.class)).getEmojiMgr().a(this.yBc.fhr.csq().getContext(), new WXMediaMessage(new WXEmojiObject(this.yBf)), null);
            if (a != null) {
                ((v) this.yBc.fhr.csB().vjC).m(((c) g.k(c.class)).getEmojiMgr().yc(a));
                return;
            }
            return;
        }
        Toast.makeText(this.yBc.fhr.csq().getContext(), R.l.dZJ, 0).show();
    }
}
