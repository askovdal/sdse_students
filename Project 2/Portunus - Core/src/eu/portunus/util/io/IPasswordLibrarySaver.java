package eu.portunus.util.io;

import eu.portunus.core.IPasswordLibrary;
import eu.portunus.util.crypter.EncryptionFailedException;
import java.io.File;

public interface IPasswordLibrarySaver {
    public void save(
        IPasswordLibrary passwordLibrary,
        File file,
        String masterPassword
    ) throws EncryptionFailedException;
}
