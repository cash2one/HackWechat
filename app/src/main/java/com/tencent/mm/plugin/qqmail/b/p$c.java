package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;

public class p$c {
    public boolean ppj = false;
    public boolean ppk = true;
    public boolean ppl = true;

    public final void toBundle(Bundle bundle) {
        bundle.putBoolean("qqmail_httpoptions_expired", this.ppj);
        bundle.putBoolean("qqmail_httpoptions_needcache", this.ppk);
        bundle.putBoolean("qqmail_httpoptions_needparse", this.ppl);
    }

    public final void fromBundle(Bundle bundle) {
        this.ppj = bundle.getBoolean("qqmail_httpoptions_expired");
        this.ppk = bundle.getBoolean("qqmail_httpoptions_needcache");
        this.ppl = bundle.getBoolean("qqmail_httpoptions_needparse");
    }
}
