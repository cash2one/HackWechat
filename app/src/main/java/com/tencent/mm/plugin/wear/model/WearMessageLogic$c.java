package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.d;

class WearMessageLogic$c extends d {
    final /* synthetic */ WearMessageLogic tir;

    private WearMessageLogic$c(WearMessageLogic wearMessageLogic) {
        this.tir = wearMessageLogic;
    }

    protected final void execute() {
        if (a.bOt().thH.bOz() != null) {
            a.bOt().thH.bOz().bOB();
        }
    }

    public final String getName() {
        return "RefreshConnectTask";
    }
}
