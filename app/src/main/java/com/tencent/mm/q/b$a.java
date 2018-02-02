package com.tencent.mm.q;

import com.tencent.mm.modelfriend.b;

class b$a {
    String bgo;
    String fAf;
    String gJo;
    String gJp;
    String gJq;
    String gJr;
    String gJs;
    long id;
    int status;
    int type;
    String userName;

    b$a() {
    }

    b$a(b bVar) {
        this.id = (long) b.kP(bVar.Nr());
        this.gJo = bVar.Nt();
        this.gJp = bVar.Nv();
        this.gJq = bVar.Nu();
        this.bgo = bVar.Nw();
        this.gJr = bVar.Ny();
        this.gJs = bVar.Nx();
        this.userName = bVar.getUsername();
        this.fAf = bVar.Nz();
        this.type = bVar.type;
        this.status = bVar.status;
    }
}
