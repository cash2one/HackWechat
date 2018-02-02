package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.chatting.ChattingUI;

public final class h {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ ChattingUI yzI;

        public AnonymousClass2(ChattingUI chattingUI) {
            this.yzI = chattingUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.yzI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    static class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ ChattingUI yzI;

        public AnonymousClass6(ChattingUI chattingUI) {
            this.yzI = chattingUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.yzI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    static class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ ChattingUI yzI;

        public AnonymousClass8(ChattingUI chattingUI) {
            this.yzI = chattingUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.yzI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    static class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ ChattingUI yzI;

        public AnonymousClass9(ChattingUI chattingUI) {
            this.yzI = chattingUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.yzI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }
}
