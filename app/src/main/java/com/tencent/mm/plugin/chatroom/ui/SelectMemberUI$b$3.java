package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import java.util.Comparator;

class SelectMemberUI$b$3 implements Comparator<SelectMemberUI$a> {
    final /* synthetic */ b ldU;

    SelectMemberUI$b$3(b bVar) {
        this.ldU = bVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return c.ol(b.a(this.ldU, ((SelectMemberUI$a) obj).jLe)).compareToIgnoreCase(c.ol(b.a(this.ldU, ((SelectMemberUI$a) obj2).jLe)));
    }
}
