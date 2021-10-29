package eu.portunus.controller.util;

import eu.portunus.core.IPasswordGroup;
import eu.portunus.core.IPasswordRecord;
import eu.portunus.view.contextmenu.PasswordRecordTableViewContextMenu;
import eu.portunus.view.control.PasswordRecordTableView;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class PasswordRecordTableViewContextMenuController {

    private OverviewController parentController;
    private PasswordRecordTableViewContextMenu contextMenu;

    public PasswordRecordTableViewContextMenuController(
        PasswordRecordTableViewContextMenu contextMenu,
        OverviewController parentController
    ) {
        this.contextMenu = contextMenu;
        this.parentController = parentController;
    }

    public void control() {
        initializeControls();
        registerListeners();
        initializeContent();
    }

    protected void initializeControls() {
        PasswordRecordTableView passwordRecordTableView = parentController
            .getView()
            .getPasswordRecordTableView();
        passwordRecordTableView.setContextMenu(contextMenu);
    }

    protected void registerListeners() {
        contextMenu.setOnShowing(
            new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    updateContextMenu();
                }
            }
        );

        contextMenu
            .getCopyUserMenuItem()
            .setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        parentController.copyUserToClipboard();
                    }
                }
            );

        contextMenu
            .getCopyPasswordMenuItem()
            .setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        parentController.copyPasswordToClipboard();
                    }
                }
            );

        contextMenu
            .getAddPasswordRecordMenuItem()
            .setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        parentController.addPasswordRecord();
                    }
                }
            );

        contextMenu
            .getEditPasswordRecordMenuItem()
            .setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        IPasswordRecord selectedPasswordRecord = parentController.getSelectedPasswordRecord();
                        parentController.editPasswordRecord(
                            selectedPasswordRecord
                        );
                    }
                }
            );

        contextMenu
            .getDeletePasswordRecordMenuItem()
            .setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        IPasswordRecord selectedPasswordRecord = parentController.getSelectedPasswordRecord();
                        parentController.deletePasswordRecord(
                            selectedPasswordRecord
                        );
                    }
                }
            );
    }

    protected void initializeContent() {
        updateContextMenu();
    }

    protected void updateContextMenu() {
        IPasswordGroup selectedPasswordGroup = parentController.getSelectedPasswordGroup();
        List<IPasswordRecord> selectedPasswordRecords = parentController.getSelectedPasswordRecords();
        IPasswordRecord selectedPasswordRecord = parentController.getSelectedPasswordRecord();

        boolean copyUserDisabled =
            selectedPasswordRecords.size() != 1 ||
            selectedPasswordRecord.getUser() == null ||
            selectedPasswordRecord.getUser().isEmpty();
        boolean copyPasswordDisabled =
            selectedPasswordRecords.size() != 1 ||
            selectedPasswordRecord.getPassword() == null ||
            selectedPasswordRecord.getPassword().isEmpty();

        boolean addDisabled = selectedPasswordGroup == null;
        boolean editDisabled = selectedPasswordRecords.size() != 1;
        boolean deleteDisabled = selectedPasswordRecords.size() != 1;

        contextMenu.getCopyUserMenuItem().setDisable(copyUserDisabled);
        contextMenu.getCopyPasswordMenuItem().setDisable(copyPasswordDisabled);

        contextMenu.getAddPasswordRecordMenuItem().setDisable(addDisabled);
        contextMenu.getEditPasswordRecordMenuItem().setDisable(editDisabled);
        contextMenu
            .getDeletePasswordRecordMenuItem()
            .setDisable(deleteDisabled);
    }
}
