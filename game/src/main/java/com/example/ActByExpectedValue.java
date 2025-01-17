// 相手が残り１艦になった時に、（相手の位置を完全に特定するまで）期待値をもとに行動を決定する
// その時の戦略
import java.util.ArrayList;

public class ActByExpectedValue {
    private static double STANDARDVALUE = 99999;
    // 全期待値を調べる
    public static void ActByExpected() {
        ArrayList<Data> valueList = new ArrayList<>();  // listをローカル変数で定義
        int count = 0;
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (stageA.get(i).get(j) >= STANDARDVALUE) {  // 基準値以上の期待値があるか調査
                    valueList.add(new Data(i, j, stageA.get(i).get(j)));
                    count++;
                }
            }
        }
        if (count > 0) {  // 基準値以上の期待値のうち、最大を調査
            double maxValue = valueList.get(0).getValue();
            int num = 0;
            for (int i = 0; i < valueList.size(); i++) {
                if (maxValue < valueList.get(i).getValue()) {
                    maxValue = valueList.get(i).getValue();
                    num = i;
                }
            }
        } else {  // 基準値以上の期待値無し
            for (int i = 1; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (stageB.get(i).get(j) >= STANDARDVALUE) {  // すべての期待値をlistに格納
                        valueList.add(new Data(i, j, stageB.get(i).get(j)));
                    }
                }
            }
            if (valueList.get(0).getValue() > 0) {           //  とりあえず、0より大きい期待値なにか一つをminValueに代入
                double minValue = valueList.get(0).getValue();
            } else {
                for (in i = 1; i < valueList.size(); i++) {
                    if (valueList.get(i).getValue() > 0) {
                        minValue = valueList.get(i).getValue();
                        break;
                    }
                }
            }
            int num;
            for (int i = 0; i < valueList.size(); i++) {   // 最小の期待値を調査
                if (minValue > valueList.get(i).getValue() && valueList.get(i).getValue() > 0) {
                    minValue = valueList.get(i).getValue();
                    num = i;
                }
            }
            // 最小の期待値（>0）に向かって移動
            moveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee（１ますだけ移動）;
        }
        // 基準値以上の期待値のうち、最大の期待値のますに攻撃可能か調べる
        if (可能) {
            attackkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk;
        } else {  // 攻撃不可
            そのマスの１マスよこに移動（無理ならできるだけ近づく）（２ます移動可）;
        }
    }

    static class Data {
        int x;
        int y;
        double value;
    
        // コンストラクタ
        public Data(int y, int x, double value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }
    }
}