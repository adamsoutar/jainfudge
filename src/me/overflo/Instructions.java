package me.overflo;

import java.util.*;

public class Instructions {
    static Map<Character, Instruction> map;
    static {
        map = new HashMap();
        map.put('>', Instruction.RIGHT);
        map.put('<', Instruction.LEFT);
        map.put('+', Instruction.INCREMENT);
        map.put('-', Instruction.DECREMENT);
        map.put('.', Instruction.OUTPUT);
        map.put(',', Instruction.INPUT);
        map.put('[', Instruction.LOOP_START);
        map.put(']', Instruction.LOOP_END);
    }

    public static Instruction[] FromCode (String code) throws Exception {
        var out = new ArrayList<Instruction>();

        for (int i = 0; i < code.length(); i++) {
            var ch = code.charAt(i);
            // Ignore non-code characters. They're automatically comments
            if (!map.containsKey(ch)) continue;
            out.add(map.get(ch));
        }

        return out.toArray(new Instruction[0]);
    }
}