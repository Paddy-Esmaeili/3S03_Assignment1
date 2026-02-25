import java.util.*;

public class DummyAgent implements CatanAgent {
    private int playerId;
    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }
    @Override
    public Move chooseInitialSettlement(GameState state) {
        return new Move();
    }
    @Override
    public Move chooseInitialRoad(GameState state) {
        return new Move();
    }
    @Override
    public Move chooseMove(GameState state) {
        return new Move();
    }
    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount){
        Map<ResourceType, Integer> discard = new HashMap<>();
        if (discardCount > 0) {
            discard.put(ResourceType.WOOD, discardCount);
        }
        return discard;
    }
    @Override
    public ResourceType chooseResource(GameState state) {
        return ResourceType.WOOD;
    }
    @Override
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        if (possibleTargets == null || possibleTargets.isEmpty()) {
            return -1;
        }
        return possibleTargets.get(0);
    }
    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.KNIGHT;
    }
}

