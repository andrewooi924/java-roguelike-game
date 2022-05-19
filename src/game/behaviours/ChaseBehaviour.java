package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;

public class ChaseBehaviour implements Behaviour {


   private final Actor target;

   /**
    * Constructor.
    *
    * @param subject the Actor to follow
    */
   public ChaseBehaviour(Actor subject) {
      this.target = subject;
   }

   @Override
   public Action getAction(Actor actor, GameMap map) {
      if(!map.contains(target) || !map.contains(actor))
         return null;

      Location here = map.locationOf(actor);
      Location there = map.locationOf(target);

      Exit intendedExit = null;

      ArrayList<Location> visited = new ArrayList<Location>();
      visited.add(here);
      for (Exit exit : here.getExits()) {
         Location destination = exit.getDestination();
         if (destination.canActorEnter(actor)) {
            intendedExit = bfsFollowTarget(destination, visited, exit, actor);
            if (intendedExit != null) {
               return new MoveActorAction(intendedExit.getDestination(), intendedExit.getName());
            }
         }

      }

      return null;
   }

   // Dijkstra is really just BFS with weighted edges. Since in the game map all edges are 1
   // (Technically walls and other higher grounds are 0, but in that case it's just discarded)
   // we can just use BFS.
   private Exit bfsFollowTarget(Location curLocation, ArrayList<Location> visited, Exit initialExit, Actor actor) {
      Exit ret = null;
      visited.add(curLocation);
      for (Exit exit : curLocation.getExits()) {
         Location destination = exit.getDestination();
         if (destination.canActorEnter(actor)) {
            ret = bfsFollowTarget(destination, visited, initialExit, actor);
            if (ret != null) {
               return ret;
            }
         }

      }
      return ret;
   }
}