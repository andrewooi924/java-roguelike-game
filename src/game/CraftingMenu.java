package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CraftingMenu extends Menu {


    /**
     * Display a menu to the user and have them select an option.
     * Ignores more than 26 options. Go on, write a better one.
     *
     * @param actor the Actor representing the player
     * @param actions the Actions that the user can choose from
     * @param display the I/O object that will display the map
     * @return the Action selected by the user
     */
    @Override
    public Action showMenu(Actor actor, ActionList actions, Display display) {
        display.println("You found an easter egg!\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠤⠞⣋⠉⣿⣯⣿⢿⣖⠦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠿⣶⣾⣿⣾⣿⣹⣿⣶⣿⣿⣾⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣧⣰⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⡟⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠟⣠⣿⠟⠋⠉⠀⠈⠀⠀⠀⠀⠘⣿⣧⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⠀⠀⠀⢀⡀⠀⠀⣀⡀⠀⣾⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⡏⠀⢻⣯⡽⢿⡄⠘⢿⡯⠵⢻⣟⡋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠼⣧⠀⠉⠀⠀⠀⠁⠀⠀⠀⠀⢨⣿⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢌⢧⣬⠇⠀⠀⠀⠸⠛⠂⠘⠆⢎⡴⣻⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠉⣿⡆⠀⠀⢾⣯⢿⣗⣀⣼⣹⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠸⡟⠀⠀⠀⠟⢲⣶⠶⣿⠍⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠰⡇⠀⠀⠀⠴⢺⣿⣤⢿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⣿⣿⣿⡆⢧⡀⠀⢀⣀⣼⣿⣟⡇⢿⣷⣶⣤⣄⣀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⣀⣴⣶⣿⣿⣿⣿⣿⣿⣿⣷⠀⠳⣄⠀⠉⢿⣿⣿⠇⠸⣿⣿⣿⣿⣿⣿⣷⣦⣄⡀⠀\n" +
                "⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⠆⠙⢦⣀⣨⠗⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀\n" +
                "⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣠⣤⣀⣉⠀⠀⡀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆\n" +
                "⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢁⣼⠿⢿⣿⣿⣿⠲⠶⠶⠯⢤⣠⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇\n" +
                "⠀⡿⣿⣿⣿⣿⣿⣿⣿⡟⣰⢹⣁⡀⠈⠙⣻⣿⣍⣉⣙⣒⣻⠓⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏\n" +
                "⠀⣷⣾⣿⣿⣿⣿⣿⣿⠁⡇⠀⠉⡀⠙⢿⣿⣿⡧⠤⠤⠭⠭⣌⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n" +
                "⢀⣿⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⣇⣤⣾⣿⣿⣗⠒⠒⠲⣶⠦⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");
        return super.showMenu(actor, actions, display);
    }
}
