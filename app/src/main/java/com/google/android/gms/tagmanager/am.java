package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

final class am implements b {
    private a bcP;
    private a bcQ;
    private Status bcR;
    private b bcS;
    a bcT;
    boolean bcU;
    private d bcV;

    public final synchronized void bg(String str) {
        if (!this.bcU) {
            this.bcP.qw().bg(str);
        }
    }

    public final Status og() {
        return this.bcR;
    }

    public final synchronized void refresh() {
        if (this.bcU) {
            m.qC();
        }
    }

    public final synchronized void release() {
        if (this.bcU) {
            m.qC();
        } else {
            this.bcU = true;
            this.bcV.bbB.remove(this);
            this.bcP.bbl = null;
            this.bcP = null;
            this.bcQ = null;
            this.bcT = null;
            this.bcS = null;
        }
    }

    final String rf() {
        if (!this.bcU) {
            return this.bcP.bbk;
        }
        m.qC();
        return "";
    }

    final void rg() {
        if (this.bcU) {
            m.qC();
        }
    }
}
