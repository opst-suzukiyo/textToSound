package com.example.yoshiharusuzuki.texttosound.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SoundSetting {

    private static final char[] CHARSET = "0123456789ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをんゔ 、。ー ！？".toCharArray();
    private static final String[] SOUND_NAME = {"C", "D", "E", "F", "G", "A", "B", "H"};

    private static final Map<Character, String> CHAR_INDEX;

    static {
        // 文字 -> コード値 のインデックスを作成
        Map<Character, String> char_index = new HashMap<>();
        char_index.put(CHARSET[0], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3]); //0
        char_index.put(CHARSET[1], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[4]); //1
        char_index.put(CHARSET[2], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[5]); //2
        char_index.put(CHARSET[3], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[6]); //3
        char_index.put(CHARSET[4], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4]); //4
        char_index.put(CHARSET[5], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[5]); //5
        char_index.put(CHARSET[6], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[6]); //6
        char_index.put(CHARSET[7], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[7]); //7
        char_index.put(CHARSET[8], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5]); //8
        char_index.put(CHARSET[9], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //9

        char_index.put(CHARSET[10], SOUND_NAME[0] + "," + SOUND_NAME[3] + "," + SOUND_NAME[6]); //ぁ
        char_index.put(CHARSET[11], SOUND_NAME[0]);                   //あ
        char_index.put(CHARSET[12], SOUND_NAME[0] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5]); //ぃ
        char_index.put(CHARSET[13], SOUND_NAME[0] + "," + SOUND_NAME[1]);                   //い
        char_index.put(CHARSET[14], SOUND_NAME[0] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //ぅ
        char_index.put(CHARSET[15], SOUND_NAME[0] + "," + SOUND_NAME[2]);                   //う
        char_index.put(CHARSET[16], SOUND_NAME[0] + "," + SOUND_NAME[5] + "," + SOUND_NAME[6]); //ぇ
        char_index.put(CHARSET[17], SOUND_NAME[0] + "," + SOUND_NAME[3]);                   //え
        char_index.put(CHARSET[18], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3]); //ぉ
        char_index.put(CHARSET[19], SOUND_NAME[0] + "," + SOUND_NAME[4]);                   //お

        char_index.put(CHARSET[20], SOUND_NAME[0] + "," + SOUND_NAME[5]); //か
        char_index.put(CHARSET[21], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[4]); //が
        char_index.put(CHARSET[22], SOUND_NAME[0] + "," + SOUND_NAME[6]); //き
        char_index.put(CHARSET[23], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[5]); //ぎ
        char_index.put(CHARSET[24], SOUND_NAME[1]); //く
        char_index.put(CHARSET[25], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[6]); //ぐ
        char_index.put(CHARSET[26], SOUND_NAME[1] + "," + SOUND_NAME[2]); //け
        char_index.put(CHARSET[27], SOUND_NAME[1] + "," + SOUND_NAME[2] + "," + SOUND_NAME[7]); //げ
        char_index.put(CHARSET[28], SOUND_NAME[1] + "," + SOUND_NAME[3]); //こ
        char_index.put(CHARSET[29], SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4]); //ご

        char_index.put(CHARSET[30], SOUND_NAME[1] + "," + SOUND_NAME[4]); //さ
        char_index.put(CHARSET[31], SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[5]); //ざ
        char_index.put(CHARSET[32], SOUND_NAME[1] + "," + SOUND_NAME[5]); //し
        char_index.put(CHARSET[33], SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[6]); //じ
        char_index.put(CHARSET[34], SOUND_NAME[1] + "," + SOUND_NAME[6]); //す
        char_index.put(CHARSET[35], SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[7]); //ず
        char_index.put(CHARSET[36], SOUND_NAME[1] + "," + SOUND_NAME[7]); //せ
        char_index.put(CHARSET[37], SOUND_NAME[1] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5]); //ぜ
        char_index.put(CHARSET[38], SOUND_NAME[2]); //そ
        char_index.put(CHARSET[39], SOUND_NAME[5] + "," + SOUND_NAME[6] + "," + SOUND_NAME[7]); //ぞ

        char_index.put(CHARSET[40], SOUND_NAME[2] + "," + SOUND_NAME[3]); //た
        char_index.put(CHARSET[41], SOUND_NAME[1] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //だ
        char_index.put(CHARSET[42], SOUND_NAME[2] + "," + SOUND_NAME[4]); //ち
        char_index.put(CHARSET[43], SOUND_NAME[1] + "," + SOUND_NAME[4] + "," + SOUND_NAME[7]); //ぢ
        char_index.put(CHARSET[44], SOUND_NAME[1] + "," + SOUND_NAME[5] + "," + SOUND_NAME[6]); //っ
        char_index.put(CHARSET[45], SOUND_NAME[2] + "," + SOUND_NAME[5]); //つ
        char_index.put(CHARSET[46], SOUND_NAME[1] + "," + SOUND_NAME[5] + "," + SOUND_NAME[7]); //づ
        char_index.put(CHARSET[47], SOUND_NAME[2] + "," + SOUND_NAME[6]); //て
        char_index.put(CHARSET[48], SOUND_NAME[1] + "," + SOUND_NAME[6] + "," + SOUND_NAME[6]); //で
        char_index.put(CHARSET[49], SOUND_NAME[2] + "," + SOUND_NAME[7]); //と
        char_index.put(CHARSET[50], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4]); //ど

        char_index.put(CHARSET[51], SOUND_NAME[3]); //な
        char_index.put(CHARSET[52], SOUND_NAME[3] + "," + SOUND_NAME[4]); //に
        char_index.put(CHARSET[53], SOUND_NAME[3] + "," + SOUND_NAME[5]); //ぬ
        char_index.put(CHARSET[54], SOUND_NAME[3] + "," + SOUND_NAME[6]); //ね
        char_index.put(CHARSET[55], SOUND_NAME[3] + "," + SOUND_NAME[7]); //の

        char_index.put(CHARSET[56], SOUND_NAME[4]); //は
        char_index.put(CHARSET[57], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[5]); //ば
        char_index.put(CHARSET[58], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[6]); //ぱ
        char_index.put(CHARSET[59], SOUND_NAME[4] + "," + SOUND_NAME[5]); //ひ
        char_index.put(CHARSET[60], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[7]); //び
        char_index.put(CHARSET[61], SOUND_NAME[2] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5]); //ぴ
        char_index.put(CHARSET[62], SOUND_NAME[4] + "," + SOUND_NAME[6]); //ふ
        char_index.put(CHARSET[63], SOUND_NAME[2] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //ぶ
        char_index.put(CHARSET[64], SOUND_NAME[0] + "," + SOUND_NAME[4] + "," + SOUND_NAME[7]); //ぷ
        char_index.put(CHARSET[65], SOUND_NAME[4] + "," + SOUND_NAME[7]); //へ
        char_index.put(CHARSET[66], SOUND_NAME[2] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //べ
        char_index.put(CHARSET[67], SOUND_NAME[2] + "," + SOUND_NAME[4] + "," + SOUND_NAME[7]); //ぺ
        char_index.put(CHARSET[68], SOUND_NAME[5]); //ほ
        char_index.put(CHARSET[69], SOUND_NAME[2] + "," + SOUND_NAME[6] + "," + SOUND_NAME[7]); //ぼ
        char_index.put(CHARSET[70], SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5]); //ぽ

        char_index.put(CHARSET[71], SOUND_NAME[5] + "," + SOUND_NAME[6]); //ま
        char_index.put(CHARSET[72], SOUND_NAME[5] + "," + SOUND_NAME[7]); //み
        char_index.put(CHARSET[73], SOUND_NAME[6]); //む
        char_index.put(CHARSET[74], SOUND_NAME[6] + "," + SOUND_NAME[7]); //め
        char_index.put(CHARSET[75], SOUND_NAME[7]); //も

        char_index.put(CHARSET[76], SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[6]); //ゃ
        char_index.put(CHARSET[77], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[2]); //や
        char_index.put(CHARSET[78], SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[7]); //ゅ
        char_index.put(CHARSET[79], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[3]); //ゆ
        char_index.put(CHARSET[80], SOUND_NAME[3] + "," + SOUND_NAME[5] + "," + SOUND_NAME[6]); //ょ
        char_index.put(CHARSET[81], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[4]); //よ

        char_index.put(CHARSET[82], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[5]); //ら
        char_index.put(CHARSET[83], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[6]); //り
        char_index.put(CHARSET[84], SOUND_NAME[0] + "," + SOUND_NAME[2] + "," + SOUND_NAME[3]); //る
        char_index.put(CHARSET[85], SOUND_NAME[0] + "," + SOUND_NAME[2] + "," + SOUND_NAME[4]); //れ
        char_index.put(CHARSET[86], SOUND_NAME[0] + "," + SOUND_NAME[2] + "," + SOUND_NAME[5]); //ろ

        char_index.put(CHARSET[87], SOUND_NAME[3] + "," + SOUND_NAME[5] + "," + SOUND_NAME[7]); //ゎ
        char_index.put(CHARSET[88], SOUND_NAME[0] + "," + SOUND_NAME[2] + "," + SOUND_NAME[6]); //わ
        char_index.put(CHARSET[89], SOUND_NAME[3] + "," + SOUND_NAME[6] + "," + SOUND_NAME[7]); //ゐ
        char_index.put(CHARSET[90], SOUND_NAME[4] + "," + SOUND_NAME[5] + "," + SOUND_NAME[6]); //ゑ
        char_index.put(CHARSET[91], SOUND_NAME[0] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4]); //を
        char_index.put(CHARSET[92], SOUND_NAME[0] + "," + SOUND_NAME[3] + "," + SOUND_NAME[5]); //ん
        char_index.put(CHARSET[93], SOUND_NAME[4] + "," + SOUND_NAME[5] + "," + SOUND_NAME[7]); //ゔ

        char_index.put(CHARSET[94], SOUND_NAME[0]); //未使用

        char_index.put(CHARSET[95], SOUND_NAME[2] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[7]); //、
        char_index.put(CHARSET[96], SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5] + "," + SOUND_NAME[6]); //。
        char_index.put(CHARSET[97], SOUND_NAME[3] + "," + SOUND_NAME[4] + "," + SOUND_NAME[5] + "," + SOUND_NAME[7]); //ー
        char_index.put(CHARSET[98], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[4]); //半角スペース
        char_index.put(CHARSET[99], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[5]); //！
        char_index.put(CHARSET[100], SOUND_NAME[0] + "," + SOUND_NAME[1] + "," + SOUND_NAME[3] + "," + SOUND_NAME[6]); //？
        CHAR_INDEX = Collections.unmodifiableMap(char_index);
    }

    //音階を確保
    private static final double FREQ_C = 523.251131;
    private static final double FREQ_D = 587.329536;
    private static final double FREQ_E = 659.255114;
    private static final double FREQ_F = 698.456463;
    private static final double FREQ_G = 783.990872;
    private static final double FREQ_A = 880.000000;
    private static final double FREQ_B = 987.766602;
    private static final double FREQ_H = 1046.502262;

    private static final Map<String, Double> FREQ_MAP;

    static {
        Map<String, Double> freq_map = new HashMap<>();
        freq_map.put("C", FREQ_C);
        freq_map.put("D", FREQ_D);
        freq_map.put("E", FREQ_E);
        freq_map.put("F", FREQ_F);
        freq_map.put("G", FREQ_G);
        freq_map.put("A", FREQ_A);
        freq_map.put("B", FREQ_B);
        freq_map.put("H", FREQ_H);
        FREQ_MAP = Collections.unmodifiableMap(freq_map);
    }

    public static Map<Character, String> getCharIndex() {
        return CHAR_INDEX;
    }

    public static Map<String, Double> getFreqMap() {
        return FREQ_MAP;
    }


}
