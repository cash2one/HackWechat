package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;

class z$2 implements b {
    final /* synthetic */ z yCg;

    z$2(z zVar) {
        this.yCg = zVar;
    }

    public final void a(Boolean bool, Boolean bool2) {
        if (!bool.booleanValue()) {
            return;
        }
        if (bool2.booleanValue()) {
            this.yCg.c(Boolean.valueOf(true), Boolean.valueOf(true));
        } else {
            this.yCg.c(Boolean.valueOf(false), Boolean.valueOf(true));
        }
    }

    public final void b(Boolean bool, Boolean bool2) {
        if (!bool.booleanValue()) {
            return;
        }
        if (bool2.booleanValue()) {
            this.yCg.c(Boolean.valueOf(true), Boolean.valueOf(false));
        } else {
            this.yCg.c(Boolean.valueOf(false), Boolean.valueOf(false));
        }
    }
}
