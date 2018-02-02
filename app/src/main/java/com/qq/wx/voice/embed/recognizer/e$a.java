package com.qq.wx.voice.embed.recognizer;

class e$a implements Runnable {
    private /* synthetic */ e bgm;

    private e$a(e eVar) {
        this.bgm = eVar;
    }

    public final void run() {
        if (this.bgm.bgt.begin() != 0) {
            this.bgm.bgu.a(-102);
        } else if (this.bgm.bgt.recognize(this.bgm.c, this.bgm.c.length) != 0) {
            this.bgm.bgu.a(-103);
        } else if (this.bgm.bgt.end() != 0) {
            this.bgm.bgu.a(-104);
        } else {
            a aVar = new a();
            if (this.bgm.bgt.getResult(aVar) != 0) {
                this.bgm.bgu.a(-105);
            }
            g gVar = this.bgm.bgu;
            gVar.b.sendMessage(gVar.b.obtainMessage(200, aVar));
        }
    }
}
