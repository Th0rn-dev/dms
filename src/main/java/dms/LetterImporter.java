package dms;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LetterImporter implements Importer{

    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        return new Document(attributes);
    }
}
