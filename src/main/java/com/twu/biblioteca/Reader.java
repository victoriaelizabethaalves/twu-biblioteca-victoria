package com.twu.biblioteca;

import java.util.Scanner;

public class Reader {
    public int nextInt() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator());

        int scannerValue = scanner.nextInt();

        return scannerValue;
    }
}
