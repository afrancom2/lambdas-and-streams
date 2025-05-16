package com.debuggeando_ideas.lambdas;

public class ExampleLambdaSwitchCaseApp {
    public static void main(String[] args) {
        var result = switch("UNO") {
            case "UNO" -> 1;
            case "DOS" -> 2;
            case "TRES" -> 3;
            default -> 4;
        };
        System.out.println(result);
    }
}
