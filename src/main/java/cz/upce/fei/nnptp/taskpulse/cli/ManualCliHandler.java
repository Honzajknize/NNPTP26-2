package cz.upce.fei.nnptp.taskpulse.cli;

import cz.upce.fei.nnptp.taskpulse.cli.manual.ManualPage;
import cz.upce.fei.nnptp.taskpulse.cli.manual.ManualPages;
import java.io.PrintStream;
import java.util.List; 

final class ManualCliHandler implements CliCommandHandler {

private final PrintStream err;
private final PrintStream out;

ManualCliHandler(PrintStream out, PrintStream err){
    this.out = out;
    this.err = err;
}
    
    @Override 
    public void handle(List<String> args)
    {
        if(args.isEmpty()) {
           printHomePage();
            return;
        }

        String command = String.join(" ", args);
        printManualPage(command);

    }

    private void printManualPage(String command) {
    for (ManualPage page: ManualPages.PAGES) {
        if (page.command().equalsIgnoreCase(command)) {
            out.println(page.content());
            return;
        }
    }
    err.println("Manual page not found: " + command); 
    }

    private void printHomePage() {
        out.println("TASKPULSE MANUAL ");
        out.println();
        out.println("Available manual pages:");
        out.println();

        for(ManualPage page: ManualPages.PAGES) {

            if(!page.command().contains(" ")) {
            out.printf("%-25s %s%n",
                page.command(),
                page.description());
            }   
        }

        out.println();
        out.println("Use 'man <command>' to read a manual page.");
    }


    
}
