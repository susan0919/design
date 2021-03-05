package com.example.design.flyweightMethod;

import java.util.HashMap;
import java.util.Map;

public class FiveChessmanFactory {
    private static FiveChessmanFactory fiveChessmanFactory = new FiveChessmanFactory();

    private final Map<Character, Chessman> map = new HashMap<Character, Chessman>();

    public static FiveChessmanFactory getInstance() {
        return fiveChessmanFactory;
    }

    public Chessman getChessmanObject(char c) {

        Chessman chessman = map.get(c);
        if (chessman == null) {
            switch (c) {
                case 'B':
                    chessman = new BlackChess();
                    break;
                case 'W':
                    chessman = new WhiteChess();
                    break;
                default:
                    //do nothing
            }
        }
        if (chessman != null) {
            map.put(c, chessman);
        }
        return chessman;
    }
}
