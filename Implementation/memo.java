class VirtualUI {
    public static void main(String[] args) {
        ICCard[] iccard = new ICCard[10];
        switch( input ) {
            case 1:
                break;
            case 2:
                break;
        }
    }
}


class GateInputBoundary {
    public void icCardTouched(ICCard iccard) {
        GateManager.check(iccard);
    }
    public void ticketInserted(Ticket ticket) {
        GateManager.check(ticket);
    }
}

class GateManager {
    static public void check(ICCard iccard) {
        // calc
        // then
        Gate.open();
        ICPanel.deduct();
        else
        Gate.close();
        Display.warn();
    }
    
    public void check(Ticket ticket) {
        // calc
    }
}

through_gateで要る入力
・ICカードなのか切符なのか
・使う切符orICカード
・入場か出場か
・何駅か



改札が外向き
    もともとある情報:
        ここが何駅か
        hoge駅からいくらか（？）
    入力によってもらえる情報:
        どこから入場したか
        いくら払えるか
    それによって発生する出力:
        バーの開閉
        切符の回収
        ICカードの残額の減算
        通行できない場合のエラー表示
改札が内向き
    もともとある情報:
        ここが何駅か
    入力によってもらえる情報:
        切符の作成日時　（考慮しない
        ICカードの残額
    それによって発生する出力
        バーの開閉
        切符/ICカードに乗車駅を記録
        エラーの場合のひょじ

