import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.*;
import org.gradle.api.tasks.incremental.*;

class LinkTask extends DefaultTask {
    @OutputDirectory
    def File outputDir

    @TaskAction
    void execute(IncrementalTaskInputs input) {
        input.outOfDate { changed ->
            def targetPath = new File(outputDir, changed.file.name).toPath()
            def changePath = changed.file.toPath()
            java.nio.file.Files.deleteIfExists(targetPath)
            try {
                java.nio.file.Files.createSymbolicLink(targetPath, changePath)
            } catch (UnsupportedOperationException | IOException ex) {
                java.nio.file.Files.copy(changePath, targetPath)
            }
        }

        input.removed { changed ->
            def targetFile = new File(outputDir, changed.file.name)
            targetFile.delete()
        }
    }
}
