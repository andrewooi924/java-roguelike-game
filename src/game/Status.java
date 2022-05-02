package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    POWER_STAR,
    CAN_JUMP, // use this status to be considered an actor that has the ability to jump to higher grounds
    DORMANT, // use this status to tell if a Koopa is in dormant state (D)
    HOSTILE_TO_PLAYER, // use this status to be considered hostile towards player (e.g., to attack player)
    CAN_MANAGE_MONEY, // use this to indicate that an actor is able to pick up money
    CAN_WALK_ON_FLOOR, // use this to indicate that an actor is able to enter a floor ground area.
    CAN_KICK, // use this status to indicate that an actor is able to kick.
    CAN_PUNCH, // use this status to indicate that an actor is able to punch.
    RESETTABLE,
}
