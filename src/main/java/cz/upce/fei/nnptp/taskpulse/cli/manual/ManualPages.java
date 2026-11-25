package cz.upce.fei.nnptp.taskpulse.cli.manual;

public final class ManualPages {

    private ManualPages() {
    }

    public static final ManualPage[] PAGES = {
            new ManualPage(
                    "project list",
                    "Lists all projects.",
                    """
                            NAME
                                project list - Lists all projects.

                            DESCRIPTION
                                Displays existing projects.

                            SYNOPSIS
                                project list

                            EXAMPLES
                                project list

                            SEE ALSO
                                man project
                                man project show
                            """),

            new ManualPage(
                    "project",
                    "Manage projects.",
                    """
                            NAME
                                project - Manage projects.

                            DESCRIPTION
                                Provides commands for creating, viewing,
                                editing and deleting projects.

                            COMMANDS
                                add       Create a project.
                                delete    Delete a project.
                                edit      Edit an existing project.
                                list      List all projects.
                                show      Display project details.

                            SEE ALSO
                                man project add
                                man project delete
                                man project edit
                                man project list
                                man project show
                            """),

            new ManualPage(
                    "project add",
                    "Creates a new project.",
                    """
                            NAME
                                project add - Creates a new project.

                            DESCRIPTION
                                Creates a project with a specified name
                                and an optional description.
                                Displays the ID and name of the created project.

                            SYNOPSIS
                                project add <name> [description]

                            ARGUMENTS
                                <name>
                                    Name of the project. Required.

                                [description]
                                    Description of the project. Optional.

                            EXAMPLES
                                project add Homework
                                project add "Game Engine" "My personal project"

                            SEE ALSO
                                man project
                                man project list
                                man project edit
                            """),

            new ManualPage(
                    "project delete",
                    "Deletes an existing project.",
                    """
                            NAME
                                project delete - Deletes an existing project.

                            DESCRIPTION
                                Deletes the project identified by its ID.

                            SYNOPSIS
                                project delete <project-id>

                            ARGUMENTS
                                <project-id>
                                    Unique identifier (UUID) of the project.
                                    Use 'project list' to obtain the ID.

                            EXAMPLES
                                project delete 550e8400-e29b-41d4-a716-446655440000

                            SEE ALSO
                                man project
                                man project list
                                man project show
                            """),

            new ManualPage(
                    "project edit",
                    "Edits an existing project.",
                    """
                            NAME
                                project edit - Edits an existing project.

                            DESCRIPTION
                                Updates the name and optionally the description
                                of an existing project.

                                If no description is provided, the existing
                                description is preserved.

                            SYNOPSIS
                                project edit <project-id> <name> [description]

                            ARGUMENTS
                                <project-id>
                                    Unique identifier (UUID) of the project.
                                    Use 'project list' to obtain the ID.

                                <name>
                                    New name of the project. Required.

                                [description]
                                    New description of the project. Optional.

                            EXAMPLES
                                project edit 550e8400-e29b-41d4-a716-446655440000 Homework

                                project edit 550e8400-e29b-41d4-a716-446655440000 "Game Engine" "Updated description"

                            SEE ALSO
                                man project
                                man project list
                                man project show
                            """),

            new ManualPage(
                    "project show",
                    "Displays project details.",
                    """
                            NAME
                                project show - Displays project details.

                            DESCRIPTION
                                Displays the ID, name and description
                                of the specified project.

                            SYNOPSIS
                                project show <project-id>

                            ARGUMENTS
                                <project-id>
                                    Unique identifier (UUID) of the project.
                                    Use 'project list' to obtain the ID.

                            EXAMPLES
                                project show 550e8400-e29b-41d4-a716-446655440000

                            SEE ALSO
                                man project
                                man project list
                                man project edit
                            """),

            new ManualPage(
                    "task",
                    "Manage tasks.",
                    """
                            NAME
                                task - Manage tasks.

                            DESCRIPTION
                                Provides commands for creating, viewing,
                                updating and deleting tasks.

                                Tasks belong to projects and support priorities,
                                time estimates, due dates, labels and states.

                            COMMANDS
                                add           Create a task.
                                delete        Delete a task.
                                label         Manage task labels.
                                list          List, filter and sort tasks.
                                show          Display task details.
                                transition    Change task state.
                                update        Update an existing task.

                            SEE ALSO
                                man task add
                                man task delete
                                man task label
                                man task list
                                man task show
                                man task transition
                                man task update
                            """),

            new ManualPage(
                    "task add",
                    "Creates a new task.",
                    """
                            NAME
                                task add - Creates a new task.

                            DESCRIPTION
                                Creates a task within an existing project.
                                Displays the ID and title of the created task.

                                New tasks start in the TODO state.

                            SYNOPSIS
                                task add <project-id> <title> [description]
                                         [--priority <priority>]
                                         [--estimate <minutes|none>]
                                         [--due <YYYY-MM-DD>]

                            ARGUMENTS
                                <project-id>
                                    UUID of an existing project.
                                    Use 'project list' to obtain the ID.

                                <title>
                                    Title of the task. Required.

                                [description]
                                    Description of the task. Optional.

                            OPTIONS
                                --priority <priority>
                                    LOW, MEDIUM, HIGH or CRITICAL.
                                    Default: MEDIUM.

                                --estimate <minutes|none>
                                    Estimated duration in non-negative whole minutes.
                                    Default: none.

                                --due <YYYY-MM-DD>
                                    Due date of the task.
                                    No due date is assigned by default.

                            EXAMPLES
                                task add <project-id> "Write documentation"

                                task add <project-id> "Fix parser" --priority HIGH --estimate 60

                                task add <project-id> "Submit assignment" --due 2026-12-15

                            SEE ALSO
                                man task
                                man task list
                                man task update
                                man project list
                            """),

            new ManualPage(
                    "task delete",
                    "Deletes an existing task.",
                    """
                            NAME
                                task delete - Deletes an existing task.

                            DESCRIPTION
                                Deletes the task identified by its ID.

                            SYNOPSIS
                                task delete <task-id>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.
                                    Use 'task list' to obtain the ID.

                            EXAMPLES
                                task delete <task-id>

                            SEE ALSO
                                man task
                                man task list
                                man task show
                            """),

            new ManualPage(
                    "task show",
                    "Displays task details.",
                    """
                            NAME
                                task show - Displays task details.

                            DESCRIPTION
                                Displays detailed information about a task,
                                including its ID, project, title, description,
                                state, priority, estimate, due date and labels.

                                Also displays the number of worklogs,
                                total recorded time and time variance.

                            SYNOPSIS
                                task show <task-id>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.
                                    Use 'task list' to obtain the ID.

                            EXAMPLES
                                task show <task-id>

                            SEE ALSO
                                man task
                                man task list
                                man task update
                                man worklog list
                            """),

            new ManualPage(
                    "task transition",
                    "Changes the state of a task.",
                    """
                            NAME
                                task transition - Changes task state.

                            DESCRIPTION
                                Transitions an existing task to a different state.
                                Only predefined state transitions are permitted.

                            SYNOPSIS
                                task transition <task-id> <state>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.

                                <state>
                                    TODO, IN_PROGRESS, BLOCKED or DONE.

                            ALLOWED TRANSITIONS
                                TODO         -> IN_PROGRESS
                                IN_PROGRESS  -> BLOCKED
                                IN_PROGRESS  -> DONE
                                BLOCKED      -> IN_PROGRESS
                                DONE         -> TODO

                                Completing a task requires at least one worklog.
                                Transitioning to the current state is not allowed.

                            EXAMPLES
                                task transition <task-id> IN_PROGRESS
                                task transition <task-id> BLOCKED
                                task transition <task-id> DONE

                            SEE ALSO
                                man task
                                man task show
                                man worklog log
                            """),

            new ManualPage(
                    "task update",
                    "Updates an existing task.",
                    """
                            NAME
                                task update - Updates an existing task.

                            DESCRIPTION
                                Updates selected properties of an existing task.
                                Properties not specified remain unchanged.

                            SYNOPSIS
                                task update <task-id>
                                            [--title <title>]
                                            [--description <text>]
                                            [--priority <priority>]
                                            [--estimate <minutes|none>]
                                            [--due <YYYY-MM-DD|none>]

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.

                            OPTIONS
                                --title <title>
                                    Set a new task title.

                                --description <text>
                                    Set a new task description.

                                --priority <priority>
                                    Set the task priority.

                                --estimate <minutes|none>
                                    Set the estimated duration in non-negative
                                    whole minutes. Use 'none' to remove the estimate.

                                --due <YYYY-MM-DD|none>
                                    Set a new due date.
                                    Use 'none' to remove the due date.

                            EXAMPLES
                                task update <task-id> --title "New title"
                                task update <task-id> --priority HIGH --estimate 120
                                task update <task-id> --due none
                                task update <task-id> --estimate none

                            SEE ALSO
                                man task
                                man task add
                                man task show
                                man task transition
                            """),

            new ManualPage(
                    "task list",
                    "Lists, filters and sorts tasks.",
                    """
                            NAME
                                task list - Lists, filters and sorts tasks.

                            DESCRIPTION
                                Displays existing tasks.
                                Supports filtering by task properties,
                                deadlines and recorded working time.

                                Multiple filters can be combined.
                                By default, tasks are sorted by title.

                            SYNOPSIS
                                task list [--project <id>]
                                          [--state <state>]
                                          [--priority <priority>]
                                          [--label <label>]
                                          [--search <text>]
                                          [--overdue]
                                          [--exceeded [<minutes>]]
                                          [--sort <order>]
                                          [--from <YYYY-MM-DD>]
                                          [--to <YYYY-MM-DD>]

                            OPTIONS
                                --project <id>
                                    Display tasks belonging to the specified project.

                                --state <state>
                                    Filter tasks by their current state.

                                --priority <priority>
                                    Filter tasks by priority.

                                --label <label>
                                    Filter tasks by label.

                                --search <text>
                                    Search task titles and descriptions.

                                --overdue
                                    Display unfinished tasks with a past due date.

                                --exceeded [<minutes>]
                                    Display tasks whose recorded time exceeds
                                    their estimated duration by more than the
                                    specified number of minutes.
                                    Tasks without an estimate are excluded.

                                --sort <order>
                                    Specify the sorting order.

                                    title
                                        Title in ascending order.

                                    priority
                                        Priority in descending order.

                                    duedate
                                        Due date in ascending order.

                                    priority-duedate
                                        Priority descending, then due date ascending.

                                --from <YYYY-MM-DD>
                                    Include tasks with a due date on or after
                                    the specified date.

                                --to <YYYY-MM-DD>
                                    Include tasks with a due date on or before
                                    the specified date.

                            EXAMPLES
                                task list
                                task list --state TODO
                                task list --priority HIGH --overdue
                                task list --label backend
                                task list --search "database"
                                task list --exceeded 30
                                task list --sort priority-duedate
                                task list --from 2026-12-01 --to 2026-12-31

                            SEE ALSO
                                man task
                                man task show
                                man task label
                                man project list
                            """),

            new ManualPage(
                    "task label",
                    "Manage task labels.",
                    """
                            NAME
                                task label - Manage task labels.

                            DESCRIPTION
                                Provides commands for adding and removing
                                labels associated with tasks.

                                Labels can be used to categorize tasks
                                and filter them using 'task list'.

                            COMMANDS
                                add       Add a label to a task.
                                remove    Remove a label from a task.

                            SEE ALSO
                                man task
                                man task label add
                                man task label remove
                                man task list
                            """),

            new ManualPage(
                    "task label add",
                    "Adds a label to a task.",
                    """
                            NAME
                                task label add - Adds a label to a task.

                            DESCRIPTION
                                Associates a label with an existing task.
                                Labels can be used to categorize and filter tasks.

                            SYNOPSIS
                                task label add <task-id> <label>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.

                                <label>
                                    Label to associate with the task.

                            EXAMPLES
                                task label add <task-id> backend
                                task label add <task-id> documentation
                                task list --label backend

                            SEE ALSO
                                man task label
                                man task label remove
                                man task list
                                man task show
                            """),

            new ManualPage(
                    "task label remove",
                    "Removes a label from a task.",
                    """
                            NAME
                                task label remove - Removes a label from a task.

                            DESCRIPTION
                                Removes the association between a task
                                and the specified label.

                            SYNOPSIS
                                task label remove <task-id> <label>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.

                                <label>
                                    Label to remove from the task.

                            EXAMPLES
                                task label remove <task-id> backend
                                task label remove <task-id> documentation

                            SEE ALSO
                                man task label
                                man task label add
                                man task show
                            """),

            new ManualPage(
                    "worklog",
                    "Track working time.",
                    """
                            NAME
                                worklog - Track working time.

                            DESCRIPTION
                                Provides commands for recording and viewing
                                time spent working on tasks.

                                Recorded time can be compared with task estimates
                                to evaluate the actual duration of work.

                            COMMANDS
                                log       Record working time.
                                list      Display recorded worklogs.

                            SEE ALSO
                                man worklog log
                                man worklog list
                                man task show
                                man task list
                            """),

            new ManualPage(
                    "worklog log",
                    "Records working time.",
                    """
                            NAME
                                worklog log - Records working time.

                            DESCRIPTION
                                Records time spent working on an existing task.
                                Each worklog includes a duration, an author
                                and an optional description.

                            SYNOPSIS
                                worklog log <task-id> <durationMinutes>
                                            --author <author>
                                            [--desc <description>]

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.

                                <durationMinutes>
                                    Duration of work in whole minutes.

                            OPTIONS
                                --author <author>
                                    Author of the worklog. Required.

                                --desc <description>
                                    Optional description of the recorded work.

                            EXAMPLES
                                worklog log <task-id> 60 --author John

                                worklog log <task-id> 90 --author John --desc "Implemented parser"

                            SEE ALSO
                                man worklog
                                man worklog list
                                man task show
                                man task transition
                            """),

            new ManualPage(
                    "worklog list",
                    "Lists recorded worklogs.",
                    """
                            NAME
                                worklog list - Lists recorded worklogs.

                            DESCRIPTION
                                Displays worklogs associated with a specified task.

                            SYNOPSIS
                                worklog list <task-id>

                            ARGUMENTS
                                <task-id>
                                    UUID of an existing task.
                                    Use 'task list' to obtain the ID.

                            EXAMPLES
                                worklog list <task-id>

                            SEE ALSO
                                man worklog
                                man worklog log
                                man task show
                            """),

            new ManualPage(
                    "report",
                    "Generate project reports.",
                    """
                            NAME
                                report - Generate project reports.

                            DESCRIPTION
                                Provides commands for generating reports
                                about existing projects.

                                Reports can be displayed in the console
                                or exported to a file.

                            COMMANDS
                                export    Generate and export a project report.

                            SEE ALSO
                                man report export
                                man project show
                                man task list
                            """),

            new ManualPage(
                    "report export",
                    "Exports a project report.",
                    """
                            NAME
                                report export - Exports a project report.

                            DESCRIPTION
                                Generates a report for an existing project
                                in the specified output format.

                                If no output path is provided, the report
                                is displayed in the console.

                                Existing files are never overwritten.

                            SYNOPSIS
                                report export <project-id>
                                              --format <markdown|json>
                                              [--output <file-path>]

                            ARGUMENTS
                                <project-id>
                                    UUID of an existing project.

                            OPTIONS
                                --format <markdown|json>
                                    Output format of the report. Required.

                                    markdown
                                        Human-readable Markdown document.

                                    json
                                        Structured JSON document.

                                --output <file-path>
                                    Destination file path.
                                    If omitted, prints to the console.

                            EXAMPLES
                                report export <project-id> --format markdown

                                report export <project-id> --format json --output report.json

                                report export <project-id> --format markdown --output report.md

                            SEE ALSO
                                man report
                                man project list
                                man project show
                                man workspace export
                            """),

            new ManualPage(
                    "workspace",
                    "Manage workspace data.",
                    """
                            NAME
                                workspace - Manage workspace data.

                            DESCRIPTION
                                Provides commands for exporting and importing
                                workspace data.

                                Workspace exports can be used to create backups
                                or transfer data between installations.

                            COMMANDS
                                export    Export workspace data.
                                import    Import workspace data.

                            SEE ALSO
                                man workspace export
                                man workspace import
                            """),

            new ManualPage(
                    "workspace export",
                    "Exports workspace data.",
                    """
                            NAME
                                workspace export - Exports workspace data.

                            DESCRIPTION
                                Exports the current workspace into a ZIP archive.

                                The resulting archive can be used as a backup
                                or imported into another workspace.

                            SYNOPSIS
                                workspace export <archive.zip>

                            ARGUMENTS
                                <archive.zip>
                                    Destination path of the ZIP archive.

                            EXAMPLES
                                workspace export backup.zip

                                workspace export "backups/my workspace.zip"

                            SEE ALSO
                                man workspace
                                man workspace import
                            """),

            new ManualPage(
                    "workspace import",
                    "Imports workspace data.",
                    """
                            NAME
                                workspace import - Imports workspace data.

                            DESCRIPTION
                                Imports workspace data from a ZIP archive
                                or a directory containing CSV files.

                                The imported data replaces the current workspace.

                            SYNOPSIS
                                workspace import <archive.zip|csv-directory>

                            ARGUMENTS
                                <archive.zip|csv-directory>
                                    Path to a ZIP archive or a directory
                                    containing workspace CSV files.

                            EXAMPLES
                                workspace import backup.zip

                                workspace import backups/csv

                            WARNING
                                Importing replaces the current workspace.
                                Consider exporting a backup before importing.

                            SEE ALSO
                                man workspace
                                man workspace export
                            """)

    };
}
