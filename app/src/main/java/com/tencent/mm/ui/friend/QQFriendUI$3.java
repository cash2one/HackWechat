package com.tencent.mm.ui.friend;

import com.tencent.mm.ui.friend.d.a;

class QQFriendUI$3 implements a {
    final /* synthetic */ QQFriendUI zdn;

    QQFriendUI$3(QQFriendUI qQFriendUI) {
        this.zdn = qQFriendUI;
    }

    public final void Ef(int i) {
        if (QQFriendUI.a(this.zdn)) {
            if (i > 0) {
                QQFriendUI.b(this.zdn).setVisibility(8);
            } else {
                QQFriendUI.b(this.zdn).setVisibility(0);
            }
        }
        QQFriendUI.a(this.zdn, false);
    }
}
