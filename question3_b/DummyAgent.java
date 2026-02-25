import java.util.*;

public interface CatanAgent {
    void init(int playerId);
    Move chooseInitialSettlement(GameState state);
    Move chooseInitialRoad(GameState state);
    Move chooseMove(GameState state);
    Map<ResourceType, Integer> chooseDiscard(GameState state,int discardCount);
    ResourceType chooseResource(GameState state);
    int chooseRobberTarget(GameState state, List<Integer> possibleTargets);
    DevelopmentCard chooseDevelopmentCard(GameState state);
}

public class DummyAgent implements CatanAgent {
    private int playerId;
    
    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public Move chooseInitialSettlement(GameState state) {
        // Just pick the first valid option
        return state.getValidSettlements(playerId).get(0);
    }

    @Override
    public Move chooseInitialRoad(GameState state) {
        return state.getValidRoads(playerId).get(0);
    }

    @Override
    public Move chooseMove(GameState state) {
        // Just return any legal move
        List<Move> moves = state.getLegalMoves(playerId);
        return moves.get(0);
    }

    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        // Discard the first resources arbitrarily
        Map<ResourceType, Integer> discard = new HashMap<>();
        for (ResourceType res : state.getPlayerResources(playerId).keySet()) {
            discard.put(res, 1);
            if (discard.size() >= discardCount) break;
        }
        return discard;
    }

    @Override
    public ResourceType chooseResource(GameState state) {
        return ResourceType.WOOD; // arbitrary
    }

    @Override
    public int chooseRobberTarget(GameState state, List<Integer> possibleTargets) {
        return possibleTargets.get(0); // pick first target
    }

    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.KNIGHT; // arbitrary choice
    }
}

