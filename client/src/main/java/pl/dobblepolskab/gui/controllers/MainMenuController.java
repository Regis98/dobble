package pl.dobblepolskab.gui.controllers;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pl.dobblepolskab.gui.events.SceneChangedEvent;
import pl.dobblepolskab.gui.others.LayoutConstants;

import java.util.Arrays;
import java.util.List;

public class MainMenuController {
    private static final double LOGO_WIDTH_MULTIPLIER = 0.7;

    @FXML
    private Scene scene;
    @FXML
    private ImageView logo;
    @FXML
    private Button singleplayer;
    @FXML
    private Button multiplayer;
    @FXML
    private Button leaderboards;
    @FXML
    private Button settings;
    @FXML
    private Button exit;

    @FXML
    public void initialize() {
        ReadOnlyDoubleProperty width = scene.widthProperty();
        ReadOnlyDoubleProperty height = scene.heightProperty();

        logo.fitWidthProperty().bind(width.multiply(LOGO_WIDTH_MULTIPLIER));

        List<Button> buttons = Arrays.asList(singleplayer, multiplayer, leaderboards, settings, exit);
        for (Button button : buttons) {
            button.prefWidthProperty().bind(width.multiply(LayoutConstants.BOTTOM_BUTTON_WIDTH_MULTIPLIER));
            button.prefHeightProperty().bind(height.multiply(LayoutConstants.BUTTON_HEIGHT_MULTIPLIER));
        }
    }

    @FXML
    public void startSingleplayer() {
        scene.getRoot().fireEvent(new SceneChangedEvent(SceneChangedEvent.SCENE_CHANGED_EVENT_TYPE, "SingleplayerSettings.fxml"));
    }

    @FXML
    public void startMultiplayer() {
        scene.getRoot().fireEvent(new SceneChangedEvent(SceneChangedEvent.SCENE_CHANGED_EVENT_TYPE, "MultiplayerSettings.fxml"));
    }

    @FXML
    public void showLeaderboards() {
        scene.getRoot().fireEvent(new SceneChangedEvent(SceneChangedEvent.SCENE_CHANGED_EVENT_TYPE, "Leaderboards.fxml"));
    }
}
