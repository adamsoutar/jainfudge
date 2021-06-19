package me.overflo;

public class VM {
    Tape tape = new Tape();
    Instruction[] code;
    int insPtr = 0;

    public VM (Instruction[] code) {
        this.code = code;
    }

    public void Run () throws Exception {
        while (insPtr < code.length) {
            RunInstruction(code[insPtr]);
            insPtr++;
        }
    }

    void RunInstruction (Instruction ins) throws Exception {
        switch (ins) {
            case LEFT:
                tape.MoveLeft();
                break;
            case RIGHT:
                tape.MoveRight();
                break;
            case INCREMENT:
                tape.Increment();
                break;
            case DECREMENT:
                tape.Decrement();
                break;
            case INPUT:
                tape.Set(System.in.read());
                break;
            case OUTPUT:
                System.out.print((char)tape.Read());
                break;
            case LOOP_START:
                RunLoopStart();
                break;
            case LOOP_END:
                RunLoopEnd();
                break;
        }
    }

    void RunLoopStart () throws Exception {
        if (tape.Read() == 0) {
            insPtr = FindMatchingLoopMarker(true);
        }
    }

    void RunLoopEnd () throws Exception {
        if (tape.Read() != 0) {
            insPtr = FindMatchingLoopMarker(false);
        }
    }

    int FindMatchingLoopMarker (boolean cameFromStart) throws Exception {
        Instruction cameFrom = cameFromStart ? Instruction.LOOP_START : Instruction.LOOP_END;
        Instruction lookingFor = cameFromStart ? Instruction.LOOP_END : Instruction.LOOP_START;
        int step = cameFromStart ? 1 : -1;

        int ptr = insPtr;
        int skipCount = 0;
        while (ptr > 0 && ptr < code.length) {
            ptr += step;
            if (code[ptr] == cameFrom) skipCount++;
            if (skipCount > 0 && code[ptr] == lookingFor) skipCount--;
            else if (code[ptr] == lookingFor) return ptr;
        }

        throw new Exception("Unterminated loop");
    }
}
