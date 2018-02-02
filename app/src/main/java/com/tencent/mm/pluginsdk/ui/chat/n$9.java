package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.Set;

class n$9 implements b {
    final /* synthetic */ n vsx;

    n$9(n nVar) {
        this.vsx = nVar;
    }

    public final void caC() {
        n.a(this.vsx, System.currentTimeMillis());
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[]{Long.valueOf(n.l(this.vsx))});
        x.d("VOICEDEBUG", "Start Record Time = %s", new Object[]{Long.valueOf(n.l(this.vsx))});
        n.b(this.vsx, false);
        n.c(this.vsx, true);
        n.d(this.vsx, true);
        n.b(this.vsx, 0);
        n.m(this.vsx);
        n.h(this.vsx);
        n.n(this.vsx).setVisibility(8);
        n.c(this.vsx, false);
        n.g(this.vsx).vlW = 3;
        n.g(this.vsx).b(n.f(this.vsx));
        n.ccf();
        if (n.f(this.vsx) != null) {
            if (n.f(this.vsx).getText() != null && n.f(this.vsx).getText().length() > 0) {
                n.f(this.vsx).setCursorVisible(true);
            }
            n.f(this.vsx).requestFocus();
            bh.hideVKB(n.k(this.vsx));
        }
        if (n.o(this.vsx) instanceof Activity) {
            ((Activity) n.o(this.vsx)).getWindow().addFlags(FileUtils.S_IWUSR);
        }
        n.p(this.vsx).setVisibility(4);
        n.q(this.vsx).setVisibility(4);
        n.r(this.vsx).setVisibility(8);
        n.f(this.vsx).setHint(this.vsx.getResources().getString(R.l.eTu));
        n.j(this.vsx).ky(true);
    }

    public final void caD() {
        n.j(this.vsx).ky(false);
        n.f(this.vsx).setHint(null);
    }

    public final void caE() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
        n.s(this.vsx);
        n.g(this.vsx).a(n.f(this.vsx));
        n.h(this.vsx);
        if (n.o(this.vsx) instanceof Activity) {
            ((Activity) n.o(this.vsx)).getWindow().clearFlags(FileUtils.S_IWUSR);
        }
        n.Cs(2);
        n.j(this.vsx).ky(false);
        n.f(this.vsx).setHint(null);
    }

    public final void caF() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        n.g(this.vsx).a(n.f(this.vsx));
        n.h(this.vsx);
        if (n.o(this.vsx) instanceof Activity) {
            ((Activity) n.o(this.vsx)).getWindow().clearFlags(FileUtils.S_IWUSR);
        }
        n.Cs(3);
        n.j(this.vsx).ky(false);
        n.f(this.vsx).setHint(null);
    }

    public final void caG() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
        n.s(this.vsx);
        n.g(this.vsx).a(n.f(this.vsx));
        n.h(this.vsx);
        if (n.o(this.vsx) instanceof Activity) {
            ((Activity) n.o(this.vsx)).getWindow().clearFlags(FileUtils.S_IWUSR);
        }
        n.c(this.vsx, 1);
        n.j(this.vsx).ky(false);
        n.f(this.vsx).setHint(null);
    }

    public final void b(String[] strArr, Set<String> set) {
        if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
            if (n.t(this.vsx)) {
                n.d(this.vsx, false);
                n.u(this.vsx);
            }
            n.g(this.vsx).a(n.f(this.vsx), strArr[0], true);
            if (n.f(this.vsx).getText().length() != 0) {
                n.f(this.vsx).setCursorVisible(true);
                n.f(this.vsx).requestFocus();
                bh.hideVKB(n.k(this.vsx));
            }
            if (!(n.v(this.vsx) || strArr[0].length() == 0)) {
                n.b(this.vsx, true);
                n.b(this.vsx, System.currentTimeMillis());
                x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.w(this.vsx) - n.l(this.vsx))});
            }
            n.x(this.vsx).addAll(set);
        }
    }

    public final void af(int i, int i2, int i3) {
        x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())});
        n.s(this.vsx);
        n.g(this.vsx).a(n.f(this.vsx));
        n.h(this.vsx);
        if (n.o(this.vsx) instanceof Activity) {
            ((Activity) n.o(this.vsx)).getWindow().clearFlags(FileUtils.S_IWUSR);
        }
        n.c(this.vsx, i);
        if (i == 12) {
            n.b(this.vsx, R.l.eTv);
        } else {
            n.b(this.vsx, R.l.dEP);
        }
        n.j(this.vsx).ky(false);
        n.f(this.vsx).setHint(null);
    }
}
