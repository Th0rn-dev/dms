package dms;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReportImporter implements Importer{

    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        return new Document(attributes);
    }
}
