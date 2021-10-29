package eu.portunus.base;

import eu.portunus.core.IPasswordLibrary;
import eu.portunus.util.crypter.DecryptionFailedException;
import java.io.FileNotFoundException;

public class AbstractPortunusWithoutMasterPassword extends AbstractPortunus {

    @Override
    protected boolean loadPasswordLibrary() {
        try {
            setMasterPassword("MyPassword");
            IPasswordLibrary loadedPasswordLibrary = doLoadPasswordLibrary();
            setPasswordLibrary(loadedPasswordLibrary);
        } catch (FileNotFoundException e) {
            //Not a problem. Creating a new file when saving on exit.
        } catch (DecryptionFailedException e) {
            e.printStackTrace();
        }

        return true;
    }
}
