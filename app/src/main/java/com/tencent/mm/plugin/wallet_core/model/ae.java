package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public final class ae {
    public int sPW = 0;

    public ae(int i) {
        g.Dk();
        g.Dj().CU().set(196660, Integer.valueOf(i));
        this.sPW = i;
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig1 " + i);
    }

    public ae() {
        g.Dk();
        this.sPW = ((Integer) g.Dj().CU().get(196660, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.WalletSwitchConfig", "WalletSwitchConfig2 " + this.sPW);
    }

    public final boolean bLD() {
        boolean z;
        if ((this.sPW & 2) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isMicroPayOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }

    public final boolean bLE() {
        boolean z;
        if ((this.sPW & FileUtils.S_IWUSR) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportScanBankCard, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }

    public final boolean bLF() {
        boolean z;
        if ((this.sPW & 256) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupportTouchPay, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }

    public final boolean bLG() {
        boolean z;
        if ((this.sPW & 2048) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isSupporSwitchWalletCurrency, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }

    public final boolean bLH() {
        boolean z;
        if ((this.sPW & 65536) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }

    public final boolean bLI() {
        boolean z;
        if ((this.sPW & 2097152) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowProtocol, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.sPW)});
        return z;
    }
}
