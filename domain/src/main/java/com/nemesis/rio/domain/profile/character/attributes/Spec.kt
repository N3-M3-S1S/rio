package com.nemesis.rio.domain.profile.character.attributes

enum class Spec(val role: Role) {
    // Death Knight
    BLOOD(Role.TANK), FROST_DEATH_KNIGHT(Role.DAMAGE_DEALER), UNHOLY(Role.DAMAGE_DEALER),

    // Demon Hunter
    HAVOC(Role.DAMAGE_DEALER), VENGEANCE(Role.TANK),

    // Druid
    BALANCE(Role.DAMAGE_DEALER), FERAL(Role.DAMAGE_DEALER), GUARDIAN(Role.TANK), RESTORATION_DRUID(Role.HEALER),

    // Hunter
    BEAST_MASTERY(Role.DAMAGE_DEALER), MARKSMANSHIP(Role.DAMAGE_DEALER), SURVIVAL(Role.DAMAGE_DEALER),

    // Mage
    ARCANE(Role.DAMAGE_DEALER), FIRE(Role.DAMAGE_DEALER), FROST_MAGE(Role.DAMAGE_DEALER),

    // Monk
    BREWMASTER(Role.TANK), MISTWEAVER(Role.HEALER), WINDWALKER(Role.DAMAGE_DEALER),

    // Paladin
    HOLY_PALADIN(Role.HEALER), PROTECTION_PALADIN(Role.TANK), RETRIBUTION(Role.DAMAGE_DEALER),

    // Priest
    DISCIPLINE(Role.HEALER), HOLY_PRIEST(Role.HEALER), SHADOW(Role.DAMAGE_DEALER),

    // Rogue
    ASSASSINATION(Role.DAMAGE_DEALER), OUTLAW(Role.DAMAGE_DEALER), SUBTLETY(Role.DAMAGE_DEALER),

    // Shaman
    ELEMENTAL(Role.DAMAGE_DEALER), ENHANCEMENT(Role.DAMAGE_DEALER), RESTORATION_SHAMAN(Role.HEALER),

    // Warlock
    AFFLICTION(Role.DAMAGE_DEALER), DEMONOLOGY(Role.DAMAGE_DEALER), DESTRUCTION(Role.DAMAGE_DEALER),

    // Warrior
    ARMS(Role.DAMAGE_DEALER), FURY(Role.DAMAGE_DEALER), PROTECTION_WARRIOR(Role.TANK),
}
