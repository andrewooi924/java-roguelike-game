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
    DORMANT, // use this status when the actor cannot move and only do nothing
    HOSTILE_TO_PLAYER, // use this status to be considered hostile towards player (e.g., to attack player)
    CAN_MANAGE_MONEY, // use this to indicate that an actor is able to pick up money
    WALKABLE_FOR_PLAYER, // use this to indicate that an actor is able to enter a floor ground area or lava area.
    CAN_TELEPORT, // whoever uses this can teleport
    RESETTABLE,
    INVULNERABLE, // use this status to be considered unable to be attacked
    HAS_KEY, // use this status to indicate that the actor has obtained the key
    IS_TOAD, // use this status to be considered Toad
    IS_PEACH, // use this status to be considered Princess Peach
    FIRE_BREATHER, // use this status to be considered to be able to breathe fire (drop fire on the ground)
    CAN_FLY, CAN_INTRINSIC_ATTACK, // use this status to be considered an actor that has the ability to fly (walk to higher grounds)
    COMPLETED, // use this status to be considered to have completed the game (defeated Bowser and spoke to Peach)
}
