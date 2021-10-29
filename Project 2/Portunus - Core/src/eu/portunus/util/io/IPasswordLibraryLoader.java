package eu.portunus.util.io;

import eu.portunus.core.IPasswordLibrary;
import eu.portunus.util.crypter.DecryptionFailedException;
import java.io.File;
import java.io.FileNotFoundException;

public interface IPasswordLibraryLoader {
    public IPasswordLibrary load(
        File file,
        String masterPassword,
        IPasswordLibrary passwordLibrary
    ) throws FileNotFoundException, DecryptionFailedException;
}
