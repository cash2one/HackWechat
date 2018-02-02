package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.g.a.je;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class m implements l {
    Activity fAF;
    c lvr = null;
    IdleHandler xGr;
    Runnable yQE = new 10(this);
    g yWw;
    ConversationWithAppBrandListView yZE;
    c yZZ = null;
    c zaa = null;

    class AnonymousClass5 extends c<je> {
        final /* synthetic */ m zab;
        final /* synthetic */ ConversationWithAppBrandListView zae;

        AnonymousClass5(m mVar, ConversationWithAppBrandListView conversationWithAppBrandListView) {
            this.zab = mVar;
            this.zae = conversationWithAppBrandListView;
            this.xen = je.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.zae != null) {
                this.zae.setSelection(0);
            }
            return false;
        }
    }

    public final void F(String str, String str2, String str3) {
        if (this.yWw != null) {
            this.yWw.notifyDataSetChanged();
        }
    }
}
