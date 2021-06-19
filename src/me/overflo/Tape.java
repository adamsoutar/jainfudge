package me.overflo;

import java.util.*;

public class Tape {
    List<Integer> cells = new ArrayList();
    int ptr = 0;

    public Tape () {
        cells.add(0);
    }

    public void MoveLeft () {
        ptr--;

        if (ptr == -1) {
            cells.add(0, 0);
            ptr = 0;
        }
    }

    public void MoveRight () {
        ptr++;

        if (ptr == cells.size()) {
            cells.add(0);
        }
    }

    public void Increment () {
        cells.set(ptr, cells.get(ptr) + 1);
    }

    public void Decrement () {
        cells.set(ptr, cells.get(ptr) - 1);
    }

    public int Read () {
        return cells.get(ptr);
    }

    public void Set (int value) {
        cells.set(ptr, value);
    }
}
