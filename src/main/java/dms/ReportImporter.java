package dms;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static dms.Attributes.PATIENT;
import static dms.Attributes.BODY;
import static dms.Attributes.TYPE;



public class ReportImporter implements Importer{

    private static final String NAME_PREFIX = "Patient: ";

    @Override
    public Document importFile(File file) throws IOException {
        TextFile textFile = new TextFile(file);
        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLines(2, line -> false, BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "REPORT");
        return new Document(attributes);
    }
}
