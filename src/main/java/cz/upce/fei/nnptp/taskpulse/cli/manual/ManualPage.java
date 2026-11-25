package cz.upce.fei.nnptp.taskpulse.cli.manual;

public record ManualPage(
    String command,
    String description,
    String content) {
}
