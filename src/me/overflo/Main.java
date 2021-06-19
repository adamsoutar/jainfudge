package me.overflo;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        var inputBytes = Files.readAllBytes(
                Paths.get("./input.bf").toAbsolutePath()
        );
        var rawCode = new String(inputBytes);

        var code = Instructions.FromCode(rawCode);
        var vm = new VM(code);
        vm.Run();
    }
}
