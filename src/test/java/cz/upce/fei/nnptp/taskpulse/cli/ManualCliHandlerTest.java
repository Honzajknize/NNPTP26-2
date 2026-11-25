package cz.upce.fei.nnptp.taskpulse.cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualCliHandlerTest {

    private ByteArrayOutputStream out;
    private ByteArrayOutputStream err;
    private ManualCliHandler handler;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        err = new ByteArrayOutputStream();

        handler = new ManualCliHandler(
                new PrintStream(out),
                new PrintStream(err));
    }

    @Test
    void shouldDisplayManualHomePage() {
        handler.handle(List.of());

        assertThat(out.toString())
                .contains("TASKPULSE MANUAL")
                .contains("project")
                .contains("task")
                .contains("worklog")
                .contains("report")
                .contains("workspace");

        assertThat(err.toString()).isEmpty();
    }

    @Test
    void shouldDisplayCommandGroup() {
        handler.handle(List.of("project"));

        assertThat(out.toString())
                .contains("COMMANDS")
                .contains("add")
                .contains("delete")
                .contains("edit")
                .contains("list")
                .contains("show");

        assertThat(err.toString()).isEmpty();
    }

    @Test
    void shouldDisplayNestedManualPage() {
        handler.handle(List.of("task", "label", "add"));

        assertThat(out.toString())
                .contains("task label add")
                .contains("SYNOPSIS")
                .contains("ARGUMENTS");

        assertThat(err.toString()).isEmpty();
    }

    @Test
    void shouldIgnoreCommandCase() {
        handler.handle(List.of("PROJECT", "ADD"));

        assertThat(out.toString())
                .contains("project add")
                .contains("SYNOPSIS");

        assertThat(err.toString()).isEmpty();
    }
}
