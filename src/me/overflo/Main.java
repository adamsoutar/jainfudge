package me.overflo;

public class Main {

    public static void main(String[] args) throws Exception {
        var rawCode = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        var code = Instructions.FromCode(rawCode);
        var vm = new VM(code);
        vm.Run();
    }
}
