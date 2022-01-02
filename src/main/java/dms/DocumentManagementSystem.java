package dms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("jpg", new ImageImporter());
        extensionToImporter.put("report", new ReportImporter());
    }

    void importFile(String path) {

    }

    List<Document> contents() {
        List<Document> documentList = new ArrayList<>();
        return null;
    }
}
