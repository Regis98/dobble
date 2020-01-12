package pl.dobblepolskab.model.servergamesession.playersmanager.player;

import gamecontent.GameCard;
import gamecontent.GameContent;
import pl.dobblepolskab.model.servergamesession.playersmanager.player.aimodules.AIModule;
import pl.dobblepolskab.model.servergamesession.playersmanager.player.aimodules.PrimitiveAIModule;

public class ComputerPlayer extends Player{
    private AIModule aiModule;

    public ComputerPlayer(String name, String clientId, int intelligenceLevel){
        super(name, clientId);
        aiModule = createAiModule(clientId, intelligenceLevel);
    }

    private AIModule createAiModule(String moduleId, int level){
        switch (level){
            case 1:
                return new PrimitiveAIModule(moduleId);
            default:
                return null;
        }
    }
}
