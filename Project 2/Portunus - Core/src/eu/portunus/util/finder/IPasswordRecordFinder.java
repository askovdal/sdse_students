package eu.portunus.util.finder;

import eu.portunus.core.IPasswordLibrary;
import eu.portunus.core.IPasswordRecord;
import java.util.List;

public interface IPasswordRecordFinder {
    public List<IPasswordRecord> findMatchingPasswordRecords(
        String partialString,
        IPasswordLibrary passwordLibrary
    );
}
