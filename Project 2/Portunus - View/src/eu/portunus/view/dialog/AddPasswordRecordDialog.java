package eu.portunus.view.dialog;

import eu.portunus.core.IPasswordRecord;
import eu.portunus.core.IPortunusFactory;
import eu.portunus.view.image.ImageLibrary;
import javafx.scene.image.Image;

public class AddPasswordRecordDialog extends AddEditPasswordRecordDialog {

    public AddPasswordRecordDialog(
        IPasswordRecord passwordRecord,
        IPortunusFactory factory
    ) {
        super(passwordRecord, factory);
    }

    @Override
    protected String createTitle() {
        return "Add Record...";
    }

    @Override
    protected Image createImage() {
        return ImageLibrary.getInstance().getAddPasswordRecordImage();
    }
}
