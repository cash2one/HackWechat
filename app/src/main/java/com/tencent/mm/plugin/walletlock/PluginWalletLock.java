package com.tencent.mm.plugin.walletlock;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.e;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class PluginWalletLock extends f implements c, com.tencent.mm.plugin.walletlock.a.a {
    private com.tencent.mm.plugin.walletlock.b.f tdV = null;

    private class a implements q<asj> {
        final /* synthetic */ PluginWalletLock tdW;

        private a(PluginWalletLock pluginWalletLock) {
            this.tdW = pluginWalletLock;
        }

        public final /* synthetic */ void e(com.tencent.mm.bq.a aVar) {
            x.i("MicroMsg.PluginWalletLock", "alvinluo afterSyncDoCmd");
            ((b) g.h(b.class)).init();
        }

        public final /* bridge */ /* synthetic */ void f(com.tencent.mm.bq.a aVar) {
        }
    }

    public void installed() {
        alias(com.tencent.mm.plugin.walletlock.a.a.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.soter.a.a.class);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        if (gVar.DS()) {
            x.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
            g.a(b.class, new d(new e()));
            s.a(1, new a());
        }
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String name() {
        return "plugin-wallet-lock";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        String value;
        x.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
        this.tdV = new com.tencent.mm.plugin.walletlock.b.f();
        com.tencent.mm.plugin.walletlock.b.f fVar = this.tdV;
        if (!com.tencent.mm.sdk.b.a.xef.d(fVar.thj)) {
            com.tencent.mm.sdk.b.a.xef.b(fVar.thj);
        }
        if (!com.tencent.mm.sdk.b.a.xef.d(fVar.thk)) {
            com.tencent.mm.sdk.b.a.xef.b(fVar.thk);
        }
        if (!com.tencent.mm.sdk.b.a.xef.d(fVar.thm)) {
            com.tencent.mm.sdk.b.a.xef.b(fVar.thm);
        }
        try {
            value = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("PatternLockTimeInterval");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLockInitTask", e, "", new Object[0]);
            value = null;
        }
        if (bh.ov(value)) {
            x.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
            com.tencent.mm.plugin.walletlock.gesture.a.a.tfP = 300;
        } else {
            int i = bh.getInt(value, 0);
            if (i >= 0) {
                x.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
                com.tencent.mm.plugin.walletlock.gesture.a.a.tfP = i;
            } else {
                x.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
                com.tencent.mm.plugin.walletlock.gesture.a.a.tfP = 300;
            }
        }
        ((b) g.h(b.class)).init();
    }

    public void onAccountRelease() {
        x.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
        if (this.tdV != null) {
            com.tencent.mm.plugin.walletlock.b.f fVar = this.tdV;
            if (com.tencent.mm.sdk.b.a.xef.d(fVar.thj)) {
                com.tencent.mm.sdk.b.a.xef.c(fVar.thj);
            }
            if (com.tencent.mm.sdk.b.a.xef.d(fVar.thk)) {
                com.tencent.mm.sdk.b.a.xef.c(fVar.thk);
            }
            if (com.tencent.mm.sdk.b.a.xef.d(fVar.thm)) {
                com.tencent.mm.sdk.b.a.xef.c(fVar.thm);
            }
            i iVar = i.ths;
            if (iVar.thw != null) {
                iVar.thw.clear();
            }
        }
    }
}
