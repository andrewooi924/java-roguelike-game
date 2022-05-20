package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.*;

public class ChaseBehaviour implements Behaviour {


   private final Actor target;
   HashMap<Location, Double> notVisited= new HashMap<>();

   private void setUnvisitedToExplorable(Location location, Location source, Actor actor) {
      notVisited.put(location, squaredDistance(location, source));
      for (Exit exit: location.getExits()) {
         Location destination = exit.getDestination();
         if (!notVisited.containsKey(destination) && location.canActorEnter(actor)) {
            setUnvisitedToExplorable(destination, source, actor);
         }
      }
   }
   private double squaredDistance(Location a, Location b) {
      double p = (double)b.x() - (double)a.x();
      double q = (double)b.y() - (double)a.y();
      return p*p + q*q;
   }


   /**
    * Constructor.
    *
    * @param subject the Actor to follow
    */
   public ChaseBehaviour(Actor subject) {
      this.target = subject;
   }

   private Location popNearest() {
      Location least = null;
      Double leastDist = null;
      for (Map.Entry<Location, Double> set: this.notVisited.entrySet()) {
         if (least == null || leastDist < set.getValue()) {
            least = set.getKey();
            leastDist = set.getValue();
         }
      }
      this.notVisited.remove(least);
      return least;
   }

   @Override
   public Action getAction(Actor actor, GameMap map) {
      if(!map.contains(target) || !map.contains(actor))
         return null;

      Location here = map.locationOf(actor);
      Location there = map.locationOf(target);
      this.notVisited.clear();
      setUnvisitedToExplorable(here, here, actor);

      ArrayList<Location> visited = new ArrayList<Location>();
      ArrayList<Location> unvisited = new ArrayList<Location>();

      visited.add(here);
      Exit intendedExit = null;
      for (Exit exit: here.getExits()) {
         while (!notVisited.isEmpty()) {
            Location v = this.popNearest();
            if (v.containsAnActor() && v.getActor() == this.target) {
               intendedExit = exit;
               break;
            }
            else {

            }
         }
         if (intendedExit != null) {
            break;
         }
      }
      //return new MoveActorAction(intendedExit.getDestination(), intendedExit.getName());
      return null;
   }
}