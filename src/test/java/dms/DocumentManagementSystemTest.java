package dms;


import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static dms.Attributes.*;


public class DocumentManagementSystemTest {

    private static final String RESOURCES = "build" + File.separator + "resources" + File.separator + "test" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";


    private static final String JOE_BLOGGS = "Joe Bloggs";

    private final DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    void shouldImportFile() throws Exception{
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    @Test
    public void shouldImportLetterAttributes() throws Exception {
        system.importFile(LETTER);
        final Document document = onlyDocument();
        assertAttributeEquals(document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals(document, ADDRESS,
            "123 Fake Street\n" +
                "Westminster\n" +
                "London\n" +
                "United Kingdom");
        assertAttributeEquals(document, BODY,
            "We are writing to you to confirm the re-scheduling of your appointment\n" +
                "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeIs("LETTER", document);
    }


    private void assertAttributeEquals(
        final Document document,
        final String attributeName,
        final String expectedValue
    ) {
        assertEquals(
            "Document has the wrong value for " + attributeName,
            expectedValue,
            document.getAttribute(attributeName)
        );
    }

    private Document onlyDocument() {
        final List<Document> documents = system.contents();
        assertThat(documents, hasSize(1));
        return documents.get(0);
    }

    private void assertTypeIs(final String type, final Document document) {
        assertAttributeEquals(document, TYPE, type);
    }
}
